package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.ads.InMobiBanner;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class P1 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final InMobiBanner f2391a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public P1(InMobiBanner mInmobiBanner) {
        super(looper);
        Intrinsics.checkNotNullParameter(mInmobiBanner, "mInmobiBanner");
        Looper looper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getMainLooper(...)");
        Intrinsics.checkNotNullParameter(mInmobiBanner, "mInmobiBanner");
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.f2391a = mInmobiBanner;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what == 1) {
            this.f2391a.refreshBanner$media_release();
        } else {
            Intrinsics.checkNotNullExpressionValue("P1", "TAG");
        }
    }
}
