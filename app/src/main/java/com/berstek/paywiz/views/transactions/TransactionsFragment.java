package com.berstek.paywiz.views.transactions;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Transaction;
import com.berstek.paywiz.views.payment.PaymentActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionsFragment extends Fragment implements View.OnClickListener {

    private View view;
    private RecyclerView recyclerView;
    private ImageView cashin, cashout, send, receive;

    public TransactionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_transactions, container, false);

        cashin = view.findViewById(R.id.cashin);
        cashout = view.findViewById(R.id.cashout);
        send = view.findViewById(R.id.send);
        receive = view.findViewById(R.id.receive);

        recyclerView = view.findViewById(R.id.recview_transactions);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        cashin.setOnClickListener(this);
        cashout.setOnClickListener(this);
        send.setOnClickListener(this);
        receive.setOnClickListener(this);

        loadTransactions();

        return view;
    }

    private void loadTransactions() {
        //TODO fetch data from database
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction();

        for (int i = 0; i < 20; i++) {
            transactions.add(transaction);
        }

        TransactionsAdapter adapter = new TransactionsAdapter(getContext(), transactions);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        //TODO function for each button
        int id = view.getId();

        if (id == R.id.send) {
            Intent intent = new Intent(getContext(), PaymentActivity.class);
            startActivity(intent);
        } else if (id == R.id.receive) {

        } else if (id == R.id.cashin) {

        } else if (id == R.id.cashout) {

        }
    }
}
