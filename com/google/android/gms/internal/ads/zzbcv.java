package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzbcv {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    /* synthetic */ zzbcv(int i, String str, Object obj, Object obj2, zzbcu zzbcuVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        com.google.android.gms.ads.internal.client.zzbd.zza().zzd(this);
    }

    public static zzbcv zzf(int i, String str, float f, float f2) {
        return new zzbcs(1, str, Float.valueOf(f), Float.valueOf(f2));
    }

    public static zzbcv zzg(int i, String str, int i2, int i3) {
        return new zzbcq(1, str, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static zzbcv zzh(int i, String str, long j, long j2) {
        return new zzbcr(1, str, Long.valueOf(j), Long.valueOf(j2));
    }

    public static zzbcv zzi(int i, String str) {
        zzbct zzbctVar = new zzbct(1, "gads:sdk_core_constants:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzbd.zza().zzc(zzbctVar);
        return zzbctVar;
    }

    public static zzbcv zzj(int i, String str) {
        zzbct zzbctVar = new zzbct(1, "gads:sdk_core_constants_service:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzbd.zza().zze(zzbctVar);
        return zzbctVar;
    }

    protected abstract Object zza(JSONObject jSONObject);

    public abstract Object zzb(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzc(SharedPreferences sharedPreferences);

    public abstract void zzd(SharedPreferences.Editor editor, Object obj);

    public final int zze() {
        return this.zza;
    }

    public final Object zzk() {
        return com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(this);
    }

    public final Object zzl() {
        return com.google.android.gms.ads.internal.client.zzbd.zzc().zzf() ? this.zzd : this.zzc;
    }

    public final String zzm() {
        return this.zzb;
    }
}
