package com.fyber.inneractive.sdk.mraid;

import java.util.Locale;

/* loaded from: classes4.dex */
public final class b0 extends y {

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.web.c0 f1299a;

    public b0(com.fyber.inneractive.sdk.web.c0 c0Var) {
        this.f1299a = c0Var;
    }

    @Override // com.fyber.inneractive.sdk.mraid.y
    public final String a() {
        return "placementType: '" + this.f1299a.toString().toLowerCase(Locale.US) + "'";
    }
}
