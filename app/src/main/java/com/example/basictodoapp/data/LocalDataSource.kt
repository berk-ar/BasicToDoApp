package com.example.basictodoapp.data

import com.example.basictodoapp.model.ToDoModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val toDoDao: ToDoDao,
) {
    fun getAllToDo(): Flow<List<ToDoModel>> {
        return toDoDao.getAllToDo()
    }

    fun searchToDo(searchQuery: String): Flow<List<ToDoModel>> {
        return toDoDao.searchToDo(searchQuery)
    }

    suspend fun insertToDo(toDoModel: ToDoModel) {
        return toDoDao.insertToDo(toDoModel)
    }

    suspend fun updateToDo(toDoModel: ToDoModel) {
        return toDoDao.updateToDo(toDoModel)
    }

    suspend fun getToDo(toDoInt: Int): ToDoModel {
        return toDoDao.getToDo(toDoInt)
    }

    suspend fun deleteToDo(toDoModel: ToDoModel) {
        return toDoDao.deleteToDo(toDoModel)
    }


}