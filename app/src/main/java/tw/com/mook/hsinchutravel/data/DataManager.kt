package tw.com.mook.hsinchutravel.data

import android.content.Context
import tw.com.mook.hsinchutravel.connect.ApiClientImp
import tw.com.mook.hsinchutravel.connect.ApiService
import tw.com.mook.hsinchutravel.data.local.PreferenceImp
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(
    val context: Context,
    private val preference: PreferenceImp,
    private val apiClient: ApiClientImp
) : DataManagerImp {

    // ------------------------------------------
    override fun getApi(): ApiService {
        return apiClient.getApi()
    }

    // ------------------------------------------
}