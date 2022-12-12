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


class FirstFragment : Fragment(R.layout.fragment_first) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val btn = view?.findViewById<Button>(R.id.btnFirst)
        val nameInput = view?.findViewById<EditText>(R.id.etFirstName)
        btn?.setOnClickListener {
            val firstName = nameInput?.text.toString().ifEmpty { null }
            val data = bundleOf("firstName" to firstName)
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, data)
        }

        return view
    }
}
