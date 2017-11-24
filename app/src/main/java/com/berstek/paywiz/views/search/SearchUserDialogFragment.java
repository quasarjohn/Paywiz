package com.berstek.paywiz.views.search;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Contact;
import com.berstek.paywiz.models.User;
import com.berstek.paywiz.views.search.SearchResultsAdapter.OnResultSelectedListener;
import com.berstek.paywiz.views.search.SearchContactsAdapter.OnContactSelectedListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchUserDialogFragment extends DialogFragment
        implements OnContactSelectedListener, OnResultSelectedListener, TextWatcher, View.OnClickListener {

    public SearchUserDialogFragment() {
        // Required empty public constructor
    }

    private OnResultSelectedListener resultSelectedListener;
    private OnContactSelectedListener contactSelectedListener;

    private ImageView backImg;
    private EditText searchEdit;
    private RecyclerView recviewContacts, recviewResults;


    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search_user, container, false);
        backImg = view.findViewById(R.id.back_img);
        searchEdit = view.findViewById(R.id.search_edit);
        recviewContacts = view.findViewById(R.id.recview_contacts);
        recviewResults = view.findViewById(R.id.recview_results);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recviewContacts.setLayoutManager(linearLayoutManager);
        recviewResults.setLayoutManager(new LinearLayoutManager(getContext()));

        searchEdit.addTextChangedListener(this);
        backImg.setOnClickListener(this);

        afterTextChanged(null);
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
        ArrayList<Contact> contacts = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            contacts.add(new Contact());
            users.add(new User());
        }

        SearchContactsAdapter searchContactsAdapter = new SearchContactsAdapter(getContext(), contacts);
        recviewContacts.setAdapter(searchContactsAdapter);

        SearchResultsAdapter searchResultsAdapter = new SearchResultsAdapter(getContext(), users);
        recviewResults.setAdapter(searchResultsAdapter);
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
    public void onContactSelected(Contact contact) {
        contactSelectedListener.onContactSelected(contact);
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


    @Override
    public void onClick(View view) {
        this.dismiss();
    }
}
