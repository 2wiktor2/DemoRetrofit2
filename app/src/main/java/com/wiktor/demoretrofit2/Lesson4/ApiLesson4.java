package com.wiktor.demoretrofit2.Lesson4;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiLesson4 {

    //https://jsonplaceholder.typicode.com/posts

    /*    @GET("posts")
        Call<List<PostLesson4>> getPosts2();*/


    //https://jsonplaceholder.typicode.com/posts?userId=1

   /* @GET("posts")
    Call <List <PostLesson4>> getPosts2(@Query("userId") int userId);*/


    //https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desk


    //https://jsonplaceholder.typicode.com/posts?userId=1&userId=4&_sort=id&_order=desk
    @GET("posts")
    Call <List <PostLesson4>> getPosts2
    (@Query("userId") Integer userId,
     //@Query("userId") Integer userId2, // добавить в параметры второго пользователя
     // @Query("userId") Integer[] userId2, // добавлять несколько пользователей в виде массива
     @Query("_sort") String sort,
     @Query("_order") String order
    );


    //@QueryMap
    @GET("posts")
    Call <List <PostLesson4>> getPosts2(@QueryMap Map <String, String> parameters);



/*    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments (@Path("id") int postId);*/

    @GET("posts/{id}/comments")
    Call <List <Comment>> getComments(@Path("id") int postId);

    @GET
    Call <List <Comment>> getComments(@Url String url);
}
