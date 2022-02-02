package com.scarrionv.subscriptionservice.dtos;

import lombok.Data;

@Data
public class SubscriptionDto {
    private String email;
    private String firstName;
    private GenderDto gender;
    private boolean consent;
    private Integer newsletterId;
}
