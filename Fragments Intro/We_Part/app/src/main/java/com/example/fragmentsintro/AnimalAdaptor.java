package com.example.fragmentsintro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdaptor extends RecyclerView.Adapter<AnimalViewHolder> {

    private ArrayList<Animal> animalslist;

    public AnimalAdaptor(ArrayList<Animal> animalslist) {
        this.animalslist = animalslist;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animalslist.get(position);
        holder.setData(animal);
    }

    @Override
    public int getItemCount() {
        return animalslist.size();
    }
}
