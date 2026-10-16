package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.nW, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2319nW implements AnonymousClass24 {
    public static byte[] A03;
    public static String[] A04 = {"kjXOolT", "y1uosoppcQ2KAnagmdUHUDs2pqKkNOP", "9S5fCrLfVI6Z6wWSlA", "LW4KLvv", "ESAoxwChDjEBJ2YD38hEjiU5IsN", "MD8cz6uZEkXt7x64XO0blzPRBkN5Dhm8", "wv8vTraLOdvtLK52tGc0aCYgNtDO0cFF", "ftZS2reRIxcEfCn6parOlN78mV3R9Y2K"};
    public static final AnonymousClass23<C2319nW> A05;
    public static final C2319nW A06;
    public static final String A07;
    public int A00;
    public final int A01;
    public final BP<C2452pg> A02;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 95);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        byte[] bArr = {119, 79, 86, 78, 83, 74, 86, 95, Ascii.SUB, 83, 94, 95, 84, 78, 83, 89, 91, 86, Ascii.SUB, 110, 72, 91, 89, 81, 125, 72, 85, 79, 74, 73, Ascii.SUB, 91, 94, 94, 95, 94, Ascii.SUB, 78, 85, Ascii.SUB, 85, 84, 95, Ascii.SUB, 110, 72, 91, 89, 81, 125, 72, 85, 79, 74, 123, 72, 72, 91, 67, Ascii.DC4, 81, 119, 100, 102, 110, 66, 119, 106, 112, 117, 68, 119, 119, 100, 124};
        if (A04[5].charAt(31) == 'Q') {
            throw new RuntimeException();
        }
        A04[4] = "LoVxB454";
        A03 = bArr;
    }

    static {
        A03();
        A06 = new C2319nW(new C2452pg[0]);
        A07 = C5C.A0h(0);
        A05 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.nX
            @Override // com.instagram.common.viewpoint.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return C2319nW.A00(bundle);
            }
        };
    }

    public C2319nW(C2452pg... c2452pgArr) {
        this.A02 = BP.A07(c2452pgArr);
        this.A01 = c2452pgArr.length;
        A02();
    }

    public static /* synthetic */ C2319nW A00(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A07);
        if (parcelableArrayList == null) {
            return new C2319nW(new C2452pg[0]);
        }
        return new C2319nW((C2452pg[]) AnonymousClass44.A01(C2452pg.A06, parcelableArrayList).toArray(new C2452pg[0]));
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0007 */
    /* JADX WARN: Incorrect condition in loop: B:6:0x0011 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A02() {
        for (int i = 0; i < i; i++) {
            for (int i2 = i + 1; i2 < i; i2++) {
                if (this.A02.get(i).equals(this.A02.get(i2))) {
                    AbstractC07214g.A08(A01(60, 15, 90), A01(0, 0, 115), new IllegalArgumentException(A01(0, 60, 101)));
                }
            }
        }
    }

    public final int A04(C2452pg c2452pg) {
        int index = this.A02.indexOf(c2452pg);
        if (index >= 0) {
            return index;
        }
        return -1;
    }

    public final C2452pg A05(int i) {
        return this.A02.get(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2319nW c2319nW = (C2319nW) obj;
        return this.A01 == c2319nW.A01 && this.A02.equals(c2319nW.A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = this.A02.hashCode();
        }
        int i = this.A00;
        String[] strArr = A04;
        if (strArr[3].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        A04[6] = "ifk0Ba0Zppjn7MlaJBrmzFqZbJ0HKklT";
        return i;
    }
}
