package com.google.android.gms.internal.ads;

import com.google.common.net.HttpHeaders;
import com.ironsource.Y1;
import io.ktor.client.utils.CacheControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzara {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || Y1.f.equals(str)) {
                zzaqp.zzd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzaqp.zzc(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static zzapm zzb(zzapz zzapzVar) {
        long j;
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = zzapzVar.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get(HttpHeaders.DATE);
        long zza = str != null ? zza(str) : 0L;
        String str2 = (String) map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z = false;
            j2 = 0;
            j3 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals(CacheControl.NO_CACHE) || trim.equals(CacheControl.NO_STORE)) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j3 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals(CacheControl.MUST_REVALIDATE) || trim.equals(CacheControl.PROXY_REVALIDATE)) {
                    z = true;
                }
                i++;
            }
            j = 0;
            i = 1;
        } else {
            j = 0;
            z = false;
            j2 = 0;
            j3 = 0;
        }
        String str3 = (String) map.get(HttpHeaders.EXPIRES);
        long zza2 = str3 != null ? zza(str3) : j;
        String str4 = (String) map.get(HttpHeaders.LAST_MODIFIED);
        if (str4 != null) {
            j4 = currentTimeMillis;
            j5 = zza(str4);
        } else {
            j4 = currentTimeMillis;
            j5 = j;
        }
        String str5 = (String) map.get("ETag");
        if (i != 0) {
            long j8 = (j3 * 1000) + j4;
            j7 = z ? j8 : (j2 * 1000) + j8;
            j6 = j8;
        } else {
            j6 = (zza <= j || zza2 < zza) ? j : (zza2 - zza) + j4;
            j7 = j6;
        }
        zzapm zzapmVar = new zzapm();
        zzapmVar.zza = zzapzVar.zzb;
        zzapmVar.zzb = str5;
        zzapmVar.zzf = j6;
        zzapmVar.zze = j7;
        zzapmVar.zzc = zza;
        zzapmVar.zzd = j5;
        zzapmVar.zzg = map;
        zzapmVar.zzh = zzapzVar.zzd;
        return zzapmVar;
    }

    static String zzc(long j) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
