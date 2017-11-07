package com.gracamachel.trust.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */
@Table(name = "survey")
@Entity
@Data
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Version
    private long version;

    private String code;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private Boolean enabled;
    @Column(length = 100)
    private String name;
    
}
