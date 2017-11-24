package com.berstek.paywiz.views.search;

import com.berstek.paywiz.models.User;

public class SearchContactsAdapter {

    public interface OnContactSelectedListener {
        void onContactSelected(User user);
    }
    private OnContactSelectedListener contactSelectedListener;

    public void setContactSelectedListener(OnContactSelectedListener contactSelectedListener) {
        this.contactSelectedListener = contactSelectedListener;
    }
}
