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
    private boolean preferenceA = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        // 根据preferenceA来移除或保留TextView
        if (preferenceA) {
            TextView textView = findViewById(R.id.textView);
            ((ViewGroup) textView.getParent()).removeView(textView);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preferenceA) {
                    // preferenceA为true时，改变按钮颜色
                    button1.setBackgroundColor(getResources().getColor(R.color.black));
                    button2.setBackgroundColor(getResources().getColor(R.color.black));
                }
//                else
//                {
                    // BUG: 忘记使用else分支，当preferenceA为true时textView已经被移除，findViewById会返回null，会导致程序崩溃
                    TextView textView = findViewById(R.id.textView);
                    textView.setText("Button 1 clicked");
//                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preferenceA)
                {
                    // preferenceA为true时，改变按钮颜色
                    button2.setBackgroundColor(getResources().getColor(R.color.white));
                    button1.setBackgroundColor(getResources().getColor(R.color.white));
                }
//                else
//                {
                    // BUG: 忘记使用else分支，当preferenceA为true时textView已经被移除，findViewById会返回null，会导致程序崩溃
                    TextView textView = findViewById(R.id.textView);
                    textView.setText("Button 2 clicked");
//                }
            }
        });
    }
}
