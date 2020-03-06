package com.map4d.awesome_library;

import com.map4d.awesome_library.Model.Model_Smartcode_Data;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface API_Smartcode_Interface {
    @Headers({
            "Content-Type:application/json"
    })
    @GET("/v1.0/api/smartcodes")
    Call<Model_Smartcode_Data> getSmartcodeData(
            @Query("location") String location

    );
}