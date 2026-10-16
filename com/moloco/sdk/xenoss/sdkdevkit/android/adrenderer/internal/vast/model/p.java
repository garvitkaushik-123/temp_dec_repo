package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class p {
    public static final int h = 8;

    /* renamed from: a, reason: collision with root package name */
    public final r f6153a;
    public final c b;
    public final Long c;
    public final List<q> d;
    public final List<u> e;
    public final A f;
    public final List<l> g;

    public p(r rVar, c cVar, Long l, List<q> mediaFiles, List<u> trackingList, A a2, List<l> icons) {
        Intrinsics.checkNotNullParameter(mediaFiles, "mediaFiles");
        Intrinsics.checkNotNullParameter(trackingList, "trackingList");
        Intrinsics.checkNotNullParameter(icons, "icons");
        this.f6153a = rVar;
        this.b = cVar;
        this.c = l;
        this.d = mediaFiles;
        this.e = trackingList;
        this.f = a2;
        this.g = icons;
    }

    public final c a() {
        return this.b;
    }

    public final Long b() {
        return this.c;
    }

    public final List<l> c() {
        return this.g;
    }

    public final List<q> d() {
        return this.d;
    }

    public final r e() {
        return this.f6153a;
    }

    public final List<u> f() {
        return this.e;
    }

    public final A g() {
        return this.f;
    }
}
