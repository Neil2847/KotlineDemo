package tw.com.mook.hsinchutravel.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IndexResponse(
    val CountryList: List<Country>,
    val EditorChoice: List<Top10>,
    val Top10: List<Top10>
) : Parcelable

@Parcelize
data class Country(
    val co_chname: String,
    val co_id: String,
    val pic: String,
    val pic_url: String
) : Parcelable

@Parcelize
data class Top10(
    val id: String,
    val isAdv: String,
    val pic01: String,
    val pic_url: String,
    val serial: String,
    val style: String,
    val title: String,
    val type: String
) : Parcelable