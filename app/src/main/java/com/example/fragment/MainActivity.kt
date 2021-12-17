package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment.AplikasiFragment.BerandaFragment
import com.example.fragment.AplikasiFragment.PengaturanFragment
import com.example.fragment.R
import com.example.fragment.AplikasiFragment.NotifikasiFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val berandaFragment = BerandaFragment()
        val notifikasiFragment = NotifikasiFragment()
        val pengaturanFragment = PengaturanFragment()

        makeCurrentFragment (berandaFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_beranda -> makeCurrentFragment(berandaFragment)
                R.id.menu_notifikasi -> makeCurrentFragment(notifikasiFragment)
                R.id.menu_pengaturan -> makeCurrentFragment(pengaturanFragment)
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framenavigation, fragment)
            commit()
        }
    }
}