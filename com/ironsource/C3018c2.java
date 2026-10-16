package com.ironsource;

import com.ironsource.N6;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.c2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3018c2 {

    /* renamed from: a, reason: collision with root package name */
    private final N6.a f3209a;
    private final ArrayList<String> b = new ArrayList<>(new C2984a2().a());
    private final P6 c = new P6();

    public C3018c2(N6.a aVar) {
        this.f3209a = aVar;
    }

    public final JSONObject a() {
        N6.a aVar = this.f3209a;
        JSONObject a2 = aVar != null ? this.c.a(this.b, aVar) : null;
        if (a2 == null) {
            a2 = this.c.a(this.b);
            Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDataByKeys(mAuctionKeyList)");
        }
        return a(a2);
    }

    private final JSONObject a(JSONObject jSONObject) {
        JSONObject b = Q6.b(jSONObject.optJSONObject(N6.u));
        if (b != null) {
            jSONObject.put(N6.u, b);
        }
        return jSONObject;
    }
}
