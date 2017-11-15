package com.berstek.paywiz.views.account_setup;


import android.animation.Animator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginSignUpFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button signupBtn;
    private Button loginBtn;

    private ConstraintLayout signupForm, loginForm;

    public interface AccountSetupListener {
        void onLogin(String username, String password);
        void onSignUp(User user);
    }

    private AccountSetupListener accountSetupListener;

    public void setAccountSetupListener(AccountSetupListener accountSetupListener) {
        this.accountSetupListener = accountSetupListener;
    }

    public LoginSignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login_signup, container, false);
        signupBtn = view.findViewById(R.id.signup_btn);
        signupForm = view.findViewById(R.id.form_signup);
        loginForm = view.findViewById(R.id.form_login);
        loginBtn = view.findViewById(R.id.login_btn);

        signupBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup_btn:
                rippleSignUp();
                break;
            case R.id.login_btn:
                rippleLogin();
                break;
            default:
                break;
        }
    }

    private void rippleLogin() {
        signupForm.setVisibility(View.VISIBLE);
        loginForm.setVisibility(View.VISIBLE);
        loginForm.bringToFront();

        int cx = 0;
        int cy = view.getHeight() - 32;
        int rad = Math.max(view.getWidth(), view.getHeight());

        Animator animator = ViewAnimationUtils.createCircularReveal(loginForm, cx, cy, 0, rad);
        animator.setDuration(300);
        animator.start();

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                signupForm.setVisibility(View.GONE);
                getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    private void rippleSignUp() {
        signupForm.setVisibility(View.INVISIBLE);
        signupForm.setVisibility(View.VISIBLE);
        signupForm.bringToFront();

        int cx = view.getWidth();
        int cy = view.getHeight() - 32;
        int rad = Math.max(view.getWidth(), view.getHeight());

        Animator animator = ViewAnimationUtils.createCircularReveal(signupForm, cx, cy, 0, rad);
        animator.setDuration(300);
        animator.start();

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                loginForm.setVisibility(View.GONE);
                getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccentDark));
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

}
