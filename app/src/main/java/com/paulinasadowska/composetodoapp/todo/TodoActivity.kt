package com.paulinasadowska.composetodoapp.todo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import com.paulinasadowska.composetodoapp.ui.ComposeTodoAppTheme

class TodoActivity : AppCompatActivity() {

    private val todoViewModel by viewModels<TodoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTodoAppTheme {
                Surface {
                    TodoActivityScreen(viewModel = todoViewModel)
                }
            }
        }
    }
}
