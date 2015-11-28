package com.lucie.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.Toast;

public class Cartactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cartactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);
        np.setMinValue(1);
        np.setMaxValue(20);
        np.setFocusable(true);
        np.setFocusableInTouchMode(true);


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
            Toast.makeText(this, "Your shopping cart is empty", Toast.LENGTH_SHORT)
                    .show();
            Intent i = new Intent(getApplicationContext(),Cartactivity.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}
