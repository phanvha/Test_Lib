package com.map4d.awesome_library;


import android.content.Context;
import android.util.Log;

import com.map4d.awesome_library.Model.Model_Smartcode_Data;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Get_Smartcodes {
    public static Context context;

    public static Model_Smartcode_Data model_smartcode_data;
    public static String data;
    public static String getDataSmartcode (Double latitude, Double longitude) {

        String latlng = latitude+","+longitude;
        API_Smartcode_Interface service = API_Smartcode.getClient2().create(API_Smartcode_Interface.class);
        retrofit2.Call<Model_Smartcode_Data> userCall = service.getSmartcodeData(latlng);
        userCall.enqueue(new Callback<Model_Smartcode_Data>() {
            @Override
            public void onResponse(Call<Model_Smartcode_Data> call, Response<Model_Smartcode_Data> response) {
                //onSignupSuccess();
                if (response.isSuccessful()) {
                    if (response.body()!=null){
                        Log.d("DataSmartCode", ""+response.body());
                        data = response.body().getResults().getSmartCode();


                    }
                }else {
                    Log.d("DataSmartCode", "null");
                }
            }
            @Override
            public void onFailure(Call<Model_Smartcode_Data> call, Throwable t) {
                Log.d("Failed: ", t.toString());
            }
        });
        return data;
    }
    public static int x(int a, int b){
        return a+b;
    }
}
