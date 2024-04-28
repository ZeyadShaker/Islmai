package com.Islmai.islami2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.Islmai.R
import com.Islmai.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.islamiBottomNavigationView.setOnItemSelectedListener {
           if (it.itemId==R.id.navigation_quran){
               pushFragment(QuranFragment())

           }else if (it.itemId==R.id.navigation_ahadeth){
               pushFragment(AhadeethFragment())

           }else if (it.itemId==R.id.navigation_sebha){
               pushFragment(TasbeehFragment())

           }else if (it.itemId==R.id.navigation_radio){
               pushFragment(RadioFragment())

           }
                return@setOnItemSelectedListener true
        }
        binding.islamiBottomNavigationView.selectedItemId=R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.islamiAppFragmentContainer.id,fragment)
            .commit()
    }
}