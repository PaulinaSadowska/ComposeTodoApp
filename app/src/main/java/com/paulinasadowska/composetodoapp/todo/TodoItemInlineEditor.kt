package com.paulinasadowska.composetodoapp.todo

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TodoItemInlineEditor(
        item: TodoItem,
        onEditItemChange: (TodoItem) -> Unit,
        onEditDone: () -> Unit,
        onRemoveItem: () -> Unit
) {
    TodoItemInput(
            text = item.task,
            setText = { onEditItemChange(item.copy(task = it)) },
            icon = item.icon,
            setIcon = { onEditItemChange(item.copy(icon = it)) },
            submit = onEditDone,
            buttonSlot = {
                Row {
                    val shrinkButtons = Modifier.widthIn(20.dp)
                    TextButton(onClick = onEditDone, modifier = shrinkButtons) {
                        Text(
                                text = "\uD83D\uDCBE", // floppy disk
                                textAlign = TextAlign.End,
                                modifier = Modifier.width(30.dp)
                        )
                    }
                    TextButton(onClick = onRemoveItem, modifier = shrinkButtons) {
                        Text(
                                text = "❌",
                                textAlign = TextAlign.End,
                                modifier = Modifier.width(30.dp)
                        )
                    }
                }
            }
    )
}

