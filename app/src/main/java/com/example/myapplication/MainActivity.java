package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    TextView v1,v2,v3,v4,v5;
    int count=0;

    Button b1;
    Validation obj=new Validation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.editTextNumber);
        e2=(EditText) findViewById(R.id.edittext2);
        e3=(EditText) findViewById(R.id.edittext3);
        e4=(EditText) findViewById(R.id.edittext4);
        e5=(EditText) findViewById(R.id.edittext5);
        v1=(TextView)findViewById(R.id.textView1);
        v2=(TextView)findViewById(R.id.textView2);
        v3=(TextView)findViewById(R.id.textView3);
        v4=(TextView)findViewById(R.id.textView4);
        v5=(TextView)findViewById(R.id.textView5);
        b1=(Button)findViewById(R.id.button);
                                    //For checking all condition is true or not

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;

                //---------------------------------------Condition for Card Number---------------------------------
                if(obj.IsValid(e1.getText().toString()))
                {
                    if(obj.type_validation(e1.getText().toString())==false)
                    {
                        v1.setText("Invalid Creditcard Number");
                        count=0;
                    }
                    else
                    {
                        v1.setText("");
                        count+=1;
                    }
                }
                else
                {
                    v1.setText("Invalid Creditcard Number");
                    count=0;
                }
                //---------------------------------------Condition for cvv-------------------------------------------
                if(obj.cvv_validation(e2.getText().toString())==false)
                {
                    v2.setText("Invalid cvv ");
                    count=0;
                }
                else
                {
                    v2.setText("");
                    count+=1;
                }
                //-----------------------------------------condition for date-------------------------------------------
                if(obj.date_validation(e3.getText().toString())==false)
                {
                    v3.setText("Invalid Date");
                    count=0;
                }
                else
                {
                    v3.setText("");
                    count+=1;
                }
                //------------------------------------------condition for first name----------------------------------------
                if(obj.Name_validation(e4.getText().toString())==false)
                {
                    v4.setText("Invalid Name");
                    count=0;
                }
                else
                {
                    v4.setText("");
                    count+=1;
                }
                //-------------------------------------------condition for Last name------------------------------------------
                if(obj.Name_validation(e5.getText().toString())==false)
                {
                    v5.setText("Invalid Name");
                    count=0;
                }
                else
                {
                    v5.setText("");
                    count+=1;
                }
                //----------------------------------------------------condition for successful emplementation of condetials-------------------
                if(count==5)
                {

                    AlertDialog dlg=new AlertDialog.Builder(MainActivity.this)
                            .setMessage("Payment Successful")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create();
                    dlg.show();
                }


            }
        });
    }
}