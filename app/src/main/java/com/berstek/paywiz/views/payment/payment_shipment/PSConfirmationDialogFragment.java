package com.berstek.paywiz.views.payment.payment_shipment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.paywiz.R;
import com.berstek.paywiz.views.parent_layouts.CustomDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PSConfirmationDialogFragment extends CustomDialogFragment {

    private View view;

    public PSConfirmationDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_psconfirmation_dialog, container, false);

        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
