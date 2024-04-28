package com.Islmai.islami2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Islmai.R
import com.Islmai.databinding.ActivitySuraDetailsBinding

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySuraDetailsBinding
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.icBack.setOnClickListener{
            finish()
        }
        val title=intent.getStringExtra(Constant.EXTRA_SURA_NAME)
        val index=intent.getIntExtra(Constant.EXTRA_SURA_INDEX,-1)
        binding.textToolbarTitle.text=title
        adapter=VersesAdapter(null)
        binding.suraDetailsRv.adapter=adapter
        readFromAssets(index)

    }

    private fun readFromAssets(index:Int) {
        val file_name = "$index.txt"
        val SuraContentAsString = application.assets.open(file_name).bufferedReader().use{
            it.readText()
        }
        val verse=SuraContentAsString.split("\n")
        adapter.update(verse)
    }
}