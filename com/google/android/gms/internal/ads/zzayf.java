package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzayf extends zzayk {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzayf(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "AkswGwusnlvibekdTn6rp1TLruqBIpT26qUqw6ERX2GI+0q3NNodYWGNobvk/KA0", "+ySS/EYovSzthax5b5cNVBSw7OeHS3QqC5FfLg20T6g=", zzastVar, i, 33);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzh == null) {
            synchronized (zzi) {
                if (zzh == null) {
                    zzh = (Long) this.zze.invoke(null, new Object[0]);
                }
            }
        }
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzT(zzh.longValue());
        }
    }
}
