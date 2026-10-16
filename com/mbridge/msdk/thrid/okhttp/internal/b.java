package com.mbridge.msdk.thrid.okhttp.internal;

/* compiled from: NamedRunnable.java */
/* loaded from: classes6.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected final String f4820a;

    public b(String str, Object... objArr) {
        this.f4820a = c.a(str, objArr);
    }

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f4820a);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
