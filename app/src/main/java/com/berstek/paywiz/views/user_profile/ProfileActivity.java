package com.berstek.paywiz.views.user_profile;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.Feedback;
import com.berstek.paywiz.models.Transaction;
import com.berstek.paywiz.utils.CustomImageUtils;
import com.berstek.paywiz.views.feedback.FeedbacksAdapter;
import com.berstek.paywiz.views.transactions.TransactionsAdapter;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView dp, dpBlurred, backImg;
    private CustomImageUtils customImageUtils;

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));


        customImageUtils = new CustomImageUtils();

        dp = findViewById(R.id.dp);
        dpBlurred = findViewById(R.id.dp_blurred);
        backImg = findViewById(R.id.back_img);

        BitmapDrawable img = (BitmapDrawable) dpBlurred.getDrawable();
        Bitmap bitmap = img.getBitmap();
        Bitmap blurred = customImageUtils.blurRenderScript(bitmap,
                15, ProfileActivity.this);
        dpBlurred.setImageBitmap(blurred);

        recyclerView = findViewById(R.id.recview_feedbacks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
        backImg.setOnClickListener(this);

        loadFeedbacks();
    }


    private void loadFeedbacks() {
        //TODO fetch data from database
        ArrayList<Feedback> feedbacks = new ArrayList<>();
        Feedback feedback = new Feedback();

        for (int i = 0; i < 10; i++) {
            feedbacks.add(feedback);
        }

        FeedbacksAdapter adapter = new FeedbacksAdapter(this, feedbacks);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        super.onBackPressed();
    }
}
