package com.paulinasadowska.composetodoapp.todo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoInputTextField(
        modifier: Modifier = Modifier,
        text: String = "",
        onTextChange: (String) -> Unit = {},
        onImeAction: () -> Unit = {}
) {
    TodoInputText(text, onTextChange, modifier, onImeAction)
}

@Preview(showBackground = true)
@Composable
fun TodoInputTextFieldPreview() {
    TodoInputTextField()
}
