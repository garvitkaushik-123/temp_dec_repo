package com.ironsource;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class J5 {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f2915a = new ArrayList<>(new I5().a());
    private final P6 b = new P6();

    public final JSONObject a() {
        JSONObject a2 = this.b.a(this.f2915a);
        Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDataByKeys(mEventsKeyList)");
        return a2;
    }
}
