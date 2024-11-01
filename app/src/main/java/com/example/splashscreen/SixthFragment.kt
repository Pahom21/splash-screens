package com.example.splashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.splashscreen.databinding.FragmentSixthBinding

class SixthFragment : Fragment() {

    private var _binding: FragmentSixthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using View Binding
        _binding = FragmentSixthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up a click listener for the button to navigate to the Fifth Fragment
        binding.buttonToFirst.setOnClickListener {
            findNavController().navigate(R.id.action_SixthFragment_to_FirstFragment)
        }

        // If you want to navigate to the Third Fragment as well, add another button
        binding.buttonToFifth.setOnClickListener {
            findNavController().navigate(R.id.action_SixthFragment_to_FifthFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}