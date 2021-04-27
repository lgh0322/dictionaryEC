package com.vaca.dic.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vaca.dic.R
import com.vaca.dic.databinding.FragmentStarBinding


class StarFragment : Fragment() {

    private lateinit var binding:FragmentStarBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       binding= FragmentStarBinding.inflate(inflater,container,false)

        return binding.root
    }


}