package org.gosky.nga.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import jonathanfinerty.once.Once;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!Once.beenDone(Once.THIS_APP_INSTALL, "introductory")) {
            Once.markDone("introductory");
            Intent intent = new Intent();
            intent.setClass(this,MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent lIntent = new Intent(this, MainActivity.class);
            startActivity(lIntent);
            finish();
        }
    }
}