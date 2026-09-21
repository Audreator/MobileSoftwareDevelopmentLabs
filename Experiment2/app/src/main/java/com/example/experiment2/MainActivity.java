package com.example.experiment2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_linear).setOnClickListener(v ->
                startActivity(new Intent(this, LinearLayoutActivity.class)));
        findViewById(R.id.btn_table).setOnClickListener(v ->
                startActivity(new Intent(this, TableLayoutActivity.class)));
        findViewById(R.id.btn_constraint1).setOnClickListener(v ->
                startActivity(new Intent(this, ConstraintLayout1Activity.class)));
        findViewById(R.id.btn_constraint2).setOnClickListener(v ->
                startActivity(new Intent(this, ConstraintLayout2Activity.class)));
    }
}
