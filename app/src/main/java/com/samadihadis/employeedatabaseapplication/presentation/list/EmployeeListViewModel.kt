package com.samadihadis.employeedatabaseapplication.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.samadihadis.employeedatabaseapplication.data.EmployeeEntity
import com.samadihadis.employeedatabaseapplication.data.EmployeeRepository

class EmployeeListViewModel(private val repository: EmployeeRepository): ViewModel() {

    val employees: LiveData<List<EmployeeEntity>> = repository.allEmployees.asLiveData()

}

class EmployeeViewModelFactory(private val repository: EmployeeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmployeeListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EmployeeListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}