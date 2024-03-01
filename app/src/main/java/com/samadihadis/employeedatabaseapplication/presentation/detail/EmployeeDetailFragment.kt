package com.samadihadis.employeedatabaseapplication.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.samadihadis.employeedatabaseapplication.data.EmployeeRoomDatabase
import com.samadihadis.employeedatabaseapplication.databinding.FragmentEmployeeDetailBinding
import kotlinx.coroutines.launch

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
        setupViews()
        setupClickListener()
    }

    private fun setupViews() = with(binding) {
        toolbar.title = args.employeeEntity.personnelID.toString()
        firstNameValueTextView.text = args.employeeEntity.firstName
        lastNameValueTextView.text = args.employeeEntity.lastName
        fatherNameValueTextView.text = args.employeeEntity.fatherName
        nationalIDValueTextView.text = args.employeeEntity.nationalID
        phoneNumberValueTextView.text = args.employeeEntity.landlineNumber
        mobileNumberValueTextView.text = args.employeeEntity.mobileNumber
        addressValueTextView.text = args.employeeEntity.address
    }

    private fun setupClickListener() {
        binding.deleteButton.setOnClickListener {
            deleteEmployee()
        }
    }

    private fun deleteEmployee() {
        lifecycleScope.launch {
            EmployeeRoomDatabase.getDatabase(requireContext()).employeeDao().delete(args.employeeEntity.personnelID)
            findNavController().popBackStack()
        }
    }
}