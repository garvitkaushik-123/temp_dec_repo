package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeuy implements zzeub {
    final String zza;
    final int zzb;

    /* synthetic */ zzeuy(String str, int i, zzeux zzeuxVar) {
        this.zza = str;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcva zzcvaVar = (zzcva) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkQ)).booleanValue()) {
            String str = this.zza;
            if (!TextUtils.isEmpty(str)) {
                zzcvaVar.zza.putString("topics", str);
            }
            int i = this.zzb;
            if (i != -1) {
                zzcvaVar.zza.putInt("atps", i);
            }
        }
    }
}
