package com.acalapatih.ayatify.ui.bookmark.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.acalapatih.ayatify.R
import com.acalapatih.ayatify.core.data.source.local.entity.AyatFavorit
import com.acalapatih.ayatify.databinding.RecyclerviewAyatFavoritBinding
import com.acalapatih.ayatify.utils.AyatCallback

class BookmarkAdapter(
    private val isDarkModeActive: Boolean,
): RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {

    private val listAyatFavorit = ArrayList<AyatFavorit>()
    var hapusAyatFavorit: ((ayatFavorit: AyatFavorit) -> Unit?)? = null
    var lihatAyatFavorit: ((ayatFavorit: AyatFavorit) -> Unit?)? = null

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = RecyclerviewAyatFavoritBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun bindItem(data: AyatFavorit) {
            with(binding) {
                tvLabelAyatFavorit.text = "Q.S ${data.namaSurat} : ${data.nomorAyat}"

                cvAyatFavorit.setOnClickListener {
                    val ayatFavorit = AyatFavorit(data.nomorSurat, data.namaSurat, data.nomorAyat, data.lafadzAyat, data.terjemahanAyat)
                    lihatAyatFavorit?.invoke(ayatFavorit)
                }

                icHapusAyatFavorit.setOnClickListener {
                    val ayatFavorit = AyatFavorit(data.nomorSurat, data.namaSurat, data.nomorAyat, data.lafadzAyat, data.terjemahanAyat)
                    hapusAyatFavorit?.invoke(ayatFavorit)
                }

                if (isDarkModeActive) {
                    icHapusAyatFavorit.setImageResource(R.drawable.ic_close_dark)
                } else {
                    icHapusAyatFavorit.setImageResource(R.drawable.ic_close_light)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_ayat_favorit, parent, false)
        )
    }

    override fun getItemCount(): Int = listAyatFavorit.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listAyatFavorit[position])
    }

    fun setListFavorite(listUser: List<AyatFavorit>) {
        val diffCallback = AyatCallback(listAyatFavorit, listUser)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        listAyatFavorit.clear()
        listAyatFavorit.addAll(listUser)
        diffResult.dispatchUpdatesTo(this)
    }
}