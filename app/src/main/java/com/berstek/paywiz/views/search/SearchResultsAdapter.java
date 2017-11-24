package com.berstek.paywiz.views.search;

import com.berstek.paywiz.models.User;

public class SearchResultsAdapter {

    public interface OnResultSelectedListener {
        void onResultSelected(User user);
    }

    private OnResultSelectedListener resultSelectedListener;

    public void setResultSelectedListener(OnResultSelectedListener resultSelectedListener) {
        this.resultSelectedListener = resultSelectedListener;
    }
}
