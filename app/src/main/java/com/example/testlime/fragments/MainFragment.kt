package com.example.testlime.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.testlime.R
import com.example.testlime.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvFragmentAdapter = TvFragmentAdapter(requireActivity())
        binding.viewpagerForTabs.adapter = tvFragmentAdapter
        val tabTitles = arrayOf("Все", "Избранные")
        TabLayoutMediator(binding.tabs, binding.viewpagerForTabs) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

}