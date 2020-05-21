package tw.com.mook.hsinchutravel.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import tw.com.mook.hsinchutravel.MainActivity


@Module
internal abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [HomeFragmentProvider::class])
    internal abstract fun bindMainActivity(): MainActivity

    // ------------------------------------------
}