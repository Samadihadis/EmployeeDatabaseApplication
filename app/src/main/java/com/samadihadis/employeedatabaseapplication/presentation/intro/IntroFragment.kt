package com.samadihadis.employeedatabaseapplication.presentation.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.samadihadis.employeedatabaseapplication.databinding.FragmentIntroBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IntroFragment : Fragment() {
    private lateinit var binding: FragmentIntroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(2000)
            findNavController().navigate(
                IntroFragmentDirections.actionToEmployeeListFragment()
            )
        }
    }
}