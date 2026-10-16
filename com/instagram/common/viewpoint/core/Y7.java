package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.media.AudioManager;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class Y7 {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 5);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{100, 92, 111, 123, 106, 103, 97, 121, 109, 108, 119, 104, 116, 121, 97, 7, 0, 2, 7, 0, Ascii.VT};
    }

    public static float A00(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(A01(2, 5, 11));
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(3);
            int volume = audioManager.getStreamMaxVolume(3);
            if (volume > 0) {
                return (streamVolume * 1.0f) / volume;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    public static void A03(Map<String, String> map, boolean z, boolean z2) {
        String A01 = A01(1, 1, 104);
        String A012 = A01(0, 1, 81);
        map.put(A01(7, 8, 29), z ? A01 : A012);
        if (!z2) {
            A01 = A012;
        }
        map.put(A01(15, 6, 107), A01);
    }
}
