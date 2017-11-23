package com.berstek.paywiz.views.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.berstek.paywiz.R;
import com.berstek.paywiz.data_access.UserDA;
import com.berstek.paywiz.models.User;
import com.berstek.paywiz.utils.CustomImageUtils;
import com.berstek.paywiz.utils.UserUtils;
import com.berstek.paywiz.views.user_profile.ProfileActivity;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.ExecutionException;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ImageView searchBtn;
    private TextView appTitle, nameTxt, addressTxt, phoneTxt,
            transactionsTxt, ratingTxt, verifiedTxt;
    private ImageView dpBlurred, dp;
    private ConstraintLayout navHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Wire views

        navHeader = (ConstraintLayout) navigationView.getHeaderView(0);

        searchBtn = findViewById(R.id.search_btn);
        appTitle = findViewById(R.id.app_title);
        dpBlurred = navHeader.findViewById(R.id.dp_blurred);
        dp = navHeader.findViewById(R.id.dp);
        nameTxt = navHeader.findViewById(R.id.name_txt);
        addressTxt = navHeader.findViewById(R.id.address_txt);
        phoneTxt = navHeader.findViewById(R.id.phone_txt);
        transactionsTxt = navHeader.findViewById(R.id.transactions_txt);
        ratingTxt = navHeader.findViewById(R.id.rating_txt);
        verifiedTxt = navHeader.findViewById(R.id.verified_txt);


        searchBtn.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction().
                add(R.id.home_content, new HomeViewPagerFragment()).commit();

        loadUserInfo();
    }


    private void loadUserInfo() {
        UserDA userDA = new UserDA();

        Query query = userDA.queryUserByUID(UserUtils.getUID());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    final User user = child.getValue(User.class);
                    nameTxt.setText(user.getFullName());

                    Glide.with(HomeActivity.this).
                            load(user.getPhoto_url()).skipMemoryCache(true).into(dp);
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                final Bitmap myBitmap = Glide.with(HomeActivity.this)
                                        .load(user.getPhoto_url())
                                        .asBitmap()
                                        .into(500, 500)
                                        .get();

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        dpBlurred.setImageBitmap(myBitmap);

                                        BitmapDrawable img = (BitmapDrawable) dpBlurred.getDrawable();
                                        Bitmap bitmap = img.getBitmap();
                                        Bitmap blurred = new CustomImageUtils().blurRenderScript(bitmap,
                                                15, HomeActivity.this);
                                        dpBlurred.setImageBitmap(blurred);

                                        dpBlurred.setColorFilter(Color.rgb(123, 123, 123),
                                                android.graphics.PorterDuff.Mode.MULTIPLY);
                                    }
                                });
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    t.start();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.search_btn) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
    }
}
