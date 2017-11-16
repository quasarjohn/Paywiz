package com.berstek.paywiz.views.account_setup;


import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.berstek.paywiz.R;
import com.berstek.paywiz.models.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginSignUpFragment extends Fragment implements View.OnClickListener,
        TextView.OnEditorActionListener {

    private View view;
    private Button signupBtn, loginBtn;
    private ConstraintLayout signupForm, loginForm;
    private EditText username, loginPassword,
            email, signupPassword, signupPasswordConfirm;


    public interface AccountSetupListener {
        void onLogin(String username, String password);

        void onSignUp(User user);
    }

    private AccountSetupListener accountSetupListener;

    public LoginSignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login_signup, container, false);

        //Wire views
        signupBtn = view.findViewById(R.id.signup_btn);
        signupForm = view.findViewById(R.id.form_signup);
        loginForm = view.findViewById(R.id.form_login);
        loginBtn = view.findViewById(R.id.login_btn);
        username = view.findViewById(R.id.login_username);
        loginPassword = view.findViewById(R.id.login_password);
        email = view.findViewById(R.id.signup_email);
        signupPassword = view.findViewById(R.id.signup_password);
        signupPasswordConfirm = view.findViewById(R.id.signup_password_confirm);

        signupBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);

        loginPassword.setOnEditorActionListener(this);
        signupPasswordConfirm.setOnEditorActionListener(this);

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

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {

        if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER
                || actionId == EditorInfo.IME_ACTION_DONE) {

            if (textView.getId() == R.id.login_password)
                accountSetupListener.onLogin(username.getText().toString(), loginPassword.getText().toString());
            else {
                //TODO manual signup
            }

            return true;
        }
        return false;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        accountSetupListener = (AccountSetupListener) context;
    }

    private void rippleLogin() {
        signupForm.setVisibility(View.VISIBLE);
        loginForm.setVisibility(View.VISIBLE);
        loginForm.bringToFront();

        int cx = 0 + (signupBtn.getWidth() / 2);
        int cy = view.getHeight() - ((signupBtn.getHeight() / 2) + 16);
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

        int cx = view.getWidth() - (loginBtn.getWidth() / 2);
        int cy = view.getHeight() - ((loginBtn.getHeight() / 2) + 16);
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
