package com.example.experiment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private data class TaskItem(val title: String, val done: Boolean)

private val Red = Color(0xFFD32F2F)

@Composable
fun TaskScreen() {
    val tasks = remember {
        mutableStateListOf(
            TaskItem("学习 Column 和 Row", true),
            TaskItem("学习状态管理", false),
            TaskItem("完成 Compose 实验", false)
        )
    }
    var input by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "课程学习任务",
            color = Red,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("请输入学习任务") },
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(Modifier.width(12.dp))
            Button(
                onClick = {
                    if (input.isNotBlank()) {
                        tasks.add(TaskItem(input.trim(), false))
                        input = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Red),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("添加", color = Color.White)
            }
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = "已完成: ${tasks.count { it.done }} / ${tasks.size}",
            color = Color.Gray,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(12.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            itemsIndexed(tasks) { index, task ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = task.done,
                            onCheckedChange = { checked ->
                                tasks[index] = task.copy(done = checked)
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Red,
                                uncheckedColor = Color.Gray
                            )
                        )
                        Text(
                            text = task.title,
                            modifier = Modifier.weight(1f),
                            fontSize = 15.sp,
                            textDecoration = if (task.done) TextDecoration.LineThrough else TextDecoration.None,
                            color = if (task.done) Color.Gray else Color(0xFF333333)
                        )
                        TextButton(onClick = { tasks.removeAt(index) }) {
                            Text("删除", color = Red)
                        }
                    }
                }
            }
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFAFAFA)
                ) {
                    TaskScreen()
                }
            }
        }
    }
}
