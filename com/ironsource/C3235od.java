package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.od, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3235od {

    /* renamed from: a, reason: collision with root package name */
    private final String f3621a;
    private final Integer b;

    public C3235od(JSONObject features, String nameKey, String amountKey) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(nameKey, "nameKey");
        Intrinsics.checkNotNullParameter(amountKey, "amountKey");
        this.f3621a = features.has(nameKey) ? features.getString(nameKey) : null;
        this.b = features.has(amountKey) ? Integer.valueOf(features.getInt(amountKey)) : null;
    }

    public final Integer a() {
        return this.b;
    }

    public final String b() {
        return this.f3621a;
    }
}
