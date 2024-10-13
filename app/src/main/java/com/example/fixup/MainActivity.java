package com.example.fixup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.fixup.utils.AndroidUtil;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.issue_feed_list);
        progressBar = findViewById(R.id.home_progress_bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.user_profile) {
            AndroidUtil.showToast(
                    this,
                    "Directing to Profile Page"
            );
            AndroidUtil.switchActivity(
                    this,
                    ProfileActivity.class
            );
        } else if (item.getItemId() == R.id.user_notification) {
            AndroidUtil.showToast(
                    this,
                    "Directing to Notifications Page"
            );
            AndroidUtil.switchActivity(
                    this,
                    NotificationActivity.class
            );
        } else if (item.getItemId() == R.id.user_settings) {
            AndroidUtil.showToast(
                    this,
                    "Directing to Settings Page"
            );
            AndroidUtil.switchActivity(
                    this,
                    SettingActivity.class
            );
        } else if (item.getItemId() == R.id.add_posts) {
            AndroidUtil.showToast(
                    this,
                    "Directing to Add Post Page"
            );
            AndroidUtil.switchActivity(
                    this,
                    AddPostActivity.class
            );
        } else if (item.getItemId() == R.id.refresh) {
            AndroidUtil.showToast(
                    this,
                    "Refreshing the Page"
            );
        } else if (item.getItemId() == R.id.logout) {

        }
        return true;
    }
}