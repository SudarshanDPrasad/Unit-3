package com.example.viewpagerwithtabs;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView tvString;

    public ViewHolder(@NonNull  View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvString = itemView.findViewById(R.id.tvString);
    }
    public void setData(Model model){
        tvString.setText(model.getName());

    }
}
