package com.paulinasadowska.composetodoapp.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
                    onTextChange = setText

            )
            TodoEditButton(
                    onClick = {
                        onItemComplete(TodoItem(text))
                        setText("")
                    },
                    enabled = text.isNotBlank(),
                    text = "Add",
                    modifier = Modifier.align(Alignment.CenterVertically),
            )
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
