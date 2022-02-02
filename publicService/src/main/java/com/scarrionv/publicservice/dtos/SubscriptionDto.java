package com.scarrionv.publicservice.dtos;

import lombok.Data;

@Data
public class SubscriptionDto {
    private String email;
    private String firstName;
    private GenderDto gender;
    private String consent;
    private Integer newsletterId;
}
