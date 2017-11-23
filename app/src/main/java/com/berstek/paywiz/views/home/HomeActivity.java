package com.berstek.paywiz.views.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
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
import com.berstek.paywiz.utils.CustomImageUtils;
import com.berstek.paywiz.views.user_profile.ProfileActivity;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ImageView searchBtn;
    private TextView appTitle;
    private ImageView dpBlurred;

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

        searchBtn = findViewById(R.id.search_btn);
        appTitle = findViewById(R.id.app_title);
        dpBlurred = navigationView.getHeaderView(0).findViewById(R.id.dp_blurred);

        BitmapDrawable img = (BitmapDrawable) dpBlurred.getDrawable();
        Bitmap bitmap = img.getBitmap();
        Bitmap blurred = new CustomImageUtils().blurRenderScript(bitmap,
                15, HomeActivity.this);
        dpBlurred.setImageBitmap(blurred);

        searchBtn.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction().
                add(R.id.home_content, new HomeViewPagerFragment()).commit();
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
