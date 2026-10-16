package com.google.android.gms.internal.consent_sdk;

import android.os.Build;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
public final class zzcu {
    public static boolean zza(boolean z) {
        return Build.VERSION.SDK_INT >= 31 ? Build.FINGERPRINT.contains("generic") || Build.FINGERPRINT.contains("emulator") || Build.HARDWARE.contains("ranchu") : Build.DEVICE.startsWith("generic");
    }
}
