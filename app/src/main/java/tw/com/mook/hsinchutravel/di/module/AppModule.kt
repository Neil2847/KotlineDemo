package tw.com.mook.hsinchutravel.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import tw.com.mook.hsinchutravel.connect.ApiClient
import tw.com.mook.hsinchutravel.connect.ApiClientImp
import tw.com.mook.hsinchutravel.data.DataManager
import tw.com.mook.hsinchutravel.data.DataManagerImp
import tw.com.mook.hsinchutravel.data.local.PreferenceHelper
import tw.com.mook.hsinchutravel.data.local.PreferenceImp
import tw.com.mook.hsinchutravel.di.PreferenceInfo
import tw.com.mook.hsinchutravel.other.AppConstants
import tw.com.mook.hsinchutravel.other.MyApplication
import javax.inject.Singleton

@Module
class AppModule {

    // ------------------------------------------
    @Provides
    @Singleton
    fun providerContext(application: MyApplication): Context {
        return application
    }

    // ------------------------------------------
    @Provides
    @Singleton
    fun providePreferenceHelper(helper: PreferenceHelper): PreferenceImp {
        return helper
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    // ------------------------------------------
    @Provides
    @Singleton
    fun provideDataManager(manager: DataManager): DataManagerImp {
        return manager
    }

    // ------------------------------------------
    @Provides
    @Singleton
    fun provideApiClient(apiClient: ApiClient): ApiClientImp {
        return apiClient
    }

    // ------------------------------------------
}