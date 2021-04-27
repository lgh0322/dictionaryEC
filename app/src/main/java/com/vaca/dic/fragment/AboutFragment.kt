package com.vaca.dic.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vaca.dic.R
import com.vaca.dic.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    lateinit var binding:FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentAboutBinding.inflate(inflater,container,false)

        return binding.root
    }


}