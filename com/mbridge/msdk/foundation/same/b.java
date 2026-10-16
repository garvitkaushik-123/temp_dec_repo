package com.mbridge.msdk.foundation.same;

/* compiled from: MBridgeRefactor.java */
/* loaded from: classes6.dex */
public class b {
    private static volatile b b;

    /* renamed from: a, reason: collision with root package name */
    private Boolean f4264a = null;

    private b() {
    }

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public Boolean a() {
        return this.f4264a;
    }
}
