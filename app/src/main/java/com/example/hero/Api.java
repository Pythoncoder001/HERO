package com.example.hero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("all.json")
    Call<ArrayList<basic>> getAllCourses();
}
