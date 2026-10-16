package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzfa extends zzdi {
    private final String zza;
    private final String zzb;

    public zzfa(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final String zze() throws RemoteException {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final String zzf() throws RemoteException {
        return this.zzb;
    }
}
