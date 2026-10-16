package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class I1 implements InterfaceC1567aq {
    public static byte[] A01;
    public static String[] A02 = {"BeK4HZWWIRhrC207wWuIOn", "ZxUaKMHZMCvHIxTDkc1UvZSYXikI2iYM", "xy0Ab8m7NOX4ZRxTfyGPwRY1TRrgVPC4", "ij8auLNb9rfA8yI55JUjNirWgnYpCp0M", "e9T4yeifuMgQg3dKDn6E2LsVBs4fgiHR", "ibrxpSG6qut0wBAmR6wSiB8exNotCqiu", "LMYPYXdb4SaVI93FsN1uYFih9", "8N3vGs6nddgUWUG"};
    public final /* synthetic */ C5F A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A02;
            if (strArr[6].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A02[2] = "F3dYTVgRpzEGoEWMN2T8FFCtbrhRHRBi";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 99);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{Ascii.NAK, 19, 5, Ascii.DC2, 63, Ascii.SO, 1, Ascii.SYN, 9, 7, 1, Ascii.DC4, 9, Ascii.SI, Ascii.SO, 63, 9, 1, 2};
    }

    static {
        A01();
    }

    public I1(C5F c5f) {
        this.A00 = c5f;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AF7(String str) {
        C1558ah c1558ah;
        C1558ah c1558ah2;
        this.A00.A0Q = false;
        c1558ah = this.A00.A0F;
        c1558ah.setProgress(100);
        c1558ah2 = this.A00.A0F;
        YB.A0O(c1558ah2, 8);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AF9(String str) {
        C1558ah c1558ah;
        M6 m6;
        boolean z;
        int i;
        this.A00.A0Q = true;
        c1558ah = this.A00.A0F;
        YB.A0O(c1558ah, 0);
        m6 = this.A00.A0E;
        m6.setUrl(str);
        z = this.A00.A0P;
        if (!z) {
            C5F c5f = this.A00;
            if (A02[5].charAt(30) != 'i') {
                throw new RuntimeException();
            }
            A02[7] = "LFtEVX0D7i5Pos5vlgnVVb1H7Q5y";
            i = c5f.A02;
            if (i > 1) {
                this.A00.A0P = true;
                this.A00.A0i(A00(0, 19, 3));
            }
        }
        C5F.A05(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFY(int i) {
        boolean z;
        C1558ah c1558ah;
        z = this.A00.A0Q;
        if (z) {
            c1558ah = this.A00.A0F;
            c1558ah.setProgress(i);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFb(String str) {
        M6 m6;
        m6 = this.A00.A0E;
        m6.setTitle(str);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFe() {
        ((AbstractC1068Ij) this.A00).A0B.ADJ(14);
    }
}
