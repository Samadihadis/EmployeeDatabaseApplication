package com.samadihadis.employeedatabaseapplication.presentation.list

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.samadihadis.employeedatabaseapplication.R

class EmployeeItemListViewHolder (view: View) : RecyclerView.ViewHolder(view){

    val employeeImageView: AppCompatImageView
    val fullName: MaterialTextView
    val personnelID : MaterialTextView
    val rootLayout: ConstraintLayout

    init {
        view.apply {
            employeeImageView = findViewById(R.id.employeeImageView)
            fullName = findViewById(R.id.fullName)
            personnelID = findViewById(R.id.personnelID)
            rootLayout = findViewById(R.id.RootLayout)
        }
    }
}