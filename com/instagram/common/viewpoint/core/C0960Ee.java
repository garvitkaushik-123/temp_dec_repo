package com.instagram.common.viewpoint.core;

import android.media.Spatializer;

/* renamed from: com.facebook.ads.redexgen.X.Ee, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0960Ee implements Spatializer.OnSpatializerStateChangedListener {
    public final /* synthetic */ C0961Ef A00;
    public final /* synthetic */ C08469h A01;

    public C0960Ee(C0961Ef c0961Ef, C08469h c08469h) {
        this.A00 = c0961Ef;
        this.A01 = c08469h;
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.A01.A0L();
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.A01.A0L();
    }
}
