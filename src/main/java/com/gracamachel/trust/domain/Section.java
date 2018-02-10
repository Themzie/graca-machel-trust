package com.gracamachel.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */

@Entity
@Data
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    @JsonIgnore
    private Integer version;
    @Column(unique = true)
    private String name;
    private String description;
    private boolean enabled;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;


}
