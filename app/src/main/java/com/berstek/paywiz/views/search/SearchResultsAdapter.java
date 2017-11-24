package com.berstek.paywiz.views.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.User;

import java.util.ArrayList;

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.ListHolder> {

    private Context context;
    private ArrayList<User> users;
    private LayoutInflater inflater;

    public SearchResultsAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.viewholder_search_result, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ListHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            resultSelectedListener.onResultSelected(users.get(getAdapterPosition()));
        }
    }

    public interface OnResultSelectedListener {
        void onResultSelected(User user);
    }

    private OnResultSelectedListener resultSelectedListener;

    public void setResultSelectedListener(OnResultSelectedListener resultSelectedListener) {
        this.resultSelectedListener = resultSelectedListener;
    }
}
