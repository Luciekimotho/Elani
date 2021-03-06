package com.lucie.myapplication;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by lucie on 11/16/15.
 */
public class MyApplication extends Application {

    //global variables and statements can be stored here
    private static final String TWITTER_KEY = "bT8c8HIFgtkTl50ZlFrJfg9Pg";
    private static final String TWITTER_SECRET = "cHmvGVoGY4WwJ5cZqFmQq4rC5Oz8wKJhfxsybw4X7xZPbrjtZp";

    @Override
    public void onCreate() {
        super.onCreate();
        //Parse.enableLocalDatastore(this);
        Parse.initialize(this, "4r6GuVjJO85qw30CpTtEAcxRKY2xN7ividCi4yQA", "E6a1zZSV37Gs9Mv56L5ylP9cnqVcXbkTWRyFuywX");
        ParseInstallation.getCurrentInstallation().saveInBackground();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

        // Enable Local Datastore.
    }


}
