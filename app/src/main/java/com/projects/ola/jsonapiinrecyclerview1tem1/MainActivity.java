package com.projects.ola.jsonapiinrecyclerview1tem1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glowna);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bn_loaderAct)
    public void OpenLoaderActivity(View view) {
        startActivity(new Intent(this, DataLoaderActivity.class));
    }
}
