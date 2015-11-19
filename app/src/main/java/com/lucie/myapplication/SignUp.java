package com.lucie.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*   query.getInBackground("zArr16XgUj", new GetCallback<ParseObject>() {
                @Override
                public void done(ParseObject object, ParseException e) {
                    if (e == null) {
                        Log.d("parse", "success");

                        String name = object.getString("name");
                        String price = object.getString("price");
                        String imageUrl = object.getString("imageUrl");

                        Log.d("name", "" + name);
                        Log.d("ingredient", "" + price);
                        Log.d("method", "" + imageUrl);
                    } else {
                        Log.d("parse", "fail");
                    }
                }
            });*/

    }

}
