package com.stackroute.enrollment.domain;

public class Subscription {
    String subscriptionId;
    String subscriptionName;
    String description;
    String imageUrl;
    int duration;
    Double amount;

    public Subscription() {
    }

    public Subscription(String subscriptionId, String subscriptionName, String description, String imageUrl, int duration, Double amount) {
        this.subscriptionId = subscriptionId;
        this.subscriptionName = subscriptionName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.duration = duration;
        this.amount = amount;
    }

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
