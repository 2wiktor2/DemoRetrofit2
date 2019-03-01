package com.wiktor.demoretrofit2.Lesson2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UmoriliApi {
@GET("/api/get")
    Call<List<AnekdotModel>>getData(@Query("name")String resourceName, @Query("num") int count);
}
