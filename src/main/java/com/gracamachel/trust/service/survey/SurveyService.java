package com.gracamachel.trust.service.survey;

import com.gracamachel.trust.domain.Survey;

import java.util.List;

/**
 * Created by thembelani on 11/3/17.
 */
public interface SurveyService {
    List<Survey> listAllSurveys();
    Survey findById(Integer id);
}
