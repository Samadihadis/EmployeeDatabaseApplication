package com.samadihadis.employeedatabaseapplication.data

import kotlinx.coroutines.flow.Flow

class EmployeeRepository(private val dao: EmployeeDAO) {

    val allEmployees: Flow<List<EmployeeEntity>> = dao.getAll()

}