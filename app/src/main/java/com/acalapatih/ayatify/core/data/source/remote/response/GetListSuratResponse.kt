package com.acalapatih.ayatify.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GetListSuratResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
) {
	data class Translation(

		@field:SerializedName("en")
		val en: String? = null,

		@field:SerializedName("id")
		val id: String? = null
	)

	data class DataItem(

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
		val tafsir: Tafsir? = null
	)

	data class Revelation(

		@field:SerializedName("en")
		val en: String? = null,

		@field:SerializedName("id")
		val id: String? = null,

		@field:SerializedName("arab")
		val arab: String? = null
	)

	data class Tafsir(

		@field:SerializedName("id")
		val id: String? = null
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

	data class Transliteration(

		@field:SerializedName("en")
		val en: String? = null,

		@field:SerializedName("id")
		val id: String? = null
	)
}
