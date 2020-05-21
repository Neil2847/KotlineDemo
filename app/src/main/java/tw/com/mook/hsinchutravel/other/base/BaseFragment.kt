package tw.com.mook.hsinchutravel.other.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

open class BaseFragment : Fragment() {

//    @Inject
//    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    // ------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

//    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    // ------------------------------------------
}