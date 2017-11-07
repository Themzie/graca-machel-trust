package com.gracamachel.trust.controller;

import com.gracamachel.trust.domain.SurveySection;
import com.gracamachel.trust.service.survey.SurveyService;
import com.gracamachel.trust.service.surveySection.SurveySectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by thembelani on 11/3/17.
 */
@Controller
public class SurveySectionController {


    private SurveySectionService surveySectionService;
    private SurveyService surveyService;

    public SurveySectionController(SurveySectionService surveySectionService, SurveyService surveyService) {
        this.surveySectionService = surveySectionService;
        this.surveyService = surveyService;
    }

    @ResponseBody
    @RequestMapping(value = "/section/survey/{surveyId}", method = RequestMethod.GET)
    public List<SurveySection> listAllSectionOfaSurvey(@PathVariable("surveyId") Integer surveyId) {
        return surveySectionService.findAllSectionsBySurvey(surveyService.findById(surveyId));
    }
}
