package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzca implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzcb zza;
    private final String zzb;

    public zzca(zzcb zzcbVar, String str) {
        Objects.requireNonNull(zzcbVar);
        this.zza = zzcbVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        List<zzbz> list;
        zzcb zzcbVar = this.zza;
        synchronized (zzcbVar) {
            list = zzcbVar.zzb;
            for (zzbz zzbzVar : list) {
                String str2 = this.zzb;
                Map map = zzbzVar.zza;
                if (map.containsKey(str2) && ((Set) map.get(str2)).contains(str)) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzi().zzE(false);
                }
            }
        }
    }
}
