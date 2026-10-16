package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import io.bidmachine.protobuf.EventTypeExtended;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdk {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};
    private static final Pattern zzd = Pattern.compile("^\\D?(\\d+)$");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair zza(zzz zzzVar) {
        char c;
        int parseInt;
        int parseInt2;
        int i;
        int i2;
        int i3;
        int i4;
        Integer num;
        Integer num2;
        String str = zzzVar.zzk;
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        int i5 = 16;
        int i6 = 3;
        int i7 = 2;
        if (!"video/dolby-vision".equals(zzzVar.zzo)) {
            int i8 = 0;
            String str2 = split[0];
            switch (str2.hashCode()) {
                case 2986313:
                    if (str2.equals("ac-4")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 3004662:
                    if (str2.equals("av01")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3006243:
                    if (str2.equals("avc1")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3006244:
                    if (str2.equals("avc2")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3199032:
                    if (str2.equals("hev1")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3214780:
                    if (str2.equals("hvc1")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3356560:
                    if (str2.equals("mp4a")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 3475740:
                    if (str2.equals("s263")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3624515:
                    if (str2.equals("vp09")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    String str3 = zzzVar.zzk;
                    Pair pair = new Pair(1, 1);
                    if (split.length < 3) {
                        zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: ".concat(String.valueOf(str3)));
                        return pair;
                    }
                    try {
                        return new Pair(Integer.valueOf(Integer.parseInt(split[1])), Integer.valueOf(Integer.parseInt(split[2])));
                    } catch (NumberFormatException unused) {
                        zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: ".concat(String.valueOf(str3)));
                        return pair;
                    }
                case 1:
                case 2:
                    String str4 = zzzVar.zzk;
                    int length = split.length;
                    if (length >= 2) {
                        try {
                            if (split[1].length() == 6) {
                                parseInt = Integer.parseInt(split[1].substring(0, 2), 16);
                                parseInt2 = Integer.parseInt(split[1].substring(4), 16);
                            } else {
                                if (length < 3) {
                                    zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str4);
                                    return null;
                                }
                                parseInt = Integer.parseInt(split[1]);
                                parseInt2 = Integer.parseInt(split[2]);
                            }
                            if (parseInt == 66) {
                                i7 = 1;
                            } else if (parseInt != 77) {
                                i7 = parseInt != 88 ? parseInt != 100 ? parseInt != 110 ? parseInt != 122 ? parseInt != 244 ? -1 : 64 : 32 : 16 : 8 : 4;
                            }
                            if (i7 == -1) {
                                zzea.zzf("CodecSpecificDataUtil", "Unknown AVC profile: " + parseInt);
                                return null;
                            }
                            switch (parseInt2) {
                                case 10:
                                    i = 1;
                                    break;
                                case 11:
                                    i = 4;
                                    break;
                                case 12:
                                    i = 8;
                                    break;
                                case 13:
                                    i = 16;
                                    break;
                                default:
                                    switch (parseInt2) {
                                        case 20:
                                            i = 32;
                                            break;
                                        case 21:
                                            i = 64;
                                            break;
                                        case 22:
                                            i = 128;
                                            break;
                                        default:
                                            switch (parseInt2) {
                                                case 30:
                                                    i = 256;
                                                    break;
                                                case 31:
                                                    i = 512;
                                                    break;
                                                case 32:
                                                    i = 1024;
                                                    break;
                                                default:
                                                    switch (parseInt2) {
                                                        case 40:
                                                            i = 2048;
                                                            break;
                                                        case 41:
                                                            i = 4096;
                                                            break;
                                                        case 42:
                                                            i = 8192;
                                                            break;
                                                        default:
                                                            switch (parseInt2) {
                                                                case 50:
                                                                    i = 16384;
                                                                    break;
                                                                case 51:
                                                                    i = 32768;
                                                                    break;
                                                                case 52:
                                                                    i = 65536;
                                                                    break;
                                                                default:
                                                                    i = -1;
                                                                    break;
                                                            }
                                                    }
                                            }
                                    }
                            }
                            if (i != -1) {
                                return new Pair(Integer.valueOf(i7), Integer.valueOf(i));
                            }
                            zzea.zzf("CodecSpecificDataUtil", "Unknown AVC level: " + parseInt2);
                            return null;
                        } catch (NumberFormatException unused2) {
                            zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str4)));
                            break;
                        }
                    } else {
                        zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str4)));
                        return null;
                    }
                case 3:
                    String str5 = zzzVar.zzk;
                    if (split.length >= 3) {
                        try {
                            int parseInt3 = Integer.parseInt(split[1]);
                            int parseInt4 = Integer.parseInt(split[2]);
                            int i9 = parseInt3 != 0 ? parseInt3 != 1 ? parseInt3 != 2 ? parseInt3 != 3 ? -1 : 8 : 4 : 2 : 1;
                            if (i9 == -1) {
                                zzea.zzf("CodecSpecificDataUtil", "Unknown VP9 profile: " + parseInt3);
                                return null;
                            }
                            if (parseInt4 == 10) {
                                i7 = 1;
                            } else if (parseInt4 != 11) {
                                if (parseInt4 == 20) {
                                    i7 = 4;
                                } else if (parseInt4 == 21) {
                                    i7 = 8;
                                } else if (parseInt4 == 30) {
                                    i7 = 16;
                                } else if (parseInt4 == 31) {
                                    i7 = 32;
                                } else if (parseInt4 == 40) {
                                    i7 = 64;
                                } else if (parseInt4 == 41) {
                                    i7 = 128;
                                } else if (parseInt4 == 50) {
                                    i7 = 256;
                                } else if (parseInt4 != 51) {
                                    switch (parseInt4) {
                                        case 60:
                                            i7 = 2048;
                                            break;
                                        case 61:
                                            i7 = 4096;
                                            break;
                                        case 62:
                                            i7 = 8192;
                                            break;
                                        default:
                                            i7 = -1;
                                            break;
                                    }
                                } else {
                                    i7 = 512;
                                }
                            }
                            if (i7 != -1) {
                                return new Pair(Integer.valueOf(i9), Integer.valueOf(i7));
                            }
                            zzea.zzf("CodecSpecificDataUtil", "Unknown VP9 level: " + parseInt4);
                            return null;
                        } catch (NumberFormatException unused3) {
                            zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str5)));
                            break;
                        }
                    } else {
                        zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str5)));
                        return null;
                    }
                case 4:
                case 5:
                    return zzb(zzzVar.zzk, split, zzzVar.zzE);
                case 6:
                    String str6 = zzzVar.zzk;
                    zzk zzkVar = zzzVar.zzE;
                    if (split.length >= 4) {
                        try {
                            int parseInt5 = Integer.parseInt(split[1]);
                            int parseInt6 = Integer.parseInt(split[2].substring(0, 2));
                            int parseInt7 = Integer.parseInt(split[3]);
                            if (parseInt5 != 0) {
                                zzea.zzf("CodecSpecificDataUtil", "Unknown AV1 profile: " + parseInt5);
                                return null;
                            }
                            if (parseInt7 == 8) {
                                i2 = 1;
                            } else {
                                if (parseInt7 != 10) {
                                    zzea.zzf("CodecSpecificDataUtil", "Unknown AV1 bit depth: " + parseInt7);
                                    return null;
                                }
                                i2 = (zzkVar == null || !(zzkVar.zze != null || (i3 = zzkVar.zzd) == 7 || i3 == 6)) ? 2 : 4096;
                            }
                            switch (parseInt6) {
                                case 0:
                                    i7 = 1;
                                    break;
                                case 1:
                                    break;
                                case 2:
                                    i7 = 4;
                                    break;
                                case 3:
                                    i7 = 8;
                                    break;
                                case 4:
                                    i7 = 16;
                                    break;
                                case 5:
                                    i7 = 32;
                                    break;
                                case 6:
                                    i7 = 64;
                                    break;
                                case 7:
                                    i7 = 128;
                                    break;
                                case 8:
                                    i7 = 256;
                                    break;
                                case 9:
                                    i7 = 512;
                                    break;
                                case 10:
                                    i7 = 1024;
                                    break;
                                case 11:
                                    i7 = 2048;
                                    break;
                                case 12:
                                    i7 = 4096;
                                    break;
                                case 13:
                                    i7 = 8192;
                                    break;
                                case 14:
                                    i7 = 16384;
                                    break;
                                case 15:
                                    i7 = 32768;
                                    break;
                                case 16:
                                    i7 = 65536;
                                    break;
                                case 17:
                                    i7 = 131072;
                                    break;
                                case 18:
                                    i7 = 262144;
                                    break;
                                case 19:
                                    i7 = 524288;
                                    break;
                                case 20:
                                    i7 = 1048576;
                                    break;
                                case 21:
                                    i7 = 2097152;
                                    break;
                                case 22:
                                    i7 = 4194304;
                                    break;
                                case 23:
                                    i7 = 8388608;
                                    break;
                                default:
                                    i7 = -1;
                                    break;
                            }
                            if (i7 != -1) {
                                return new Pair(Integer.valueOf(i2), Integer.valueOf(i7));
                            }
                            zzea.zzf("CodecSpecificDataUtil", "Unknown AV1 level: " + parseInt6);
                            return null;
                        } catch (NumberFormatException unused4) {
                            zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str6)));
                            break;
                        }
                    } else {
                        zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str6)));
                        return null;
                    }
                case 7:
                    String str7 = zzzVar.zzk;
                    if (split.length == 3) {
                        try {
                            if ("audio/mp4a-latm".equals(zzay.zzd(Integer.parseInt(split[1], 16)))) {
                                int parseInt8 = Integer.parseInt(split[2]);
                                if (parseInt8 == 17) {
                                    i6 = 17;
                                } else if (parseInt8 == 20) {
                                    i6 = 20;
                                } else if (parseInt8 == 23) {
                                    i6 = 23;
                                } else if (parseInt8 == 29) {
                                    i6 = 29;
                                } else if (parseInt8 == 39) {
                                    i6 = 39;
                                } else if (parseInt8 != 42) {
                                    switch (parseInt8) {
                                        case 1:
                                            i6 = 1;
                                            break;
                                        case 2:
                                            i6 = 2;
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            i6 = 4;
                                            break;
                                        case 5:
                                            i6 = 5;
                                            break;
                                        case 6:
                                            i6 = 6;
                                            break;
                                        default:
                                            i6 = -1;
                                            break;
                                    }
                                } else {
                                    i6 = 42;
                                }
                                if (i6 != -1) {
                                    return new Pair(Integer.valueOf(i6), 0);
                                }
                            }
                            return null;
                        } catch (NumberFormatException unused5) {
                            zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str7)));
                            break;
                        }
                    } else {
                        zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str7)));
                        return null;
                    }
                case '\b':
                    if (split.length == 4) {
                        try {
                            int parseInt9 = Integer.parseInt(split[1]);
                            int parseInt10 = Integer.parseInt(split[2]);
                            int parseInt11 = Integer.parseInt(split[3]);
                            if (parseInt9 != 0) {
                                if (parseInt9 != 1) {
                                    if (parseInt9 == 2) {
                                        if (parseInt10 == 1) {
                                            i4 = 1026;
                                            i8 = 1;
                                        } else if (parseInt10 == 2) {
                                            i4 = 1028;
                                            i8 = 2;
                                        }
                                    }
                                    i8 = parseInt10;
                                    i4 = -1;
                                } else if (parseInt10 == 0) {
                                    i4 = 513;
                                } else {
                                    if (parseInt10 == 1) {
                                        i4 = EventTypeExtended.EVENT_TYPE_EXTENDED_IMPRESSION_OPPORTUNITY_VALUE;
                                        i8 = 1;
                                    }
                                    i8 = parseInt10;
                                    i4 = -1;
                                }
                                if (i4 == -1) {
                                    zzea.zzf("CodecSpecificDataUtil", "Unknown AC-4 profile: " + parseInt9 + "." + i8);
                                    return null;
                                }
                                if (parseInt11 == 0) {
                                    i5 = 1;
                                } else if (parseInt11 == 1) {
                                    i5 = 2;
                                } else if (parseInt11 == 2) {
                                    i5 = 4;
                                } else if (parseInt11 == 3) {
                                    i5 = 8;
                                } else if (parseInt11 != 4) {
                                    i5 = -1;
                                }
                                if (i5 != -1) {
                                    return new Pair(Integer.valueOf(i4), Integer.valueOf(i5));
                                }
                                zzea.zzf("CodecSpecificDataUtil", "Unknown AC-4 level: " + parseInt11);
                                return null;
                            }
                            if (parseInt10 == 0) {
                                i4 = 257;
                                if (i4 == -1) {
                                }
                            }
                            i8 = parseInt10;
                            i4 = -1;
                            if (i4 == -1) {
                            }
                        } catch (NumberFormatException unused6) {
                            zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed AC-4 codec string: ".concat(str));
                            break;
                        }
                    } else {
                        zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed AC-4 codec string: ".concat(str));
                        return null;
                    }
                default:
                    return null;
            }
            return null;
        }
        if (split.length < 3) {
            zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: ".concat(str));
            return null;
        }
        Matcher matcher = zzd.matcher(split[1]);
        if (!matcher.matches()) {
            zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: ".concat(str));
            return null;
        }
        String group = matcher.group(1);
        if (group != null) {
            int hashCode = group.hashCode();
            if (hashCode != 1567) {
                switch (hashCode) {
                    case 1536:
                        if (group.equals("00")) {
                            num = 1;
                            break;
                        }
                        break;
                    case 1537:
                        if (group.equals("01")) {
                            num = 2;
                            break;
                        }
                        break;
                    case 1538:
                        if (group.equals("02")) {
                            num = 4;
                            break;
                        }
                        break;
                    case 1539:
                        if (group.equals("03")) {
                            num = 8;
                            break;
                        }
                        break;
                    case 1540:
                        if (group.equals("04")) {
                            num = 16;
                            break;
                        }
                        break;
                    case 1541:
                        if (group.equals("05")) {
                            num = 32;
                            break;
                        }
                        break;
                    case 1542:
                        if (group.equals("06")) {
                            num = 64;
                            break;
                        }
                        break;
                    case 1543:
                        if (group.equals("07")) {
                            num = 128;
                            break;
                        }
                        break;
                    case 1544:
                        if (group.equals("08")) {
                            num = 256;
                            break;
                        }
                        break;
                    case 1545:
                        if (group.equals("09")) {
                            num = 512;
                            break;
                        }
                        break;
                }
                if (num == null) {
                    zzea.zzf("CodecSpecificDataUtil", "Unknown Dolby Vision profile string: ".concat(String.valueOf(group)));
                    return null;
                }
                String str8 = split[2];
                if (str8 != null) {
                    int hashCode2 = str8.hashCode();
                    switch (hashCode2) {
                        case 1537:
                            if (str8.equals("01")) {
                                num2 = 1;
                                break;
                            }
                            break;
                        case 1538:
                            if (str8.equals("02")) {
                                num2 = 2;
                                break;
                            }
                            break;
                        case 1539:
                            if (str8.equals("03")) {
                                num2 = 4;
                                break;
                            }
                            break;
                        case 1540:
                            if (str8.equals("04")) {
                                num2 = 8;
                                break;
                            }
                            break;
                        case 1541:
                            if (str8.equals("05")) {
                                num2 = 16;
                                break;
                            }
                            break;
                        case 1542:
                            if (str8.equals("06")) {
                                num2 = 32;
                                break;
                            }
                            break;
                        case 1543:
                            if (str8.equals("07")) {
                                num2 = 64;
                                break;
                            }
                            break;
                        case 1544:
                            if (str8.equals("08")) {
                                num2 = 128;
                                break;
                            }
                            break;
                        case 1545:
                            if (str8.equals("09")) {
                                num2 = 256;
                                break;
                            }
                            break;
                        default:
                            switch (hashCode2) {
                                case 1567:
                                    if (str8.equals("10")) {
                                        num2 = 512;
                                        break;
                                    }
                                    break;
                                case 1568:
                                    if (str8.equals("11")) {
                                        num2 = 1024;
                                        break;
                                    }
                                    break;
                                case 1569:
                                    if (str8.equals("12")) {
                                        num2 = 2048;
                                        break;
                                    }
                                    break;
                                case 1570:
                                    if (str8.equals("13")) {
                                        num2 = 4096;
                                        break;
                                    }
                                    break;
                            }
                    }
                    if (num2 == null) {
                        return new Pair(num, num2);
                    }
                    zzea.zzf("CodecSpecificDataUtil", "Unknown Dolby Vision level string: ".concat(String.valueOf(str8)));
                    return null;
                }
                num2 = null;
                if (num2 == null) {
                }
            } else if (group.equals("10")) {
                num = 1024;
                if (num == null) {
                }
            }
        }
        num = null;
        if (num == null) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00be, code lost:
    
        if (r11.equals("L123") != false) goto L108;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0260  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair zzb(String str, String[] strArr, zzk zzkVar) {
        int i;
        Integer num;
        if (strArr.length < 4) {
            zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = zzd.matcher(strArr[1]);
        if (!matcher.matches()) {
            zzea.zzf("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String group = matcher.group(1);
        char c = 6;
        if ("1".equals(group)) {
            i = 1;
        } else if ("2".equals(group)) {
            i = (zzkVar == null || zzkVar.zzd != 6) ? 2 : 4096;
        } else {
            if (!"6".equals(group)) {
                zzea.zzf("CodecSpecificDataUtil", "Unknown HEVC profile string: ".concat(String.valueOf(group)));
                return null;
            }
            i = 6;
        }
        String str2 = strArr[3];
        if (str2 != null) {
            switch (str2.hashCode()) {
                case 70821:
                    if (str2.equals("H30")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 70914:
                    if (str2.equals("H60")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 70917:
                    if (str2.equals("H63")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 71007:
                    if (str2.equals("H90")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 71010:
                    if (str2.equals("H93")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 74665:
                    if (str2.equals("L30")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 74758:
                    if (str2.equals("L60")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 74761:
                    if (str2.equals("L63")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 74851:
                    if (str2.equals("L90")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 74854:
                    if (str2.equals("L93")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 2193639:
                    if (str2.equals("H120")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 2193642:
                    if (str2.equals("H123")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 2193732:
                    if (str2.equals("H150")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 2193735:
                    if (str2.equals("H153")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 2193738:
                    if (str2.equals("H156")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 2193825:
                    if (str2.equals("H180")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case 2193828:
                    if (str2.equals("H183")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case 2193831:
                    if (str2.equals("H186")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case 2312803:
                    if (str2.equals("L120")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 2312806:
                    break;
                case 2312896:
                    if (str2.equals("L150")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 2312899:
                    if (str2.equals("L153")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 2312902:
                    if (str2.equals("L156")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 2312989:
                    if (str2.equals("L180")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 2312992:
                    if (str2.equals("L183")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 2312995:
                    if (str2.equals("L186")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    num = 1;
                    break;
                case 1:
                    num = 4;
                    break;
                case 2:
                    num = 16;
                    break;
                case 3:
                    num = 64;
                    break;
                case 4:
                    num = 256;
                    break;
                case 5:
                    num = 1024;
                    break;
                case 6:
                    num = 4096;
                    break;
                case 7:
                    num = 16384;
                    break;
                case '\b':
                    num = 65536;
                    break;
                case '\t':
                    num = 262144;
                    break;
                case '\n':
                    num = 1048576;
                    break;
                case 11:
                    num = 4194304;
                    break;
                case '\f':
                    num = 16777216;
                    break;
                case '\r':
                    num = 2;
                    break;
                case 14:
                    num = 8;
                    break;
                case 15:
                    num = 32;
                    break;
                case 16:
                    num = 128;
                    break;
                case 17:
                    num = 512;
                    break;
                case 18:
                    num = 2048;
                    break;
                case 19:
                    num = 8192;
                    break;
                case 20:
                    num = 32768;
                    break;
                case 21:
                    num = 131072;
                    break;
                case 22:
                    num = 524288;
                    break;
                case 23:
                    num = 2097152;
                    break;
                case 24:
                    num = 8388608;
                    break;
                case 25:
                    num = 33554432;
                    break;
            }
            if (num == null) {
                return new Pair(Integer.valueOf(i), num);
            }
            zzea.zzf("CodecSpecificDataUtil", "Unknown HEVC level string: ".concat(String.valueOf(str2)));
            return null;
        }
        num = null;
        if (num == null) {
        }
    }

    public static String zzc(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String zzd(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        int i5;
        Object[] objArr = {zzc[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(true != z ? 'L' : 'H'), Integer.valueOf(i4)};
        String str = zzex.zza;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int i6 = 6;
        while (true) {
            if (i6 <= 0) {
                break;
            }
            int i7 = i6 - 1;
            if (iArr[i7] != 0) {
                break;
            }
            i6 = i7;
        }
        for (i5 = 0; i5 < i6; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }

    public static byte[] zze(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2 + 4];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }
}
