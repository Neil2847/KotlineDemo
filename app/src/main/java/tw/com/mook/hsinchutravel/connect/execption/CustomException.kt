package tw.com.mook.hsinchutravel.connect.execption

import android.net.ParseException
import com.google.gson.JsonParseException
import org.json.JSONException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object CustomException {

    /**
     * Unknown error.
     */
    private const val UNKNOWN: Int = 1000

    /**
     * Parse error.
     */
    private const val PARSE_ERROR = 1001

    /**
     * Network error.
     */
    private const val NETWORK_ERROR = 1002

    // ------------------------------------------
    fun handleException(e: Throwable): ApiException {
        return if (e is JsonParseException || e is JSONException || e is ParseException) {
            ApiException(PARSE_ERROR, e.message!!)
        } else if (e is ConnectException) {
            ApiException(NETWORK_ERROR, e.message!!)
        } else if (e is UnknownHostException || e is SocketTimeoutException) {
            ApiException(NETWORK_ERROR, e.message!!)
        } else {
            ApiException(UNKNOWN, e.message!!)
        }
    }

    // ------------------------------------------
}