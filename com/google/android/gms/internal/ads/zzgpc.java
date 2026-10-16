package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgpc {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzgpc() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgpc zza(zzgmt zzgmtVar) throws GeneralSecurityException {
        zzgpd zzgpdVar = new zzgpd(zzgmtVar.zzd(), zzgmtVar.zzc(), null);
        Map map = this.zzb;
        if (!map.containsKey(zzgpdVar)) {
            map.put(zzgpdVar, zzgmtVar);
            return this;
        }
        zzgmt zzgmtVar2 = (zzgmt) map.get(zzgpdVar);
        if (zzgmtVar2.equals(zzgmtVar) && zzgmtVar.equals(zzgmtVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgpdVar.toString()));
    }

    public final zzgpc zzb(zzgmx zzgmxVar) throws GeneralSecurityException {
        zzgpe zzgpeVar = new zzgpe(zzgmxVar.zzc(), zzgmxVar.zzd(), null);
        Map map = this.zza;
        if (!map.containsKey(zzgpeVar)) {
            map.put(zzgpeVar, zzgmxVar);
            return this;
        }
        zzgmx zzgmxVar2 = (zzgmx) map.get(zzgpeVar);
        if (zzgmxVar2.equals(zzgmxVar) && zzgmxVar.equals(zzgmxVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgpeVar.toString()));
    }

    public final zzgpc zzc(zzgod zzgodVar) throws GeneralSecurityException {
        zzgpd zzgpdVar = new zzgpd(zzgodVar.zzd(), zzgodVar.zzc(), null);
        Map map = this.zzd;
        if (!map.containsKey(zzgpdVar)) {
            map.put(zzgpdVar, zzgodVar);
            return this;
        }
        zzgod zzgodVar2 = (zzgod) map.get(zzgpdVar);
        if (zzgodVar2.equals(zzgodVar) && zzgodVar.equals(zzgodVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgpdVar.toString()));
    }

    public final zzgpc zzd(zzgoh zzgohVar) throws GeneralSecurityException {
        zzgpe zzgpeVar = new zzgpe(zzgohVar.zzc(), zzgohVar.zzd(), null);
        Map map = this.zzc;
        if (!map.containsKey(zzgpeVar)) {
            map.put(zzgpeVar, zzgohVar);
            return this;
        }
        zzgoh zzgohVar2 = (zzgoh) map.get(zzgpeVar);
        if (zzgohVar2.equals(zzgohVar) && zzgohVar.equals(zzgohVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgpeVar.toString()));
    }

    public zzgpc(zzgpg zzgpgVar) {
        Map map;
        Map map2;
        Map map3;
        Map map4;
        map = zzgpgVar.zza;
        this.zza = new HashMap(map);
        map2 = zzgpgVar.zzb;
        this.zzb = new HashMap(map2);
        map3 = zzgpgVar.zzc;
        this.zzc = new HashMap(map3);
        map4 = zzgpgVar.zzd;
        this.zzd = new HashMap(map4);
    }
}
