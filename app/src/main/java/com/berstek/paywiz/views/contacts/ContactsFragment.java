package com.berstek.paywiz.views.contacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Contact;
import com.berstek.paywiz.views.contacts.ContactsAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;

    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contacts, container, false);
        recyclerView = view.findViewById(R.id.contact_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadContacts();
        return view;
    }

    private void loadContacts() {
        //TODO fetch data from database
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact contact = new Contact();

        for (int i = 0; i < 10; i++) {
            contacts.add(contact);
        }

        ContactsAdapter adapter = new ContactsAdapter(getContext(), contacts);
        recyclerView.setAdapter(adapter);
    }

}
