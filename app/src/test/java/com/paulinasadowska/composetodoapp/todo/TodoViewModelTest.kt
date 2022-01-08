package com.paulinasadowska.composetodoapp.todo

import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import org.junit.Test
import java.util.*

class TodoViewModelTest : TestCase() {


    @Test
    fun `should update list on remove`() {
        //given
        val viewModel = TodoViewModel()
        val task1 = TodoItem("task1", TodoIcon.Done, UUID.randomUUID())
        val task2 = TodoItem("task2", TodoIcon.Privacy, UUID.randomUUID())
        val task3 = TodoItem("task3", TodoIcon.Square, UUID.randomUUID())
        listOf(task1, task2, task3).forEach {
            viewModel.addItem(it)
        }

        // when
        viewModel.removeItem(task2)

        // then
        assertThat(viewModel.todoItems).containsExactly(task1, task3)
    }
}