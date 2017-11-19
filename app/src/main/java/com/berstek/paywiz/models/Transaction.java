package com.berstek.paywiz.models;

public class Transaction {

    private String title, detail;
    private String seller_uid, buyer_uid;
    private String courier, address;
    private TransactionType transaction_type;
    private long creation_date, expiration_date, shipment_date;
    private double amount, trans_charge, percent_charge;

    public enum TransactionType {
        DOOR, PICKUP
    }

    public enum Status {
        AWAITING_ACCEPTANCE, AWAITING_SHIPMENT, COMPLETED
    }
}
