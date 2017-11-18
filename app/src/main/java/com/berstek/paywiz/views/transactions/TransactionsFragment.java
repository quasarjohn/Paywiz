package com.berstek.paywiz.views.transactions;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Transaction;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionsFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;

    public TransactionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_transactions, container, false);
        recyclerView = view.findViewById(R.id.recview_transactions);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //TODO fetch data from database

        ArrayList<Transaction> transactions = new ArrayList<>();

        Transaction transaction = new Transaction();

        for (int i = 0; i < 20; i++) {
            transactions.add(transaction);
        }

        TransactionsAdapter adapter = new TransactionsAdapter(getContext(), transactions);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
