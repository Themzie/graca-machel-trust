package com.gracamachel.trust.service.surveySectionQuestion;

import com.gracamachel.trust.domain.SurveySection;
import com.gracamachel.trust.domain.SurveySectionQuestion;

import java.util.List;

/**
 * Created by thembelani on 11/3/17.
 */
public interface SurveySectionQuestionService {
    List<SurveySectionQuestion> findAllQuestionsOfaSection(SurveySection surveySection);

    SurveySectionQuestion findById(Integer surveySectionQuestionId);
}
