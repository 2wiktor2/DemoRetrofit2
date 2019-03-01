package com.wiktor.demoretrofit2.Lesson1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Link {
    // получился синхронный метод

    @GET("/users/{user}/repos")
        // такой результат нужно получить в конце.   конечная точка.
    Call<List<PojoLesson1>> anyData(@Path("user") String user);
}
