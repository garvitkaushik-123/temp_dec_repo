package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f1777a;
    public static final Handler b = new Handler(Looper.getMainLooper());

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(32), new p(), new q());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f1777a = threadPoolExecutor;
    }
}
