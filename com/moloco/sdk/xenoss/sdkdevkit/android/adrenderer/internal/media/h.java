package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5861a = 100;
    public static final int b = 101;
    public static final int c = 102;
    public static final int d = 200;

    public static final f a(Context appContext, String cacheDir) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        return new g(appContext, cacheDir);
    }
}
