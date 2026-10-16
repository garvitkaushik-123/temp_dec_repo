package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzavo {
    protected volatile Boolean zzb;
    private final zzawx zze;
    private static final ConditionVariable zzc = new ConditionVariable();
    protected static volatile zzfqi zza = null;
    private static volatile Random zzd = null;

    public zzavo(zzawx zzawxVar) {
        this.zze = zzawxVar;
        zzawxVar.zzj().execute(new zzavn(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            if (zzd == null) {
                synchronized (zzavo.class) {
                    if (zzd == null) {
                        zzd = new Random();
                    }
                }
            }
            return zzd.nextInt();
        }
    }

    public final void zzc(int i, int i2, long j, String str, Exception exc) {
        try {
            zzc.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzarz zza2 = zzasd.zza();
            zza2.zza(this.zze.zza.getPackageName());
            zza2.zze(j);
            if (str != null) {
                zza2.zzb(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zza2.zzf(stringWriter.toString());
                zza2.zzd(exc.getClass().getName());
            }
            zzfqg zza3 = zza.zza(((zzasd) zza2.zzbr()).zzaV());
            zza3.zza(i);
            if (i2 != -1) {
                zza3.zzb(i2);
            }
            zza3.zzc();
        } catch (Exception unused) {
        }
    }
}
