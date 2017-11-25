package com.berstek.paywiz.views.payment.payment_shipment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.paywiz.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PSPage2 extends Fragment {


    public PSPage2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pspage2, container, false);
    }

    interface DetailsAndImageURLListener {
        void onDetailsAndImagesReady(String details, ArrayList<String> imgURLs);
    }

}
