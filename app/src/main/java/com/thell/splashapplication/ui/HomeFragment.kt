package com.thell.splashapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thell.splashapplication.R
import com.thell.splashapplication.databinding.FragmentHomeBinding
import com.thell.splashapplication.viewmodel.HomeFragmentViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewModel : HomeFragmentViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        init()

        return binding.root
    }

    private fun init()
    {
        viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        binding.viewModel = viewModel

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}