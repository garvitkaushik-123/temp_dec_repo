package com.instagram.common.viewpoint.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;

/* renamed from: com.facebook.ads.redexgen.X.nD, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2300nD extends AbstractC0978Ew {
    public static String[] A01 = {"LN1kZ6lR3vZBqqrviA4uTSOzBGS9o2bO", "mUQPITaRnEXTrG2Wr7xIAnPzPHhU6DS3", "avW0I4bwWNzzQZleeOInYpLZY9PTle7", "LGUT8ZIo3joumZn9NybI7JCchk0DSCTG", "S4WFRdtC0lcE2afHWARgiwpUU5tNPmtd", "SbOYlLigHNVPkFHrMvYK7wwtNeL", "2fmBOvz22OTh8nUuYBKjoVDFU", "lR30iWlIbuozJgbVtB9O9DOed4NJenPq"};
    public C0970Eo A00;

    public abstract Pair<C08117s[], InterfaceC2301nE[]> A0d(C0970Eo c0970Eo, int[][][] iArr, int[] iArr2, C2337no c2337no, Timeline timeline) throws AD;

    /* JADX WARN: Incorrect condition in loop: B:3:0x0005 */
    /* JADX WARN: Incorrect condition in loop: B:6:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A0Y(InterfaceC08087p[] interfaceC08087pArr, C2452pg c2452pg, int[] iArr, boolean z) throws AD {
        int length = interfaceC08087pArr.length;
        int formatSupportLevel = 0;
        int i = 1;
        for (int i2 = 0; i2 < bestRendererIndex; i2++) {
            InterfaceC08087p interfaceC08087p = interfaceC08087pArr[i2];
            int i3 = 0;
            for (int bestFormatSupportLevel = 0; bestFormatSupportLevel < bestRendererIndex; bestFormatSupportLevel++) {
                int bestRendererIndex = interfaceC08087p.AKM(c2452pg.A08(bestFormatSupportLevel));
                i3 = Math.max(i3, AbstractC08017i.A03(bestRendererIndex));
            }
            int bestRendererIndex2 = iArr[i2];
            int bestRendererIndex3 = bestRendererIndex2 == 0 ? 1 : 0;
            if (i3 > formatSupportLevel || (i3 == formatSupportLevel && z && i == 0 && bestRendererIndex3 != 0)) {
                length = i2;
                formatSupportLevel = i3;
                i = bestRendererIndex3;
            }
        }
        return length;
    }

    public static int[] A0Z(InterfaceC08087p interfaceC08087p, C2452pg c2452pg) throws AD {
        int[] iArr = new int[c2452pg.A01];
        for (int i = 0; i < c2452pg.A01; i++) {
            iArr[i] = interfaceC08087p.AKM(c2452pg.A08(i));
        }
        return iArr;
    }

    public static int[] A0a(InterfaceC08087p[] interfaceC08087pArr) throws AD {
        int[] iArr = new int[interfaceC08087pArr.length];
        for (int i = 0; i < iArr.length; i++) {
            int AKO = interfaceC08087pArr[i].AKO();
            String[] strArr = A01;
            String str = strArr[4];
            String str2 = strArr[1];
            int i2 = str.charAt(23);
            if (i2 == str2.charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "1ViYEGUZxGRCVXLKV1NACncyCaxKGcLE";
            strArr2[1] = "WZkUCc71MckdncxFpAml539B1oxWjr0A";
            iArr[i] = AKO;
        }
        return iArr;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0978Ew
    public final C0979Ex A0b(InterfaceC08087p[] interfaceC08087pArr, C2319nW c2319nW, C2337no c2337no, Timeline timeline) throws AD {
        int[] rendererTrackGroupCounts;
        int[] iArr = new int[interfaceC08087pArr.length + 1];
        C2452pg[][] c2452pgArr = new C2452pg[interfaceC08087pArr.length + 1][];
        int[][][] iArr2 = new int[interfaceC08087pArr.length + 1][][];
        for (int i = 0; i < c2452pgArr.length; i++) {
            c2452pgArr[i] = new C2452pg[c2319nW.A01];
            iArr2[i] = new int[c2319nW.A01][];
        }
        int[] A0a = A0a(interfaceC08087pArr);
        for (int i2 = 0; i2 < c2319nW.A01; i2++) {
            C2452pg A05 = c2319nW.A05(i2);
            int groupIndex = A0Y(interfaceC08087pArr, A05, iArr, A05.A02 == 5);
            if (groupIndex == interfaceC08087pArr.length) {
                rendererTrackGroupCounts = new int[A05.A01];
            } else {
                rendererTrackGroupCounts = A0Z(interfaceC08087pArr[groupIndex], A05);
            }
            int i3 = iArr[groupIndex];
            c2452pgArr[groupIndex][i3] = A05;
            iArr2[groupIndex][i3] = rendererTrackGroupCounts;
            iArr[groupIndex] = iArr[groupIndex] + 1;
        }
        C2319nW[] c2319nWArr = new C2319nW[interfaceC08087pArr.length];
        String[] strArr = new String[interfaceC08087pArr.length];
        int[] iArr3 = new int[interfaceC08087pArr.length];
        int i4 = 0;
        while (true) {
            int length = interfaceC08087pArr.length;
            String[] strArr2 = A01;
            if (strArr2[4].charAt(23) == strArr2[1].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr3 = A01;
            strArr3[4] = "hppY0P6sht5kF7is4RCKyMBKsFUVAoRB";
            strArr3[1] = "XeHPWbHBeoBDFVDQc4DbmKa9NYqMdrJh";
            if (i4 < length) {
                int i5 = iArr[i4];
                c2319nWArr[i4] = new C2319nW((C2452pg[]) C5C.A1I(c2452pgArr[i4], i5));
                iArr2[i4] = (int[][]) C5C.A1I(iArr2[i4], i5);
                strArr[i4] = interfaceC08087pArr[i4].getName();
                iArr3[i4] = interfaceC08087pArr[i4].A9N();
                i4++;
            } else {
                C0970Eo c0970Eo = new C0970Eo(strArr, iArr3, c2319nWArr, A0a, iArr2, new C2319nW((C2452pg[]) C5C.A1I(c2452pgArr[interfaceC08087pArr.length], iArr[interfaceC08087pArr.length])));
                Pair<C08117s[], InterfaceC2301nE[]> A0d = A0d(c0970Eo, iArr2, A0a, c2337no, timeline);
                return new C0979Ex((C08117s[]) A0d.first, (InterfaceC2301nE[]) A0d.second, AbstractC0975Et.A00(c0970Eo, (InterfaceC0972Eq[]) A0d.second), c0970Eo);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0978Ew
    public final void A0c(Object obj) {
        this.A00 = (C0970Eo) obj;
    }
}
