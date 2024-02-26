package com.samadihadis.employeedatabaseapplication.data

import java.io.Serializable

data class EmployeeModel(
    val personnelID : Int,
    val firstName : String,
    val lastName : String,
    val nationalID : String,
    val fatherName : String,
    val phoneNumber : String,
    val mobileNumber : String,
    val address : String
): Serializable