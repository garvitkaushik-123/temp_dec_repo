package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzavn implements Runnable {
    final /* synthetic */ zzavo zza;

    zzavn(zzavo zzavoVar) {
        this.zza = zzavoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        boolean z;
        zzawx zzawxVar;
        ConditionVariable conditionVariable2;
        zzavo zzavoVar = this.zza;
        if (zzavoVar.zzb != null) {
            return;
        }
        conditionVariable = zzavo.zzc;
        synchronized (conditionVariable) {
            if (zzavoVar.zzb != null) {
                return;
            }
            boolean z2 = false;
            try {
                z = ((Boolean) zzbde.zzcO.zze()).booleanValue();
            } catch (IllegalStateException unused) {
                z = false;
            }
            if (z) {
                try {
                    zzawxVar = this.zza.zze;
                    zzavo.zza = zzfqi.zzb(zzawxVar.zza, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z2 = z;
            this.zza.zzb = Boolean.valueOf(z2);
            conditionVariable2 = zzavo.zzc;
            conditionVariable2.open();
        }
    }
}
