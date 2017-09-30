package com.example.andrewassign1;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent  = getIntent();

        int count = intent.getIntExtra("count",0);
        Item items[] = new Item[5];
        items =(Item[]) intent.getSerializableExtra("items");

        for(;count < items.length;count++)
        {

        }



        LinearLayout layout = (LinearLayout)findViewById(R.id.items);



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
                myIntent = new Intent(OrderActivity.this,AndrewActivity.class);
                startActivity(myIntent);
                break;

            case R.id.name:
                Toast.makeText(OrderActivity.this, getString(R.string.name),Toast.LENGTH_LONG).show();
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
