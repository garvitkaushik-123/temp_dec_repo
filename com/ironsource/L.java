package com.ironsource;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    public static final L f2933a = new L();
    private static final HashMap<String, Long> b = new HashMap<>();

    private L() {
    }

    public final HashMap<String, Long> a() {
        return b;
    }

    public final long b(String instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Long l = b.get(instance);
        if (l != null) {
            return System.currentTimeMillis() - l.longValue();
        }
        return -1L;
    }

    public final long c(String instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Long l = b.get(instance);
        if (l != null) {
            return l.longValue();
        }
        return -1L;
    }

    public final boolean a(String instance, long j) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (instance.length() == 0) {
            return false;
        }
        HashMap<String, Long> hashMap = b;
        if (hashMap.containsKey(instance)) {
            return false;
        }
        hashMap.put(instance, Long.valueOf(j));
        return true;
    }

    public final boolean a(String instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        HashMap<String, Long> hashMap = b;
        if (hashMap.get(instance) == null) {
            return false;
        }
        hashMap.remove(instance);
        return true;
    }
}
