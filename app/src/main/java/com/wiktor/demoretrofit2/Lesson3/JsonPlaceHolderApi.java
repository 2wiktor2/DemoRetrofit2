package com.wiktor.demoretrofit2.Lesson3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("posts")
    Call <List <Post>> getPosts();
}
