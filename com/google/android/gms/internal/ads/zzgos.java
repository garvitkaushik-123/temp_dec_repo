package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgos {
    private final Map zza;
    private final Map zzb;

    private zzgos() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzgos zza(zzgoq zzgoqVar) throws GeneralSecurityException {
        if (zzgoqVar == null) {
            throw new NullPointerException("primitive constructor must be non-null");
        }
        zzgot zzgotVar = new zzgot(zzgoqVar.zzc(), zzgoqVar.zzd(), null);
        Map map = this.zza;
        if (!map.containsKey(zzgotVar)) {
            map.put(zzgotVar, zzgoqVar);
            return this;
        }
        zzgoq zzgoqVar2 = (zzgoq) map.get(zzgotVar);
        if (zzgoqVar2.equals(zzgoqVar) && zzgoqVar.equals(zzgoqVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzgotVar.toString()));
    }

    public final zzgos zzb(zzgow zzgowVar) throws GeneralSecurityException {
        Map map = this.zzb;
        Class zzb = zzgowVar.zzb();
        if (!map.containsKey(zzb)) {
            map.put(zzb, zzgowVar);
            return this;
        }
        zzgow zzgowVar2 = (zzgow) map.get(zzb);
        if (zzgowVar2.equals(zzgowVar) && zzgowVar.equals(zzgowVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb.toString()));
    }

    public final zzgov zzc() {
        return new zzgov(this, null);
    }

    /* synthetic */ zzgos(zzgou zzgouVar) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    /* synthetic */ zzgos(zzgov zzgovVar, zzgou zzgouVar) {
        Map map;
        Map map2;
        map = zzgovVar.zza;
        this.zza = new HashMap(map);
        map2 = zzgovVar.zzb;
        this.zzb = new HashMap(map2);
    }
}
