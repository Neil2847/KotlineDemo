package tw.com.mook.hsinchutravel.other

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import tw.com.mook.hsinchutravel.data.DataManager
import tw.com.mook.hsinchutravel.ui.home.HomeViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(private val dataManager: DataManager) :
    ViewModelProvider.NewInstanceFactory() {

    // ------------------------------------------
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(dataManager) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class :${modelClass.name}")
    }

    // ------------------------------------------
}