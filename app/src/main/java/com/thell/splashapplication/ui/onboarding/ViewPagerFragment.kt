package com.thell.splashapplication.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thell.splashapplication.databinding.FragmentViewPagerBinding
import com.thell.splashapplication.ui.onboarding.adapter.ViewPagerAdapter
import com.thell.splashapplication.ui.onboarding.screens.FirstFragment
import com.thell.splashapplication.ui.onboarding.screens.SecondFragment
import com.thell.splashapplication.ui.onboarding.screens.ThirdFragment
import com.thell.splashapplication.viewmodel.HomeFragmentViewModel
import com.thell.splashapplication.viewmodel.ViewPagerFragmentViewModel


class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private lateinit var viewModel : ViewPagerFragmentViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerBinding.inflate(inflater,container,false)

        init()

        return binding.root
    }

    private fun init()
    {
        viewModel = ViewModelProvider(this).get(ViewPagerFragmentViewModel::class.java)
        binding.viewModel = viewModel
        val viewpagerAdapter =  ViewPagerAdapter(viewModel.fragmentList,requireActivity().supportFragmentManager,lifecycle)
        binding.viewPager.adapter = viewpagerAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}