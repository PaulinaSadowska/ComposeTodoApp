package com.paulinasadowska.composetodoapp.todo

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composetodoapp.ui.ComposeTodoAppTheme

@Composable
fun TodoItemInput(
        text: String = "",
        setText: (String) -> Unit = {},
        submit: () -> Unit = {},
        icon: TodoIcon = TodoIcon.Default,
        setIcon: (TodoIcon) -> Unit = {},
        buttonSlot: @Composable () -> Unit
) {
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
            Spacer(modifier = Modifier.width(8.dp))
            Box(Modifier.align(Alignment.CenterVertically)) {
                buttonSlot()
            }
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
        TodoItemInput(
                text = "test",
                buttonSlot = {
                    TodoEditButton(
                            onClick = { },
                            enabled = true,
                            text = "Add"
                    )
                }
        )
    }
}
