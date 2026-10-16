package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzawv implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzawx zzb;

    zzawv(zzawx zzawxVar, int i, boolean z) {
        this.zza = i;
        this.zzb = zzawxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzatq zzatqVar;
        int i = this.zza;
        zzawx zzawxVar = this.zzb;
        if (i > 0) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            Context context = zzawxVar.zza;
            zzatqVar = zzfoq.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused2) {
            zzatqVar = null;
        }
        zzawx zzawxVar2 = this.zzb;
        zzawxVar2.zzk = zzatqVar;
        int i2 = this.zza;
        if (i2 < 4) {
            if (zzatqVar != null && zzatqVar.zzaf() && !zzatqVar.zzg().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzatqVar.zzag() && zzatqVar.zzf().zzg() && zzatqVar.zzf().zza() != -2) {
                return;
            }
            zzawxVar2.zzn(i2 + 1, true);
        }
    }
}
