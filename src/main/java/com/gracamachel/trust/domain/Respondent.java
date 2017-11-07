package com.gracamachel.trust.domain;

import com.gracamachel.trust.utils.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */
@Table(name = "respondent")
@Entity
@Data
public class Respondent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Version
    private long version;


    private Integer age;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    private Date dateCreated;
    private String fullname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "national_id")
    private String nationalId;
    @Column(name = "respondent_id", unique = true)
    private String respondentId;



}
