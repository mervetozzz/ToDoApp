package com.tozzz.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.tozzz.todoapp.R
import com.tozzz.todoapp.databinding.FragmentDetayBinding
import com.tozzz.todoapp.viewmodel.DetayFragmentViewModel
import com.tozzz.todoapp.viewmodel.GorevDetayVMF


class DetayFragment : Fragment() {
    private lateinit var tasarim : FragmentDetayBinding
    private lateinit var viewModel : DetayFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false)
        tasarim.detayFragment = this
        tasarim.detayToolbarBaslik = "Yapılacak İş Detay"

        val bundle:DetayFragmentArgs by navArgs()
        val yapilacakIs = bundle.yapilacak
        tasarim.yapilacakIsNesnesi = yapilacakIs

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayFragmentViewModel by viewModels(){
            GorevDetayVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonguncelle(is_id:Int, yapilacak_is : String){
        viewModel.guncelle(is_id,yapilacak_is)
    }

}