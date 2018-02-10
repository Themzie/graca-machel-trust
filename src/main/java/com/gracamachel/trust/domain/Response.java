package com.gracamachel.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by thembelani on 11/3/17.
 */

@Data
@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    @JsonIgnore
    private Integer version;

    @Column(unique = true)
    private String responseId;
    @ManyToOne(optional=false)
    @JoinColumn(nullable = false)
    private User user;
    private String deviceId;
    @ManyToOne(optional=false)
    @JoinColumn(nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Respondent respondent;
    @ManyToOne(optional=false)
    @JoinColumn(nullable = false)
    private SurveySectionQuestionChoice surveySectionQuestionChoice;
    private String choiceValue;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

}
