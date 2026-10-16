package com.instagram.common.viewpoint.core;

import android.database.DataSetObserver;

/* renamed from: com.facebook.ads.redexgen.X.Ps, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1255Ps extends DataSetObserver {
    public final /* synthetic */ Pv A00;

    public C1255Ps(Pv pv) {
        this.A00 = pv;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        this.A00.A0e();
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.A00.A0e();
    }
}
