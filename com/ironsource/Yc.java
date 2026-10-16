package com.ironsource;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public class Yc implements C0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3150a;

    public Yc(String placementName) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        this.f3150a = placementName;
    }

    @Override // com.ironsource.C0
    public Map<String, Object> a(A0 a0) {
        HashMap hashMap = new HashMap();
        hashMap.put("placement", this.f3150a);
        return hashMap;
    }
}
