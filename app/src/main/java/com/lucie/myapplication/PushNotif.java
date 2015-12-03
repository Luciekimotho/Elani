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

        ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
        try {
            obj = query.find();
        }catch (ParseException e){
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        for (int i = 0; i < obj.size(); i++){
            //Log.d("badge number", ""+obj.get(i).getString("BadgeNumber"));
            numbers = obj.get(i).getString("BadgeNumber");
            Log.d("Badge numbers", numbers);
        }


    }

    @Override
    public void onClick(View v) {
        badgeNumber = et_badge.getText().toString();
        //Log.d("badge", "number:"+badgeNumber);
        if (badgeNumber.equals(numbers)){
            Intent i = new Intent(PushNotif.this,ItemsActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(getBaseContext(),"Invalid badge number",Toast.LENGTH_SHORT);
        }
    }
}
