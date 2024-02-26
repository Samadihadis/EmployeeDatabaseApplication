package com.samadihadis.employeedatabaseapplication.presentation.list

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samadihadis.employeedatabaseapplication.databinding.FragmentEmployeeListBinding

class EmployeeListFragment(private val navController: NavController) : Fragment() {
    private lateinit var binding: FragmentEmployeeListBinding
    private val employeeAdaptor by lazy {
        EmployeeListAdapter(findNavController())
    }
    private var animation: ObjectAnimator? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        initAnimation()
        getAddEmployee()
    }

    private fun setupView() {
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        with(binding.employeeRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            addItemDecoration(dividerItemDecoration)
            adapter = employeeAdaptor
        }
    }

    private fun initAnimation() {
        animation = ObjectAnimator.ofFloat(binding.progressBarLoading, "rotation", 0f, 360f).apply {
            duration = 1000
            repeatCount = ObjectAnimator.INFINITE
            interpolator = LinearInterpolator()
        }
    }


    private fun getAddEmployee() {
        binding.fabButton.setOnClickListener {
            navController.navigate(
                EmployeeListFragmentDirections.actionToAddEmployeeFragment()
            )
        }
    }
}