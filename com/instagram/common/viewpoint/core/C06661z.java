package com.instagram.common.viewpoint.core;

import android.media.AudioAttributes;

/* renamed from: com.facebook.ads.redexgen.X.1z, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C06661z {
    public final AudioAttributes A00;

    public C06661z(C2495qQ c2495qQ) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(c2495qQ.A02).setFlags(c2495qQ.A03).setUsage(c2495qQ.A05);
        if (C5C.A02 >= 29) {
            C06641x.A00(usage, c2495qQ.A01);
        }
        if (C5C.A02 >= 32) {
            C06651y.A00(usage, c2495qQ.A04);
        }
        this.A00 = usage.build();
    }
}
