package com.gracamachel.trust.service.response;

import com.gracamachel.trust.domain.Response;
import com.gracamachel.trust.domain.SurveySectionQuestionChoice;

import java.util.Date;
import java.util.List;

/**
 * Created by thembelani on 11/4/17.
 */
public interface ResponseService {
    List<Response> findAllBySurveySectionQuestionChoiceAndDateCreated(SurveySectionQuestionChoice surveySectionQuestionChoice, Date dateCreated);
}
