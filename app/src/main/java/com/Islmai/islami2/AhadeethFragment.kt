package com.Islmai.islami2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.Islmai.databinding.FragmentAhadeethBinding

class AhadeethFragment : Fragment() {
    lateinit var binding: FragmentAhadeethBinding
    lateinit var adapter:HadeethAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAhadeethBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter= HadeethAdapter(null)
        binding.ahadeethRv.adapter=adapter
        readHadeethFile()

    }
    private fun readHadeethFile() {
        val file_name = "ahadeeth.txt"
        val SuraContentAsString = requireContext().assets.open(file_name).bufferedReader().use{
            it.readText()
        }
        val ahadeethList=SuraContentAsString.trim().split("#")
        val titleHadeethList= mutableListOf<String>()
        val descriptionHadeethList= mutableListOf<String>()
        for (hadeeth in ahadeethList){
            val mutableHadeethList=hadeeth.trim().split("\n").toMutableList()
            titleHadeethList.add(mutableHadeethList.get(0))
            descriptionHadeethList.add(mutableHadeethList.joinToString("\n"))
        }
        adapter.onHadeethItemClickListener=object :HadeethAdapter.OnHadeethItemClickListener{
            override fun onHadeethItemClick(hadeethItemPosition: Int) {

            }


        }
        adapter.update(titleHadeethList)
    }
}