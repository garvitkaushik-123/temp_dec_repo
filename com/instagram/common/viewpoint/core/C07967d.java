package com.instagram.common.viewpoint.core;

import android.os.Looper;
import com.facebook.ads.androidx.media3.common.Timeline;

/* renamed from: com.facebook.ads.redexgen.X.7d, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C07967d {
    public int A00;
    public int A01;
    public Looper A03;
    public Object A04;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final Timeline A0A;
    public final AnonymousClass45 A0B;
    public final InterfaceC07947b A0C;
    public final InterfaceC07957c A0D;
    public long A02 = -9223372036854775807L;
    public boolean A05 = true;

    public C07967d(InterfaceC07947b interfaceC07947b, InterfaceC07957c interfaceC07957c, Timeline timeline, int i, AnonymousClass45 anonymousClass45, Looper looper) {
        this.A0C = interfaceC07947b;
        this.A0D = interfaceC07957c;
        this.A0A = timeline;
        this.A03 = looper;
        this.A0B = anonymousClass45;
        this.A00 = i;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final long A02() {
        return this.A02;
    }

    public final Looper A03() {
        return this.A03;
    }

    public final Timeline A04() {
        return this.A0A;
    }

    public final InterfaceC07957c A05() {
        return this.A0D;
    }

    public final C07967d A06() {
        AbstractC07133y.A08(!this.A09);
        if (this.A02 == -9223372036854775807L) {
            AbstractC07133y.A07(this.A05);
        }
        this.A09 = true;
        this.A0C.AJC(this);
        return this;
    }

    public final C07967d A07(int i) {
        AbstractC07133y.A08(!this.A09);
        this.A01 = i;
        return this;
    }

    public final C07967d A08(Object obj) {
        AbstractC07133y.A08(!this.A09);
        this.A04 = obj;
        return this;
    }

    public final Object A09() {
        return this.A04;
    }

    public final synchronized void A0A(boolean z) {
        this.A07 |= z;
        this.A08 = true;
        notifyAll();
    }

    public final boolean A0B() {
        return this.A05;
    }

    public final synchronized boolean A0C() throws InterruptedException {
        AbstractC07133y.A08(this.A09);
        AbstractC07133y.A08(this.A03.getThread() != Thread.currentThread());
        while (!this.A08) {
            wait();
        }
        return this.A07;
    }

    public final synchronized boolean A0D() {
        return this.A06;
    }
}
