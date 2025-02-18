package com.acalapatih.ayatify.utils

import androidx.recyclerview.widget.DiffUtil
import com.acalapatih.ayatify.core.data.source.local.entity.AyatFavorit

class AyatCallback(
    private val oldListAyatFavorit: List<AyatFavorit>,
    private val newListAyatFavorit: List<AyatFavorit>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldListAyatFavorit.size

    override fun getNewListSize(): Int = newListAyatFavorit.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldListAyatFavorit[oldItemPosition].nomorSurat == newListAyatFavorit[newItemPosition].nomorSurat &&
                oldListAyatFavorit[oldItemPosition].nomorAyat == newListAyatFavorit[newItemPosition].nomorAyat
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldListAyatFavorit[oldItemPosition]
        val newItem = newListAyatFavorit[newItemPosition]
        return oldItem.namaSurat == newItem.namaSurat && oldItem.nomorAyat == newItem.nomorAyat
    }
}