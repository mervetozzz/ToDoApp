package com.tozzz.todoapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.tozzz.todoapp.R
import com.tozzz.todoapp.adapter.YapilacaklarAdapter
import com.tozzz.todoapp.databinding.FragmentAnasayfaBinding
import com.tozzz.todoapp.entity.Yapilacaklar

class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim : FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)
        tasarim.toolbarAnasayfa.title = "Yapılacaklar Listesi"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())

        val yapilacaklarListesi = ArrayList<Yapilacaklar>()
        val i1 = Yapilacaklar(1,"Ekmek Al")
        val i2 = Yapilacaklar(2,"kahvaltı")
        val i3 = Yapilacaklar(3,"spor")
        val i4 = Yapilacaklar(4,"Kotlin")

        yapilacaklarListesi.add(i1)
        yapilacaklarListesi.add(i2)
        yapilacaklarListesi.add(i3)
        yapilacaklarListesi.add(i4)

        val adapter = YapilacaklarAdapter(requireContext(),yapilacaklarListesi)
        tasarim.rv.adapter = adapter

        tasarim.fabEkle.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.kayıtGecis)
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