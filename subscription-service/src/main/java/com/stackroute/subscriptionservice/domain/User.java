package com.stackroute.subscriptionservice.domain;

import lombok.*;

import java.util.Locale;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class User {

    private String userId;
    private Locale startDate;
}