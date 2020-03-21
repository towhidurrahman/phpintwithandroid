package com.example.apiintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Tag;

public class MainActivity extends AppCompatActivity {

    Button btnViewData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }



    public void btnViewDataClick(View view) {
//        Toast.makeText(this,"btnViewDataClick",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ViewData.class);
        startActivity(intent);
    }

    public void btnInserClick(View view) {

        Intent intent = new Intent(this, insertDataActivity.class);
        startActivity(intent);
    }

    public void btnViewDataTableClick(View view) {

        Intent intent = new Intent(this, ViewDataTable.class);
        startActivity(intent);
    }
}
