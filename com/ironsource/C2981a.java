package com.ironsource;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* renamed from: com.ironsource.a, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C2981a extends Thread {
    private static final int l = 1;
    private static final InterfaceC2998b m = new C0284a();
    private static final InterfaceC3130i9 n = new b();
    private final int d;

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC2998b f3170a = m;
    private InterfaceC3130i9 b = n;
    private final Handler c = new Handler(Looper.getMainLooper());
    private String e = "";
    private boolean f = false;
    private boolean g = false;
    private volatile int h = 0;
    private int i = 1;
    private int j = 0;
    private final Runnable k = new c();

    /* renamed from: com.ironsource.a$a, reason: collision with other inner class name */
    class C0284a implements InterfaceC2998b {
        C0284a() {
        }

        @Override // com.ironsource.InterfaceC2998b
        public void a() {
        }

        @Override // com.ironsource.InterfaceC2998b
        public void b() {
            throw new RuntimeException("ANRHandler has given up");
        }
    }

    /* renamed from: com.ironsource.a$b */
    class b implements InterfaceC3130i9 {
        b() {
        }

        @Override // com.ironsource.InterfaceC3130i9
        public void a(InterruptedException interruptedException) {
            Log.w("ANRHandler", "Interrupted: " + interruptedException.getMessage());
        }
    }

    /* renamed from: com.ironsource.a$c */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2981a c2981a = C2981a.this;
            c2981a.h = (c2981a.h + 1) % Integer.MAX_VALUE;
        }
    }

    public C2981a(int i) {
        this.d = i;
    }

    public void a(int i) {
        this.i = i;
    }

    public int b() {
        return this.i;
    }

    public C2981a c() {
        this.e = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        setName("|ANR-ANRHandler|");
        int i = -1;
        while (!isInterrupted() && this.j < this.i) {
            int i2 = this.h;
            this.c.post(this.k);
            try {
                Thread.sleep(this.d);
                if (this.h != i2) {
                    this.j = 0;
                } else if (this.g || !Debug.isDebuggerConnected()) {
                    this.j++;
                    this.f3170a.a();
                    String str = C3260q4.l;
                    if (str != null && !str.trim().isEmpty()) {
                        new M5(C3260q4.l, String.valueOf(System.currentTimeMillis()), "ANR").a();
                    }
                } else {
                    if (this.h != i) {
                        Log.w("ANRHandler", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                    }
                    i = this.h;
                }
            } catch (InterruptedException e) {
                this.b.a(e);
                return;
            }
        }
        if (this.j >= this.i) {
            this.f3170a.b();
        }
    }

    public int a() {
        return this.j;
    }

    public C2981a b(boolean z) {
        this.f = z;
        return this;
    }

    public C2981a a(InterfaceC2998b interfaceC2998b) {
        if (interfaceC2998b == null) {
            this.f3170a = m;
            return this;
        }
        this.f3170a = interfaceC2998b;
        return this;
    }

    public C2981a a(InterfaceC3130i9 interfaceC3130i9) {
        if (interfaceC3130i9 == null) {
            this.b = n;
            return this;
        }
        this.b = interfaceC3130i9;
        return this;
    }

    public C2981a a(String str) {
        if (str == null) {
            str = "";
        }
        this.e = str;
        return this;
    }

    public C2981a a(boolean z) {
        this.g = z;
        return this;
    }

    private String a(StackTraceElement[] stackTraceElementArr) {
        String str = "";
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (stackTraceElement != null) {
                    str = str + stackTraceElement.toString() + ";\n";
                }
            }
        }
        return str;
    }
}
