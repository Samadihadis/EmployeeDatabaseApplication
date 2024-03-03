package com.samadihadis.employeedatabaseapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface EmployeeDAO {
    @Query("SELECT * FROM employee_table ORDER BY personnel_id ASC")
    suspend fun getAll(): List<EmployeeEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employee: EmployeeEntity)

    @Update
    suspend fun update(employee: EmployeeEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employees: List<EmployeeEntity>)

    @Query("DELETE FROM employee_table WHERE personnel_id = :personnelId")
    suspend fun delete(personnelId : Int)

    @Query("DELETE FROM employee_table")
    suspend fun deleteAll()

}