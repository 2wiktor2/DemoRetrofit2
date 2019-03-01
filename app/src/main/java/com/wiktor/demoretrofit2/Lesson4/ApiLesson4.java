package com.wiktor.demoretrofit2.Lesson4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiLesson4 {
    @GET("posts")
    Call<List<PostLesson4>> getPosts2();
}
