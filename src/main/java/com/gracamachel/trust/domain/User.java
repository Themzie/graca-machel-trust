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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    @JsonIgnore
    private Integer version;
    private String fullname;
    @Column(unique = true)
    private String username;
    private String pincode;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
}
