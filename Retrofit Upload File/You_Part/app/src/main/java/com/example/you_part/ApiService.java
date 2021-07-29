package com.example.you_part;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @Headers("Authorization: Client-ID aff55c85d45a0e9")
    @POST("3/upload")
    @Multipart
    Call<ResponseModel> uploadVideo(

            @Part MultipartBody.Part File,
            @Part("title") String title
    );
}
