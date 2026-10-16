package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;

/* loaded from: classes4.dex */
public final class G5 {

    /* renamed from: a, reason: collision with root package name */
    public final C2591c3 f2292a;

    public G5(Interceptor[] interceptors, Dispatcher dispatcher, C2687he timeoutConfig) {
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(timeoutConfig, "timeoutConfig");
        this.f2292a = new C2591c3(interceptors, dispatcher, timeoutConfig);
    }
}
