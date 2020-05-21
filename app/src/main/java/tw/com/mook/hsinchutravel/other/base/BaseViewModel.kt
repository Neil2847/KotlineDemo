package tw.com.mook.hsinchutravel.other.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import io.reactivex.ObservableTransformer
import io.reactivex.disposables.CompositeDisposable
import tw.com.mook.hsinchutravel.connect.response.ResponseTransformer
import tw.com.mook.hsinchutravel.connect.scheduler.SchedulerProvider
import java.lang.ref.WeakReference

open class BaseViewModel<N> constructor() : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    private lateinit var navigator: WeakReference<N>

    // ------------------------------------------
    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    // ------------------------------------------
    protected fun <T> getResponseTransformer(): ObservableTransformer<T, T> {
        return ResponseTransformer.handleResult()
    }

    // ------------------------------------------
    protected fun <T> getSchedulerProvider(): ObservableTransformer<T, T> {
        return SchedulerProvider.applySchedulers()
    }

    // ------------------------------------------
    protected fun getDisposable(): CompositeDisposable {
        return disposable
    }

    // ------------------------------------------
    protected fun getNavigator(): N? {
        return navigator.get()
    }

    // ------------------------------------------
    fun setNavigator(navigator: N) {
        this.navigator = WeakReference<N>(navigator)
    }

    // ------------------------------------------
}