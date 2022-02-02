package com.scarrionv.publicservice.models;

import lombok.Data;

@Data
public class Subscription {
    private String email;
    private String firstName;
    private Gender gender;
    private String consent;
    private Integer newsletterId;
}
