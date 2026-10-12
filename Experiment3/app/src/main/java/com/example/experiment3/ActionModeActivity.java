package com.example.experiment3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionModeActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ActionMode actionMode;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);

        listView = findViewById(R.id.list_view);
        List<String> data = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        adapter = new ArrayAdapter<>(this, R.layout.item_action_mode, R.id.tv_name, data);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            listView.setItemChecked(position, true);
            selectedPosition = position;
            if (actionMode == null) {
                actionMode = startSupportActionMode(actionModeCallback);
            } else {
                actionMode.setTitle(getString(R.string.action_mode_title));
            }
            return true;
        });
    }

    private final ActionMode.Callback actionModeCallback = new ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_action_mode, menu);
            mode.setTitle(getString(R.string.action_mode_title));
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.action_delete) {
                if (selectedPosition >= 0 && selectedPosition < adapter.getCount()) {
                    adapter.remove(adapter.getItem(selectedPosition));
                }
                mode.finish();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
            selectedPosition = -1;
            listView.clearChoices();
            adapter.notifyDataSetChanged();
        }
    };
}
