package com.berstek.paywiz.views.feedback;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Feedback;

import java.util.ArrayList;

public class FeedbacksAdapter extends RecyclerView.Adapter<FeedbacksAdapter.ListHolder> {

    private Context context;
    private ArrayList<Feedback> feedbacks;
    private LayoutInflater inflater;

    public FeedbacksAdapter(Context context, ArrayList<Feedback> feedbacks) {
        this.context = context;
        this.feedbacks = feedbacks;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.viewholder_feedback, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        //TODO
    }

    @Override
    public int getItemCount() {
        return feedbacks.size();
    }

    class ListHolder extends RecyclerView.ViewHolder {

        public ListHolder(View itemView) {
            super(itemView);
        }
    }
}
