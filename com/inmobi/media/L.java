package com.inmobi.media;

import android.os.SystemClock;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.commons.core.configs.RootConfig;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class L extends AbstractC2864se {
    public final InterfaceC2971z5 d;
    public final WeakReference e;
    public K f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(S0 adUnit, InterfaceC2971z5 interfaceC2971z5) {
        super(adUnit, (byte) 0);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.d = interfaceC2971z5;
        this.e = new WeakReference(adUnit);
    }

    @Override // com.inmobi.media.AbstractC2864se
    public final void a(Object obj) {
        C2947y0 c2947y0 = (C2947y0) obj;
        S0 s0 = (S0) this.e.get();
        if (s0 == null) {
            return;
        }
        s0.b((byte) 0);
        if (this.f == null) {
            if (c2947y0 == null) {
                s0.a(s0.I(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                return;
            } else if (c2947y0.m()) {
                s0.c(c2947y0);
                return;
            } else {
                s0.d(c2947y0);
                return;
            }
        }
        Z I = s0.I();
        K k = this.f;
        Intrinsics.checkNotNull(k);
        InMobiAdRequestStatus inMobiAdRequestStatus = k.f2330a;
        K k2 = this.f;
        Intrinsics.checkNotNull(k2);
        s0.a(I, inMobiAdRequestStatus, k2.b);
    }

    @Override // com.inmobi.media.G1
    public final void c() {
        super.c();
        S0 s0 = (S0) this.e.get();
        if (s0 == null) {
            return;
        }
        s0.b((byte) 0);
        s0.a(s0.I(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), (short) 2117);
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.d;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("AdFetcherTask", "executeTask " + this);
        }
        S0 s0 = (S0) this.e.get();
        if (s0 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.d;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("AdFetcherTask", "adUnit is null. fail");
            }
            this.f = new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 2111);
            b(null);
            return;
        }
        LinkedHashMap linkedHashMap = O2.f2380a;
        if (!((RootConfig) AbstractC2808p5.a("root", "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig", null)).getMonetizationDisabled()) {
            U0 s = s0.s();
            s.getClass();
            s.f = SystemClock.elapsedRealtime();
            try {
                InterfaceC2971z5 interfaceC2971z53 = this.d;
                if (interfaceC2971z53 != null) {
                    ((A5) interfaceC2971z53).a("AdFetcherTask", "getting ad from store");
                }
                b(s0.p().a(s0.h0(), s0.F()));
                return;
            } catch (K e) {
                Intrinsics.checkNotNullExpressionValue(S0.e(), "<get-TAG>(...)");
                this.f = e;
                b(null);
                return;
            }
        }
        InterfaceC2971z5 interfaceC2971z54 = this.d;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).b("AdFetcherTask", "SDK will not perform this load operation as monetization has been disabled. Please contact InMobi for further info.");
        }
        this.f = new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MONETIZATION_DISABLED), (short) 2012);
        b(null);
    }
}
