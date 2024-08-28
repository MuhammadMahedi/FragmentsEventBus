package com.mun.fragmentseventbus

import android.os.Bundle
import android.view.View
import com.mun.fragmentseventbus.databinding.FragmentTabTwoBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class TabTwoFragment : BaseFragment<FragmentTabTwoBinding>(FragmentTabTwoBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        binding.tvFragmentTwo.text = event.message
    }

}