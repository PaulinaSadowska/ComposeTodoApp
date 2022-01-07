package com.paulinasadowska.composetodoapp.todo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun TodoActivityScreen(viewModel: TodoViewModel) {
    val items by viewModel.todoItems.observeAsState(initial = listOf())
    TodoScreen(items,
            onAddItem = { viewModel.addItem(it) },
            onRemoveItem = { viewModel.removeItem(it) }
    )
}
