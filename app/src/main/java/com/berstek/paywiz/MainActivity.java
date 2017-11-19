package com.berstek.paywiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.berstek.paywiz.views.account_setup.LoginSignUpFragment;
import com.berstek.paywiz.models.User;
import com.berstek.paywiz.views.home.HomeActivity;
import com.berstek.paywiz.views.user_profile.ProfileActivity;
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
        else {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onLogin(String username, String password) {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSignUp(User user) {
        //TODO register user
    }
}

