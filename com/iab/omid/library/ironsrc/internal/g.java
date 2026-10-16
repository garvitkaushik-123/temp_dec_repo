package com.iab.omid.library.ironsrc.internal;

import android.content.Context;

/* loaded from: classes4.dex */
public class g {
    private static g b = new g();

    /* renamed from: a, reason: collision with root package name */
    private Context f2040a;

    private g() {
    }

    public static g b() {
        return b;
    }

    public Context a() {
        return this.f2040a;
    }

    public void a(Context context) {
        this.f2040a = context != null ? context.getApplicationContext() : null;
    }
}
