package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.Lq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1152Lq extends AbstractC1873fo {
    public final /* synthetic */ LV A00;

    public C1152Lq(LV lv) {
        this.A00 = lv;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r0.A07() == false) goto L6;
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC1873fo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A03() {
        boolean z;
        Y2 y2;
        WeakReference weakReference;
        WeakReference weakReference2;
        Y2 y22;
        z = this.A00.A05;
        if (!z) {
            y22 = this.A00.A01;
        }
        y2 = this.A00.A01;
        y2.A05();
        weakReference = this.A00.A0A;
        if (weakReference.get() != null) {
            weakReference2 = this.A00.A0A;
            ((InterfaceC1578b1) weakReference2.get()).AEA();
        }
    }
}
