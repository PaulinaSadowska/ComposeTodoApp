package com.paulinasadowska.composetodoapp.todo

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composetodoapp.ui.ComposeTodoAppTheme

@Composable
fun TodoItemInput(
        onItemComplete: (TodoItem) -> Unit
) {
    val (text, setText) = remember { mutableStateOf("") }
    val (icon, setIcon) = remember { mutableStateOf(TodoIcon.Default) }
    val submit = {
        onItemComplete(TodoItem(text, icon = icon))
        setText("")
    }
    Column {
        Row(modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        ) {
            TodoInputTextField(
                    modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                    text = text,
                    onTextChange = setText,
                    onImeAction = submit
            )
            TodoEditButton(
                    onClick = submit,
                    enabled = text.isNotBlank(),
                    text = "Add",
                    modifier = Modifier.align(Alignment.CenterVertically),
            )
        }
        if (text.isNotBlank()) {
            AnimatedIconRow(icon, setIcon, Modifier.padding(top = 8.dp))
        } else {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TodoItemInputPreview() {
    ComposeTodoAppTheme {
        TodoItemInput(onItemComplete = {})
    }

}
