package com.mun.fragmentseventbus

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.mun.fragmentseventbus.databinding.FragmentHomeBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = binding.tabLayout
        val viewPager =binding.viewPager

        val adapter = HomeAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "List 1"
                1 -> "List 2"
                else -> null
            }
        }.attach()

    }

    @SuppressLint("ResourceType")
    private fun setTabText(text:String){
        binding.tabLayout.getTabAt(0)?.text = text
        binding.tabLayout.getTabAt(1)?.text = text
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onTextChangeEvent(event: TabTextChangeEvent) {
        setTabText(event.message)
    }
}