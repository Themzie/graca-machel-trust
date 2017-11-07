package com.gracamachel.trust.repository;

import com.gracamachel.trust.domain.SurveySectionQuestion;
import com.gracamachel.trust.domain.SurveySectionQuestionChoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by thembelani on 11/4/17.
 */
public interface SurveySectionQuestionChoiceRepository extends CrudRepository<SurveySectionQuestionChoice,Integer> {
    List<SurveySectionQuestionChoice> findAllBySurveySectionQuestion(SurveySectionQuestion surveySectionQuestion);
}
