package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzqn extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzz zzc;

    public zzqn(int i, zzz zzzVar, boolean z) {
        super("AudioTrack write failed: " + i);
        this.zzb = z;
        this.zza = i;
        this.zzc = zzzVar;
    }
}
