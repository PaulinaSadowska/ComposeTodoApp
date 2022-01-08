package com.paulinasadowska.composetodoapp.todo

import androidx.compose.runtime.Composable

@Composable
fun TodoItemInlineEditor(
        item: TodoItem,
        onEditItemChange: (TodoItem) -> Unit,
        onEditDone: () -> Unit,
        onRemoveItem: () -> Unit
) = TodoItemInput(
        text = item.task,
        setText = { onEditItemChange(item.copy(task = it)) },
        icon = item.icon,
        setIcon = { onEditItemChange(item.copy(icon = it)) },
        submit = onEditDone,
)

