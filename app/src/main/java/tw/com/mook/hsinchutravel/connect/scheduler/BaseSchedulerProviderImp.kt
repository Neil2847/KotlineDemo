package tw.com.mook.hsinchutravel.connect.scheduler

import androidx.lifecycle.LifecycleOwner
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler


interface BaseSchedulerProviderImp {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

    fun <T> applySchedulers(): ObservableTransformer<T, T>
}