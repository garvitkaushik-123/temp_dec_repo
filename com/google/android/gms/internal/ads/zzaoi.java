package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaoi implements zzaoa {
    final /* synthetic */ zzaoj zza;
    private final zzem zzb;
    private final SparseArray zzc;
    private final SparseIntArray zzd;
    private final int zze;

    public zzaoi(zzaoj zzaojVar, int i) {
        Objects.requireNonNull(zzaojVar);
        this.zza = zzaojVar;
        this.zzb = new zzem(new byte[5], 5);
        this.zzc = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zza(zzen zzenVar) {
        List list;
        SparseArray sparseArray;
        int i;
        zzady zzadyVar;
        SparseBooleanArray sparseBooleanArray;
        SparseBooleanArray sparseBooleanArray2;
        zzady zzadyVar2;
        SparseArray sparseArray2;
        SparseBooleanArray sparseBooleanArray3;
        zzaom zzaomVar;
        zzaoj zzaojVar;
        int i2;
        zzem zzemVar;
        int i3;
        int i4;
        if (zzenVar.zzm() != 2) {
            return;
        }
        zzaoj zzaojVar2 = this.zza;
        list = zzaojVar2.zzb;
        zzeu zzeuVar = (zzeu) list.get(0);
        if ((zzenVar.zzm() & 128) != 0) {
            zzenVar.zzM(1);
            int zzq = zzenVar.zzq();
            int i5 = 3;
            zzenVar.zzM(3);
            zzem zzemVar2 = this.zzb;
            zzenVar.zzG(zzemVar2, 2);
            zzemVar2.zzn(3);
            int i6 = 13;
            zzaojVar2.zzr = zzemVar2.zzd(13);
            zzenVar.zzG(zzemVar2, 2);
            int i7 = 4;
            zzemVar2.zzn(4);
            int i8 = 12;
            zzenVar.zzM(zzemVar2.zzd(12));
            SparseArray sparseArray3 = this.zzc;
            sparseArray3.clear();
            SparseIntArray sparseIntArray = this.zzd;
            sparseIntArray.clear();
            int zza = zzenVar.zza();
            while (zza > 0) {
                int i9 = 5;
                zzenVar.zzG(zzemVar2, 5);
                int zzd = zzemVar2.zzd(8);
                zzemVar2.zzn(i5);
                int zzd2 = zzemVar2.zzd(i6);
                zzemVar2.zzn(i7);
                int zzd3 = zzemVar2.zzd(i8);
                int zzc = zzenVar.zzc();
                int i10 = zzc + zzd3;
                String str = null;
                ArrayList arrayList = null;
                int i11 = -1;
                int i12 = 0;
                while (zzenVar.zzc() < i10) {
                    int zzm = zzenVar.zzm();
                    int zzc2 = zzenVar.zzc() + zzenVar.zzm();
                    if (zzc2 > i10) {
                        break;
                    }
                    if (zzm == i9) {
                        long zzu = zzenVar.zzu();
                        if (zzu != 1094921523) {
                            if (zzu != 1161904947) {
                                if (zzu != 1094921524) {
                                    if (zzu == 1212503619) {
                                        i4 = 36;
                                        zzaojVar = zzaojVar2;
                                        i11 = i4;
                                        i2 = zzc2;
                                        zzemVar = zzemVar2;
                                        i3 = zza;
                                    }
                                    zzaojVar = zzaojVar2;
                                    i2 = zzc2;
                                    zzemVar = zzemVar2;
                                    i3 = zza;
                                }
                                zzaojVar = zzaojVar2;
                                i2 = zzc2;
                                zzemVar = zzemVar2;
                                i3 = zza;
                                i11 = 172;
                            }
                            zzaojVar = zzaojVar2;
                            zzemVar = zzemVar2;
                            i3 = zza;
                            i11 = 135;
                            i2 = zzc2;
                            zzenVar.zzM(i2 - zzenVar.zzc());
                            zza = i3;
                            zzemVar2 = zzemVar;
                            zzaojVar2 = zzaojVar;
                            i9 = 5;
                        }
                        zzaojVar = zzaojVar2;
                        i2 = zzc2;
                        zzemVar = zzemVar2;
                        i3 = zza;
                        i11 = 129;
                    } else {
                        if (zzm != 106) {
                            if (zzm != 122) {
                                if (zzm == 127) {
                                    int zzm2 = zzenVar.zzm();
                                    if (zzm2 != 21) {
                                        if (zzm2 == 14) {
                                            i4 = 136;
                                        } else {
                                            if (zzm2 == 33) {
                                                i4 = TsExtractor.TS_STREAM_TYPE_DTS_UHD;
                                            }
                                            zzaojVar = zzaojVar2;
                                            i2 = zzc2;
                                            zzemVar = zzemVar2;
                                            i3 = zza;
                                        }
                                    }
                                    zzaojVar = zzaojVar2;
                                    i2 = zzc2;
                                    zzemVar = zzemVar2;
                                    i3 = zza;
                                    i11 = 172;
                                } else if (zzm == 123) {
                                    i4 = 138;
                                } else if (zzm == 10) {
                                    String trim = zzenVar.zzB(3, StandardCharsets.UTF_8).trim();
                                    i12 = zzenVar.zzm();
                                    zzaojVar = zzaojVar2;
                                    str = trim;
                                    i2 = zzc2;
                                    zzemVar = zzemVar2;
                                    i3 = zza;
                                } else {
                                    if (zzm == 89) {
                                        ArrayList arrayList2 = new ArrayList();
                                        while (zzenVar.zzc() < zzc2) {
                                            int i13 = zzc2;
                                            String trim2 = zzenVar.zzB(3, StandardCharsets.UTF_8).trim();
                                            int zzm3 = zzenVar.zzm();
                                            int i14 = zza;
                                            byte[] bArr = new byte[4];
                                            zzenVar.zzH(bArr, 0, 4);
                                            arrayList2.add(new zzaok(trim2, zzm3, bArr));
                                            zza = i14;
                                            zzc2 = i13;
                                            zzemVar2 = zzemVar2;
                                            zzaojVar2 = zzaojVar2;
                                        }
                                        zzaojVar = zzaojVar2;
                                        i2 = zzc2;
                                        zzemVar = zzemVar2;
                                        i3 = zza;
                                        arrayList = arrayList2;
                                        i11 = 89;
                                    } else {
                                        zzaojVar = zzaojVar2;
                                        i2 = zzc2;
                                        zzemVar = zzemVar2;
                                        i3 = zza;
                                        if (zzm == 111) {
                                            i11 = 257;
                                        }
                                    }
                                    zzenVar.zzM(i2 - zzenVar.zzc());
                                    zza = i3;
                                    zzemVar2 = zzemVar;
                                    zzaojVar2 = zzaojVar;
                                    i9 = 5;
                                }
                                zzaojVar = zzaojVar2;
                                i11 = i4;
                                i2 = zzc2;
                                zzemVar = zzemVar2;
                                i3 = zza;
                            }
                            zzaojVar = zzaojVar2;
                            zzemVar = zzemVar2;
                            i3 = zza;
                            i11 = 135;
                            i2 = zzc2;
                            zzenVar.zzM(i2 - zzenVar.zzc());
                            zza = i3;
                            zzemVar2 = zzemVar;
                            zzaojVar2 = zzaojVar;
                            i9 = 5;
                        }
                        zzaojVar = zzaojVar2;
                        i2 = zzc2;
                        zzemVar = zzemVar2;
                        i3 = zza;
                        i11 = 129;
                    }
                    zzenVar.zzM(i2 - zzenVar.zzc());
                    zza = i3;
                    zzemVar2 = zzemVar;
                    zzaojVar2 = zzaojVar;
                    i9 = 5;
                }
                zzaoj zzaojVar3 = zzaojVar2;
                zzem zzemVar3 = zzemVar2;
                int i15 = zza;
                zzenVar.zzL(i10);
                zzaol zzaolVar = new zzaol(i11, str, i12, arrayList, Arrays.copyOfRange(zzenVar.zzN(), zzc, i10));
                if (zzd == 6 || zzd == 5) {
                    zzd = zzaolVar.zza;
                }
                zza = i15 - (zzd3 + 5);
                sparseBooleanArray3 = zzaojVar3.zzh;
                if (!sparseBooleanArray3.get(zzd2)) {
                    zzaomVar = zzaojVar3.zze;
                    zzaoo zzb = zzaomVar.zzb(zzd, zzaolVar);
                    sparseIntArray.put(zzd2, zzd2);
                    sparseArray3.put(zzd2, zzb);
                }
                i7 = 4;
                zzemVar2 = zzemVar3;
                zzaojVar2 = zzaojVar3;
                i5 = 3;
                i6 = 13;
                i8 = 12;
            }
            zzaoj zzaojVar4 = zzaojVar2;
            int size = sparseIntArray.size();
            for (int i16 = 0; i16 < size; i16++) {
                int keyAt = sparseIntArray.keyAt(i16);
                int valueAt = sparseIntArray.valueAt(i16);
                sparseBooleanArray = zzaojVar4.zzh;
                sparseBooleanArray.put(keyAt, true);
                sparseBooleanArray2 = zzaojVar4.zzi;
                sparseBooleanArray2.put(valueAt, true);
                zzaoo zzaooVar = (zzaoo) sparseArray3.valueAt(i16);
                if (zzaooVar != null) {
                    zzadyVar2 = zzaojVar4.zzl;
                    zzaooVar.zzb(zzeuVar, zzadyVar2, new zzaon(zzq, keyAt, 8192));
                    sparseArray2 = zzaojVar4.zzg;
                    sparseArray2.put(valueAt, zzaooVar);
                }
            }
            int i17 = this.zze;
            sparseArray = zzaojVar4.zzg;
            sparseArray.remove(i17);
            zzaojVar4.zzm = 0;
            i = zzaojVar4.zzm;
            if (i == 0) {
                zzadyVar = zzaojVar4.zzl;
                zzadyVar.zzG();
                zzaojVar4.zzn = true;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoa
    public final void zzb(zzeu zzeuVar, zzady zzadyVar, zzaon zzaonVar) {
    }
}
