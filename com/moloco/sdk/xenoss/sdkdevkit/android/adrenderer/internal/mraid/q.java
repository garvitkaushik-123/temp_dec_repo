package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class q {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5908a;

        static {
            int[] iArr = new int[p.values().length];
            try {
                iArr[p.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[p.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[p.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5908a = iArr;
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a a(p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "<this>");
        int i = a.f5908a[pVar.ordinal()];
        if (i == 1) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.b;
        }
        if (i == 2) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.c;
        }
        if (i == 3) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.d;
        }
        throw new NoWhenBranchMatchedException();
    }
}
