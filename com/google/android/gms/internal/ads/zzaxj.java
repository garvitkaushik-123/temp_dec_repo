package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaxj extends zzayk {
    public zzaxj(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "WQkp0526ddrUi1BRkagos9QKSJQ1uugrJcxnlXdGVtysNEwcyhf7H4AuLi1Daa/J", "bIxRlixcWzGpKi+RzORPGFA/CCK1ebxNEgd5yxb9Upc=", zzastVar, i, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzast zzastVar = this.zzd;
        zzastVar.zzY(3);
        try {
            int i = 1;
            if (true == ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue()) {
                i = 2;
            }
            zzastVar.zzY(i);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
