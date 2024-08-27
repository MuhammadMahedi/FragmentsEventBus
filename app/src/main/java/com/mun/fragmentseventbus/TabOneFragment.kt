package com.mun.fragmentseventbus

import android.os.Bundle
import android.view.View
import com.mun.fragmentseventbus.databinding.FragmentTabOneBinding
import org.greenrobot.eventbus.EventBus


class TabOneFragment : BaseFragment<FragmentTabOneBinding>(FragmentTabOneBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTabText.setOnClickListener{
            var text = binding.editTextTab.text.toString()

            EventBus.getDefault().post(TabTextChangeEvent(text))
            binding.editTextTab.setText("")
        }

        binding.btnNextFragText.setOnClickListener{
            var text= binding.editText.text.toString()

            EventBus.getDefault().post(TextChangeEvent(text))
            binding.editText.setText("")
        }
    }

}