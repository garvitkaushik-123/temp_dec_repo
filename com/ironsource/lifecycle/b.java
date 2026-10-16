package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.ironsource.W9;
import com.ironsource.X9;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.lifecycle.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class b implements Application.ActivityLifecycleCallbacks {
    private static final b m = new b();
    private static AtomicBoolean n = new AtomicBoolean(false);
    static final long o = 700;

    /* renamed from: a, reason: collision with root package name */
    private int f3472a = 0;
    private int b = 0;
    private boolean c = true;
    private boolean d = true;
    private X9 e = X9.NONE;
    private final List<W9> f = new CopyOnWriteArrayList();
    private final Runnable g = new Runnable() { // from class: com.ironsource.lifecycle.b$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            b.this.f();
        }
    };
    private final Runnable h = new Runnable() { // from class: com.ironsource.lifecycle.b$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            b.this.g();
        }
    };
    private final Runnable i = new Runnable() { // from class: com.ironsource.lifecycle.b$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            b.this.h();
        }
    };
    private final Runnable j = new Runnable() { // from class: com.ironsource.lifecycle.b$$ExternalSyntheticLambda3
        @Override // java.lang.Runnable
        public final void run() {
            b.this.i();
        }
    };
    private final Runnable k = new Runnable() { // from class: com.ironsource.lifecycle.b$$ExternalSyntheticLambda4
        @Override // java.lang.Runnable
        public final void run() {
            b.this.j();
        }
    };
    private final a.InterfaceC0293a l = new a();

    class a implements a.InterfaceC0293a {
        a() {
        }

        @Override // com.ironsource.lifecycle.a.InterfaceC0293a
        public void a(Activity activity) {
            b.this.c(activity);
        }

        @Override // com.ironsource.lifecycle.a.InterfaceC0293a
        public void b(Activity activity) {
        }

        @Override // com.ironsource.lifecycle.a.InterfaceC0293a
        public void onResume(Activity activity) {
            b.this.b(activity);
        }
    }

    public static b d() {
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        Iterator<W9> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        Iterator<W9> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        Iterator<W9> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        Iterator<W9> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void a(W9 w9) {
        if (!IronsourceLifecycleProvider.a() || w9 == null || this.f.contains(w9)) {
            return;
        }
        this.f.add(w9);
    }

    public void b(W9 w9) {
        if (this.f.contains(w9)) {
            this.f.remove(w9);
        }
    }

    public X9 c() {
        return this.e;
    }

    public boolean e() {
        return this.e == X9.STOPPED;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        com.ironsource.lifecycle.a.b(activity);
        com.ironsource.lifecycle.a a2 = com.ironsource.lifecycle.a.a(activity);
        if (a2 != null) {
            a2.d(this.l);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        d(activity);
    }

    void c(Activity activity) {
        int i = this.f3472a + 1;
        this.f3472a = i;
        if (i == 1 && this.d) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.k);
            this.d = false;
            this.e = X9.STARTED;
        }
    }

    void d(Activity activity) {
        this.f3472a--;
        b();
    }

    void b(Activity activity) {
        int i = this.b + 1;
        this.b = i;
        if (i == 1) {
            if (this.c) {
                IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.j);
                this.c = false;
                this.e = X9.RESUMED;
                return;
            }
            IronSourceThreadManager.INSTANCE.removeUiThreadTask(this.g);
        }
    }

    void a(Context context) {
        Application application;
        if (!n.compareAndSet(false, true) || (application = (Application) context.getApplicationContext()) == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
    }

    private void b() {
        if (this.f3472a == 0 && this.c) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.i);
            this.d = true;
            this.e = X9.STOPPED;
        }
    }

    void a(Activity activity) {
        int i = this.b - 1;
        this.b = i;
        if (i == 0) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(this.g, 700L);
        }
    }

    private void a() {
        if (this.b == 0) {
            this.c = true;
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.h);
            this.e = X9.PAUSED;
        }
    }
}
