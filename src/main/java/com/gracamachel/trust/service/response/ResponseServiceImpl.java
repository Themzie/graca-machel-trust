package com.gracamachel.trust.service.response;

import com.gracamachel.trust.domain.Response;
import com.gracamachel.trust.domain.SurveySectionQuestionChoice;
import com.gracamachel.trust.repository.ResponseRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by thembelani on 11/4/17.
 */
public class ResponseServiceImpl implements ResponseService {

    private ResponseRepository responseRepository;

    public ResponseServiceImpl(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public List<Response> findAllBySurveySectionQuestionChoiceAndDateCreated(SurveySectionQuestionChoice surveySectionQuestionChoice, Date dateCreated) {
        return responseRepository.findAllBySurveySectionQuestionChoiceAndDateCreatedLessThanEqual(surveySectionQuestionChoice,dateCreated);
    }
}
