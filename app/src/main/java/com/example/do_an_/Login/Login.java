package com.example.do_an_.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.do_an_.MainActivity;
import com.example.do_an_.R;

public class Login extends AppCompatActivity {
    TextView username;TextView pass;TextView dangkyngay;
     Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnlogin = findViewById(R.id.loginButton);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        dangkyngay=findViewById(R.id.dangkyngay);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị nhập vào từ EditText
                String user = username.getText().toString().trim();
                String password = pass.getText().toString().trim();
        if (user.equals("") || password.equals(""))
        {
          if(user.equals(""))
          {
             Toast.makeText(Login.this, "Tài khoản không được bỏ trống !", Toast.LENGTH_SHORT).show();
          }
          else
          {
              Toast.makeText(Login.this, "Mật khẩu không được bỏ trống !", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
                // So sánh giá trị bằng .equals()
                if (user.equals("admin") && password.equals("1")) {
                    Intent manh = new Intent(Login.this, MainActivity.class);
                    startActivity(manh);
                    overridePendingTransition(R.drawable.zoom_in, R.drawable.zoom_out);

                    finish();
                } else {
                    Toast.makeText(Login.this, "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
                }
            }
            }
        });
dangkyngay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent manh = new Intent(Login.this, register.class);
        startActivity(manh); overridePendingTransition(R.drawable.zoom_in, R.drawable.zoom_out);
        finish();
    }
});

    }
}