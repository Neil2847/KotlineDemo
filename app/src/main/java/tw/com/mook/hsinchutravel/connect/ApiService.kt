package tw.com.mook.hsinchutravel.connect

import io.reactivex.Observable
import retrofit2.http.*
import tw.com.mook.hsinchutravel.data.model.IndexRequest
import tw.com.mook.hsinchutravel.data.model.IndexResponse

interface ApiService {

    // ------------------------------------------
    /**index page (theme)*/
    @FormUrlEncoded
    @POST("api/spot_v2.php")
    fun getIndex(
        @Field("cmd") cmd: String,
        @Field("lat") lat: Double,
        @Field("lon") lon: Double
    ): Observable<IndexResponse>
    // ------------------------------------------
}