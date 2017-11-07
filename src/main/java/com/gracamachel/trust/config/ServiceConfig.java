package com.gracamachel.trust.config;

import com.gracamachel.trust.repository.*;
import com.gracamachel.trust.service.response.ResponseService;
import com.gracamachel.trust.service.response.ResponseServiceImpl;
import com.gracamachel.trust.service.survey.SurveyService;
import com.gracamachel.trust.service.survey.SurveyServiceImpl;
import com.gracamachel.trust.service.surveySection.SurveySectionService;
import com.gracamachel.trust.service.surveySection.SurveySectionServiceImpl;
import com.gracamachel.trust.service.surveySectionQuestion.SurveySectionQuestionService;
import com.gracamachel.trust.service.surveySectionQuestion.SurveySectionQuestionServiceImpl;
import com.gracamachel.trust.service.surveySectionQuestionChoice.SurveySectionQuestionChoiceService;
import com.gracamachel.trust.service.surveySectionQuestionChoice.SurveySectionQuestionChoiceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by thembelani on 11/2/17.
 */
@Configuration
@Import(JpaRepositoriesConfig.class)
public class ServiceConfig {

    @Bean
    public ResponseService responseService(ResponseRepository responseRepository){
        return new ResponseServiceImpl(responseRepository);
    }

    @Bean
    public SurveyService surveyService(SurveyRepository surveyRepository){
        return new SurveyServiceImpl(surveyRepository);
    }

    @Bean
    public SurveySectionService surveySectionService(SurveySectionRepository surveySectionRepository){
        return new SurveySectionServiceImpl(surveySectionRepository);
    }

    @Bean
    public SurveySectionQuestionService surveySectionQuestionService(SurveySectionQuestionRepository surveySectionQuestionRepository){
        return new SurveySectionQuestionServiceImpl(surveySectionQuestionRepository);
    }

    @Bean
    public SurveySectionQuestionChoiceService surveySectionQuestionChoiceService(SurveySectionQuestionChoiceRepository surveySectionQuestionChoiceRepository){
        return new SurveySectionQuestionChoiceServiceImpl(surveySectionQuestionChoiceRepository);
    }
}
