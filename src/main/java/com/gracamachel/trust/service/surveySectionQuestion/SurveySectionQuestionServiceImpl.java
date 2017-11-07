package com.gracamachel.trust.service.surveySectionQuestion;

import com.gracamachel.trust.domain.SurveySection;
import com.gracamachel.trust.domain.SurveySectionQuestion;
import com.gracamachel.trust.repository.SurveySectionQuestionRepository;

import java.util.List;

/**
 * Created by thembelani on 11/3/17.
 */
public class SurveySectionQuestionServiceImpl implements  SurveySectionQuestionService {

    private SurveySectionQuestionRepository surveySectionQuestionRepository;

    public SurveySectionQuestionServiceImpl(SurveySectionQuestionRepository surveySectionQuestionRepository) {
        this.surveySectionQuestionRepository = surveySectionQuestionRepository;
    }

    @Override
    public List<SurveySectionQuestion> findAllQuestionsOfaSection(SurveySection surveySection) {
        return surveySectionQuestionRepository.findAllBySurveySection(surveySection);
    }

    @Override
    public SurveySectionQuestion findById(Integer surveySectionQuestionId) {
        return surveySectionQuestionRepository.findOne(surveySectionQuestionId);
    }
}
