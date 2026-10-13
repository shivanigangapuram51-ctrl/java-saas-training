package com.saas.training.model;

public class Subscription {
    private Long id;
    private String planName;
    private double amount;
    private String status;

    public Subscription() {
    }

    public Subscription(Long id, String planName,
                        double amount, String status) {
        this.id = id;
        this.planName = planName;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

