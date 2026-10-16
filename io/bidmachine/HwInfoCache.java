package io.bidmachine;

import android.content.Context;
import android.os.Build;

/* loaded from: classes7.dex */
final class HwInfoCache {
    private static final String KEY_HW = Build.MANUFACTURER + Build.MODEL;

    HwInfoCache() {
    }

    String read(Context context, String key) {
        return BidMachineSharedPreference.getHwInfo(context, key + KEY_HW);
    }

    void store(Context context, String key, String value) {
        BidMachineSharedPreference.setHwInfo(context, key + KEY_HW, value);
    }
}
