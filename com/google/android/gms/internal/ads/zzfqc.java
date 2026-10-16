package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfqc {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zzfpj zze;
    private boolean zzf;

    public zzfqc(Context context, int i, zzfpj zzfpjVar, boolean z) {
        this.zzf = false;
        this.zzb = context;
        this.zzd = Integer.toString(i - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zzfpjVar;
        this.zzf = z;
    }

    private final File zze(String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(zzayp zzaypVar) {
        zzayq zzd = zzays.zzd();
        zzd.zze(zzaypVar.zzc().zzk());
        zzd.zza(zzaypVar.zzc().zzj());
        zzd.zzb(zzaypVar.zzc().zza());
        zzd.zzd(zzaypVar.zzc().zzc());
        zzd.zzc(zzaypVar.zzc().zzb());
        return Hex.bytesToStringLowercase(((zzays) zzd.zzbr()).zzaV());
    }

    private final String zzg() {
        return "FBAMTD".concat(String.valueOf(this.zzd));
    }

    private final String zzh() {
        return "LATMTD".concat(String.valueOf(this.zzd));
    }

    private final void zzi(int i, long j) {
        this.zze.zza(i, j);
    }

    private final void zzj(int i, long j, String str) {
        this.zze.zzb(i, j, str);
    }

    private final zzays zzk(int i) {
        String string = i == 1 ? this.zzc.getString(zzh(), null) : this.zzc.getString(zzg(), null);
        if (string == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            byte[] stringToBytes = Hex.stringToBytes(string);
            zzgxz zzgxzVar = zzgxz.zzb;
            return zzays.zzi(zzgxz.zzv(stringToBytes, 0, stringToBytes.length), this.zzf ? zzgyr.zza() : zzgyr.zzb());
        } catch (zzgzw unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, currentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, currentTimeMillis);
            return null;
        }
    }

    public final boolean zza(zzayp zzaypVar) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            if (!zzfpw.zze(new File(zze(zzaypVar.zzc().zzk()), "pcbc"), zzaypVar.zzd().zzA())) {
                zzi(4020, currentTimeMillis);
                return false;
            }
            String zzf = zzf(zzaypVar);
            SharedPreferences.Editor edit = this.zzc.edit();
            edit.putString(zzh(), zzf);
            boolean commit = edit.commit();
            if (commit) {
                zzi(5015, currentTimeMillis);
            } else {
                zzi(4021, currentTimeMillis);
            }
            return commit;
        }
    }

    public final boolean zzb(zzayp zzaypVar, zzfqb zzfqbVar) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzays zzk = zzk(1);
            String zzk2 = zzaypVar.zzc().zzk();
            if (zzk != null && zzk.zzk().equals(zzk2)) {
                zzi(4014, currentTimeMillis);
                return false;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            File zze = zze(zzk2);
            if (zze.exists()) {
                zzj(4023, currentTimeMillis2, "d:" + (true != zze.isDirectory() ? "0" : "1") + ",f:" + (true != zze.isFile() ? "0" : "1"));
                zzi(4015, currentTimeMillis2);
            } else if (!zze.mkdirs()) {
                zzj(4024, currentTimeMillis2, "cw:".concat(true != zze.canWrite() ? "0" : "1"));
                zzi(4015, currentTimeMillis2);
                return false;
            }
            File zze2 = zze(zzk2);
            File file = new File(zze2, "pcam.jar");
            File file2 = new File(zze2, "pcbc");
            if (!zzfpw.zze(file, zzaypVar.zzf().zzA())) {
                zzi(4016, currentTimeMillis);
                return false;
            }
            if (!zzfpw.zze(file2, zzaypVar.zzd().zzA())) {
                zzi(4017, currentTimeMillis);
                return false;
            }
            if (zzfqbVar != null && !zzfqbVar.zza(file)) {
                zzi(4018, currentTimeMillis);
                zzfpw.zzd(zze2);
                return false;
            }
            String zzf = zzf(zzaypVar);
            long currentTimeMillis3 = System.currentTimeMillis();
            SharedPreferences sharedPreferences = this.zzc;
            String string = sharedPreferences.getString(zzh(), null);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(zzh(), zzf);
            if (string != null) {
                edit.putString(zzg(), string);
            }
            if (!edit.commit()) {
                zzi(4019, currentTimeMillis3);
                return false;
            }
            HashSet hashSet = new HashSet();
            zzays zzk3 = zzk(1);
            if (zzk3 != null) {
                hashSet.add(zzk3.zzk());
            }
            zzays zzk4 = zzk(2);
            if (zzk4 != null) {
                hashSet.add(zzk4.zzk());
            }
            for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                if (!hashSet.contains(file3.getName())) {
                    zzfpw.zzd(file3);
                }
            }
            zzi(5014, currentTimeMillis);
            return true;
        }
    }

    public final zzfpu zzc(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzays zzk = zzk(1);
            if (zzk == null) {
                zzi(4022, currentTimeMillis);
                return null;
            }
            File zze = zze(zzk.zzk());
            File file = new File(zze, "pcam.jar");
            if (!file.exists()) {
                file = new File(zze, "pcam");
            }
            File file2 = new File(zze, "pcbc");
            File file3 = new File(zze, "pcopt");
            zzi(5016, currentTimeMillis);
            return new zzfpu(zzk, file, file2, file3);
        }
    }

    public final boolean zzd(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzays zzk = zzk(1);
            if (zzk == null) {
                zzi(4025, currentTimeMillis);
                return false;
            }
            File zze = zze(zzk.zzk());
            if (!new File(zze, "pcam.jar").exists()) {
                zzi(4026, currentTimeMillis);
                return false;
            }
            if (new File(zze, "pcbc").exists()) {
                zzi(5019, currentTimeMillis);
                return true;
            }
            zzi(4027, currentTimeMillis);
            return false;
        }
    }
}
