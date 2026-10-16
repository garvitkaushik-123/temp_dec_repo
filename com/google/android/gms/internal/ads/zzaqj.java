package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaqj {
    public final Object zza;
    public final zzapm zzb;
    public final zzaqm zzc;
    public boolean zzd;

    private zzaqj(zzaqm zzaqmVar) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzaqmVar;
    }

    private zzaqj(Object obj, zzapm zzapmVar) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzapmVar;
        this.zzc = null;
    }

    public static zzaqj zza(zzaqm zzaqmVar) {
        return new zzaqj(zzaqmVar);
    }

    public static zzaqj zzb(Object obj, zzapm zzapmVar) {
        return new zzaqj(obj, zzapmVar);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
