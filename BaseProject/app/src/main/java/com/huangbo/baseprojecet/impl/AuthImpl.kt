package com.huangbo.baseprojecet.impl

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.huangbo.baseprojecet.http.ApiServices
import rx.Observable
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by zohar on 2017/6/10.
 * desc:
 */
class AuthImpl
@Inject
constructor(private val mService: ApiServices)  {

    public fun getAuthCode(): Observable<Bitmap>? {
        return mService.authCode
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map { it.byteStream() }
                .map { BitmapFactory.decodeStream(it) };

    }

}

