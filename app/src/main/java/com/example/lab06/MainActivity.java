package com.example.lab06;

import android.os.Bundle;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;
    private List<Article> articleList;

    private void initData() {
        articleList.add(new Article(
                "Khi Developer bảo test kỹ lắm rồi, không có bug đâu",
                "Hôm nay trải nghiệm quả giao diện nhận mã OTP đỉnh cao của công nghệ 4.0 anh em ạ",
                R.drawable.img01,
                0
        ));

        articleList.add(new Article(
                "Đề thi bằng lái xe hạng \"Vô cực\"",
                "Thi lý thuyết bằng lái gặp đúng câu này thì chỉ biết chắp tay lạy thầy.",
                R.drawable.img02,
                0
        ));

        articleList.add(new Article(
                "Bữa ăn chuẩn 5 sao tại gia",
                "Góc học tập thì đầy mỹ phẩm với hộp đồ, nhưng đồ ăn thì không thể xơ xát được.\n" +
                        "Cơm trắng đầy ắp, gà rán vàng ươm, thìa mạ vàng chuẩn style hoàng gia! Ăn xong làm ngụm canh rồi ngồi học bài là vừa đẹp.",
                R.drawable.img03,
                0
        ));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initData();

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        articleAdapter = new ArticleAdapter(this, articleList, new ArticleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Article article, int position) {
                article.increaseView();

                articleAdapter.notifyItemChanged(position);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("article_key", article);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(articleAdapter);
    }
}