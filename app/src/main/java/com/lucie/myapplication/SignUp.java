package com.lucie.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText etname, etemail, etpassword;
    Button signup;
    ParseUser user;

    String username, email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        etname = (EditText) findViewById(R.id.et_name);
        etemail = (EditText) findViewById(R.id.et_email);
        etpassword = (EditText) findViewById(R.id.et_password);

        signup = (Button) findViewById(R.id.sign_up_btn);
        signup.setOnClickListener(this);

        Log.d("", "name:" + username);
        Log.d("", "email:" + email);
        Log.d("", "password:" + password);

    }

    @Override
    public void onClick(View v) {

        username = etname.getText().toString();
        email = etemail.getText().toString();
        password = etpassword.getText().toString();

        user = new ParseUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        Log.d("parse","name:" +username);
        Log.d("parse","email:" +email);
        Log.d("parse","password:" +password);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    Toast.makeText(getBaseContext(),"Sign up successful",Toast.LENGTH_SHORT).show();


                    ParseUser.becomeInBackground(user.getSessionToken(), new LogInCallback() {
                        @Override
                        public void done(ParseUser parseUser, ParseException e) {

                        }
                    });

                    Intent i = new Intent(SignUp.this, ItemsActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getBaseContext(),"Sign up not successful",Toast.LENGTH_SHORT).show();
                    Log.e("parse","FAILED" + e.getMessage() + Integer.toString(e.getCode()));
                }

            }
        });
    }
}
