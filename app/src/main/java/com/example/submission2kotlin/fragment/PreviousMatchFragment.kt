package com.example.submission2kotlin.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.submission2kotlin.R

/**
 * A simple [Fragment] subclass.
 */
class PreviousMatchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_previous_match, container, false)
        val strtext = arguments!!.getString("idleagues")
        Log.e("PreviousMatchFragment", strtext)
        return rootView
    }
}
