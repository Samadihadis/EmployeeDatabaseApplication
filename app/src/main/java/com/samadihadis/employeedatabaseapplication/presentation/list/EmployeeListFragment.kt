package com.samadihadis.employeedatabaseapplication.presentation.list

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samadihadis.employeedatabaseapplication.data.EmployeeEntity
import com.samadihadis.employeedatabaseapplication.data.PersonGender
import com.samadihadis.employeedatabaseapplication.databinding.FragmentEmployeeListBinding

class EmployeeListFragment() : Fragment() {

    private lateinit var binding: FragmentEmployeeListBinding
    private val employeeAdaptor by lazy {
        EmployeeListAdapter()
    }
    private val dividerItemDecoration by lazy {
        DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
    }
    private var animation: ObjectAnimator? = null
    private var employeeList = mutableListOf<EmployeeEntity>()
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareMockData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackPressedCallback()
        initAnimation()
        setupView()
        setupClickListeners()
        addEmployeeList(employeeList)
    }

    private fun setupView() {
        with(binding.employeeRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            addItemDecoration(dividerItemDecoration)
            adapter = employeeAdaptor
        }
    }

    private fun setupClickListeners() {
        binding.fabButton.setOnClickListener {
            findNavController().navigate(
                EmployeeListFragmentDirections.actionToAddEmployeeFragment()
            )
        }
        employeeAdaptor.setItemClickListener {
            findNavController().navigate(
                EmployeeListFragmentDirections.actionToEmployeeDetailFragment(it)
            )
        }
    }

    private fun initAnimation() {
        animation = ObjectAnimator.ofFloat(binding.progressBarLoading, "rotation", 0f, 360f).apply {
            duration = 1000
            repeatCount = ObjectAnimator.INFINITE
            interpolator = LinearInterpolator()
        }
    }

    private fun prepareMockData() {
        employeeList.add(
            EmployeeEntity(
                personnelID = 6806,
                gender = PersonGender.FEMALE.name,
                firstName = "حدیث",
                lastName = "صمدی",
                nationalID = "0017934699",
                fatherName = "عزیزاله",
                landlineNumber = "02155316024",
                mobileNumber = "9128757419",
                address = "خزانه بخارایی",
                isFavorite = false
            )
        )
        employeeList.add(
            EmployeeEntity(
                personnelID = 6441,
                gender = PersonGender.MALE.name,
                firstName = "حسین",
                lastName = "خیراله پور",
                nationalID = "0410080012",
                fatherName = "اروجعلی",
                landlineNumber = "02155816775",
                mobileNumber = "9127923092",
                address = "وحدت اسلامی",
                isFavorite = true
            )
        )
        employeeList.add(
            EmployeeEntity(
                personnelID = 6673,
                gender = PersonGender.FEMALE.name,
                firstName = "مهناز",
                lastName = "نعمتی",
                nationalID = "0079144691",
                fatherName = "علی اصغر",
                landlineNumber = "02177603475",
                mobileNumber = "9372580212",
                address = "میدان سپاه",
                isFavorite = true
            )
        )
    }

    private fun addEmployeeList(employees: List<EmployeeEntity>) {
        employeeAdaptor.clearList()
        employeeAdaptor.addItemList(employees)
    }

    private fun onBackPressedCallback() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (doubleBackToExitPressedOnce) {
                        requireActivity().finish()
                        return
                    }
                    doubleBackToExitPressedOnce = true
                    Toast.makeText(requireContext(), "click back button again", Toast.LENGTH_SHORT)
                        .show()
                    Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
                }
            })
    }


}