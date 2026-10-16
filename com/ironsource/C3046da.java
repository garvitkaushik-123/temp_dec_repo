package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.da, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3046da implements InterfaceC3320te<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3320te<String> f3254a;

    public C3046da(InterfaceC3320te<String> serverResponse) {
        Intrinsics.checkNotNullParameter(serverResponse, "serverResponse");
        this.f3254a = serverResponse;
    }

    @Override // com.ironsource.InterfaceC3320te
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a() {
        return new JSONObject(this.f3254a.a());
    }
}
