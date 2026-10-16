package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class B0 extends G5 {

    /* renamed from: a, reason: collision with root package name */
    private final C3205n0 f2796a;
    private final C3070f0 b;
    private final String c;

    public /* synthetic */ B0(C3205n0 c3205n0, C3070f0 c3070f0, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c3205n0, c3070f0, (i & 4) != 0 ? null : str);
    }

    @Override // com.ironsource.C0
    public Map<String, Object> a(A0 a0) {
        Map<String, Object> a2 = a(this.b);
        a2.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        a2.put("sessionDepth", Integer.valueOf(this.f2796a.f()));
        String str = this.c;
        if (str != null) {
            a2.put(IronSourceConstants.EVENTS_MEDIATION_LOAD_STRATEGY, str);
        }
        return a2;
    }

    public B0(C3205n0 adTools, C3070f0 adProperties, String str) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        this.f2796a = adTools;
        this.b = adProperties;
        this.c = str;
    }
}
