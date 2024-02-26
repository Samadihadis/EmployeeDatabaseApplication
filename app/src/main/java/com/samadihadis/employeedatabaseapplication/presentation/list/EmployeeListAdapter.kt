package com.samadihadis.employeedatabaseapplication.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.samadihadis.employeedatabaseapplication.R
import com.samadihadis.employeedatabaseapplication.data.EmployeeModel

class EmployeeListAdapter(private val navController: NavController) :
    RecyclerView.Adapter<EmployeeItemListViewHolder>() {

    private var employeeList: MutableList<EmployeeModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeItemListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmployeeItemListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeeItemListViewHolder, position: Int) {
        holder.apply {
            personnelID.text = employeeList[position].personnelID.toString()
            fullName.text = employeeList[position].firstName + employeeList[position].lastName
            rootLayout.setOnClickListener {

            }
        }
    }
}