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


public class FragmentC extends Fragment {

    private RecyclerView recyclerview;
    private List<Model> modelList = new ArrayList<>();

    public FragmentC() {
        // Required empty public constructor
    }

    public static FragmentC newInstance() {
        FragmentC fragment = new FragmentC();
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
        return inflater.inflate(R.layout.fragment_c, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerview = view.findViewById(R.id.recyclerview);
        setRecylerView();
        buildData();

    }

    private void buildData() {
        modelList.add(new Model("munnar"));
        modelList.add(new Model("coalkers  "));
        modelList.add(new Model("love lake"));
        modelList.add(new Model("abhey falls"));
        modelList.add(new Model("Mysuru Palace"));
        modelList.add(new Model("Bangalore Palace"));
        modelList.add(new Model("TajMahal"));
        modelList.add(new Model("Lover View"));
        modelList.add(new Model("Goa Beach"));
        modelList.add(new Model("India gate "));
        modelList.add(new Model("Lalith Mahal"));
        modelList.add(new Model("Red Fort"));
        modelList.add(new Model("QutibMinar"));
        modelList.add(new Model("Ladakh"));
        modelList.add(new Model("Coorg"));
    }

    private void setRecylerView(){
        Adaptor adaptor = new Adaptor(modelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adaptor);
    }
}