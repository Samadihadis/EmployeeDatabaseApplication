package com.samadihadis.employeedatabaseapplication.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samadihadis.employeedatabaseapplication.R
import com.samadihadis.employeedatabaseapplication.data.EmployeeEntity

class EmployeeListAdapter : RecyclerView.Adapter<EmployeeItemListViewHolder>() {

    private var employeeList: MutableList<EmployeeEntity> = mutableListOf()
    private var employeeItemClickListener: ((EmployeeEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeItemListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmployeeItemListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    fun addItemList(countryModelList: List<EmployeeEntity>) {
        employeeList.addAll(countryModelList)
        notifyItemRangeInserted(employeeList.size - 1, countryModelList.size)
    }

    override fun onBindViewHolder(holder: EmployeeItemListViewHolder, position: Int) {
        holder.apply {
            personnelID.text = employeeList[position].personnelID.toString()
            fullName.text = employeeList[position].firstName + " " + employeeList[position].lastName
            rootLayout.setOnClickListener {
                employeeItemClickListener?.invoke(employeeList[position])
            }
        }
    }

    fun setItemClickListener(listener: (EmployeeEntity) -> Unit) {
        employeeItemClickListener = listener
    }

    fun clearList() {
        employeeList.clear()
        notifyDataSetChanged()
    }
}