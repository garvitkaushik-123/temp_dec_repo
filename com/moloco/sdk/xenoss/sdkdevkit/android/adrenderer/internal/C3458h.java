package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.h, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3458h {

    /* renamed from: a, reason: collision with root package name */
    public static final C3458h f5847a = new C3458h();
    public static final int b = 0;

    public final boolean a(String adm) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        return StringsKt.contains((CharSequence) adm, (CharSequence) "mraid.js", true);
    }

    public final boolean b(String adm) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        return StringsKt.contains((CharSequence) adm, (CharSequence) "<VAST", true);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i c(String adm) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        return b(adm) ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.f5770a : a(adm) ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.b : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.c;
    }
}
