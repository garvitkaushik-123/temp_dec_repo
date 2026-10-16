package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaxf implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzaxg zza;

    zzaxf(zzaxg zzaxgVar) {
        this.zza = zzaxgVar;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        long j;
        long j2;
        long j3;
        if (z) {
            zzaxg zzaxgVar = this.zza;
            zzaxgVar.zzb = System.currentTimeMillis();
            zzaxgVar.zze = true;
            return;
        }
        zzaxg zzaxgVar2 = this.zza;
        long currentTimeMillis = System.currentTimeMillis();
        j = zzaxgVar2.zzc;
        if (j > 0) {
            j2 = zzaxgVar2.zzc;
            if (currentTimeMillis >= j2) {
                j3 = zzaxgVar2.zzc;
                zzaxgVar2.zzd = currentTimeMillis - j3;
            }
        }
        zzaxgVar2.zze = false;
    }
}
