package com.code.knab.sportgeeks.ui.welcome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.code.knab.sportgeeks.R;
import com.code.knab.sportgeeks.network.json.SportEvent;
import com.code.knab.sportgeeks.ui.events.EventsActivity;
import com.code.knab.sportgeeks.ui.welcome.mvp.WelcomeMVP;
import com.code.knab.sportgeeks.ui.welcome.mvp.WelcomeModel;
import com.code.knab.sportgeeks.ui.welcome.mvp.WelcomePresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity implements WelcomeMVP.View{

    private MyEventsListAdapter myEventsListAdapter;
    private ListView myEventsListView;

    private WelcomePresenter presenter;

    private Long userId;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        presenter = new WelcomePresenter(this, new WelcomeModel());

        myEventsListView = findViewById(R.id.myEventsListView);

        userId = getIntent().getLongExtra("userId", 0);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        presenter.getEventsList(userId);

        myEventsListView.setOnItemClickListener((parent,view,position,id) -> {

        });
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


    @Override
    public void listLoaded(List<SportEvent> list) {
        myEventsListAdapter = new MyEventsListAdapter(this, R.layout.my_events_adapter_view, (ArrayList<SportEvent>) list);

    }
}
