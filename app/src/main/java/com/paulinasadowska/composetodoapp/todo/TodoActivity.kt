package com.paulinasadowska.composetodoapp.todo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.paulinasadowska.composetodoapp.ui.ComposeTodoAppTheme

class TodoActivity : AppCompatActivity() {

    val todoViewModel by viewModels<TodoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTodoAppTheme {
                Surface {
                    HelloExample()
                }
            }
        }
    }
}

@Composable
fun HelloExample() {
    Column {
        val (text, setText) = remember { mutableStateOf("type something") }
        Text(text)
        TextField(
                value = text,
                onValueChange = { setText(it) })
    }

}

@Preview
@Composable
fun HelloExamplePreview() {
    ComposeTodoAppTheme {
        HelloExample()
    }
}