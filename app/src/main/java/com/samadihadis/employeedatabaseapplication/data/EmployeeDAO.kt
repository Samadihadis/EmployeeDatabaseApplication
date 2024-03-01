package com.samadihadis.employeedatabaseapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeeDAO {
    @Query("SELECT * FROM employee_table ORDER BY personal_id ASC")
    suspend fun getAll(): List<EmployeeEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employee: EmployeeEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employees: List<EmployeeEntity>)

    @Query("DELETE FROM employee_table")
    suspend fun deleteAll()
}