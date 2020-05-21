package tw.com.mook.hsinchutravel.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import tw.com.mook.hsinchutravel.ui.home.HomeFragment

@Module
abstract class HomeFragmentProvider {

    @ContributesAndroidInjector
    internal abstract fun providerHomeFragmentFactory(): HomeFragment

    // ------------------------------------------
}