package com.thell.splashapplication.ui.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.thell.splashapplication.R
import com.thell.splashapplication.databinding.FragmentThirdBinding
import com.thell.splashapplication.util.ActivityUtil
import com.thell.splashapplication.viewmodel.ThirdFragmentViewModel

class ThirdFragment : Fragment() {


    private var _binding: FragmentThirdBinding? = null
    private lateinit var viewModel : ThirdFragmentViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_third,container,false)

        init()

        return binding.root
    }

    private fun init()
    {
        viewModel = ViewModelProvider(this).get(ThirdFragmentViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.fragmentIndex.observe(viewLifecycleOwner){
            ActivityUtil.changeSplashViewPagerFragment(activity,it)
        }

        viewModel.fragmentFinish.observe(viewLifecycleOwner){
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}