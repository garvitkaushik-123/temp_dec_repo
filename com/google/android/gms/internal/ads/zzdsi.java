package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdsi {
    final /* synthetic */ zzdsj zza;
    private final Map zzb;

    zzdsi(zzdsj zzdsjVar) {
        Objects.requireNonNull(zzdsjVar);
        this.zza = zzdsjVar;
        this.zzb = new ConcurrentHashMap();
    }

    static /* bridge */ /* synthetic */ zzdsi zza(zzdsi zzdsiVar) {
        Map map;
        zzdsj zzdsjVar = zzdsiVar.zza;
        Map map2 = zzdsiVar.zzb;
        map = zzdsjVar.zzc;
        map2.putAll(map);
        return zzdsiVar;
    }

    public static /* synthetic */ void zzf(zzdsi zzdsiVar) {
        zzdso zzdsoVar;
        zzdsoVar = zzdsiVar.zza.zza;
        zzdsoVar.zzf(zzdsiVar.zzb);
    }

    public static /* synthetic */ void zzg(zzdsi zzdsiVar) {
        zzdso zzdsoVar;
        zzdsoVar = zzdsiVar.zza.zza;
        zzdsoVar.zzg(zzdsiVar.zzb);
    }

    public static /* synthetic */ void zzh(zzdsi zzdsiVar) {
        zzdso zzdsoVar;
        zzdsoVar = zzdsiVar.zza.zza;
        zzdsoVar.zze(zzdsiVar.zzb);
    }

    public final zzdsi zzb(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdsi zzc(zzfca zzfcaVar) {
        zzb("aai", zzfcaVar.zzw);
        zzb("request_id", zzfcaVar.zzan);
        zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfca.zza(zzfcaVar.zzb));
        return this;
    }

    public final zzdsi zzd(zzfcd zzfcdVar) {
        zzb("gqi", zzfcdVar.zzb);
        return this;
    }

    public final String zze() {
        zzdso zzdsoVar;
        zzdsoVar = this.zza.zza;
        return zzdsoVar.zzb(this.zzb);
    }

    public final void zzi() {
        Executor executor;
        executor = this.zza.zzb;
        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsh
            @Override // java.lang.Runnable
            public final void run() {
                zzdsi.zzh(zzdsi.this);
            }
        });
    }

    public final void zzj() {
        Executor executor;
        executor = this.zza.zzb;
        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsf
            @Override // java.lang.Runnable
            public final void run() {
                zzdsi.zzg(zzdsi.this);
            }
        });
    }

    public final void zzk() {
        Executor executor;
        executor = this.zza.zzb;
        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsg
            @Override // java.lang.Runnable
            public final void run() {
                zzdsi.zzf(zzdsi.this);
            }
        });
    }
}
