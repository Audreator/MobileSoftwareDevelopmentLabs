package com.example.experiment3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tvTest = findViewById(R.id.tv_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_size_small) {
            tvTest.setTextSize(10);
            return true;
        } else if (id == R.id.action_size_medium) {
            tvTest.setTextSize(16);
            return true;
        } else if (id == R.id.action_size_large) {
            tvTest.setTextSize(20);
            return true;
        } else if (id == R.id.action_normal) {
            Toast.makeText(this, R.string.toast_normal, Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_color_red) {
            tvTest.setTextColor(Color.RED);
            return true;
        } else if (id == R.id.action_color_black) {
            tvTest.setTextColor(Color.BLACK);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
