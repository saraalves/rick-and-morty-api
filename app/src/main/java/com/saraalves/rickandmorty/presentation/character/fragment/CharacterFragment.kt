package com.saraalves.rickandmorty.presentation.character.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.saraalves.rickandmorty.domain.model.response.character.AllCharacters
import com.saraalves.rickandmorty.presentation.character.adapter.AllCharactersAdapter
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.FragmentCharacterBinding
import com.saraalves.rickandmorty.presentation.character.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment(R.layout.fragment_character) {

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: AllCharactersAdapter
    private val viewModel: CharacterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        adapter = AllCharactersAdapter { character ->
            character.let {}
        }

        adapter.apply {
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.characterListProgressBar.isVisible = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeViewModel() {
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
                binding.characterListProgressBar.isVisible = isLoading
        }

        viewModel.allCharacters.observe(viewLifecycleOwner) { allCharacters ->
            binding.characterListProgressBar.isVisible = false
            adapter.submitList(allCharacters.results)
        }

        viewModel.error.observe(viewLifecycleOwner) {
            binding.let {
                it.characterListProgressBar.isVisible = false
                it.recyclerView.isVisible = false
                // colocar cenario de erro
                // adicionar a view com botão tentar de novo e tentar mais tarde
            }
        }
    }


}