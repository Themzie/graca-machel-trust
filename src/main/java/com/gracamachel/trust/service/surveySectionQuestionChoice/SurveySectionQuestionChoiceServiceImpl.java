package com.gracamachel.trust.service.surveySectionQuestionChoice;

import com.gracamachel.trust.domain.SurveySectionQuestion;
import com.gracamachel.trust.domain.SurveySectionQuestionChoice;
import com.gracamachel.trust.repository.SurveySectionQuestionChoiceRepository;

import java.util.List;

/**
 * Created by thembelani on 11/4/17.
 */
public class SurveySectionQuestionChoiceServiceImpl implements  SurveySectionQuestionChoiceService {

    private SurveySectionQuestionChoiceRepository surveySectionQuestionChoiceRepository;

    public SurveySectionQuestionChoiceServiceImpl(SurveySectionQuestionChoiceRepository surveySectionQuestionChoiceRepository) {
        this.surveySectionQuestionChoiceRepository = surveySectionQuestionChoiceRepository;
    }

    @Override
    public List<SurveySectionQuestionChoice> listAllChoicesForQuestion(SurveySectionQuestion surveySectionQuestion) {
        return surveySectionQuestionChoiceRepository.findAllBySurveySectionQuestion(surveySectionQuestion);
    }
}
