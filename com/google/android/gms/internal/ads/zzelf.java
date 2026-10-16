package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzelf implements zzeln {
    final /* synthetic */ zzelg zza;

    zzelf(zzelg zzelgVar) {
        Objects.requireNonNull(zzelgVar);
        this.zza = zzelgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        zzelg zzelgVar = this.zza;
        synchronized (zzelgVar) {
            zzelgVar.zzj = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdfb zzdfbVar;
        zzelg zzelgVar = this.zza;
        zzdfb zzdfbVar2 = (zzdfb) obj;
        synchronized (zzelgVar) {
            zzelgVar.zzj = zzdfbVar2;
            zzdfbVar = zzelgVar.zzj;
            zzdfbVar.zzk();
        }
    }
}
