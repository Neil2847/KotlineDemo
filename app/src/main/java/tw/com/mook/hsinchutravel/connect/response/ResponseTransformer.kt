package tw.com.mook.hsinchutravel.connect.response

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.functions.Function
import tw.com.mook.hsinchutravel.connect.execption.CustomException

object ResponseTransformer {

    fun <T> handleResult(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.onErrorResumeNext(ErrorResumeFunction<T>()).flatMap(ResponseFunction<T>())
        }
    }

    // -------------------------------------------
    /**
     * Local exception use.(Network,JSON error...)
     *
     * @param <T>
     */
    private class ErrorResumeFunction<T> : Function<Throwable, ObservableSource<T>> {
        override fun apply(throwable: Throwable): ObservableSource<T> {
            return Observable.error(CustomException.handleException(throwable))
        }
    }

    // -------------------------------------------
    /**
     * Server api response.
     *
     * @param <T>
     */
    private class ResponseFunction<T> : Function<T, ObservableSource<T>> {
        override fun apply(response: T): ObservableSource<T> {
            return Observable.just(response)
        }
    }

    // ------------------------------------------
}