package com.fyber.inneractive.sdk.protobuf;

/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f1664a;
    public static final boolean b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f1664a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        b = cls2 != null;
    }

    public static boolean a() {
        return (f1664a == null || b) ? false : true;
    }
}
