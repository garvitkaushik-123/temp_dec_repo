package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class o0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1812a;
    public final /* synthetic */ v0 b;

    public o0(v0 v0Var, String str) {
        this.b = v0Var;
        this.f1812a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.a("injecting JS: %s", this.f1812a);
        try {
            String str = this.f1812a;
            if (str != null) {
                com.fyber.inneractive.sdk.util.o0.a(this.b.f1826a, str);
            }
        } catch (Exception unused) {
            IAlog.a("Failed to inject JS", new Object[0]);
        }
    }
}
