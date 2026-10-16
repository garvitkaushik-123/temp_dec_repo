package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaxy extends zzayk {
    public zzaxy(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "+T/U1hw7+KZ4U7a2mmAOu7BJ15632T6q77fmzX/Xgjcy3uK841Ng+VsVpINIYuXP", "GzjxqsxzxT+aATwD+mE+LGwR24OtaI/aqws6qGNlH18=", zzastVar, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzawd zzawdVar = new zzawd((String) this.zze.invoke(null, this.zza.zzb(), Boolean.valueOf(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdf)).booleanValue())));
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzj(zzawdVar.zza);
            zzastVar.zzA(zzawdVar.zzb);
        }
    }
}
