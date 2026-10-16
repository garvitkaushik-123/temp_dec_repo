package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzafk implements zzaeu {
    final /* synthetic */ zzafn zza;
    private final long zzb;

    public zzafk(zzafn zzafnVar, long j) {
        Objects.requireNonNull(zzafnVar);
        this.zza = zzafnVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzb;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0013 */
    @Override // com.google.android.gms.internal.ads.zzaeu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaes zzg(long j) {
        zzafq[] zzafqVarArr;
        zzafq[] zzafqVarArr2;
        zzafq[] zzafqVarArr3;
        zzafn zzafnVar = this.zza;
        zzafqVarArr = zzafnVar.zzi;
        zzaes zza = zzafqVarArr[0].zza(j);
        for (int i = 1; i < zzafqVarArr2.length; i++) {
            zzafqVarArr3 = zzafnVar.zzi;
            zzaes zza2 = zzafqVarArr3[i].zza(j);
            if (zza2.zza.zzc < zza.zza.zzc) {
                zza = zza2;
            }
        }
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
