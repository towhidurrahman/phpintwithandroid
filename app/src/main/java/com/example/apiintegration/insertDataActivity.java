package com.example.apiintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class insertDataActivity extends AppCompatActivity {

    DatePickerDialog picker;
    private Spinner spinner;

    private EditText txtDescription;
    private EditText txtAmount;
    private Spinner txtTransactionThrough;
    private EditText txtReference;

    private EditText trndtText;

    Date CurrentSystemDate;

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    String formatteddate;





    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);


        txtDescription = findViewById(R.id.descText);
        txtAmount = findViewById(R.id.amountText);
        txtTransactionThrough = findViewById(R.id.trnsthrText);
        txtReference = findViewById(R.id.refText);
        trndtText= findViewById(R.id.trndtText);
        trndtText.setInputType(InputType.TYPE_NULL);





        CurrentSystemDate = Calendar.getInstance().getTime();

        formatteddate = df.format(CurrentSystemDate);

        trndtText.setText(formatteddate);





        //--------------- Transtype Spinner data Add -----------------

        spinner = findViewById(R.id.spinner);

        List<String> Transtyplelist = new ArrayList<String>();
        Transtyplelist.add("Select Entry Type");
        Transtyplelist.add("In");
        Transtyplelist.add("Out");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Transtyplelist);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        ///-----------


        //--------------- Transtype Spinner data Add -----------------



        List<String> ModeOfPaymentList = new ArrayList<String>();
        ModeOfPaymentList.add("Select Mode of payment");
        ModeOfPaymentList.add("Cash");
        ModeOfPaymentList.add("Cheque");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ModeOfPaymentList);

        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txtTransactionThrough.setAdapter(dataAdapter2);

        ///-----------






        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.dahukstudios.com/accounts/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


    }

    public void btnInsertClick(View view){





        Double debitamt=0.0;
        Double creditamt=0.0;

        if(spinner.getSelectedItem()=="In"){

            debitamt = Double.parseDouble( txtAmount.getText().toString());
            creditamt = 0.0;

        }
        else if(spinner.getSelectedItem()=="Out"){

            creditamt = Double.parseDouble( txtAmount.getText().toString());
            debitamt = 0.0;

        }
        else{

            Toast.makeText(this, "Select Entry Type", Toast.LENGTH_SHORT).show();

            return;
        }



        if(TextUtils.isEmpty(txtDescription.getText().toString())){

            Toast.makeText(this, "Description can NOT be empty", Toast.LENGTH_SHORT).show();

            return;

        }



        if(txtTransactionThrough.getSelectedItemPosition()==0){

            Toast.makeText(this, "Select Mode of Pay", Toast.LENGTH_SHORT).show();

            return;

        }








        Insertinfo insertinfo = new Insertinfo(
                txtDescription.getText().toString(),
                debitamt,
                creditamt,
                String.valueOf(txtTransactionThrough.getSelectedItem()),
                txtReference.getText().toString(),
                trndtText.getText().toString()


        );


        Call<Insertinfo> call = jsonPlaceHolderApi.insertData(insertinfo);

        call.enqueue(new Callback<Insertinfo>() {
            @Override
            public void onResponse(Call<Insertinfo> call, Response<Insertinfo> response) {

                if(!response.isSuccessful()){

                    return;

                }




                String content = "";
               // content += "Code: " + response.code() + "\n";
                content += "Description: Data Inserted Successfully \n";



                spinner.setSelection(0);
                txtDescription.setText("");
                txtAmount.setText("");
                txtTransactionThrough.setSelection(0);
                txtReference.setText("");
                trndtText.setText("");
                trndtText.setText(formatteddate);



                Toast.makeText(insertDataActivity.this, content, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<Insertinfo> call, Throwable t) {

                Toast.makeText(insertDataActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            }
        });



    }

    public void clickdate (View view) {

        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        // date picker dialog
        picker = new DatePickerDialog(insertDataActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String month = "";
                        String day = "";

                        if(monthOfYear<10){
                            month = "0" + (monthOfYear + 1);

                        }
                        else{
                            month = ""+ (monthOfYear + 1);
                        }

                        if(dayOfMonth<10){
                            day = "0" + dayOfMonth;

                        }
                        else{
                            day = ""+ dayOfMonth;
                        }


                        trndtText.setText(year + "-" + month +  "-" + day );
                    }
                }, year, month, day);

        picker.show();


    }
}
