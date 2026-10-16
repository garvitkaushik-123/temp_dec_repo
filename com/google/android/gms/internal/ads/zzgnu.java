package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgnu {
    private static final zzgnu zza = new zzgnu();
    private final Map zzb = new HashMap();

    zzgnu() {
    }

    public static zzgnu zzb() {
        return zza;
    }

    public final synchronized zzgfm zza(String str) throws GeneralSecurityException {
        Map map;
        map = this.zzb;
        if (!map.containsKey("AES128_GCM")) {
            throw new GeneralSecurityException("Name AES128_GCM does not exist");
        }
        return (zzgfm) map.get("AES128_GCM");
    }

    public final synchronized void zzc(String str, zzgfm zzgfmVar) throws GeneralSecurityException {
        Map map = this.zzb;
        if (!map.containsKey(str)) {
            map.put(str, zzgfmVar);
            return;
        }
        if (((zzgfm) map.get(str)).equals(zzgfmVar)) {
            return;
        }
        throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + String.valueOf(map.get(str)) + "), cannot insert " + String.valueOf(zzgfmVar));
    }

    public final synchronized void zzd(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zzc((String) entry.getKey(), (zzgfm) entry.getValue());
        }
    }
}
