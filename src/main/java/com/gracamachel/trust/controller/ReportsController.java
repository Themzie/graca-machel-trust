package com.gracamachel.trust.controller;

import com.googlecode.charts4j.*;
import com.gracamachel.trust.domain.Response;
import com.gracamachel.trust.domain.SurveySectionQuestionChoice;
import com.gracamachel.trust.service.response.ResponseService;
import com.gracamachel.trust.service.survey.SurveyService;
import com.gracamachel.trust.service.surveySection.SurveySectionService;
import com.gracamachel.trust.service.surveySectionQuestion.SurveySectionQuestionService;
import com.gracamachel.trust.service.surveySectionQuestionChoice.SurveySectionQuestionChoiceService;
import com.gracamachel.trust.utils.Colours;
import com.gracamachel.trust.utils.RandomNumberGenerator;
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
            long[] totalChoiceCount = new long[1];
            choiceCountMap.entrySet().stream().forEach(choiceCountEntry -> totalChoiceCount[0] =totalChoiceCount[0]+choiceCountEntry.getValue() );
            log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Choice count Map {}",choiceCountMap.toString());

            System.out.println("##################################Total {}"+totalChoiceCount[0]);
            long maxRangeValue = choiceCountMap.entrySet().stream().mapToLong(choiceCountMapEntry -> choiceCountMapEntry.getValue()).max().orElseThrow(NoSuchElementException::new);
            List<BarChartPlot> barChartPlotsList = new ArrayList<>();
            List<Slice> pieChartSliceList = new ArrayList<>();
            choiceCountMap.entrySet().stream().forEach(choiceCountMapEntry -> {
                BarChartPlot barChartPlot = Plots.newBarChartPlot(Data.newData(choiceCountMapEntry.getValue()), Color.RED, choiceCountMapEntry.getKey());
                barChartPlotsList.add(barChartPlot);
                log.info("################################# Total {}",totalChoiceCount[0]);
                log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CHOICE {}  VALUE {}",choiceCountMapEntry.getKey(),choiceCountMapEntry.getValue());
                log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>> % CALC {}",(((double)choiceCountMapEntry.getValue()/totalChoiceCount[0]))*100);
                Slice pieChartSlice = Slice.newSlice(Math.toIntExact(choiceCountMapEntry.getValue()),Colours.all().get(RandomNumberGenerator.generateIntWithSetLimit(Colours.all().size()-1)), choiceCountMapEntry.getKey(),
                        "[ Value :"+choiceCountMapEntry.getValue()+"]    "+String.valueOf(((double)choiceCountMapEntry.getValue()/Math.toIntExact(totalChoiceCount[0]))*100)+"%");
                pieChartSliceList.add(pieChartSlice);

            });


            //bar chart
            BarChart barChart = GCharts.newBarChart(barChartPlotsList);
            barChart.setTitle("Responses : Bar Graph",Color.MAROON,20);
            barChart.setSize(500, 500);
            barChart.setSpaceBetweenGroupsOfBars(10);
            barChart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, maxRangeValue+10));
            barChart.setBarWidth(BarChart.AUTO_RESIZE);

            //pie chart
            PieChart pieChart = GCharts.newPieChart(pieChartSliceList);
            pieChart.setTitle("Responses: Pie Chart",Color.BLUE,20);
            pieChart.setSize(700,400);
            pieChart.setThreeD(true);
            pieChart.setLegendPosition(LegendPosition.BOTTOM_VERTICAL);


            model.addAttribute("pieUrl",pieChart.toURLString());
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