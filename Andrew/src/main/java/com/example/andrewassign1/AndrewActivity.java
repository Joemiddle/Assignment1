// Andrew McGuire n01121995 Assignment 1
package com.example.andrewassign1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AndrewActivity extends AppCompatActivity {

    private Button regular;
    private Button deluxe;
    private Button wings;
    private Button special;
    private Button drinks;
    private Button finalorder;
    public Item[] items;
    public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andrew);
        // Item array is only 5 because most people don't order much more than that, plus the order is going to need to fit into the layout
        items = new Item[5];
        count = 0;

        regular =(Button)findViewById(R.id.regularButton);
        deluxe =(Button)findViewById(R.id.deluxButton);
        wings =(Button)findViewById(R.id.wingsButton);
        special =(Button)findViewById(R.id.specialButton);
        drinks=(Button)findViewById(R.id.drinksButton);
        finalorder = (Button) findViewById(R.id.final_order);


        //Adding all the button funcitonality
        regular.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent = new Intent(AndrewActivity.this,CustomActivity.class);
                startActivity(myIntent);
            }
        });

        finalorder.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent = new Intent(AndrewActivity.this,OrderActivity.class);
                myIntent.putExtra("activity",items);
                myIntent.putExtra("count",count);
                startActivity(myIntent);
            }
        });

        deluxe.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (count < 5)
                {
                Pizza pizza = new Pizza(getString(R.string.Deluxe),13.99,getString(R.string.mushrooms),getString(R.string.black_olives),getString(R.string.medium));
                items[count] = pizza;
                count++;

                    Toast.makeText(AndrewActivity.this,items[count-1].getItemName()+ " " + getString(R.string.ordered),Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(AndrewActivity.this, R.string.error_item,Toast.LENGTH_LONG).show();
                }
            }
        });

        wings.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                if (count < 5)
                {
                    Item pizza = new Item(getString(R.string.Wings),13.99);
                    items[count] = pizza;
                    count++;

                    Toast.makeText(AndrewActivity.this,items[count-1].getItemName()+ " " + getString(R.string.ordered),Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(AndrewActivity.this, R.string.error_item,Toast.LENGTH_LONG).show();
                }

            }
        });

        special.setOnClickListener(new View.OnClickListener()
        {

                public void onClick(View v)
                {
                    if (count < 5)
                    {
                        Pizza pizza = new Pizza(getString(R.string.deal),15.99,getString(R.string.mushrooms),getString(R.string.anchovie),getString(R.string.large));
                        items[count] = pizza;
                        count++;
                        Toast.makeText(AndrewActivity.this,items[count-1].getItemName()+ " " + getString(R.string.ordered),Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(AndrewActivity.this, R.string.error_item,Toast.LENGTH_LONG).show();
                    }
                }

        });

        drinks.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                if (count < 5)
                {
                    Item drink = new Item(getString(R.string.coke),13.99);
                    items[count] = drink;
                    count++;

                    Toast.makeText(AndrewActivity.this,items[count-1].getItemName()+ " " + getString(R.string.ordered),Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(AndrewActivity.this, R.string.error_item,Toast.LENGTH_LONG).show();
                }
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    // Populating Menu
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    // onResume is for when the app gets back to this activity and so it can add a new item to the order
    @Override
    protected void onResume()
    {
        super.onResume();
        try {
            if (count < 5) {


                Intent intent = getIntent();

                // need to make sure program came from a new order and not anywhere else
                if(intent.getStringExtra("activity").compareTo("order") == 0)
                {
                    String size = intent.getStringExtra("size");
                    double cost = intent.getDoubleExtra("cost", 0);
                    String top1 = intent.getStringExtra("top1");
                    String top2 = intent.getStringExtra("top2");
                    Pizza pizza = new Pizza(getResources().getString(R.string.regular), cost, top1, top2, size);
                    items[count] = pizza;
                    count++;
                    Toast.makeText(AndrewActivity.this, items[count - 1].getItemName() + " " + getString(R.string.ordered), Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(AndrewActivity.this, R.string.error_item,Toast.LENGTH_LONG).show();
            }
        }

        catch(Exception e)
        {
            Log.d("d","didn't come here from custom");
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){

        Intent myIntent;
        switch(item.getItemId())
        {
            case R.id.Home:
                myIntent = new Intent(AndrewActivity.this,AndrewActivity.class);
                myIntent.putExtra("activity","not order");
                startActivity(myIntent);
                break;

            case R.id.name:
                Toast.makeText(AndrewActivity.this, getString(R.string.name),Toast.LENGTH_LONG).show();
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


