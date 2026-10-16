package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Pair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzalq {
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;
    public final zzalw zzf;
    public final String zzg;
    public final String zzh;
    public final zzalq zzi;
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    public static zzalq zzb(String str, long j, long j2, zzalw zzalwVar, String[] strArr, String str2, String str3, zzalq zzalqVar) {
        return new zzalq(str, null, j, j2, zzalwVar, strArr, str2, str3, zzalqVar);
    }

    public static zzalq zzc(String str) {
        return new zzalq(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    private static SpannableStringBuilder zzi(String str, Map map) {
        if (!map.containsKey(str)) {
            zzcs zzcsVar = new zzcs();
            zzcsVar.zzl(new SpannableStringBuilder());
            map.put(str, zzcsVar);
        }
        CharSequence zzr = ((zzcs) map.get(str)).zzr();
        zzr.getClass();
        return (SpannableStringBuilder) zzr;
    }

    private final void zzj(TreeSet treeSet, boolean z) {
        String str = this.zza;
        boolean equals = "p".equals(str);
        boolean equals2 = "div".equals(str);
        if (z || equals || (equals2 && this.zzh != null)) {
            long j = this.zzd;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.zze;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.zzm != null) {
            for (int i = 0; i < this.zzm.size(); i++) {
                zzalq zzalqVar = (zzalq) this.zzm.get(i);
                boolean z2 = true;
                if (!z && !equals) {
                    z2 = false;
                }
                zzalqVar.zzj(treeSet, z2);
            }
        }
    }

    private final void zzk(long j, String str, List list) {
        String str2;
        String str3 = this.zzg;
        if (true != "".equals(str3)) {
            str = str3;
        }
        if (zzg(j) && "div".equals(this.zza) && (str2 = this.zzh) != null) {
            list.add(new Pair(str, str2));
            return;
        }
        for (int i = 0; i < zza(); i++) {
            zzd(i).zzk(j, str, list);
        }
    }

    private final void zzl(long j, Map map, Map map2, String str, Map map3) {
        Iterator it;
        zzalq zzalqVar;
        zzalw zza;
        boolean z;
        int i;
        Map map4 = map;
        if (zzg(j)) {
            String str2 = this.zzg;
            String str3 = true != "".equals(str2) ? str2 : str;
            Iterator it2 = this.zzl.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                String str4 = (String) entry.getKey();
                HashMap hashMap = this.zzk;
                int intValue = hashMap.containsKey(str4) ? ((Integer) hashMap.get(str4)).intValue() : 0;
                int intValue2 = ((Integer) entry.getValue()).intValue();
                if (intValue != intValue2) {
                    zzcs zzcsVar = (zzcs) map3.get(str4);
                    zzcsVar.getClass();
                    zzalu zzaluVar = (zzalu) map2.get(str3);
                    zzaluVar.getClass();
                    int i2 = zzaluVar.zzj;
                    zzalw zza2 = zzalv.zza(this.zzf, this.zzj, map4);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzcsVar.zzr();
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        zzcsVar.zzl(spannableStringBuilder);
                    }
                    if (zza2 != null) {
                        zzalq zzalqVar2 = this.zzi;
                        if (zza2.zzh() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(zza2.zzh()), intValue, intValue2, 33);
                        }
                        if (zza2.zzM()) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, 33);
                        }
                        if (zza2.zzN()) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, 33);
                        }
                        if (zza2.zzL()) {
                            zzda.zzb(spannableStringBuilder, new ForegroundColorSpan(zza2.zzd()), intValue, intValue2, 33);
                        }
                        if (zza2.zzK()) {
                            zzda.zzb(spannableStringBuilder, new BackgroundColorSpan(zza2.zzc()), intValue, intValue2, 33);
                        }
                        if (zza2.zzG() != null) {
                            zzda.zzb(spannableStringBuilder, new TypefaceSpan(zza2.zzG()), intValue, intValue2, 33);
                        }
                        if (zza2.zzk() != null) {
                            zzalp zzk = zza2.zzk();
                            zzk.getClass();
                            int i3 = zzk.zza;
                            it = it2;
                            if (i3 == -1) {
                                i3 = (i2 == 2 || i2 == 1) ? 3 : 1;
                                i = 1;
                            } else {
                                i = zzk.zzb;
                            }
                            int i4 = zzk.zzc;
                            if (i4 == -2) {
                                i4 = 1;
                            }
                            zzda.zzb(spannableStringBuilder, new zzdb(i3, i, i4), intValue, intValue2, 33);
                        } else {
                            it = it2;
                        }
                        int zzg = zza2.zzg();
                        if (zzg == 2) {
                            while (true) {
                                if (zzalqVar2 == null) {
                                    zzalqVar2 = null;
                                    break;
                                }
                                zzalw zza3 = zzalv.zza(zzalqVar2.zzf, zzalqVar2.zzj, map4);
                                if (zza3 != null && zza3.zzg() == 1) {
                                    break;
                                } else {
                                    zzalqVar2 = zzalqVar2.zzi;
                                }
                            }
                            if (zzalqVar2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(zzalqVar2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        zzalqVar = null;
                                        break;
                                    }
                                    zzalq zzalqVar3 = (zzalq) arrayDeque.pop();
                                    zzalw zza4 = zzalv.zza(zzalqVar3.zzf, zzalqVar3.zzj, map4);
                                    if (zza4 != null && zza4.zzg() == 3) {
                                        zzalqVar = zzalqVar3;
                                        break;
                                    }
                                    for (int zza5 = zzalqVar3.zza() - 1; zza5 >= 0; zza5--) {
                                        arrayDeque.push(zzalqVar3.zzd(zza5));
                                    }
                                }
                                if (zzalqVar != null) {
                                    if (zzalqVar.zza() != 1 || zzalqVar.zzd(0).zzb == null) {
                                        zzea.zze("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str5 = zzalqVar.zzd(0).zzb;
                                        String str6 = zzex.zza;
                                        zzalw zza6 = zzalv.zza(zzalqVar.zzf, zzalqVar.zzj, map4);
                                        int zzf = zza6 != null ? zza6.zzf() : -1;
                                        if (zzf == -1 && (zza = zzalv.zza(zzalqVar2.zzf, zzalqVar2.zzj, map4)) != null) {
                                            zzf = zza.zzf();
                                        }
                                        spannableStringBuilder.setSpan(new zzcz(str5, zzf), intValue, intValue2, 33);
                                    }
                                }
                            }
                        } else if (zzg == 3 || zzg == 4) {
                            spannableStringBuilder.setSpan(new zzalo(), intValue, intValue2, 33);
                        }
                        if (zza2.zzJ()) {
                            zzda.zzb(spannableStringBuilder, new zzcy(), intValue, intValue2, 33);
                        }
                        int zze = zza2.zze();
                        if (zze != 1) {
                            if (zze == 2) {
                                zzda.zzb(spannableStringBuilder, new RelativeSizeSpan(zza2.zza()), intValue, intValue2, 33);
                            } else if (zze == 3) {
                                zzda.zza(spannableStringBuilder, zza2.zza() / 100.0f, intValue, intValue2, 33);
                            }
                            z = true;
                        } else {
                            z = true;
                            zzda.zzb(spannableStringBuilder, new AbsoluteSizeSpan((int) zza2.zza(), true), intValue, intValue2, 33);
                        }
                        if ("p".equals(this.zza)) {
                            if (zza2.zzb() != Float.MAX_VALUE) {
                                zzcsVar.zzj((zza2.zzb() * (-90.0f)) / 100.0f);
                            }
                            if (zza2.zzj() != null) {
                                zzcsVar.zzm(zza2.zzj());
                            }
                            if (zza2.zzi() != null) {
                                zzcsVar.zzg(zza2.zzi());
                            }
                        }
                        it2 = it;
                    }
                }
            }
            int i5 = 0;
            while (i5 < zza()) {
                zzd(i5).zzl(j, map4, map2, str3, map3);
                i5++;
                map4 = map;
            }
        }
    }

    private final void zzm(long j, boolean z, String str, Map map) {
        long j2;
        boolean z2;
        HashMap hashMap = this.zzk;
        hashMap.clear();
        HashMap hashMap2 = this.zzl;
        hashMap2.clear();
        String str2 = this.zza;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.zzg;
        String str4 = true != "".equals(str3) ? str3 : str;
        if (this.zzc && z) {
            SpannableStringBuilder zzi = zzi(str4, map);
            String str5 = this.zzb;
            str5.getClass();
            zzi.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z) {
            zzi(str4, map).append('\n');
            return;
        }
        if (zzg(j)) {
            for (Map.Entry entry : map.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence zzr = ((zzcs) entry.getValue()).zzr();
                zzr.getClass();
                hashMap.put(str6, Integer.valueOf(zzr.length()));
            }
            boolean equals = "p".equals(str2);
            for (int i = 0; i < zza(); i++) {
                zzalq zzd = zzd(i);
                if (z || equals) {
                    j2 = j;
                    z2 = true;
                } else {
                    j2 = j;
                    z2 = false;
                }
                zzd.zzm(j2, z2, str4, map);
            }
            if (equals) {
                SpannableStringBuilder zzi2 = zzi(str4, map);
                int length = zzi2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (zzi2.charAt(length) == ' ');
                if (length >= 0 && zzi2.charAt(length) != '\n') {
                    zzi2.append('\n');
                }
            }
            for (Map.Entry entry2 : map.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence zzr2 = ((zzcs) entry2.getValue()).zzr();
                zzr2.getClass();
                hashMap2.put(str7, Integer.valueOf(zzr2.length()));
            }
        }
    }

    public final int zza() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final zzalq zzd(int i) {
        List list = this.zzm;
        if (list != null) {
            return (zzalq) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List zze(long j, Map map, Map map2, Map map3) {
        List arrayList = new ArrayList();
        String str = this.zzg;
        zzk(j, str, arrayList);
        TreeMap treeMap = new TreeMap();
        zzm(j, false, str, treeMap);
        zzl(j, map, map2, str, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) arrayList.get(i);
            String str2 = (String) map3.get(pair.second);
            if (str2 != null) {
                byte[] decode = Base64.decode(str2, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                zzalu zzaluVar = (zzalu) map2.get(pair.first);
                zzaluVar.getClass();
                zzcs zzcsVar = new zzcs();
                zzcsVar.zzc(decodeByteArray);
                zzcsVar.zzh(zzaluVar.zzb);
                zzcsVar.zzi(0);
                zzcsVar.zze(zzaluVar.zzc, 0);
                zzcsVar.zzf(zzaluVar.zze);
                zzcsVar.zzk(zzaluVar.zzf);
                zzcsVar.zzd(zzaluVar.zzg);
                zzcsVar.zzo(zzaluVar.zzj);
                arrayList2.add(zzcsVar.zzq());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzalu zzaluVar2 = (zzalu) map2.get(entry.getKey());
            zzaluVar2.getClass();
            zzcs zzcsVar2 = (zzcs) entry.getValue();
            CharSequence zzr = zzcsVar2.zzr();
            zzr.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzr;
            for (zzalo zzaloVar : (zzalo[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzalo.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzaloVar), spannableStringBuilder.getSpanEnd(zzaloVar), (CharSequence) "");
            }
            int i2 = 0;
            while (i2 < spannableStringBuilder.length()) {
                int i3 = i2 + 1;
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
                i2 = i3;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i6 = 0;
            while (i6 < spannableStringBuilder.length() - 1) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i6) == '\n' && spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
                i6 = i7;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i8 = 0;
            while (i8 < spannableStringBuilder.length() - 1) {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i9) == '\n') {
                    spannableStringBuilder.delete(i8, i9);
                }
                i8 = i9;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzcsVar2.zze(zzaluVar2.zzc, zzaluVar2.zzd);
            zzcsVar2.zzf(zzaluVar2.zze);
            zzcsVar2.zzh(zzaluVar2.zzb);
            zzcsVar2.zzk(zzaluVar2.zzf);
            zzcsVar2.zzn(zzaluVar2.zzi, zzaluVar2.zzh);
            zzcsVar2.zzo(zzaluVar2.zzj);
            arrayList2.add(zzcsVar2.zzq());
        }
        return arrayList2;
    }

    public final void zzf(zzalq zzalqVar) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzalqVar);
    }

    public final boolean zzg(long j) {
        long j2 = this.zzd;
        if (j2 == -9223372036854775807L) {
            if (this.zze == -9223372036854775807L) {
                return true;
            }
            j2 = -9223372036854775807L;
        }
        if (j2 <= j && this.zze == -9223372036854775807L) {
            return true;
        }
        if (j2 != -9223372036854775807L || j >= this.zze) {
            return j2 <= j && j < this.zze;
        }
        return true;
    }

    public final long[] zzh() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        zzj(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    private zzalq(String str, String str2, long j, long j2, zzalw zzalwVar, String[] strArr, String str3, String str4, zzalq zzalqVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzalwVar;
        this.zzj = strArr;
        this.zzc = str2 != null;
        this.zzd = j;
        this.zze = j2;
        str3.getClass();
        this.zzg = str3;
        this.zzi = zzalqVar;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }
}
