package com.gracamachel.trust.repository;

import com.gracamachel.trust.domain.Response;
import com.gracamachel.trust.domain.SurveySectionQuestionChoice;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by thembelani on 11/4/17.
 */
public interface ResponseRepository extends CrudRepository<Response,Integer> {
    List<Response> findAllBySurveySectionQuestionChoiceAndDateCreatedLessThanEqual(SurveySectionQuestionChoice surveySectionQuestionChoice, Date dateCreated);
}
