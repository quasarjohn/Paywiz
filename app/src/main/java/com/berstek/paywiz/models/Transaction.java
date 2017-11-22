package com.berstek.paywiz.models;

public class Transaction {

    private String title, detail;
    private String sender_uid, receiver_uid;
    private String courier, address;
    private TransactionType transaction_type;
    private Status status;
    private long creation_date, expiration_date, accepted_date, shipment_date;
    private double amount, trans_charge, percent_charge;
    private Feedback feedback;

    public enum TransactionType {
        DOOR, PICKUP
    }

    public enum Status {
        AWAITING_ACCEPTANCE, AWAITING_SHIPMENT, COMPLETED
    }
}
