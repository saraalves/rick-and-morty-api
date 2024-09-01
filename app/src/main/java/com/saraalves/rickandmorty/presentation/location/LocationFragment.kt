package com.saraalves.rickandmorty.presentation.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.FragmentLocationBinding
import com.saraalves.rickandmorty.domain.model.response.location.AllLocation
import com.saraalves.rickandmorty.presentation.character.adapter.AllCharactersAdapter
import com.saraalves.rickandmorty.presentation.location.adapter.AllLocationAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : Fragment(R.layout.fragment_location) {

    private var _binding: FragmentLocationBinding? = null
    private val binding get() =_binding!!

    private lateinit var adapter: AllLocationAdapter
    private val viewModel: LocationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        adapter = AllLocationAdapter { location ->
            location.let {}

        }

        adapter.apply {
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.characterListProgressBar.isVisible = true
        }
    }

    private fun observeViewModel() {
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                binding.characterListProgressBar.visibility = View.VISIBLE
            } else {
                binding.characterListProgressBar.visibility = View.GONE
            }
        }

        viewModel.allLocation.observe(viewLifecycleOwner) { allLocation ->
            binding.characterListProgressBar.isVisible = false
            adapter.submitList(allLocation.results)
        }

        viewModel.error.observe(viewLifecycleOwner) {
            binding.let {
                it.characterListProgressBar.isVisible = false
                it.recyclerView.isVisible = false
                // colocar cenario de erro
            }
        }
    }
}