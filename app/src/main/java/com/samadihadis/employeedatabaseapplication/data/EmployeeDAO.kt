package com.samadihadis.employeedatabaseapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDAO {
    @Query("SELECT * FROM employee_table ORDER BY personal_id ASC")
    fun getAll(): Flow<List<EmployeeEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employee: EmployeeEntity)

    @Query("DELETE FROM employee_table")
    suspend fun deleteAll()
}