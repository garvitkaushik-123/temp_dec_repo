package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzalm {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzalm(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    public static zzalm zzb(String str, zzalk zzalkVar) {
        zzalm zzalmVar;
        int i;
        int parseInt;
        zzdd.zzd(str.startsWith("Style:"));
        String[] split = TextUtils.split(str.substring(6), ",");
        int length = split.length;
        int i2 = zzalkVar.zzk;
        if (length != i2) {
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(length), str};
            String str2 = zzex.zza;
            zzea.zzf("SsaStyle", String.format(Locale.US, "Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", objArr));
            return null;
        }
        try {
            String trim = split[zzalkVar.zza].trim();
            int i3 = zzalkVar.zzb;
            int zzd = i3 != -1 ? zzd(split[i3].trim()) : -1;
            int i4 = zzalkVar.zzc;
            Integer zzc = i4 != -1 ? zzc(split[i4].trim()) : null;
            int i5 = zzalkVar.zzd;
            Integer zzc2 = i5 != -1 ? zzc(split[i5].trim()) : null;
            int i6 = zzalkVar.zze;
            float f = -3.4028235E38f;
            try {
                if (i6 != -1) {
                    String trim2 = split[i6].trim();
                    try {
                        f = Float.parseFloat(trim2);
                    } catch (NumberFormatException e) {
                        zzalmVar = null;
                        zzea.zzg("SsaStyle", "Failed to parse font size: '" + trim2 + "'", e);
                    }
                }
                zzalmVar = null;
                int i7 = zzalkVar.zzf;
                boolean z = i7 != -1 && zze(split[i7].trim());
                int i8 = zzalkVar.zzg;
                boolean z2 = i8 != -1 && zze(split[i8].trim());
                int i9 = zzalkVar.zzh;
                boolean z3 = i9 != -1 && zze(split[i9].trim());
                int i10 = zzalkVar.zzi;
                boolean z4 = i10 != -1 && zze(split[i10].trim());
                int i11 = zzalkVar.zzj;
                if (i11 != -1) {
                    String trim3 = split[i11].trim();
                    try {
                        parseInt = Integer.parseInt(trim3.trim());
                    } catch (NumberFormatException unused) {
                    }
                    if (parseInt == 1 || parseInt == 3) {
                        i = parseInt;
                        return new zzalm(trim, zzd, zzc, zzc2, f, z, z2, z3, z4, i);
                    }
                    zzea.zzf("SsaStyle", "Ignoring unknown BorderStyle: ".concat(String.valueOf(trim3)));
                }
                i = -1;
                return new zzalm(trim, zzd, zzc, zzc2, f, z, z2, z3, z4, i);
            } catch (RuntimeException e2) {
                e = e2;
                zzea.zzg("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e);
                return zzalmVar;
            }
        } catch (RuntimeException e3) {
            e = e3;
            zzalmVar = null;
        }
    }

    public static Integer zzc(String str) {
        try {
            long parseLong = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzdd.zzd(parseLong <= 4294967295L);
            return Integer.valueOf(Color.argb(zzgbt.zzb(((parseLong >> 24) & 255) ^ 255), zzgbt.zzb(parseLong & 255), zzgbt.zzb((parseLong >> 8) & 255), zzgbt.zzb((parseLong >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            zzea.zzg("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(str.trim());
        } catch (NumberFormatException unused) {
        }
        switch (parseInt) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return parseInt;
            default:
                zzea.zzf("SsaStyle", "Ignoring unknown alignment: ".concat(String.valueOf(str)));
                return -1;
        }
    }

    private static boolean zze(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e) {
            zzea.zzg("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }
}
