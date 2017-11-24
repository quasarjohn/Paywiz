package com.berstek.paywiz.views.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Contact;

import java.util.ArrayList;

public class SearchContactsAdapter extends RecyclerView.Adapter<SearchContactsAdapter.ListHolder> {

    private Context context;
    private ArrayList<Contact> contacts;
    private LayoutInflater inflater;

    public SearchContactsAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.viewholder_search_contact, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ListHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            contactSelectedListener.onContactSelected(contacts.get(getAdapterPosition()));
        }
    }

    public interface OnContactSelectedListener {
        void onContactSelected(Contact contact);
    }

    private OnContactSelectedListener contactSelectedListener;

    public void setContactSelectedListener(OnContactSelectedListener contactSelectedListener) {
        this.contactSelectedListener = contactSelectedListener;
    }
}
