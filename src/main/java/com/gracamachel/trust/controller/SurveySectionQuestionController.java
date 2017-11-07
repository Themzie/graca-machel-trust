package com.gracamachel.trust.controller;

import com.gracamachel.trust.domain.SurveySectionQuestion;
import com.gracamachel.trust.service.surveySection.SurveySectionService;
import com.gracamachel.trust.service.surveySectionQuestion.SurveySectionQuestionService;
import com.gracamachel.trust.utils.AppPredicate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * Created by thembelani on 11/3/17.
 */
@Controller
public class SurveySectionQuestionController {

    private SurveySectionService surveySectionService;
    private SurveySectionQuestionService surveySectionQuestionService;

    public SurveySectionQuestionController(SurveySectionService surveySectionService, SurveySectionQuestionService surveySectionQuestionService) {
        this.surveySectionService = surveySectionService;
        this.surveySectionQuestionService = surveySectionQuestionService;
    }

    @ResponseBody
    @RequestMapping(value = "/surveysection/question/{surveySectionId}")
    public List<SurveySectionQuestion> listAllSectionQuestions(@PathVariable("surveySectionId") Integer surveySectionId){
       //return surveySectionQuestionService.findAllQuestionsOfaSection(surveySectionService.findById(surveySectionId));

        return surveySectionQuestionService.findAllQuestionsOfaSection(surveySectionService.findById(surveySectionId)).stream().filter(AppPredicate.distinctByKey(p->p.getQuestion().getTitle())).collect(Collectors.toList());
    }
}
