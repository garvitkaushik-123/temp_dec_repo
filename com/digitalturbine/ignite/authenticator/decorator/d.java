package com.digitalturbine.ignite.authenticator.decorator;

import android.content.ComponentName;
import android.os.IBinder;

/* loaded from: classes3.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentName f992a;
    public final /* synthetic */ IBinder b;
    public final /* synthetic */ e c;

    public d(e eVar, ComponentName componentName, IBinder iBinder) {
        this.c = eVar;
        this.f992a = componentName;
        this.b = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f992a, this.b);
    }
}
