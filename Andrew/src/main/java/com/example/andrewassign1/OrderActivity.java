// Andrew McGuire n01121995 Assignment 1
package com.example.andrewassign1;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.x;

public class OrderActivity extends AppCompatActivity {

    public Item items[];
    public int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent  = getIntent();

        count = intent.getIntExtra("count",0);
        items = new Item[5];
        items =(Item[]) intent.getSerializableExtra("items");

        Context context = this.getApplicationContext();

//        LinearLayout layout = (LinearLayout)findViewById(R.id.items);
//
//        TextView newText;
//        Button delete;
//
//        try {
//            for (int x = 0; x < count; x++) {
//
//                LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(
//                        ActionBar.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//                newText = new TextView(getApplicationContext());
//                newText.setLayoutParams(params);
//                newText.setText(items[x].getItemName());
//                delete = new Button(getApplicationContext());
//
//                delete.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        items[count] = items[items.length];
//                    }
//                });
//            }
//            int total = 0;
//            for(int x=0;x<count;x++)
//            {
//                total += items[x].getCost();
//            }
//                TextView tv = new TextView(context);
//                tv.setText(total);
//                layout.addView(tv);
//
//        }catch(Exception e)
//            {
//                Log.d("d", "Deleted only element");
//            }
//
//
        Button checkout = (Button) findViewById(R.id.checkout);

        checkout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(OrderActivity.this,AndrewActivity.class);
                myIntent = new Intent(OrderActivity.this,CheckoutActivity.class);
                myIntent.putExtra("activity","not order");
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
                myIntent = new Intent(OrderActivity.this,AndrewActivity.class);
                myIntent.putExtra("activity","not order");
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
