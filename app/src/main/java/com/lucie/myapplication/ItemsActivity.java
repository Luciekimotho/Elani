package com.lucie.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

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
}
