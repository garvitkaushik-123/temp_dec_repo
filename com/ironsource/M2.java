package com.ironsource;

import android.text.TextUtils;
import com.ironsource.AbstractC3222o0;
import com.ironsource.D0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes6.dex */
public class M2 extends AbstractC3222o0 {
    private final WeakReference<P2> k;
    private final a l;
    private final N2 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M2(C3205n0 tools, N2 adUnitData, P2 listener) {
        super(tools, adUnitData, listener, null, 8, null);
        String format;
        int b;
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.k = new WeakReference<>(listener);
        this.l = new a();
        this.m = adUnitData;
        Placement g = g();
        IronLog.INTERNAL.verbose("placement = " + g);
        if (g == null || TextUtils.isEmpty(g.getPlacementName())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format("can't load banner - %s", Arrays.copyOf(new Object[]{g == null ? "placement is null" : "placement name is empty"}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            b = C3408z0.b(adUnitData.b().a());
        } else {
            format = null;
            b = 510;
        }
        if (format != null) {
            IronLog.API.error(a(format));
            a(b, format);
        }
    }

    private final ISBannerSize m() {
        return f().a(this.m.b().h());
    }

    @Override // com.ironsource.AbstractC3222o0
    public C3256q0 b() {
        return new T2(this.m.b(), a(m()));
    }

    private final class a extends AbstractC3222o0.a implements A2 {
        public a() {
            super();
        }

        @Override // com.ironsource.A2
        public void a(C3393y2 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            IronLog.INTERNAL.verbose(M2.this.a(instance.q()));
            P2 p2 = (P2) M2.this.k.get();
            if (p2 != null) {
                p2.i();
            }
        }

        @Override // com.ironsource.AbstractC3222o0.a, com.ironsource.D
        public void b(AbstractC3407z instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            super.b(instance);
            InterfaceC3374x0 i = M2.this.i();
            if (i != null) {
                i.f();
            }
        }

        @Override // com.ironsource.A2
        public void c(C3393y2 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            IronLog.INTERNAL.verbose(M2.this.a(instance.q()));
            P2 p2 = (P2) M2.this.k.get();
            if (p2 != null) {
                p2.j();
            }
        }

        @Override // com.ironsource.A2
        public void b(C3393y2 instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            IronLog.INTERNAL.verbose(M2.this.a(instance.q()));
            P2 p2 = (P2) M2.this.k.get();
            if (p2 != null) {
                p2.m();
            }
        }
    }

    public final void a(Yf yf, InterfaceC3374x0 displayListener) {
        Intrinsics.checkNotNullParameter(displayListener, "displayListener");
        if (yf != null) {
            a(new C2(yf), displayListener);
        }
    }

    @Override // com.ironsource.AbstractC3222o0
    protected C a() {
        return new C() { // from class: com.ironsource.M2$$ExternalSyntheticLambda0
            @Override // com.ironsource.C
            public final AbstractC3407z a(A a2, G g) {
                AbstractC3407z a3;
                a3 = M2.a(M2.this, a2, g);
                return a3;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC3407z a(M2 this$0, A instanceData, G adInstancePayload) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        Intrinsics.checkNotNullParameter(adInstancePayload, "adInstancePayload");
        return new C3393y2(new V0(this$0.f(), D0.b.PROVIDER), instanceData, adInstancePayload, this$0.l);
    }

    private final ISBannerSize a(ISBannerSize iSBannerSize) {
        if (!iSBannerSize.isSmart()) {
            return iSBannerSize;
        }
        if (AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext())) {
            return com.ironsource.mediationsdk.l.a();
        }
        return ISBannerSize.BANNER;
    }
}
