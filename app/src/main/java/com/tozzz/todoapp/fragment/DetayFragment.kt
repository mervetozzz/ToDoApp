package com.tozzz.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.tozzz.todoapp.R
import com.tozzz.todoapp.databinding.FragmentDetayBinding


class DetayFragment : Fragment() {
    private lateinit var tasarim : FragmentDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentDetayBinding.inflate(inflater, container, false)
        tasarim.toolbarDetay.title = "Yapılacak İş Detay"

        val bundle:DetayFragmentArgs by navArgs()
        val yapilacakIs = bundle.yapilacak

        tasarim.etGuncelle.setText(yapilacakIs.yapilacak_is)

        tasarim.buttonGuncelle.setOnClickListener{
            val yapilacak_is = tasarim.etGuncelle.text.toString()

            guncelle(yapilacakIs.is_id,yapilacak_is)

        }


        return tasarim.root
    }

    fun guncelle(is_id:Int, yapilacak_is : String){
        Log.e("İş", "$is_id - $yapilacak_is")
    }

}