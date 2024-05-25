package com.demo.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2;
    // 假设preferenceA已经被设置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 根据preferenceA来移除或保留TextView
                TextView textView = findViewById(R.id.textView);
                ((ViewGroup) textView.getParent()).removeView(textView);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // BUG: 忘记使用else分支，当preferenceA为true时textView已经被移除，findViewById会返回null，会导致程序崩溃
                TextView textView = findViewById(R.id.textView);
                textView.setText("Button 2 clicked");
            }
        });
    }
}
