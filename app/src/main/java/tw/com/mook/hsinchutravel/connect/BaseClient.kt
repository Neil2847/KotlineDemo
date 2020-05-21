package tw.com.mook.hsinchutravel.connect

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tw.com.mook.hsinchutravel.BuildConfig
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager

open class BaseClient {

    private val timeOut: Long = 60
    private val log = HttpLoggingInterceptor()

    companion object {
        lateinit var retrofit: Retrofit
    }

    // ------------------------------------------
    init {

        log.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE

        val builder = OkHttpClient.Builder()
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(log)

        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.SERVER_URL)
            .client(builder.build())
            .build()
    }

    // ------------------------------------------
    /**
     * create api service.
     *
     * @param service api service
     * @return T
     */
    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }

    // ------------------------------------------
}