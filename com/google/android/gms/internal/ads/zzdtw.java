package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdtw implements zzdtk {
    private final long zza;
    private final zzelg zzb;

    zzdtw(long j, Context context, zzdtp zzdtpVar, zzche zzcheVar, String str) {
        this.zza = j;
        zzfaf zzu = zzcheVar.zzu();
        zzu.zzc(context);
        zzu.zza(new com.google.android.gms.ads.internal.client.zzr());
        zzu.zzb(str);
        zzelg zza = zzu.zzd().zza();
        this.zzb = zza;
        zza.zzE(new zzdtv(this, zzdtpVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zza() {
        this.zzb.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzb(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zzb.zzad(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzc() {
        this.zzb.zzY(ObjectWrapper.wrap(null));
    }
}
