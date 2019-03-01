package com.wiktor.demoretrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wiktor.demoretrofit2.Lesson1.Lesson1Activity;
import com.wiktor.demoretrofit2.Lesson2.Lesson2Activity;
import com.wiktor.demoretrofit2.Lesson3.Lesson3Activity;
import com.wiktor.demoretrofit2.Lesson4.Lesson4Activity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
@BindView(R.id.b1)Button button1;
@BindView(R.id.b2)Button button2;
@BindView(R.id.b3)Button button3;
@BindView(R.id.b4)Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b1:
                Intent intent1 = new Intent(this, Lesson1Activity.class);
                startActivity(intent1);
                break;
            case R.id.b2:
                Intent intent2 = new Intent(this, Lesson2Activity.class);
                startActivity(intent2);
                break;
                case R.id.b3:
                Intent intent3 = new Intent(this, Lesson3Activity.class);
                startActivity(intent3);
                break;
                case R.id.b4:
                Intent intent4 = new Intent(this, Lesson4Activity.class);
                startActivity(intent4);
                break;
        }

    }
}
