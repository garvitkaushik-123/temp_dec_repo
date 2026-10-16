package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzvz extends zzup {
    private static final zzap zza;
    private final zzvj[] zzb;
    private final List zzc;
    private final zzbl[] zzd;
    private final ArrayList zze;
    private int zzf = -1;
    private long[][] zzg;
    private zzvw zzh;
    private final zzus zzi;

    static {
        zzad zzadVar = new zzad();
        zzadVar.zza("MergingMediaSource");
        zza = zzadVar.zzc();
    }

    public zzvz(boolean z, boolean z2, zzus zzusVar, zzvj... zzvjVarArr) {
        this.zzb = zzvjVarArr;
        this.zzi = zzusVar;
        this.zze = new ArrayList(Arrays.asList(zzvjVarArr));
        this.zzc = new ArrayList(zzvjVarArr.length);
        int i = 0;
        while (true) {
            int length = zzvjVarArr.length;
            if (i >= length) {
                this.zzd = new zzbl[length];
                this.zzg = new long[0][];
                new HashMap();
                zzfzw.zzb(8).zzb(2).zza();
                return;
            }
            this.zzc.add(new ArrayList());
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    protected final /* bridge */ /* synthetic */ void zzA(Object obj, zzvj zzvjVar, zzbl zzblVar) {
        int i;
        Integer num = (Integer) obj;
        if (this.zzh != null) {
            return;
        }
        if (this.zzf == -1) {
            i = zzblVar.zzb();
            this.zzf = i;
        } else {
            int zzb = zzblVar.zzb();
            int i2 = this.zzf;
            if (zzb != i2) {
                this.zzh = new zzvw(0);
                return;
            }
            i = i2;
        }
        if (this.zzg.length == 0) {
            this.zzg = (long[][]) Array.newInstance((Class<?>) Long.TYPE, i, this.zzd.length);
        }
        ArrayList arrayList = this.zze;
        arrayList.remove(zzvjVar);
        zzbl[] zzblVarArr = this.zzd;
        zzblVarArr[num.intValue()] = zzblVar;
        if (arrayList.isEmpty()) {
            zzo(zzblVarArr[0]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzG(zzvf zzvfVar) {
        zzvf zzvfVar2;
        zzvv zzvvVar = (zzvv) zzvfVar;
        int i = 0;
        while (true) {
            zzvj[] zzvjVarArr = this.zzb;
            if (i >= zzvjVarArr.length) {
                return;
            }
            List list = (List) this.zzc.get(i);
            zzvf zzn = zzvvVar.zzn(i);
            int i2 = 0;
            while (true) {
                if (i2 < list.size()) {
                    zzvfVar2 = ((zzvx) list.get(i2)).zzb;
                    if (zzvfVar2.equals(zzn)) {
                        list.remove(i2);
                        break;
                    }
                    i2++;
                }
            }
            zzvjVarArr[i].zzG(zzvvVar.zzn(i));
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final zzvf zzI(zzvh zzvhVar, zzzm zzzmVar, long j) {
        zzbl[] zzblVarArr = this.zzd;
        zzvj[] zzvjVarArr = this.zzb;
        int length = zzvjVarArr.length;
        zzvf[] zzvfVarArr = new zzvf[length];
        int zza2 = zzblVarArr[0].zza(zzvhVar.zza);
        for (int i = 0; i < length; i++) {
            zzvh zza3 = zzvhVar.zza(zzblVarArr[i].zzf(zza2));
            zzvfVarArr[i] = zzvjVarArr[i].zzI(zza3, zzzmVar, j - this.zzg[zza2][i]);
            ((List) this.zzc.get(i)).add(new zzvx(zza3, zzvfVarArr[i], null));
        }
        return new zzvv(this.zzi, this.zzg[zza2], zzvfVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final zzap zzJ() {
        zzvj[] zzvjVarArr = this.zzb;
        return zzvjVarArr.length > 0 ? zzvjVarArr[0].zzJ() : zza;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzug
    protected final void zzn(zzhj zzhjVar) {
        super.zzn(zzhjVar);
        int i = 0;
        while (true) {
            zzvj[] zzvjVarArr = this.zzb;
            if (i >= zzvjVarArr.length) {
                return;
            }
            zzB(Integer.valueOf(i), zzvjVarArr[i]);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzug
    protected final void zzq() {
        super.zzq();
        Arrays.fill(this.zzd, (Object) null);
        this.zzf = -1;
        this.zzh = null;
        ArrayList arrayList = this.zze;
        arrayList.clear();
        Collections.addAll(arrayList, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvj
    public final void zzt(zzap zzapVar) {
        this.zzb[0].zzt(zzapVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    protected final /* bridge */ /* synthetic */ zzvh zzy(Object obj, zzvh zzvhVar) {
        zzvh zzvhVar2;
        zzvh zzvhVar3;
        int intValue = ((Integer) obj).intValue();
        List list = this.zzc;
        List list2 = (List) list.get(intValue);
        for (int i = 0; i < list2.size(); i++) {
            zzvhVar2 = ((zzvx) list2.get(i)).zza;
            if (zzvhVar2.equals(zzvhVar)) {
                zzvhVar3 = ((zzvx) ((List) list.get(0)).get(i)).zza;
                return zzvhVar3;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzvj
    public final void zzz() throws IOException {
        zzvw zzvwVar = this.zzh;
        if (zzvwVar != null) {
            throw zzvwVar;
        }
        super.zzz();
    }
}
