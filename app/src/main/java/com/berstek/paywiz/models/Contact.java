package com.berstek.paywiz.models;


import com.google.firebase.database.Exclude;

/**
 * Created by Jarvis on 23/11/2017.
 */

public class Contact {

    @Exclude
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
