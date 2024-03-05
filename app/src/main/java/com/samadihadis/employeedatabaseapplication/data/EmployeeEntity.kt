package com.samadihadis.employeedatabaseapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "employee_table")
class EmployeeEntity(
    @PrimaryKey @ColumnInfo(name = "personnel_id") val personnelID : Int,
    @ColumnInfo(name = "gender") val gender : String,
    @ColumnInfo(name = "first_name") val firstName : String,
    @ColumnInfo(name = "last_name") val lastName : String,
    @ColumnInfo(name = "national_id") val nationalID : String,
    @ColumnInfo(name = "father_name") val fatherName : String,
    @ColumnInfo(name = "landline_number") val landlineNumber : String,
    @ColumnInfo(name = "mobile_number") val mobileNumber : String,
    @ColumnInfo(name = "person_address") val address : String,
    @ColumnInfo(name = "is_favorite") var isFavorite : Boolean,
): Serializable