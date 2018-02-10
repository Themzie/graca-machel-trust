package com.gracamachel.trust.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by thembelani on 11/3/17.
 */
@Entity
@Data
public class Respondent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private Integer version;
    private String respondentId;
    private Integer age;
    private String gender;
    private String fullname;
    private String nationalId;
    private String country;

}
