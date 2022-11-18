package dwiyan.com.kandang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent as Intent

class DetailKandang : AppCompatActivity() {
    var NamaKandang : TextView? = null
    var Alamat : TextView? = null
    var JenisKandang : TextView? = null
    var TanggalDoc : TextView? = null
    var PeriodeUmur : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kandang)

        NamaKandang = findViewById(R.id.namakandang)
        Alamat = findViewById(R.id.alamat)
        Alamat = findViewById(R.id.alamat)
        JenisKandang = findViewById(R.id.jeniskandang)
        TanggalDoc = findViewById(R.id.tanggaldoc)
        PeriodeUmur = findViewById(R.id.periodeumur)
        NamaKandang?.text = intent.getStringExtra("NamaKandang").toString()
        Alamat?.text = intent.getStringExtra("Alamat").toString()
        JenisKandang?.text = intent.getStringExtra("JenisKandang").toString()
        TanggalDoc?.text = intent.getStringExtra("TanggalDoc").toString()
        PeriodeUmur?.text = intent.getStringExtra("PeriodeUmur").toString()
    }
}