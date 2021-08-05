package com.example.viewpagerwithtabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentA extends Fragment {

    private RecyclerView recyclerview;
    private List<Model> modelList = new ArrayList<>();



    public FragmentA() {
        // Required empty public constructor
    }

    public static FragmentA newInstance() {
        FragmentA fragment = new FragmentA();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerview = view.findViewById(R.id.recyclerview);
        setRecylerView();
        buildData();

    }

    private void buildData() {
       modelList.add(new Model("Sudarshan D Prasad"));
        modelList.add(new Model("Llyod "));
        modelList.add(new Model("Nrupul Dev"));
        modelList.add(new Model("Pratheek "));
        modelList.add(new Model("Yogesh"));
        modelList.add(new Model("Virat Kholi"));
        modelList.add(new Model("Aditya"));
        modelList.add(new Model("Dubai sheek "));
        modelList.add(new Model("Jack"));
        modelList.add(new Model("Yedurappa"));
        modelList.add(new Model("Sachin"));
        modelList.add(new Model("Bing Bong"));
        modelList.add(new Model("Messi"));
        modelList.add(new Model("Rajkumar"));
        modelList.add(new Model("Narendra modi"));
    }

    private void setRecylerView(){
        Adaptor adaptor = new Adaptor(modelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adaptor);
    }

}