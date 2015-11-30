package com.lucie.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.InjectView;
import butterknife.ButterKnife;

public class PushNotif extends AppCompatActivity {
//EditText badge, pin;
    //Button login, request_pin;

    @InjectView(R.id.badge_no)
    EditText badge;

    @InjectView(R.id.pin_no)
    EditText pin;

    @InjectView(R.id.login)
    Button login;

    @InjectView(R.id.request_pin)
    Button request;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notif);



    }
}
