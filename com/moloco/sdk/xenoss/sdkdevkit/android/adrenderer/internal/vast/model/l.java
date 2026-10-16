package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class l {
    public static final int j = 8;

    /* renamed from: a, reason: collision with root package name */
    public final String f6149a;
    public final Integer b;
    public final Integer c;
    public final String d;
    public final r e;
    public final Long f;
    public final m g;
    public final List<String> h;
    public final y i;

    public l(String str, Integer num, Integer num2, String str2, r rVar, Long l, m mVar, List<String> viewTrackingUrlList, y resource) {
        Intrinsics.checkNotNullParameter(viewTrackingUrlList, "viewTrackingUrlList");
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.f6149a = str;
        this.b = num;
        this.c = num2;
        this.d = str2;
        this.e = rVar;
        this.f = l;
        this.g = mVar;
        this.h = viewTrackingUrlList;
        this.i = resource;
    }

    public final String a() {
        return this.d;
    }

    public final m b() {
        return this.g;
    }

    public final Long c() {
        return this.f;
    }

    public final Integer d() {
        return this.c;
    }

    public final r e() {
        return this.e;
    }

    public final String f() {
        return this.f6149a;
    }

    public final y g() {
        return this.i;
    }

    public final List<String> h() {
        return this.h;
    }

    public final Integer i() {
        return this.b;
    }
}
