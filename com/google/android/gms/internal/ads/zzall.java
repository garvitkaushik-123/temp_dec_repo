package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzall {
    private static final Pattern zzc = Pattern.compile("\\{([^}]*)\\}");
    private static final Pattern zzd;
    private static final Pattern zze;
    private static final Pattern zzf;
    public final int zza;
    public final PointF zzb;

    static {
        String str = zzex.zza;
        zzd = Pattern.compile(String.format(Locale.US, "\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        zze = Pattern.compile(String.format(Locale.US, "\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        zzf = Pattern.compile("\\\\an(\\d+)");
    }

    private zzall(int i, PointF pointF) {
        this.zza = i;
        this.zzb = pointF;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0097 A[Catch: RuntimeException -> 0x000a, TryCatch #0 {RuntimeException -> 0x000a, blocks: (B:19:0x008b, B:21:0x0097, B:29:0x009d, B:24:0x00a5), top: B:18:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x000a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzall zza(String str) {
        Matcher matcher;
        int i;
        Matcher matcher2;
        Matcher matcher3;
        boolean find;
        boolean find2;
        PointF pointF;
        String str2;
        String str3;
        Matcher matcher4 = zzc.matcher(str);
        PointF pointF2 = null;
        int i2 = -1;
        while (matcher4.find()) {
            String group = matcher4.group(1);
            group.getClass();
            try {
                matcher2 = zzd.matcher(group);
                matcher3 = zze.matcher(group);
                find = matcher2.find();
                find2 = matcher3.find();
            } catch (RuntimeException unused) {
            }
            if (find) {
                if (find2) {
                    zzea.zze("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + group + "'");
                }
                str2 = matcher2.group(1);
                str3 = matcher2.group(2);
            } else if (find2) {
                String group2 = matcher3.group(1);
                String group3 = matcher3.group(2);
                str2 = group2;
                str3 = group3;
            } else {
                pointF = null;
                if (pointF != null) {
                    pointF2 = pointF;
                }
                try {
                    matcher = zzf.matcher(group);
                    if (matcher.find()) {
                        i = -1;
                    } else {
                        String group4 = matcher.group(1);
                        if (group4 == null) {
                            throw null;
                        }
                        String str4 = group4;
                        i = zzalm.zzd(group4);
                    }
                    if (i == -1) {
                        i2 = i;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            if (str2 == null) {
                throw null;
            }
            String str5 = str2;
            float parseFloat = Float.parseFloat(str2.trim());
            if (str3 == null) {
                throw null;
            }
            String str6 = str3;
            pointF = new PointF(parseFloat, Float.parseFloat(str3.trim()));
            if (pointF != null) {
            }
            matcher = zzf.matcher(group);
            if (matcher.find()) {
            }
            if (i == -1) {
            }
        }
        return new zzall(i2, pointF2);
    }

    public static String zzb(String str) {
        return zzc.matcher(str).replaceAll("");
    }
}
