package tw.com.mook.hsinchutravel.data.local

import android.content.Context
import tw.com.mook.hsinchutravel.di.PreferenceInfo
import javax.inject.Inject

class PreferenceHelper @Inject constructor(
    val context: Context,
    @PreferenceInfo val fileName: String
) : PreferenceImp {


}