package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class n {
    public static final int c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f6151a;
    public final String b;

    public n(String str, String impressionUrl) {
        Intrinsics.checkNotNullParameter(impressionUrl, "impressionUrl");
        this.f6151a = str;
        this.b = impressionUrl;
    }

    public final String a() {
        return this.f6151a;
    }

    public final String b() {
        return this.b;
    }
}
