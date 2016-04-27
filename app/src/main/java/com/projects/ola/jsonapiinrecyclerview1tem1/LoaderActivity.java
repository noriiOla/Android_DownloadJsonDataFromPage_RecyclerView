package com.projects.ola.jsonapiinrecyclerview1tem1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.projects.ola.jsonapiinrecyclerview1tem1.ioutil.IOUtil;
import com.projects.ola.jsonapiinrecyclerview1tem1.model.Person;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoaderActivity extends AppCompatActivity {

    @Bind(R.id.recycler_view)
    RecyclerView recycleview;
    List<Person> mPersonList;
    PersonsAdapter personsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        ButterKnife.bind(this);
        mPersonList=new ArrayList<>();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleview.setLayoutManager(mLayoutManager);
        recycleview.setItemAnimator(new DefaultItemAnimator());
        personsAdapter = new PersonsAdapter(mPersonList);
        recycleview.setAdapter(personsAdapter);
        new DownloadJsonTask().execute("http://uinames.com/api/?amount=3");
    }

    public class DownloadJsonTask extends AsyncTask<String, Void, List<Person>> {

        @Override
        protected List<Person> doInBackground(String... urls) {
            return getJsonFromUrl(urls[0]);
        }

        private List<Person> getJsonFromUrl(String apiUrl) {
            String jsonText;
            List<Person> persons = new ArrayList<Person>();
            try {
                URLConnection urlConnection = new URL(apiUrl).openConnection();
                jsonText = IOUtil.getStringFromInputStream(urlConnection.getInputStream());
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Person>>() {
                }.getType();
                persons = gson.fromJson(jsonText,
                        listType);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return persons;
        }

        @Override
        protected void onPostExecute(List<Person> data) {
           recycleview.setAdapter(new PersonsAdapter(data));
        }
    }
}
