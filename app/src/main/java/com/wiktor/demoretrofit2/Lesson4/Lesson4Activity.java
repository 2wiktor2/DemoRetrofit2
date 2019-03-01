package com.wiktor.demoretrofit2.Lesson4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wiktor.demoretrofit2.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Lesson4Activity extends AppCompatActivity {
    private TextView textViewResultLesson4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4);

        textViewResultLesson4 = findViewById(R.id.text_view_result_lesson4);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiLesson4 apiLesson4 = retrofit.create(ApiLesson4.class);

        Call <List <PostLesson4>> call = apiLesson4.getPosts2();
        call.enqueue(new Callback <List <PostLesson4>>() {
            @Override
            public void onResponse(Call <List <PostLesson4>> call, Response <List <PostLesson4>> response) {
                if (!response.isSuccessful()) {
                    textViewResultLesson4.setText("Code: " + response.code());
                    return;
                }
                List <PostLesson4> posts = response.body();
                for (PostLesson4 post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "UserId: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getBody() + "\n\n";

                    textViewResultLesson4.append(content);
                }
            }

            @Override
            public void onFailure(Call <List <PostLesson4>> call, Throwable t) {
                textViewResultLesson4.setText(t.getMessage());
            }
        });

    }
}