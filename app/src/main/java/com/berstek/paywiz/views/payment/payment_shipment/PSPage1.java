package com.berstek.paywiz.views.payment.payment_shipment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.paywiz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PSPage1 extends Fragment {

    private TitleAndAmountInputListener inputListener;

    public PSPage1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        inputListener = (TitleAndAmountInputListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pspage1, container, false);
    }

    interface TitleAndAmountInputListener {
        void onTitleAndAmountReady(String title, String amount);
    }

}
