package io.bidmachine.rendering.internal.controller;

import android.content.Context;
import io.bidmachine.rendering.internal.n;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.internal.view.f;
import io.bidmachine.rendering.model.AdParams;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.AnimationEventType;
import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.CacheType;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.Orientation;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.Tag;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.Executable;
import io.bidmachine.util.Utils;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public class b implements io.bidmachine.rendering.internal.controller.a {

    /* renamed from: a, reason: collision with root package name */
    private final Tag f6986a;
    private final Context b;
    private final AdParams c;
    private final io.bidmachine.rendering.internal.controller.c d;
    private final io.bidmachine.rendering.internal.animation.b e;
    private final io.bidmachine.rendering.internal.state.a f;
    final Queue<e> g;
    private final AtomicBoolean h;
    private final AtomicBoolean i;
    private final AtomicBoolean j;
    io.bidmachine.rendering.internal.view.f k;
    volatile e l;
    volatile e m;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6987a;

        static {
            int[] iArr = new int[CacheType.values().length];
            f6987a = iArr;
            try {
                iArr[CacheType.FullLoad.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6987a[CacheType.PartialLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6987a[CacheType.StreamLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private class c implements g {

        /* renamed from: a, reason: collision with root package name */
        private final io.bidmachine.rendering.internal.controller.c f6989a;

        public c(io.bidmachine.rendering.internal.controller.c adControllerListener) {
            this.f6989a = adControllerListener;
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void a() {
            this.f6989a.a();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void b() {
            b.this.g();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void c() {
            this.f6989a.c();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void d() {
            this.f6989a.onAdClicked();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void e() {
            if (!b.this.j()) {
                b();
            } else {
                b.this.u();
                b.this.v();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void a(PrivacySheetParams privacySheetParams) {
            this.f6989a.a(privacySheetParams);
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void a(BrokenCreativeEvent brokenCreativeEvent) {
            b.this.a(brokenCreativeEvent);
        }
    }

    private class d implements f.d {
        private d() {
        }

        @Override // io.bidmachine.rendering.internal.view.f.d
        public void a() {
            b.this.q();
        }

        @Override // io.bidmachine.rendering.internal.view.f.d
        public void onLoaded() {
            b.this.s();
        }

        /* synthetic */ d(b bVar, a aVar) {
            this();
        }

        @Override // io.bidmachine.rendering.internal.view.f.d
        public void a(BrokenCreativeEvent brokenCreativeEvent) {
            b.this.a(brokenCreativeEvent);
        }
    }

    public b(Context context, AdParams adParams, io.bidmachine.rendering.internal.controller.c adControllerListener, io.bidmachine.rendering.internal.animation.b adAnimationController) {
        Tag tag = new Tag(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6184a);
        this.f6986a = tag;
        this.f = new io.bidmachine.rendering.internal.state.d(tag.toString());
        this.b = context.getApplicationContext();
        this.c = adParams;
        this.d = adControllerListener;
        this.e = adAnimationController;
        this.g = new ConcurrentLinkedQueue();
        this.h = new AtomicBoolean(false);
        this.i = new AtomicBoolean(false);
        this.j = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(e eVar) {
        if (this.f.i()) {
            v();
            this.d.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(e eVar) {
        a(eVar, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Utils.ifNotNull(this.l, new Executable() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda2
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                b.this.g((e) obj);
            }
        });
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public void f() {
        o.b(this.f6986a, "performHide", new Object[0]);
        Utils.ifNotNull(this.l, new Executable() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda5
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                ((e) obj).a(false);
            }
        });
        r();
    }

    CacheType h() {
        return this.c.getCacheType();
    }

    e i() {
        return this.g.peek();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void d(e adPhaseController) {
        o.b(this.f6986a, "removeAndDestroyAdPhaseController (%s)", adPhaseController);
        Utils.ifNotNull(adPhaseController, new Executable() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda3
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                b.this.i((e) obj);
            }
        });
        b(adPhaseController);
    }

    boolean k() {
        Iterator<e> it = this.g.iterator();
        while (it.hasNext()) {
            if (!it.next().b()) {
                return false;
            }
        }
        return true;
    }

    public boolean l() {
        return this.f.b();
    }

    void m() {
        if (this.h.compareAndSet(false, true)) {
            for (e eVar : this.g) {
                o.b(this.f6986a, "loadAdPhase (%s)", eVar);
                eVar.c();
            }
        }
    }

    void n() {
        final AdPhaseParams placeholderParams = this.c.getPlaceholderParams();
        UiUtils.onUiThread(new n() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda0
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                b.this.a(placeholderParams);
            }
        });
    }

    void o() {
        if (this.f.k()) {
            this.d.a(this);
        }
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public void onShown() {
        o.b(this.f6986a, "onShown", new Object[0]);
        Utils.ifNotNull(this.l, new Executable() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda9
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                b.this.e((e) obj);
            }
        });
    }

    boolean p() {
        if (!this.f.a(true)) {
            return false;
        }
        this.d.b(this);
        return true;
    }

    void q() {
        this.d.e();
    }

    void r() {
        io.bidmachine.rendering.internal.view.f fVar = this.k;
        if (fVar != null && this.j.compareAndSet(true, false)) {
            fVar.i();
            this.d.b(fVar);
        }
    }

    void s() {
        p();
    }

    void t() {
        io.bidmachine.rendering.internal.view.f fVar = this.k;
        if (fVar != null && this.j.compareAndSet(false, true)) {
            this.d.a(fVar);
            fVar.j();
        }
    }

    public String toString() {
        return this.f6986a.toString();
    }

    void u() {
        if (this.i.compareAndSet(false, true)) {
            this.d.d();
            this.m = this.l;
            e i = i();
            if (i == null) {
                b(this.m, this.m == null ? new Error("No ad phase to show") : null);
            } else {
                if (this.m != i) {
                    i(i);
                    i.a(new c(this.d));
                    this.l = i;
                    this.e.a(i.getAdPhase(), AnimationEventType.Appear);
                }
                this.d.a(i);
                r();
            }
            this.i.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        final io.bidmachine.rendering.internal.controller.c cVar = this.d;
        Objects.requireNonNull(cVar);
        n nVar = new n() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda8
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                c.this.b();
            }
        };
        e eVar = this.l;
        if (eVar == null) {
            nVar.run();
        } else {
            eVar.a(true);
            this.e.a(eVar.getAdPhase(), AnimationEventType.Disappear, false, (Runnable) null, (Runnable) nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(e eVar) {
        eVar.d();
        eVar.onShown();
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public void a() {
        o.b(this.f6986a, "destroy", new Object[0]);
        this.e.a();
        b(this.l);
        Iterator<e> it = this.g.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        e();
        Utils.ifNotNull(this.k, new Executable() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda4
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                ((io.bidmachine.rendering.internal.view.f) obj).b();
            }
        });
        this.k = null;
        this.f.a();
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public Orientation b() {
        return this.c.getOrientation();
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public void c() {
        o.b(this.f6986a, "load (cacheType - %s)", h());
        io.bidmachine.rendering.internal.f.b(this.b);
        Queue<AdPhaseParams> adPhaseParamsQueue = this.c.getAdPhaseParamsQueue();
        if (adPhaseParamsQueue.isEmpty()) {
            this.d.a(this, new Error("Ad phase queue is empty"));
            return;
        }
        if (l()) {
            this.d.b(this);
            return;
        }
        if (this.f.c()) {
            for (AdPhaseParams adPhaseParams : adPhaseParamsQueue) {
                Tag tag = new Tag("AdPhaseController");
                a(new h(this.b, adPhaseParams, tag, new io.bidmachine.rendering.internal.state.c(tag.toString(), io.bidmachine.rendering.internal.h.f()), new C0615b(), this.e));
            }
            int i = a.f6987a[h().ordinal()];
            if (i == 1) {
                m();
                return;
            }
            if (i == 2) {
                n();
                m();
            } else {
                if (i != 3) {
                    return;
                }
                n();
            }
        }
    }

    @Override // io.bidmachine.rendering.internal.controller.a
    public boolean d() {
        o.b(this.f6986a, "performShow", new Object[0]);
        this.f.l();
        e eVar = this.l;
        if (eVar == null) {
            t();
            m();
            return false;
        }
        if (!this.f.m()) {
            return true;
        }
        eVar.d();
        return true;
    }

    boolean i(e adPhaseController) {
        return this.g.remove(adPhaseController);
    }

    void b(e adPhaseController) {
        o.b(this.f6986a, "destroyAdPhaseController (%s)", adPhaseController);
        Utils.ifNotNull(adPhaseController, new Executable() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda10
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                ((e) obj).a();
            }
        });
        if (this.l == adPhaseController) {
            this.l = null;
        }
        if (this.m == adPhaseController) {
            this.m = null;
        }
    }

    boolean j() {
        return i() != null;
    }

    /* renamed from: io.bidmachine.rendering.internal.controller.b$b, reason: collision with other inner class name */
    class C0615b implements f {
        C0615b() {
        }

        @Override // io.bidmachine.rendering.internal.controller.f
        public void a(e adPhaseController) {
            o.b(b.this.f6986a, "onAdPhaseLoaded (%s)", adPhaseController);
            if (b.this.k()) {
                b.this.u();
                b.this.p();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.f
        public void a(e adPhaseController, Error error) {
            o.a(b.this.f6986a, "onAdPhaseFailToLoad (%s) - %s", adPhaseController, error);
            b.this.d(adPhaseController);
            if (b.this.l()) {
                if (b.this.f.d()) {
                    b.this.b(adPhaseController, new Error("Fail to load after show (CacheType - " + b.this.h() + ") - " + error));
                    return;
                } else {
                    b.this.o();
                    return;
                }
            }
            b.this.a(error);
        }
    }

    void e() {
        this.g.clear();
    }

    void b(final e adPhaseController, Error error) {
        Utils.ifNotNull(error, new Executable() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda11
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                b.this.a(adPhaseController, (Error) obj);
            }
        });
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AdPhaseParams adPhaseParams) {
        if (this.k != null) {
            return;
        }
        io.bidmachine.rendering.internal.view.f fVar = new io.bidmachine.rendering.internal.view.f(this.b, adPhaseParams, this.e);
        this.k = fVar;
        fVar.setListener(new d(this, null));
        this.k.e();
    }

    private void a(final e adPhaseController, e prevAdPhaseController) {
        Utils.ifNotNull(prevAdPhaseController, new Executable() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda6
            @Override // io.bidmachine.util.Executable
            public final void execute(Object obj) {
                b.this.c((e) obj);
            }
        });
        this.e.a(adPhaseController.getAdPhase(), AnimationEventType.Appear, false, (Runnable) null, (Runnable) new n() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda7
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                b.h(e.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(e eVar, Error error) {
        this.d.a(eVar, error);
    }

    boolean a(e adPhaseController) {
        return this.g.add(adPhaseController);
    }

    boolean a(Error error) {
        if (!this.f.a(false)) {
            return false;
        }
        this.d.a(this, error);
        return true;
    }

    void a(BrokenCreativeEvent brokenCreativeEvent) {
        if (this.f.h()) {
            return;
        }
        this.d.a(brokenCreativeEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final e adPhaseController) {
        n nVar = new n() { // from class: io.bidmachine.rendering.internal.controller.b$$ExternalSyntheticLambda1
            @Override // io.bidmachine.util.SafeRunnable
            public final void onRun() {
                b.this.d(adPhaseController);
            }
        };
        adPhaseController.a(true);
        this.e.a(adPhaseController.getAdPhase(), AnimationEventType.Disappear, false, (Runnable) null, (Runnable) nVar);
    }
}
