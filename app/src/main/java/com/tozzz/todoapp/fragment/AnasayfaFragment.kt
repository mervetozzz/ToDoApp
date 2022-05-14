package com.tozzz.todoapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.tozzz.todoapp.R
import com.tozzz.todoapp.adapter.YapilacaklarAdapter
import com.tozzz.todoapp.databinding.FragmentAnasayfaBinding
import com.tozzz.todoapp.entity.Yapilacaklar
import com.tozzz.todoapp.viewmodel.AnasayfaFragmentViewModel
import com.tozzz.todoapp.viewmodel.GorevAnasayfaVMF

class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim : FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment = this

        tasarim.anasayfaToolbarBaslik = "Yapılacaklar Listesi"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner){
            val adapter = YapilacaklarAdapter(requireContext(),it,viewModel)
            tasarim.yapilacaklarAdapter = adapter
        }

        return tasarim.root
    }

    fun fabTikla(v:View){
        Navigation.findNavController(v).navigate(R.id.kayıtGecis)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel : AnasayfaFragmentViewModel by viewModels(){
            GorevAnasayfaVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.gorevleriYukle()
    }


}