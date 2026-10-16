package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class H4 extends AbstractC2864se {
    public final long d;
    public final InterfaceC2971z5 e;
    public final WeakReference f;
    public K g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H4(S0 adUnit, long j, InterfaceC2971z5 interfaceC2971z5) {
        super(adUnit, (byte) 2);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.d = j;
        this.e = interfaceC2971z5;
        this.f = new WeakReference(adUnit);
    }

    @Override // com.inmobi.media.AbstractC2864se
    public final void a(Object obj) {
        byte[] bArr = (byte[]) obj;
        S0 s0 = (S0) this.f.get();
        if (s0 == null) {
            return;
        }
        if (this.g != null) {
            InterfaceC2971z5 interfaceC2971z5 = this.e;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).d("GetSignalsWorker", "AdUnit " + s0 + " state - FAILED");
            }
            s0.d((byte) 3);
        }
        F0 r = s0.r();
        if (r == null) {
            return;
        }
        K k = this.g;
        if (k != null) {
            InterfaceC2971z5 interfaceC2971z52 = this.e;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).a("GetSignalsWorker", "get signals failed", k);
            }
            s0.a(k.b, this.d);
            r.b(new InMobiAdRequestStatus(k.f2330a.getStatusCode()));
            return;
        }
        if (bArr != null) {
            s0.b(this.d);
            r.a(bArr);
            InterfaceC2971z5 interfaceC2971z53 = this.e;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).a("GetSignalsWorker", "callback - onRequestCreated");
                return;
            }
            return;
        }
        s0.d((byte) 3);
        InterfaceC2971z5 interfaceC2971z54 = this.e;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).d("GetSignalsWorker", "AdUnit " + this + " state - FAILED");
        }
        InterfaceC2971z5 interfaceC2971z55 = this.e;
        if (interfaceC2971z55 != null) {
            ((A5) interfaceC2971z55).b("GetSignalsWorker", "no request created - fail");
        }
        s0.a(13, this.d);
        r.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
    }

    @Override // com.inmobi.media.G1
    public final void c() {
        super.c();
        S0 s0 = (S0) this.f.get();
        if (s0 == null) {
            return;
        }
        F0 r = s0.r();
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("GetSignalsWorker", "onOOM");
        }
        if (r != null) {
            r.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY));
        }
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        S0 s0 = (S0) this.f.get();
        if ((s0 != null ? s0.H() : null) == null) {
            InterfaceC2971z5 interfaceC2971z5 = this.e;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("GetSignalsWorker", "OAManager is null");
            }
            b(null);
            return;
        }
        if (s0.r() == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.e;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("GetSignalsWorker", "listener is null");
            }
            b(null);
            return;
        }
        try {
            C2598ca H = s0.H();
            b(H != null ? new C2615da(H.f2535a).a() : null);
        } catch (K e) {
            this.g = e;
            b(null);
        }
    }
}
