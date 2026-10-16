package com.iab.omid.library.unity3d.internal;

import android.content.Context;

/* loaded from: classes4.dex */
public class f {
    private static f b = new f();

    /* renamed from: a, reason: collision with root package name */
    private Context f2113a;

    private f() {
    }

    public static f b() {
        return b;
    }

    public Context a() {
        return this.f2113a;
    }

    public void a(Context context) {
        this.f2113a = context != null ? context.getApplicationContext() : null;
    }
}
