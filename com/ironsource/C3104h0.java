package com.ironsource;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.h0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3104h0 {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f3328a = new ArrayList<>(new C3087g0().a());
    private final P6 b = new P6();

    public final JSONObject a() {
        JSONObject a2 = this.b.a(this.f3328a);
        Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDataByKeys(mAdQualityKeyList)");
        return a2;
    }
}
