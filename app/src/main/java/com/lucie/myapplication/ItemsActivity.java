package com.lucie.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemsActivity extends AppCompatActivity {

    private List<Item> itemList =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rv = (RecyclerView) findViewById(R.id.itemrecycler);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(),itemList);
        rv.setAdapter(itemAdapter);
    }

}
