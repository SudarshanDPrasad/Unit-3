package com.example.dynamicfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentName extends Fragment {
    private Button mbtnresponse;
    private RecyclerView recyclerView;
    private ArrayList<ResponseModel> responseModels = new ArrayList<>();
    private FragmentAdaptor fragmentAdaptor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniviews(view);
    }

    private void iniviews(View view) {
        mbtnresponse = view.findViewById(R.id.btnresponse);
        recyclerView = view.findViewById(R.id.recyclerview);
        mbtnresponse.setOnClickListener(v -> {
            displaydata();
            setrecycler();
        });
    }

    private void setrecycler() {
        ApiSerivce apiSerivce = NetWork.getInstance().create(ApiSerivce.class);
        Call<ArrayList<ResponseModel>> call = apiSerivce.data("shivarajp",
                "2cbe00030c04472c9d8ad4b0ec112dbe",
                "raw", "c651391e428182f08d60d59e79073f3fcf79b858", "nobroker");
        call.enqueue(new Callback<ArrayList<ResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseModel>> call, Response<ArrayList<ResponseModel>> response) {
                responseModels = response.body();
                fragmentAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseModel>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void displaydata() {
        fragmentAdaptor = new FragmentAdaptor(responseModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentAdaptor);
    }

}