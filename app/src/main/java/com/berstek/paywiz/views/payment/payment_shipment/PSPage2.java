package com.berstek.paywiz.views.payment.payment_shipment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.berstek.paywiz.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PSPage2 extends Fragment {
    private View view;
    private TextView amount, balance, product_name,
            product_details, warranty_1, warranty_2,
            warranty_3, warranty_4, warranty_5, warranty_6,
            warranty_7, meetup, shipping, lbc_express,
            jrs_express, courier_2go;
    private ImageView product_image;
    private Button proceed_button;

    public PSPage2() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pspage2, container, false);
        // Inflate the layout for this fragment

        amount = view.findViewById(R.id.amount);
        amount.setText("5,000");
        balance = view.findViewById(R.id.available_balance_value);
        product_name = view.findViewById(R.id.product_name);
        product_name.setText("Iphone X");
        product_details = view.findViewById(R.id.product_details);
        warranty_1 = view.findViewById(R.id.warranty_1);
        warranty_2 = view.findViewById(R.id.warranty_2);
        warranty_3 = view.findViewById(R.id.warranty_3);
        warranty_4 = view.findViewById(R.id.warranty_4);
        warranty_5 = view.findViewById(R.id.warranty_5);
        warranty_6 = view.findViewById(R.id.warranty_6);
        warranty_7 = view.findViewById(R.id.warranty_7);
        meetup = view.findViewById(R.id.meet_up);
        shipping = view.findViewById(R.id.Shipping);
        lbc_express = view.findViewById(R.id.lbc_express);
        jrs_express = view.findViewById(R.id.jrs_express);
        courier_2go = view.findViewById(R.id.courier_2go);
        product_image = view.findViewById(R.id.product_image);
        proceed_button = view.findViewById(R.id.proceed_button);
        return view;
    }

}
