package dwiyan.com.catatankeuanganpribadi.Holder

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import dwiyan.com.kandang.R


class HolderItem(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    var kandang: TextView
    var location: TextView
    var hari: TextView
    var ekor: TextView
    var berat: TextView
    var jeniskandang: TextView
    var periode: TextView
    var image: ImageView
    var itemClickListener: ItemClickListner? = null
    var cardkandang: CardView
    var lysum: LinearLayout
    override fun onClick(v: View) {
        itemClickListener!!.onItemClick(v, getLayoutPosition())
    }

    @JvmName("setItemClickListener1")
    fun setItemClickListener(itemClickListener: ItemClickListner?) {
        this.itemClickListener = itemClickListener
    }

    init {
        image = itemView.findViewById<ImageView>(R.id.image1)
        berat = itemView.findViewById<TextView>(R.id.berat)
        jeniskandang = itemView.findViewById<TextView>(R.id.jeniskandang)
        periode = itemView.findViewById<TextView>(R.id.periode)
        ekor = itemView.findViewById<TextView>(R.id.ekor)
        hari = itemView.findViewById<TextView>(R.id.hari)
        location = itemView.findViewById<TextView>(R.id.location)
        kandang = itemView.findViewById<TextView>(R.id.kandang)
        cardkandang = itemView.findViewById<CardView>(R.id.cardkandang)
        lysum = itemView.findViewById<LinearLayout>(R.id.lysum)
        cardkandang.setOnClickListener(this)
    }
}