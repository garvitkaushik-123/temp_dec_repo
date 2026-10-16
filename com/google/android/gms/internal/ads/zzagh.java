package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzagh implements zzadv {
    private final zzen zza = new zzen(4);
    private final zzaew zzb = new zzaew(-1, -1, "image/heif");

    private final boolean zza(zzadw zzadwVar, int i) throws IOException {
        zzen zzenVar = this.zza;
        zzenVar.zzI(4);
        ((zzadl) zzadwVar).zzm(zzenVar.zzN(), 0, 4, false);
        return zzenVar.zzu() == ((long) i);
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        return this.zzb.zzb(zzadwVar, zzaerVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ zzadv zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ List zzd() {
        return zzfyq.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zze(zzady zzadyVar) {
        this.zzb.zze(zzadyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzb.zzf(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        ((zzadl) zzadwVar).zzl(4, false);
        return zza(zzadwVar, 1718909296) && zza(zzadwVar, 1751476579);
    }
}
