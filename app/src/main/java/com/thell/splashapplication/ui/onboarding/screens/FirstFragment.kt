package com.thell.splashapplication.ui.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thell.splashapplication.R
import com.thell.splashapplication.databinding.FragmentFirstBinding
import com.thell.splashapplication.util.ActivityUtil
import com.thell.splashapplication.viewmodel.FirstFragmentViewModel

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var viewModel : FirstFragmentViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false)

        init()

        return binding.root
    }

    private fun init()
    {
        viewModel = ViewModelProvider(this).get(FirstFragmentViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.fragmentIndex.observe(viewLifecycleOwner){
            ActivityUtil.changeSplashViewPagerFragment(activity,it)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}