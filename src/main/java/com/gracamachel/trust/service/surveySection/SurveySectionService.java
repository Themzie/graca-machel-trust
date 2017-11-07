package com.gracamachel.trust.service.surveySection;

import com.gracamachel.trust.domain.Survey;
import com.gracamachel.trust.domain.SurveySection;

import java.util.List;

/**
 * Created by thembelani on 11/3/17.
 */
public interface SurveySectionService {
    List<SurveySection> findAllSectionsBySurvey(Survey survey);

    SurveySection findById(Integer surveySectionId);
}
