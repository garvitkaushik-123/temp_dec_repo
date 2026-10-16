package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.internal.ads.zzbde;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzcb {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final Context zzc;

    zzcb(Context context) {
        this.zzc = context;
    }

    final synchronized void zzb(String str) {
        Map map = this.zza;
        if (map.containsKey(str)) {
            return;
        }
        SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.zzc) : this.zzc.getSharedPreferences(str, 0);
        zzca zzcaVar = new zzca(this, str);
        map.put(str, zzcaVar);
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzcaVar);
    }

    public final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkQ)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzr();
            Map zzw = zzs.zzw((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkV));
            Iterator it = zzw.keySet().iterator();
            while (it.hasNext()) {
                zzb((String) it.next());
            }
            zzd(new zzbz(zzw));
        }
    }

    final synchronized void zzd(zzbz zzbzVar) {
        this.zzb.add(zzbzVar);
    }
}
