package com.gracamachel.trust.repository;

import com.gracamachel.trust.domain.Survey;
import com.gracamachel.trust.domain.SurveySection;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by thembelani on 11/3/17.
 */
public interface SurveySectionRepository extends CrudRepository<SurveySection, Integer> {
    List<SurveySection> findAllBySurvey(Survey survey);
    SurveySection findOne(Integer id);
}
