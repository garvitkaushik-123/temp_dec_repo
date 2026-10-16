package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.y1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2948y1 extends AbstractC2864se {
    public final JSONObject d;
    public final InterfaceC2971z5 e;
    public final WeakReference f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2948y1(S0 adUnit, JSONObject response, InterfaceC2971z5 interfaceC2971z5) {
        super(adUnit, (byte) 4);
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(response, "response");
        this.d = response;
        this.e = interfaceC2971z5;
        this.f = new WeakReference(adUnit);
    }

    @Override // com.inmobi.media.AbstractC2864se
    public final void a(Object obj) {
        F0 r;
        InMobiAdRequestStatus inMobiAdRequestStatus = (InMobiAdRequestStatus) obj;
        S0 s0 = (S0) this.f.get();
        if (s0 == null || (r = s0.r()) == null) {
            return;
        }
        if (inMobiAdRequestStatus != null) {
            s0.b(inMobiAdRequestStatus, true, (short) 2182);
            return;
        }
        s0.d((byte) 2);
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).d("AuctionCloseWorker", "AdUnit " + s0 + " state - AVAILABLE");
        }
        s0.e(r);
    }

    @Override // com.inmobi.media.G1
    public final void c() {
        super.c();
        S0 s0 = (S0) this.f.get();
        if (s0 == null) {
            return;
        }
        s0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), true, (short) 2181);
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        C2947y0 y;
        S0 s0 = (S0) this.f.get();
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
        if ((s0 != null ? s0.y() : null) == null) {
            b(inMobiAdRequestStatus);
            return;
        }
        try {
            AdConfig j = s0.j();
            if (j != null && (y = s0.y()) != null) {
                y.a(this.d, j, this.e);
            }
            b(null);
        } catch (Exception unused) {
            S0.e();
            b(inMobiAdRequestStatus);
        }
    }
}
