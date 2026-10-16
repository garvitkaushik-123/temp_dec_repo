package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.Timeline;

/* renamed from: com.facebook.ads.redexgen.X.Ew, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0978Ew {
    public InterfaceC0977Ev A00;
    public F6 A01;

    public abstract boolean A0Y();

    public abstract C0979Ex A0b(InterfaceC08087p[] interfaceC08087pArr, C2319nW c2319nW, C2337no c2337no, Timeline timeline) throws AD;

    public abstract void A0c(Object obj);

    public final F6 A00() {
        return (F6) AbstractC07133y.A02(this.A01);
    }

    public final void A01() {
        if (this.A00 != null) {
            this.A00.AGD();
        }
    }

    public final void A02(InterfaceC0977Ev interfaceC0977Ev, F6 f6) {
        this.A00 = interfaceC0977Ev;
        this.A01 = f6;
    }
}
