package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzayg extends zzayk {
    public zzayg(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "1BnW1+pN8ACAA5SCwHeu4aDyUa+GdAsZQaTQjOE/fWA7hyCouT0ju5bDmhkUNXUI", "kp4jwXczzGPw0lGC8OB8RleYASbnnNEZzgNaMBT0Bfw=", zzastVar, i, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzast zzastVar = this.zzd;
        zzastVar.zzad(3);
        boolean booleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
        synchronized (zzastVar) {
            if (booleanValue) {
                zzastVar.zzad(2);
            } else {
                zzastVar.zzad(1);
            }
        }
    }
}
