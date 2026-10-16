package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzalp {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzfyv zze = zzfyv.zzp("auto", "none");
    private static final zzfyv zzf = zzfyv.zzq("dot", "sesame", "circle");
    private static final zzfyv zzg = zzfyv.zzp("filled", "open");
    private static final zzfyv zzh = zzfyv.zzq("after", "before", "outside");
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzalp(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzalp zza(String str) {
        boolean z;
        if (str == null) {
            return null;
        }
        String zza = zzfuv.zza(str.trim());
        if (zza.isEmpty()) {
            return null;
        }
        zzfyv zzm = zzfyv.zzm(TextUtils.split(zza, zzd));
        String str2 = (String) zzfyw.zza(zzgas.zzb(zzh, zzm), "outside");
        int hashCode = str2.hashCode();
        int i = -1;
        int i2 = 0;
        if (hashCode != -1106037339) {
            if (hashCode == 92734940 && str2.equals("after")) {
                z = false;
            }
            z = -1;
        } else {
            if (str2.equals("outside")) {
                z = true;
            }
            z = -1;
        }
        int i3 = z ? !z ? 1 : -2 : 2;
        zzgaq zzb = zzgas.zzb(zze, zzm);
        if (zzb.isEmpty()) {
            zzgaq zzb2 = zzgas.zzb(zzg, zzm);
            zzgaq zzb3 = zzgas.zzb(zzf, zzm);
            if (!zzb2.isEmpty() || !zzb3.isEmpty()) {
                String str3 = (String) zzfyw.zza(zzb2, "filled");
                int i4 = (str3.hashCode() == 3417674 && str3.equals("open")) ? 2 : 1;
                String str4 = (String) zzfyw.zza(zzb3, "circle");
                int hashCode2 = str4.hashCode();
                if (hashCode2 != -905816648) {
                    if (hashCode2 == 99657 && str4.equals("dot")) {
                        i = 0;
                    }
                } else if (str4.equals("sesame")) {
                    i = 1;
                }
                if (i == 0) {
                    i = 2;
                } else if (i != 1) {
                    i2 = i4;
                    i = 1;
                } else {
                    i = 3;
                }
                i2 = i4;
            }
        } else {
            String str5 = (String) zzb.iterator().next();
            if (str5.hashCode() == 3387192 && str5.equals("none")) {
                i = 0;
            }
        }
        return new zzalp(i, i2, i3);
    }
}
