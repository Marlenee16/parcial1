package com.example.parcial.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.parcial.data.festival
import com.example.parcial.databinding.FragmentFestivalBinding
import com.example.parcial.ui.movie.viewmodel.FestivalViewModel

class FestivalFragment: Fragment() {

    private lateinit var binding: FragmentFestivalBinding

    private val movieViewModel: FestivalViewModel by activityViewModels{
        FestivalViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFestivalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = festivalViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

}