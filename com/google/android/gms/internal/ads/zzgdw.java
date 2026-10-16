package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgdw {
    private final zzfwo zza = new zzfwo();
    private final String zzb;
    private volatile Logger zzc;

    zzgdw(Class cls) {
        this.zzb = cls.getName();
    }

    final Logger zza() {
        Logger logger = this.zzc;
        if (logger != null) {
            return logger;
        }
        synchronized (this.zza) {
            Logger logger2 = this.zzc;
            if (logger2 != null) {
                return logger2;
            }
            Logger logger3 = Logger.getLogger(this.zzb);
            this.zzc = logger3;
            return logger3;
        }
    }
}
