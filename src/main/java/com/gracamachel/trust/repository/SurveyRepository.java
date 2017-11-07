package com.gracamachel.trust.repository;

import com.gracamachel.trust.domain.Survey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by thembelani on 11/3/17.
 */
public interface SurveyRepository extends CrudRepository<Survey,Integer> {
    List<Survey> findAll();
    Survey findOne(Integer id);
}
