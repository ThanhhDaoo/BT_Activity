package com.example.bt_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private TextView tvLostPassword;

    // Dữ liệu mẫu để kiểm tra
    private static final String DEMO_USERNAME = "admin";
    private static final String DEMO_PASSWORD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các view
        initViews();

        // Xử lý sự kiện click button Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        // Xử lý sự kiện click Lost Password
        tvLostPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Chức năng đang phát triển",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvLostPassword = findViewById(R.id.tvLostPassword);
    }

    private void handleLogin() {
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        // Kiểm tra rỗng
        if (username.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập username",
                    Toast.LENGTH_SHORT).show();
            edtUsername.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập password",
                    Toast.LENGTH_SHORT).show();
            edtPassword.requestFocus();
            return;
        }

        // Kiểm tra thông tin đăng nhập
        if (username.equals(DEMO_USERNAME) && password.equals(DEMO_PASSWORD)) {
            // Đăng nhập thành công
            Toast.makeText(this, "Đăng nhập thành công!",
                    Toast.LENGTH_SHORT).show();

            // Chuyển sang màn hình Profile
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);

        } else {
            // Đăng nhập thất bại
            Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}