package com.lucie.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.services.concurrency.AsyncTask;

public class ItemsActivity extends AppCompatActivity {
    List<ParseObject> object;
    List<String> name = new ArrayList<String>();
    List<String> price = new ArrayList<String>();
    List<String> imgUrl = new ArrayList<String>();
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        rv = (RecyclerView) findViewById(R.id.itemrecycler);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        new FetchData().execute();
    }



    private class FetchData extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Vegetables");

            try {
                object = query.find();
                for (int i=0;i<object.size();i++){
                    name.add(object.get(i).getString("name"));
                    price.add(object.get(i).getString("price"));
                    imgUrl.add(object.get(i).getString("imageUrl"));


                    Log.d("name", "" + name);
                    Log.d("ingredient", "" + price);
                    Log.d("method", "" + imgUrl);
                }
            }catch (Exception e){
                Log.e("Error", e.getMessage());
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ItemAdapter adapter = new ItemAdapter(ItemsActivity.this,name, price, imgUrl);
            rv.setAdapter(adapter);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cart_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cart) {
            Toast.makeText(this, "View cart", Toast.LENGTH_SHORT)
                    .show();
            Intent i = new Intent(getApplicationContext(),Login.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
