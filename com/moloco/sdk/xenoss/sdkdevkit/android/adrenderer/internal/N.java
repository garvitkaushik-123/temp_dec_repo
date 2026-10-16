package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class N {

    /* renamed from: a, reason: collision with root package name */
    public static final N f5809a = new N();
    public static final Map<Integer, C3454d> b = new LinkedHashMap();
    public static final int c = 8;

    public final void b(int i) {
        b.remove(Integer.valueOf(i));
    }

    public final int a(C3454d wv) {
        Intrinsics.checkNotNullParameter(wv, "wv");
        int hashCode = wv.hashCode();
        b.put(Integer.valueOf(hashCode), wv);
        return hashCode;
    }

    public final /* synthetic */ <T> T a(int i) {
        T t = (T) b.get(Integer.valueOf(i));
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }
}
