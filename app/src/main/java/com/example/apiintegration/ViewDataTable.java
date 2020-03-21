package com.example.apiintegration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewDataTable extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private String TAG;
    ArrayList<Data> data;
    private TextView tvTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data_table);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.dahukstudios.com/accounts/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<AccountsInfo> call = jsonPlaceHolderApi.getData();

        call.enqueue(new Callback<AccountsInfo>() {
            @Override
            public void onResponse(Call<AccountsInfo> call, Response<AccountsInfo> response) {

                if(!response.isSuccessful()){

                    return;

                }


                 data = response.body().getData();

                int content=0   ;
                for(int i = 0; i<data.size(); i++){

                    content +=  Integer.parseInt(data.get(i).getDebit())-Integer.parseInt(data.get(i).getCredit())  ;



                }


                tvTotal = findViewById(R.id.tvTotal);

                tvTotal.setText(""+content);

                RecyclerView rv1 = findViewById(R.id.rv1);
                rv1.setHasFixedSize(true);
                RecyclerView.LayoutManager mLayoutmanager = new LinearLayoutManager(ViewDataTable.this);



                RecyclerView.Adapter mAdapter = new MainAdapter(data);

                rv1.setLayoutManager(mLayoutmanager);
                rv1.setAdapter(mAdapter);





            }

            @Override
            public void onFailure(Call<AccountsInfo> call, Throwable t) {

                Toast.makeText(ViewDataTable.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            }
        });















    }
}



