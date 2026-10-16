package com.instagram.common.viewpoint.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Nw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1209Nw implements InterfaceC1463Ya {
    public static String[] A01 = {"dAENZa04S5kpLZ1505OVGzU", "BCWAX", "x4EBtM5L1", "d5mzvX7vdf5oGTbdkf23a85QS6J33UuP", "T3xMk8xyeuXfnP2cHDF22zgmf4sSWk7a", "D6RnJQb1nSkQk7teZoJG77p", "lMrZ8D5HcAsH09zpnUIM78ubrFXrhoz6", "r7D6OIPJDO7XxyVdFUwVLtQI1zZlrgYr"};
    public final /* synthetic */ NO A00;

    public C1209Nw(NO no) {
        this.A00 = no;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1463Ya
    public final void ACl(AbstractC1464Yb abstractC1464Yb) {
        boolean A0Y;
        boolean z;
        VI vi;
        C1201No c1201No;
        C1929gi c1929gi;
        InterfaceC1470Yh interfaceC1470Yh;
        ZU zu;
        C1929gi c1929gi2;
        AtomicBoolean atomicBoolean;
        boolean A0X;
        AtomicBoolean atomicBoolean2;
        C1621bi c1621bi;
        A0Y = this.A00.A0Y();
        if (A0Y) {
            atomicBoolean2 = this.A00.A0b;
            if (!atomicBoolean2.get()) {
                c1621bi = this.A00.A0Z;
                c1621bi.A07(this.A00);
                return;
            }
        }
        NO no = this.A00;
        if (A01[4].charAt(5) == '8') {
            A01[1] = "011C";
            z = no.A0d;
            if (z) {
                atomicBoolean = this.A00.A0b;
                if (!atomicBoolean.get()) {
                    A0X = this.A00.A0X();
                    if (A0X) {
                        this.A00.A0g.setToolbarActionMode(0);
                        this.A00.A0N();
                        return;
                    }
                }
            }
            vi = this.A00.A0T;
            vi.A04(VH.A07, null);
            c1201No = this.A00.A0P;
            if (c1201No.A0c()) {
                c1929gi2 = this.A00.A0R;
                c1929gi2.A0F().AEO();
            }
            c1929gi = this.A00.A0R;
            c1929gi.A0F().AB0();
            interfaceC1470Yh = this.A00.A0W;
            zu = this.A00.A0X;
            String A7w = zu.A7w();
            if (A01[6].charAt(7) != 'V') {
                String[] strArr = A01;
                strArr[3] = "iNY9OvP3hEWy4eydF9NsffnrPtCfLtIx";
                strArr[7] = "zl19Behk0RYI4HrdG27XeFY6Dxp3Bz2i";
                interfaceC1470Yh.A4j(A7w);
                return;
            }
        }
        throw new RuntimeException();
    }
}
