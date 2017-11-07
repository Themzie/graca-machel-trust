package com.gracamachel.trust.domain;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */
@Table(name = "response")
@Data
@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "choice_value")
    private String choiceValue;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    private Date dateCreated;
    @Column(name = "device_id")
    private String deviceId;
    @Column(name = "response_id")
    private String responseId;
    @Version
    private long version;
    @ManyToOne
    @JoinColumn(name = "respondent_id", referencedColumnName = "id")
    private Respondent respondent;
    @ManyToOne
    @JoinColumn(name = "survey_section_question_choice_id", referencedColumnName = "id")
    private SurveySectionQuestionChoice surveySectionQuestionChoice;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
