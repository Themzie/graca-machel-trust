package com.gracamachel.trust.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */
@Entity
@Data
public class SurveySectionQuestionChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    @JsonIgnore
    private Integer version;
    @ManyToOne(optional=false)
    @JoinColumn(nullable = false)
    private SurveySectionQuestion surveySectionQuestion;
    @ManyToOne(optional=false)
    @JoinColumn(nullable = false)
    private Choice choice;
    private boolean enabled;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;


}
