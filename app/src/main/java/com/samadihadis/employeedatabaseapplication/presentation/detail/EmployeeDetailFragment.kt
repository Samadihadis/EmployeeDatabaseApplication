package com.samadihadis.employeedatabaseapplication.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.samadihadis.employeedatabaseapplication.databinding.FragmentEmployeeDetailBinding

class EmployeeDetailFragment : Fragment() {
    private val args by navArgs<EmployeeDetailFragmentArgs>()
    private lateinit var binding: FragmentEmployeeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            personnelIDDetail.text = args.employeeModel.personnelID.toString()
            firstNameValueTextView.text = args.employeeModel.firstName
            lastNameValueTextView.text = args.employeeModel.lastName
            fatherNameValueTextView.text = args.employeeModel.fatherName
            nationalIDValueTextView.text = args.employeeModel.nationalID
            phoneNumberValueTextView.text = args.employeeModel.phoneNumber
            mobileNumberValueTextView.text = args.employeeModel.mobileNumber
            addressValueTextView.text = args.employeeModel.address
        }
    }
}