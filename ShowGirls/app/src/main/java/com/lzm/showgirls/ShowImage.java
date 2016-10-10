package com.lzm.showgirls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ShowImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AnimationUtils.receiveTransitionImage(ShowImage.this, "myview");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        String url = getIntent().getStringExtra("image_url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Picasso.with(this).load(url).into(imageView);

    }
}
