package com.inmobi.media;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class H5 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final H5 f2303a = new H5();

    public H5() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Context d = Uc.d();
        if (d == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = C6.b;
        return B6.a(d, "inmobi_store");
    }
}
