package com.wiktor.demoretrofit2.Lesson1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.wiktor.demoretrofit2.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Lesson1Activity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);
        listView = findViewById(R.id.pagination_list);







        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Link client = retrofit.create(Link.class);

        Call<List<PojoLesson1>> call = client.anyData("2wiktor2");
        call.enqueue(new Callback<List <PojoLesson1>>() {
            @Override
            public void onResponse(Call <List <PojoLesson1>> call, Response<List <PojoLesson1>> response) {
                List<PojoLesson1> repos = response.body();
                //GitHubRepoAdapter adapter = new GitHubRepoAdapter(MainActivity.this,  repos);
                listView.setAdapter(new Adapter(Lesson1Activity.this,  repos));
            }

            @Override
            public void onFailure(Call <List <PojoLesson1>> call, Throwable t) {
                Toast.makeText(Lesson1Activity.this, "Что-то не так с интернетом", Toast.LENGTH_SHORT).show();
            }
        });




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {

            }
        });
    }

}
