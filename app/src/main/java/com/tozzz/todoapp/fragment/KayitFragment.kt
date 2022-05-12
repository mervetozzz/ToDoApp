package com.tozzz.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.tozzz.todoapp.R
import com.tozzz.todoapp.databinding.FragmentKayitBinding

class KayitFragment : Fragment() {
    private lateinit var tasarim : FragmentKayitBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit, container, false)
        tasarim.kayitFragment = this
        tasarim.kayitToolbarBaslik = "Yapılacak İş Kayıt"
        return tasarim.root
    }

    fun buttonKaydetTikla(is_adi : String){
        Log.e("İş", "$is_adi")
    }

}