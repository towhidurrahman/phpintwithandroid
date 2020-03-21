package com.example.apiintegration;

import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AccountsInfo {

    @SerializedName("data")
    @Expose
    private ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Post{" +
                "data=" + data +
                '}';
    }
}
