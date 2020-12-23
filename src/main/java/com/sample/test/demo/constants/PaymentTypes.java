package com.sample.test.demo.constants;

public enum PaymentTypes {

    CREDIT_CARD("Credit Card"),
    CASH("Cash on Pickup");

    private String displayName;

    private PaymentTypes(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
