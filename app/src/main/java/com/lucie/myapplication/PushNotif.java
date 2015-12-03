package com.lucie.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import butterknife.InjectView;
import butterknife.ButterKnife;

public class PushNotif extends AppCompatActivity implements View.OnClickListener {
    @InjectView(R.id.badge_no)
    EditText et_badge;

    @InjectView(R.id.pin_no)
    EditText et_pin;

    @InjectView(R.id.login)
    Button login;

    @InjectView(R.id.request_pin)
    Button request;

    String badgeNumber;
    String numbers;

    List<ParseObject> obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notif);
        ButterKnife.inject(this);
        login.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        badgeNumber = et_badge.getText().toString();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
        query.whereEqualTo("BadgeNumber",badgeNumber );
        try {
            obj = query.find();
            Intent i = new Intent(PushNotif.this,ItemsActivity.class);
            startActivity(i);
        }catch (ParseException e){
            Log.e("Error", e.getMessage());
            e.printStackTrace();
            Toast.makeText(getBaseContext(),"Invalid badge number",Toast.LENGTH_SHORT);
        }
    }
}
