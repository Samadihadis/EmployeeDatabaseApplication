package com.samadihadis.employeedatabaseapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDAO {
    @Query("SELECT * FROM employee_table ORDER BY personnel_id ASC")
    fun getAll(): Flow<List<EmployeeEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employee: EmployeeEntity)

    @Update
    suspend fun update(employee: EmployeeEntity)

    @Query("UPDATE employee_table SET is_favorite=:isFavorite WHERE personnel_id = :personnelId")
    suspend fun update(personnelId: Int, isFavorite: Boolean)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employees: List<EmployeeEntity>)

    @Query("DELETE FROM employee_table WHERE personnel_id = :personnelId")
    suspend fun delete(personnelId : Int)

    @Query("DELETE FROM employee_table")
    suspend fun deleteAll()

}