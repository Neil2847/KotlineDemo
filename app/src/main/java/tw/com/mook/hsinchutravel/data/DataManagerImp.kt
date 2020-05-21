package tw.com.mook.hsinchutravel.data

import android.content.Context
import tw.com.mook.hsinchutravel.connect.ApiClientImp
import tw.com.mook.hsinchutravel.data.local.PreferenceImp

interface DataManagerImp : PreferenceImp, ApiClientImp {

}