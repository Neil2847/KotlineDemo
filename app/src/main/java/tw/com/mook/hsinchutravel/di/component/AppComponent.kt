package tw.com.mook.hsinchutravel.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import tw.com.mook.hsinchutravel.di.builder.ActivityBuilder
import tw.com.mook.hsinchutravel.di.module.AppModule
import tw.com.mook.hsinchutravel.other.MyApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityBuilder::class, AndroidInjectionModule::class])
interface AppComponent {

    fun inject(application: MyApplication)

    // ------------------------------------------
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): AppComponent
    }

    // ------------------------------------------
}