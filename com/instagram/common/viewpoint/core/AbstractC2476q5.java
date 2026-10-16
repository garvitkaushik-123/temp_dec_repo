package com.instagram.common.viewpoint.core;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.q5, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2476q5<K0, V0> {
    public static byte[] A00;

    static {
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + RangingPosition.RSSI_MIN);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{97, 116, 108, 97, 95, 112, 97, 96, 71, 97, 117, 111};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.q5 != com.google.common.collect.MultimapBuilder<K0, V0> */
    public AbstractC2476q5() {
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.q5 != com.google.common.collect.MultimapBuilder<K0, V0> */
    public /* synthetic */ AbstractC2476q5(BG bg) {
        this();
    }

    public static AbstractC2475q4<Object> A00(int expectedKeys) {
        AbstractC2306nJ.A00(expectedKeys, A03(0, 12, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE));
        return new BG(expectedKeys);
    }

    public static <K0> AbstractC2475q4<K0> A01(Comparator<K0> comparator) {
        AbstractC2159ki.A04(comparator);
        return new BF(comparator);
    }

    public static AbstractC2475q4<Comparable> A02() {
        return A01(AbstractC2491qK.A03());
    }
}
