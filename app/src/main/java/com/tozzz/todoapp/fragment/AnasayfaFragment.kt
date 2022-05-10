package com.tozzz.todoapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import com.tozzz.todoapp.R
import com.tozzz.todoapp.databinding.FragmentAnasayfaBinding
import com.tozzz.todoapp.entity.Yapilacaklar

class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim : FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)
        tasarim.toolbarAnasayfa.title = "Yapılacaklar Listesi"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)


        tasarim.fabEkle.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.kayıtGecis)
        }

        tasarim.buttonDetay.setOnClickListener{
            val yapilacaklar = Yapilacaklar(1,"Ekmek Al")
            val gecis = AnasayfaFragmentDirections.detayGecis(yapilacak = yapilacaklar)
            Navigation.findNavController(it).navigate(gecis)
        }
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }

    fun ara(aramaKelimesi:String){
        Log.e("İş Ara",aramaKelimesi)
    }


}