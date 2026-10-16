package com.ironsource;

import android.content.Context;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Jf {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f2919a = If.f2911a.a();
    private final P6 b = new P6();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the new method getToken(context: Context)")
    public final JSONObject a() {
        JSONObject a2 = this.b.a(this.f2919a);
        Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDataByKeys(mTokenKeyList)");
        return a(a2);
    }

    public final JSONObject a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JSONObject a2 = this.b.a(context, this.f2919a);
        Intrinsics.checkNotNullExpressionValue(a2, "mGlobalDataReader.getDat…s(context, mTokenKeyList)");
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
