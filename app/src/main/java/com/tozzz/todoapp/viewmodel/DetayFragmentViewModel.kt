package com.tozzz.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.tozzz.todoapp.repo.YapilacaklarDaoRepository

class DetayFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val irepo = YapilacaklarDaoRepository(application)

    fun guncelle(is_id : Int, yapilacak_is: String){
        irepo.guncelle(is_id,yapilacak_is)
    }
}