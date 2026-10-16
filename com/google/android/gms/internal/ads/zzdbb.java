package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdbb implements zzcza {
    private int zza = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbt)).intValue();
    private int zzb = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznl)).intValue();

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final synchronized void zzdo(zzfcn zzfcnVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbu)).booleanValue()) {
            try {
                zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
                this.zza = zzfcdVar.zzc;
                this.zzb = zzfcdVar.zzd;
            } catch (NullPointerException unused) {
            }
        }
    }
}
