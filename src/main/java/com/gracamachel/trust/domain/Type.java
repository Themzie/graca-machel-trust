package com.gracamachel.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by thembelani on 11/3/17.
 */

@Entity
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    @JsonIgnore
    private Integer version;
    @Column(unique = true)
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

}
