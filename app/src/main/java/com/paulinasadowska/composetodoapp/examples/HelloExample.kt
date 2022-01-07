package com.paulinasadowska.composetodoapp.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.paulinasadowska.composetodoapp.ui.ComposeTodoAppTheme

@Composable
fun HelloExample() {
    Column {
        val (text, setText) = remember { mutableStateOf("type something") }
        Text(text)
        TextField(
                value = text,
                onValueChange = { setText(it) })
    }

}

@Preview(showBackground = true)
@Composable
fun HelloExamplePreview() {
    ComposeTodoAppTheme {
        HelloExample()
    }
}