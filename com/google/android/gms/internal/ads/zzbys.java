package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbys implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzbyt zza;
    private final String zzb;

    public zzbys(zzbyt zzbytVar, String str) {
        Objects.requireNonNull(zzbytVar);
        this.zza = zzbytVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        List<zzbyr> list;
        zzbyt zzbytVar = this.zza;
        synchronized (zzbytVar) {
            list = zzbytVar.zzb;
            for (zzbyr zzbyrVar : list) {
                zzbyt.zzb(zzbyrVar.zza, zzbyrVar.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
