package com.lzm.showgirls;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(loadUrl(), MainActivity.this));

    }

    /**
     * zhisdssadadsdasad
     * @return
     */

    List<String> loadUrl() {
        List<String> mList = new ArrayList<>();
        String baseUrl = "http://i.meizitu.net/2016/09/12a";
        String url = "";
        for (int i = 1; i < 40; i++) {
            if (i < 10) {
                url = baseUrl + "0" + i + ".jpg";
            } else {
                url = baseUrl + i + ".jpg";
            }
            mList.add(url);
        }

        return mList;
    }

}
