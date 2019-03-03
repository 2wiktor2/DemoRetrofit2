package com.wiktor.demoretrofit2.Lesson4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wiktor.demoretrofit2.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Lesson4Activity extends AppCompatActivity {
    @BindView(R.id.text_view_result_lesson4)
    TextView textViewResultLesson4;
    private ApiLesson4 apiLesson4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4);
        ButterKnife.bind(this);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiLesson4 = retrofit.create(ApiLesson4.class);

//          getPosts();
        getComments();
    }

    private void getPosts() {
        Map<String, String> parameters = new HashMap <>();
        parameters.put("userId","1");
        parameters.put("userId","2");
        parameters.put("_sort","id");
        parameters.put("_order","desc");

        Call <List <PostLesson4>> call = apiLesson4.getPosts2(parameters);
        // Если не нужно оиспользовать параметры

        //@Query("userId") int userId - ввод числа
        //@Query("userId") Integer userId - если нцжно вместо числа поставить null
       // Call <List <PostLesson4>> call = apiLesson4.getPosts2(null,null,null);
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

    private void getComments() {
        //Call <List <Comment>> call = apiLesson4.getComments(3);
        Call <List <Comment>> call = apiLesson4.getComments("posts/3/comments");
        call.enqueue(new Callback <List <Comment>>() {
            @Override
            public void onResponse(Call <List <Comment>> call, Response <List <Comment>> response) {
                if (!response.isSuccessful()) {
                    textViewResultLesson4.setText("Code: "+ response.code());
                    return;
                }
                List<Comment> comments = response.body();
                for (Comment comment : comments){
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "PostId: " + comment.getPostId() + "\n";
                    content += "Name: " + comment.getName() + "\n";
                    content += "Text: " + comment.getText() + "\n\n";

                    textViewResultLesson4.append(content);
                }
            }
            @Override
            public void onFailure(Call <List <Comment>> call, Throwable t) {
                textViewResultLesson4.setText(t.getMessage());
            }
        });
    }
}