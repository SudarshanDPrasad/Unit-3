package com.example.dynamicfragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class FragmentViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivImage;
    private TextView textview2,textview1;

    public FragmentViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        ivImage= itemView.findViewById(R.id.ivImage);
        textview1 = itemView.findViewById(R.id.textview1);
        textview2 = itemView.findViewById(R.id.textview2);
    }

    public void setData(ResponseModel responseModel){
        textview1.setText(responseModel.getTitle());
        textview2.setText(responseModel.getSubTitle());
        Glide.with(ivImage).load(responseModel.getImage()).into(ivImage);
    }
}

