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
import com.berstek.paywiz.data_access.DA;
import com.berstek.paywiz.data_access.TransactionDA;
import com.berstek.paywiz.models.Contact;
import com.berstek.paywiz.models.Transaction;
import com.berstek.paywiz.models.User;
import com.berstek.paywiz.utils.UserUtils;
import com.berstek.paywiz.views.payment.PaymentTypeActivity;
import com.berstek.paywiz.views.payment.payment_shipment.PSConfirmationDialogFragment;
import com.berstek.paywiz.views.payment.payment_shipment.PaymentShipmentActivity;
import com.berstek.paywiz.views.search.SearchContactsAdapter;
import com.berstek.paywiz.views.search.SearchResultsAdapter;
import com.berstek.paywiz.views.search.SearchUserDialogFragment;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

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
        final ArrayList<Transaction> transactions = new ArrayList<>();
        final TransactionsAdapter adapter = new TransactionsAdapter(getContext(), transactions);
        recyclerView.setAdapter(adapter);

        TransactionDA transactionDA = new TransactionDA();
        transactionDA.queryTransactionsBySender(UserUtils.getUID()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Transaction transaction = dataSnapshot.getValue(Transaction.class);
                transactions.add(transaction);
                adapter.notifyItemInserted(transactions.size() - 1);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        //TODO function for each button
        int id = view.getId();

        if (id == R.id.send) {
            Intent intent = new Intent(getContext(), PaymentTypeActivity.class);
            startActivity(intent);
        } else if (id == R.id.receive) {
            PSConfirmationDialogFragment fragment = new PSConfirmationDialogFragment();
            fragment.show(getActivity().getFragmentManager(), null);
        } else if (id == R.id.cashin) {

        } else if (id == R.id.cashout) {

        }
    }
}
