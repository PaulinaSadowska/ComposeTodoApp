package com.paulinasadowska.composetodoapp.todo

import androidx.compose.runtime.Composable

@Composable
fun TodoActivityScreen(viewModel: TodoViewModel) {
    TodoScreen(viewModel.todoItems,
            onAddItem = { viewModel.addItem(it) },
            onRemoveItem = { viewModel.removeItem(it) }
    )
}
