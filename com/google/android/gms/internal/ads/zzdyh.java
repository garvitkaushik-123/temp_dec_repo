package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdyh extends zzbvh {
    private final zzcak zza;
    private final zzbvq zzb;

    zzdyh(zzcak zzcakVar, zzbvq zzbvqVar) {
        this.zza = zzcakVar;
        this.zzb = zzbvqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) {
        this.zza.zzd(zzbbVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzc(new zzdyy(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvq zzbvqVar) {
        this.zza.zzc(new zzdyy(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbvqVar));
    }
}
