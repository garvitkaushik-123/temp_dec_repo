package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzfyf {
    private static final zzfyf zza = new zzfyc();
    private static final zzfyf zzb = new zzfyd(-1);
    private static final zzfyf zzc = new zzfyd(1);

    /* synthetic */ zzfyf(zzfye zzfyeVar) {
    }

    public static zzfyf zzj() {
        return zza;
    }

    public abstract int zza();

    public abstract zzfyf zzb(int i, int i2);

    public abstract zzfyf zzc(Object obj, Object obj2, Comparator comparator);

    public abstract zzfyf zzd(boolean z, boolean z2);

    public abstract zzfyf zze(boolean z, boolean z2);
}
