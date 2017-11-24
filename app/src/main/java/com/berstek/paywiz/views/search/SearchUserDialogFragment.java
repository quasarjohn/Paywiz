package com.berstek.paywiz.views.search;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.User;
import com.berstek.paywiz.views.search.SearchResultsAdapter.OnResultSelectedListener;
import com.berstek.paywiz.views.search.SearchContactsAdapter.OnContactSelectedListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchUserDialogFragment extends DialogFragment
        implements OnContactSelectedListener, OnResultSelectedListener, TextWatcher {

    public SearchUserDialogFragment() {
        // Required empty public constructor
    }

    private OnResultSelectedListener resultSelectedListener;
    private OnContactSelectedListener contactSelectedListener;

    private ImageView backImg;
    private EditText searchEdit;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search_user, container, false);
        backImg = view.findViewById(R.id.back_img);
        searchEdit = view.findViewById(R.id.search_edit);
        searchEdit.addTextChangedListener(this);
        return view;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        //TODO Load data
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Override
    public void onContactSelected(User user) {
        contactSelectedListener.onContactSelected(user);
    }

    @Override
    public void onResultSelected(User user) {
        resultSelectedListener.onResultSelected(user);
    }

    public void setResultSelectedListener(OnResultSelectedListener resultSelectedListener) {
        this.resultSelectedListener = resultSelectedListener;
    }

    public void setContactSelectedListener(OnContactSelectedListener contactSelectedListener) {
        this.contactSelectedListener = contactSelectedListener;
    }


}
