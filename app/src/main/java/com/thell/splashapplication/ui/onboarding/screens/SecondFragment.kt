package com.thell.splashapplication.ui.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thell.splashapplication.R
import com.thell.splashapplication.databinding.FragmentSecondBinding
import com.thell.splashapplication.util.ActivityUtil
import com.thell.splashapplication.viewmodel.SecondFragmentViewModel


class SecondFragment : Fragment() {


    private var _binding: FragmentSecondBinding? = null
    private lateinit var viewModel : SecondFragmentViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false)

        init()

        return binding.root
    }

    private fun init()
    {
        viewModel = ViewModelProvider(this).get(SecondFragmentViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.fragmentIndex.observe(viewLifecycleOwner){
            activity?.apply {
                ActivityUtil.changeSplashViewPagerFragment(activity,it)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}