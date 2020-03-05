package com.map4d.awesome_library;

import android.util.Log;
import android.view.View;

import com.map4d.awesome_library.API_Smartcodes.API_Smartcode;
import com.map4d.awesome_library.API_Smartcodes_Interface.API_Smartcode_Interface;
import com.map4d.awesome_library.Model.Model_Smartcode_Data;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Get_Smartcodes {

    public static List<Model_Smartcode_Data> model_smartcode_data;
    public static List<Model_Smartcode_Data> getDataSmartcode (final Double latitude, final Double longitude) {

        String latlng = latitude+","+longitude;
        API_Smartcode_Interface service = API_Smartcode.getClient2().create(API_Smartcode_Interface.class);
        Call<Model_Smartcode_Data> userCall = service.getSmartcodeData(latlng);
        userCall.enqueue(new Callback<Model_Smartcode_Data>() {
            @Override
            public void onResponse(Call<Model_Smartcode_Data> call, Response<Model_Smartcode_Data> response) {
                //onSignupSuccess();
                if (response.isSuccessful()) {
                    if (response.body()!=null){
                        Log.d("DataSmartCode", ""+response.body().getResults().getSmartCode());
                        model_smartcode_data = new ArrayList<>();
                        model_smartcode_data.add(new Model_Smartcode_Data(
                                response.body().getCode(),
                                response.body().getMessage(),
                                response.body().getResults()));

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
        return model_smartcode_data;
    }
}
