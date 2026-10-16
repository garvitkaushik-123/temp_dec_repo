package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.os.Looper;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* renamed from: com.facebook.ads.redexgen.X.9n, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08509n extends AbstractC2344nv implements DI {
    public long A00;
    public InterfaceC07605t A01;
    public InterfaceC2170ku<InterfaceExecutorC0983Fb> A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final int A06;
    public final AnonymousClass32 A07;
    public final C2478q7 A08;
    public final C5Y A09;
    public final A6 A0A;
    public final DC A0B;
    public final FF A0C;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ku != com.google.common.base.Supplier<com.facebook.ads.androidx.media3.exoplayer.util.ReleasableExecutor> */
    @MetaExoPlayerCustomization("Allow for passing a new drmSessionManager")
    public C08509n(C2478q7 c2478q7, C5Y c5y, DC dc, A6 a6, FF ff, int i, InterfaceC2170ku<InterfaceExecutorC0983Fb> interfaceC2170ku) {
        this.A07 = (AnonymousClass32) AbstractC07133y.A01(c2478q7.A03);
        this.A08 = c2478q7;
        this.A09 = c5y;
        this.A0B = dc;
        this.A0A = a6 == null ? A6.A00 : a6;
        this.A0C = ff;
        this.A06 = i;
        this.A04 = true;
        this.A00 = -9223372036854775807L;
        this.A02 = interfaceC2170ku;
    }

    private void A00() {
        final Timeline c08499m = new C08499m(this.A00, this.A05, false, this.A03, null, this.A08);
        if (this.A04) {
            Timeline timeline = new C9t(c08499m) { // from class: com.facebook.ads.redexgen.X.1e
                @Override // com.instagram.common.viewpoint.core.C9t, com.facebook.ads.androidx.media3.common.Timeline
                public final C2456pl A0I(int i, C2456pl c2456pl, boolean z) {
                    super.A0I(i, c2456pl, z);
                    c2456pl.A05 = true;
                    return c2456pl;
                }

                @Override // com.instagram.common.viewpoint.core.C9t, com.facebook.ads.androidx.media3.common.Timeline
                public final C2454pj A0L(int i, C2454pj c2454pj, long j) {
                    super.A0L(i, c2454pj, j);
                    c2454pj.A0F = true;
                    return c2454pj;
                }
            };
            c08499m = timeline;
        }
        A05(c08499m);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2344nv
    public final void A09() {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2344nv
    public final void A0A(InterfaceC07605t interfaceC07605t) {
        this.A01 = interfaceC07605t;
        this.A0A.AH4();
        this.A0A.AJe((Looper) AbstractC07133y.A01(Looper.myLooper()), A00());
        A00();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0927Cx
    @MetaExoPlayerCustomization("PlayerId needs to be set")
    public final InterfaceC2338np A5W(C2337no c2337no, F0 f0, long j) {
        InterfaceExecutorC0983Fb interfaceExecutorC0983Fb;
        InterfaceC2425pF A5I = this.A09.A5I();
        if (this.A01 != null) {
            A5I.A43(this.A01);
        }
        Uri uri = this.A07.A00;
        DD A5X = this.A0B.A5X(C8O.A03);
        A6 a6 = this.A0A;
        A1 A01 = A01(c2337no);
        FF ff = this.A0C;
        D8 A02 = A02(c2337no);
        String str = this.A07.A04;
        int i = this.A06;
        if (this.A02 != null) {
            interfaceExecutorC0983Fb = this.A02.get();
        } else {
            interfaceExecutorC0983Fb = null;
        }
        return new C08529p(uri, A5I, A5X, a6, A01, ff, A02, this, f0, str, i, interfaceExecutorC0983Fb);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0927Cx
    public final void ACT() {
    }

    @Override // com.instagram.common.viewpoint.core.DI
    public final void AG0(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.A00;
        }
        if (!this.A04 && this.A00 == j && this.A05 == z && this.A03 == z2) {
            return;
        }
        this.A00 = j;
        this.A05 = z;
        this.A03 = z2;
        this.A04 = false;
        A00();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0927Cx
    public final void AHk(InterfaceC2338np interfaceC2338np) {
        ((C08529p) interfaceC2338np).A0a();
    }
}
