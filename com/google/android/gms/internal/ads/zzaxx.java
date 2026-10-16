package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaxx extends zzayk {
    private static volatile String zzh;
    private static final Object zzi = new Object();

    public zzaxx(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "d4PN2fwB2P9jxIUN6NPwGCD1vcjTZd510+VTbYWnWivlqPuX4Pd9jb/zoaClHGV2", "B7r3opNSMuM8FMoC6aVwUNpehxdhrcT61rhsqayMJbM=", zzastVar, i, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzz(ExifInterface.LONGITUDE_EAST);
        if (zzh == null) {
            synchronized (zzi) {
                if (zzh == null) {
                    zzh = (String) this.zze.invoke(null, new Object[0]);
                }
            }
        }
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzz(zzh);
        }
    }
}
