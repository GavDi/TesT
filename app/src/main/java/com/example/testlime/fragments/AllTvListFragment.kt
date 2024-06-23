package com.example.testlime.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testlime.R
import androidx.fragment.app.activityViewModels
import com.example.testlime.viewModels.TvViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllTvListFragment : Fragment() {

    private val tvViewModel: TvViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_all_tv_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvLiveData = tvViewModel.getTvLiveData()
        tvLiveData.observe(viewLifecycleOwner) {

        }
    }

}