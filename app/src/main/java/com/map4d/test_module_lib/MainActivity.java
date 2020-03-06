package com.map4d.test_module_lib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.map4d.awesome_library.Model_Smartcode_Data;
import com.map4d.awesome_library.SmartCodeLib;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Model_Smartcode_Data model_smartcode_data;
    TextView a;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.a);
        JSONObject v = SmartCodeLib.getSmartcode(16.125234,108.12453);
        a.setText("" + v.toString());
        Log.e("data", a +"");

        //Toast.makeText(getApplicationContext(),""+Get_Smartcodes.getDataSmartcode(16.235252,108.1242352).get(1),Toast.LENGTH_SHORT).show();

    }
//    private String getDataSmartcode (Double latitude, Double longitude) {
//
//        String latlng = latitude+","+longitude;
//        com.map4d.awesome_library.API_Smartcodes_Interface.API_Smartcode_Interface service = API_Smartcode.getClient2().create(API_Smartcode_Interface.class);
//        Call<com.map4d.awesome_library.Model.Model_Smartcode_Data> userCall = service.getSmartcodeData(latlng);
//        userCall.enqueue(new Callback<com.map4d.awesome_library.Model.Model_Smartcode_Data>() {
//            @Override
//            public void onResponse(Call<com.map4d.awesome_library.Model.Model_Smartcode_Data> call, Response<com.map4d.awesome_library.Model.Model_Smartcode_Data> response) {
//                //onSignupSuccess();
//                if (response.isSuccessful()) {
//                    if (response.body()!=null){
//                        Log.d("DataSmartCode", ""+response.body().getResults().getSmartCode());
//                        Toast.makeText(getApplicationContext(),""+response.body().getResults().getSmartCode(),Toast.LENGTH_SHORT).show();
//                        data = response.body().getResults().getSmartCode();
//
//
//                    }
//                }else {
//                    Log.d("DataSmartCode", "null");
//                }
//            }
//            @Override
//            public void onFailure(Call<com.map4d.awesome_library.Model.Model_Smartcode_Data> call, Throwable t) {
//                Log.d("Failed: ", t.toString());
//            }
//        });
//        return data;
//    }
}
