package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzamc {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzen zzc = new zzen();
    private final StringBuilder zzd = new StringBuilder();

    static String zza(zzen zzenVar, StringBuilder sb) {
        zzc(zzenVar);
        if (zzenVar.zza() == 0) {
            return null;
        }
        String zzd = zzd(zzenVar, sb);
        if (!"".equals(zzd)) {
            return zzd;
        }
        char zzm = (char) zzenVar.zzm();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(zzm);
        return sb2.toString();
    }

    static void zzc(zzen zzenVar) {
        while (true) {
            for (boolean z = true; zzenVar.zza() > 0 && z; z = false) {
                char c = (char) zzenVar.zzN()[zzenVar.zzc()];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    zzenVar.zzM(1);
                } else {
                    int zzc = zzenVar.zzc();
                    int zzd = zzenVar.zzd();
                    byte[] zzN = zzenVar.zzN();
                    if (zzc + 2 <= zzd) {
                        int i = zzc + 1;
                        if (zzN[zzc] == 47) {
                            int i2 = zzc + 2;
                            if (zzN[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= zzd) {
                                        break;
                                    }
                                    if (((char) zzN[i2]) == '*' && ((char) zzN[i3]) == '/') {
                                        zzd = i2 + 2;
                                        i2 = zzd;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzenVar.zzM(zzd - zzenVar.zzc());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    private static String zzd(zzen zzenVar, StringBuilder sb) {
        sb.setLength(0);
        int zzc = zzenVar.zzc();
        int zzd = zzenVar.zzd();
        loop0: while (true) {
            for (boolean z = false; zzc < zzd && !z; z = true) {
                char c = (char) zzenVar.zzN()[zzc];
                if ((c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                    sb.append(c);
                    zzc++;
                }
            }
        }
        zzenVar.zzM(zzc - zzenVar.zzc());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:171:0x030d, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x00aa, code lost:
    
        if (")".equals(zza(r4, r1)) == false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzb(zzen zzenVar) {
        String str;
        String sb;
        char c;
        StringBuilder sb2 = this.zzd;
        int i = 0;
        sb2.setLength(0);
        int zzc = zzenVar.zzc();
        while (!TextUtils.isEmpty(zzenVar.zzz(StandardCharsets.UTF_8))) {
        }
        zzen zzenVar2 = this.zzc;
        zzenVar2.zzJ(zzenVar.zzN(), zzenVar.zzc());
        zzenVar2.zzL(zzc);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzc(zzenVar2);
            if (zzenVar2.zza() >= 5 && "::cue".equals(zzenVar2.zzB(5, StandardCharsets.UTF_8))) {
                int zzc2 = zzenVar2.zzc();
                String zza2 = zza(zzenVar2, sb2);
                if (zza2 != null) {
                    if ("{".equals(zza2)) {
                        zzenVar2.zzL(zzc2);
                        str = "";
                    } else if ("(".equals(zza2)) {
                        int zzc3 = zzenVar2.zzc();
                        int zzd = zzenVar2.zzd();
                        int i2 = i;
                        while (zzc3 < zzd && i2 == 0) {
                            int i3 = zzc3 + 1;
                            i2 = ((char) zzenVar2.zzN()[zzc3]) == ')' ? 1 : i;
                            zzc3 = i3;
                        }
                        str = zzenVar2.zzB((zzc3 - 1) - zzenVar2.zzc(), StandardCharsets.UTF_8).trim();
                    } else {
                        str = null;
                    }
                    if (str == null || !"{".equals(zza(zzenVar2, sb2))) {
                        break;
                    }
                    zzamd zzamdVar = new zzamd();
                    if (!"".equals(str)) {
                        int indexOf = str.indexOf(91);
                        if (indexOf != -1) {
                            Matcher matcher = zza.matcher(str.substring(indexOf));
                            if (matcher.matches()) {
                                String group = matcher.group(1);
                                group.getClass();
                                zzamdVar.zzv(group);
                            }
                            str = str.substring(i, indexOf);
                        }
                        String str2 = zzex.zza;
                        String[] split = str.split("\\.", -1);
                        String str3 = split[i];
                        int indexOf2 = str3.indexOf(35);
                        if (indexOf2 != -1) {
                            zzamdVar.zzu(str3.substring(i, indexOf2));
                            zzamdVar.zzt(str3.substring(indexOf2 + 1));
                        } else {
                            zzamdVar.zzu(str3);
                        }
                        int length = split.length;
                        if (length > 1) {
                            zzamdVar.zzs((String[]) Arrays.copyOfRange(split, 1, length));
                        }
                    }
                    int i4 = i;
                    String str4 = null;
                    while (i4 == 0) {
                        int zzc4 = zzenVar2.zzc();
                        str4 = zza(zzenVar2, sb2);
                        int i5 = (str4 == null || "}".equals(str4)) ? 1 : i;
                        if (i5 == 0) {
                            zzenVar2.zzL(zzc4);
                            zzc(zzenVar2);
                            String zzd2 = zzd(zzenVar2, sb2);
                            if (!"".equals(zzd2) && ":".equals(zza(zzenVar2, sb2))) {
                                zzc(zzenVar2);
                                StringBuilder sb3 = new StringBuilder();
                                int i6 = i;
                                while (true) {
                                    if (i6 != 0) {
                                        sb = sb3.toString();
                                        break;
                                    }
                                    int zzc5 = zzenVar2.zzc();
                                    String zza3 = zza(zzenVar2, sb2);
                                    if (zza3 == null) {
                                        sb = null;
                                        break;
                                    }
                                    if ("}".equals(zza3) || ";".equals(zza3)) {
                                        zzenVar2.zzL(zzc5);
                                        i6 = 1;
                                    } else {
                                        sb3.append(zza3);
                                    }
                                }
                                if (sb != null && !"".equals(sb)) {
                                    int zzc6 = zzenVar2.zzc();
                                    String zza4 = zza(zzenVar2, sb2);
                                    if (!";".equals(zza4)) {
                                        if ("}".equals(zza4)) {
                                            zzenVar2.zzL(zzc6);
                                        } else {
                                            continue;
                                        }
                                    }
                                    if ("color".equals(zzd2)) {
                                        zzamdVar.zzk(zzdl.zza(sb));
                                    } else if ("background-color".equals(zzd2)) {
                                        zzamdVar.zzh(zzdl.zza(sb));
                                    } else if ("ruby-position".equals(zzd2)) {
                                        if ("over".equals(sb)) {
                                            zzamdVar.zzp(1);
                                        } else if ("under".equals(sb)) {
                                            zzamdVar.zzp(2);
                                        }
                                    } else if ("text-combine-upright".equals(zzd2)) {
                                        zzamdVar.zzj("all".equals(sb) || sb.startsWith("digits"));
                                    } else if ("text-decoration".equals(zzd2)) {
                                        if ("underline".equals(sb)) {
                                            zzamdVar.zzq(true);
                                        }
                                    } else if ("font-family".equals(zzd2)) {
                                        zzamdVar.zzl(sb);
                                    } else if ("font-weight".equals(zzd2)) {
                                        if ("bold".equals(sb)) {
                                            zzamdVar.zzi(true);
                                        }
                                    } else if ("font-style".equals(zzd2)) {
                                        if ("italic".equals(sb)) {
                                            zzamdVar.zzo(true);
                                        }
                                    } else if ("font-size".equals(zzd2)) {
                                        Matcher matcher2 = zzb.matcher(zzfuv.zza(sb));
                                        if (matcher2.matches()) {
                                            String group2 = matcher2.group(2);
                                            group2.getClass();
                                            int hashCode = group2.hashCode();
                                            if (hashCode == 37) {
                                                if (group2.equals("%")) {
                                                    c = 2;
                                                    if (c != 0) {
                                                    }
                                                    String group3 = matcher2.group(1);
                                                    group3.getClass();
                                                    zzamdVar.zzm(Float.parseFloat(group3));
                                                }
                                                c = 65535;
                                                if (c != 0) {
                                                }
                                                String group32 = matcher2.group(1);
                                                group32.getClass();
                                                zzamdVar.zzm(Float.parseFloat(group32));
                                            } else if (hashCode != 3240) {
                                                if (hashCode == 3592 && group2.equals("px")) {
                                                    c = 0;
                                                    if (c != 0) {
                                                        zzamdVar.zzn(1);
                                                    } else if (c == 1) {
                                                        zzamdVar.zzn(2);
                                                    } else {
                                                        if (c != 2) {
                                                            throw new IllegalStateException();
                                                        }
                                                        zzamdVar.zzn(3);
                                                    }
                                                    String group322 = matcher2.group(1);
                                                    group322.getClass();
                                                    zzamdVar.zzm(Float.parseFloat(group322));
                                                }
                                                c = 65535;
                                                if (c != 0) {
                                                }
                                                String group3222 = matcher2.group(1);
                                                group3222.getClass();
                                                zzamdVar.zzm(Float.parseFloat(group3222));
                                            } else {
                                                if (group2.equals("em")) {
                                                    c = 1;
                                                    if (c != 0) {
                                                    }
                                                    String group32222 = matcher2.group(1);
                                                    group32222.getClass();
                                                    zzamdVar.zzm(Float.parseFloat(group32222));
                                                }
                                                c = 65535;
                                                if (c != 0) {
                                                }
                                                String group322222 = matcher2.group(1);
                                                group322222.getClass();
                                                zzamdVar.zzm(Float.parseFloat(group322222));
                                            }
                                        } else {
                                            zzea.zzf("WebvttCssParser", "Invalid font-size: '" + sb + "'.");
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                        i4 = i5;
                        i = 0;
                    }
                    if ("}".equals(str4)) {
                        arrayList.add(zzamdVar);
                    }
                    i = 0;
                }
            }
            str = null;
            if (str == null) {
                break;
            }
            break;
        }
    }
}
