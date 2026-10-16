package com.ironsource;

import com.ironsource.F;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class gg implements E {

    /* renamed from: a, reason: collision with root package name */
    private final V0 f3326a;
    private final AbstractC3340v0 b;
    private final ng c;
    private final ig d;
    private F e;
    private pg f;
    private final List<AbstractC3407z> g;
    private AbstractC3407z h;
    private boolean i;

    public gg(V0 adTools, AbstractC3340v0 adUnitData, ng listener) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f3326a = adTools;
        this.b = adUnitData;
        this.c = listener;
        this.d = ig.d.a(adTools, adUnitData);
        this.g = new ArrayList();
    }

    private final boolean e() {
        return this.h != null;
    }

    private final void f() {
        F f = this.e;
        F.b d = f != null ? f.d() : null;
        if (d == null || d.e()) {
            this.c.a(509, "Mediation No fill");
            return;
        }
        if (!d.f()) {
            Iterator<AbstractC3407z> it = d.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        } else {
            pg pgVar = this.f;
            if (pgVar != null) {
                pgVar.a();
            }
        }
    }

    public final AbstractC3407z c() {
        F.c c;
        F f = this.e;
        if (f == null || (c = f.c()) == null) {
            return null;
        }
        return c.c();
    }

    public final boolean d() {
        Iterator<AbstractC3407z> it = this.g.iterator();
        while (it.hasNext()) {
            if (it.next().z()) {
                return true;
            }
        }
        return false;
    }

    private final void c(AbstractC3407z abstractC3407z) {
        d(abstractC3407z);
        b();
    }

    public final void b() {
        IronLog.INTERNAL.verbose(C3205n0.a(this.f3326a, "dispose", (String) null, 2, (Object) null));
        Iterator<T> it = this.g.iterator();
        while (it.hasNext()) {
            ((AbstractC3407z) it.next()).c();
        }
        this.g.clear();
        this.f3326a.e().h().a();
    }

    private final void d(AbstractC3407z abstractC3407z) {
        this.h = abstractC3407z;
        this.g.remove(abstractC3407z);
    }

    public final void a(C adInstanceFactory) {
        Intrinsics.checkNotNullParameter(adInstanceFactory, "adInstanceFactory");
        this.d.a(adInstanceFactory, new a());
    }

    public static final class a implements jg {
        a() {
        }

        @Override // com.ironsource.jg
        public void a(kg waterfallInstances) {
            Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
            if (gg.this.i) {
                return;
            }
            gg.this.a(waterfallInstances);
        }

        @Override // com.ironsource.jg
        public void a(int i, String errorReason) {
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            if (gg.this.i) {
                return;
            }
            gg.this.c.a(i, errorReason);
        }
    }

    public final void a(I adInstancePresenter) {
        AbstractC3407z c;
        Intrinsics.checkNotNullParameter(adInstancePresenter, "adInstancePresenter");
        F f = this.e;
        F.c c2 = f != null ? f.c() : null;
        if (c2 == null || (c = c2.c()) == null) {
            return;
        }
        c(c);
        pg pgVar = this.f;
        if (pgVar != null) {
            pgVar.a(c2.c(), c2.d());
        }
        c2.c().a(adInstancePresenter);
    }

    public final void a() {
        this.i = true;
        AbstractC3407z abstractC3407z = this.h;
        if (abstractC3407z != null) {
            abstractC3407z.b();
        }
    }

    @Override // com.ironsource.E
    public void a(AbstractC3407z instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (!this.i && !e()) {
            pg pgVar = this.f;
            if (pgVar != null) {
                pgVar.a(instance);
            }
            this.g.add(instance);
            if (this.g.size() == 1) {
                pg pgVar2 = this.f;
                if (pgVar2 != null) {
                    pgVar2.b(instance);
                }
                this.c.b(instance);
                return;
            }
            F f = this.e;
            if (f == null || !f.a(instance)) {
                return;
            }
            this.c.a(instance);
            return;
        }
        instance.c();
    }

    @Override // com.ironsource.E
    public void a(IronSourceError error, AbstractC3407z instance) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (this.i) {
            return;
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(kg kgVar) {
        F a2 = F.c.a(this.b, kgVar);
        this.e = a2;
        this.f = pg.c.a(this.f3326a, this.b, this.d.a(), kgVar, a2);
        f();
    }

    public final void b(AbstractC3407z instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        pg pgVar = this.f;
        if (pgVar != null) {
            pgVar.a(instance, this.b.l(), this.b.o());
        }
    }
}
