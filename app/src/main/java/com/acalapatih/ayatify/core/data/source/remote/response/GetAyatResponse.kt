package com.acalapatih.ayatify.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetAyatResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
) {
	data class Data(

		@field:SerializedName("number")
		val number: Number? = null,

		@field:SerializedName("meta")
		val meta: Meta? = null,

		@field:SerializedName("translation")
		val translation: Translation? = null,

		@field:SerializedName("tafsir")
		val tafsir: TafsirAyat? = null,

		@field:SerializedName("text")
		val text: Text? = null,

		@field:SerializedName("audio")
		val audio: Audio? = null,

		@field:SerializedName("surah")
		val surah: Surah? = null
	)

	data class Transliteration(

		@field:SerializedName("en")
		val en: String? = null,

		@field:SerializedName("id")
		val id: String? = null
	)

	data class Number(

		@field:SerializedName("inQuran")
		val inQuran: Int? = null,

		@field:SerializedName("inSurah")
		val inSurah: Int? = null
	)

	data class Id(

		@field:SerializedName("short")
		val jsonMemberShort: String? = null,

		@field:SerializedName("long")
		val jsonMemberLong: String? = null
	)

	data class Name(

		@field:SerializedName("translation")
		val translation: Translation? = null,

		@field:SerializedName("short")
		val jsonMemberShort: String? = null,

		@field:SerializedName("long")
		val jsonMemberLong: String? = null,

		@field:SerializedName("transliteration")
		val transliteration: Transliteration? = null
	)

	data class Surah(

		@field:SerializedName("number")
		val number: Int? = null,

		@field:SerializedName("sequence")
		val sequence: Int? = null,

		@field:SerializedName("numberOfVerses")
		val numberOfVerses: Int? = null,

		@field:SerializedName("revelation")
		val revelation: Revelation? = null,

		@field:SerializedName("name")
		val name: Name? = null,

		@field:SerializedName("tafsir")
		val tafsir: TafsirSurat? = null,

		@field:SerializedName("preBismillah")
		val preBismillah: PreBismillah? = null
	)

	data class Meta(

		@field:SerializedName("hizbQuarter")
		val hizbQuarter: Int? = null,

		@field:SerializedName("ruku")
		val ruku: Int? = null,

		@field:SerializedName("manzil")
		val manzil: Int? = null,

		@field:SerializedName("page")
		val page: Int? = null,

		@field:SerializedName("sajda")
		val sajda: Sajda? = null,

		@field:SerializedName("juz")
		val juz: Int? = null
	)

	data class Text(

		@field:SerializedName("transliteration")
		val transliteration: Transliteration? = null,

		@field:SerializedName("arab")
		val arab: String? = null
	)

	data class PreBismillah(

		@field:SerializedName("translation")
		val translation: Translation? = null,

		@field:SerializedName("text")
		val text: Text? = null,

		@field:SerializedName("audio")
		val audio: Audio? = null
	)

	data class Audio(

		@field:SerializedName("secondary")
		val secondary: List<String?>? = null,

		@field:SerializedName("primary")
		val primary: String? = null
	)

	data class Translation(

		@field:SerializedName("en")
		val en: String? = null,

		@field:SerializedName("id")
		val id: String? = null
	)

	data class TafsirAyat(

		@field:SerializedName("id")
		val id: Id? = null
	)

	data class TafsirSurat(

		@field:SerializedName("id")
		val id: String? = null
	)

	data class Revelation(

		@field:SerializedName("en")
		val en: String? = null,

		@field:SerializedName("id")
		val id: String? = null,

		@field:SerializedName("arab")
		val arab: String? = null
	)

	data class Sajda(

		@field:SerializedName("obligatory")
		val obligatory: Boolean? = null,

		@field:SerializedName("recommended")
		val recommended: Boolean? = null
	)
}
