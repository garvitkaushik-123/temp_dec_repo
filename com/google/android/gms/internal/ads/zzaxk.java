package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaxk extends zzayk {
    private static final zzayl zzh = new zzayl();
    private final Context zzi;

    public zzaxk(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, Context context) {
        super(zzawxVar, "agDdf5wrmtJ0cP5XVK0JCsJ4BViR17o/n9P6hmH0muvYwmpx2DZ552/tAJvOo6qR", "48yXjRp5G93PEoVZx8WBMAeqgOhil0yQSUdmW98nZyI=", zzastVar, i, 29);
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzn(ExifInterface.LONGITUDE_EAST);
        Context context = this.zzi;
        AtomicReference zza = zzh.zza(context.getPackageName());
        if (zza.get() == null) {
            synchronized (zza) {
                if (zza.get() == null) {
                    zza.set((String) this.zze.invoke(null, context));
                }
            }
        }
        String str = (String) zza.get();
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzn(zzaul.zza(str.getBytes(), true));
        }
    }
}
