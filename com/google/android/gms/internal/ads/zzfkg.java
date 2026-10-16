package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfkg {
    private final long zza;
    private final long zzb;
    private long zze;
    private long zzd = 5;
    private final Random zzf = new Random();
    private long zzc = 0;

    public zzfkg(long j, double d, long j2, double d2) {
        this.zza = j;
        this.zzb = j2;
        zzc();
    }

    public final long zza() {
        double d = this.zze;
        double d2 = 0.2d * d;
        long j = (long) (d + d2);
        return ((long) (d - d2)) + ((long) (this.zzf.nextDouble() * ((j - r0) + 1)));
    }

    public final void zzb() {
        double d = this.zze;
        this.zze = Math.min((long) (d + d), this.zzb);
        this.zzc++;
    }

    public final void zzc() {
        this.zze = this.zza;
        this.zzc = 0L;
    }

    public final synchronized void zzd(int i) {
        Preconditions.checkArgument(i > 0);
        this.zzd = i;
    }

    public final boolean zze() {
        return this.zzc > Math.max(this.zzd, (long) ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzE)).intValue()) && this.zze >= this.zzb;
    }
}
