package com.gracamachel.trust.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */

@Entity
@Data
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private long version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="date_created")
    private Date dateCreated;
    private String description;
    private Boolean enabled;
    private String name;


}
