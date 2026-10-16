package com.ironsource;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Z8 {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f3161a = new ArrayList<>(new Y8().a());
    private final P6 b = new P6();

    public final JSONObject a() {
        JSONObject a2 = this.b.a(this.f3161a);
        Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDataByKeys(mInitKeyList)");
        return a2;
    }
}
