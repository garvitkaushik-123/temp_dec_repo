package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.logger.FMPLogger;
import com.ironsource.C3040d4;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class IAlog {

    /* renamed from: a, reason: collision with root package name */
    public static int f1749a = 4;
    public static final com.fyber.inneractive.sdk.logger.a b = new com.fyber.inneractive.sdk.logger.a();
    public static final v0 c = new v0();

    public static void a(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).debug(str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).error(str, null, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).info(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).log(1, null, str, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).verbose(str, objArr);
        }
    }

    public static void f(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).warning(str, objArr);
        }
    }

    public static void a(String str, Throwable th, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).error(str, th, objArr);
        }
    }

    public static String a(Object obj) {
        StringBuilder sb = new StringBuilder("(");
        sb.append(Thread.currentThread().getName()).append("): ").append(obj.getClass().getSimpleName()).append(C3040d4.i.d).append(Integer.toHexString(System.identityHashCode(obj))).append("] ");
        return sb.toString();
    }

    public static String a(Class cls) {
        StringBuilder sb = new StringBuilder("(");
        sb.append(Thread.currentThread().getName()).append("): ").append(cls.getSimpleName()).append(C3040d4.i.d).append(Integer.toHexString(System.identityHashCode(cls))).append("] ");
        return sb.toString();
    }
}
