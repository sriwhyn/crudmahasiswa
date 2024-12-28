package com.example.crud_mahasiswa.screen_page

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_mahasiswa.R
import com.example.crud_mahasiswa.databinding.ActivityTambahDataMahasiswaBinding
import com.example.crud_mahasiswa.helper.DbHelper
import com.example.crud_mahasiswa.model.ModelMahasiswa

class TambahDataMahasiswa : AppCompatActivity() {

    //binding:secara ringkasuntuk kita deklarasi variabel
    private lateinit var binding: ActivityTambahDataMahasiswaBinding
    private lateinit var db : DbHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTambahDataMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)



        db = DbHelper(this)
        binding.btnTambahData.setOnClickListener{
            val nama = binding.txtInputNama.text.toString()
            val nim = binding.txtInputNIM.text.toString()

            //karena nim --> int jadi kita perlu convert dari string ke int
            //toInt()
            val dataMahasiswa = ModelMahasiswa(0, nama, nim.toInt(), "Teknik Komputer" )
            db.insertDataMahasiswa(dataMahasiswa)
            finish();
            Toast.makeText(this,"Berhasil Tambah Data",
                Toast.LENGTH_SHORT).show()
        }

    }
}