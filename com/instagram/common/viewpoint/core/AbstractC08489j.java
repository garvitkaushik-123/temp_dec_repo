package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: com.facebook.ads.redexgen.X.9j, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC08489j implements InterfaceC2301nE {
    public int A00;

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1742")
    public boolean A01;
    public final int A02;
    public final long[] A03;
    public final C2489qI[] A04;
    public final int A05;
    public final C2452pg A06;
    public final int[] A07;

    /* JADX WARN: Incorrect condition in loop: B:11:0x0044 */
    /* JADX WARN: Incorrect condition in loop: B:6:0x0020 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC08489j(C2452pg c2452pg, int[] iArr, int i) {
        AbstractC07133y.A08(iArr.length > 0);
        this.A02 = i;
        this.A06 = (C2452pg) AbstractC07133y.A01(c2452pg);
        this.A05 = iArr.length;
        this.A04 = new C2489qI[this.A05];
        for (int i2 = 0; i2 < i; i2++) {
            C2489qI[] c2489qIArr = this.A04;
            int i3 = iArr[i2];
            c2489qIArr[i2] = c2452pg.A08(i3);
        }
        Arrays.sort(this.A04, new Comparator() { // from class: com.facebook.ads.redexgen.X.EV
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC08489j.A07((C2489qI) obj, (C2489qI) obj2);
            }
        });
        this.A07 = new int[this.A05];
        for (int i4 = 0; i4 < i; i4++) {
            int[] iArr2 = this.A07;
            int i5 = c2452pg.A07(this.A04[i4]);
            iArr2[i4] = i5;
        }
        int i6 = this.A05;
        this.A03 = new long[i6];
        this.A01 = false;
    }

    public static /* synthetic */ int A07(C2489qI c2489qI, C2489qI c2489qI2) {
        return c2489qI2.A05 - c2489qI.A05;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2301nE
    public void A5x() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2301nE
    public void A6K() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0972Eq
    public final C2489qI A8B(int i) {
        return this.A04[i];
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0972Eq
    public final int A8H(int i) {
        return this.A07[i];
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2301nE
    public final C2489qI A92() {
        return this.A04[A93()];
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0972Eq
    public final C2452pg A9L() {
        return this.A06;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0003 */
    @Override // com.instagram.common.viewpoint.core.InterfaceC0972Eq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int AA6(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.A07[i2];
            if (i3 == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2301nE
    public void AFJ(float f) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC08489j abstractC08489j = (AbstractC08489j) obj;
        return this.A06 == abstractC08489j.A06 && Arrays.equals(this.A07, abstractC08489j.A07);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = (System.identityHashCode(this.A06) * 31) + Arrays.hashCode(this.A07);
        }
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0972Eq
    public final int length() {
        return this.A07.length;
    }
}
