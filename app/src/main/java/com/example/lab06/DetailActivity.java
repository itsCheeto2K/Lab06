package com.example.lab06;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivDetailImage;
    private TextView tvDetailTitle;
    private TextView tvDetailView;
    private TextView tvDetailContent;

    // Ve giao dien activity_detail.xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivDetailImage = findViewById(R.id.ivDetailImage);
        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        tvDetailContent = findViewById(R.id.tvDetailContent);
        tvDetailView = findViewById(R.id.tvDetailView);

        Article article = (Article) getIntent().getSerializableExtra("article_key");

        if (article != null) {
            tvDetailTitle.setText(article.getTitle());
            tvDetailView.setText("Views: " + article.getViewCount());
            tvDetailContent.setText(article.getContent());
            ivDetailImage.setImageResource(article.getImgCover());
        }

        // Nut back Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Chi tiết bài viết");
        }
    }

    // Dong man hinh ve MainActivity
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
