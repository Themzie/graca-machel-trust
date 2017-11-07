package com.gracamachel.trust.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */
@Table(name = "survey_section")
@Entity
@Data
public class SurveySection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Version
    private long version;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private Boolean enabled;
    @ManyToOne

    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    private Survey survey;
}
