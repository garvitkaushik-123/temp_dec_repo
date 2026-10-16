package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgnq {
    private static final zzgnq zza = new zzgnq();
    private final Map zzb = new HashMap();

    public static zzgnq zza() {
        return zza;
    }

    public final synchronized void zzb(zzgnp zzgnpVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzb;
        zzgnp zzgnpVar2 = (zzgnp) map.get(cls);
        if (zzgnpVar2 != null && !zzgnpVar2.equals(zzgnpVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class already inserted");
        }
        map.put(cls, zzgnpVar);
    }
}
