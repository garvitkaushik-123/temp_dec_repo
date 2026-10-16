package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzesd implements zzeub {
    public final zzfbz zza;

    public zzesd(zzfbz zzfbzVar) {
        this.zza = zzfbzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcva zzcvaVar = (zzcva) obj;
        zzfbz zzfbzVar = this.zza;
        if (zzfbzVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmr)).booleanValue()) {
                return;
            }
            Bundle bundle = zzcvaVar.zza;
            bundle.putBoolean("render_in_browser", zzfbzVar.zzd());
            bundle.putBoolean("disable_ml", zzfbzVar.zzc());
        }
    }
}
