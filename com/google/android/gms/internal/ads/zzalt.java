package com.google.android.gms.internal.ads;

import android.text.Layout;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzalt implements zzakt {
    private final XmlPullParserFactory zzi;
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");
    private static final Pattern zzf = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzalr zzh = new zzalr(30.0f, 1, 1);

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d6, code lost:
    
        if (r13.equals("s") != false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long zzc(String str, zzalr zzalrVar) throws zzakp {
        double d;
        double d2;
        Matcher matcher = zzc.matcher(str);
        char c = 2;
        if (matcher.matches()) {
            String group = matcher.group(1);
            group.getClass();
            long parseLong = Long.parseLong(group) * 3600;
            String group2 = matcher.group(2);
            group2.getClass();
            long parseLong2 = Long.parseLong(group2) * 60;
            String group3 = matcher.group(3);
            group3.getClass();
            double d3 = parseLong + parseLong2;
            double parseLong3 = Long.parseLong(group3);
            String group4 = matcher.group(4);
            double parseDouble = group4 != null ? Double.parseDouble(group4) : 0.0d;
            double d4 = d3 + parseLong3;
            return (long) ((d4 + parseDouble + (matcher.group(5) != null ? Long.parseLong(r13) / zzalrVar.zza : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / zzalrVar.zzb) / zzalrVar.zza : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = zzd.matcher(str);
        if (!matcher2.matches()) {
            throw new zzakp("Malformed time expression: ".concat(String.valueOf(str)));
        }
        String group5 = matcher2.group(1);
        group5.getClass();
        double parseDouble2 = Double.parseDouble(group5);
        String group6 = matcher2.group(2);
        group6.getClass();
        int hashCode = group6.hashCode();
        if (hashCode == 102) {
            if (group6.equals(InneractiveMediationDefs.GENDER_FEMALE)) {
                c = 4;
            }
            c = 65535;
        } else if (hashCode == 104) {
            if (group6.equals("h")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode == 109) {
            if (group6.equals("m")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode == 3494) {
            if (group6.equals("ms")) {
                c = 3;
            }
            c = 65535;
        } else if (hashCode != 115) {
            if (hashCode == 116 && group6.equals("t")) {
                c = 5;
            }
            c = 65535;
        }
        if (c == 0) {
            d = 3600.0d;
        } else {
            if (c != 1) {
                if (c == 3) {
                    d2 = 1000.0d;
                } else {
                    if (c != 4) {
                        if (c == 5) {
                            d2 = zzalrVar.zzc;
                        }
                        return (long) (parseDouble2 * 1000000.0d);
                    }
                    d2 = zzalrVar.zza;
                }
                parseDouble2 /= d2;
                return (long) (parseDouble2 * 1000000.0d);
            }
            d = 60.0d;
        }
        parseDouble2 *= d;
        return (long) (parseDouble2 * 1000000.0d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Layout.Alignment zzd(String str) {
        char c;
        String zza2 = zzfuv.zza(str);
        switch (zza2.hashCode()) {
            case -1364013995:
                if (zza2.equals("center")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 100571:
                if (zza2.equals("end")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3317767:
                if (zza2.equals("left")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 108511772:
                if (zza2.equals("right")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 109757538:
                if (zza2.equals("start")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0 || c == 1) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (c == 2 || c == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (c != 4) {
            return null;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private static zzalw zze(zzalw zzalwVar) {
        return zzalwVar == null ? new zzalw() : zzalwVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v73 */
    /* JADX WARN: Type inference failed for: r6v9 */
    private static zzalw zzf(XmlPullParser xmlPullParser, zzalw zzalwVar) {
        ?? r6;
        Matcher matcher;
        int attributeCount = xmlPullParser.getAttributeCount();
        boolean z = false;
        zzalw zzalwVar2 = zzalwVar;
        int i = 0;
        while (i < attributeCount) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            ?? r10 = -1;
            r10 = -1;
            r10 = -1;
            r10 = -1;
            r10 = -1;
            ?? r102 = -1;
            r10 = -1;
            r10 = -1;
            ?? r103 = -1;
            r10 = -1;
            r10 = -1;
            r10 = -1;
            r10 = -1;
            r10 = -1;
            r10 = -1;
            ?? r104 = -1;
            r10 = -1;
            r10 = -1;
            ?? r105 = -1;
            r10 = -1;
            r10 = -1;
            r10 = -1;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        r6 = 6;
                        break;
                    }
                    r6 = -1;
                    break;
                case -1289044182:
                    if (attributeName.equals("extent")) {
                        r6 = 16;
                        break;
                    }
                    r6 = -1;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        r6 = 3;
                        break;
                    }
                    r6 = -1;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        r6 = 7;
                        break;
                    }
                    r6 = -1;
                    break;
                case -1008619738:
                    if (attributeName.equals("origin")) {
                        r6 = 15;
                        break;
                    }
                    r6 = -1;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        r6 = 12;
                        break;
                    }
                    r6 = -1;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        r6 = 5;
                        break;
                    }
                    r6 = -1;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        r6 = z;
                        break;
                    }
                    r6 = -1;
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        r6 = 10;
                        break;
                    }
                    r6 = -1;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        r6 = 2;
                        break;
                    }
                    r6 = -1;
                    break;
                case 109403361:
                    if (attributeName.equals("shear")) {
                        r6 = 14;
                        break;
                    }
                    r6 = -1;
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        r6 = 9;
                        break;
                    }
                    r6 = -1;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        r6 = 4;
                        break;
                    }
                    r6 = -1;
                    break;
                case 921125321:
                    if (attributeName.equals("textEmphasis")) {
                        r6 = 13;
                        break;
                    }
                    r6 = -1;
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        r6 = 11;
                        break;
                    }
                    r6 = -1;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        r6 = 1;
                        break;
                    }
                    r6 = -1;
                    break;
                case 1754920356:
                    if (attributeName.equals("multiRowAlign")) {
                        r6 = 8;
                        break;
                    }
                    r6 = -1;
                    break;
                default:
                    r6 = -1;
                    break;
            }
            switch (r6) {
                case 0:
                    if (!"style".equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzt(attributeValue);
                        break;
                    }
                case 1:
                    zzalwVar2 = zze(zzalwVar2);
                    try {
                        zzalwVar2.zzm(zzdl.zzb(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        zzea.zzf("TtmlParser", "Failed parsing background value: ".concat(String.valueOf(attributeValue)));
                        break;
                    }
                case 2:
                    zzalwVar2 = zze(zzalwVar2);
                    try {
                        zzalwVar2.zzp(zzdl.zzb(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused2) {
                        zzea.zzf("TtmlParser", "Failed parsing color value: ".concat(String.valueOf(attributeValue)));
                        break;
                    }
                case 3:
                    zzalwVar2 = zze(zzalwVar2);
                    zzalwVar2.zzq(attributeValue);
                    break;
                case 4:
                    try {
                        zzalwVar2 = zze(zzalwVar2);
                        String str = zzex.zza;
                        String[] split = attributeValue.split("\\s+", -1);
                        int length = split.length;
                        if (length == 1) {
                            matcher = zze.matcher(attributeValue);
                        } else {
                            if (length != 2) {
                                throw new zzakp("Invalid number of entries for fontSize: " + length + ".");
                            }
                            matcher = zze.matcher(split[1]);
                            zzea.zzf("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
                        }
                        if (!matcher.matches()) {
                            throw new zzakp("Invalid expression for fontSize: '" + attributeValue + "'.");
                        }
                        String group = matcher.group(3);
                        if (group == null) {
                            throw null;
                        }
                        String str2 = group;
                        int hashCode = group.hashCode();
                        if (hashCode != 37) {
                            if (hashCode != 3240) {
                                if (hashCode == 3592 && group.equals("px")) {
                                    r10 = 0;
                                }
                            } else if (group.equals("em")) {
                                r10 = 1;
                            }
                        } else if (group.equals("%")) {
                            r10 = 2;
                        }
                        if (r10 == 0) {
                            zzalwVar2.zzs(1);
                        } else if (r10 == 1) {
                            zzalwVar2.zzs(2);
                        } else {
                            if (r10 != 2) {
                                throw new zzakp("Invalid unit for fontSize: '" + group + "'.");
                            }
                            zzalwVar2.zzs(3);
                        }
                        String group2 = matcher.group(1);
                        if (group2 == null) {
                            throw null;
                        }
                        String str3 = group2;
                        zzalwVar2.zzr(Float.parseFloat(group2));
                        break;
                    } catch (zzakp unused3) {
                        zzea.zzf("TtmlParser", "Failed parsing fontSize value: ".concat(String.valueOf(attributeValue)));
                        break;
                    }
                case 5:
                    zzalwVar2 = zze(zzalwVar2);
                    zzalwVar2.zzn("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 6:
                    zzalwVar2 = zze(zzalwVar2);
                    zzalwVar2.zzu("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    zzalwVar2 = zze(zzalwVar2);
                    zzalwVar2.zzB(zzd(attributeValue));
                    break;
                case 8:
                    zzalwVar2 = zze(zzalwVar2);
                    zzalwVar2.zzw(zzd(attributeValue));
                    break;
                case 9:
                    String zza2 = zzfuv.zza(attributeValue);
                    int hashCode2 = zza2.hashCode();
                    if (hashCode2 != 96673) {
                        if (hashCode2 == 3387192 && zza2.equals("none")) {
                            r105 = z;
                        }
                    } else if (zza2.equals("all")) {
                        r105 = 1;
                    }
                    if (r105 == 0) {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzC(z);
                        break;
                    } else if (r105 == 1) {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzC(true);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    String zza3 = zzfuv.zza(attributeValue);
                    switch (zza3.hashCode()) {
                        case -618561360:
                            if (zza3.equals("baseContainer")) {
                                r104 = 2;
                                break;
                            }
                            break;
                        case -410956671:
                            if (zza3.equals("container")) {
                                r104 = z;
                                break;
                            }
                            break;
                        case -250518009:
                            if (zza3.equals("delimiter")) {
                                r104 = 5;
                                break;
                            }
                            break;
                        case -136074796:
                            if (zza3.equals("textContainer")) {
                                r104 = 4;
                                break;
                            }
                            break;
                        case 3016401:
                            if (zza3.equals("base")) {
                                r104 = 1;
                                break;
                            }
                            break;
                        case 3556653:
                            if (zza3.equals("text")) {
                                r104 = 3;
                                break;
                            }
                            break;
                    }
                    if (r104 == 0) {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzz(1);
                        break;
                    } else if (r104 != 1 && r104 != 2) {
                        if (r104 != 3 && r104 != 4) {
                            if (r104 == 5) {
                                zzalwVar2 = zze(zzalwVar2);
                                zzalwVar2.zzz(4);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            zzalwVar2 = zze(zzalwVar2);
                            zzalwVar2.zzz(3);
                            break;
                        }
                    } else {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzz(2);
                        break;
                    }
                case 11:
                    String zza4 = zzfuv.zza(attributeValue);
                    int hashCode3 = zza4.hashCode();
                    if (hashCode3 != -1392885889) {
                        if (hashCode3 == 92734940 && zza4.equals("after")) {
                            r103 = 1;
                        }
                    } else if (zza4.equals("before")) {
                        r103 = z;
                    }
                    if (r103 == 0) {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzy(1);
                        break;
                    } else if (r103 == 1) {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzy(2);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 12:
                    String zza5 = zzfuv.zza(attributeValue);
                    switch (zza5.hashCode()) {
                        case -1461280213:
                            if (zza5.equals("nounderline")) {
                                r102 = 3;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (zza5.equals("underline")) {
                                r102 = 2;
                                break;
                            }
                            break;
                        case 913457136:
                            if (zza5.equals("nolinethrough")) {
                                r102 = 1;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (zza5.equals("linethrough")) {
                                r102 = z;
                                break;
                            }
                            break;
                    }
                    if (r102 == 0) {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzv(true);
                        break;
                    } else if (r102 == 1) {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzv(z);
                        break;
                    } else if (r102 == 2) {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzE(true);
                        break;
                    } else if (r102 == 3) {
                        zzalwVar2 = zze(zzalwVar2);
                        zzalwVar2.zzE(z);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    zzalwVar2 = zze(zzalwVar2);
                    zzalwVar2.zzD(zzalp.zza(attributeValue));
                    break;
                case 14:
                    zzalw zze2 = zze(zzalwVar2);
                    Matcher matcher2 = zza.matcher(attributeValue);
                    float f = Float.MAX_VALUE;
                    if (matcher2.matches()) {
                        try {
                            String group3 = matcher2.group(1);
                            if (group3 == null) {
                                throw null;
                                break;
                            } else {
                                String str4 = group3;
                                f = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(group3)));
                            }
                        } catch (NumberFormatException e) {
                            zzea.zzg("TtmlParser", "Failed to parse shear: ".concat(String.valueOf(attributeValue)), e);
                        }
                    } else {
                        zzea.zzf("TtmlParser", "Invalid value for shear: ".concat(String.valueOf(attributeValue)));
                    }
                    zze2.zzA(f);
                    zzalwVar2 = zze2;
                    break;
                case 15:
                    zzalwVar2 = zze(zzalwVar2);
                    zzalwVar2.zzx(attributeValue);
                    break;
                case 16:
                    zzalwVar2 = zze(zzalwVar2);
                    zzalwVar2.zzo(attributeValue);
                    break;
            }
            i++;
            z = false;
        }
        return zzalwVar2;
    }

    private static String[] zzg(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return new String[0];
        }
        String str2 = zzex.zza;
        return trim.split("\\s+", -1);
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzakn.zza(zzb(bArr, i, i2), zzaksVar, zzdnVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(12:384|(1:(10:387|388|389|390|391|392|34|(2:360|(1:362)(4:363|364|365|(2:367|(2:369|37)(2:370|371))(2:372|373)))|36|37)(1:398))(1:400)|399|388|389|390|391|392|34|(0)|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0168, code lost:
    
        com.google.android.gms.internal.ads.zzea.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0166, code lost:
    
        r16 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0521 A[Catch: IOException -> 0x06ef, XmlPullParserException -> 0x06f8, TryCatch #14 {IOException -> 0x06ef, XmlPullParserException -> 0x06f8, blocks: (B:3:0x0006, B:6:0x0058, B:8:0x0067, B:11:0x0073, B:14:0x007d, B:16:0x0085, B:17:0x008c, B:20:0x0096, B:23:0x00aa, B:24:0x00c5, B:26:0x00cf, B:27:0x00d3, B:29:0x00df, B:30:0x00e3, B:34:0x0172, B:38:0x01d0, B:41:0x01e0, B:43:0x01e6, B:45:0x01ee, B:47:0x01f6, B:49:0x01fe, B:51:0x0206, B:53:0x020e, B:55:0x0214, B:57:0x021c, B:59:0x0224, B:61:0x022a, B:63:0x0230, B:65:0x0238, B:67:0x0240, B:70:0x0249, B:72:0x06d1, B:73:0x026b, B:75:0x0271, B:77:0x027a, B:79:0x0289, B:81:0x0294, B:83:0x02a6, B:85:0x02ac, B:87:0x0526, B:97:0x02b0, B:100:0x02ba, B:102:0x02c0, B:104:0x02cb, B:106:0x02d1, B:107:0x02d8, B:111:0x02e2, B:115:0x0521, B:116:0x02ee, B:118:0x02f6, B:120:0x02fc, B:122:0x0304, B:124:0x030a, B:128:0x031f, B:130:0x0325, B:132:0x0335, B:133:0x03a2, B:135:0x03ac, B:137:0x03b2, B:139:0x03ba, B:141:0x03c0, B:145:0x03d5, B:147:0x03db, B:149:0x03eb, B:150:0x0473, B:152:0x047b, B:165:0x04c2, B:167:0x04ca, B:183:0x0514, B:200:0x03fa, B:203:0x03fb, B:204:0x03fc, B:206:0x040a, B:209:0x0412, B:212:0x0421, B:214:0x0427, B:216:0x0435, B:218:0x044c, B:220:0x044d, B:221:0x044e, B:222:0x045c, B:225:0x033f, B:227:0x0340, B:228:0x0341, B:229:0x034b, B:232:0x0355, B:235:0x0360, B:237:0x0366, B:239:0x0374, B:241:0x0386, B:243:0x0387, B:244:0x0388, B:245:0x0393, B:249:0x0538, B:253:0x055b, B:271:0x05f4, B:280:0x05bf, B:284:0x05c8, B:276:0x0664, B:286:0x05cf, B:291:0x05d9, B:296:0x05e4, B:298:0x05ea, B:300:0x05ef, B:324:0x0606, B:328:0x0610, B:331:0x0619, B:337:0x062d, B:340:0x0644, B:343:0x0650, B:345:0x0655, B:349:0x0634, B:360:0x017d, B:362:0x0189, B:365:0x0194, B:367:0x019a, B:369:0x01a8, B:371:0x01b7, B:373:0x01b8, B:374:0x01b9, B:375:0x00fa, B:377:0x0106, B:380:0x0112, B:382:0x0118, B:384:0x0126, B:389:0x013d, B:392:0x0144, B:394:0x0168, B:403:0x015e, B:406:0x0163, B:416:0x067d, B:419:0x068d, B:422:0x0691, B:424:0x069b, B:426:0x06a5, B:427:0x06b0, B:430:0x06ad, B:434:0x06c2, B:437:0x06ca, B:441:0x06e8, B:444:0x06ee), top: B:2:0x0006, inners: #2, #3, #7, #9, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04ca A[Catch: IOException -> 0x06ef, XmlPullParserException -> 0x06f8, TRY_LEAVE, TryCatch #14 {IOException -> 0x06ef, XmlPullParserException -> 0x06f8, blocks: (B:3:0x0006, B:6:0x0058, B:8:0x0067, B:11:0x0073, B:14:0x007d, B:16:0x0085, B:17:0x008c, B:20:0x0096, B:23:0x00aa, B:24:0x00c5, B:26:0x00cf, B:27:0x00d3, B:29:0x00df, B:30:0x00e3, B:34:0x0172, B:38:0x01d0, B:41:0x01e0, B:43:0x01e6, B:45:0x01ee, B:47:0x01f6, B:49:0x01fe, B:51:0x0206, B:53:0x020e, B:55:0x0214, B:57:0x021c, B:59:0x0224, B:61:0x022a, B:63:0x0230, B:65:0x0238, B:67:0x0240, B:70:0x0249, B:72:0x06d1, B:73:0x026b, B:75:0x0271, B:77:0x027a, B:79:0x0289, B:81:0x0294, B:83:0x02a6, B:85:0x02ac, B:87:0x0526, B:97:0x02b0, B:100:0x02ba, B:102:0x02c0, B:104:0x02cb, B:106:0x02d1, B:107:0x02d8, B:111:0x02e2, B:115:0x0521, B:116:0x02ee, B:118:0x02f6, B:120:0x02fc, B:122:0x0304, B:124:0x030a, B:128:0x031f, B:130:0x0325, B:132:0x0335, B:133:0x03a2, B:135:0x03ac, B:137:0x03b2, B:139:0x03ba, B:141:0x03c0, B:145:0x03d5, B:147:0x03db, B:149:0x03eb, B:150:0x0473, B:152:0x047b, B:165:0x04c2, B:167:0x04ca, B:183:0x0514, B:200:0x03fa, B:203:0x03fb, B:204:0x03fc, B:206:0x040a, B:209:0x0412, B:212:0x0421, B:214:0x0427, B:216:0x0435, B:218:0x044c, B:220:0x044d, B:221:0x044e, B:222:0x045c, B:225:0x033f, B:227:0x0340, B:228:0x0341, B:229:0x034b, B:232:0x0355, B:235:0x0360, B:237:0x0366, B:239:0x0374, B:241:0x0386, B:243:0x0387, B:244:0x0388, B:245:0x0393, B:249:0x0538, B:253:0x055b, B:271:0x05f4, B:280:0x05bf, B:284:0x05c8, B:276:0x0664, B:286:0x05cf, B:291:0x05d9, B:296:0x05e4, B:298:0x05ea, B:300:0x05ef, B:324:0x0606, B:328:0x0610, B:331:0x0619, B:337:0x062d, B:340:0x0644, B:343:0x0650, B:345:0x0655, B:349:0x0634, B:360:0x017d, B:362:0x0189, B:365:0x0194, B:367:0x019a, B:369:0x01a8, B:371:0x01b7, B:373:0x01b8, B:374:0x01b9, B:375:0x00fa, B:377:0x0106, B:380:0x0112, B:382:0x0118, B:384:0x0126, B:389:0x013d, B:392:0x0144, B:394:0x0168, B:403:0x015e, B:406:0x0163, B:416:0x067d, B:419:0x068d, B:422:0x0691, B:424:0x069b, B:426:0x06a5, B:427:0x06b0, B:430:0x06ad, B:434:0x06c2, B:437:0x06ca, B:441:0x06e8, B:444:0x06ee), top: B:2:0x0006, inners: #2, #3, #7, #9, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0655 A[Catch: zzakp -> 0x065e, IOException -> 0x06ef, XmlPullParserException -> 0x06f8, TRY_LEAVE, TryCatch #10 {zzakp -> 0x065e, blocks: (B:343:0x0650, B:345:0x0655), top: B:342:0x0650 }] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x017d A[Catch: IOException -> 0x06ef, XmlPullParserException -> 0x06f8, TryCatch #14 {IOException -> 0x06ef, XmlPullParserException -> 0x06f8, blocks: (B:3:0x0006, B:6:0x0058, B:8:0x0067, B:11:0x0073, B:14:0x007d, B:16:0x0085, B:17:0x008c, B:20:0x0096, B:23:0x00aa, B:24:0x00c5, B:26:0x00cf, B:27:0x00d3, B:29:0x00df, B:30:0x00e3, B:34:0x0172, B:38:0x01d0, B:41:0x01e0, B:43:0x01e6, B:45:0x01ee, B:47:0x01f6, B:49:0x01fe, B:51:0x0206, B:53:0x020e, B:55:0x0214, B:57:0x021c, B:59:0x0224, B:61:0x022a, B:63:0x0230, B:65:0x0238, B:67:0x0240, B:70:0x0249, B:72:0x06d1, B:73:0x026b, B:75:0x0271, B:77:0x027a, B:79:0x0289, B:81:0x0294, B:83:0x02a6, B:85:0x02ac, B:87:0x0526, B:97:0x02b0, B:100:0x02ba, B:102:0x02c0, B:104:0x02cb, B:106:0x02d1, B:107:0x02d8, B:111:0x02e2, B:115:0x0521, B:116:0x02ee, B:118:0x02f6, B:120:0x02fc, B:122:0x0304, B:124:0x030a, B:128:0x031f, B:130:0x0325, B:132:0x0335, B:133:0x03a2, B:135:0x03ac, B:137:0x03b2, B:139:0x03ba, B:141:0x03c0, B:145:0x03d5, B:147:0x03db, B:149:0x03eb, B:150:0x0473, B:152:0x047b, B:165:0x04c2, B:167:0x04ca, B:183:0x0514, B:200:0x03fa, B:203:0x03fb, B:204:0x03fc, B:206:0x040a, B:209:0x0412, B:212:0x0421, B:214:0x0427, B:216:0x0435, B:218:0x044c, B:220:0x044d, B:221:0x044e, B:222:0x045c, B:225:0x033f, B:227:0x0340, B:228:0x0341, B:229:0x034b, B:232:0x0355, B:235:0x0360, B:237:0x0366, B:239:0x0374, B:241:0x0386, B:243:0x0387, B:244:0x0388, B:245:0x0393, B:249:0x0538, B:253:0x055b, B:271:0x05f4, B:280:0x05bf, B:284:0x05c8, B:276:0x0664, B:286:0x05cf, B:291:0x05d9, B:296:0x05e4, B:298:0x05ea, B:300:0x05ef, B:324:0x0606, B:328:0x0610, B:331:0x0619, B:337:0x062d, B:340:0x0644, B:343:0x0650, B:345:0x0655, B:349:0x0634, B:360:0x017d, B:362:0x0189, B:365:0x0194, B:367:0x019a, B:369:0x01a8, B:371:0x01b7, B:373:0x01b8, B:374:0x01b9, B:375:0x00fa, B:377:0x0106, B:380:0x0112, B:382:0x0118, B:384:0x0126, B:389:0x013d, B:392:0x0144, B:394:0x0168, B:403:0x015e, B:406:0x0163, B:416:0x067d, B:419:0x068d, B:422:0x0691, B:424:0x069b, B:426:0x06a5, B:427:0x06b0, B:430:0x06ad, B:434:0x06c2, B:437:0x06ca, B:441:0x06e8, B:444:0x06ee), top: B:2:0x0006, inners: #2, #3, #7, #9, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01e0 A[Catch: IOException -> 0x06ef, XmlPullParserException -> 0x06f8, TRY_ENTER, TryCatch #14 {IOException -> 0x06ef, XmlPullParserException -> 0x06f8, blocks: (B:3:0x0006, B:6:0x0058, B:8:0x0067, B:11:0x0073, B:14:0x007d, B:16:0x0085, B:17:0x008c, B:20:0x0096, B:23:0x00aa, B:24:0x00c5, B:26:0x00cf, B:27:0x00d3, B:29:0x00df, B:30:0x00e3, B:34:0x0172, B:38:0x01d0, B:41:0x01e0, B:43:0x01e6, B:45:0x01ee, B:47:0x01f6, B:49:0x01fe, B:51:0x0206, B:53:0x020e, B:55:0x0214, B:57:0x021c, B:59:0x0224, B:61:0x022a, B:63:0x0230, B:65:0x0238, B:67:0x0240, B:70:0x0249, B:72:0x06d1, B:73:0x026b, B:75:0x0271, B:77:0x027a, B:79:0x0289, B:81:0x0294, B:83:0x02a6, B:85:0x02ac, B:87:0x0526, B:97:0x02b0, B:100:0x02ba, B:102:0x02c0, B:104:0x02cb, B:106:0x02d1, B:107:0x02d8, B:111:0x02e2, B:115:0x0521, B:116:0x02ee, B:118:0x02f6, B:120:0x02fc, B:122:0x0304, B:124:0x030a, B:128:0x031f, B:130:0x0325, B:132:0x0335, B:133:0x03a2, B:135:0x03ac, B:137:0x03b2, B:139:0x03ba, B:141:0x03c0, B:145:0x03d5, B:147:0x03db, B:149:0x03eb, B:150:0x0473, B:152:0x047b, B:165:0x04c2, B:167:0x04ca, B:183:0x0514, B:200:0x03fa, B:203:0x03fb, B:204:0x03fc, B:206:0x040a, B:209:0x0412, B:212:0x0421, B:214:0x0427, B:216:0x0435, B:218:0x044c, B:220:0x044d, B:221:0x044e, B:222:0x045c, B:225:0x033f, B:227:0x0340, B:228:0x0341, B:229:0x034b, B:232:0x0355, B:235:0x0360, B:237:0x0366, B:239:0x0374, B:241:0x0386, B:243:0x0387, B:244:0x0388, B:245:0x0393, B:249:0x0538, B:253:0x055b, B:271:0x05f4, B:280:0x05bf, B:284:0x05c8, B:276:0x0664, B:286:0x05cf, B:291:0x05d9, B:296:0x05e4, B:298:0x05ea, B:300:0x05ef, B:324:0x0606, B:328:0x0610, B:331:0x0619, B:337:0x062d, B:340:0x0644, B:343:0x0650, B:345:0x0655, B:349:0x0634, B:360:0x017d, B:362:0x0189, B:365:0x0194, B:367:0x019a, B:369:0x01a8, B:371:0x01b7, B:373:0x01b8, B:374:0x01b9, B:375:0x00fa, B:377:0x0106, B:380:0x0112, B:382:0x0118, B:384:0x0126, B:389:0x013d, B:392:0x0144, B:394:0x0168, B:403:0x015e, B:406:0x0163, B:416:0x067d, B:419:0x068d, B:422:0x0691, B:424:0x069b, B:426:0x06a5, B:427:0x06b0, B:430:0x06ad, B:434:0x06c2, B:437:0x06ca, B:441:0x06e8, B:444:0x06ee), top: B:2:0x0006, inners: #2, #3, #7, #9, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0271 A[Catch: IOException -> 0x06ef, XmlPullParserException -> 0x06f8, LOOP:1: B:75:0x0271->B:89:0x0530, LOOP_START, PHI: r1 r9
      0x0271: PHI (r1v26 java.lang.String) = (r1v11 java.lang.String), (r1v47 java.lang.String) binds: [B:74:0x026f, B:89:0x0530] A[DONT_GENERATE, DONT_INLINE]
      0x0271: PHI (r9v10 java.util.ArrayDeque) = (r9v3 java.util.ArrayDeque), (r9v58 java.util.ArrayDeque) binds: [B:74:0x026f, B:89:0x0530] A[DONT_GENERATE, DONT_INLINE], TryCatch #14 {IOException -> 0x06ef, XmlPullParserException -> 0x06f8, blocks: (B:3:0x0006, B:6:0x0058, B:8:0x0067, B:11:0x0073, B:14:0x007d, B:16:0x0085, B:17:0x008c, B:20:0x0096, B:23:0x00aa, B:24:0x00c5, B:26:0x00cf, B:27:0x00d3, B:29:0x00df, B:30:0x00e3, B:34:0x0172, B:38:0x01d0, B:41:0x01e0, B:43:0x01e6, B:45:0x01ee, B:47:0x01f6, B:49:0x01fe, B:51:0x0206, B:53:0x020e, B:55:0x0214, B:57:0x021c, B:59:0x0224, B:61:0x022a, B:63:0x0230, B:65:0x0238, B:67:0x0240, B:70:0x0249, B:72:0x06d1, B:73:0x026b, B:75:0x0271, B:77:0x027a, B:79:0x0289, B:81:0x0294, B:83:0x02a6, B:85:0x02ac, B:87:0x0526, B:97:0x02b0, B:100:0x02ba, B:102:0x02c0, B:104:0x02cb, B:106:0x02d1, B:107:0x02d8, B:111:0x02e2, B:115:0x0521, B:116:0x02ee, B:118:0x02f6, B:120:0x02fc, B:122:0x0304, B:124:0x030a, B:128:0x031f, B:130:0x0325, B:132:0x0335, B:133:0x03a2, B:135:0x03ac, B:137:0x03b2, B:139:0x03ba, B:141:0x03c0, B:145:0x03d5, B:147:0x03db, B:149:0x03eb, B:150:0x0473, B:152:0x047b, B:165:0x04c2, B:167:0x04ca, B:183:0x0514, B:200:0x03fa, B:203:0x03fb, B:204:0x03fc, B:206:0x040a, B:209:0x0412, B:212:0x0421, B:214:0x0427, B:216:0x0435, B:218:0x044c, B:220:0x044d, B:221:0x044e, B:222:0x045c, B:225:0x033f, B:227:0x0340, B:228:0x0341, B:229:0x034b, B:232:0x0355, B:235:0x0360, B:237:0x0366, B:239:0x0374, B:241:0x0386, B:243:0x0387, B:244:0x0388, B:245:0x0393, B:249:0x0538, B:253:0x055b, B:271:0x05f4, B:280:0x05bf, B:284:0x05c8, B:276:0x0664, B:286:0x05cf, B:291:0x05d9, B:296:0x05e4, B:298:0x05ea, B:300:0x05ef, B:324:0x0606, B:328:0x0610, B:331:0x0619, B:337:0x062d, B:340:0x0644, B:343:0x0650, B:345:0x0655, B:349:0x0634, B:360:0x017d, B:362:0x0189, B:365:0x0194, B:367:0x019a, B:369:0x01a8, B:371:0x01b7, B:373:0x01b8, B:374:0x01b9, B:375:0x00fa, B:377:0x0106, B:380:0x0112, B:382:0x0118, B:384:0x0126, B:389:0x013d, B:392:0x0144, B:394:0x0168, B:403:0x015e, B:406:0x0163, B:416:0x067d, B:419:0x068d, B:422:0x0691, B:424:0x069b, B:426:0x06a5, B:427:0x06b0, B:430:0x06ad, B:434:0x06c2, B:437:0x06ca, B:441:0x06e8, B:444:0x06ee), top: B:2:0x0006, inners: #2, #3, #7, #9, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0530 A[LOOP:1: B:75:0x0271->B:89:0x0530, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x052c A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r41v1, types: [com.google.android.gms.internal.ads.zzalw, java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzako zzb(byte[] bArr, int i, int i2) {
        String str;
        String str2;
        ArrayDeque arrayDeque;
        zzalr zzalrVar;
        zzalx zzalxVar;
        int i3;
        int i4;
        int i5;
        zzalq zzalqVar;
        long j;
        long j2;
        long j3;
        char c;
        ArrayDeque arrayDeque2;
        float f;
        float f2;
        float f3;
        String str3;
        float f4;
        float f5;
        int i6;
        float f6;
        String zza2;
        int i7;
        zzalu zzaluVar;
        char c2;
        char c3;
        String zza3;
        zzalw zzalwVar;
        String zza4;
        zzalw zzalwVar2;
        String zza5;
        float f7;
        zzalr zzalrVar2;
        String group;
        boolean z;
        String zza6;
        String group2;
        String str4 = "";
        String str5 = "http://www.w3.org/ns/ttml#parameter";
        try {
            XmlPullParser newPullParser = this.zzi.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new zzalu("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            Object obj = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, i, i2), null);
            ArrayDeque arrayDeque3 = new ArrayDeque();
            int eventType = newPullParser.getEventType();
            zzalr zzalrVar3 = zzh;
            zzalx zzalxVar2 = null;
            zzals zzalsVar = null;
            zzalr zzalrVar4 = zzalrVar3;
            int i8 = 0;
            int i9 = 15;
            while (eventType != 1) {
                zzalq zzalqVar2 = (zzalq) arrayDeque3.peek();
                ?? r41 = obj;
                if (i8 == 0) {
                    String name = newPullParser.getName();
                    str = str4;
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            String attributeValue = newPullParser.getAttributeValue(str5, "frameRate");
                            int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
                            String attributeValue2 = newPullParser.getAttributeValue(str5, "frameRateMultiplier");
                            if (attributeValue2 != null) {
                                String str6 = zzex.zza;
                                zzalxVar = zzalxVar2;
                                i3 = i8;
                                zzdd.zze(attributeValue2.split(" ", -1).length == 2, "frameRateMultiplier doesn't have 2 parts");
                                f7 = Integer.parseInt(r15[0]) / Integer.parseInt(r15[1]);
                            } else {
                                zzalxVar = zzalxVar2;
                                i3 = i8;
                                f7 = 1.0f;
                            }
                            int i10 = zzalrVar3.zzb;
                            String attributeValue3 = newPullParser.getAttributeValue(str5, "subFrameRate");
                            if (attributeValue3 != null) {
                                i10 = Integer.parseInt(attributeValue3);
                            }
                            int i11 = zzalrVar3.zzc;
                            zzalrVar = zzalrVar3;
                            String attributeValue4 = newPullParser.getAttributeValue(str5, "tickRate");
                            if (attributeValue4 != null) {
                                i11 = Integer.parseInt(attributeValue4);
                            }
                            zzalr zzalrVar5 = new zzalr(parseInt * f7, i10, i11);
                            String attributeValue5 = newPullParser.getAttributeValue(str5, "cellResolution");
                            if (attributeValue5 != null) {
                                Matcher matcher = zzg.matcher(attributeValue5);
                                if (matcher.matches()) {
                                    try {
                                        group = matcher.group(1);
                                    } catch (NumberFormatException unused) {
                                        str2 = str5;
                                    }
                                    if (group == null) {
                                        throw r41;
                                    }
                                    String str7 = group;
                                    int parseInt2 = Integer.parseInt(group);
                                    String group3 = matcher.group(2);
                                    if (group3 == null) {
                                        throw r41;
                                    }
                                    String str8 = group3;
                                    i4 = Integer.parseInt(group3);
                                    if (parseInt2 == 0) {
                                        z = false;
                                    } else if (i4 != 0) {
                                        str2 = str5;
                                        z = true;
                                        StringBuilder sb = new StringBuilder();
                                        zzalrVar2 = zzalrVar5;
                                        sb.append("Invalid cell resolution ");
                                        sb.append(parseInt2);
                                        sb.append(" ");
                                        sb.append(i4);
                                        zzdd.zze(z, sb.toString());
                                        zza6 = zzey.zza(newPullParser, "extent");
                                        if (zza6 != null) {
                                            Matcher matcher2 = zzf.matcher(zza6);
                                            if (matcher2.matches()) {
                                                try {
                                                    group2 = matcher2.group(1);
                                                } catch (NumberFormatException unused2) {
                                                    zzea.zzf("TtmlParser", "Ignoring malformed tts extent: ".concat(zza6));
                                                }
                                                if (group2 == null) {
                                                    throw r41;
                                                }
                                                String str9 = group2;
                                                int parseInt3 = Integer.parseInt(group2);
                                                String group4 = matcher2.group(2);
                                                if (group4 == null) {
                                                    throw r41;
                                                }
                                                String str10 = group4;
                                                zzalsVar = new zzals(parseInt3, Integer.parseInt(group4));
                                                zzalrVar4 = zzalrVar2;
                                            } else {
                                                zzea.zzf("TtmlParser", "Ignoring non-pixel tts extent: ".concat(zza6));
                                            }
                                        }
                                        zzalsVar = r41;
                                        zzalrVar4 = zzalrVar2;
                                    } else {
                                        i4 = 0;
                                        z = false;
                                    }
                                    str2 = str5;
                                    StringBuilder sb2 = new StringBuilder();
                                    zzalrVar2 = zzalrVar5;
                                    sb2.append("Invalid cell resolution ");
                                    sb2.append(parseInt2);
                                    sb2.append(" ");
                                    sb2.append(i4);
                                    zzdd.zze(z, sb2.toString());
                                    zza6 = zzey.zza(newPullParser, "extent");
                                    if (zza6 != null) {
                                    }
                                    zzalsVar = r41;
                                    zzalrVar4 = zzalrVar2;
                                } else {
                                    zzea.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                }
                            }
                            str2 = str5;
                            zzalrVar2 = zzalrVar5;
                            i4 = 15;
                            zza6 = zzey.zza(newPullParser, "extent");
                            if (zza6 != null) {
                            }
                            zzalsVar = r41;
                            zzalrVar4 = zzalrVar2;
                        } else {
                            str2 = str5;
                            zzalrVar = zzalrVar3;
                            zzalxVar = zzalxVar2;
                            i3 = i8;
                            i4 = i9;
                        }
                        zzals zzalsVar2 = zzalsVar;
                        String str11 = "metadata";
                        if (!name.equals("tt") && !name.equals("head") && !name.equals("body") && !name.equals("div") && !name.equals("p") && !name.equals("span") && !name.equals("br") && !name.equals("style") && !name.equals("styling") && !name.equals("layout") && !name.equals("region") && !name.equals("metadata") && !name.equals("image") && !name.equals("data") && !name.equals("information")) {
                            zzea.zze("TtmlParser", "Ignoring unsupported tag: " + newPullParser.getName());
                            zzalsVar = zzalsVar2;
                            arrayDeque = arrayDeque3;
                            i9 = i4;
                            zzalxVar2 = zzalxVar;
                            i8 = 1;
                        }
                        if ("head".equals(name)) {
                            while (true) {
                                newPullParser.next();
                                if (zzey.zzc(newPullParser, "style")) {
                                    String zza7 = zzey.zza(newPullParser, "style");
                                    zzalw zzf2 = zzf(newPullParser, new zzalw());
                                    if (zza7 != null) {
                                        String[] zzg2 = zzg(zza7);
                                        int length = zzg2.length;
                                        arrayDeque2 = arrayDeque3;
                                        int i12 = 0;
                                        while (i12 < length) {
                                            int i13 = i12;
                                            zzf2.zzl((zzalw) hashMap.get(zzg2[i13]));
                                            i12 = i13 + 1;
                                        }
                                    } else {
                                        arrayDeque2 = arrayDeque3;
                                    }
                                    String zzH = zzf2.zzH();
                                    if (zzH != null) {
                                        hashMap.put(zzH, zzf2);
                                    }
                                } else {
                                    arrayDeque2 = arrayDeque3;
                                    if (zzey.zzc(newPullParser, "region")) {
                                        String zza8 = zzey.zza(newPullParser, "id");
                                        if (zza8 != null) {
                                            String zza9 = zzey.zza(newPullParser, "origin");
                                            if (zza9 == null && (zza4 = zzey.zza(newPullParser, "style")) != null && (zzalwVar2 = (zzalw) hashMap.get(zza4)) != null) {
                                                zza9 = zzalwVar2.zzI();
                                            }
                                            if (zza9 != null) {
                                                Matcher matcher3 = zzb.matcher(zza9);
                                                Matcher matcher4 = zzf.matcher(zza9);
                                                if (matcher3.matches()) {
                                                    f = 100.0f;
                                                    try {
                                                        String group5 = matcher3.group(1);
                                                        if (group5 == null) {
                                                            throw r41;
                                                        }
                                                        String str12 = group5;
                                                        f3 = Float.parseFloat(group5) / 100.0f;
                                                        String group6 = matcher3.group(2);
                                                        if (group6 == null) {
                                                            throw r41;
                                                        }
                                                        String str13 = group6;
                                                        f2 = Float.parseFloat(group6) / 100.0f;
                                                    } catch (NumberFormatException unused3) {
                                                        zzea.zzf("TtmlParser", "Ignoring region with malformed origin: ".concat(zza9));
                                                    }
                                                } else {
                                                    f = 100.0f;
                                                    if (!matcher4.matches()) {
                                                        zzea.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(zza9));
                                                    } else if (zzalsVar2 == null) {
                                                        zzea.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(zza9));
                                                    } else {
                                                        try {
                                                            String group7 = matcher4.group(1);
                                                            if (group7 == null) {
                                                                throw r41;
                                                            }
                                                            String str14 = group7;
                                                            int parseInt4 = Integer.parseInt(group7);
                                                            String group8 = matcher4.group(2);
                                                            if (group8 == null) {
                                                                throw r41;
                                                            }
                                                            String str15 = group8;
                                                            f3 = parseInt4 / zzalsVar2.zza;
                                                            f2 = Integer.parseInt(group8) / zzalsVar2.zzb;
                                                        } catch (NumberFormatException unused4) {
                                                            zzea.zzf("TtmlParser", "Ignoring region with malformed origin: ".concat(zza9));
                                                        }
                                                    }
                                                }
                                                if (zzaluVar != null) {
                                                    hashMap2.put(zzaluVar.zza, zzaluVar);
                                                }
                                                if (zzey.zzb(newPullParser, "head")) {
                                                    arrayDeque = arrayDeque2;
                                                } else {
                                                    str11 = str3;
                                                    arrayDeque3 = arrayDeque2;
                                                }
                                            } else {
                                                f = 100.0f;
                                                f2 = 0.0f;
                                                f3 = 0.0f;
                                            }
                                            float f8 = f3;
                                            String zza10 = zzey.zza(newPullParser, "extent");
                                            if (zza10 == null && (zza3 = zzey.zza(newPullParser, "style")) != null && (zzalwVar = (zzalw) hashMap.get(zza3)) != null) {
                                                zza10 = zzalwVar.zzF();
                                            }
                                            if (zza10 != null) {
                                                Matcher matcher5 = zzb.matcher(zza10);
                                                str3 = str11;
                                                Matcher matcher6 = zzf.matcher(zza10);
                                                if (matcher5.matches()) {
                                                    try {
                                                        String group9 = matcher5.group(1);
                                                        if (group9 == null) {
                                                            throw r41;
                                                        }
                                                        String str16 = group9;
                                                        float parseFloat = Float.parseFloat(group9) / f;
                                                        String group10 = matcher5.group(2);
                                                        if (group10 == null) {
                                                            throw r41;
                                                        }
                                                        String str17 = group10;
                                                        f5 = Float.parseFloat(group10) / f;
                                                        f4 = parseFloat;
                                                    } catch (NumberFormatException unused5) {
                                                        zzea.zzf("TtmlParser", "Ignoring region with malformed extent: ".concat(String.valueOf(zza9)));
                                                    }
                                                } else {
                                                    if (!matcher6.matches()) {
                                                        zzea.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(String.valueOf(zza9)));
                                                    } else if (zzalsVar2 == null) {
                                                        zzea.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(String.valueOf(zza9)));
                                                    } else {
                                                        try {
                                                            String group11 = matcher6.group(1);
                                                            if (group11 == null) {
                                                                throw r41;
                                                            }
                                                            String str18 = group11;
                                                            int parseInt5 = Integer.parseInt(group11);
                                                            String group12 = matcher6.group(2);
                                                            if (group12 == null) {
                                                                throw r41;
                                                            }
                                                            String str19 = group12;
                                                            f5 = Integer.parseInt(group12) / zzalsVar2.zzb;
                                                            f4 = parseInt5 / zzalsVar2.zza;
                                                        } catch (NumberFormatException unused6) {
                                                            zzea.zzf("TtmlParser", "Ignoring region with malformed extent: ".concat(String.valueOf(zza9)));
                                                        }
                                                    }
                                                    zzaluVar = r41;
                                                }
                                                if (zzaluVar != null) {
                                                }
                                                if (zzey.zzb(newPullParser, "head")) {
                                                }
                                            } else {
                                                str3 = str11;
                                                f4 = 1.0f;
                                                f5 = 1.0f;
                                            }
                                            String zza11 = zzey.zza(newPullParser, "displayAlign");
                                            if (zza11 != null) {
                                                String zza12 = zzfuv.zza(zza11);
                                                int hashCode = zza12.hashCode();
                                                if (hashCode != -1364013995) {
                                                    if (hashCode == 92734940 && zza12.equals("after")) {
                                                        c3 = 1;
                                                        if (c3 != 0) {
                                                            f6 = f2 + (f5 / 2.0f);
                                                            i6 = 1;
                                                        } else if (c3 == 1) {
                                                            f6 = f2 + f5;
                                                            i6 = 2;
                                                        }
                                                        float f9 = 1.0f / i4;
                                                        zza2 = zzey.zza(newPullParser, "writingMode");
                                                        if (zza2 != null) {
                                                            String zza13 = zzfuv.zza(zza2);
                                                            int hashCode2 = zza13.hashCode();
                                                            if (hashCode2 == 3694) {
                                                                if (zza13.equals("tb")) {
                                                                    c2 = 0;
                                                                    if (c2 != 0) {
                                                                    }
                                                                    i7 = 2;
                                                                    zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f9, i7);
                                                                    if (zzaluVar != null) {
                                                                    }
                                                                    if (zzey.zzb(newPullParser, "head")) {
                                                                    }
                                                                }
                                                                c2 = 65535;
                                                                if (c2 != 0) {
                                                                }
                                                                i7 = 2;
                                                                zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f9, i7);
                                                                if (zzaluVar != null) {
                                                                }
                                                                if (zzey.zzb(newPullParser, "head")) {
                                                                }
                                                            } else if (hashCode2 != 3553396) {
                                                                if (hashCode2 == 3553576 && zza13.equals("tbrl")) {
                                                                    c2 = 2;
                                                                    if (c2 != 0 || c2 == 1) {
                                                                        i7 = 2;
                                                                    } else if (c2 == 2) {
                                                                        i7 = 1;
                                                                    }
                                                                    zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f9, i7);
                                                                    if (zzaluVar != null) {
                                                                    }
                                                                    if (zzey.zzb(newPullParser, "head")) {
                                                                    }
                                                                }
                                                                c2 = 65535;
                                                                if (c2 != 0) {
                                                                }
                                                                i7 = 2;
                                                                zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f9, i7);
                                                                if (zzaluVar != null) {
                                                                }
                                                                if (zzey.zzb(newPullParser, "head")) {
                                                                }
                                                            } else {
                                                                if (zza13.equals("tblr")) {
                                                                    c2 = 1;
                                                                    if (c2 != 0) {
                                                                    }
                                                                    i7 = 2;
                                                                    zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f9, i7);
                                                                    if (zzaluVar != null) {
                                                                    }
                                                                    if (zzey.zzb(newPullParser, "head")) {
                                                                    }
                                                                }
                                                                c2 = 65535;
                                                                if (c2 != 0) {
                                                                }
                                                                i7 = 2;
                                                                zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f9, i7);
                                                                if (zzaluVar != null) {
                                                                }
                                                                if (zzey.zzb(newPullParser, "head")) {
                                                                }
                                                            }
                                                        }
                                                        i7 = Integer.MIN_VALUE;
                                                        zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f9, i7);
                                                        if (zzaluVar != null) {
                                                        }
                                                        if (zzey.zzb(newPullParser, "head")) {
                                                        }
                                                    }
                                                    c3 = 65535;
                                                    if (c3 != 0) {
                                                    }
                                                    float f92 = 1.0f / i4;
                                                    zza2 = zzey.zza(newPullParser, "writingMode");
                                                    if (zza2 != null) {
                                                    }
                                                    i7 = Integer.MIN_VALUE;
                                                    zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f92, i7);
                                                    if (zzaluVar != null) {
                                                    }
                                                    if (zzey.zzb(newPullParser, "head")) {
                                                    }
                                                } else {
                                                    if (zza12.equals("center")) {
                                                        c3 = 0;
                                                        if (c3 != 0) {
                                                        }
                                                        float f922 = 1.0f / i4;
                                                        zza2 = zzey.zza(newPullParser, "writingMode");
                                                        if (zza2 != null) {
                                                        }
                                                        i7 = Integer.MIN_VALUE;
                                                        zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f922, i7);
                                                        if (zzaluVar != null) {
                                                        }
                                                        if (zzey.zzb(newPullParser, "head")) {
                                                        }
                                                    }
                                                    c3 = 65535;
                                                    if (c3 != 0) {
                                                    }
                                                    float f9222 = 1.0f / i4;
                                                    zza2 = zzey.zza(newPullParser, "writingMode");
                                                    if (zza2 != null) {
                                                    }
                                                    i7 = Integer.MIN_VALUE;
                                                    zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f9222, i7);
                                                    if (zzaluVar != null) {
                                                    }
                                                    if (zzey.zzb(newPullParser, "head")) {
                                                    }
                                                }
                                            }
                                            i6 = 0;
                                            f6 = f2;
                                            float f92222 = 1.0f / i4;
                                            zza2 = zzey.zza(newPullParser, "writingMode");
                                            if (zza2 != null) {
                                            }
                                            i7 = Integer.MIN_VALUE;
                                            zzaluVar = new zzalu(zza8, f8, f6, 0, i6, f4, f5, 1, f92222, i7);
                                            if (zzaluVar != null) {
                                            }
                                            if (zzey.zzb(newPullParser, "head")) {
                                            }
                                        }
                                        zzaluVar = r41;
                                        str3 = str11;
                                        if (zzaluVar != null) {
                                        }
                                        if (zzey.zzb(newPullParser, "head")) {
                                        }
                                    } else if (zzey.zzc(newPullParser, str11)) {
                                        do {
                                            newPullParser.next();
                                            if (zzey.zzc(newPullParser, "image") && (zza5 = zzey.zza(newPullParser, "id")) != null) {
                                                hashMap3.put(zza5, newPullParser.nextText());
                                            }
                                        } while (!zzey.zzb(newPullParser, str11));
                                    }
                                }
                                str3 = str11;
                                if (zzey.zzb(newPullParser, "head")) {
                                }
                            }
                        } else {
                            ArrayDeque arrayDeque4 = arrayDeque3;
                            try {
                                int attributeCount = newPullParser.getAttributeCount();
                                zzalw zzf3 = zzf(newPullParser, r41);
                                int i14 = 0;
                                String str20 = str;
                                long j4 = -9223372036854775807L;
                                long j5 = -9223372036854775807L;
                                long j6 = -9223372036854775807L;
                                String[] strArr = null;
                                String str21 = null;
                                while (i14 < attributeCount) {
                                    try {
                                        String attributeName = newPullParser.getAttributeName(i14);
                                        String attributeValue6 = newPullParser.getAttributeValue(i14);
                                        int i15 = i14;
                                        switch (attributeName.hashCode()) {
                                            case -934795532:
                                                if (attributeName.equals("region")) {
                                                    c = 4;
                                                    break;
                                                }
                                                c = 65535;
                                                break;
                                            case 99841:
                                                if (attributeName.equals("dur")) {
                                                    c = 2;
                                                    break;
                                                }
                                                c = 65535;
                                                break;
                                            case 100571:
                                                if (attributeName.equals("end")) {
                                                    c = 1;
                                                    break;
                                                }
                                                c = 65535;
                                                break;
                                            case 93616297:
                                                if (attributeName.equals("begin")) {
                                                    c = 0;
                                                    break;
                                                }
                                                c = 65535;
                                                break;
                                            case 109780401:
                                                if (attributeName.equals("style")) {
                                                    c = 3;
                                                    break;
                                                }
                                                c = 65535;
                                                break;
                                            case 1292595405:
                                                if (attributeName.equals("backgroundImage")) {
                                                    c = 5;
                                                    break;
                                                }
                                                c = 65535;
                                                break;
                                            default:
                                                c = 65535;
                                                break;
                                        }
                                        if (c != 0) {
                                            i5 = 1;
                                            if (c == 1) {
                                                j4 = zzc(attributeValue6, zzalrVar4);
                                            } else if (c == 2) {
                                                i5 = 1;
                                                j6 = zzc(attributeValue6, zzalrVar4);
                                            } else if (c == 3) {
                                                i5 = 1;
                                                String[] zzg3 = zzg(attributeValue6);
                                                if (zzg3.length > 0) {
                                                    strArr = zzg3;
                                                }
                                            } else if (c == 4) {
                                                i5 = 1;
                                                if (hashMap2.containsKey(attributeValue6)) {
                                                    str20 = attributeValue6;
                                                }
                                            } else if (c == 5 && attributeValue6.startsWith("#")) {
                                                i5 = 1;
                                                try {
                                                    str21 = attributeValue6.substring(1);
                                                } catch (zzakp e) {
                                                    e = e;
                                                    arrayDeque = arrayDeque4;
                                                    zzea.zzg("TtmlParser", "Suppressing parser error", e);
                                                    zzalsVar = zzalsVar2;
                                                    i8 = i5;
                                                    i9 = i4;
                                                    zzalxVar2 = zzalxVar;
                                                    newPullParser.next();
                                                    eventType = newPullParser.getEventType();
                                                    arrayDeque3 = arrayDeque;
                                                    str4 = str;
                                                    zzalrVar3 = zzalrVar;
                                                    str5 = str2;
                                                    obj = null;
                                                }
                                            } else {
                                                i5 = 1;
                                            }
                                        } else {
                                            i5 = 1;
                                            j5 = zzc(attributeValue6, zzalrVar4);
                                        }
                                        i14 = i15 + 1;
                                    } catch (zzakp e2) {
                                        e = e2;
                                        i5 = 1;
                                    }
                                }
                                i5 = 1;
                                if (zzalqVar2 != null) {
                                    long j7 = zzalqVar2.zzd;
                                    if (j7 != -9223372036854775807L) {
                                        j5 = j5 != -9223372036854775807L ? j5 + j7 : -9223372036854775807L;
                                        if (j4 != -9223372036854775807L) {
                                            j4 += j7;
                                        } else {
                                            zzalqVar = zzalqVar2;
                                            j4 = -9223372036854775807L;
                                        }
                                    }
                                    zzalqVar = zzalqVar2;
                                } else {
                                    zzalqVar = null;
                                }
                                try {
                                    if (j4 == -9223372036854775807L) {
                                        if (j6 != -9223372036854775807L) {
                                            j3 = j5 + j6;
                                        } else {
                                            if (zzalqVar != null) {
                                                j3 = zzalqVar.zze;
                                                if (j3 != -9223372036854775807L) {
                                                }
                                            }
                                            j2 = j5;
                                            j = -9223372036854775807L;
                                            zzalq zzb2 = zzalq.zzb(newPullParser.getName(), j2, j, zzf3, strArr, str20, str21, zzalqVar);
                                            arrayDeque = arrayDeque4;
                                            arrayDeque.push(zzb2);
                                            if (zzalqVar2 != null) {
                                                zzalqVar2.zzf(zzb2);
                                            }
                                        }
                                        j = j3;
                                    } else {
                                        j = j4;
                                    }
                                    arrayDeque.push(zzb2);
                                    if (zzalqVar2 != null) {
                                    }
                                } catch (zzakp e3) {
                                    e = e3;
                                    zzea.zzg("TtmlParser", "Suppressing parser error", e);
                                    zzalsVar = zzalsVar2;
                                    i8 = i5;
                                    i9 = i4;
                                    zzalxVar2 = zzalxVar;
                                    newPullParser.next();
                                    eventType = newPullParser.getEventType();
                                    arrayDeque3 = arrayDeque;
                                    str4 = str;
                                    zzalrVar3 = zzalrVar;
                                    str5 = str2;
                                    obj = null;
                                }
                                j2 = j5;
                                zzalq zzb22 = zzalq.zzb(newPullParser.getName(), j2, j, zzf3, strArr, str20, str21, zzalqVar);
                                arrayDeque = arrayDeque4;
                            } catch (zzakp e4) {
                                e = e4;
                                arrayDeque = arrayDeque4;
                                i5 = 1;
                            }
                        }
                        zzalsVar = zzalsVar2;
                        i9 = i4;
                    } else {
                        str2 = str5;
                        arrayDeque = arrayDeque3;
                        zzalrVar = zzalrVar3;
                        zzalxVar = zzalxVar2;
                        i3 = i8;
                        if (eventType == 4) {
                            if (zzalqVar2 == null) {
                                throw null;
                            }
                            zzalq zzalqVar3 = zzalqVar2;
                            zzalqVar2.zzf(zzalq.zzc(newPullParser.getText()));
                        } else if (eventType == 3) {
                            if (newPullParser.getName().equals("tt")) {
                                zzalq zzalqVar4 = (zzalq) arrayDeque.peek();
                                if (zzalqVar4 == null) {
                                    throw null;
                                }
                                zzalq zzalqVar5 = zzalqVar4;
                                zzalxVar2 = new zzalx(zzalqVar4, hashMap, hashMap2, hashMap3);
                            } else {
                                zzalxVar2 = zzalxVar;
                            }
                            arrayDeque.pop();
                            i8 = i3;
                        }
                    }
                    zzalxVar2 = zzalxVar;
                    i8 = i3;
                } else {
                    str = str4;
                    str2 = str5;
                    arrayDeque = arrayDeque3;
                    zzalrVar = zzalrVar3;
                    zzalxVar = zzalxVar2;
                    i3 = i8;
                    if (eventType == 2) {
                        i8 = i3 + 1;
                    } else {
                        if (eventType == 3) {
                            i8 = i3 - 1;
                        }
                        zzalxVar2 = zzalxVar;
                        i8 = i3;
                    }
                    zzalxVar2 = zzalxVar;
                }
                newPullParser.next();
                eventType = newPullParser.getEventType();
                arrayDeque3 = arrayDeque;
                str4 = str;
                zzalrVar3 = zzalrVar;
                str5 = str2;
                obj = null;
            }
            zzalx zzalxVar3 = zzalxVar2;
            if (zzalxVar3 != null) {
                return zzalxVar3;
            }
            throw null;
        } catch (IOException e5) {
            throw new IllegalStateException("Unexpected error when reading input.", e5);
        } catch (XmlPullParserException e6) {
            throw new IllegalStateException("Unable to decode source", e6);
        }
    }

    public zzalt() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.zzi = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }
}
