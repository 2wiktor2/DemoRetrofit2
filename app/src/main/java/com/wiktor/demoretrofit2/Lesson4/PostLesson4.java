package com.wiktor.demoretrofit2.Lesson4;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostLesson4 {

    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String text;

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return text;
    }

}
