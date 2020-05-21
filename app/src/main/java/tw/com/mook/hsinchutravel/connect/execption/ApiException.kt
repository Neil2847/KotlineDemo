package tw.com.mook.hsinchutravel.connect.execption

import java.lang.Exception

data class ApiException(var code: Int, var msg: String) : Exception()