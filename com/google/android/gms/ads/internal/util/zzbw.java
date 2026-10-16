package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzfjp;
import com.google.android.gms.internal.ads.zzfjq;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbw extends zzb {
    private final com.google.android.gms.ads.internal.util.client.zzu zza;
    private final String zzb;
    private final com.google.android.gms.ads.internal.util.client.zzv zzc;

    public zzbw(Context context, String str, String str2, zzfjq zzfjqVar, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.zza = new com.google.android.gms.ads.internal.util.client.zzu(context, com.google.android.gms.ads.internal.zzv.zzr().zzc(context, str));
        this.zzb = str2;
        this.zzc = zzvVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        if (zzvVar == null) {
            this.zza.zza(this.zzb);
        } else {
            new zzfjp(zzvVar.zzb(), this.zza, zzcaf.zze, null).zzd(this.zzb);
        }
    }
}
