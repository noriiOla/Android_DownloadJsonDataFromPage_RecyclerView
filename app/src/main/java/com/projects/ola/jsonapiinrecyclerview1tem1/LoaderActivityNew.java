package com.projects.ola.jsonapiinrecyclerview1tem1;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.projects.ola.jsonapiinrecyclerview1tem1.model.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoaderActivityNew extends AppCompatActivity {

    public static final int LOADER_ID = 1;
    @Bind(R.id.recycler_vieww)
    RecyclerView recycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_activity_new);
        ButterKnife.bind(this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleview.setLayoutManager(mLayoutManager);
        recycleview.setItemAnimator(new DefaultItemAnimator());
        setupLoader();
    }

    private void setupLoader() {
        getLoaderManager().initLoader(LOADER_ID, Bundle.EMPTY, new LoaderManager.LoaderCallbacks<List<Person>>() {

            @Override
            public Loader<List<Person>> onCreateLoader(int id, Bundle args) {
                return new DataAsyncTaskLoader(LoaderActivityNew.this);
            }

            @Override
            public void onLoadFinished(Loader<List<Person>> loader, List<Person> data) {
                recycleview.setAdapter(new PersonsAdapter(data));
            }

            @Override
            public void onLoaderReset(Loader<List<Person>> loader) {
            }
        });
    }
}
