package com.samadihadis.employeedatabaseapplication

import android.app.Application
import com.samadihadis.employeedatabaseapplication.data.EmployeeRepository
import com.samadihadis.employeedatabaseapplication.data.EmployeeRoomDatabase

class EmployeeApplication: Application() {

    val database by lazy { EmployeeRoomDatabase.getDatabase(this) }

    val repository by lazy { EmployeeRepository(database.employeeDao()) }

}