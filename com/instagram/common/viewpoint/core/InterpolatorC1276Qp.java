package com.instagram.common.viewpoint.core;

import android.view.animation.Interpolator;

/* renamed from: com.facebook.ads.redexgen.X.Qp, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class InterpolatorC1276Qp implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
