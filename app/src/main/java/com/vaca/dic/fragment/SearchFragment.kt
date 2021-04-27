package com.vaca.dic.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.vaca.dic.databinding.FragmentSearchBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SearchFragment : Fragment() {

    private lateinit var binding:FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentSearchBinding.inflate(inflater, container, false)

        MainScope().launch {
            delay(500)
            binding.input.requestFocus()
            val inputManager: InputMethodManager = requireActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.showSoftInput(binding.input, 0)
        }


        return binding.root
    }


    fun closeSoftKeyboard(mEditText: EditText) {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mEditText.windowToken, 0)
    }

    override fun onPause() {
        super.onPause()
        closeSoftKeyboard(binding.input)
    }
}