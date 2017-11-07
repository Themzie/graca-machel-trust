package com.gracamachel.trust.repository;

import com.gracamachel.trust.domain.SurveySection;
import com.gracamachel.trust.domain.SurveySectionQuestion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by thembelani on 11/3/17.
 */
public interface SurveySectionQuestionRepository extends CrudRepository<SurveySectionQuestion,Integer> {
    List<SurveySectionQuestion> findAllBySurveySection(SurveySection surveySection);
    SurveySectionQuestion findOne(Integer id);
}
