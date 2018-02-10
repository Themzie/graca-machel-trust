package com.gracamachel.trust.domain;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by thembelani on 11/2/17.
 */
@Entity
@Data
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer version;
    @Column(unique = true)
    private String name;
    private boolean enabled;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
}
