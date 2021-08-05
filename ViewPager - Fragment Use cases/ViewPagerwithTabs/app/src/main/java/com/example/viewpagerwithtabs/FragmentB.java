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


public class FragmentB extends Fragment {

    private RecyclerView recyclerview;
    private List<Model> modelList = new ArrayList<>();


    public FragmentB() {
        // Required empty public constructor
    }


    public static FragmentB newInstance() {
        FragmentB fragment = new FragmentB();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerview = view.findViewById(R.id.recyclerview);
        setRecylerView();
        buildData();

    }

    private void buildData() {
        modelList.add(new Model("Delhi"));
        modelList.add(new Model("karnataka "));
        modelList.add(new Model("kerala"));
        modelList.add(new Model("Andhra Pradesh "));
        modelList.add(new Model("ooty"));
        modelList.add(new Model("Rajasthan"));
        modelList.add(new Model("Mumbai"));
        modelList.add(new Model("Chennai"));
        modelList.add(new Model("Tamil naidu "));
        modelList.add(new Model("Gujurath"));
        modelList.add(new Model("Bihar"));
        modelList.add(new Model("Nepal"));
        modelList.add(new Model("Goa"));
        modelList.add(new Model("Coorg"));
        modelList.add(new Model("West Bengal"));
    }

    private void setRecylerView(){
        Adaptor adaptor = new Adaptor(modelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adaptor);
    }
}