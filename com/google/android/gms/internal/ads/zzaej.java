package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaej {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            String str2 = zzex.zza;
            String str3 = group;
            int parseInt = Integer.parseInt(group, 16);
            String group2 = matcher.group(2);
            String str4 = group2;
            int parseInt2 = Integer.parseInt(group2, 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.zza = parseInt;
            this.zzb = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }

    public final boolean zzb(zzav zzavVar) {
        for (int i = 0; i < zzavVar.zza(); i++) {
            zzau zzb = zzavVar.zzb(i);
            if (zzb instanceof zzaha) {
                zzaha zzahaVar = (zzaha) zzb;
                if ("iTunSMPB".equals(zzahaVar.zzb) && zzc(zzahaVar.zzc)) {
                    return true;
                }
            } else if (zzb instanceof zzahh) {
                zzahh zzahhVar = (zzahh) zzb;
                if ("com.apple.iTunes".equals(zzahhVar.zza) && "iTunSMPB".equals(zzahhVar.zzb) && zzc(zzahhVar.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
