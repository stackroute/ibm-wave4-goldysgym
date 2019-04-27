package com.stackroute.userauthentication.domain;

import lombok.*;
import org.springframework.data.annotation.Id;


import javax.validation.constraints.NotNull;


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
    private User[] user;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User[] getUser() {
        return user;
    }

    public void setUser(User[] user) {
        this.user = user;
    }
}
