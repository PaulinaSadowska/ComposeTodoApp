package com.paulinasadowska.composetodoapp.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.composetodoapp.util.generateRandomTodoItem

/**
 * Stateless component that is responsible for the entire todo screen.
 *
 * @param items (state) list of [TodoItem] to display
 * @param onAddItem (event) request an item be added
 * @param onRemoveItem (event) request an item be removed
 */
@Composable
fun TodoScreen(
        items: List<TodoItem>,
        currentlyEditing: TodoItem?,
        onAddItem: (TodoItem) -> Unit,
        onRemoveItem: (TodoItem) -> Unit,
        onStartEdit: (TodoItem) -> Unit,
        onEditItemChange: (TodoItem) -> Unit,
        onEditDone: () -> Unit
) {
    Column {
        TodoItemInputBackground(elevate = true, modifier = Modifier.fillMaxWidth()) {
            TodoItemEntryInput(onItemComplete = { onAddItem(it) })
        }
        LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(items = items) { todo ->
                if (currentlyEditing?.id == todo.id) {
                    TodoItemInlineEditor(
                            item = todo,
                            onEditItemChange = onEditItemChange,
                            onEditDone = onEditDone,
                            onRemoveItem = { onRemoveItem(todo) }
                    )
                } else {
                    TodoRow(
                            todo = todo,
                            onItemClicked = { item -> onStartEdit(item) },
                            modifier = Modifier.fillParentMaxWidth()
                    )
                }
            }
        }

        Button(
                onClick = { onAddItem(generateRandomTodoItem()) },
                modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
        ) {
            Text("Add random item")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoScreen() {
    val items = listOf(
            TodoItem("Learn compose", TodoIcon.Event),
            TodoItem("Take the codelab"),
            TodoItem("Apply state", TodoIcon.Done),
            TodoItem("Build dynamic UIs", TodoIcon.Square)
    )
    TodoScreen(items, currentlyEditing = items[2], {}, {}, {}, {}, {})
}