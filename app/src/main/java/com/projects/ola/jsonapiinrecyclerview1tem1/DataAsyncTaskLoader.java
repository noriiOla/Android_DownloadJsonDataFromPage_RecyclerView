package com.projects.ola.jsonapiinrecyclerview1tem1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.projects.ola.jsonapiinrecyclerview1tem1.ioutil.IOUtil;
import com.projects.ola.jsonapiinrecyclerview1tem1.model.Person;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ola on 2016-04-28.
 */
public class DataAsyncTaskLoader extends AsyncTaskLoader<List<Person>> {

    private List<Person> persons;
    String apiUrl;

    public DataAsyncTaskLoader(Context context) {
        super(context);
        apiUrl="http://uinames.com/api/?amount=3";
    }

    @Override
    protected void onStartLoading() {
        if(persons != null) {
            deliverResult(persons);
        } else {
            forceLoad();
        }
    }

    @Override
    public List<Person> loadInBackground() {
       // String jsonText="";
       List<Person> downloadedData = new ArrayList<>();
        try {
            URLConnection urlConnection = null;
            urlConnection = new URL(apiUrl).openConnection();
          //  jsonText = IOUtil.getStringFromInputStream(urlConnection.getInputStream());
            JsonReader reader = new JsonReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Person>>() {
            }.getType();
           // downloadedData = gson.fromJson(jsonText, listType);
            downloadedData = gson.fromJson(reader, listType);
            return downloadedData;
        } catch (IOException e) {
        e.printStackTrace();
    }
        return downloadedData;
    }

    @Override
    public void deliverResult(List<Person> data) {
        persons = data;
        super.deliverResult(data);
    }
}
