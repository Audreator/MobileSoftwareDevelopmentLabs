package com.example.experiment3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private static final String[] NAMES = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};

    private static final int[] ICONS = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
            R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    private final List<AnimalAdapter.Animal> animals = new ArrayList<>();

    private AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        for (int i = 0; i < NAMES.length; i++) {
            animals.add(new AnimalAdapter.Animal(NAMES[i], ICONS[i]));
        }

        adapter = new AnimalAdapter(animals);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        findViewById(R.id.btn_add).setOnClickListener(v -> {
            int index = animals.size() % NAMES.length;
            animals.add(new AnimalAdapter.Animal(NAMES[index], ICONS[index]));
            adapter.notifyItemInserted(animals.size() - 1);
            recyclerView.scrollToPosition(animals.size() - 1);
        });
    }
}
