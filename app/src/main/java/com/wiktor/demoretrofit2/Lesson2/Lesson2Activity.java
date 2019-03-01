package com.wiktor.demoretrofit2.Lesson2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.wiktor.demoretrofit2.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Lesson2Activity extends AppCompatActivity {
    private static UmoriliApi umoriliApi;
    RecyclerView recyclerView;
    List <AnekdotModel> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);


        umoriliApi = Controller.getApi();
        posts = new ArrayList <>();


        //recyclerView
        recyclerView = findViewById(R.id.recycler_view_lesson_2);
        //создать и Назначить LayoutManager для recyclerView:
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //Здесь же назначить adapter  recyclerView.
        RecyclerViewPostsAdapter recyclerAdapter = new RecyclerViewPostsAdapter(posts);
        recyclerView.setAdapter(recyclerAdapter);


        umoriliApi.getData("new anekdot", 50).enqueue(new Callback<List<AnekdotModel>>() {
            @Override
            public void onResponse(Call<List<AnekdotModel>> call, Response<List<AnekdotModel>> response) {
                posts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AnekdotModel>> call, Throwable t) {
                Toast.makeText(Lesson2Activity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
