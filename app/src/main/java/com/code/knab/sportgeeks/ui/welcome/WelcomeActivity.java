package com.code.knab.sportgeeks.ui.welcome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.code.knab.sportgeeks.R;
import com.code.knab.sportgeeks.ui.events.EventsActivity;
import com.code.knab.sportgeeks.ui.settings.SettingsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WelcomeActivity extends AppCompatActivity {

    private Long userId;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        userId = getIntent().getLongExtra("userId", 0);
        bottomNavigationView = findViewById(R.id.bottom_navigation_welcome);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.ic_account:
                    Intent intent = new Intent(WelcomeActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    WelcomeActivity.this.finish();
                    break;
                case R.id.ic_fitness:
                    Intent intent2 = new Intent(WelcomeActivity.this, EventsActivity.class);
                    startActivity(intent2);
                    WelcomeActivity.this.finish();
                    break;
                case R.id.ic_setting:
                    Intent intent3 = new Intent(WelcomeActivity.this, SettingsActivity.class);
                    startActivity(intent3);
                    WelcomeActivity.this.finish();
                    break;
            }
            return false;
        }
    };




}
