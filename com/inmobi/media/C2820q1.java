package com.inmobi.media;

import android.os.SystemClock;
import io.ktor.http.ContentDisposition;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.q1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2820q1 implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f2676a;
    public final String b;
    public final long c;
    public final String d;

    public C2820q1(CountDownLatch countDownLatch, String remoteUrl, long j, String assetAdType) {
        Intrinsics.checkNotNullParameter(countDownLatch, "countDownLatch");
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        Intrinsics.checkNotNullParameter(assetAdType, "assetAdType");
        this.f2676a = countDownLatch;
        this.b = remoteUrl;
        this.c = j;
        this.d = assetAdType;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object proxy, Method method, Object[] args) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(args, "args");
        C2868t1 c2868t1 = C2868t1.f2707a;
        Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
        Objects.toString(method);
        if (method == null) {
            return null;
        }
        if (!StringsKt.equals("onSuccess", method.getName(), true)) {
            if (!StringsKt.equals("onError", method.getName(), true)) {
                return null;
            }
            C2868t1.f2707a.c(this.b);
            this.f2676a.countDown();
            return null;
        }
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.c)), TuplesKt.to(ContentDisposition.Parameters.Size, 0), TuplesKt.to("assetType", "image"), TuplesKt.to("networkType", L3.q()), TuplesKt.to("adType", this.d));
        Pd pd = Pd.f2401a;
        Pd.b("AssetDownloaded", hashMapOf, Td.f2443a);
        C2868t1.f2707a.d(this.b);
        this.f2676a.countDown();
        return null;
    }
}
