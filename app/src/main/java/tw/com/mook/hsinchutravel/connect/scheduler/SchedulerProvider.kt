package tw.com.mook.hsinchutravel.connect.scheduler

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

object SchedulerProvider : BaseSchedulerProviderImp {

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    // ------------------------------------------
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    // ------------------------------------------
    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    // ------------------------------------------
    override fun <T> applySchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable
                .subscribeOn(io())
                .observeOn(ui())
                .debounce(1, TimeUnit.SECONDS)
        }
    }

    // ------------------------------------------
}