package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzchh {
    private final VersionInfoParcel zza;
    private final Context zzb;
    private final long zzc;
    private final WeakReference zzd;

    /* synthetic */ zzchh(zzchf zzchfVar, zzchg zzchgVar) {
        VersionInfoParcel versionInfoParcel;
        Context context;
        WeakReference weakReference;
        long j;
        versionInfoParcel = zzchfVar.zza;
        this.zza = versionInfoParcel;
        context = zzchfVar.zzb;
        this.zzb = context;
        weakReference = zzchfVar.zzd;
        this.zzd = weakReference;
        j = zzchfVar.zzc;
        this.zzc = j;
    }

    final long zza() {
        return this.zzc;
    }

    final Context zzb() {
        return this.zzb;
    }

    public final com.google.android.gms.ads.internal.zzk zzc() {
        return new com.google.android.gms.ads.internal.zzk(this.zzb, this.zza);
    }

    final zzbfx zzd() {
        return new zzbfx(this.zzb);
    }

    final VersionInfoParcel zze() {
        return this.zza;
    }

    final String zzf() {
        return com.google.android.gms.ads.internal.zzv.zzr().zzc(this.zzb, this.zza.afmaVersion);
    }

    final WeakReference zzg() {
        return this.zzd;
    }
}
