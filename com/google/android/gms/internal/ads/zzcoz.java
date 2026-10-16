package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzcoz {
    private final zzcqy zza;
    private final View zzb;
    private final zzfcb zzc;
    private final zzcfg zzd;

    public zzcoz(View view, zzcfg zzcfgVar, zzcqy zzcqyVar, zzfcb zzfcbVar) {
        this.zzb = view;
        this.zzd = zzcfgVar;
        this.zza = zzcqyVar;
        this.zzc = zzfcbVar;
    }

    public final View zza() {
        return this.zzb;
    }

    public final zzcfg zzb() {
        return this.zzd;
    }

    public final zzcqy zzc() {
        return this.zza;
    }

    public zzcxk zzd(Set set) {
        return new zzcxk(set);
    }

    public final zzfcb zze() {
        return this.zzc;
    }
}
