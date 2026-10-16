package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcvh {
    private final Context zza;
    private final zzfcw zzb;
    private final Bundle zzc;
    private final zzfco zzd;
    private final zzcuy zze;
    private final zzedr zzf;
    private final int zzg;

    /* synthetic */ zzcvh(zzcvf zzcvfVar, zzcvg zzcvgVar) {
        Context context;
        zzfcw zzfcwVar;
        Bundle bundle;
        zzfco zzfcoVar;
        zzcuy zzcuyVar;
        zzedr zzedrVar;
        int i;
        context = zzcvfVar.zza;
        this.zza = context;
        zzfcwVar = zzcvfVar.zzb;
        this.zzb = zzfcwVar;
        bundle = zzcvfVar.zzc;
        this.zzc = bundle;
        zzfcoVar = zzcvfVar.zzd;
        this.zzd = zzfcoVar;
        zzcuyVar = zzcvfVar.zze;
        this.zze = zzcuyVar;
        zzedrVar = zzcvfVar.zzf;
        this.zzf = zzedrVar;
        i = zzcvfVar.zzg;
        this.zzg = i;
    }

    final int zza() {
        return this.zzg;
    }

    final Context zzb(Context context) {
        return this.zza;
    }

    final Bundle zzc() {
        return this.zzc;
    }

    final zzcuy zzd() {
        return this.zze;
    }

    final zzcvf zze() {
        zzcvf zzcvfVar = new zzcvf();
        zzcvfVar.zzf(this.zza);
        zzcvfVar.zzk(this.zzb);
        zzcvfVar.zzg(this.zzc);
        zzcvfVar.zzh(this.zze);
        zzcvfVar.zze(this.zzf);
        return zzcvfVar;
    }

    final zzedr zzf(String str) {
        zzedr zzedrVar = this.zzf;
        return zzedrVar != null ? zzedrVar : new zzedr(str);
    }

    final zzfco zzg() {
        return this.zzd;
    }

    final zzfcw zzh() {
        return this.zzb;
    }
}
