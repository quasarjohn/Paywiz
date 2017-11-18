package com.berstek.paywiz.views.history;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Transaction;
import com.berstek.paywiz.models.User;

import java.util.ArrayList;

/**
 * Created by Berstek on 11/18/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ListHolder> {

    private Context context;
    private ArrayList<Transaction> transactions;
    private LayoutInflater inflater;

    public HistoryAdapter(Context context, ArrayList<Transaction> transactions) {
        this.context = context;
        this.transactions = transactions;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.viewholder_placeholder, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    class ListHolder extends RecyclerView.ViewHolder {

        public ListHolder(View itemView) {
            super(itemView);
        }
    }
}
