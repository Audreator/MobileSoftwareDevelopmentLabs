package com.example.experiment3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_list_view).setOnClickListener(v ->
                startActivity(new Intent(this, ListViewActivity.class)));
        findViewById(R.id.btn_dialog).setOnClickListener(v ->
                startActivity(new Intent(this, CustomDialogActivity.class)));
        findViewById(R.id.btn_menu).setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class)));
        findViewById(R.id.btn_action_mode).setOnClickListener(v ->
                startActivity(new Intent(this, ActionModeActivity.class)));
        findViewById(R.id.btn_recycler).setOnClickListener(v ->
                startActivity(new Intent(this, RecyclerViewActivity.class)));
    }
}
