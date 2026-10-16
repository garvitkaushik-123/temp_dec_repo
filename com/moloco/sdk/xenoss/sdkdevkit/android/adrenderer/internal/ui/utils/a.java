package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.TextUnit;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final float f6045a;
    public static final float b;
    public static final long c;
    public static final long d;
    public static final long e;
    public static final RoundedCornerShape f;

    static {
        float m6389constructorimpl = Dp.m6389constructorimpl(24);
        f6045a = m6389constructorimpl;
        b = Dp.m6389constructorimpl(4);
        c = TextUnit.INSTANCE.m6591getUnspecifiedXSAIIZE();
        d = DpKt.m6411DpSizeYgX7TsA(m6389constructorimpl, m6389constructorimpl);
        e = Color.m4062copywmQWz5c$default(Color.INSTANCE.m4093getGray0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
        f = RoundedCornerShapeKt.getCircleShape();
    }

    public static final float a() {
        return b;
    }

    public static final long b() {
        return d;
    }

    public static final float c() {
        return f6045a;
    }

    public static final long d() {
        return c;
    }

    public static final long e() {
        return e;
    }

    public static final RoundedCornerShape f() {
        return f;
    }
}
