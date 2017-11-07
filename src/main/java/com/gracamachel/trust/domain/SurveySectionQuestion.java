package com.gracamachel.trust.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */
@Table(name = "survey_section_question")
@Entity
@Data
public class SurveySectionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "choice_data_type")
    private String choiceDataType;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private Boolean enabled;
    @Column(name = "max_number_of_choice_required")
    private Integer maximumNumberOfChoiceRequired;

    @Column(name = "min_number_of_choices_required")
    private Integer minimumOfChoicesRequired;

    @Column(name = "number_of_choices")
    private Integer numberOfChoices;
    @Column(name = "section_position")
    private Integer sectionPosition;
    @Version
    private long version;
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "survey_section_id", referencedColumnName = "id")
    private SurveySection surveySection;
    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;
    @Column(name = "max_number_of_choices_required")
    private Integer maximumNumberOfChoicesRequired;

}