package com.projects.ola.jsonapiinrecyclerview1tem1.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ola on 2016-04-27.
 */
public class Person {

    @SerializedName("name")
    String mName;
    @SerializedName("surname")
    String mSurname;
    @SerializedName("gender")
    String mGenger;
    @SerializedName("region")
    String mRegion;


    public String getGenger() {
        return mGenger;
    }

    public String getName() {
        return mName;
    }

    public String getSurname() {
        return mSurname;
    }

    public String getRegion() {
        return mRegion;
    }
}
