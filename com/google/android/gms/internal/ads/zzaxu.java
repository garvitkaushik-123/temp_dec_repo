package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaxu extends zzayk {
    private final zzawp zzh;

    public zzaxu(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, zzawp zzawpVar) {
        super(zzawxVar, "LLos9e8Ql/sv7oIXEM/FCVf2w4qxksYVSJjnFOiKAZfJ/fOB+3TAGyZw1OkiJRsU", "lmzfMnrRinUoapvwdylnImZxEAh1S0BzbHZ4/bdyts0=", zzastVar, i, 94);
        this.zzh = zzawpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int intValue = ((Integer) this.zze.invoke(null, this.zzh.zza())).intValue();
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzab(zzatf.zza(intValue));
        }
    }
}
