package com.example.fragmentsintro;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private ImageView ivAnaimal;


    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        intviews(itemView);
    }

    private void intviews(View itemView) {
        tvName = itemView.findViewById(R.id.tvName);
        ivAnaimal = itemView.findViewById(R.id.ivImage);
    }

    public void setData(Animal animal){
        ivAnaimal.setImageResource(animal.getImage());
        tvName.setText(animal.getName());
    }
}
