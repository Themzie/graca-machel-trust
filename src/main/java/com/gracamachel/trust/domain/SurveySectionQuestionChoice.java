package com.gracamachel.trust.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */
@Table(name = "survey_section_question_choice")
@Entity
@Data
public class SurveySectionQuestionChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Version
    private long version;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private Boolean enabled;
    @ManyToOne
    @JoinColumn(name = "choice_id", referencedColumnName = "id")
    private Choice choice;
    @ManyToOne
    @JoinColumn(name = "survey_section_question_id", referencedColumnName = "id")
    private SurveySectionQuestion surveySectionQuestion;

}
