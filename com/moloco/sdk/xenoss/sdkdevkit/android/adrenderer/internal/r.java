package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5922a = "START_MUTED";
    public static final String b = "CLOSE_DELAY_SECONDS";
    public static final String c = "DEC_DELAY_SECONDS";
    public static final String d = "SKIP_DELAY_SECONDS";
    public static final String e = "SKIP_ENABLED";
    public static final String f = "AUTO_STORE_ON_SKIP";
    public static final String g = "AUTO_STORE_ON_COMPLETE";

    public static final void a(Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        intent.putExtra(b, i);
    }

    public static final void b(Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        intent.putExtra(c, i);
    }

    public static final void c(Intent intent, boolean z) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        intent.putExtra(f5922a, z);
    }

    public static final int d(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return intent.getIntExtra(c, 0);
    }

    public static final Boolean e(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        if (intent.hasExtra(e)) {
            return Boolean.valueOf(intent.getBooleanExtra(e, false));
        }
        return null;
    }

    public static final int f(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return intent.getIntExtra(d, 0);
    }

    public static final boolean g(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return intent.getBooleanExtra(f5922a, true);
    }

    public static final void a(Intent intent, Boolean bool) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        if (bool != null) {
            intent.putExtra(e, bool.booleanValue());
        }
    }

    public static final boolean b(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return intent.getBooleanExtra(f, false);
    }

    public static final int c(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return intent.getIntExtra(b, 0);
    }

    public static final boolean a(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return intent.getBooleanExtra(g, false);
    }

    public static final void b(Intent intent, boolean z) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        intent.putExtra(f, z);
    }

    public static final void c(Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        intent.putExtra(d, i);
    }

    public static final void a(Intent intent, boolean z) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        intent.putExtra(g, z);
    }
}
