package com.berstek.paywiz.data_access;

import com.berstek.paywiz.models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class UserDA extends DA {

    public Query queryUserByUID(String uid) {
        return rootRef.child("users").orderByKey().equalTo(uid);
    }

    public Query queryUserByPayID(String payID) {
        return rootRef.child("users").orderByChild("pay_id").equalTo(payID);
    }


    public void addUser(String uid, User user) {
        rootRef.child("users").child(uid).setValue(user);
    }
}
