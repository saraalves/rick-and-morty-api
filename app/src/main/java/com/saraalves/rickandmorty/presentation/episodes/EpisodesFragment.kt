package com.saraalves.rickandmorty.presentation.episodes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.FragmentEpisodesBinding
import com.saraalves.rickandmorty.presentation.episodes.adapter.AllEpisodesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodesFragment : Fragment(R.layout.fragment_episodes) {

    private var _binding: FragmentEpisodesBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: AllEpisodesAdapter
    private val viewModel: EpisodesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        adapter = AllEpisodesAdapter { episodes ->
            episodes.let {}

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

        viewModel.allEpisodes.observe(viewLifecycleOwner) { allEpisodes ->
            binding.characterListProgressBar.isVisible = false
            adapter.submitList(allEpisodes.results)
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