package com.berstek.paywiz.models;

public class Transaction {

    //required attribs
    private String title, detail;
    private String sender_uid, receiver_uid;
    private long creation_date;
    private double amount;


    //optional attribs for payment for shipment
    private double trans_charge, percent_charge;
    private long expiration_date, accepted_date, shipment_date;
    private String address;
    private ShippingType transaction_type;
    private Status status;
    private Feedback feedback;
    private Courier courier;

    public enum ShippingType {
        DOOR, PICKUP
    }

    public enum Status {
        AWAITING_ACCEPTANCE, AWAITING_SHIPMENT, COMPLETED
    }

    public enum Courier {
        LBC, TWO_GO, JRS, FEDEX
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String getSender_uid() {
        return sender_uid;
    }

    public void setSender_uid(String sender_uid) {
        this.sender_uid = sender_uid;
    }

    public String getReceiver_uid() {
        return receiver_uid;
    }

    public void setReceiver_uid(String receiver_uid) {
        this.receiver_uid = receiver_uid;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ShippingType getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(ShippingType transaction_type) {
        this.transaction_type = transaction_type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(long creation_date) {
        this.creation_date = creation_date;
    }

    public long getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(long expiration_date) {
        this.expiration_date = expiration_date;
    }

    public long getAccepted_date() {
        return accepted_date;
    }

    public void setAccepted_date(long accepted_date) {
        this.accepted_date = accepted_date;
    }

    public long getShipment_date() {
        return shipment_date;
    }

    public void setShipment_date(long shipment_date) {
        this.shipment_date = shipment_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTrans_charge() {
        return trans_charge;
    }

    public void setTrans_charge(double trans_charge) {
        this.trans_charge = trans_charge;
    }

    public double getPercent_charge() {
        return percent_charge;
    }

    public void setPercent_charge(double percent_charge) {
        this.percent_charge = percent_charge;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
