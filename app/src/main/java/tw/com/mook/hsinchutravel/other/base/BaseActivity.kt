package tw.com.mook.hsinchutravel.other.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import java.util.*
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

//    @Inject
//    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    // ------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState, persistentState)
    }

    // ------------------------------------------
//    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    // ------------------------------------------
}