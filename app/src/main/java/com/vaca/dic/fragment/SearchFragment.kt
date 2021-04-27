package com.vaca.dic.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData

import com.vaca.dic.DicTool
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

        val explain=MutableLiveData<String>()

        MainScope().launch {
            delay(500)
            binding.input.requestFocus()
            val inputManager: InputMethodManager = requireActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.showSoftInput(binding.input, 0)
        }


        binding.input.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                explain.postValue(binding.input.text.toString())
            }

        })


        explain.observe(viewLifecycleOwner,{
            val x= DicTool.searchString2Index(it)
            val y=DicTool.getExplain(x)
            binding.explain.text=y
        })


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