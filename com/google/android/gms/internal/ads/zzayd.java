package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzayd extends zzayk {
    public zzayd(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "ZfusKpZJ8SBLRBp0x6BWNud7pIzhvWIkVd0V0uxTu84aE2cfWFwKn+FMoh4smXgk", "VN0WZ1yYObu9EYHkfC3f48JbFLjOwnUEkH1X8nPNLSU=", zzastVar, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzaws zzawsVar = new zzaws((String) this.zze.invoke(null, new Object[0]));
            zzastVar.zzp(zzawsVar.zza.longValue());
            zzastVar.zzq(zzawsVar.zzb.longValue());
        }
    }
}
