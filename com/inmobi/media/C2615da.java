package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.RootConfig;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* renamed from: com.inmobi.media.da, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2615da {

    /* renamed from: a, reason: collision with root package name */
    public final S0 f2548a;

    public C2615da(S0 adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f2548a = adUnit;
    }

    public final byte[] a() {
        T h0 = this.f2548a.h0();
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("h-user-agent", Uc.k()));
        if (hashMapOf != null) {
            HashMap hashMap = h0.k;
            if (hashMap != null) {
                hashMap.putAll(hashMapOf);
            }
        } else {
            h0.getClass();
        }
        h0.f();
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a("root", Uc.b(), null);
        RootConfig rootConfig = a2 instanceof RootConfig ? (RootConfig) a2 : null;
        if (rootConfig != null && rootConfig.getMonetizationDisabled()) {
            throw new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MONETIZATION_DISABLED), (short) 2012);
        }
        if (!h0.d) {
            throw new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED), (short) 2141);
        }
        byte[] bytes = h0.c().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }
}
