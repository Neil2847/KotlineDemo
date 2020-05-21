package tw.com.mook.hsinchutravel.other

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import tw.com.mook.hsinchutravel.di.component.DaggerAppComponent
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    // ------------------------------------------
    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    // ------------------------------------------
    override fun androidInjector(): DispatchingAndroidInjector<Any> = androidInjector

    // ------------------------------------------
}