package com.tozzz.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.tozzz.todoapp.R
import com.tozzz.todoapp.databinding.FragmentKayitBinding
import com.tozzz.todoapp.viewmodel.GorevKayitVMF
import com.tozzz.todoapp.viewmodel.KayitFragmentViewModel

class KayitFragment : Fragment() {
    private lateinit var tasarim : FragmentKayitBinding
    private lateinit var viewModel :KayitFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit, container, false)
        tasarim.kayitFragment = this
        tasarim.kayitToolbarBaslik = "Yapılacak İş Kayıt"
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KayitFragmentViewModel by viewModels(){
            GorevKayitVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonKaydetTikla(is_adi : String){
        viewModel.kayit(is_adi)
    }

}