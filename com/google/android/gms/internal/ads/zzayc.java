package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzayc extends zzayk {
    private final StackTraceElement[] zzh;

    public zzayc(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzawxVar, "UtW7g7feJqOHsjIRMP7TbkL8M4VYsmVrsaULCIKJGwvBOELKcxTQZfT6AHg6wl4V", "3s4OpKjyDjUzqtut1o8wCVCKFRdtRePXWRu+sqk/xG8=", zzastVar, i, 45);
        this.zzh = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzh;
        if (stackTraceElementArr != null) {
            zzawo zzawoVar = new zzawo((String) this.zze.invoke(null, stackTraceElementArr));
            zzast zzastVar = this.zzd;
            synchronized (zzastVar) {
                zzastVar.zzD(zzawoVar.zza.longValue());
                if (zzawoVar.zzb.booleanValue()) {
                    zzastVar.zzZ(true != zzawoVar.zzc.booleanValue() ? 2 : 1);
                } else {
                    zzastVar.zzZ(3);
                }
            }
        }
    }
}
