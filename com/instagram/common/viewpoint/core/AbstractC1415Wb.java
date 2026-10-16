package com.instagram.common.viewpoint.core;

import android.widget.RelativeLayout;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Wb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1415Wb extends RelativeLayout {
    public static final AtomicBoolean A00 = new AtomicBoolean();
    public static final AtomicReference<WS> A01 = new AtomicReference<>();

    public static void A00(boolean z, WS ws) {
        A00.set(z);
        A01.set(ws);
    }
}
