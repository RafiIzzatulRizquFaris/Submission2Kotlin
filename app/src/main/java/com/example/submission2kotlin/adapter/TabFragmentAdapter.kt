package com.example.submission2kotlin.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.submission2kotlin.R
import com.example.submission2kotlin.fragment.NextMatchFragment
import com.example.submission2kotlin.fragment.PreviousMatchFragment

class TabFragmentAdapter(private val cContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    private val title = intArrayOf(R.string.previous_match, R.string.next_match)

    override fun getItem(position: Int): Fragment {
        val fragment: Fragment? = null
        when (position) {
            0 -> return PreviousMatchFragment()
            1 -> return NextMatchFragment()
        }
        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return cContext.resources.getString(title[position])
    }

    override fun getCount(): Int {
        return title.size
    }
}