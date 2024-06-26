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
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samadihadis.employeedatabaseapplication.EmployeeApplication
import com.samadihadis.employeedatabaseapplication.data.EmployeeRoomDatabase
import com.samadihadis.employeedatabaseapplication.databinding.FragmentEmployeeListBinding
import kotlinx.coroutines.launch

class EmployeeListFragment : Fragment() {

    private val employeeViewModel: EmployeeListViewModel by viewModels {
        EmployeeViewModelFactory((requireContext().applicationContext as EmployeeApplication).repository)
    }

    private lateinit var binding: FragmentEmployeeListBinding
    private val employeeAdaptor by lazy {
        EmployeeListAdapter() { id, favorite ->
            lifecycleScope.launch {
                EmployeeRoomDatabase.getDatabase(requireContext()).employeeDao()
                    .update(id, favorite)
            }
        }
    }
    private val dividerItemDecoration by lazy {
        DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
    }
    private var animation: ObjectAnimator? = null
    private var doubleBackToExitPressedOnce = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEmployees()
        onBackPressedCallback()
        initAnimation()
        setupView()
        setupClickListeners()
    }

    private fun observeEmployees() =
        employeeViewModel.employees.observe(viewLifecycleOwner) { employee ->
            employee?.let {
                employeeAdaptor.clearList()
                employeeAdaptor.addItemList(it)
            }
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
                EmployeeListFragmentDirections.actionToEmployeeInputFragment(null)
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

    private fun onBackPressedCallback() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (doubleBackToExitPressedOnce) {
                        requireActivity().finish()
                        return
                    }
                    doubleBackToExitPressedOnce = true
                    Toast.makeText(requireContext(), "برای خروج دوباره بر روی دکمه بازگشت بزنید.", Toast.LENGTH_SHORT)
                        .show()
                    Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
                }
            })
    }

}