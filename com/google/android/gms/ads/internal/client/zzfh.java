package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzfh implements Runnable {
    final /* synthetic */ zzfi zza;

    zzfh(zzfi zzfiVar) {
        Objects.requireNonNull(zzfiVar);
        this.zza = zzfiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbk zzbkVar;
        zzbk zzbkVar2;
        zzfk zzfkVar = this.zza.zza;
        zzbkVar = zzfkVar.zza;
        if (zzbkVar != null) {
            try {
                zzbkVar2 = zzfkVar.zza;
                zzbkVar2.zze(1);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
