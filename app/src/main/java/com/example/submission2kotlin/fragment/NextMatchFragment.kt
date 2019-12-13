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
class NextMatchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_next_match, container, false)
        val strtext = arguments!!.getString("idleagues")
        Log.e("NextMatchFragment", strtext)
        return rootView
    }
}
