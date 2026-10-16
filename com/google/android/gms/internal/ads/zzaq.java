package com.google.android.gms.internal.ads;

import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaq {
    private static final HashSet zza = new HashSet();
    private static String zzb = "media3.common";

    public static synchronized String zza() {
        String str;
        synchronized (zzaq.class) {
            str = zzb;
        }
        return str;
    }

    public static synchronized void zzb(String str) {
        synchronized (zzaq.class) {
            if (zza.add(str)) {
                zzb = zzb + ", " + str;
            }
        }
    }
}
