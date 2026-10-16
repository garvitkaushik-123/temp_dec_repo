package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzeha {
    final String zza;
    final String zzb;
    int zzc;
    long zzd;
    final Integer zze;

    zzeha(String str, String str2, int i, long j, Integer num) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = j;
        this.zze = num;
    }

    public final String toString() {
        Integer num;
        String str = this.zza + "." + this.zzc + "." + this.zzd;
        String str2 = this.zzb;
        if (!TextUtils.isEmpty(str2)) {
            str = str + "." + str2;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbO)).booleanValue() || (num = this.zze) == null || TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "." + num;
    }
}
