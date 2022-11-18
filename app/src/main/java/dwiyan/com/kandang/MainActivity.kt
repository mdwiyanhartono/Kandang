package dwiyan.com.kandang

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dwiyan.com.catatankeuanganpribadi.Adapter.AdapterListItem
import dwiyan.com.kandang.Dataset.DataKandang

class MainActivity : AppCompatActivity(), View.OnClickListener,
    AdapterListItem.OnItemClickListener {

    var rckandang : RecyclerView? = null
    var adapterList: AdapterListItem? = null
    var aktif: TextView? = null
    var search: EditText? = null
    var rehat: TextView? = null
    var countkandang: TextView? = null
    var def : ColorStateList? = null
    var select : TextView? = null
    var count : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rckandang = findViewById(R.id.rc1)
        countkandang = findViewById(R.id.countkandang)
        aktif = findViewById(R.id.aktif)
        rehat = findViewById(R.id.rehat)
        select = findViewById(R.id.select)
        def = rehat?.textColors
        aktif?.setOnClickListener(this@MainActivity)
        rehat?.setOnClickListener(this@MainActivity)
        rckandang?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        rckandang?.itemAnimator = DefaultItemAnimator()
        adapterList = AdapterListItem(this@MainActivity)
        datakandang?.add(DataKandang("Kandang Bangkit","Kota Jakarta Utara",true,null,"MANDIRI","Periode 5","21 Hari","23.000 Ekor", "840 gr","Open House","21 Des 2021"))
        datakandang?.add(DataKandang("Kandang Kita Jaya 01","Kota Semarang",true,"Agrinis","PLASMA","Periode 5","21 Hari","23.000 Ekor", "840 gr","Close House","21 Des 2021"))
        datakandang?.let { adapterList?.setData(it) }
        rckandang?.adapter = adapterList
        count = datakandang?.size
        countkandang?.setText(count.toString() + " kandang aktif")

    }


    val datakandang : ArrayList<DataKandang>? = ArrayList()
    override fun onClick(view: View?) {
        if(view?.id ==  R.id.aktif){
            datakandang?.clear()
            select?.animate()?.x(0F)?.setDuration(100);
            aktif?.setTextColor(Color.WHITE);
            rehat?.setTextColor(def);
            datakandang?.add(DataKandang("Kandang Bangkit","Kota Jakarta Utara",true,null,"MANDIRI","Periode 5","21 Hari","23.000 Ekor", "840 gr","Open House","21 Des 2021"))
            datakandang?.add(DataKandang("Kandang Kita Jaya 01","Kota Semarang",true,"Agrinis","PLASMA","Periode 5","21 Hari","23.000 Ekor", "840 gr","Close House","21 Des 2021"))
            datakandang?.let { adapterList?.setData(it) }
            rckandang?.adapter = adapterList
            count = datakandang?.size
            countkandang?.setText(count.toString() + " kandang aktif")
        } else if(view?.id ==  R.id.rehat){
            datakandang?.clear()
            datakandang?.add(DataKandang("Kandang Bangkit 2","Kota Jakarta Utara",false,null,"MANDIRI","5 Periode",null,null, null,null,null))
            rehat?.setTextColor(Color.WHITE);
            aktif?.setTextColor(def);
            var size: Int? = rehat?.getWidth()
            select?.animate()?.x(size?.toFloat()!!)?.setDuration(100);
            datakandang?.let { adapterList?.setData(it) }
            rckandang?.adapter = adapterList
            count = datakandang?.size
            countkandang?.setText(count.toString() + " kandang rehat")
        }
    }

    override fun onItemClick(
        bodyWeight: String?,
        jenisPeternakan: String?,
        alamatKandang: String?,
        namaKandang: String?,
        umur: String?,
        clientName: String?,
        jenisKandang: String?,
        periode: String?,
        populasi: String?,
        statusAktif: Boolean?,
        tanggalDoc: String?
    ) {

        val i = Intent(this@MainActivity, DetailKandang::class.java)
        i.putExtra("NamaKandang" , namaKandang)
        i.putExtra("Alamat" , alamatKandang)
        i.putExtra("JenisKandang" , jenisKandang)
        i.putExtra("TanggalDoc" , tanggalDoc)
        i.putExtra("PeriodeUmur" , "$periode | Umur $umur")
        startActivity(i)
    }
}