package dwiyan.com.catatankeuanganpribadi.Adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.icu.text.DateFormat
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dwiyan.com.catatankeuanganpribadi.Holder.HolderItem
import dwiyan.com.kandang.Dataset.DataKandang
import dwiyan.com.kandang.R
import dwiyan.com.kandang.R.color.gray2
import kotlinx.coroutines.NonDisposableHandle.parent
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

@Suppress("UNREACHABLE_CODE")
class AdapterListItem(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<HolderItem?>() {
    private var datakandang = ArrayList<DataKandang>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderItem {
        val v: View = from(parent.context).inflate(R.layout.item, parent, false)
        return HolderItem(v)
    }

    @SuppressLint("SetTextI18n", "NewApi", "SimpleDateFormat", "ResourceAsColor")
    override fun onBindViewHolder(holder: HolderItem, position: Int) {
        val data : DataKandang = datakandang[position]
        holder?.kandang?.text  = data.nama_kandang
        holder?.location?.text  = data.alamat_kandang
        holder?.hari?.text  = data.umur
        holder?.ekor?.text  = data.populasi
        holder?.berat?.text  = data.body_weight
        holder?.jeniskandang?.text  = data.jenis_peternakan
        holder?.periode?.text  = data.periode
        if(data.status_aktif == false){
            holder.image.drawable.setColorFilter(gray2, PorterDuff.Mode.SRC_ATOP)
            holder.lysum.visibility = View.GONE
            holder.kandang.setTextColor(R.color.basic)
        } else {
            holder.image.drawable.clearColorFilter()
            holder.lysum.visibility = View.VISIBLE
            holder.kandang?.setTextColor(R.color.basic)
            holder.cardkandang.setOnClickListener {
                onItemClickListener.onItemClick(
                   data.body_weight,
                    data.jenis_peternakan,
                    data.alamat_kandang,
                    data.nama_kandang,
                    data.umur,
                    data.client_name,
                    data.jenis_kandang,
                    data.periode,
                    data.populasi,
                    data.status_aktif,
                    data.tanggal_doc
                )
            }
        }

    }

    //val itemCount: Int? = null
    override fun getItemCount(): Int {
        Log.d("count" , datakandang.size.toString())
        return this.datakandang.size
    }

    //    @SuppressLint("NotifyDataSetChanged")
    @SuppressLint("NotifyDataSetChanged")
    fun setData(datakandang: ArrayList<DataKandang>) {
        //this.datakandang.clear();
        this.datakandang = datakandang
        Log.d("data" , datakandang.toString())
        notifyDataSetChanged();
    }

    interface OnItemClickListener {
        fun onItemClick(
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

        }

    }

}