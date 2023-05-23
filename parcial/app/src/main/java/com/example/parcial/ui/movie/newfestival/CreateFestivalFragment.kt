package com.example.parcial.ui.movie.newfestival

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial.databinding.FragmentCreateFestivalBinding
import com.example.parcial.ui.movie.viewmodel.FestivalViewModel

class CreateFestivalFragment : Fragment(){

    private lateinit var binding: FragmentCreateFestivalBinding

    private val viewModel: FestivalViewModel by activityViewModels(){
        FestivalViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentCreateFestivalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        setObserver()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun setObserver(){
        viewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(FestivalViewModel.FESTIVAL_CREATED) -> {
                    Log.d("TAG APP", viewModel.getFestivals().toString())
                    Log.d("TAG APP", status)

                    viewModel.clearStatus()
                    viewModel.clearData()

                    findNavController().popBackStack()
                }

                status.equals(FestivalViewModel.FESTIVAL_DELETED) -> {
                    Log.d("TAG APP", status)
                    viewModel.clearStatus()
                }

            }

        }

    }

}