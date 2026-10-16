package com.inmobi.media;

import com.google.ads.mediation.AbstractAdViewAdapter;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ba, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2581ba extends N9 {
    public final C2563aa y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2581ba(C2563aa novatiqData, InterfaceC2971z5 interfaceC2971z5) {
        super(novatiqData.c.getBeaconUrl(), interfaceC2971z5);
        Intrinsics.checkNotNullParameter(novatiqData, "novatiqData");
        this.y = novatiqData;
        this.t = false;
        this.u = false;
        this.x = false;
    }

    @Override // com.inmobi.media.N9
    public final void f() {
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            StringBuilder append = new StringBuilder("preparing Novatiq request with data - hyperId - ").append(this.y.f2519a).append(" - sspHost - ").append(this.y.b).append(" - pubId - inmobi");
            this.y.getClass();
            ((A5) interfaceC2971z5).a("Novatiq", append.toString());
        }
        super.f();
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.put("sptoken", this.y.f2519a);
        }
        HashMap hashMap2 = this.j;
        if (hashMap2 != null) {
            this.y.getClass();
            hashMap2.put("sspid", "i6i");
        }
        HashMap hashMap3 = this.j;
        if (hashMap3 != null) {
            hashMap3.put("ssphost", this.y.b);
        }
        HashMap hashMap4 = this.j;
        if (hashMap4 != null) {
            this.y.getClass();
            hashMap4.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "inmobi");
        }
    }
}
