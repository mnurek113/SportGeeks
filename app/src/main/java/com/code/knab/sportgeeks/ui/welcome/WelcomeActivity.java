package com.code.knab.sportgeeks.ui.welcome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.code.knab.sportgeeks.R;
import com.code.knab.sportgeeks.ui.events.EventsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WelcomeActivity extends AppCompatActivity {

    private Long userId;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        userId = getIntent().getLongExtra("userId", 0);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.ic_account:

                    break;
                case R.id.ic_fitness:
                    Intent intent = new Intent(WelcomeActivity.this, EventsActivity.class);
                    startActivity(intent);
                    WelcomeActivity.this.finish();
                    break;
                case R.id.ic_setting:
                    break;
            }
            return false;
        }
    };




}
