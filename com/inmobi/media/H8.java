package com.inmobi.media;

import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.controllers.PublisherCallbacks;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class H8 extends PublisherCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<InMobiNative> f2305a;

    public H8(InMobiNative inMobiNative) {
        Intrinsics.checkNotNullParameter(inMobiNative, "inMobiNative");
        this.f2305a = new WeakReference<>(inMobiNative);
    }

    public final WeakReference<InMobiNative> getNativeRef() {
        return this.f2305a;
    }

    @Override // com.inmobi.ads.controllers.PublisherCallbacks
    public void onImraidLog(String log) {
        U7 mPubListener;
        Intrinsics.checkNotNullParameter(log, "log");
        InMobiNative inMobiNative = this.f2305a.get();
        if (inMobiNative == null || (mPubListener = inMobiNative.getMPubListener()) == null) {
            return;
        }
        mPubListener.a(inMobiNative, log);
    }

    public final void setNativeRef(WeakReference<InMobiNative> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.f2305a = weakReference;
    }
}
