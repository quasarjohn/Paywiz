package com.berstek.paywiz.views.transactions;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.berstek.paywiz.MainActivity;
import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Transaction;
import com.berstek.paywiz.views.home.HomeActivity;
import com.berstek.paywiz.views.user_profile.ProfileActivity;

import java.util.ArrayList;


public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.ListHolder> {

    private Context context;
    private ArrayList<Transaction> transactions;
    private LayoutInflater inflater;

    public TransactionsAdapter(Context context, ArrayList<Transaction> transactions) {
        this.context = context;
        this.transactions = transactions;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.viewholder_transaction, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        //TODO
        holder.product_name.setText("Apple Iphone X");
        holder.date_shipped.setText("November 1, 2017");
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    class ListHolder extends RecyclerView.ViewHolder {
        private ImageView dp;
        private TextView product_name,product_quality,name,identity,likes,dislikes,price,courier,transaction_date,
        date_shipped;
        private View.OnClickListener clickListener;
        public ListHolder(View itemView) {
            super(itemView);
            dp = itemView.findViewById(R.id.profile_image);
            product_name = itemView.findViewById(R.id.product_name_textview);
            product_quality  = itemView.findViewById(R.id.product_quality_textview);
            name  = itemView.findViewById(R.id.name_textview);
            identity = itemView.findViewById(R.id.identity_textview);
            likes  = itemView.findViewById(R.id.like_value);
            dislikes  = itemView.findViewById(R.id.dislike_value);
            price  = itemView.findViewById(R.id.price_textview);
            courier  = itemView.findViewById(R.id.courier_value);
            transaction_date  = itemView.findViewById(R.id.transaction_date_value);
            date_shipped  = itemView.findViewById(R.id.shipped_date_value);

            dp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ProfileActivity.class);
                    context.startActivity(intent);
                }
            });


        }



    }
}
