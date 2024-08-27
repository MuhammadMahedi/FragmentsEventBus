package com.mun.fragmentseventbus

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabOneFragment()
            1 -> TabTwoFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}