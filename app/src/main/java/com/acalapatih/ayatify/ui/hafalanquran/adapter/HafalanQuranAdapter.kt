package com.acalapatih.ayatify.ui.hafalanquran.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.core.domain.model.hafalanquran.HafalanQuranModel
import com.acalapatih.ayatify.databinding.RecyclerviewHafalanQuranBinding

class HafalanQuranAdapter(
    private val listSurat: List<HafalanQuranModel.GetListSurat>,
    val listener: OnUserClickListener? = null
): RecyclerView.Adapter<HafalanQuranAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = RecyclerviewHafalanQuranBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun bindItem(data: HafalanQuranModel.GetListSurat) {
            with(binding) {
                tvSurat.text = data.namaSurat
                tvJumlahAyat.text = "${data.jumlahAyat} Ayat"

                cvHafalanQuran.setOnClickListener {
                    listener?.onUserClicked(data.nomorSurat, "detailSurat")
                }
            }
        }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_hafalan_quran, parent, false)
        )
    }

    override fun getItemCount(): Int = 37

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reversedPosition = listSurat.size - 1 - position
        holder.bindItem(listSurat[reversedPosition])
    }

    interface OnUserClickListener {
        fun onUserClicked(nomorSurat: String, clicked: String)
    }
}