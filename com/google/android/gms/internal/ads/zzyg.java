package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzyg implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzyg(zzz zzzVar, int i) {
        this.zza = 1 == (zzzVar.zze & 1);
        this.zzb = zzmb.zza(i, false);
    }

    @Override // java.lang.Comparable
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzyg zzygVar) {
        return zzfyf.zzj().zzd(this.zzb, zzygVar.zzb).zzd(this.zza, zzygVar.zza).zza();
    }
}
