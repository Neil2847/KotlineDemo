package tw.com.mook.hsinchutravel.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import tw.com.mook.hsinchutravel.data.DataManager
import tw.com.mook.hsinchutravel.other.base.BaseViewModel

class HomeViewModel(private val manager: DataManager) : BaseViewModel<HomeNavigator>() {

    // ------------------------------------------
    private val title = MutableLiveData<String>()

    // ------------------------------------------
    fun getTitle(): LiveData<String> {
        return title
    }

    // ------------------------------------------
    fun connectIndex() {
        getDisposable().add(
            manager.getApi().getIndex("appHome", 24.1234, 121.1234)
                .compose(getSchedulerProvider())
                .compose(getResponseTransformer())
                .subscribe(
                    { result -> Logger.e("TT", "result :$result") },
                    { error -> Logger.e("TT", "error :${error.message}") })
        )
    }

    // ------------------------------------------
    fun setName() {
        title.apply { value = "This is android studio." }
    }

    // ------------------------------------------
}
