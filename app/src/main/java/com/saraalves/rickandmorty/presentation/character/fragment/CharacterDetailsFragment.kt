package com.saraalves.rickandmorty.presentation.character.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saraalves.rickandmorty.R
import com.saraalves.rickandmorty.databinding.FragmentCharacterDetailsBinding
import com.squareup.picasso.Picasso

class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {

    private var _binding: FragmentCharacterDetailsBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        return binding?.details
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: CharacterDetailArgs? = arguments?.getParcelable("args")

        args?.let {
            binding?.characterDetailName?.text = "Hi, I'm ${it.name} !"
            Picasso.get().load(it.image).into(binding?.picture)
            binding?.textStatus?.text = "Hi, I'm ${it.status} !"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(args: CharacterDetailArgs) = CharacterDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("args", args)
                }
            }
    }
}