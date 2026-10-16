package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.p, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3238p {

    /* renamed from: a, reason: collision with root package name */
    private final Boolean f3624a;

    public C3238p(JSONObject adFormatAuctionSettings) {
        Intrinsics.checkNotNullParameter(adFormatAuctionSettings, "adFormatAuctionSettings");
        this.f3624a = adFormatAuctionSettings.has(C3255q.f3645a) ? Boolean.valueOf(adFormatAuctionSettings.optBoolean(C3255q.f3645a)) : null;
    }

    public final Boolean a() {
        return this.f3624a;
    }
}
