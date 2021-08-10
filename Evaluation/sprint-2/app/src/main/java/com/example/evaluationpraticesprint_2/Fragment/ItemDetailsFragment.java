package com.example.evaluationpraticesprint_2.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evaluationpraticesprint_2.PreferenceHelper;
import com.example.evaluationpraticesprint_2.R;


public class ItemDetailsFragment extends Fragment {


    private TextView Tvtitlle1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Tvtitlle1 = view.findViewById(R.id.TvTittlefragment);
//        PreferenceHelper.getInstance(getContext());
        String data = PreferenceHelper.getStringFromPreference(getContext(),"data");
        Tvtitlle1.setText(data);
    }
}