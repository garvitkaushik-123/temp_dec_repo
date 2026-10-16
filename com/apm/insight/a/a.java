package com.apm.insight.a;

import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.b.i;
import com.apm.insight.runtime.m;

/* compiled from: AlogUploadManager.java */
/* loaded from: classes2.dex */
public class a implements ICrashCallback {
    private static volatile a d;

    /* renamed from: a, reason: collision with root package name */
    private volatile String f206a;
    private volatile i.a b;
    private volatile i.a c;
    private volatile boolean e = false;

    private a() {
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public final void a(String str, i.a aVar, i.a aVar2) {
        this.f206a = str;
        this.b = aVar;
        this.c = aVar2;
        if (this.e) {
            return;
        }
        this.e = true;
        m.a().a(new Runnable() { // from class: com.apm.insight.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // com.apm.insight.ICrashCallback
    public void onCrash(CrashType crashType, String str, Thread thread) {
        crashType.equals(CrashType.NATIVE);
    }
}
