package com.berstek.paywiz.callbacks;

import com.google.firebase.database.DataSnapshot;

public interface ChildEventCallback {
    void onChildAdded(DataSnapshot dataSnapshot);

    void onChildChanged(DataSnapshot dataSnapshot);
}

