package com.tozzz.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tozzz.todoapp.entity.Yapilacaklar
import com.tozzz.todoapp.repo.YapilacaklarDaoRepository

class AnasayfaFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val irepo = YapilacaklarDaoRepository(application)
    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()

    init {
        gorevleriYukle()
        yapilacaklarListesi = irepo.gorevleriGetir()
    }

    fun ara(aramaKelimesi:String){
        irepo.ara(aramaKelimesi)
    }

    fun sil(is_id:Int){
        irepo.sil(is_id)
    }

    fun gorevleriYukle(){
        irepo.tumGorevler()
    }
}