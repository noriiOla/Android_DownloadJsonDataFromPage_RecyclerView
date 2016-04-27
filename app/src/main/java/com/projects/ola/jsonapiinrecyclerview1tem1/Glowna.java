package com.projects.ola.jsonapiinrecyclerview1tem1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Glowna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glowna);
    }

    public void OpenLoaderActivity(View view) {
        startActivity(new Intent(this, LoaderActivity.class));
    }
}
