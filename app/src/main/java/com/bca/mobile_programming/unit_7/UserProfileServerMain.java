package com.bca.mobile_programming.unit_7;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bca.mobile_programming.R;

import java.util.HashMap;

public class UserProfileServerMain extends AppCompatActivity {
    ListView mainList;

    EditText idInput;
    EditText nameInput;
    EditText addressInput;

    final String getEndpoint = "http://192.168.16.106/getdata.php";
    final String sendEndpoint = "http://192.168.16.106/setdata.php";

    @Override
    protected void onStart() {
        super.onStart();

        ActionBar bar = getSupportActionBar();
        if (bar != null) bar.hide();
    }

    @Override
    public void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_7_user_profile_server);

        idInput = findViewById(R.id.userProfileServerIdInput);
        mainList = findViewById(R.id.userProfileServerListMain);
        nameInput = findViewById(R.id.userProfileServerNameInput);
        addressInput = findViewById(R.id.userProfileServerAddressInput);
        Button insertButton = findViewById(R.id.userProfileServerInsertButton);
        Button refreshButton = findViewById(R.id.userProfileServerRefreshButton);

        getUserData();

        insertButton.setOnClickListener(v -> setUserData());
        refreshButton.setOnClickListener(v -> getUserData());
    }

    private void setUserData(){
        RequestQueue query = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,sendEndpoint,
                response -> Toast.makeText(getApplicationContext(),
                        response, Toast.LENGTH_SHORT).show(),
                error -> Log.d("Error posting data", error.toString())
        ){
            @Override
            protected HashMap<String, String> getParams(){
                HashMap<String, String> map = new HashMap<>();

                map.put("id", idInput.getText().toString());
                map.put("name", nameInput.getText().toString());
                map.put("address", addressInput.getText().toString());

                return map;
            }
        };

        query.add(stringRequest);

    }

    private void getUserData(){
//        RequestQueue query = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.POST,getEndPoint);
    }
}
