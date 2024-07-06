package com.example.myapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SetupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SetupFragment : Fragment(R.layout.fragment_setup) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var tvcontinue = view.findViewById<TextView>(R.id.tvContinue)
        tvcontinue.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_setupFragment_to_runFragment)
        })
    }

}