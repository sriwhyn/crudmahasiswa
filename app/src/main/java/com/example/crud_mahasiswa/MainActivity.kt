package com.example.crud_mahasiswa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crud_mahasiswa.adapter.MahasiswaAdapter
import com.example.crud_mahasiswa.databinding.ActivityMainBinding
import com.example.crud_mahasiswa.helper.DbHelper
import com.example.crud_mahasiswa.screen_page.TambahDataMahasiswa

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db : DbHelper
    private lateinit var mahasiswaAdapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DbHelper(this)
        mahasiswaAdapter = MahasiswaAdapter(db.getAllDataMahasiswa(),this)

        binding.rvDataMahasiswa.layoutManager = LinearLayoutManager(this)
        binding.rvDataMahasiswa.adapter = mahasiswaAdapter

        //silahkan buat detail page
        //ketika diklik item nya akan pindah

        binding.btnPageTambah.setOnClickListener{
            val intent = Intent(this, TambahDataMahasiswa::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val newMahasiswa = db.getAllDataMahasiswa()
        mahasiswaAdapter.refreshData(newMahasiswa)

    }
}