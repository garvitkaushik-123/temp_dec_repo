package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.accessibility.CaptioningManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzyu extends zzza implements zzmc {
    public static final /* synthetic */ int zzb = 0;
    private static final zzgab zzc = zzgab.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzxu
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            int i = zzyu.zzb;
            if (num.intValue() == -1) {
                return num2.intValue() == -1 ? 0 : -1;
            }
            if (num2.intValue() == -1) {
                return 1;
            }
            return num.intValue() - num2.intValue();
        }
    });
    public final Context zza;
    private final Object zzd;
    private zzyi zze;
    private Thread zzf;
    private zzym zzg;
    private zze zzh;
    private final zzxq zzi;

    public zzyu(Context context) {
        zzxq zzxqVar = new zzxq();
        zzyi zzyiVar = zzyi.zzF;
        this.zzd = new Object();
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzi = zzxqVar;
        if (zzyiVar instanceof zzyi) {
            this.zze = zzyiVar;
        } else {
            zzyh zzyhVar = new zzyh(zzyiVar, null);
            zzyhVar.zzw(zzyiVar);
            this.zze = new zzyi(zzyhVar);
        }
        this.zzh = zze.zza;
        if (this.zze.zzQ && context == null) {
            zzea.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    static /* bridge */ /* synthetic */ int zzb(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    protected static int zzc(zzz zzzVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzzVar.zzd)) {
            return 4;
        }
        String zzh = zzh(str);
        String zzh2 = zzh(zzzVar.zzd);
        if (zzh2 == null || zzh == null) {
            return (z && zzh2 == null) ? 1 : 0;
        }
        if (zzh2.startsWith(zzh) || zzh.startsWith(zzh2)) {
            return 3;
        }
        String str2 = zzex.zza;
        return zzh2.split("-", 2)[0].equals(zzh.split("-", 2)[0]) ? 2 : 0;
    }

    protected static String zzh(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static /* synthetic */ boolean zzm(zzyu zzyuVar, zzyi zzyiVar, zzz zzzVar) {
        zzym zzymVar;
        zzym zzymVar2;
        if (zzyiVar.zzQ) {
            int i = zzzVar.zzG;
            char c = 65535;
            if (i != -1 && i > 2) {
                String str = zzzVar.zzo;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -2123537834:
                            if (str.equals("audio/eac3-joc")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 187078296:
                            if (str.equals("audio/ac3")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 187078297:
                            if (str.equals("audio/ac4")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 1504578661:
                            if (str.equals("audio/eac3")) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    if ((c == 0 || c == 1 || c == 2 || c == 3) && (Build.VERSION.SDK_INT < 32 || (zzymVar2 = zzyuVar.zzg) == null || !zzymVar2.zze())) {
                        return true;
                    }
                }
                return Build.VERSION.SDK_INT >= 32 && (zzymVar = zzyuVar.zzg) != null && zzymVar.zze() && zzymVar.zzc() && zzyuVar.zzg.zzd() && zzyuVar.zzg.zzb(zzyuVar.zzh, zzzVar);
            }
        }
        return true;
    }

    private static void zzt(zzxk zzxkVar, zzbr zzbrVar, Map map) {
        for (int i = 0; i < zzxkVar.zzb; i++) {
            if (((zzbn) zzbrVar.zzD.get(zzxkVar.zzb(i))) != null) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzu() {
        boolean z;
        zzym zzymVar;
        synchronized (this.zzd) {
            z = false;
            if (this.zze.zzQ && Build.VERSION.SDK_INT >= 32 && (zzymVar = this.zzg) != null && zzymVar.zze()) {
                z = true;
            }
        }
        if (z) {
            zzs();
        }
    }

    private static final Pair zzv(int i, zzyz zzyzVar, int[][][] iArr, zzyo zzyoVar, Comparator comparator) {
        RandomAccess randomAccess;
        zzyz zzyzVar2 = zzyzVar;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < 2) {
            if (i == zzyzVar2.zzc(i2)) {
                zzxk zzd = zzyzVar2.zzd(i2);
                for (int i3 = 0; i3 < zzd.zzb; i3++) {
                    zzbm zzb2 = zzd.zzb(i3);
                    List zza = zzyoVar.zza(i2, zzb2, iArr[i2][i3]);
                    int i4 = zzb2.zza;
                    boolean[] zArr = new boolean[i4];
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = i5 + 1;
                        zzyp zzypVar = (zzyp) zza.get(i5);
                        int zzb3 = zzypVar.zzb();
                        if (!zArr[i5] && zzb3 != 0) {
                            if (zzb3 == 1) {
                                randomAccess = zzfyq.zzo(zzypVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzypVar);
                                for (int i7 = i6; i7 < i4; i7++) {
                                    zzyp zzypVar2 = (zzyp) zza.get(i7);
                                    if (zzypVar2.zzb() == 2 && zzypVar.zzc(zzypVar2)) {
                                        arrayList2.add(zzypVar2);
                                        zArr[i7] = true;
                                    }
                                }
                                randomAccess = arrayList2;
                            }
                            arrayList.add(randomAccess);
                        }
                        i5 = i6;
                    }
                }
            }
            i2++;
            zzyzVar2 = zzyzVar;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            iArr2[i8] = ((zzyp) list.get(i8)).zzc;
        }
        zzyp zzypVar3 = (zzyp) list.get(0);
        return Pair.create(new zzyv(zzypVar3.zzb, iArr2, 0), Integer.valueOf(zzypVar3.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzmc
    public final void zza(zzma zzmaVar) {
        synchronized (this.zzd) {
            boolean z = this.zze.zzU;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzza
    protected final Pair zzd(zzyz zzyzVar, int[][][] iArr, final int[] iArr2, zzvh zzvhVar, zzbl zzblVar) throws zzin {
        final zzyi zzyiVar;
        int i;
        final boolean z;
        final String str;
        int[] iArr3;
        int length;
        Context context;
        CaptioningManager captioningManager;
        Locale locale;
        Context context2;
        synchronized (this.zzd) {
            this.zzf = Thread.currentThread();
            zzyiVar = this.zze;
        }
        if (zzyiVar.zzQ && Build.VERSION.SDK_INT >= 32 && this.zzg == null) {
            this.zzg = new zzym(this.zza, this);
        }
        int i2 = 2;
        zzyv[] zzyvVarArr = new zzyv[2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = 1;
            if (i4 >= 2) {
                z = false;
                break;
            }
            if (zzyzVar.zzc(i4) == 2 && zzyzVar.zzd(i4).zzb > 0) {
                z = true;
                break;
            }
            i4++;
        }
        Pair zzv = zzv(1, zzyzVar, iArr, new zzyo() { // from class: com.google.android.gms.internal.ads.zzxz
            @Override // com.google.android.gms.internal.ads.zzyo
            public final List zza(int i5, zzbm zzbmVar, int[] iArr4) {
                final zzyu zzyuVar = zzyu.this;
                final zzyi zzyiVar2 = zzyiVar;
                zzfvq zzfvqVar = new zzfvq() { // from class: com.google.android.gms.internal.ads.zzyb
                    @Override // com.google.android.gms.internal.ads.zzfvq
                    public final boolean zza(Object obj) {
                        return zzyu.zzm(zzyu.this, zzyiVar2, (zzz) obj);
                    }
                };
                int i6 = iArr2[i5];
                int i7 = zzfyq.zzd;
                zzfyn zzfynVar = new zzfyn();
                for (int i8 = 0; i8 < zzbmVar.zza; i8++) {
                    zzfynVar.zzf(new zzye(i5, zzbmVar, i8, zzyiVar2, iArr4[i8], z, zzfvqVar, i6));
                }
                return zzfynVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzya
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzye) Collections.max((List) obj)).zza((zzye) Collections.max((List) obj2));
            }
        });
        if (zzv != null) {
            zzyvVarArr[((Integer) zzv.second).intValue()] = (zzyv) zzv.first;
        }
        final String str2 = zzv == null ? null : ((zzyv) zzv.first).zza.zzb(((zzyv) zzv.first).zzb[0]).zzd;
        int i5 = zzyiVar.zzu.zzb;
        final Point zzw = (!zzyiVar.zzk || (context2 = this.zza) == null) ? null : zzex.zzw(context2);
        Pair zzv2 = zzv(2, zzyzVar, iArr, new zzyo() { // from class: com.google.android.gms.internal.ads.zzxx
            /* JADX WARN: Removed duplicated region for block: B:44:0x0057  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0063  */
            @Override // com.google.android.gms.internal.ads.zzyo
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final List zza(int i6, zzbm zzbmVar, int[] iArr4) {
                int i7;
                int i8;
                int i9;
                boolean z2;
                int i10;
                int i11;
                int i12;
                Point point;
                int i13;
                zzbm zzbmVar2 = zzbmVar;
                int i14 = zzyu.zzb;
                zzyi zzyiVar2 = zzyi.this;
                int i15 = iArr2[i6];
                Point point2 = zzw;
                int i16 = point2 != null ? point2.x : zzyiVar2.zzi;
                int i17 = point2 != null ? point2.y : zzyiVar2.zzj;
                boolean z3 = zzyiVar2.zzl;
                if (i16 == Integer.MAX_VALUE) {
                    i7 = -1;
                    i8 = Integer.MAX_VALUE;
                } else if (i17 == Integer.MAX_VALUE) {
                    i8 = Integer.MAX_VALUE;
                    i7 = -1;
                } else {
                    int i18 = Integer.MAX_VALUE;
                    for (int i19 = 0; i19 < zzbmVar2.zza; i19++) {
                        zzz zzb2 = zzbmVar2.zzb(i19);
                        int i20 = zzb2.zzv;
                        if (i20 > 0 && (i10 = zzb2.zzw) > 0) {
                            if (z3) {
                                if ((i20 > i10) != (i16 > i17)) {
                                    i12 = i17;
                                    i11 = i16;
                                    if (i20 * i11 < i10 * i12) {
                                        String str3 = zzex.zza;
                                        point = new Point(i12, ((r10 + i20) - 1) / i20);
                                    } else {
                                        String str4 = zzex.zza;
                                        point = new Point(((r12 + i10) - 1) / i10, i11);
                                    }
                                    i13 = i20 * i10;
                                    if (i20 >= ((int) (point.x * 0.98f)) && i10 >= ((int) (point.y * 0.98f)) && i13 < i18) {
                                        i18 = i13;
                                    }
                                }
                            }
                            i11 = i17;
                            i12 = i16;
                            if (i20 * i11 < i10 * i12) {
                            }
                            i13 = i20 * i10;
                            if (i20 >= ((int) (point.x * 0.98f))) {
                                i18 = i13;
                            }
                        }
                    }
                    i7 = -1;
                    i8 = i18;
                }
                int i21 = zzfyq.zzd;
                zzfyn zzfynVar = new zzfyn();
                int i22 = 0;
                while (i22 < zzbmVar2.zza) {
                    int zza = zzbmVar2.zzb(i22).zza();
                    if (i8 != Integer.MAX_VALUE) {
                        i9 = i7;
                        if (zza == i9 || zza > i8) {
                            z2 = false;
                            zzfynVar.zzf(new zzys(i6, zzbmVar2, i22, zzyiVar2, iArr4[i22], str2, i15, z2));
                            i22++;
                            zzbmVar2 = zzbmVar;
                            i7 = i9;
                        }
                    } else {
                        i9 = i7;
                    }
                    z2 = true;
                    zzfynVar.zzf(new zzys(i6, zzbmVar2, i22, zzyiVar2, iArr4[i22], str2, i15, z2));
                    i22++;
                    zzbmVar2 = zzbmVar;
                    i7 = i9;
                }
                return zzfynVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxy
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                List list = (List) obj;
                List list2 = (List) obj2;
                return zzfyf.zzj().zzc((zzys) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyq
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzys.zzd((zzys) obj3, (zzys) obj4);
                    }
                }), (zzys) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyq
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzys.zzd((zzys) obj3, (zzys) obj4);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzyq
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzys.zzd((zzys) obj3, (zzys) obj4);
                    }
                }).zzb(list.size(), list2.size()).zzc((zzys) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyr
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzys.zza((zzys) obj3, (zzys) obj4);
                    }
                }), (zzys) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyr
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzys.zza((zzys) obj3, (zzys) obj4);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzyr
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzys.zza((zzys) obj3, (zzys) obj4);
                    }
                }).zza();
            }
        });
        boolean z2 = zzyiVar.zzA;
        int i6 = 4;
        Pair zzv3 = zzv2 == null ? zzv(4, zzyzVar, iArr, new zzyo() { // from class: com.google.android.gms.internal.ads.zzxv
            @Override // com.google.android.gms.internal.ads.zzyo
            public final List zza(int i7, zzbm zzbmVar, int[] iArr4) {
                int i8 = zzyu.zzb;
                int i9 = zzfyq.zzd;
                zzfyn zzfynVar = new zzfyn();
                for (int i10 = 0; i10 < zzbmVar.zza; i10++) {
                    zzfynVar.zzf(new zzyf(i7, zzbmVar, i10, zzyi.this, iArr4[i10]));
                }
                return zzfynVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxw
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzyf) ((List) obj).get(0)).compareTo((zzyf) ((List) obj2).get(0));
            }
        }) : null;
        if (zzv3 != null) {
            zzyvVarArr[((Integer) zzv3.second).intValue()] = (zzyv) zzv3.first;
        } else if (zzv2 != null) {
            zzyvVarArr[((Integer) zzv2.second).intValue()] = (zzyv) zzv2.first;
        }
        if (!zzyiVar.zzx || (context = this.zza) == null || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
            str = null;
        } else {
            String str3 = zzex.zza;
            str = locale.toLanguageTag();
        }
        int i7 = 3;
        Pair zzv4 = zzv(3, zzyzVar, iArr, new zzyo() { // from class: com.google.android.gms.internal.ads.zzyc
            @Override // com.google.android.gms.internal.ads.zzyo
            public final List zza(int i8, zzbm zzbmVar, int[] iArr4) {
                int i9 = zzyu.zzb;
                int i10 = zzfyq.zzd;
                zzfyn zzfynVar = new zzfyn();
                for (int i11 = 0; i11 < zzbmVar.zza; i11++) {
                    zzfynVar.zzf(new zzyn(i8, zzbmVar, i11, zzyi.this, iArr4[i11], str2, str));
                }
                return zzfynVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyd
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzyn) ((List) obj).get(0)).zza((zzyn) ((List) obj2).get(0));
            }
        });
        if (zzv4 != null) {
            zzyvVarArr[((Integer) zzv4.second).intValue()] = (zzyv) zzv4.first;
        }
        int i8 = 0;
        while (i8 < i2) {
            int zzc2 = zzyzVar.zzc(i8);
            if (zzc2 != i2 && zzc2 != i && zzc2 != i7 && zzc2 != i6) {
                zzxk zzd = zzyzVar.zzd(i8);
                int[][] iArr4 = iArr[i8];
                int i9 = i3;
                int i10 = i9;
                zzbm zzbmVar = null;
                zzyg zzygVar = null;
                while (i9 < zzd.zzb) {
                    zzbm zzb2 = zzd.zzb(i9);
                    int[] iArr5 = iArr4[i9];
                    zzyg zzygVar2 = zzygVar;
                    for (int i11 = i3; i11 < zzb2.zza; i11++) {
                        if (zzmb.zza(iArr5[i11], zzyiVar.zzR)) {
                            zzyg zzygVar3 = new zzyg(zzb2.zzb(i11), iArr5[i11]);
                            if (zzygVar2 == null || zzygVar3.compareTo(zzygVar2) > 0) {
                                zzbmVar = zzb2;
                                zzygVar2 = zzygVar3;
                                i10 = i11;
                            }
                        }
                    }
                    i9++;
                    zzygVar = zzygVar2;
                    i3 = 0;
                }
                zzyvVarArr[i8] = zzbmVar == null ? null : new zzyv(zzbmVar, new int[]{i10}, 0);
            }
            i8++;
            i2 = 2;
            i3 = 0;
            i7 = 3;
            i = 1;
            i6 = 4;
        }
        HashMap hashMap = new HashMap();
        int i12 = 2;
        for (int i13 = 0; i13 < 2; i13++) {
            zzt(zzyzVar.zzd(i13), zzyiVar, hashMap);
        }
        zzt(zzyzVar.zze(), zzyiVar, hashMap);
        for (int i14 = 0; i14 < 2; i14++) {
            if (((zzbn) hashMap.get(Integer.valueOf(zzyzVar.zzc(i14)))) != null) {
                throw null;
            }
        }
        int i15 = 0;
        while (i15 < i12) {
            zzxk zzd2 = zzyzVar.zzd(i15);
            if (zzyiVar.zzf(i15, zzd2)) {
                if (zzyiVar.zzd(i15, zzd2) != null) {
                    throw null;
                }
                zzyvVarArr[i15] = null;
            }
            i15++;
            i12 = 2;
        }
        int i16 = 0;
        while (i16 < i12) {
            int zzc3 = zzyzVar.zzc(i16);
            if (zzyiVar.zze(i16) || zzyiVar.zzE.contains(Integer.valueOf(zzc3))) {
                zzyvVarArr[i16] = null;
            }
            i16++;
            i12 = 2;
        }
        zzxq zzxqVar = this.zzi;
        zzzl zzq = zzq();
        zzfyq zzd3 = zzxr.zzd(zzyvVarArr);
        int i17 = 2;
        zzyw[] zzywVarArr = new zzyw[2];
        int i18 = 0;
        while (i18 < i17) {
            zzyv zzyvVar = zzyvVarArr[i18];
            if (zzyvVar != null && (length = (iArr3 = zzyvVar.zzb).length) != 0) {
                zzywVarArr[i18] = length == 1 ? new zzyx(zzyvVar.zza, iArr3[0], 0, 0, null) : zzxqVar.zza(zzyvVar.zza, iArr3, 0, zzq, (zzfyq) zzd3.get(i18));
            }
            i18++;
            i17 = 2;
        }
        zzme[] zzmeVarArr = new zzme[i17];
        for (int i19 = 0; i19 < i17; i19++) {
            zzmeVarArr[i19] = (zzyiVar.zze(i19) || zzyiVar.zzE.contains(Integer.valueOf(zzyzVar.zzc(i19))) || (zzyzVar.zzc(i19) != -2 && zzywVarArr[i19] == null)) ? null : zzme.zza;
        }
        boolean z3 = zzyiVar.zzS;
        return Pair.create(zzmeVarArr, zzywVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final zzmc zze() {
        return this;
    }

    public final zzyi zzf() {
        zzyi zzyiVar;
        synchronized (this.zzd) {
            zzyiVar = this.zze;
        }
        return zzyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void zzj() {
        zzym zzymVar;
        synchronized (this.zzd) {
            Thread thread = this.zzf;
            if (thread != null) {
                zzdd.zzg(thread == Thread.currentThread(), "DefaultTrackSelector is accessed on the wrong thread.");
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (zzymVar = this.zzg) != null) {
            zzymVar.zza();
            this.zzg = null;
        }
        super.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void zzk(zze zzeVar) {
        if (this.zzh.equals(zzeVar)) {
            return;
        }
        this.zzh = zzeVar;
        zzu();
    }

    public final void zzl(zzyh zzyhVar) {
        boolean equals;
        zzyi zzyiVar = new zzyi(zzyhVar);
        synchronized (this.zzd) {
            equals = this.zze.equals(zzyiVar);
            this.zze = zzyiVar;
        }
        if (equals) {
            return;
        }
        if (zzyiVar.zzQ && this.zza == null) {
            zzea.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean zzn() {
        return true;
    }
}
