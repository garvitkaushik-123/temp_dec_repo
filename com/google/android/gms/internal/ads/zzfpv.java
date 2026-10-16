package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfpv {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final int zzd;

    public zzfpv(Context context, int i) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfpw.zza(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfpw.zza(dir2, true);
        this.zza = dir2;
        this.zzd = i;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd - 1));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        StringBuilder sb = new StringBuilder("FBAMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    private final String zzf() {
        StringBuilder sb = new StringBuilder("LATMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(zzayp zzaypVar, zzfqb zzfqbVar) {
        boolean z;
        zzays zzb;
        zzays zzb2;
        String zzk = zzaypVar.zzc().zzk();
        byte[] zzA = zzaypVar.zzf().zzA();
        byte[] zzA2 = zzaypVar.zzd().zzA();
        if (!TextUtils.isEmpty(zzk) && zzA2 != null && zzA2.length != 0) {
            File file = this.zza;
            zzfpw.zzd(file);
            file.mkdirs();
            zzfpw.zzc(zzk, file).mkdirs();
            File zzb3 = zzfpw.zzb(zzk, "pcam.jar", file);
            if ((zzA == null || zzA.length <= 0 || zzfpw.zze(zzb3, zzA)) && zzfpw.zze(zzfpw.zzb(zzk, "pcbc", file), zzA2)) {
                File zzb4 = zzfpw.zzb(zzaypVar.zzc().zzk(), "pcam.jar", file);
                if (zzb4.exists() && zzfqbVar != null && !zzfqbVar.zza(zzb4)) {
                    return false;
                }
                String zzk2 = zzaypVar.zzc().zzk();
                if (!TextUtils.isEmpty(zzk2)) {
                    File zzb5 = zzfpw.zzb(zzk2, "pcam.jar", file);
                    File zzb6 = zzfpw.zzb(zzk2, "pcbc", file);
                    File zzb7 = zzfpw.zzb(zzk2, "pcam.jar", zzd());
                    File zzb8 = zzfpw.zzb(zzk2, "pcbc", zzd());
                    if ((!zzb5.exists() || zzb5.renameTo(zzb7)) && zzb6.exists() && zzb6.renameTo(zzb8)) {
                        zzayq zzd = zzays.zzd();
                        zzd.zze(zzaypVar.zzc().zzk());
                        zzd.zza(zzaypVar.zzc().zzj());
                        zzd.zzb(zzaypVar.zzc().zza());
                        zzd.zzd(zzaypVar.zzc().zzc());
                        zzd.zzc(zzaypVar.zzc().zzb());
                        zzays zzaysVar = (zzays) zzd.zzbr();
                        zzays zzb9 = zzb(1);
                        SharedPreferences.Editor edit = this.zzc.edit();
                        if (zzb9 != null && !zzaysVar.zzk().equals(zzb9.zzk())) {
                            edit.putString(zze(), Hex.bytesToStringLowercase(zzb9.zzaV()));
                        }
                        edit.putString(zzf(), Hex.bytesToStringLowercase(zzaysVar.zzaV()));
                        if (edit.commit()) {
                            z = true;
                            HashSet hashSet = new HashSet();
                            zzb = zzb(1);
                            if (zzb != null) {
                                hashSet.add(zzb.zzk());
                            }
                            zzb2 = zzb(2);
                            if (zzb2 != null) {
                                hashSet.add(zzb2.zzk());
                            }
                            for (File file2 : zzd().listFiles()) {
                                String name = file2.getName();
                                if (!hashSet.contains(name)) {
                                    zzfpw.zzd(zzfpw.zzc(name, zzd()));
                                }
                            }
                            return z;
                        }
                    }
                }
                z = false;
                HashSet hashSet2 = new HashSet();
                zzb = zzb(1);
                if (zzb != null) {
                }
                zzb2 = zzb(2);
                if (zzb2 != null) {
                }
                while (r4 < r1) {
                }
                return z;
            }
        }
        return false;
    }

    final zzays zzb(int i) {
        String string = i == 1 ? this.zzc.getString(zzf(), null) : this.zzc.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] stringToBytes = Hex.stringToBytes(string);
            zzgxz zzgxzVar = zzgxz.zzb;
            zzays zzh = zzays.zzh(zzgxz.zzv(stringToBytes, 0, stringToBytes.length));
            String zzk = zzh.zzk();
            File zzb = zzfpw.zzb(zzk, "pcam.jar", zzd());
            if (!zzb.exists()) {
                zzb = zzfpw.zzb(zzk, "pcam", zzd());
            }
            File zzb2 = zzfpw.zzb(zzk, "pcbc", zzd());
            if (zzb.exists()) {
                if (zzb2.exists()) {
                    return zzh;
                }
            }
        } catch (zzgzw unused) {
        }
        return null;
    }

    public final zzfpu zzc(int i) {
        zzays zzb = zzb(1);
        if (zzb == null) {
            return null;
        }
        String zzk = zzb.zzk();
        File zzb2 = zzfpw.zzb(zzk, "pcam.jar", zzd());
        if (!zzb2.exists()) {
            zzb2 = zzfpw.zzb(zzk, "pcam", zzd());
        }
        return new zzfpu(zzb, zzb2, zzfpw.zzb(zzk, "pcbc", zzd()), zzfpw.zzb(zzk, "pcopt", zzd()));
    }
}
