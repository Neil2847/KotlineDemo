package tw.com.mook.hsinchutravel.ui.others

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OthersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Others Page"
    }

    val text: LiveData<String> = _text
}
