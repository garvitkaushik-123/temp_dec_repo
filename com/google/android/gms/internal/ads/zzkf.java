package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzkf implements zzlg {
    private final Object zza;
    private zzbl zzb;

    public zzkf(Object obj, zzvc zzvcVar) {
        this.zza = obj;
        this.zzb = zzvcVar.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final zzbl zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final Object zzb() {
        return this.zza;
    }

    public final void zzc(zzbl zzblVar) {
        this.zzb = zzblVar;
    }
}
