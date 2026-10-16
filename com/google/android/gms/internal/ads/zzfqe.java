package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfqe {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfqf zzc;
    private final zzfoi zzd;
    private final zzfod zze;
    private zzfpt zzf;
    private final Object zzg = new Object();

    public zzfqe(Context context, zzfqf zzfqfVar, zzfoi zzfoiVar, zzfod zzfodVar, boolean z) {
        this.zzb = context;
        this.zzc = zzfqfVar;
        this.zzd = zzfoiVar;
        this.zze = zzfodVar;
    }

    private final synchronized Class zzd(zzfpu zzfpuVar) throws zzfqd {
        String zzk = zzfpuVar.zza().zzk();
        HashMap hashMap = zza;
        Class cls = (Class) hashMap.get(zzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (!this.zze.zza(zzfpuVar.zzc())) {
                throw new zzfqd(2026, "VM did not pass signature verification");
            }
            try {
                File zzb = zzfpuVar.zzb();
                if (!zzb.exists()) {
                    zzb.mkdirs();
                }
                Class loadClass = new DexClassLoader(zzfpuVar.zzc().getAbsolutePath(), zzb.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                hashMap.put(zzk, loadClass);
                return loadClass;
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                throw new zzfqd(2008, e);
            }
        } catch (GeneralSecurityException e2) {
            throw new zzfqd(2026, e2);
        }
    }

    public final zzfol zza() {
        zzfpt zzfptVar;
        synchronized (this.zzg) {
            zzfptVar = this.zzf;
        }
        return zzfptVar;
    }

    public final zzfpu zzb() {
        synchronized (this.zzg) {
            zzfpt zzfptVar = this.zzf;
            if (zzfptVar == null) {
                return null;
            }
            return zzfptVar.zzf();
        }
    }

    public final boolean zzc(zzfpu zzfpuVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfpt zzfptVar = new zzfpt(zzd(zzfpuVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzfpuVar.zze(), null, new Bundle(), 2), zzfpuVar, this.zzc, this.zzd, false);
                if (!zzfptVar.zzh()) {
                    throw new zzfqd(4000, "init failed");
                }
                int zze = zzfptVar.zze();
                if (zze != 0) {
                    throw new zzfqd(4001, "ci: " + zze);
                }
                synchronized (this.zzg) {
                    zzfpt zzfptVar2 = this.zzf;
                    if (zzfptVar2 != null) {
                        try {
                            zzfptVar2.zzg();
                        } catch (zzfqd e) {
                            this.zzd.zzc(e.zza(), -1L, e);
                        }
                    }
                    this.zzf = zzfptVar;
                }
                this.zzd.zzd(3000, System.currentTimeMillis() - currentTimeMillis);
                return true;
            } catch (Exception e2) {
                throw new zzfqd(2004, e2);
            }
        } catch (zzfqd e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - currentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - currentTimeMillis, e4);
            return false;
        }
    }
}
