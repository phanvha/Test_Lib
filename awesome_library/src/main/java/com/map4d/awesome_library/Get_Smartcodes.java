package com.map4d.awesome_library;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Get_Smartcodes {
    public static Context context;

    public static Model_Smartcode_Data model_smartcode_data;
    public static JSONObject object;
    public static JSONObject getDataSmartcode (Double latitude, Double longitude) {

        String latlng = latitude+","+longitude;
        API_Smartcode_Interface service = API_Smartcode.getClient2().create(API_Smartcode_Interface.class);
        retrofit2.Call<Model_Smartcode_Data> userCall = service.getSmartcodeData(latlng);
        userCall.enqueue(new Callback<Model_Smartcode_Data>() {
            @Override
            public void onResponse(Call<Model_Smartcode_Data> call, Response<Model_Smartcode_Data> response) {
                if (response.isSuccessful()){

                    //min
                    JSONObject min = new JSONObject();
                    try {
                        min.put("lat", response.body().getResults().getMin().getLatitude());
                        min.put("lng", response.body().getResults().getMin().getLongitude());
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //max
                    JSONObject max = new JSONObject();
                    try {
                        max.put("lat", response.body().getResults().getMax().getLatitude());
                        max.put("lng", response.body().getResults().getMax().getLongitude());
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //location
                    JSONObject location = new JSONObject();
                    try {
                        location.put("lat", response.body().getResults().getLocation().getLatitude());
                        location.put("lng", response.body().getResults().getLocation().getLongitude());
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //compoundCode
                    JSONObject compoundCode = new JSONObject();
                    try {
                        compoundCode.put("compoundCode", response.body().getResults().getCompoundCode());
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //smartcodes
                    JSONObject smartcodes = new JSONObject();
                    try {
                        smartcodes.put("smartCode", response.body().getResults().getSmartCode());
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //center
                    JSONObject center = new JSONObject();
                    try {
                        center.put("lat", response.body().getResults().getCenter().getLatitude());
                        center.put("lng", response.body().getResults().getCenter().getLongitude());
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    //result
                    JSONObject result = new JSONObject();
                    try {
                        result.put("min", min);
                        result.put("max", max);
                        result.put("location", location);
                        result.put("compoundCode", compoundCode);
                        result.put("smartCode", smartcodes);
                        result.put("center", center);
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //
                    object = new JSONObject();
                    try {
                        object.put("code", response.body().getCode());
                        object.put("result", result);

                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    Log.e("jsonObject", object.toString());
                }
            }

            @Override
            public void onFailure(Call<Model_Smartcode_Data> call, Throwable t) {

            }
        });
        return object;
    }
    public static int x(int a, int b){
        return a+b;
    }
}
