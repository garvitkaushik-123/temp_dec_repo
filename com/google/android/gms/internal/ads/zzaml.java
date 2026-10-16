package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.ktor.http.ContentDisposition;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaml {
    public static final Pattern zza = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)((?:.|\\f)*)?$");
    private static final Pattern zzb = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map zzc;
    private static final Map zzd;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzc = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzd = Collections.unmodifiableMap(hashMap2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static SpannedString zza(String str, String str2, List list) {
        char c;
        char c2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            int i2 = i + 1;
            char charAt = str2.charAt(i);
            if (charAt == '&') {
                int indexOf = str2.indexOf(59, i2);
                int indexOf2 = str2.indexOf(32, i2);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    String substring = str2.substring(i2, indexOf);
                    int hashCode = substring.hashCode();
                    if (hashCode == 3309) {
                        if (substring.equals("gt")) {
                            c2 = 1;
                            if (c2 != 0) {
                            }
                            if (indexOf == indexOf2) {
                            }
                            i = indexOf + 1;
                        }
                        c2 = 65535;
                        if (c2 != 0) {
                        }
                        if (indexOf == indexOf2) {
                        }
                        i = indexOf + 1;
                    } else if (hashCode == 3464) {
                        if (substring.equals("lt")) {
                            c2 = 0;
                            if (c2 != 0) {
                            }
                            if (indexOf == indexOf2) {
                            }
                            i = indexOf + 1;
                        }
                        c2 = 65535;
                        if (c2 != 0) {
                        }
                        if (indexOf == indexOf2) {
                        }
                        i = indexOf + 1;
                    } else if (hashCode != 96708) {
                        if (hashCode == 3374865 && substring.equals("nbsp")) {
                            c2 = 2;
                            if (c2 != 0) {
                                spannableStringBuilder.append(Typography.less);
                            } else if (c2 == 1) {
                                spannableStringBuilder.append(Typography.greater);
                            } else if (c2 == 2) {
                                spannableStringBuilder.append(' ');
                            } else if (c2 != 3) {
                                zzea.zzf("WebvttCueParser", "ignoring unsupported entity: '&" + substring + ";'");
                            } else {
                                spannableStringBuilder.append(Typography.amp);
                            }
                            if (indexOf == indexOf2) {
                                spannableStringBuilder.append((CharSequence) " ");
                            }
                            i = indexOf + 1;
                        }
                        c2 = 65535;
                        if (c2 != 0) {
                        }
                        if (indexOf == indexOf2) {
                        }
                        i = indexOf + 1;
                    } else {
                        if (substring.equals("amp")) {
                            c2 = 3;
                            if (c2 != 0) {
                            }
                            if (indexOf == indexOf2) {
                            }
                            i = indexOf + 1;
                        }
                        c2 = 65535;
                        if (c2 != 0) {
                        }
                        if (indexOf == indexOf2) {
                        }
                        i = indexOf + 1;
                    }
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
            } else if (i2 < str2.length()) {
                char charAt2 = str2.charAt(i2);
                int indexOf3 = str2.indexOf(62, i2);
                i2 = indexOf3 == -1 ? str2.length() : indexOf3 + 1;
                int i3 = i2 - 2;
                boolean z = str2.charAt(i3) == '/';
                int i4 = i + (charAt2 == '/' ? 2 : 1);
                if (!z) {
                    i3 = i2 - 1;
                }
                String substring2 = str2.substring(i4, i3);
                if (!substring2.trim().isEmpty()) {
                    String trim = substring2.trim();
                    zzdd.zzd(!trim.isEmpty());
                    String str3 = zzex.zza;
                    String str4 = trim.split("[ \\.]", 2)[0];
                    int hashCode2 = str4.hashCode();
                    if (hashCode2 == 98) {
                        if (str4.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                            c = 0;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode2 == 99) {
                        if (str4.equals("c")) {
                            c = 1;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode2 == 105) {
                        if (str4.equals("i")) {
                            c = 2;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode2 == 3650) {
                        if (str4.equals("rt")) {
                            c = 5;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode2 == 3314158) {
                        if (str4.equals(N6.q)) {
                            c = 3;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode2 == 3511770) {
                        if (str4.equals("ruby")) {
                            c = 4;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else if (hashCode2 != 117) {
                        if (hashCode2 == 118 && str4.equals("v")) {
                            c = 7;
                            switch (c) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    if (charAt2 != '/') {
                                        if (!z) {
                                            arrayDeque.push(zzamh.zza(substring2, spannableStringBuilder.length()));
                                            break;
                                        }
                                    } else {
                                        while (!arrayDeque.isEmpty()) {
                                            zzamh zzamhVar = (zzamh) arrayDeque.pop();
                                            zzg(str, zzamhVar, arrayList, spannableStringBuilder, list);
                                            if (arrayDeque.isEmpty()) {
                                                arrayList.clear();
                                            } else {
                                                arrayList.add(new zzamg(zzamhVar, spannableStringBuilder.length(), null));
                                            }
                                            if (zzamhVar.zza.equals(str4)) {
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    break;
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    } else {
                        if (str4.equals("u")) {
                            c = 6;
                            switch (c) {
                            }
                        }
                        c = 65535;
                        switch (c) {
                        }
                    }
                }
            }
            i = i2;
        }
        while (!arrayDeque.isEmpty()) {
            zzg(str, (zzamh) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        zzg(str, zzamh.zzb(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    static zzcs zzb(String str) {
        zzamj zzamjVar = new zzamj();
        zzh(str, zzamjVar);
        return zzamjVar.zza();
    }

    public static zzame zzc(zzen zzenVar, List list) {
        String zzz = zzenVar.zzz(StandardCharsets.UTF_8);
        if (zzz != null) {
            Pattern pattern = zza;
            Matcher matcher = pattern.matcher(zzz);
            if (matcher.matches()) {
                return zze(null, matcher, zzenVar, list);
            }
            String zzz2 = zzenVar.zzz(StandardCharsets.UTF_8);
            if (zzz2 != null) {
                Matcher matcher2 = pattern.matcher(zzz2);
                if (matcher2.matches()) {
                    return zze(zzz.trim(), matcher2, zzenVar, list);
                }
            }
        }
        return null;
    }

    private static int zzd(List list, String str, zzamh zzamhVar) {
        List zzf = zzf(list, str, zzamhVar);
        for (int i = 0; i < zzf.size(); i++) {
            zzamd zzamdVar = ((zzami) zzf.get(i)).zzb;
            if (zzamdVar.zze() != -1) {
                return zzamdVar.zze();
            }
        }
        return -1;
    }

    private static zzame zze(String str, Matcher matcher, zzen zzenVar, List list) {
        zzamj zzamjVar = new zzamj();
        try {
            String group = matcher.group(1);
            if (group == null) {
                throw null;
            }
            String str2 = group;
            zzamjVar.zza = zzamn.zzb(group);
            String group2 = matcher.group(2);
            if (group2 == null) {
                throw null;
            }
            String str3 = group2;
            zzamjVar.zzb = zzamn.zzb(group2);
            String group3 = matcher.group(3);
            group3.getClass();
            zzh(group3, zzamjVar);
            StringBuilder sb = new StringBuilder();
            String zzz = zzenVar.zzz(StandardCharsets.UTF_8);
            while (!TextUtils.isEmpty(zzz)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(zzz.trim());
                zzz = zzenVar.zzz(StandardCharsets.UTF_8);
            }
            zzamjVar.zzc = zza(str, sb.toString(), list);
            return new zzame(zzamjVar.zza().zzq(), zzamjVar.zza, zzamjVar.zzb);
        } catch (IllegalArgumentException unused) {
            zzea.zzf("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(matcher.group())));
            return null;
        }
    }

    private static List zzf(List list, String str, zzamh zzamhVar) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzamd zzamdVar = (zzamd) list.get(i);
            int zzf = zzamdVar.zzf(str, zzamhVar.zza, zzamhVar.zzd, zzamhVar.zzc);
            if (zzf > 0) {
                arrayList.add(new zzami(zzf, zzamdVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void zzg(String str, zzamh zzamhVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        char c;
        Comparator comparator;
        zzamh zzamhVar2;
        zzamh zzamhVar3;
        zzamh zzamhVar4;
        int i;
        int i2 = zzamhVar.zzb;
        int length = spannableStringBuilder.length();
        String str2 = zzamhVar.zza;
        int hashCode = str2.hashCode();
        int i3 = -1;
        if (hashCode == 0) {
            if (str2.equals("")) {
                c = 7;
            }
            c = 65535;
        } else if (hashCode == 105) {
            if (str2.equals("i")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode == 3314158) {
            if (str2.equals(N6.q)) {
                c = 6;
            }
            c = 65535;
        } else if (hashCode == 3511770) {
            if (str2.equals("ruby")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode == 98) {
            if (str2.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode == 99) {
            if (str2.equals("c")) {
                c = 4;
            }
            c = 65535;
        } else if (hashCode != 117) {
            if (hashCode == 118 && str2.equals("v")) {
                c = 5;
            }
            c = 65535;
        } else {
            if (str2.equals("u")) {
                c = 3;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i2, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
                break;
            case 2:
                int zzd2 = zzd(list2, str, zzamhVar);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                comparator = zzamg.zza;
                Collections.sort(arrayList, comparator);
                int i4 = i2;
                int i5 = 0;
                int i6 = 0;
                while (i5 < arrayList.size()) {
                    zzamhVar2 = ((zzamg) arrayList.get(i5)).zzb;
                    if ("rt".equals(zzamhVar2.zza)) {
                        zzamg zzamgVar = (zzamg) arrayList.get(i5);
                        zzamhVar3 = zzamgVar.zzb;
                        int zzd3 = zzd(list2, str, zzamhVar3);
                        if (zzd3 == i3) {
                            zzd3 = zzd2 != i3 ? zzd2 : 1;
                        }
                        zzamhVar4 = zzamgVar.zzb;
                        int i7 = zzamhVar4.zzb - i6;
                        i = zzamgVar.zzc;
                        int i8 = i - i6;
                        CharSequence subSequence = spannableStringBuilder.subSequence(i7, i8);
                        spannableStringBuilder.delete(i7, i8);
                        spannableStringBuilder.setSpan(new zzcz(subSequence.toString(), zzd3), i4, i7, 33);
                        i6 += subSequence.length();
                        i4 = i7;
                    }
                    i5++;
                    i3 = -1;
                }
                break;
            case 3:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                break;
            case 4:
                for (String str3 : zzamhVar.zzd) {
                    Map map = zzc;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i2, length, 33);
                    } else {
                        Map map2 = zzd;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i2, length, 33);
                        }
                    }
                }
                break;
            case 5:
                spannableStringBuilder.setSpan(new zzdc(zzamhVar.zzc), i2, length, 33);
                break;
            case 6:
            case 7:
                break;
            default:
                return;
        }
        List zzf = zzf(list2, str, zzamhVar);
        for (int i9 = 0; i9 < zzf.size(); i9++) {
            zzamd zzamdVar = ((zzami) zzf.get(i9)).zzb;
            if (zzamdVar != null) {
                if (zzamdVar.zzg() != -1) {
                    zzda.zzb(spannableStringBuilder, new StyleSpan(zzamdVar.zzg()), i2, length, 33);
                }
                if (zzamdVar.zzz()) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                }
                if (zzamdVar.zzy()) {
                    zzda.zzb(spannableStringBuilder, new ForegroundColorSpan(zzamdVar.zzc()), i2, length, 33);
                }
                if (zzamdVar.zzx()) {
                    zzda.zzb(spannableStringBuilder, new BackgroundColorSpan(zzamdVar.zzb()), i2, length, 33);
                }
                if (zzamdVar.zzr() != null) {
                    zzda.zzb(spannableStringBuilder, new TypefaceSpan(zzamdVar.zzr()), i2, length, 33);
                }
                int zzd4 = zzamdVar.zzd();
                if (zzd4 == 1) {
                    zzda.zzb(spannableStringBuilder, new AbsoluteSizeSpan((int) zzamdVar.zza(), true), i2, length, 33);
                } else if (zzd4 == 2) {
                    zzda.zzb(spannableStringBuilder, new RelativeSizeSpan(zzamdVar.zza()), i2, length, 33);
                } else if (zzd4 == 3) {
                    zzda.zzb(spannableStringBuilder, new RelativeSizeSpan(zzamdVar.zza() / 100.0f), i2, length, 33);
                }
                if (zzamdVar.zzw()) {
                    spannableStringBuilder.setSpan(new zzcy(), i2, length, 33);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void zzh(String str, zzamj zzamjVar) {
        Matcher matcher = zzb.matcher(str);
        while (matcher.find()) {
            int i = 1;
            String group = matcher.group(1);
            group.getClass();
            int i2 = 2;
            String group2 = matcher.group(2);
            group2.getClass();
            try {
                char c = 65535;
                if ("line".equals(group)) {
                    int indexOf = group2.indexOf(44);
                    if (indexOf != -1) {
                        String substring = group2.substring(indexOf + 1);
                        switch (substring.hashCode()) {
                            case -1364013995:
                                if (substring.equals("center")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -1074341483:
                                if (substring.equals("middle")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 100571:
                                if (substring.equals("end")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 109757538:
                                if (substring.equals("start")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        if (c == 0) {
                            i2 = 0;
                        } else if (c == 1 || c == 2) {
                            i2 = 1;
                        } else if (c != 3) {
                            zzea.zzf("WebvttCueParser", "Invalid anchor value: ".concat(String.valueOf(substring)));
                            i2 = Integer.MIN_VALUE;
                        }
                        zzamjVar.zzg = i2;
                        group2 = group2.substring(0, indexOf);
                    }
                    if (group2.endsWith("%")) {
                        zzamjVar.zze = zzamn.zza(group2);
                        zzamjVar.zzf = 0;
                    } else {
                        zzamjVar.zze = Integer.parseInt(group2);
                        zzamjVar.zzf = 1;
                    }
                } else if ("align".equals(group)) {
                    switch (group2.hashCode()) {
                        case -1364013995:
                            if (group2.equals("center")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1074341483:
                            if (group2.equals("middle")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 100571:
                            if (group2.equals("end")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 3317767:
                            if (group2.equals("left")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 108511772:
                            if (group2.equals("right")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 109757538:
                            if (group2.equals("start")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            if (c != 2 && c != 3) {
                                if (c != 4) {
                                    i = 5;
                                    if (c != 5) {
                                        zzea.zzf("WebvttCueParser", "Invalid alignment value: ".concat(group2));
                                    }
                                } else {
                                    i = 3;
                                }
                            }
                            i = 2;
                        } else {
                            i = 4;
                        }
                    }
                    zzamjVar.zzd = i;
                } else if (C3040d4.h.L.equals(group)) {
                    int indexOf2 = group2.indexOf(44);
                    if (indexOf2 != -1) {
                        String substring2 = group2.substring(indexOf2 + 1);
                        switch (substring2.hashCode()) {
                            case -1842484672:
                                if (substring2.equals("line-left")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -1364013995:
                                if (substring2.equals("center")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -1276788989:
                                if (substring2.equals("line-right")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -1074341483:
                                if (substring2.equals("middle")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 100571:
                                if (substring2.equals("end")) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case 109757538:
                                if (substring2.equals("start")) {
                                    c = 1;
                                    break;
                                }
                                break;
                        }
                        if (c == 0 || c == 1) {
                            i = 0;
                        } else if (c != 2 && c != 3) {
                            if (c == 4 || c == 5) {
                                i = 2;
                            } else {
                                zzea.zzf("WebvttCueParser", "Invalid anchor value: ".concat(String.valueOf(substring2)));
                                i = Integer.MIN_VALUE;
                            }
                        }
                        zzamjVar.zzi = i;
                        group2 = group2.substring(0, indexOf2);
                    }
                    zzamjVar.zzh = zzamn.zza(group2);
                } else if (ContentDisposition.Parameters.Size.equals(group)) {
                    zzamjVar.zzj = zzamn.zza(group2);
                } else if ("vertical".equals(group)) {
                    int hashCode = group2.hashCode();
                    if (hashCode != 3462) {
                        if (hashCode == 3642 && group2.equals("rl")) {
                            c = 0;
                        }
                    } else if (group2.equals("lr")) {
                        c = 1;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            zzea.zzf("WebvttCueParser", "Invalid 'vertical' value: ".concat(group2));
                            i = Integer.MIN_VALUE;
                        } else {
                            i = 2;
                        }
                    }
                    zzamjVar.zzk = i;
                } else {
                    zzea.zzf("WebvttCueParser", "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException unused) {
                zzea.zzf("WebvttCueParser", "Skipping bad cue setting: ".concat(String.valueOf(matcher.group())));
            }
        }
    }
}
