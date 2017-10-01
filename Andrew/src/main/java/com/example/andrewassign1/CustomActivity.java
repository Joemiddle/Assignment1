// Andrew McGuire n01121995 Assignment 1
package com.example.andrewassign1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CustomActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Context context = getApplicationContext();

        RadioButton size = (RadioButton) findViewById(R.id.small);
        RadioButton nothing1 = (RadioButton) findViewById(R.id.nothing1);
        RadioButton nothing2 = (RadioButton) findViewById(R.id.nothing2);
        size.setChecked(true);
        nothing1.setChecked(true);
        nothing2.setChecked(true);

        Button order =(Button) findViewById(R.id.order);

        order.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                RadioGroup size = (RadioGroup) findViewById(R.id.size);
                RadioGroup topping1 = (RadioGroup) findViewById(R.id.Topping1);
                RadioGroup topping2 = (RadioGroup) findViewById(R.id.Topping2);

                int selectId = size.getCheckedRadioButtonId();
                Intent myIntent = new Intent(CustomActivity.this,AndrewActivity.class);

                switch(selectId)
                {
                    case R.id.small:

                        myIntent.putExtra("size",getString(R.string.small));
                        myIntent.putExtra("cost",9.99);
                        break;
                    case R.id.medium:
                        myIntent.putExtra("size",getString(R.string.medium));
                        myIntent.putExtra("cost",11.99);
                        break;
                    case R.id.large:
                        myIntent.putExtra("size",getString(R.string.large));
                        myIntent.putExtra("cost",13.99);
                        break;

                }


                selectId = topping1.getCheckedRadioButtonId();

                switch(selectId) {
                    case R.id.pepperoni:
                        myIntent.putExtra("top1", getString(R.string.pepperoni));
                        break;
                    case R.id.nothing1:
                        myIntent.putExtra("top1", getString(R.string.nothing));
                        break;

                    case R.id.sausage:
                        myIntent.putExtra("top1", getString(R.string.sausage));
                        break;

                    case R.id.extracheese:
                        myIntent.putExtra("top1", getString(R.string.extra_cheese));
                        break;

                    case R.id.greenolives:
                        myIntent.putExtra("top1", getString(R.string.green_olives));
                        break;

                    case R.id.greenpepper:
                        myIntent.putExtra("top1", getString(R.string.green_peppers));
                        break;

                    case R.id.mushroom:
                        myIntent.putExtra("top1", getString(R.string.mushrooms));
                        break;
                }

                selectId = topping2.getCheckedRadioButtonId();

                switch(selectId) {
                    case R.id.pepperoni2:
                        myIntent.putExtra("top2", getString(R.string.pepperoni));
                        break;
                    case R.id.nothing2:
                        myIntent.putExtra("top2", getString(R.string.nothing));
                        break;

                    case R.id.sausage2:
                        myIntent.putExtra("top2", getString(R.string.sausage));
                        break;

                    case R.id.extracheese2:
                        myIntent.putExtra("top2", getString(R.string.extra_cheese));
                        break;

                    case R.id.greenolives2:
                        myIntent.putExtra("top2", getString(R.string.green_olives));
                        break;

                    case R.id.greenpepper2:
                        myIntent.putExtra("top2", getString(R.string.green_peppers));
                        break;

                    case R.id.mushroom2:
                        myIntent.putExtra("top2", getString(R.string.mushrooms));
                        break;
                }

                myIntent.putExtra("activity","order");
                startActivity(myIntent);

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
                myIntent = new Intent(CustomActivity.this,AndrewActivity.class);
                myIntent.putExtra("activity","not order");
                startActivity(myIntent);
                break;

            case R.id.name:
                Toast.makeText(CustomActivity.this, getString(R.string.name),Toast.LENGTH_LONG).show();
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
