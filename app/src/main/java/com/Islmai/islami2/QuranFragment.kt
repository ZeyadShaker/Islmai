package com.Islmai.islami2

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Sms.Intents
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.Islmai.databinding.FragmentQuraanBinding

class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuraanBinding
    lateinit var adapter: SuraNameAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentQuraanBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val suraNamesIndexes= suraNames.mapIndexed {index, suraName ->
            SuraNameIndex(suraName,index+1)

        }

        adapter=SuraNameAdapter(suraNamesIndexes)
        adapter.onItemClickListener=object :SuraNameAdapter.onSuraItemClickListener{
            override fun onSuraClick(suraNameIndex: SuraNameIndex, position: Int) {
                val intent= Intent(requireContext(),SuraDetailsActivity::class.java)
                intent.putExtra(Constant.EXTRA_SURA_NAME,suraNameIndex.name)
                intent.putExtra(Constant.EXTRA_SURA_INDEX,suraNameIndex.index)
                startActivity(intent)

            }

        }
        binding.suraNameIndexRv.adapter=adapter

    }
}