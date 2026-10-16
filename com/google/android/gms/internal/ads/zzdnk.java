package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdnk implements zzbkf {
    private final zzbht zza;
    private final zzdny zzb;
    private final zzhgl zzc;

    public zzdnk(zzdje zzdjeVar, zzdit zzditVar, zzdny zzdnyVar, zzhgl zzhglVar) {
        this.zza = zzdjeVar.zzc(zzditVar.zzA());
        this.zzb = zzdnyVar;
        this.zzc = zzhglVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbhj) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    public final void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zzb.zzl("/nativeAdCustomClick", this);
    }
}
