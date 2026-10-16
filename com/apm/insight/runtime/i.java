package com.apm.insight.runtime;

import android.os.SystemClock;
import android.util.Printer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LooperMessageManager.java */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static i f331a;
    private long b = -1;
    private final List<Printer> c = new ArrayList();
    private final List<Printer> d = new ArrayList();
    private boolean e = false;

    static /* synthetic */ Printer c() {
        return null;
    }

    static {
        new Printer() { // from class: com.apm.insight.runtime.i.1
            @Override // android.util.Printer
            public final void println(String str) {
                if (str == null) {
                    return;
                }
                if (str.charAt(0) == '>') {
                    i.a().a(str);
                } else if (str.charAt(0) == '<') {
                    i.a().b(str);
                }
                i.c();
            }
        };
    }

    private i() {
    }

    public static i a() {
        if (f331a == null) {
            synchronized (i.class) {
                if (f331a == null) {
                    f331a = new i();
                }
            }
        }
        return f331a;
    }

    public final boolean b() {
        return this.b != -1 && SystemClock.uptimeMillis() - this.b > 5000;
    }

    final void a(String str) {
        this.b = -1L;
        try {
            a(this.c, str);
        } catch (Exception e) {
            com.apm.insight.a.a((Throwable) e);
        }
    }

    final void b(String str) {
        this.b = SystemClock.uptimeMillis();
        try {
            a(this.d, str);
        } catch (Exception e) {
            com.apm.insight.a.b((Throwable) e);
        }
    }

    private static void a(List<? extends Printer> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Printer printer = list.get(i);
                if (printer == null) {
                    return;
                }
                printer.println(str);
            }
        } catch (Throwable th) {
            com.apm.insight.a.a(th);
        }
    }
}
