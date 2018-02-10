package com.gracamachel.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */
@Entity
@Data
public class SurveySectionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    @JsonIgnore
    private Integer version;
    @ManyToOne(optional=false)
    @JoinColumn(nullable = false)
    private SurveySection surveySection;
    @ManyToOne(optional=false)
    @JoinColumn(nullable = false)
    private Question question;
    @ManyToOne(optional=false)
    @JoinColumn(nullable = false)
    private Type type;
    private int sectionPosition;
    private int numberOfChoices;
    private int minNumberOfChoicesRequired;
    private int maxNumberOfChoiceRequired;
    private String choiceDataType;
    private boolean enabled;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

}