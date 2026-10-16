package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcdr extends zzcdn {
    public zzcdr(zzccb zzccbVar) {
        super(zzccbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzt(String str) {
        String zzk = com.google.android.gms.ads.internal.util.client.zzf.zzk(str);
        zzccb zzccbVar = (zzccb) this.zzc.get();
        if (zzccbVar != null && zzk != null) {
            zzccbVar.zzt(zzk, this);
        }
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, zzk, "noop", "Noop cache is a noop.");
        return false;
    }
}
