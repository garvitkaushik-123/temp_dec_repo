package com.ironsource;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class X8 {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f3128a = new ArrayList<>(new W8().a());
    private final P6 b = new P6();

    public final JSONObject a() {
        JSONObject a2 = this.b.a(this.f3128a);
        Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDat…mInitDeferredDataKeyList)");
        return a2;
    }
}
