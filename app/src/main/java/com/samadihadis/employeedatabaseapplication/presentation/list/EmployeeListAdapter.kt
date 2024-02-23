package com.samadihadis.employeedatabaseapplication.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samadihadis.employeedatabaseapplication.R

class EmployeeListAdapter() : RecyclerView.Adapter<EmployeeItemListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeItemListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmployeeItemListViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: EmployeeItemListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}