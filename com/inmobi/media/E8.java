package com.inmobi.media;

import android.os.SystemClock;
import com.inmobi.ads.InMobiAdRequestStatus;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class E8 extends AbstractC2864se {
    public final WeakReference d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E8(C2596c8 adUnit) {
        super(adUnit, (byte) 6);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.d = new WeakReference(adUnit);
    }

    @Override // com.inmobi.media.AbstractC2864se
    public final void a(Object obj) {
        short shortValue = ((Number) obj).shortValue();
        S0 s0 = (C2596c8) this.d.get();
        if (s0 == null) {
            return;
        }
        if (shortValue != 0) {
            s0.a(new WeakReference<>(s0.r()), shortValue, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            return;
        }
        if (2 == s0.Q()) {
            s0.d((byte) 4);
            InterfaceC2930x k = s0.k();
            GestureDetectorOnGestureListenerC2634ec x = s0.x();
            F0 r = s0.r();
            if (!(k instanceof T7)) {
                if (r != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    r.a(s0, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                    return;
                }
                return;
            }
            T7 t7 = (T7) k;
            t7.H = x;
            t7.K = s0.T();
            U0 s = s0.s();
            s.getClass();
            s.i = SystemClock.elapsedRealtime();
            s0.u0();
            s0.z0();
            if (r != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                s0.f(r);
            }
        }
    }

    @Override // com.inmobi.media.G1
    public final void c() {
        F0 r;
        super.c();
        S0 s0 = (C2596c8) this.d.get();
        if (s0 == null || (r = s0.r()) == null) {
            return;
        }
        r.a(s0, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        C2596c8 c2596c8 = (C2596c8) this.d.get();
        if (c2596c8 == null) {
            b((short) 13);
            return;
        }
        F0 r = c2596c8.r();
        if (r != null) {
            b(Short.valueOf(c2596c8.c(r)));
        }
    }
}
