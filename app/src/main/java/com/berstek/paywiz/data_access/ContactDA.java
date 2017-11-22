package com.berstek.paywiz.data_access;

import com.berstek.paywiz.models.Contact;
import com.google.firebase.database.Query;

public class ContactDA extends DA {

    private final String node = "contacts";

    public Query queryuserContactsByUID(String uid) {
        return rootRef.child(node).orderByKey().equalTo(uid);
    }

    public void addContact(String contact_uid, String user_uid) {
        rootRef.child(node).child(user_uid).child(contact_uid).setValue(System.currentTimeMillis());
    }

    public void deleteContact(String contact_uid, String user_uid) {
        rootRef.child(node).child(user_uid).child(contact_uid).setValue(null);
    }
}
