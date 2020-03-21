package com.example.apiintegration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("debit")
    @Expose
    private String debit;

    @SerializedName("credit")
    @Expose
    private String credit;

    @SerializedName("transactionthrough")
    @Expose
    private String transactionthrough;

    @SerializedName("reference")
    @Expose
    private String reference;

    @SerializedName("transactiondate")
    @Expose
    private String transactiondate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
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
        return "Data{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", debit='" + debit + '\'' +
                ", credit='" + credit + '\'' +
                ", transactionthrough='" + transactionthrough + '\'' +
                ", reference='" + reference + '\'' +
                ", transactiondate='" + transactiondate + '\'' +
                '}';
    }
}
