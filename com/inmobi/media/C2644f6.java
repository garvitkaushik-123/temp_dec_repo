package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.f6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2644f6 extends AbstractC2864se {
    public final WeakReference d;
    public final WeakReference e;
    public short f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2644f6(C2760m6 adUnit, F0 eventListener) {
        super(adUnit, (byte) 5);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.d = new WeakReference(adUnit);
        this.e = new WeakReference(eventListener);
    }

    @Override // com.inmobi.media.AbstractC2864se
    public final void a(Object obj) {
        F0 f0;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        C2760m6 c2760m6 = (C2760m6) this.d.get();
        if (c2760m6 == null || (f0 = (F0) this.e.get()) == null) {
            return;
        }
        if (!booleanValue) {
            short s = this.f;
            if (s != 0) {
                c2760m6.a(this.e, s, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
                return;
            } else {
                c2760m6.b(f0, (short) 85);
                return;
            }
        }
        InterfaceC2930x k = c2760m6.k();
        GestureDetectorOnGestureListenerC2634ec x = c2760m6.x();
        if (x != null) {
            if (k instanceof T7) {
                T7 t7 = (T7) k;
                t7.H = x;
                t7.K = c2760m6.T();
            } else {
                c2760m6.b(f0, (short) 84);
            }
        }
        c2760m6.h(f0);
    }

    @Override // com.inmobi.media.G1
    public final void c() {
        super.c();
        C2760m6 c2760m6 = (C2760m6) this.d.get();
        if (c2760m6 == null || ((F0) this.e.get()) == null) {
            return;
        }
        c2760m6.a(this.e, (short) 40, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        C2760m6 c2760m6 = (C2760m6) this.d.get();
        F0 f0 = (F0) this.e.get();
        if (c2760m6 != null && f0 != null) {
            if (c2760m6.E0()) {
                short c = c2760m6.c(f0);
                this.f = c;
                b(Boolean.valueOf(c == 0));
                return;
            }
            b(Boolean.FALSE);
            return;
        }
        b(Boolean.FALSE);
    }
}
