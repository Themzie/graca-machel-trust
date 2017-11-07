package com.gracamachel.trust.service.survey;

import com.gracamachel.trust.domain.Survey;
import com.gracamachel.trust.repository.SurveyRepository;

import java.util.List;

/**
 * Created by thembelani on 11/3/17.
 */
public class SurveyServiceImpl implements  SurveyService {

    private SurveyRepository surveyRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public List<Survey> listAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey findById(Integer id) {
        return surveyRepository.findOne(id);
    }
}
