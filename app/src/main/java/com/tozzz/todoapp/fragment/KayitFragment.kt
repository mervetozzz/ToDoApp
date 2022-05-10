package com.tozzz.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tozzz.todoapp.R
import com.tozzz.todoapp.databinding.FragmentKayitBinding

class KayitFragment : Fragment() {
    private lateinit var tasarim : FragmentKayitBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentKayitBinding.inflate(inflater, container, false)
        tasarim.toolbarKayit.title = "Yapılacak İş Kayıt"

        tasarim.buttonKaydet.setOnClickListener {
            val is_adi = tasarim.etYapilacakIs.text.toString()

            kayit(is_adi)
        }
        return tasarim.root
    }

    fun kayit(is_adi : String){
        Log.e("İş", "$is_adi")
    }

}