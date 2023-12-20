package com.example.basictodoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.basictodoapp.model.ToDoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM to_do_table")
    fun getAllToDo(): Flow<List<ToDoModel>>

    @Query("SELECT * FROM to_do_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchToDo(searchQuery: String): Flow<List<ToDoModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE) //Aynı id ile to_do eklemeye çalıştığımızda REPLACE edecek
    suspend fun insertToDo(toDoModel: ToDoModel) //database'de işlem yaptığımız zaman asenkron bir şekilde gerçekleşmesi için suspend kullanıyoruz.
    //Not: database işlemleri yaparken asenkron şekilde çalışmamız gerekiyor. Yoksa işlem gecikmesi sebebiyle ANR hatasıyla karşı karşıya kalırız.
    //Not2: Flow yapısı asenkron şekilde gerçekleşir. Flow kullanmadığımız yerlerde suspend fun kullandık.

    @Update
    suspend fun updateToDo(toDoModel: ToDoModel)

    @Query("SELECT * FROM to_do_table WHERE id = :toDoId")
    suspend fun getToDo(toDoId: Int): ToDoModel

    @Delete
    suspend fun deleteToDo(toDoModel: ToDoModel)
}