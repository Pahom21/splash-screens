package com.example.splashscreen

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.splashscreen.databinding.FragmentForthBinding

class ForthFragment : Fragment() {

    private var _binding: FragmentForthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using View Binding
        _binding = FragmentForthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Registering the context menu for a specific view (update with your view ID)
        registerForContextMenu(binding.root) // You can change this to a specific view if desired

        // Set up a click listener for the button to navigate to the Fifth Fragment
        binding.buttonToFifth.setOnClickListener {
            findNavController().navigate(R.id.action_ForthFragment_to_FifthFragment)
        }

        // If you want to navigate to the Third Fragment as well, add another button
        binding.buttonToThird.setOnClickListener {
            findNavController().navigate(R.id.action_ForthFragment_to_ThirdFragment)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // Inflate the context menu
        requireActivity().menuInflater.inflate(R.menu.context_menu, menu) // Ensure you use requireActivity()
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.context_option_edit -> {
                // Handle edit action
                Toast.makeText(context, "Edit option selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.context_option_delete -> {
                // Handle delete action
                Toast.makeText(context, "Delete option selected", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}