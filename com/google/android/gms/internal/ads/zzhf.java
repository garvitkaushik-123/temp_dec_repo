package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.ironsource.C3040d4;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhf {
    private static final Pattern zza = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final Pattern zzb = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static long zza(String str, String str2) {
        long j = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                zzea.zzc("HttpUtil", "Unexpected Content-Length [" + str + C3040d4.i.e);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j;
        }
        Matcher matcher = zza.matcher(str2);
        if (!matcher.matches()) {
            return j;
        }
        try {
            String group = matcher.group(2);
            if (group == null) {
                throw null;
            }
            String str3 = group;
            long parseLong = Long.parseLong(group);
            String group2 = matcher.group(1);
            if (group2 == null) {
                throw null;
            }
            String str4 = group2;
            long parseLong2 = (parseLong - Long.parseLong(group2)) + 1;
            if (j < 0) {
                return parseLong2;
            }
            if (j == parseLong2) {
                return j;
            }
            zzea.zzf("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + C3040d4.i.e);
            return Math.max(j, parseLong2);
        } catch (NumberFormatException unused2) {
            zzea.zzc("HttpUtil", "Unexpected Content-Range [" + str2 + C3040d4.i.e);
            return j;
        }
    }

    public static long zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = zzb.matcher(str);
        if (!matcher.matches()) {
            return -1L;
        }
        String group = matcher.group(1);
        group.getClass();
        return Long.parseLong(group);
    }
}
