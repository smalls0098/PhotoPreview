package com.wgw.photopreview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wgw.photo.preview.IndicatorType;
import com.wgw.photo.preview.PhotoPreview;

import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Main2Activity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        
        final RecyclerView recyclerView = findViewById(R.id.rv);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        final PhotoAdapter adapter = new PhotoAdapter(Arrays.asList(MainActivity.picDataMore));
        recyclerView.setAdapter(adapter);
        
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            final ImageView imageView = view.findViewById(R.id.itemIv);
            
            PhotoPreview.with(Main2Activity.this)
                .indicatorType(IndicatorType.DOT)
                .selectIndicatorColor(0xffEE3E3E)
                .normalIndicatorColor(0xff3954A0)
                .delayShowProgressTime(200)
                .imageLoader((position1, url, imageView1) ->
                    Glide.with(Main2Activity.this)
                        .load(((String) url))
                        .placeholder(position == position1 ? imageView.getDrawable() : null)
                        .into(imageView1))
                .onDismissListener(() -> Toast.makeText(Main2Activity.this, "界面关闭", Toast.LENGTH_SHORT).show())
                .sources(Arrays.asList(MainActivity.picDataMore))
                .defaultShowPosition(position)
                .build()
                .show(layoutManager :: findViewByPosition);
        });
    }
}
