package com.instagram.common.viewpoint.core;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.ads.NativeAd;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.h6, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1953h6 implements InterfaceC1327Sp {
    public static String[] A02 = {"XqTxzibSN1zAjaiM9LtVSqsxSG", "xqN5bEwB0Nihon7KSuA", "FVkOY26I4teb9ftOLmk9A45ZS3TS2DIY", "wzTDEcMKt7VvW9W8eKeIWksTnJ0tE", "iGRCr9OHUARnshCNCmKS3XNzEIA09VDm", "MJLgHxMJm3Fw", ExifInterface.LATITUDE_SOUTH, "m77T1m6dtAhGTcgbhkAg"};
    public final List<C2111ju> A00;
    public final /* synthetic */ C1952h5 A01;

    public C1953h6(C1952h5 c1952h5, List<C2111ju> list) {
        this.A01 = c1952h5;
        this.A00 = list;
    }

    private void A00() {
        S6 s6;
        S6 s62;
        S6 s63;
        C1929gi c1929gi;
        S6 s64;
        S6 s65;
        C1929gi c1929gi2;
        NativeAd.NativeOptions nativeOptions;
        s6 = this.A01.A01;
        s6.A05(true);
        s62 = this.A01.A01;
        s62.A02();
        s63 = this.A01.A01;
        s63.A03(0);
        Iterator<C2111ju> it = this.A00.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A02[4].charAt(3) == 'E') {
                throw new RuntimeException();
            }
            A02[0] = "GKxyFdZ7ADxfGJ";
            if (hasNext) {
                C2111ju next = it.next();
                c1929gi = this.A01.A02;
                C1374Uk A0K = UK.A0K();
                s64 = this.A01.A01;
                UK uk = new UK(c1929gi, next, null, A0K, s64.A01());
                if (uk.A12() != null && uk.A12().A0F() != null) {
                    ((AbstractC2059iv) uk.A12().A0F()).A00(uk);
                }
                s65 = this.A01.A01;
                c1929gi2 = this.A01.A02;
                nativeOptions = this.A01.A00;
                s65.A04(new NativeAd(c1929gi2, uk, nativeOptions));
            } else {
                WT.A00(new C1954h7(this));
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1327Sp
    public final void ADL() {
        A00();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1327Sp
    public final void ADT() {
        A00();
    }
}
