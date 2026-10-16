package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import io.bidmachine.iab.utils.VisibilityTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class lf {

    /* renamed from: a, reason: collision with root package name */
    public final WeakHashMap f2635a;
    public final ff b;
    public final Handler c;
    public final byte d;
    public final InterfaceC2971z5 e;
    public final int f;
    public final ArrayList g;
    public long h;
    public final AtomicBoolean i;
    public hf j;
    public final Lazy k;
    public final Lazy l;
    public boolean m;

    public lf(ff visibilityChecker, byte b, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(visibilityChecker, "visibilityChecker");
        WeakHashMap weakHashMap = new WeakHashMap(10);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f2635a = weakHashMap;
        this.b = visibilityChecker;
        this.c = handler;
        this.d = b;
        this.e = interfaceC2971z5;
        this.f = 50;
        this.g = new ArrayList(50);
        this.i = new AtomicBoolean(true);
        this.k = LazyKt.lazy(new jf(this));
        this.l = LazyKt.lazy(new kf(this));
    }

    public final void a(View view, Object obj, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(view, "view");
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c(VisibilityTracker.TAG, "add view to tracker - minPercent - " + i + "  " + this);
        }
        Cif cif = (Cif) this.f2635a.get(view);
        if (cif == null) {
            cif = new Cif();
            this.f2635a.put(view, cif);
            this.h++;
        }
        cif.f2603a = i;
        long j = this.h;
        cif.b = j;
        cif.c = view;
        cif.d = obj;
        long j2 = this.f;
        if (j % j2 == 0) {
            long j3 = j - j2;
            for (Map.Entry entry : this.f2635a.entrySet()) {
                View view2 = (View) entry.getKey();
                if (((Cif) entry.getValue()).b < j3) {
                    this.g.add(view2);
                }
            }
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                View view3 = (View) it.next();
                Intrinsics.checkNotNull(view3);
                a(view3);
            }
            this.g.clear();
        }
        if (this.f2635a.size() == 1) {
            f();
        }
    }

    public void b() {
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c(VisibilityTracker.TAG, "destroy " + this);
        }
        a();
        this.j = null;
        this.i.set(true);
    }

    public abstract int c();

    public abstract void d();

    public void e() {
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c(VisibilityTracker.TAG, "pause " + this);
        }
        ((gf) this.k.getValue()).run();
        this.c.removeCallbacksAndMessages(null);
        this.m = false;
        this.i.set(true);
    }

    public void f() {
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c(VisibilityTracker.TAG, "resume " + this);
        }
        this.i.set(false);
        g();
    }

    public final void g() {
        if (this.m || this.i.get()) {
            return;
        }
        this.m = true;
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue()).schedule((Runnable) this.l.getValue(), c(), TimeUnit.MILLISECONDS);
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c(VisibilityTracker.TAG, "removed view from tracker " + this);
        }
        if (((Cif) this.f2635a.remove(view)) != null) {
            this.h--;
            if (this.f2635a.isEmpty()) {
                e();
            }
        }
    }

    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c(VisibilityTracker.TAG, "clear " + this);
        }
        this.f2635a.clear();
        this.c.removeMessages(0);
        this.m = false;
    }
}
