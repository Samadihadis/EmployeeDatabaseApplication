package com.samadihadis.employeedatabaseapplication.presentation.input

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.samadihadis.employeedatabaseapplication.R
import com.samadihadis.employeedatabaseapplication.data.EmployeeEntity
import com.samadihadis.employeedatabaseapplication.data.EmployeeRoomDatabase
import com.samadihadis.employeedatabaseapplication.data.PersonGender
import com.samadihadis.employeedatabaseapplication.databinding.FragmentEmployeeInputBinding
import com.samadihadis.employeedatabaseapplication.presentation.detail.EmployeeDetailFragmentArgs
import kotlinx.coroutines.launch

class EmployeeInputFragment : Fragment() {

    private val args by navArgs<EmployeeInputFragmentArgs>()
    private lateinit var binding: FragmentEmployeeInputBinding
    private var isUpdateOperation = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isUpdateOperation = args.employeeEntity != null

        if (isUpdateOperation) setupEditStatus()

        setupClickListener()
    }

    private fun setupEditStatus() = with(binding) {
        val model = args.employeeEntity
        doneButton.text = "Update"
        personnelIdEditText.inputType = InputType.TYPE_NULL

        personnelIdEditText.setText(model?.personnelID.toString())
        firstNameEditText.setText(model?.firstName)
        lastNameEditText.setText(model?.lastName)
        nationalIdEditText.setText(model?.nationalID)
        fatherNameEditText.setText(model?.fatherName)
        landlineNumberEditText.setText(model?.landlineNumber)
        mobileNumberEditText.setText(model?.mobileNumber)
        addressEditText.setText(model?.address)
    }

    private fun setupClickListener() {
        binding.doneButton.setOnClickListener {
            prepareData()?.let {
                saveEmployee(it)
            }
        }
    }

    private fun prepareData(): EmployeeEntity? {
        val personalId = binding.personnelIdEditText.text.toString()
        val firstName = binding.firstNameEditText.text.toString()
        val lastName = binding.lastNameEditText.text.toString()
        val fatherName = binding.fatherNameEditText.text.toString()
        val nationalId = binding.nationalIdEditText.text.toString()
        val landlineNumber = binding.landlineNumberEditText.text.toString()
        val mobileNumber = binding.mobileNumberEditText.text.toString()
        val address = binding.addressEditText.text.toString() // Optional

        if (personalId.length <= 3) {
            Toast.makeText(requireContext(), "مقدار کد پرسنلی نامعتبر است.", Toast.LENGTH_SHORT)
                .show()
            return null
        }

        if (firstName.length <= 2) {
            Toast.makeText(requireContext(), "مقدار نام نامعتبر است.", Toast.LENGTH_SHORT).show()
            return null
        }

        if (lastName.length <= 2) {
            Toast.makeText(requireContext(), "مقدار فامیلی نامعتبر است.", Toast.LENGTH_SHORT).show()
            return null
        }

        if (nationalId.length != 10) {
            Toast.makeText(requireContext(), "مقدار شناسه ملی نامعتبر است.", Toast.LENGTH_SHORT)
                .show()
            return null
        }

        if (fatherName.length <= 2) {
            Toast.makeText(requireContext(), "مقدار نام پدر نامعتبر است.", Toast.LENGTH_SHORT)
                .show()
            return null
        }

        if (landlineNumber.length != 11) {
            Toast.makeText(requireContext(), "مقدار شماره منزل نامعتبر است.", Toast.LENGTH_SHORT)
                .show()
            return null
        }

        if (mobileNumber.length != 11) {
            Toast.makeText(requireContext(), "مقدار شماره موبایل نامعتبر است.", Toast.LENGTH_SHORT)
                .show()
            return null
        }

        return EmployeeEntity(
            personnelID = personalId.toInt(),
            gender = PersonGender.FEMALE.name,
            firstName = firstName,
            lastName = lastName,
            fatherName = fatherName,
            nationalID = nationalId,
            landlineNumber = landlineNumber,
            mobileNumber = mobileNumber,
            address = address,
            isFavorite = false
        )
    }

    private fun saveEmployee(employeeEntity: EmployeeEntity) {
        lifecycleScope.launch {
            if (isUpdateOperation) {
                EmployeeRoomDatabase.getDatabase(requireContext()).employeeDao()
                    .update(employeeEntity)
                findNavController().popBackStack(R.id.employeeListFragment, true)
            } else {
                EmployeeRoomDatabase.getDatabase(requireContext()).employeeDao()
                    .insert(employeeEntity)
                findNavController().popBackStack()
            }
        }
    }
}