package com.example.android.architecture.blueprints.todoapp.tasks

import android.os.Parcel
import android.os.Parcelable
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4 ::class)
class TasksViewModelTest() : Parcelable {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    constructor(parcel: Parcel) : this() {

    }

    // Other code…


    @Test
    fun addNewTask_setsNewTaskEvent() {

        // Given a fresh ViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When adding a new task
        tasksViewModel.addNewTask()

        // Then the new task event is triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        assertThat(
            value.getContentIfNotHandled(), (not(nullValue()))
        )
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TasksViewModelTest> {
        override fun createFromParcel(parcel: Parcel): TasksViewModelTest {
            return TasksViewModelTest(parcel)
        }

        override fun newArray(size: Int): Array<TasksViewModelTest?> {
            return arrayOfNulls(size)
        }
    }
}