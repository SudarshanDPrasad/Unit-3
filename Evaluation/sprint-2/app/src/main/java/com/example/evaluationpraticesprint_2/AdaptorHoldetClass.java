package com.example.evaluationpraticesprint_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.evaluationpraticesprint_2.Fragment.ItemDetailsFragment;

import java.util.List;

public class AdaptorHoldetClass extends RecyclerView.Adapter<Holder> {

    private List<ResponseModel> responseModelList;
    private ItemClickListener clickListener;

    public AdaptorHoldetClass(List<ResponseModel> responseModelList, ItemClickListener clickListener) {
        this.responseModelList = responseModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new Holder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        ResponseModel responseModel = responseModelList.get(position);
        holder.setData(responseModel);
    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
}

class Holder extends RecyclerView.ViewHolder {

    private TextView tittle, subtittle;
    private ImageView imageView;
    private ItemClickListener clickListener;

    public Holder(@NonNull View itemView, ItemClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initviews(itemView);

    }

    private void initviews(View itemView) {

        tittle = itemView.findViewById(R.id.Tvtitlle1);
        subtittle = itemView.findViewById(R.id.TvSubTittle);
        imageView = itemView.findViewById(R.id.imageview);

    }

    public void setData(ResponseModel responseModel) {

        tittle.setText(responseModel.getTitle());
        subtittle.setText(responseModel.getSubTitle());
        Glide.with(imageView).load(responseModel.getImage()).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickListener.onItemClick(responseModel, getAdapterPosition());
            }
        });
    }
}
