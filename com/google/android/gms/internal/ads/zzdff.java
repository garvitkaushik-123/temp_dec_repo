package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzdff {
    private final zzdgn zza;
    private final zzcfg zzb;

    public zzdff(zzdgn zzdgnVar, zzcfg zzcfgVar) {
        this.zza = zzdgnVar;
        this.zzb = zzcfgVar;
    }

    public final View zza() {
        zzcfg zzcfgVar = this.zzb;
        if (zzcfgVar == null) {
            return null;
        }
        return zzcfgVar.zzG();
    }

    public final View zzb() {
        zzcfg zzcfgVar = this.zzb;
        if (zzcfgVar != null) {
            return zzcfgVar.zzG();
        }
        return null;
    }

    public final zzcfg zzc() {
        return this.zzb;
    }

    public final zzddv zzd(Executor executor) {
        final zzcfg zzcfgVar = this.zzb;
        return new zzddv(new zzdas() { // from class: com.google.android.gms.internal.ads.zzdfe
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza() {
                com.google.android.gms.ads.internal.overlay.zzm zzL;
                zzcfg zzcfgVar2 = zzcfg.this;
                if (zzcfgVar2 == null || (zzL = zzcfgVar2.zzL()) == null) {
                    return;
                }
                zzL.zzb();
            }
        }, executor);
    }

    public final zzdgn zze() {
        return this.zza;
    }

    public Set zzf(zzcur zzcurVar) {
        return Collections.singleton(new zzddv(zzcurVar, zzcaf.zzg));
    }

    public Set zzg(zzcur zzcurVar) {
        return Collections.singleton(new zzddv(zzcurVar, zzcaf.zzg));
    }
}
