package com.samadihadis.employeedatabaseapplication.presentation.list

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.samadihadis.employeedatabaseapplication.R

class EmployeeItemListViewHolder (view: View) : RecyclerView.ViewHolder(view){

    val rootLayout: ConstraintLayout
    val employeeImageView: AppCompatImageView
    val fullName: MaterialTextView
    val personnelID : MaterialTextView
    val isFavoriteImageView : AppCompatImageView

    init {
        view.apply {
            rootLayout = findViewById(R.id.RootLayout)
            employeeImageView = findViewById(R.id.employeeImageView)
            fullName = findViewById(R.id.fullNameTextView)
            personnelID = findViewById(R.id.personnelIDTextView)
            isFavoriteImageView = findViewById(R.id.isFavoriteImageView)
        }
    }
}