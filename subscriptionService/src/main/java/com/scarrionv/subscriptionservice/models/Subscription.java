package com.scarrionv.subscriptionservice.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity with all information of a subscription
 */
@Data
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String email;
    private String firstName;
    private Gender gender;
    private boolean consent;
    private Integer newsletterId;

}
