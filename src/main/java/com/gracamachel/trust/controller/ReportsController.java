package com.gracamachel.trust.controller;

import com.googlecode.charts4j.*;
import com.gracamachel.trust.domain.Response;
import com.gracamachel.trust.domain.SurveySectionQuestionChoice;
import com.gracamachel.trust.service.response.ResponseService;
import com.gracamachel.trust.service.survey.SurveyService;
import com.gracamachel.trust.service.surveySection.SurveySectionService;
import com.gracamachel.trust.service.surveySectionQuestion.SurveySectionQuestionService;
import com.gracamachel.trust.service.surveySectionQuestionChoice.SurveySectionQuestionChoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by thembelani on 11/3/17.
 */
@Controller
@Slf4j
public class ReportsController {

    private static final String CUSTOMER_RESPONSE_PAGE ="reports/response_graph";

    private SurveyService surveyService;

    private SurveySectionQuestionChoiceService surveySectionQuestionChoiceService;

    private SurveySectionQuestionService surveySectionQuestionService;

    private ResponseService responseService;

    private SurveySectionService surveySectionService;

    public ReportsController(SurveyService surveyService, SurveySectionQuestionChoiceService surveySectionQuestionChoiceService, SurveySectionQuestionService surveySectionQuestionService, ResponseService responseService, SurveySectionService surveySectionService) {
        this.surveyService = surveyService;
        this.surveySectionQuestionChoiceService = surveySectionQuestionChoiceService;
        this.surveySectionQuestionService = surveySectionQuestionService;
        this.responseService = responseService;
        this.surveySectionService = surveySectionService;
    }

    @RequestMapping(value = "/customer/response/")
    public String displayCustomerResponseReportPage(Model model){
        model.addAttribute("surveys",surveyService.listAllSurveys());
        return CUSTOMER_RESPONSE_PAGE;
    }
    @RequestMapping(value = "/customer/response/", method = RequestMethod.POST)
    public String generateCustomerResponseGraphForSurvey( Model model, @RequestParam("surveys") Integer surveyId , @RequestParam("sections") Integer surveySectionId, @RequestParam("questions") Integer surveySectionQuestionId, @RequestParam("date") String createdDate) throws ParseException {
        log.debug(">>>>>>>>>>>>>>>>>>SURVEY ID {}",surveyId);
        log.debug(">>>>>>>>>>>>>>>>>>SURVEY SECTION ID {}",surveySectionId);
        log.debug(">>>>>>>>>>>>>>>>>> SURVEY SECTION QUESTION ID {}",surveySectionQuestionId);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Date dateCreated = dateFormat.parse(createdDate + " 00:00:00");
        List<SurveySectionQuestionChoice> surveySectionQuestionChoiceList = surveySectionQuestionChoiceService.listAllChoicesForQuestion(surveySectionQuestionService.findById(surveySectionQuestionId));
        // for each choice count responses
        List<Response> responseList = new ArrayList<>();
        surveySectionQuestionChoiceList.stream().forEach(surveySectionQuestionChoice -> {
            log.debug(">>>>>>>>>>>>>>>>>>>>> LOOKING FOR RESPONSES FOR Survey Section Question Choice ID {}", surveySectionQuestionChoice.getId());
            if(!responseService.findAllBySurveySectionQuestionChoiceAndDateCreated(surveySectionQuestionChoice, dateCreated).isEmpty()) {
                responseList.addAll(responseService.findAllBySurveySectionQuestionChoiceAndDateCreated(surveySectionQuestionChoice, dateCreated));
            }
            else{
                log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SURVEY SECTION QUESTION CHOICE ID {} has no RESPONSE YET",surveySectionQuestionChoice.getId());
            }
        });
        log.debug(">>>>>>>>>>>>>>>>> RESPONSES FOR {} AS FOLLOWS {}", dateCreated,responseList);
        model.addAttribute("surveys",surveyService.listAllSurveys());
        if(!responseList.isEmpty()) {
            Map<String, Long> choiceCountMap = responseList.stream().collect(Collectors.groupingBy(Response::getChoiceValue, Collectors.counting()));
            long maxRangeValue = choiceCountMap.entrySet().stream().mapToLong(choiceCountMapEntry -> choiceCountMapEntry.getValue()).max().orElseThrow(NoSuchElementException::new);
            List<BarChartPlot> barChartPlotsList = new ArrayList<>();
            choiceCountMap.entrySet().stream().forEach(choiceCountMapEntry -> {
                BarChartPlot barChartPlot = Plots.newBarChartPlot(Data.newData(choiceCountMapEntry.getValue()*10), Color.RED, choiceCountMapEntry.getKey());
                barChartPlotsList.add(barChartPlot);
            });

            BarChart barChart = GCharts.newBarChart(barChartPlotsList);
            barChart.setTitle("Customer Responses",Color.MAROON,25);
            barChart.setSize(700, 400);
            barChart.setSpaceBetweenGroupsOfBars(10);
            barChart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, maxRangeValue*10));
            barChart.setBarWidth(BarChart.AUTO_RESIZE);
            model.addAttribute("barChartUrl", barChart.toURLString());
            model.addAttribute("survey", surveyService.findById(surveyId));
            model.addAttribute("surveySection",surveySectionService.findById(surveySectionId));
            model.addAttribute("surveySectionQuestion",surveySectionQuestionService.findById(surveySectionQuestionId));
            return CUSTOMER_RESPONSE_PAGE;
        }
        model.addAttribute("info", "There are no responses for the survey Question "+surveySectionQuestionService.findById(surveySectionQuestionId).getQuestion().getTitle()+" for the survey "+surveyService.findById(surveyId).getName()+" Section "+surveySectionService.findById(surveySectionId).getSection().getName());

        return CUSTOMER_RESPONSE_PAGE;
    }
}