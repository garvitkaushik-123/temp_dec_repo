package com.instagram.common.viewpoint.core;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Fp, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C0996Fp extends AbstractC1277Qq<FY> {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public AbstractC1464Yb A04;
    public InterfaceC1470Yh A05;
    public String A06;
    public List<C1767e5> A07;
    public boolean A08;
    public final SparseBooleanArray A09 = new SparseBooleanArray();
    public final AbstractC2094jd A0A;
    public final C1335Sx A0B;
    public final C1929gi A0C;
    public final VA A0D;
    public final Y2 A0E;
    public final C1005Fy A0F;
    public final C1874fp A0G;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C0996Fp(C1929gi c1929gi, List<C1767e5> list, AbstractC2094jd abstractC2094jd, VA va, C1335Sx c1335Sx, C1874fp c1874fp, Y2 y2, InterfaceC1470Yh interfaceC1470Yh, String str, int i, int i2, int i3, int i4, C1005Fy c1005Fy, AbstractC1464Yb abstractC1464Yb) {
        this.A0C = c1929gi;
        this.A0D = va;
        this.A0B = c1335Sx;
        this.A0G = c1874fp;
        this.A0E = y2;
        this.A05 = interfaceC1470Yh;
        this.A0A = abstractC2094jd;
        this.A07 = list;
        this.A00 = i;
        this.A03 = i4;
        this.A06 = str;
        this.A01 = i3;
        this.A02 = i2;
        this.A0F = c1005Fy;
        this.A04 = abstractC1464Yb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC1277Qq
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final FY A0F(ViewGroup viewGroup, int i) {
        return new FY(AbstractC1699cy.A00(new C1645c6(this.A0C, this.A0D, this.A05, this.A0A, null, this.A0G, this.A0E).A0P(this.A04).A0U(), this.A03, this.A06, this.A0F), this.A09, this.A0G, this.A00, this.A01, this.A02, this.A07.size(), this.A0C, this.A0A.A2A());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC1277Qq
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void A0K(FY fy, int i) {
        fy.A0q(this.A07.get(i), this.A0D, this.A0B, this.A0E, this.A06);
        if (!this.A08 && i == 0) {
            fy.AJF();
            this.A08 = true;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1277Qq
    public final int A0B() {
        return this.A07.size();
    }
}
