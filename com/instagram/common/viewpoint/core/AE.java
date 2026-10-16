package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class AE implements InterfaceC2398oo, InterfaceC08087p {
    public int A00;
    public int A01;
    public long A02;
    public long A04;
    public C08117s A05;
    public C8O A06;
    public DT A07;
    public boolean A08;
    public boolean A09;
    public C2489qI[] A0A;
    public final int A0C;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D18870411: Adding start stall debug reason")
    public EnumC2055ir A0B = EnumC2055ir.A09;
    public final C07926z A0D = new C07926z();
    public long A03 = Long.MIN_VALUE;

    public abstract void A1Z();

    public abstract void A1a(long j, boolean z) throws AD;

    public abstract void A1c(C2489qI[] c2489qIArr, long j, long j2) throws AD;

    public AE(int i) {
        this.A0C = i;
    }

    private final int A1O() {
        return this.A00;
    }

    private void A1P(long j, boolean z) throws AD {
        this.A08 = false;
        this.A02 = j;
        this.A03 = j;
        A1a(j, z);
    }

    public final int A1Q(long j) {
        return ((DT) AbstractC07133y.A01(this.A07)).AK2(j - this.A04);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Keep track of the non-adjusted timestamp")
    public final int A1R(C07926z c07926z, C2410p0 c2410p0, int i) {
        int AHP = ((DT) AbstractC07133y.A01(this.A07)).AHP(c07926z, c2410p0, i);
        if (AHP == -4) {
            if (c2410p0.A05()) {
                this.A03 = Long.MIN_VALUE;
                return this.A08 ? -4 : -3;
            }
            c2410p0.A00 = c2410p0.A01;
            c2410p0.A01 += this.A04;
            this.A03 = Math.max(this.A03, c2410p0.A01);
        } else if (AHP == -5) {
            C2489qI c2489qI = (C2489qI) AbstractC07133y.A01(c07926z.A00);
            if (c2489qI.A0M != Long.MAX_VALUE) {
                c07926z.A00 = c2489qI.A07().A0s(c2489qI.A0M + this.A04).A14();
            }
        }
        return AHP;
    }

    public final AD A1S(Throwable th, C2489qI c2489qI, int i) {
        return A1T(th, c2489qI, false, i);
    }

    public final AD A1T(Throwable th, C2489qI c2489qI, boolean z, int i) {
        int i2 = 4;
        if (c2489qI != null && !this.A09) {
            this.A09 = true;
            try {
                int formatSupport = AKM(c2489qI);
                i2 = AbstractC08017i.A03(formatSupport);
            } catch (AD unused) {
            } catch (Throwable th2) {
                this.A09 = false;
                throw th2;
            }
            this.A09 = false;
        }
        return AD.A04(th, getName(), A1O(), c2489qI, i2, z, i);
    }

    public final C07926z A1U() {
        this.A0D.A00();
        return this.A0D;
    }

    public final C08117s A1V() {
        return (C08117s) AbstractC07133y.A01(this.A05);
    }

    public final C8O A1W() {
        return (C8O) AbstractC07133y.A01(this.A06);
    }

    public void A1X() throws AD {
    }

    public void A1Y() {
    }

    public void A1b(boolean z, boolean z2) throws AD {
    }

    public final boolean A1d() {
        return A9p() ? this.A08 : ((DT) AbstractC07133y.A01(this.A07)).AAe();
    }

    public final C2489qI[] A1e() {
        return (C2489qI[]) AbstractC07133y.A01(this.A0A);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final void A5x() {
        AbstractC07133y.A08(this.A01 == 1);
        this.A0D.A00();
        this.A01 = 0;
        this.A07 = null;
        this.A0A = null;
        this.A08 = false;
        A1Z();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final void A6L(C08117s c08117s, C2489qI[] c2489qIArr, DT dt, long j, boolean z, boolean z2, long j2, long j3) throws AD {
        AbstractC07133y.A08(this.A01 == 0);
        this.A05 = c08117s;
        this.A01 = 1;
        A1b(z, z2);
        AIa(c2489qIArr, dt, j2, j3);
        A1P(j, z);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final InterfaceC08087p A7D() {
        return this;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public AnonymousClass78 A8T() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D18870411: Adding start stall debug reason")
    public final EnumC2055ir A99() {
        return this.A0B;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final int A9A() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final DT A9D() {
        return this.A07;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo, com.instagram.common.viewpoint.core.InterfaceC08087p
    public final int A9N() {
        return this.A0C;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC07957c
    public void A9i(int i, Object obj) throws AD {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final boolean A9p() {
        return this.A03 == Long.MIN_VALUE;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final void AA9(int i, C8O c8o) {
        this.A00 = i;
        this.A06 = c8o;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final boolean AAN() {
        return this.A08;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final void ACU() throws IOException {
        ((DT) AbstractC07133y.A01(this.A07)).ACR();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final void AIa(C2489qI[] c2489qIArr, DT dt, long j, long j2) throws AD {
        AbstractC07133y.A08(!this.A08);
        this.A07 = dt;
        if (this.A03 == Long.MIN_VALUE) {
            this.A03 = j;
        }
        this.A0A = c2489qIArr;
        this.A04 = j2;
        A1c(c2489qIArr, j, j2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final void AIm(long j) throws AD {
        A1P(j, false);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final void AJN() {
        this.A08 = true;
    }

    public int AKO() throws AD {
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final void start() throws AD {
        AbstractC07133y.A08(this.A01 == 1);
        this.A01 = 2;
        A1X();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2398oo
    public final void stop() {
        AbstractC07133y.A08(this.A01 == 2);
        this.A01 = 1;
        A1Y();
    }
}
