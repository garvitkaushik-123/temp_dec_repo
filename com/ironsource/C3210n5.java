package com.ironsource;

import com.ironsource.mediationsdk.d;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.n5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3210n5 implements InterfaceC3317tb<String, d.a> {
    @Override // com.ironsource.InterfaceC3317tb
    public d.a a(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        d.a a2 = com.ironsource.mediationsdk.d.b().a(new JSONObject(input));
        Intrinsics.checkNotNullExpressionValue(a2, "getInstance().getAuction…sponse(JSONObject(input))");
        return a2;
    }
}
