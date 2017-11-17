package com.berstek.paywiz.views.account_setup;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.berstek.paywiz.R;
import com.berstek.paywiz.callbacks.OnUserQueriedListener;
import com.berstek.paywiz.data_access.UserDA;
import com.berstek.paywiz.models.User;
import com.berstek.paywiz.utils.CustomAnimator;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment implements OnUserQueriedListener, View.OnClickListener {

    private View view;
    private ImageView dp, logo;
    private TextView welcome;
    private Button continueBtn;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    private AnimatorSet welcomeAnimation;
    private ConstraintLayout constraintLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_welcome, container, false);
        constraintLayout = (ConstraintLayout) view;
        logo = view.findViewById(R.id.logo);
        continueBtn = view.findViewById(R.id.continue_btn);
        dp = view.findViewById(R.id.dp);
        welcome = view.findViewById(R.id.txt_welcome);
        welcomeAnimation = CustomAnimator.animateAlpha(logo);

        continueBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onUserQueried(User user) {

        Glide.with(getContext()).load(user.getPhoto_url()).skipMemoryCache(true).into(dp);
        welcome.setText("Welcome, " + user.getFirstname() + "!");

        TransitionManager.beginDelayedTransition(constraintLayout);
        ConstraintLayout.LayoutParams lparams = (ConstraintLayout.LayoutParams) logo.getLayoutParams();
        lparams.verticalBias = 0.12f;
        logo.setLayoutParams(lparams);

        dp.setVisibility(View.VISIBLE);
        welcome.setVisibility(View.VISIBLE);
        welcomeAnimation.removeAllListeners();
        welcomeAnimation.end();
        welcomeAnimation.cancel();
        continueBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {

    }
}
