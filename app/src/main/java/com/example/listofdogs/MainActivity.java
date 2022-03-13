package com.example.listofdogs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int min = 100;
        Random rand = new Random();
        ArrayList<URL> cats = new ArrayList<>();
        for (int i  = 0; i < 400; i++){
            int temp;
            temp = rand.nextInt(500) + min;
            try {
                URL newURL = new URL("https://http.cat/" + temp);
                System.out.println(newURL);
                cats.add(newURL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
        RecyclerView DogsView = findViewById(R.id.DogsView);
        ClassLayoutAdapter adapter = new ClassLayoutAdapter();
        adapter.setData(cats);
        DogsView.setLayoutManager(new LinearLayoutManager(this));
        DogsView.setAdapter(adapter);
    }
}