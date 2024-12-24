package com.example.studentsmanagement.utility.rxbus

import com.example.quanpham.utility.rxbus.RxBus
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

open class BaseEvent

class StopUpdate() : BaseEvent()


class NetworkConnected(val isOn: Boolean) : BaseEvent()
class UpdateAvgValue(val typeValue : String, val avgSteps: Float, val avgCalories: Float, val avgDistance: Float, val avgHour: Float) : BaseEvent()
class NotiBack() : BaseEvent()


fun listenEvent(
    onSuccess: (e: BaseEvent) -> Unit,
    onError: (th: Throwable) -> Unit = {}
): Disposable {
    return RxBus.listen(BaseEvent::class.java)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            onSuccess(it)
        }, {
            onError(it)
        })
}

