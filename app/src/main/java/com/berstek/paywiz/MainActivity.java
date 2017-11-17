package com.berstek.paywiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.berstek.paywiz.views.ViewPagerFragment;
import com.berstek.paywiz.views.account_setup.LoginSignUpFragment;
import com.berstek.paywiz.models.User;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements LoginSignUpFragment.AccountSetupListener {

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        if (auth.getCurrentUser() == null)
            //redirect to login page
            getSupportFragmentManager().beginTransaction().
                    add(R.id.main_container, new LoginSignUpFragment()).commit();
        else
            //direct to home page
            getSupportFragmentManager().beginTransaction().
                    add(R.id.main_container, new ViewPagerFragment()).commit();
    }

    @Override
    public void onLogin(String username, String password) {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.main_container, new ViewPagerFragment()).commit();
    }

    @Override
    public void onSignUp(User user) {
        //TODO register user
    }
}

