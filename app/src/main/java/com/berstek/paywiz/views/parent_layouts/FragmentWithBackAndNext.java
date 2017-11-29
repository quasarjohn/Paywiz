package com.berstek.paywiz.views.parent_layouts;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.berstek.paywiz.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWithBackAndNext extends Fragment implements View.OnClickListener{


    public View view;
    private TextView next;

    public FragmentWithBackAndNext() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        next = view.findViewById(R.id.next_btn);
        next.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
