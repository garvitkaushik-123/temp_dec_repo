package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcuf implements zzcza, zzdep {
    private final Context zza;
    private final zzfcw zzb;
    private final VersionInfoParcel zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzdun zze;
    private final zzfhx zzf;
    private final zzdvi zzg;

    public zzcuf(Context context, zzfcw zzfcwVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.util.zzg zzgVar, zzdun zzdunVar, zzfhx zzfhxVar, zzdvi zzdviVar) {
        this.zza = context;
        this.zzb = zzfcwVar;
        this.zzc = versionInfoParcel;
        this.zzd = zzgVar;
        this.zze = zzdunVar;
        this.zzf = zzfhxVar;
        this.zzg = zzdviVar;
    }

    private final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeo)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzd;
            Context context = this.zza;
            VersionInfoParcel versionInfoParcel = this.zzc;
            zzfcw zzfcwVar = this.zzb;
            zzfhx zzfhxVar = this.zzf;
            zzdvi zzdviVar = this.zzg;
            com.google.android.gms.ads.internal.zzv.zza().zze(context, versionInfoParcel, zzfcwVar.zzf, zzgVar.zzg(), zzfhxVar, zzdviVar.zzq());
        }
        this.zze.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
        zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbk zzbkVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzep)).booleanValue()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zzf(String str) {
    }
}
