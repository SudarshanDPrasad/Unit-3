package com.example.evaluationpraticesprint_2.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evaluationpraticesprint_2.AdaptorHoldetClass;
import com.example.evaluationpraticesprint_2.ApiService;
import com.example.evaluationpraticesprint_2.ItemClickListener;
import com.example.evaluationpraticesprint_2.NetWork;
import com.example.evaluationpraticesprint_2.PreferenceHelper;
import com.example.evaluationpraticesprint_2.R;
import com.example.evaluationpraticesprint_2.ResponseModel;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItemListFragment extends Fragment implements ItemClickListener {

    private TextView tvheadline;
    private RecyclerView recyclerView;
    private ArrayList<ResponseModel> responseModels = new ArrayList<>();
    private AdaptorHoldetClass adaptorHoldetClass;
    private FragmentManager fragmentManager;

//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//
//    private String mParam1;
//    private String mParam2;
//
//    public ItemListFragment() {
//        // Required empty public constructor
//    }
//
//
//    public static ItemListFragment newInstance(String param1, String param2) {
//        ItemListFragment fragment = new ItemListFragment();
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
        fragmentManager = getActivity().getSupportFragmentManager();


    }

    private void initviews(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        tvheadline = view.findViewById(R.id.tvHeadline);
        tvheadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildata();
                setrecycler();
            }
        });
    }

    private void setrecycler() {
        adaptorHoldetClass = new AdaptorHoldetClass(responseModels, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adaptorHoldetClass);
    }

    private void buildata() {
        ApiService apiService = NetWork.getInstance().create(ApiService.class);
        Call<ArrayList<ResponseModel>> call = apiService.data("shivarajp",
                "2cbe00030c04472c9d8ad4b0ec112dbe", "raw",
                "c651391e428182f08d60d59e79073f3fcf79b858", "nobroker");
        call.enqueue(new Callback<ArrayList<ResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseModel>> call, Response<ArrayList<ResponseModel>> response) {
                responseModels = response.body();
                adaptorHoldetClass.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ArrayList<ResponseModel>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onItemClick(ResponseModel responseModel, int postion) {

        PreferenceHelper.writeStringToPreference(getContext(),"data",responseModel.getTitle());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ItemDetailsFragment itemDetailsFragment = new ItemDetailsFragment();
        fragmentTransaction.replace(R.id.flcontainer,itemDetailsFragment,"Detail").addToBackStack("").commit();
    }
}