package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.f2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3072f2 {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC3340v0 f3291a;
    private final Map<String, Object> b;
    private final List<String> c;
    private final StringBuilder d;

    public C3072f2(AbstractC3340v0 adUnitData) {
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.f3291a = adUnitData;
        this.b = new HashMap();
        this.c = new ArrayList();
        this.d = new StringBuilder();
    }

    public final Map<String, Object> a() {
        return this.b;
    }

    public final List<String> b() {
        return this.c;
    }

    public final StringBuilder c() {
        return this.d;
    }

    public final boolean d() {
        return (this.b.isEmpty() && this.c.isEmpty()) ? false : true;
    }

    public final void a(NetworkSettings providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        List<String> list = this.c;
        String providerInstanceName = providerSettings.getProviderInstanceName();
        Intrinsics.checkNotNullExpressionValue(providerInstanceName, "providerSettings.providerInstanceName");
        list.add(providerInstanceName);
        this.d.append(providerSettings.getInstanceType(this.f3291a.b().a())).append(providerSettings.getProviderInstanceName()).append(",");
    }

    public final void a(NetworkSettings providerSettings, Map<String, ? extends Object> biddingData) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        Intrinsics.checkNotNullParameter(biddingData, "biddingData");
        String providerInstanceName = providerSettings.getProviderInstanceName();
        Intrinsics.checkNotNullExpressionValue(providerInstanceName, "providerSettings.providerInstanceName");
        a(providerInstanceName, providerSettings.getInstanceType(this.f3291a.b().a()), biddingData);
    }

    public final void a(C3 biddingResponse) {
        Intrinsics.checkNotNullParameter(biddingResponse, "biddingResponse");
        String c = biddingResponse.c();
        Intrinsics.checkNotNullExpressionValue(c, "biddingResponse.instanceName");
        int d = biddingResponse.d();
        Map<String, Object> a2 = biddingResponse.a();
        Intrinsics.checkNotNullExpressionValue(a2, "biddingResponse.biddingData");
        a(c, d, a2);
    }

    private final void a(String str, int i, Map<String, ? extends Object> map) {
        this.b.put(str, map);
        this.d.append(i).append(str).append(",");
    }
}
