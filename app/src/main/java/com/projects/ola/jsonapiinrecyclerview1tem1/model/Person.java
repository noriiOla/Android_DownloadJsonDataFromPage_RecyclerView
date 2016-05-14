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
    String Gender;
    @SerializedName("region")
    String mRegion;


    public String getGender() {
        return Gender;
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
