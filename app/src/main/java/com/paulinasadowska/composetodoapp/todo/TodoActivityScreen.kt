package com.paulinasadowska.composetodoapp.todo

import androidx.compose.runtime.Composable

@Composable
fun TodoActivityScreen(viewModel: TodoViewModel) {
    TodoScreen(viewModel.todoItems,
            currentlyEditing = viewModel.currentEditItem,
            onAddItem = viewModel::addItem,
            onRemoveItem = viewModel::removeItem,
            onEditDone = viewModel::onEditDone,
            onStartEdit = viewModel::onEditItemSelected,
            onEditItemChange = viewModel::onEditItemChange
    )
}
