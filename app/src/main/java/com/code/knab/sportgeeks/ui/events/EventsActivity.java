package com.code.knab.sportgeeks.ui.events;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.code.knab.sportgeeks.R;
import com.code.knab.sportgeeks.ui.welcome.WelcomeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EventsActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.ic_account:
                    Intent intent = new Intent(EventsActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    EventsActivity.this.finish();
                    break;
                case R.id.ic_fitness:
                    Intent intent2 = new Intent(EventsActivity.this, EventsActivity.class);
                    startActivity(intent2);
                    EventsActivity.this.finish();
                    break;
                case R.id.ic_setting:

                    break;
            }
            return false;
        }
    };
}
