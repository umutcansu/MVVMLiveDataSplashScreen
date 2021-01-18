package com.thell.splashapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.thell.splashapplication.R
import com.thell.splashapplication.databinding.FragmentSplashBinding
import com.thell.splashapplication.util.ActivityUtil
import com.thell.splashapplication.util.CustomSharedPreferences
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_splash,container,false)

        init()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init()
    {
        GlobalScope.launch {
            delay(ActivityUtil.SPLASH_TICK)
            if(CustomSharedPreferences(requireContext()).getOnBoarding()) {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }
            else
            {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }
    }

}