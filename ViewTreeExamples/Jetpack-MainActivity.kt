package com.demo.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.myapplication.ui.theme.MyApplicationTheme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    // textVisible 状态能影响 Text 组件是否被渲染
    var textVisible by remember { mutableStateOf(true) }
    // textContent 状态影响绑定到该状态的组件的显示内容
    var textContent by remember { mutableStateOf("Hello World!") }

    Column() {
        if (textVisible) {
            Text(
                // 将自身显示内容绑定到 textContent 状态
                text = textContent,
                fontSize = 18.sp
            )
        }

        Row {
            Button(
                // 点击按钮时，修改 textVisible 状态的值为 false，引擎会重新渲染组件树，去除 Text 组件
                onClick = { textVisible = false },
            ) {
                Text("Button 1")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                // 点击按钮时，修改 textContent 状态的值为 "Button 2 clicked"，新的UI状态的值导致引擎重新渲染组件树
                // 与命令式编程不同，onClick并不直接访问View Tree，而是把复杂性交给引擎，由引擎处理状态变更
                // 因而 textVisible 状态的值为 false时，正确实现的引擎会判断到Text不再存在，不应将 textContent的值设置到该View，所以不会导致程序崩溃
                onClick = { textContent = "Button 2 clicked" },
            ) {
                Text("Button 2")
            }
        }
    }
}
