package com.example.fragmentnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class SecondFragment : Fragment(R.layout.fragment_second) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val btn = view?.findViewById<Button>(R.id.btnSecond)
        val nameInput = view?.findViewById<EditText>(R.id.etLastName)
        btn?.setOnClickListener {
            val lastName = nameInput?.text.toString().ifEmpty { null }
            val firstName = arguments?.getString("firstName", "John")
            val data = bundleOf("firstName" to firstName, "lastName" to lastName)
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, data)
        }

        return view
    }
}
