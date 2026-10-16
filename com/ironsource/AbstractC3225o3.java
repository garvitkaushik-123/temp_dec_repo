package com.ironsource;

import android.app.Activity;
import com.ironsource.AbstractC3292s3;
import com.ironsource.I0;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Locale;

/* renamed from: com.ironsource.o3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3225o3<Listener extends I0> extends AbstractC3292s3<Listener> implements AdapterAdInteractionListener {

    /* renamed from: com.ironsource.o3$a */
    class a extends Pd {
        a() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3225o3.this.P();
        }
    }

    /* renamed from: com.ironsource.o3$b */
    class b extends Pd {
        b() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3225o3.this.S();
        }
    }

    /* renamed from: com.ironsource.o3$c */
    class c extends Pd {
        c() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3225o3.this.Q();
        }
    }

    /* renamed from: com.ironsource.o3$d */
    class d extends Pd {
        d() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3225o3.this.T();
        }
    }

    /* renamed from: com.ironsource.o3$e */
    class e extends Pd {
        e() {
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3225o3.this.R();
        }
    }

    /* renamed from: com.ironsource.o3$f */
    class f extends Pd {
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        f(int i, String str) {
            this.b = i;
            this.c = str;
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3225o3.this.b(this.b, this.c);
        }
    }

    public AbstractC3225o3(InterfaceC3012bd interfaceC3012bd, C3171l0 c3171l0, BaseAdAdapter<?, ?> baseAdAdapter, C3000b1 c3000b1, C3207n2 c3207n2, Listener listener) {
        super(interfaceC3012bd, c3171l0, baseAdAdapter, c3000b1, c3207n2, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        synchronized (this.q) {
            if (this.e != AbstractC3292s3.h.SHOWING) {
                ironLog.error("unexpected ad closed for " + k() + " - state = " + this.e);
                D0 d0 = this.d;
                if (d0 != null) {
                    d0.j.l("unexpected ad closed - state = " + this.e);
                }
                return;
            }
            a(AbstractC3292s3.h.NONE);
            if (this.d != null) {
                String str = "";
                if (this.f3690a.a() == IronSource.AD_UNIT.REWARDED_VIDEO) {
                    String f2 = ((I0) this.b).f();
                    str = "otherInstanceAvailable = " + (f2.length() > 0 ? "true|" + f2 : "false");
                }
                this.d.i.a(j(), str);
            }
            ((I0) this.b).a((AbstractC3225o3<?>) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.d;
        if (d0 != null) {
            d0.i.d(j());
        }
        ((I0) this.b).c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.d;
        if (d0 != null) {
            d0.i.l(j());
        }
        ((I0) this.b).b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.d;
        if (d0 != null) {
            d0.i.i(j());
        }
        ((I0) this.b).d((AbstractC3225o3<?>) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        IronLog.INTERNAL.verbose(d());
        D0 d0 = this.d;
        if (d0 != null) {
            d0.i.k(j());
        }
    }

    @Override // com.ironsource.AbstractC3292s3
    public boolean B() {
        Object obj;
        if (this.k == null || !y()) {
            return false;
        }
        try {
            obj = this.c;
        } catch (Throwable th) {
            C3260q4.d().a(th);
            String str = "isReadyToShow - exception = " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            D0 d0 = this.d;
            if (d0 != null) {
                d0.j.g(str);
            }
        }
        if (obj instanceof AdapterAdFullScreenInterface) {
            return ((AdapterAdFullScreenInterface) obj).isAdAvailable(this.k);
        }
        IronLog.INTERNAL.error(a("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface"));
        D0 d02 = this.d;
        if (d02 != null) {
            d02.j.g("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface");
        }
        return false;
    }

    public void a(Activity activity, Placement placement) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("placementName = " + placement.getPlacementName()));
        try {
            this.g = placement;
            a(AbstractC3292s3.h.SHOWING);
            this.d.i.a(activity, j());
            Object obj = this.c;
            if (obj instanceof AdapterAdFullScreenInterface) {
                ((AdapterAdFullScreenInterface) obj).showAd(this.k, this);
                return;
            }
            ironLog.error(a("showAd - adapter not instance of AdapterAdFullScreenInterface"));
            D0 d0 = this.d;
            if (d0 != null) {
                d0.j.g("showAd - adapter not instance of AdapterAdFullScreenInterface");
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            a(AbstractC3292s3.h.FAILED);
            String str = "showAd - exception = " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            D0 d02 = this.d;
            if (d02 != null) {
                d02.j.g(str);
            }
            onAdShowFailed(C3408z0.h(this.f3690a.a()), str);
        }
    }

    public void b(boolean z) {
        D0 d0 = this.d;
        if (d0 != null) {
            d0.i.a(z);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        if (u().e()) {
            u().a(new a());
        } else {
            P();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdEnded() {
        if (u().e()) {
            u().a(new c());
        } else {
            Q();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowFailed(int i, String str) {
        if (u().e()) {
            u().a(new f(i, str));
        } else {
            b(i, str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowSuccess() {
        if (u().e()) {
            u().a(new e());
        } else {
            R();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdStarted() {
        if (u().e()) {
            u().a(new b());
        } else {
            S();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdVisible() {
        if (u().e()) {
            u().a(new d());
        } else {
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("error = " + i + ", " + str));
        AbstractC3292s3.h hVar = this.e;
        if (hVar == AbstractC3292s3.h.SHOWING) {
            a(AbstractC3292s3.h.FAILED);
            D0 d0 = this.d;
            if (d0 != null) {
                d0.i.a(j(), i, str, "");
            }
            ((I0) this.b).a(new IronSourceError(i, str), (AbstractC3225o3<?>) this);
            return;
        }
        String a2 = a(hVar, i, str);
        ironLog.error(a(a2));
        D0 d02 = this.d;
        if (d02 != null) {
            d02.j.t(a2);
        }
    }

    static String a(AbstractC3292s3.h hVar, int i, String str) {
        return String.format(Locale.ENGLISH, "unexpected show failed, state - %s, error - %d %s", hVar, Integer.valueOf(i), str);
    }
}
