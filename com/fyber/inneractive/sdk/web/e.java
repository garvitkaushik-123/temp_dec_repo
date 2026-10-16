package com.fyber.inneractive.sdk.web;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public final class e {
    public com.fyber.inneractive.sdk.util.e c;
    public com.fyber.inneractive.sdk.util.d d;
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ i l;
    public Handler b = null;
    public final Object e = new Object();
    public boolean f = false;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f1796a = Executors.newSingleThreadExecutor(new com.fyber.inneractive.sdk.util.b());

    public e(i1 i1Var, String str, boolean z, String str2, String str3, String str4) {
        this.l = i1Var;
        this.g = str;
        this.h = z;
        this.i = str2;
        this.j = str3;
        this.k = str4;
    }

    public final Handler a() {
        if (this.b == null) {
            synchronized (this.e) {
                this.b = new Handler(Looper.getMainLooper());
            }
        }
        return this.b;
    }
}
