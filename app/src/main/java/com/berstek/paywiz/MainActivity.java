package com.berstek.paywiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.berstek.paywiz.views.account_setup.LoginSignUpFragment;
import com.berstek.paywiz.models.User;

public class MainActivity extends AppCompatActivity implements LoginSignUpFragment.AccountSetupListener {

    private LoginSignUpFragment loginSignUpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        loginSignUpFragment = new LoginSignUpFragment();

        loginSignUpFragment.setAccountSetupListener(this);
        getSupportFragmentManager().beginTransaction().
                replace(R.id.main_container, loginSignUpFragment).commit();


    }

    @Override
    public void onLogin(String username, String password) {
        //TODO log user in
    }

    @Override
    public void onSignUp(User user) {
        //TODO register user
    }
}

