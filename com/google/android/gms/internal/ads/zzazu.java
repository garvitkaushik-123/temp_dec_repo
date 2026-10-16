package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzazu implements Runnable {
    final /* synthetic */ zzazv zza;

    zzazu(zzazv zzazvVar) {
        Objects.requireNonNull(zzazvVar);
        this.zza = zzazvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List list;
        zzazv zzazvVar = this.zza;
        obj = zzazvVar.zzc;
        synchronized (obj) {
            z = zzazvVar.zzd;
            if (z) {
                z2 = zzazvVar.zze;
                if (z2) {
                    zzazvVar.zzd = false;
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("App went background");
                    list = zzazvVar.zzf;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            ((zzazw) it.next()).zza(false);
                        } catch (Exception e) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                        }
                    }
                }
            }
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("App is still foreground");
        }
    }
}
