package com.tozzz.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.tozzz.todoapp.repo.YapilacaklarDaoRepository

class KayitFragmentViewModel(application: Application):AndroidViewModel(application) {
    val irepo = YapilacaklarDaoRepository(application)

    fun kayit(yapilacak_is:String){
        irepo.kayit(yapilacak_is)
    }
}