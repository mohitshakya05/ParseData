package com.Test.Parse.Model;

public class Order {
    private String orderId;
    private String amount;
    private String currency;
    private String comment ;
    private String result;

    private String filename;

    public Order(){}
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
