package com.example.apiintegration;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Insertinfo {

    private String description;

    private Number debit;

    private Number credit;

    private String transactionthrough;

    private String reference;

    private String transactiondate;


    public Insertinfo(String description, Number debit, Number credit, String transactionthrough, String reference, String transactiondate) {
        this.description = description;
        this.debit = debit;
        this.credit = credit;
        this.transactionthrough = transactionthrough;
        this.reference = reference;
        this.transactiondate = transactiondate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Number getDebit() {
        return debit;
    }

    public void setDebit(Number debit) {
        this.debit = debit;
    }

    public Number getCredit() {
        return credit;
    }

    public void setCredit(Number credit) {
        this.credit = credit;
    }

    public String getTransactionthrough() {
        return transactionthrough;
    }

    public void setTransactionthrough(String transactionthrough) {
        this.transactionthrough = transactionthrough;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(String transactiondate) {
        this.transactiondate = transactiondate;
    }

    @Override
    public String toString() {
        return "Insertinfo{" +
                "description='" + description + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", transactionthrough='" + transactionthrough + '\'' +
                ", reference='" + reference + '\'' +
                ", transactiondate='" + transactiondate + '\'' +
                '}';
    }
}
