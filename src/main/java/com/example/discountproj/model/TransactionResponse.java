package com.example.discountproj.model;

import lombok.Getter;

@Getter
public class TransactionResponse {
    private double discountedTotal;

    public TransactionResponse(double discountedTotal) {
        this.discountedTotal = discountedTotal;
    }

    public void setDiscountedTotal(double discountedTotal) {
        this.discountedTotal = discountedTotal;
    }
}
