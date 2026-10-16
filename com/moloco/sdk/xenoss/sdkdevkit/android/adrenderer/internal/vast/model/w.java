package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class w {
    public static final int d = 8;

    /* renamed from: a, reason: collision with root package name */
    public final List<C3490a> f6160a;
    public final String b;
    public final String c;

    public w(List<C3490a> ads, String str, String str2) {
        Intrinsics.checkNotNullParameter(ads, "ads");
        this.f6160a = ads;
        this.b = str;
        this.c = str2;
    }

    public final List<C3490a> a() {
        return this.f6160a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
