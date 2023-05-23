package com.example.parcial.ui.movie.listfestival

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial.R
import com.example.parcial.data.model.FestivalModel
import com.example.parcial.databinding.FragmentListaBinding
import com.example.parcial.ui.movie.adapter.FestivalAdapter
import com.example.parcial.ui.movie.viewmodel.FestivalViewModel

class ListaFragment : Fragment() {

    private val festivalViewModel: FestivalViewModel by activityViewModels{
        FestivalViewModel.Factory
    }

    private lateinit var binding: FragmentListaBinding
    private lateinit var adapter: FestivalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_billboard, container, false)
        binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener{
            festivalViewModel.clearData()
            it.findNavController().navigate(R.id.action_listaFragment3_to_createFestivalFragment2)
        }


    }

    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = FestivalAdapter{ FestivalSelected ->
            showSelectedItem(FestivalSelected)
        }

        binding.recyclerView.adapter = adapter
        displayfestivals()
    }


    private fun showSelectedItem(festival: FestivalModel){
        festivalViewModel.setSelectedFestival(festival)
        findNavController().navigate(R.id.action_listaFragment3_to_festivalFragment2)
    }

    private fun displayfestivals(){
        adapter.setData(festivalViewModel.getFestivals())
        adapter.notifyDataSetChanged()
    }

}