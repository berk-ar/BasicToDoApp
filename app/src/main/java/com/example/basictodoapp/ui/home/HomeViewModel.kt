package com.example.basictodoapp.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.basictodoapp.data.Repository
import com.example.basictodoapp.model.Priority
import com.example.basictodoapp.model.ToDoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application, private val repository: Repository,
) : AndroidViewModel(application) {

    val toDoList = repository.localDataSource.getAllToDo()

    fun insertToDo() {
        viewModelScope.launch {
            repository.localDataSource.insertToDo(
                ToDoModel(
                    title = "Title",
                    description = "Description",
                    priority = Priority.HIGH,
                    isChecked = true
                )
            )
        }
    }

}