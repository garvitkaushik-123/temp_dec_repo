package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
public final class zzeu {
    static final zzeu zza = new zzeu(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzeu zzd;
    private final Map zze;

    zzeu() {
        this.zze = new HashMap();
    }

    public static zzeu zza() {
        zzeu zzeuVar = zzd;
        if (zzeuVar != null) {
            return zzeuVar;
        }
        synchronized (zzeu.class) {
            zzeu zzeuVar2 = zzd;
            if (zzeuVar2 != null) {
                return zzeuVar2;
            }
            int i = zzgs.zza;
            zzeu zzb2 = zzfc.zzb(zzeu.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzfh zzb(zzgl zzglVar, int i) {
        return (zzfh) this.zze.get(new zzet(zzglVar, i));
    }

    zzeu(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
