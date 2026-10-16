package com.inmobi.media;

import android.view.WindowInsets;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Af {
    public void a(EnumC2813pa orientation, Cf finalInsets) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(finalInsets, "finalInsets");
    }

    public boolean a() {
        return true;
    }

    public void a(WindowInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
    }
}
