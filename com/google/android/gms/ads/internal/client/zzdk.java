package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzdk implements MuteThisAdReason {
    private final String zza;
    private final zzdj zzb;

    public zzdk(zzdj zzdjVar) {
        String str;
        this.zzb = zzdjVar;
        try {
            str = zzdjVar.zze();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            str = null;
        }
        this.zza = str;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.zza;
    }

    public final String toString() {
        return this.zza;
    }

    public final zzdj zza() {
        return this.zzb;
    }
}
