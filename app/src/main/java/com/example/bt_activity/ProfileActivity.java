package com.example.bt_activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageButton btnBack, btnSettings;
    private TextView tvProfileName, tvFollowers, tvFollowing;
    private TextView tvEmail, tvPhone, tvSkype, tvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Khởi tạo views
        initViews();

        // Nhận dữ liệu từ Intent
        String username = getIntent().getStringExtra("USERNAME");
        if (username != null) {
            tvProfileName.setText(username);
        }

        // Hiển thị thông tin profile mẫu
        displayProfileInfo();

        // Xử lý sự kiện nút Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Quay lại màn hình trước
            }
        });

        // Xử lý sự kiện nút Settings
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this,
                        "Chức năng Settings đang phát triển",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        btnBack = findViewById(R.id.btnBack);
        btnSettings = findViewById(R.id.btnSettings);
        tvProfileName = findViewById(R.id.tvProfileName);
        tvFollowers = findViewById(R.id.tvFollowers);
        tvFollowing = findViewById(R.id.tvFollowing);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvSkype = findViewById(R.id.tvSkype);
        tvWeb = findViewById(R.id.tvWeb);
    }

    private void displayProfileInfo() {
        // Dữ liệu mẫu
        tvFollowers.setText("125");
        tvFollowing.setText("250");
        tvEmail.setText("mail@email.com");
        tvPhone.setText("+99 999 555 222");
        tvSkype.setText("me@123");
        tvWeb.setText("cssauthor.com/");
    }
}
