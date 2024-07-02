package com.example.dynamicgeneratedview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 创建主LinearLayout(竖向)
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mainLayout.setPadding(16, 16, 16, 16);

        // 创建TextView
        TextView textView = new TextView(this);
        textView.setId(View.generateViewId());
        textView.setText("Hello World!");
        textView.setTextSize(18);
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewParams.gravity = android.view.Gravity.CENTER_HORIZONTAL;
        textViewParams.setMargins(0, 0, 0, 20);
        textView.setLayoutParams(textViewParams);
        // 将TextView添加到主LinearLayout
        mainLayout.addView(textView);

        // 创建内嵌的LinearLayout(横向，包含两个按钮)
        LinearLayout innerLayout = new LinearLayout(this);
        innerLayout.setOrientation(LinearLayout.HORIZONTAL);
        innerLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        innerLayout.setGravity(android.view.Gravity.CENTER);

        // 创建Button1
        Button button1 = new Button(this);
        button1.setId(View.generateViewId());
        button1.setText("Button 1");
        LinearLayout.LayoutParams button1Params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button1Params.setMarginEnd(10);
        button1.setLayoutParams(button1Params);
        // 添加Button1到内嵌LinearLayout
        innerLayout.addView(button1);

        // 创建Button2
        Button button2 = new Button(this);
        button2.setId(View.generateViewId());
        button2.setText("Button 2");
        // 添加Button2到内嵌LinearLayout
        innerLayout.addView(button2);

        // 将内嵌LinearLayout添加到主LinearLayout
        mainLayout.addView(innerLayout);

        // 设置主LinearLayout作为Activity的内容视图
        setContentView(mainLayout);
    }
}