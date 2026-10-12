package com.example.experiment3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    public static class Animal {

        private final String name;

        private final int iconRes;

        public Animal(String name, int iconRes) {
            this.name = name;
            this.iconRes = iconRes;
        }
    }

    private final List<Animal> animals;

    public AnimalAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animals.get(position);
        holder.imageView.setImageResource(animal.iconRes);
        holder.nameView.setText(animal.name);
        holder.itemView.setOnClickListener(v ->
                Toast.makeText(v.getContext(), animal.name, Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    static class AnimalViewHolder extends RecyclerView.ViewHolder {

        final ImageView imageView;

        final TextView nameView;

        AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_animal);
            nameView = itemView.findViewById(R.id.tv_animal_name);
        }
    }
}
