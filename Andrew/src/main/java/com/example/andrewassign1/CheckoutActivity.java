// Andrew McGuire n01121995 Assignment 1
package com.example.andrewassign1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner title = (Spinner) findViewById(R.id.title);

        List<String> list = new ArrayList<String>();
        list.add(getString(R.string.notitle));
        list.add(getString(R.string.mr));
        list.add(getString(R.string.ms));
        list.add(getString(R.string.doc));

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        title.setAdapter(dataAdapter);


        Spinner province = (Spinner) findViewById(R.id.province);

        // adding the provinces strings
        List<String> list2 = new ArrayList<String>();
        list2.add(getString(R.string.on));
        list2.add(getString(R.string.qb));
        list2.add(getString(R.string.ab));
        list2.add(getString(R.string.sa));

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list2);

        dataAdapter2.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        province.setAdapter(dataAdapter2);


        Button confirm = (Button) findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                EditText name = (EditText) findViewById(R.id.clientname);
                EditText city = (EditText) findViewById(R.id.city);
                EditText cardnum = (EditText) findViewById(R.id.cardnumber);
                EditText cvc = (EditText) findViewById(R.id.cvc);


                String ed_text = name.getText().toString();

                if(!ed_text.isEmpty())
                    ed_text.trim();


                if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
                {
                    //EditText is empty
                    Toast.makeText(CheckoutActivity.this,getString(R.string.entername),Toast.LENGTH_LONG).show();
                }
                else
                {
                    ed_text = city.getText().toString().trim();
                    if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
                    {
                        //EditText is empty
                        Toast.makeText(CheckoutActivity.this,getString(R.string.entercity),Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        ed_text = cardnum.getText().toString().trim();
                        if(ed_text.isEmpty() || ed_text.length() < 16 || ed_text.equals("") || ed_text == null)
                        {
                            //EditText is empty
                            Toast.makeText(CheckoutActivity.this,getString(R.string.enternum),Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            ed_text = cvc.getText().toString().trim();

                            if(ed_text.isEmpty() || ed_text.length() < 3 || ed_text.equals("") || ed_text == null)
                            {
                                //EditText is empty
                                Toast.makeText(CheckoutActivity.this,getString(R.string.entercvc),Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(CheckoutActivity.this,getString(R.string.finalO),Toast.LENGTH_LONG).show();

                            }


                        }

                    }

                }
            }
        });

    }

    // Populating Menu
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;


    }

    // Used to Create Menu
    public boolean onOptionsItemSelected(MenuItem item){

        Intent myIntent;
        switch(item.getItemId())
        {
            case R.id.Home:
                myIntent = new Intent(CheckoutActivity.this,AndrewActivity.class);
                startActivity(myIntent);
                break;

            case R.id.name:
                Toast.makeText(CheckoutActivity.this, getString(R.string.name),Toast.LENGTH_LONG).show();
                break;

            case R.id.Pizza:
                myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ginopizza.ca"));
                startActivity(myIntent);
                break;

            case R.id.help:
                myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.ca"));
                startActivity(myIntent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
