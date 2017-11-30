package com.berstek.paywiz.views.payment.payment_shipment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Transaction;
import com.berstek.paywiz.views.parent_layouts.FragmentWithBackAndNext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class PSPage2 extends FragmentWithBackAndNext implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener {
    private TextView amount, product_name,
            product_details, lbc_express,
            jrs_express, courier_2go, seekbar_days;
    private RecyclerView recyclerView;

    private ArrayList transactions;
    private Transaction transaction;

    private SeekBar seekBar;

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

        transactions = getArguments().getParcelableArrayList("transactions");
        transaction = (Transaction) transactions.get(0);

        amount = view.findViewById(R.id.amount);
        product_name = view.findViewById(R.id.product_name);
        product_details = view.findViewById(R.id.product_details);

        lbc_express = view.findViewById(R.id.lbc_express);
        jrs_express = view.findViewById(R.id.jrs_express);
        courier_2go = view.findViewById(R.id.courier_2go);

        seekBar = view.findViewById(R.id.seekbar);
        seekbar_days = view.findViewById(R.id.seekbar_days);

        recyclerView = view.findViewById(R.id.recview_images);

        super.onCreateView(inflater, container, savedInstanceState);

        lbc_express.setOnClickListener(this);
        jrs_express.setOnClickListener(this);
        courier_2go.setOnClickListener(this);

        loadTransactionData();

        seekBar.setOnSeekBarChangeListener(this);

        return view;
    }


    private void loadTransactionData() {
        amount.setText(transaction.getAmount() + "");
        product_name.setText(transaction.getTitle());
        product_details.setText(transaction.getDetail());
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        super.onClick(view);

        if (id == R.id.lbc_express) {
            transaction.setCourier(Transaction.Courier.LBC);
        } else if (id == R.id.courier_2go) {
            transaction.setCourier(Transaction.Courier.TWO_GO);
        } else if (id == R.id.jrs_express) {
            transaction.setCourier(Transaction.Courier.JRS);
        } else if (id == R.id.next_btn) {

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        long date = transaction.getCreation_date();

        date = date + (i * (24 * 60 * 60 * 1000));

        Date due_date = new Date(date);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd");

        seekbar_days.setText(df.format(due_date));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
