package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.q4, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2475q4<K0> {
    public static byte[] A00;
    public static String[] A01 = {"bao8c38n28wPAMqvf0", "eVcWzAuCAXWumTICSFBebUgmb9TguTkL", "p", "gqL7Zo5j54GI4jqi05kLU", "fae6iywUSwwj1RjLTY2P", "asvzUEyWtHVXByXUijz9tuohidd7jT94", "t7lccWit4rbeEMhbm3WlI6hCZ2BNlGb8", "1T7kTgAAsxu7zrmAj3X1"};

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] ^ i3) ^ 104;
            String[] strArr = A01;
            if (strArr[0].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            A01[6] = "XFZlfL1njVMJiM3nHtzYTwesPM930KjJ";
            copyOfRange[i4] = (byte) i5;
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{46, 51, 59, 46, 40, 63, 46, 47, Ascii.GS, 42, 39, 62, 46, 56, Ascii.ESC, 46, 57, 0, 46, 50};
    }

    public abstract <K extends K0, V> Map<K, Collection<V>> A04();

    static {
        A02();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.q4 != com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys<K0> */
    private final BD<K0, Object> A00(final int expectedValuesPerKey) {
        AbstractC2306nJ.A00(expectedValuesPerKey, A01(0, 20, 35));
        return new BD<K0, Object>(this) { // from class: com.facebook.ads.redexgen.X.2F
            public final /* synthetic */ AbstractC2475q4 A01;

            {
                this.A01 = this;
            }

            @Override // com.instagram.common.viewpoint.core.BD
            public final <K extends K0, V> BM<K, V> A00() {
                return AbstractC2479q8.A00(this.A01.A04(), new BE(expectedValuesPerKey));
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.q4 != com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys<K0> */
    public final BD<K0, Object> A03() {
        return A00(2);
    }
}
