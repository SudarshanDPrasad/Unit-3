package com.example.dynamicfragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdaptor extends RecyclerView.Adapter<FragmentViewHolder> {

    List<ResponseModel> responseModelArrayList;

    public FragmentAdaptor(List<ResponseModel> responseModelArrayList) {
        this.responseModelArrayList = responseModelArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public FragmentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new FragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FragmentViewHolder holder, int position) {
        ResponseModel responseModel = responseModelArrayList.get(position);
        holder.setData(responseModel);
    }

    @Override
    public int getItemCount() {
        return responseModelArrayList.size();
    }
}
