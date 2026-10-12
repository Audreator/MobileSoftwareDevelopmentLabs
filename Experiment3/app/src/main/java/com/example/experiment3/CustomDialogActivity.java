package com.example.experiment3;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CustomDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        findViewById(R.id.btn_show_dialog).setOnClickListener(v -> showCustomDialog());
    }

    private void showCustomDialog() {
        View view = getLayoutInflater().inflate(R.layout.dialog_custom, null);
        new AlertDialog.Builder(this)
                .setView(view)
                .setNegativeButton(R.string.dialog_cancel, null)
                .setPositiveButton(R.string.dialog_sign_in, null)
                .show();
    }
}
