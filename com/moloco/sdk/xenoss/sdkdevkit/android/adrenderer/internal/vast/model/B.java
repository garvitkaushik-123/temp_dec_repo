package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class B {
    public static final int g = 8;

    /* renamed from: a, reason: collision with root package name */
    public final String f6137a;
    public final Boolean b;
    public final d c;
    public final List<n> d;
    public final List<String> e;
    public final List<g> f;

    public B(String vastAdTagUrl, Boolean bool, d dVar, List<n> impressions, List<String> errorUrls, List<g> creatives) {
        Intrinsics.checkNotNullParameter(vastAdTagUrl, "vastAdTagUrl");
        Intrinsics.checkNotNullParameter(impressions, "impressions");
        Intrinsics.checkNotNullParameter(errorUrls, "errorUrls");
        Intrinsics.checkNotNullParameter(creatives, "creatives");
        this.f6137a = vastAdTagUrl;
        this.b = bool;
        this.c = dVar;
        this.d = impressions;
        this.e = errorUrls;
        this.f = creatives;
    }

    public final d a() {
        return this.c;
    }

    public final List<g> b() {
        return this.f;
    }

    public final List<String> c() {
        return this.e;
    }

    public final Boolean d() {
        return this.b;
    }

    public final List<n> e() {
        return this.d;
    }

    public final String f() {
        return this.f6137a;
    }
}
