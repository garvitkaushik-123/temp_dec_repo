package com.instagram.common.viewpoint.core;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class MT implements InterfaceC1471Yi {
    public static byte[] A02;
    public static String[] A03 = {"NTFBcVe31dSo2GnU3Js6iiY0zks5LQys", "Ca9zWfFJkFyFOF3Godi91RgYkRzgzr2p", "cII4QPxWTYmVZfubYcNoLj9MPP8GF9tt", "PE9F3dLYBiF4JqqMXSdTSS6miGDS", "DZYdCvYuTuX3W9uqeE5C1IukMMXrX2Kv", "LDE71mkJxI8TxTUVwO2u55MEQLy5qptr", "oLxvrvG8qZvA3h0mNhA70cq5V56", "NZtOBPQowQq2"};
    public final C1291Re A00;
    public final C1929gi A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 25);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{46, 41, 51, 56, 53, 49, 56, 38, 55, 55, 56, 40, 53, 46, 34, 41, 51, 38, 51, 46, 40, 41, 56, 44, 34, 62, 78, 73, 79, 66, 92, 89, 66, 84, 89, 66, 86, 88, 68, 69, 73, 75, 8, SignedBytes.MAX_POWER_OF_TWO, 71, 69, 67, 68, 73, 73, 77, 8, 71, 66, 85, 8, 79, 72, 82, 67, 84, 72, 71, 74, 8, 79, 86, 69, 8, 103, 83, 66, 79, 67, 72, 69, 67, 104, 67, 82, 81, 73, 84, 77, 99, 94, 86, 73, 84, 82, 67, 66, 103, 69, 82, 79, 80, 79, 82, 95};
    }

    static {
        A01();
    }

    public MT(C1929gi c1929gi, C1291Re c1291Re) {
        this.A01 = c1929gi;
        this.A00 = c1291Re;
    }

    private final void A02() {
        T5 A0G = this.A01.A0G();
        if (A0G != null) {
            Ad A6k = A0G.A6k();
            String[] strArr = A03;
            if (strArr[2].charAt(26) == strArr[4].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "uggbWVrJrahsC4DgFI3QlP54yVqi59lG";
            strArr2[1] = "7cYKYqsJYjxuuUZE8o6LAtyu5uwrvd1J";
            if (A6k != null && A0G.A6o() != null) {
                A0G.A6o().onError(A6k, AdError.AD_PRESENTATION_ERROR);
            }
        }
        this.A00.A05().finish();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AAu(Intent intent, Bundle bundle, C1291Re c1291Re) {
        ComponentName component = new ComponentName(AbstractC1382Us.A05(AbstractC1382Us.A02.get()), A00(39, 61, 63));
        Intent intent2 = new Intent();
        intent2.setComponent(component);
        String A00 = A00(26, 13, 4);
        intent2.putExtra(A00, intent.getStringExtra(A00));
        String A002 = A00(0, 26, 126);
        intent2.putExtra(A002, intent.getIntExtra(A002, -1));
        try {
            this.A01.A0F().AID();
            C1433Wu.A09(c1291Re.A05(), intent2);
        } catch (C1431Ws unused) {
            A02();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AFA(boolean z) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AFi(boolean z) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AIv(Bundle bundle) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final String getCurrentClientToken() {
        return A00(0, 0, 70);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        this.A01.A0F().AHp();
        if (i2 != -1) {
            this.A01.A0F().AHo(i2);
            A02();
            return false;
        }
        C1291Re c1291Re = this.A00;
        String[] strArr = A03;
        if (strArr[6].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[6] = "sxsZAXbczpYXyJjlUSCXbm3Rr92";
        strArr2[7] = "fqqSdoB1RgIi";
        c1291Re.A05().finish();
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void onDestroy() {
    }
}
