package com.example.bmicalculator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Age = (EditText)findViewById(R.id.age);
        EditText Height = (EditText)findViewById(R.id.height);
        EditText Weight = (EditText)findViewById(R.id.weight);

        Button Button_calculate =(Button)findViewById(R.id.btn_calculate);


        Button_calculate.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (Age.getText().toString().equals("") || Height.getText().toString().equals("") || Weight.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Invalid Entries", Toast.LENGTH_LONG).show();
                }
                else if (Integer.parseInt(Age.getText().toString()) < 18)
                {
                    Toast.makeText(getApplicationContext(), "This app is for 18+ only", Toast.LENGTH_LONG).show();
                }else

                    {
                    float BMI = (Float.parseFloat(Weight.getText().toString()))/((Float.parseFloat(Height.getText().toString()))*(Float.parseFloat(Height.getText().toString())))*10000;

                    Intent BMI_Cal= new Intent(MainActivity.this,ResultActivity.class);

                    BMI_Cal.putExtra("bmi",BMI);

                    startActivity(BMI_Cal);

                    }
            }
        });
    }
    @Override
    public void onBackPressed()

    {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Do you want to Exit from App?")
                .setTitle("Exit")
                .setCancelable(true)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog msgBox = builder1.create();
        msgBox.show();
    }
}
