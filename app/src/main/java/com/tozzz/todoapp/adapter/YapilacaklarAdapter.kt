package com.tozzz.todoapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.tozzz.todoapp.R
import com.tozzz.todoapp.databinding.CardTasarimBinding
import com.tozzz.todoapp.databinding.FragmentAnasayfaBinding
import com.tozzz.todoapp.entity.Yapilacaklar
import com.tozzz.todoapp.fragment.AnasayfaFragmentDirections
import com.tozzz.todoapp.viewmodel.AnasayfaFragmentViewModel

class YapilacaklarAdapter(val mContext:Context, var yapilacaklarListesi:List<Yapilacaklar>,var viewModel: AnasayfaFragmentViewModel)
    : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root){
        var tasarim : CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacakIs = yapilacaklarListesi.get(position)
        val h = holder.tasarim

        h.yapilacaklarNesnesi = yapilacakIs

        h.imageView.setOnClickListener{
            Snackbar.make(it,"${yapilacakIs.yapilacak_is} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.sil(yapilacakIs.is_id)
                }
                .show()
        }

        h.cardView.setOnClickListener{
            val gecis =AnasayfaFragmentDirections.detayGecis(yapilacak = yapilacakIs)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }
}