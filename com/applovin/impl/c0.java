package com.applovin.impl;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public abstract class c0 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.k f412a;
    protected final String b;
    protected final com.applovin.impl.sdk.o c;
    protected final AtomicBoolean e = new AtomicBoolean();
    private final Context d = com.applovin.impl.sdk.k.o();

    public c0(String str, com.applovin.impl.sdk.k kVar) {
        this.b = str;
        this.f412a = kVar;
        this.c = kVar.O();
    }

    public Context a() {
        return this.d;
    }

    public void a(boolean z) {
        this.e.set(z);
    }
}
