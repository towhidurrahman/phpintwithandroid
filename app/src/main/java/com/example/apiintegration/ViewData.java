package com.example.apiintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewData extends AppCompatActivity {
    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private String TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);



        textViewResult = findViewById(R.id.text_view_result);

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
                    textViewResult.setText("Code: "+ response.code());
                    return;

                }


                ArrayList<Data> data = response.body().getData();

                for(int i = 0; i<data.size(); i++){
                    String content = "";
                    content += "id: " + data.get(i).getId() + "\n";
                    content += "description: " + data.get(i).getDescription() + "\n";
                    content += "debit: " + data.get(i).getDebit() + "\n";
                    content += "credit: " + data.get(i).getCredit() + "\n" ;
                    content += "transactionthrough: " + data.get(i).getTransactionthrough() + "\n";
                    content += "reference: " + data.get(i).getReference() + "\n";
                    content += "transactiondate: " + data.get(i).getTransactiondate() + "\n\n\n";



                    textViewResult.append(content);
                }




            }

            @Override
            public void onFailure(Call<AccountsInfo> call, Throwable t) {

                Toast.makeText(ViewData.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
