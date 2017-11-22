package com.berstek.paywiz.data_access;

import com.google.firebase.database.Query;

public class BusinessSettingsDA extends DA {

    //determines the charge for each transaction

    private final String node = "business_settings";

    public Query queryBusinessSettings() {
        return rootRef.child(node);
    }
}
