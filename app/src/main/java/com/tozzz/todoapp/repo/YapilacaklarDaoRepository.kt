package com.tozzz.todoapp.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tozzz.todoapp.entity.Yapilacaklar
import com.tozzz.todoapp.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class YapilacaklarDaoRepository(var application: Application){
    var yapilacaklarListesi:MutableLiveData<List<Yapilacaklar>>
    var vt:Veritabani

    init {
        yapilacaklarListesi = MutableLiveData()
        vt = Veritabani.veritabaniErisim(application)!!
    }

    fun gorevleriGetir() : MutableLiveData<List<Yapilacaklar>>{
        return yapilacaklarListesi
    }

    fun kayit(yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniGorev = Yapilacaklar(0,yapilacak_is)
            vt.yapilacaklarDao().gorevEkle(yeniGorev)
        }
    }

    fun guncelle(is_id : Int, yapilacak_is: String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncelGorev = Yapilacaklar(is_id,yapilacak_is)
            vt.yapilacaklarDao().gorevGuncelle(guncelGorev)
        }
    }

    fun ara(aramakelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = vt.yapilacaklarDao().gorevArama(aramakelimesi)
        }
    }

    fun sil(is_id: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenGorev = Yapilacaklar(is_id,"")
            vt.yapilacaklarDao().gorevSil(silinenGorev)
            tumGorevler()
        }
    }

    fun tumGorevler(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = vt.yapilacaklarDao().tumGorevler()
        }
    }
}