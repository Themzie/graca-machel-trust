package com.gracamachel.trust.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by thembelani on 11/2/17.
 */
@Entity
@Table(name = "choice")
@Data
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Version
    private long version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    private Date dateCreated;

    private Boolean enabled;

    @Column(length = 50)
    private String name;
}
