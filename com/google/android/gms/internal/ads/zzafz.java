package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzafz extends zzadg {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzafz(final zzaeg zzaegVar, int i, long j, long j2) {
        super(r1, r2, r3, 0L, r7, j, j2, r5, Math.max(6, zzaegVar.zzc));
        long j3;
        Objects.requireNonNull(zzaegVar);
        zzadd zzaddVar = new zzadd() { // from class: com.google.android.gms.internal.ads.zzafw
            @Override // com.google.android.gms.internal.ads.zzadd
            public final long zza(long j4) {
                return zzaeg.this.zzb(j4);
            }
        };
        zzafx zzafxVar = new zzafx(zzaegVar, i, null);
        long zza = zzaegVar.zza();
        long j4 = zzaegVar.zzj;
        int i2 = zzaegVar.zzd;
        if (i2 > 0) {
            j3 = ((i2 + zzaegVar.zzc) / 2) + 1;
        } else {
            int i3 = zzaegVar.zza;
            int i4 = zzaegVar.zzb;
            long j5 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            if (i3 == i4 && i3 > 0) {
                j5 = i3;
            }
            j3 = 64 + (((j5 * zzaegVar.zzg) * zzaegVar.zzh) / 8);
        }
    }
}
