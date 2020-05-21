package tw.com.mook.hsinchutravel.connect

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiClient @Inject constructor() : BaseClient(), ApiClientImp {

    companion object {
        @Volatile
        private lateinit var api: ApiService
    }

    // ------------------------------------------
    init {
        api = createService(ApiService::class.java)
    }

    // ------------------------------------------
    override fun getApi(): ApiService {
        return api
    }

    // ------------------------------------------
}