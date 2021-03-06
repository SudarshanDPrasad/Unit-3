package com.example.dynamicfragments;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiSerivce {

    @GET("{userName}/{userId}/{raw}/{id}/{brokerName}")
    Call<ArrayList<ResponseModel>> data(@Path("userName") String userName,
                                       @Path("userId") String userid,
                                       @Path("raw") String raw,
                                       @Path("id") String id,
                                       @Path("brokerName") String brokerName

    );
}
