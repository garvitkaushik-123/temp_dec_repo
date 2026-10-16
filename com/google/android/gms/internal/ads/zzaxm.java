package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaxm extends zzayk {
    public zzaxm(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "ptULCqFpkxWHwh0HVZoMpk0Xr91rKWbEROvrSrbrHF8bfcD+J1G9qxssmqT2HcO0", "gABvx04l+Prrr7UIzRlxJTdbXEyGkYLmeTdDcw+INuA=", zzastVar, i, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzast zzastVar = this.zzd;
        zzastVar.zzm(-1L);
        zzastVar.zzl(-1L);
        int[] iArr = (int[]) this.zze.invoke(null, this.zza.zzb());
        synchronized (zzastVar) {
            zzastVar.zzm(iArr[0]);
            zzastVar.zzl(iArr[1]);
            int i = iArr[2];
            if (i != Integer.MIN_VALUE) {
                zzastVar.zzk(i);
            }
        }
    }
}
