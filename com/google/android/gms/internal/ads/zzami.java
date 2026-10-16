package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzami implements Comparable {
    public final int zza;
    public final zzamd zzb;

    public zzami(int i, zzamd zzamdVar) {
        this.zza = i;
        this.zzb = zzamdVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.zza, ((zzami) obj).zza);
    }
}
