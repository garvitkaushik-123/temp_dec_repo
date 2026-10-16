package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzalj implements zzakt {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzali zzc;
    private final zzen zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzalj() {
        this(null);
    }

    private static float zzb(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zzc(long j, List list, List list2) {
        int i;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    private static long zzd(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String group = matcher.group(1);
        String str2 = zzex.zza;
        long parseLong = Long.parseLong(group) * 3600000000L;
        long parseLong2 = Long.parseLong(matcher.group(2)) * 60000000;
        return parseLong + parseLong2 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0050, code lost:
    
        if (r3.equals("playresx") != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zze(zzen zzenVar, Charset charset) {
        while (true) {
            String zzz = zzenVar.zzz(charset);
            if (zzz == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(zzz)) {
                while (true) {
                    String zzz2 = zzenVar.zzz(charset);
                    if (zzz2 != null && (zzenVar.zza() == 0 || zzenVar.zze(charset) != 91)) {
                        String[] split = zzz2.split(":");
                        if (split.length == 2) {
                            char c = 0;
                            String zza2 = zzfuv.zza(split[0].trim());
                            switch (zza2.hashCode()) {
                                case 1879649548:
                                    break;
                                case 1879649549:
                                    if (zza2.equals("playresy")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            if (c == 0) {
                                this.zzf = Float.parseFloat(split[1].trim());
                            } else if (c == 1) {
                                try {
                                    this.zzg = Float.parseFloat(split[1].trim());
                                } catch (NumberFormatException unused) {
                                }
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(zzz)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                zzalk zzalkVar = null;
                while (true) {
                    String zzz3 = zzenVar.zzz(charset);
                    if (zzz3 != null && (zzenVar.zza() == 0 || zzenVar.zze(charset) != 91)) {
                        if (zzz3.startsWith("Format:")) {
                            zzalkVar = zzalk.zza(zzz3);
                        } else if (zzz3.startsWith("Style:")) {
                            if (zzalkVar == null) {
                                zzea.zzf("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(zzz3));
                            } else {
                                zzalm zzb = zzalm.zzb(zzz3, zzalkVar);
                                if (zzb != null) {
                                    linkedHashMap.put(zzb.zza, zzb);
                                }
                            }
                        }
                    }
                }
                this.zze = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(zzz)) {
                zzea.zze("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(zzz)) {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    @Override // com.google.android.gms.internal.ads.zzakt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzali zzaliVar;
        Charset charset;
        zzali zzaliVar2;
        zzen zzenVar;
        int parseInt;
        long zzd;
        float f;
        Layout.Alignment alignment;
        int i3;
        int i4;
        int i5;
        Integer num;
        int i6;
        zzalj zzaljVar = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        zzen zzenVar2 = zzaljVar.zzd;
        zzenVar2.zzJ(bArr, i + i2);
        zzenVar2.zzL(i);
        Charset zzC = zzenVar2.zzC();
        if (zzC == null) {
            zzC = StandardCharsets.UTF_8;
        }
        if (zzaljVar.zzb) {
            zzaliVar = zzaljVar.zzc;
        } else {
            zzaljVar.zze(zzenVar2, zzC);
            zzaliVar = null;
        }
        while (true) {
            String zzz = zzenVar2.zzz(zzC);
            if (zzz == null) {
                int i7 = 0;
                while (i7 < arrayList.size()) {
                    List list = (List) arrayList.get(i7);
                    if (list.isEmpty()) {
                        if (i7 != 0) {
                            i7++;
                        } else {
                            i7 = 0;
                        }
                    }
                    if (i7 == arrayList.size() - 1) {
                        throw new IllegalStateException();
                    }
                    long longValue = ((Long) arrayList2.get(i7)).longValue();
                    zzdnVar.zza(new zzakl(list, longValue, ((Long) arrayList2.get(i7 + 1)).longValue() - longValue));
                    i7++;
                }
                return;
            }
            if (zzz.startsWith("Format:")) {
                zzaliVar = zzali.zza(zzz);
            } else {
                if (zzz.startsWith("Dialogue:")) {
                    if (zzaliVar == null) {
                        zzea.zzf("SsaParser", "Skipping dialogue line before complete format: ".concat(zzz));
                    } else {
                        zzdd.zzd(zzz.startsWith("Dialogue:"));
                        String substring = zzz.substring(9);
                        int i8 = zzaliVar.zzf;
                        String[] split = substring.split(",", i8);
                        if (split.length != i8) {
                            zzea.zzf("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(zzz));
                        } else {
                            int i9 = zzaliVar.zza;
                            if (i9 != -1) {
                                try {
                                    parseInt = Integer.parseInt(split[i9].trim());
                                } catch (RuntimeException unused) {
                                    zzea.zzf("SsaParser", "Fail to parse layer: ".concat(String.valueOf(split[zzaliVar.zza])));
                                }
                                zzd = zzd(split[zzaliVar.zzb]);
                                if (zzd != -9223372036854775807L) {
                                    zzea.zzf("SsaParser", "Skipping invalid timing: ".concat(zzz));
                                } else {
                                    long zzd2 = zzd(split[zzaliVar.zzc]);
                                    if (zzd2 == -9223372036854775807L || zzd2 <= zzd) {
                                        charset = zzC;
                                        zzaliVar2 = zzaliVar;
                                        zzenVar = zzenVar2;
                                        zzea.zzf("SsaParser", "Skipping invalid timing: ".concat(zzz));
                                    } else {
                                        Map map = zzaljVar.zze;
                                        zzalm zzalmVar = (map == null || (i6 = zzaliVar.zzd) == -1) ? null : (zzalm) map.get(split[i6].trim());
                                        String str = split[zzaliVar.zze];
                                        zzall zza2 = zzall.zza(str);
                                        charset = zzC;
                                        String replace = zzall.zzb(str).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                        float f2 = zzaljVar.zzf;
                                        float f3 = zzaljVar.zzg;
                                        SpannableString spannableString = new SpannableString(replace);
                                        zzcs zzcsVar = new zzcs();
                                        zzcsVar.zzl(spannableString);
                                        zzcsVar.zzp(parseInt);
                                        if (zzalmVar != null) {
                                            Integer num2 = zzalmVar.zzc;
                                            zzaliVar2 = zzaliVar;
                                            if (num2 != null) {
                                                zzenVar = zzenVar2;
                                                f = f2;
                                                spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                            } else {
                                                zzenVar = zzenVar2;
                                                f = f2;
                                            }
                                            if (zzalmVar.zzj == 3 && (num = zzalmVar.zzd) != null) {
                                                spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                            }
                                            float f4 = zzalmVar.zze;
                                            if (f4 != -3.4028235E38f && f3 != -3.4028235E38f) {
                                                zzcsVar.zzn(f4 / f3, 1);
                                            }
                                            if (!zzalmVar.zzf) {
                                                i4 = 0;
                                                i5 = 33;
                                                if (zzalmVar.zzg) {
                                                    spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                                }
                                            } else if (zzalmVar.zzg) {
                                                i4 = 0;
                                                i5 = 33;
                                                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                            } else {
                                                i4 = 0;
                                                i5 = 33;
                                                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                            }
                                            if (zzalmVar.zzh) {
                                                spannableString.setSpan(new UnderlineSpan(), i4, spannableString.length(), i5);
                                            }
                                            if (zzalmVar.zzi) {
                                                spannableString.setSpan(new StrikethroughSpan(), i4, spannableString.length(), i5);
                                            }
                                        } else {
                                            zzaliVar2 = zzaliVar;
                                            zzenVar = zzenVar2;
                                            f = f2;
                                        }
                                        int i10 = zza2.zza;
                                        if (i10 == -1) {
                                            i10 = zzalmVar != null ? zzalmVar.zzb : -1;
                                        }
                                        switch (i10) {
                                            case 0:
                                            default:
                                                zzea.zzf("SsaParser", "Unknown alignment: " + i10);
                                            case -1:
                                                alignment = null;
                                                break;
                                            case 1:
                                            case 4:
                                            case 7:
                                                alignment = Layout.Alignment.ALIGN_NORMAL;
                                                break;
                                            case 2:
                                            case 5:
                                            case 8:
                                                alignment = Layout.Alignment.ALIGN_CENTER;
                                                break;
                                            case 3:
                                            case 6:
                                            case 9:
                                                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                                break;
                                        }
                                        zzcsVar.zzm(alignment);
                                        int i11 = Integer.MIN_VALUE;
                                        switch (i10) {
                                            case 0:
                                            default:
                                                zzea.zzf("SsaParser", "Unknown alignment: " + i10);
                                            case -1:
                                                i3 = Integer.MIN_VALUE;
                                                break;
                                            case 1:
                                            case 4:
                                            case 7:
                                                i3 = 0;
                                                break;
                                            case 2:
                                            case 5:
                                            case 8:
                                                i3 = 1;
                                                break;
                                            case 3:
                                            case 6:
                                            case 9:
                                                i3 = 2;
                                                break;
                                        }
                                        zzcsVar.zzi(i3);
                                        switch (i10) {
                                            case -1:
                                                break;
                                            case 0:
                                            default:
                                                zzea.zzf("SsaParser", "Unknown alignment: " + i10);
                                                break;
                                            case 1:
                                            case 2:
                                            case 3:
                                                i11 = 2;
                                                break;
                                            case 4:
                                            case 5:
                                            case 6:
                                                i11 = 1;
                                                break;
                                            case 7:
                                            case 8:
                                            case 9:
                                                i11 = 0;
                                                break;
                                        }
                                        zzcsVar.zzf(i11);
                                        PointF pointF = zza2.zzb;
                                        if (pointF == null || f3 == -3.4028235E38f || f == -3.4028235E38f) {
                                            zzcsVar.zzh(zzb(zzcsVar.zzb()));
                                            zzcsVar.zze(zzb(zzcsVar.zza()), 0);
                                        } else {
                                            zzcsVar.zzh(pointF.x / f);
                                            zzcsVar.zze(pointF.y / f3, 0);
                                        }
                                        zzcu zzq = zzcsVar.zzq();
                                        int zzc = zzc(zzd2, arrayList2, arrayList);
                                        for (int zzc2 = zzc(zzd, arrayList2, arrayList); zzc2 < zzc; zzc2++) {
                                            ((List) arrayList.get(zzc2)).add(zzq);
                                        }
                                    }
                                    zzaljVar = this;
                                    zzC = charset;
                                    zzaliVar = zzaliVar2;
                                    zzenVar2 = zzenVar;
                                }
                            }
                            parseInt = 0;
                            zzd = zzd(split[zzaliVar.zzb]);
                            if (zzd != -9223372036854775807L) {
                            }
                        }
                    }
                }
                charset = zzC;
                zzaliVar2 = zzaliVar;
                zzenVar = zzenVar2;
                zzaljVar = this;
                zzC = charset;
                zzaliVar = zzaliVar2;
                zzenVar2 = zzenVar;
            }
        }
    }

    public zzalj(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzen();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String zzB = zzex.zzB((byte[]) list.get(0));
        zzdd.zzd(zzB.startsWith("Format:"));
        zzali zza2 = zzali.zza(zzB);
        zza2.getClass();
        this.zzc = zza2;
        zze(new zzen((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }
}
