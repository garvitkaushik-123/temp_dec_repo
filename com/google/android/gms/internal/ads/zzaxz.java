package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaxz extends zzayk {
    public zzaxz(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "4HRSTLOwWZkuNJXWodn1qJJgWaIIvv19EC2kc5Tc35PPh8H51LV3J7XsfwYf6N8B", "x59qZ2C8s/H9o8A43vx+gBO6K2fFzzXR0hkzA9nrVNs=", zzastVar, i, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        try {
            boolean booleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
            zzast zzastVar = this.zzd;
            int i = 1;
            if (true == booleanValue) {
                i = 2;
            }
            zzastVar.zzac(i);
        } catch (InvocationTargetException unused) {
            this.zzd.zzac(3);
        }
    }
}
