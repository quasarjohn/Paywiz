package com.berstek.paywiz.views.payment.payment_shipment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Transaction;

/**
 * A simple {@link Fragment} subclass.
 */
public class PSPage3 extends Fragment {

    private CourierAndDueDateListener listener;

    public PSPage3() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (CourierAndDueDateListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

    interface CourierAndDueDateListener {
        void onCourierAndDueDateReady(Transaction.Courier courier, long due_date);
    }
}
