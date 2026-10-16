package com.inmobi.media;

import android.content.Context;
import com.ironsource.C3040d4;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Sa {

    /* renamed from: a, reason: collision with root package name */
    public final C6 f2428a;

    public Sa(Context context, String sharePrefFile) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharePrefFile, "sharePrefFile");
        ConcurrentHashMap concurrentHashMap = C6.b;
        this.f2428a = B6.a(context, sharePrefFile);
    }

    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        C6.a(this.f2428a, key, value, false, 4, (Object) null);
    }

    public final void b(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        C6.a(this.f2428a, key, value, false, 4, (Object) null);
        a(System.currentTimeMillis() / 1000);
    }

    public final boolean c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f2428a.a(key);
    }

    public final void a(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        C6.a(this.f2428a, key, z, false, 4, (Object) null);
    }

    public final String a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        C6 c6 = this.f2428a;
        c6.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        return c6.f2249a.getString(key, null);
    }

    public final long b() {
        C6 c6 = this.f2428a;
        c6.getClass();
        Intrinsics.checkNotNullParameter("last_ts", C3040d4.h.W);
        return c6.f2249a.getLong("last_ts", 0L);
    }

    public final void a(long j) {
        C6.a(this.f2428a, "last_ts", j, false, 4, (Object) null);
    }

    public final void a() {
        this.f2428a.b();
    }

    public final boolean b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        C6 c6 = this.f2428a;
        c6.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        return c6.f2249a.contains(key);
    }
}
