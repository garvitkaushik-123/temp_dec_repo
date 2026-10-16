package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzapa implements zzadv {
    private final zzen zza = new zzen(4);
    private final zzaew zzb = new zzaew(-1, -1, "image/webp");

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
        zzen zzenVar = this.zza;
        zzenVar.zzI(4);
        zzadl zzadlVar = (zzadl) zzadwVar;
        zzadlVar.zzm(zzenVar.zzN(), 0, 4, false);
        if (zzenVar.zzu() == 1380533830) {
            zzadlVar.zzl(4, false);
            zzenVar.zzI(4);
            zzadlVar.zzm(zzenVar.zzN(), 0, 4, false);
            if (zzenVar.zzu() == 1464156752) {
                return true;
            }
        }
        return false;
    }
}
