package com.stackroute.subscriptionservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subscription {
    @Id
    private String subscriptionId;
    @NotNull
    private String subscriptionName;
    @NotNull
    private String description;
    @NotNull
    private String imageUrl;
    @NotNull
    private int duration;
    @NotNull
    private double amount;
    private ArrayList<User> user;

}
