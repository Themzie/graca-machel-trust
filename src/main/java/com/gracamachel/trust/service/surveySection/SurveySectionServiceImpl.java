package com.gracamachel.trust.service.surveySection;

import com.gracamachel.trust.domain.Survey;
import com.gracamachel.trust.domain.SurveySection;
import com.gracamachel.trust.repository.SurveySectionRepository;

import java.util.List;

/**
 * Created by thembelani on 11/3/17.
 */
public class SurveySectionServiceImpl implements SurveySectionService {

    private SurveySectionRepository surveySectionRepository;

    public SurveySectionServiceImpl(SurveySectionRepository surveySectionRepository) {
        this.surveySectionRepository = surveySectionRepository;
    }


    @Override
    public List<SurveySection> findAllSectionsBySurvey(Survey survey) {
        return surveySectionRepository.findAllBySurvey(survey);
    }

    @Override
    public SurveySection findById(Integer surveySectionId) {
        return surveySectionRepository.findOne(surveySectionId);
    }
}
