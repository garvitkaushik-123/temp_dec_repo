package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public class zzbeo {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzbeo(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbeo zza(String str, double d) {
        return new zzbeo(str, Double.valueOf(d), 3);
    }

    public static zzbeo zzb(String str, long j) {
        return new zzbeo(str, Long.valueOf(j), 2);
    }

    public static zzbeo zzc(String str, String str2) {
        return new zzbeo("gad:dynamite_module:experiment_id", "", 4);
    }

    public static zzbeo zzd(String str, boolean z) {
        return new zzbeo(str, Boolean.valueOf(z), 1);
    }

    public final Object zze() {
        zzbft zza = zzbfv.zza();
        if (zza != null) {
            int i = this.zzc - 1;
            return i != 0 ? i != 1 ? i != 2 ? zza.zzd(this.zza, (String) this.zzb) : zza.zzb(this.zza, ((Double) this.zzb).doubleValue()) : zza.zzc(this.zza, ((Long) this.zzb).longValue()) : zza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (zzbfv.zzb() != null) {
            zzbfv.zzb().zza();
        }
        return this.zzb;
    }
}
