package com.gracamachel.trust.service.surveySectionQuestionChoice;

import com.gracamachel.trust.domain.SurveySectionQuestion;
import com.gracamachel.trust.domain.SurveySectionQuestionChoice;

import java.util.List;

/**
 * Created by thembelani on 11/4/17.
 */
public interface SurveySectionQuestionChoiceService {
    List<SurveySectionQuestionChoice> listAllChoicesForQuestion(SurveySectionQuestion surveySectionQuestion);
}
