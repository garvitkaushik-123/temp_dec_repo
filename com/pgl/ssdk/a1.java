package com.pgl.ssdk;

import android.os.HandlerThread;
import com.pgl.ssdk.e1;

/* loaded from: classes6.dex */
public class a1 {

    /* renamed from: a, reason: collision with root package name */
    private final d1<b1> f6376a;
    private e1 b;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a1 f6377a = new a1();
    }

    public static a1 a() {
        return b.f6377a;
    }

    public e1 b() {
        if (this.b == null) {
            synchronized (a1.class) {
                if (this.b == null) {
                    this.b = a("ssdk_net_handler");
                }
            }
        }
        return this.b;
    }

    public e1 c() {
        if (this.b == null) {
            synchronized (a1.class) {
                if (this.b == null) {
                    this.b = a("ssdk_handler");
                }
            }
        }
        return this.b;
    }

    private a1() {
        this.f6376a = d1.a(2);
    }

    public e1 a(String str) {
        return b(null, str);
    }

    private b1 a(e1.a aVar, String str) {
        try {
            HandlerThread handlerThread = new HandlerThread(str);
            handlerThread.start();
            return new b1(handlerThread, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    public e1 b(e1.a aVar, String str) {
        b1 a2 = this.f6376a.a();
        if (a2 != null) {
            a2.a(aVar);
            a2.a(str);
            return a2;
        }
        return a(aVar, str);
    }
}
