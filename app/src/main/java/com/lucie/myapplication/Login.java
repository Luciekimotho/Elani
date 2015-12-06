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
import com.parse.ParseException;
import com.parse.ParseUser;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import io.fabric.sdk.android.Fabric;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private static final String TWITTER_KEY = "sp0HpuB2Wgf1LbuV4couzLgp6";
    private static final String TWITTER_SECRET = "F2jROJnKT6NeR2hXKgcWllclMyXP2QJUtYn9nWAbYbuMhytxeS";
    TwitterLoginButton loginButton;
    EditText etemail, etpassword;
    Button emailloginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

        setContentView(R.layout.login);

        etemail = (EditText) findViewById(R.id.et_email);
        etpassword = (EditText) findViewById(R.id.et_password);
        emailloginbtn = (Button) findViewById(R.id.loginbtn);

        emailloginbtn.setOnClickListener(this);

        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                TwitterSession session = result.data;
                String msg = "@" + session.getUserName() + "logged in (#" + session.getUserId() + ")";
                //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

            }
            @Override
            public void failure(TwitterException e) {
                Log.d("TwitterKit", "Login with Twitter failure");

            }


        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
        Intent i = new Intent(Login.this, ItemsActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {

        ParseUser.logInInBackground(etemail.getText().toString().trim(), etpassword.getText().toString().trim(), new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser == null) {
                    ParseUser.becomeInBackground(parseUser.getSessionToken(), new LogInCallback() {
                        @Override
                        public void done(ParseUser parseUser, ParseException e) {

                        }
                    });

                    Intent i = new Intent(getBaseContext(), ItemsActivity.class);
                    startActivity(i);
                } else {
                    etemail.setText(null);
                    etpassword.setText(null);

                    Toast.makeText(getBaseContext(),
                            "Wrong username or password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
