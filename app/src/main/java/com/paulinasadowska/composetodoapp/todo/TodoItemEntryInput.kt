package com.paulinasadowska.composetodoapp.todo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TodoItemEntryInput(
        onItemComplete: (TodoItem) -> Unit
) {
    val (text, setText) = remember { mutableStateOf("") }
    val (icon, setIcon) = remember { mutableStateOf(TodoIcon.Default) }
    val submit = {
        onItemComplete(TodoItem(text, icon = icon))
        setText("")
    }
    TodoItemInput(text, setText, submit, icon, setIcon){
        TodoEditButton(
                onClick = submit,
                enabled = text.isNotBlank(),
                text = "Add",
        )
    }
}
