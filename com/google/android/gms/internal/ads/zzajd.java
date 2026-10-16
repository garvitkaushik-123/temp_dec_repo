package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzajd implements zzadv {
    private static final byte[] zza = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzz zzb;
    private long zzA;
    private long zzB;
    private zzajc zzC;
    private int zzD;
    private int zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private zzady zzI;
    private zzafb[] zzJ;
    private zzafb[] zzK;
    private boolean zzL;
    private long zzM;
    private final zzakr zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzen zzg;
    private final zzen zzh;
    private final zzen zzi;
    private final byte[] zzj;
    private final zzen zzk;
    private final zzags zzl;
    private final zzen zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private final zzfz zzp;
    private final zzadj zzq;
    private zzfyq zzr;
    private int zzs;
    private int zzt;
    private long zzu;
    private int zzv;
    private zzen zzw;
    private long zzx;
    private int zzy;
    private long zzz;

    static {
        zzx zzxVar = new zzx();
        zzxVar.zzah("application/x-emsg");
        zzb = zzxVar.zzan();
    }

    @Deprecated
    public zzajd() {
        this(zzakr.zza, 32, null, null, zzfyq.zzn(), null);
    }

    private static int zzg(int i) throws zzaz {
        if (i >= 0) {
            return i;
        }
        throw zzaz.zza("Unexpected negative value: " + i, null);
    }

    private static Pair zzh(zzen zzenVar, long j) throws zzaz {
        long zzw;
        long zzw2;
        zzen zzenVar2 = zzenVar;
        zzenVar2.zzL(8);
        int zza2 = zzaix.zza(zzenVar2.zzg());
        zzenVar2.zzM(4);
        long zzu = zzenVar2.zzu();
        if (zza2 == 0) {
            zzw = zzenVar2.zzu();
            zzw2 = zzenVar2.zzu();
        } else {
            zzw = zzenVar2.zzw();
            zzw2 = zzenVar2.zzw();
        }
        long j2 = j + zzw2;
        long zzu2 = zzex.zzu(zzw, 1000000L, zzu, RoundingMode.DOWN);
        zzenVar2.zzM(2);
        int zzq = zzenVar2.zzq();
        int[] iArr = new int[zzq];
        long[] jArr = new long[zzq];
        long[] jArr2 = new long[zzq];
        long[] jArr3 = new long[zzq];
        long j3 = j2;
        long j4 = zzu2;
        int i = 0;
        while (i < zzq) {
            int zzg = zzenVar2.zzg();
            if ((Integer.MIN_VALUE & zzg) != 0) {
                throw zzaz.zza("Unhandled indirect reference", null);
            }
            long zzu3 = zzenVar2.zzu();
            iArr[i] = zzg & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            zzw += zzu3;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            long zzu4 = zzex.zzu(zzw, 1000000L, zzu, RoundingMode.DOWN);
            jArr4[i] = zzu4 - jArr5[i];
            zzenVar2.zzM(4);
            j3 += iArr[i];
            i++;
            zzenVar2 = zzenVar;
            zzq = zzq;
            j4 = zzu4;
            jArr2 = jArr4;
            jArr3 = jArr5;
        }
        return Pair.create(Long.valueOf(zzu2), new zzadi(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzs zzj(List list) {
        int i;
        UUID[] uuidArr;
        zzajl zzajlVar;
        UUID uuid;
        int size = list.size();
        int i2 = 0;
        ArrayList arrayList = null;
        while (i2 < size) {
            zzfd zzfdVar = (zzfd) list.get(i2);
            if (zzfdVar.zzd == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] zzN = zzfdVar.zza.zzN();
                zzen zzenVar = new zzen(zzN);
                if (zzenVar.zzd() >= 32) {
                    zzenVar.zzL(0);
                    int zza2 = zzenVar.zza();
                    int zzg = zzenVar.zzg();
                    if (zzg != zza2) {
                        zzea.zzf("PsshAtomUtil", "Advertised atom size (" + zzg + ") does not match buffer size: " + zza2);
                    } else {
                        int zzg2 = zzenVar.zzg();
                        if (zzg2 != 1886614376) {
                            zzea.zzf("PsshAtomUtil", "Atom type is not pssh: " + zzg2);
                        } else {
                            int zza3 = zzaix.zza(zzenVar.zzg());
                            if (zza3 > 1) {
                                zzea.zzf("PsshAtomUtil", "Unsupported pssh version: " + zza3);
                            } else {
                                UUID uuid2 = new UUID(zzenVar.zzt(), zzenVar.zzt());
                                if (zza3 == 1) {
                                    int zzp = zzenVar.zzp();
                                    uuidArr = new UUID[zzp];
                                    int i3 = 0;
                                    while (i3 < zzp) {
                                        UUID[] uuidArr2 = uuidArr;
                                        int i4 = i3;
                                        uuidArr2[i4] = new UUID(zzenVar.zzt(), zzenVar.zzt());
                                        i3 = i4 + 1;
                                        i2 = i2;
                                        uuidArr = uuidArr2;
                                    }
                                } else {
                                    uuidArr = null;
                                }
                                i = i2;
                                int zzp2 = zzenVar.zzp();
                                int zza4 = zzenVar.zza();
                                if (zzp2 != zza4) {
                                    zzea.zzf("PsshAtomUtil", "Atom data size (" + zzp2 + ") does not match the bytes left: " + zza4);
                                    zzajlVar = null;
                                    uuid = zzajlVar == null ? null : zzajlVar.zza;
                                    if (uuid == null) {
                                        zzea.zzf("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                                    } else {
                                        arrayList.add(new zzr(uuid, null, "video/mp4", zzN));
                                        i2 = i + 1;
                                    }
                                } else {
                                    byte[] bArr = new byte[zzp2];
                                    zzenVar.zzH(bArr, 0, zzp2);
                                    zzajlVar = new zzajl(uuid2, zza3, bArr, uuidArr);
                                    if (zzajlVar == null) {
                                    }
                                    if (uuid == null) {
                                    }
                                }
                            }
                        }
                    }
                }
                i = i2;
                zzajlVar = null;
                if (zzajlVar == null) {
                }
                if (uuid == null) {
                }
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        if (arrayList == null) {
            return null;
        }
        return new zzs(arrayList);
    }

    private final void zzk() {
        this.zzs = 0;
        this.zzv = 0;
    }

    private static void zzl(zzen zzenVar, int i, zzajr zzajrVar) throws zzaz {
        zzenVar.zzL(i + 8);
        int zzg = zzenVar.zzg();
        int i2 = zzaix.zza;
        if ((zzg & 1) != 0) {
            throw zzaz.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (zzg & 2) != 0;
        int zzp = zzenVar.zzp();
        if (zzp == 0) {
            Arrays.fill(zzajrVar.zzl, 0, zzajrVar.zze, false);
            return;
        }
        int i3 = zzajrVar.zze;
        if (zzp != i3) {
            throw zzaz.zza("Senc sample count " + zzp + " is different from fragment sample count" + i3, null);
        }
        Arrays.fill(zzajrVar.zzl, 0, zzp, z);
        zzajrVar.zza(zzenVar.zza());
        zzen zzenVar2 = zzajrVar.zzn;
        zzenVar.zzH(zzenVar2.zzN(), 0, zzenVar2.zzd());
        zzenVar2.zzL(0);
        zzajrVar.zzo = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0356, code lost:
    
        if ((com.google.android.gms.internal.ads.zzex.zzu(r40, 1000000, r7.zzd, java.math.RoundingMode.DOWN) + com.google.android.gms.internal.ads.zzex.zzu(r2[0], 1000000, r7.zzc, java.math.RoundingMode.DOWN)) < r7.zze) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x06cc, code lost:
    
        zzk();
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x06cf, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:89:0x038d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzm(long j) throws zzaz {
        int i;
        List list;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        byte[] bArr;
        int i7;
        boolean z;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z3;
        long[] jArr;
        while (true) {
            ArrayDeque arrayDeque = this.zzn;
            if (arrayDeque.isEmpty() || ((zzfc) arrayDeque.peek()).zza != j) {
                break;
            }
            zzfc zzfcVar = (zzfc) arrayDeque.pop();
            int i21 = zzfcVar.zzd;
            int i22 = 12;
            int i23 = 8;
            if (i21 == 1836019574) {
                zzs zzj = zzj(zzfcVar.zzb);
                zzfc zza2 = zzfcVar.zza(1836475768);
                zza2.getClass();
                SparseArray sparseArray = new SparseArray();
                List list2 = zza2.zzb;
                int size = list2.size();
                long j2 = -9223372036854775807L;
                int i24 = 0;
                while (i24 < size) {
                    zzfd zzfdVar = (zzfd) list2.get(i24);
                    int i25 = zzfdVar.zzd;
                    if (i25 == 1953654136) {
                        zzen zzenVar = zzfdVar.zza;
                        zzenVar.zzL(i22);
                        Pair create = Pair.create(Integer.valueOf(zzenVar.zzg()), new zzaiy(zzenVar.zzg() - 1, zzenVar.zzg(), zzenVar.zzg(), zzenVar.zzg()));
                        sparseArray.put(((Integer) create.first).intValue(), (zzaiy) create.second);
                    } else if (i25 == 1835362404) {
                        zzen zzenVar2 = zzfdVar.zza;
                        zzenVar2.zzL(8);
                        j2 = zzaix.zza(zzenVar2.zzg()) == 0 ? zzenVar2.zzu() : zzenVar2.zzw();
                    }
                    i24++;
                    i22 = 12;
                }
                List zzf = zzaix.zzf(zzfcVar, new zzaej(), j2, zzj, (this.zzd & 16) != 0, false, new zzfve(this) { // from class: com.google.android.gms.internal.ads.zzaiz
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        return (zzajp) obj;
                    }
                });
                int size2 = zzf.size();
                SparseArray sparseArray2 = this.zzf;
                if (sparseArray2.size() == 0) {
                    String zza3 = zzajg.zza(zzf);
                    for (int i26 = 0; i26 < size2; i26++) {
                        zzajs zzajsVar = (zzajs) zzf.get(i26);
                        zzajp zzajpVar = zzajsVar.zza;
                        zzafb zzw = this.zzI.zzw(i26, zzajpVar.zzb);
                        long j3 = zzajpVar.zze;
                        zzw.zzl(j3);
                        int i27 = zzajpVar.zza;
                        sparseArray2.put(i27, new zzajc(zzw, zzajsVar, zzn(sparseArray, i27), zza3));
                        this.zzA = Math.max(this.zzA, j3);
                    }
                    this.zzI.zzG();
                } else {
                    zzdd.zzf(sparseArray2.size() == size2);
                    for (int i28 = 0; i28 < size2; i28++) {
                        zzajs zzajsVar2 = (zzajs) zzf.get(i28);
                        int i29 = zzajsVar2.zza.zza;
                        ((zzajc) sparseArray2.get(i29)).zzh(zzajsVar2, zzn(sparseArray, i29));
                    }
                }
            } else {
                int i30 = 16;
                if (i21 == 1836019558) {
                    SparseArray sparseArray3 = this.zzf;
                    int i31 = this.zzd;
                    byte[] bArr2 = this.zzj;
                    List list3 = zzfcVar.zzc;
                    int size3 = list3.size();
                    int i32 = 0;
                    while (i32 < size3) {
                        zzfc zzfcVar2 = (zzfc) list3.get(i32);
                        if (zzfcVar2.zzd == 1953653094) {
                            zzfd zzb2 = zzfcVar2.zzb(1952868452);
                            zzb2.getClass();
                            zzen zzenVar3 = zzb2.zza;
                            zzenVar3.zzL(i23);
                            int zzg = zzenVar3.zzg();
                            int i33 = zzaix.zza;
                            zzajc zzajcVar = (zzajc) sparseArray3.get(zzenVar3.zzg());
                            if (zzajcVar == null) {
                                zzajcVar = null;
                            } else {
                                if ((zzg & 1) != 0) {
                                    long zzw2 = zzenVar3.zzw();
                                    zzajr zzajrVar = zzajcVar.zzb;
                                    zzajrVar.zzb = zzw2;
                                    zzajrVar.zzc = zzw2;
                                }
                                zzaiy zzaiyVar = zzajcVar.zze;
                                zzajcVar.zzb.zza = new zzaiy((zzg & 2) != 0 ? zzenVar3.zzg() - 1 : zzaiyVar.zza, (zzg & 8) != 0 ? zzenVar3.zzg() : zzaiyVar.zzb, (zzg & 16) != 0 ? zzenVar3.zzg() : zzaiyVar.zzc, (zzg & 32) != 0 ? zzenVar3.zzg() : zzaiyVar.zzd);
                            }
                            if (zzajcVar == null) {
                                i = i31;
                                list = list3;
                                i2 = size3;
                                i4 = i32;
                                i5 = i30;
                                i3 = 8;
                            } else {
                                zzajr zzajrVar2 = zzajcVar.zzb;
                                long j4 = zzajrVar2.zzp;
                                boolean z4 = zzajrVar2.zzq;
                                zzajcVar.zzi();
                                zzajcVar.zzm = true;
                                zzfd zzb3 = zzfcVar2.zzb(1952867444);
                                if (zzb3 == null || (i31 & 2) != 0) {
                                    zzajrVar2.zzp = j4;
                                    zzajrVar2.zzq = z4;
                                } else {
                                    zzen zzenVar4 = zzb3.zza;
                                    zzenVar4.zzL(8);
                                    zzajrVar2.zzp = zzaix.zza(zzenVar4.zzg()) == 1 ? zzenVar4.zzw() : zzenVar4.zzu();
                                    zzajrVar2.zzq = true;
                                }
                                List list4 = zzfcVar2.zzb;
                                int size4 = list4.size();
                                i = i31;
                                int i34 = 0;
                                int i35 = 0;
                                int i36 = 0;
                                while (true) {
                                    i6 = 1953658222;
                                    if (i34 >= size4) {
                                        break;
                                    }
                                    List list5 = list3;
                                    zzfd zzfdVar2 = (zzfd) list4.get(i34);
                                    int i37 = size3;
                                    if (zzfdVar2.zzd == 1953658222) {
                                        zzen zzenVar5 = zzfdVar2.zza;
                                        zzenVar5.zzL(12);
                                        int zzp = zzenVar5.zzp();
                                        if (zzp > 0) {
                                            i36 += zzp;
                                            i35++;
                                        }
                                    }
                                    i34++;
                                    size3 = i37;
                                    list3 = list5;
                                }
                                list = list3;
                                i2 = size3;
                                zzajcVar.zzh = 0;
                                zzajcVar.zzg = 0;
                                zzajcVar.zzf = 0;
                                zzajrVar2.zzd = i35;
                                zzajrVar2.zze = i36;
                                if (zzajrVar2.zzg.length < i35) {
                                    zzajrVar2.zzf = new long[i35];
                                    zzajrVar2.zzg = new int[i35];
                                }
                                if (zzajrVar2.zzh.length < i36) {
                                    int i38 = (i36 * Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) / 100;
                                    zzajrVar2.zzh = new int[i38];
                                    zzajrVar2.zzi = new long[i38];
                                    zzajrVar2.zzj = new boolean[i38];
                                    zzajrVar2.zzl = new boolean[i38];
                                }
                                int i39 = 0;
                                int i40 = 0;
                                int i41 = 0;
                                while (true) {
                                    long j5 = 0;
                                    if (i39 >= size4) {
                                        break;
                                    }
                                    zzfd zzfdVar3 = (zzfd) list4.get(i39);
                                    if (zzfdVar3.zzd == i6) {
                                        int i42 = i40 + 1;
                                        zzen zzenVar6 = zzfdVar3.zza;
                                        zzenVar6.zzL(8);
                                        int zzg2 = zzenVar6.zzg();
                                        i8 = i39;
                                        zzajp zzajpVar2 = zzajcVar.zzd.zza;
                                        int i43 = i40;
                                        zzaiy zzaiyVar2 = zzajrVar2.zza;
                                        String str = zzex.zza;
                                        i9 = size4;
                                        zzajrVar2.zzg[i43] = zzenVar6.zzp();
                                        long[] jArr2 = zzajrVar2.zzf;
                                        i10 = i32;
                                        long j6 = zzajrVar2.zzb;
                                        jArr2[i43] = j6;
                                        if ((zzg2 & 1) != 0) {
                                            jArr2[i43] = j6 + zzenVar6.zzg();
                                        }
                                        boolean z5 = (zzg2 & 4) != 0;
                                        int i44 = zzaiyVar2.zzd;
                                        int zzg3 = z5 ? zzenVar6.zzg() : i44;
                                        boolean z6 = z5;
                                        int i45 = zzg2 & 256;
                                        int i46 = zzg2 & 512;
                                        int i47 = zzg2 & 1024;
                                        int i48 = zzg2 & 2048;
                                        long[] jArr3 = zzajpVar2.zzi;
                                        if (jArr3 != null) {
                                            i11 = i47;
                                            if (jArr3.length == 1 && (jArr = zzajpVar2.zzj) != null) {
                                                long j7 = jArr3[0];
                                                if (j7 == 0) {
                                                    i12 = i44;
                                                } else {
                                                    i12 = i44;
                                                }
                                                j5 = jArr[0];
                                                int[] iArr = zzajrVar2.zzh;
                                                long[] jArr4 = zzajrVar2.zzi;
                                                boolean[] zArr = zzajrVar2.zzj;
                                                boolean z7 = (zzajpVar2.zzb == 2 || (i & 1) == 0) ? false : true;
                                                i13 = zzajrVar2.zzg[i43] + i41;
                                                int i49 = i41;
                                                long j8 = zzajpVar2.zzc;
                                                long j9 = zzajrVar2.zzp;
                                                i14 = i49;
                                                while (i14 < i13) {
                                                    if (i45 != 0) {
                                                        z2 = z7;
                                                        i15 = zzenVar6.zzg();
                                                    } else {
                                                        z2 = z7;
                                                        i15 = zzaiyVar2.zzb;
                                                    }
                                                    zzg(i15);
                                                    if (i46 != 0) {
                                                        i16 = i14;
                                                        i17 = zzenVar6.zzg();
                                                    } else {
                                                        i16 = i14;
                                                        i17 = zzaiyVar2.zzc;
                                                    }
                                                    zzg(i17);
                                                    if (i11 != 0) {
                                                        i18 = zzenVar6.zzg();
                                                    } else {
                                                        if (i16 == 0) {
                                                            if (z6) {
                                                                i18 = zzg3;
                                                                i16 = 0;
                                                            } else {
                                                                i16 = 0;
                                                            }
                                                        }
                                                        i18 = i12;
                                                    }
                                                    if (i48 != 0) {
                                                        i19 = i17;
                                                        i20 = zzenVar6.zzg();
                                                    } else {
                                                        i19 = i17;
                                                        i20 = 0;
                                                    }
                                                    zzaiy zzaiyVar3 = zzaiyVar2;
                                                    long zzu = zzex.zzu((i20 + j9) - j5, 1000000L, j8, RoundingMode.DOWN);
                                                    jArr4[i16] = zzu;
                                                    if (!zzajrVar2.zzq) {
                                                        jArr4[i16] = zzu + zzajcVar.zzd.zzh;
                                                    }
                                                    iArr[i16] = i19;
                                                    if (((i18 >> 16) & 1) == 0) {
                                                        if (!z2) {
                                                            z3 = true;
                                                        } else if (i16 == 0) {
                                                            z3 = true;
                                                            i16 = 0;
                                                        }
                                                        zArr[i16] = z3;
                                                        j9 += i15;
                                                        i14 = i16 + 1;
                                                        z7 = z2;
                                                        zzaiyVar2 = zzaiyVar3;
                                                    }
                                                    z3 = false;
                                                    zArr[i16] = z3;
                                                    j9 += i15;
                                                    i14 = i16 + 1;
                                                    z7 = z2;
                                                    zzaiyVar2 = zzaiyVar3;
                                                }
                                                zzajrVar2.zzp = j9;
                                                i41 = i13;
                                                i40 = i42;
                                            }
                                        } else {
                                            i11 = i47;
                                        }
                                        i12 = i44;
                                        int[] iArr2 = zzajrVar2.zzh;
                                        long[] jArr42 = zzajrVar2.zzi;
                                        boolean[] zArr2 = zzajrVar2.zzj;
                                        if (zzajpVar2.zzb == 2) {
                                        }
                                        i13 = zzajrVar2.zzg[i43] + i41;
                                        int i492 = i41;
                                        long j82 = zzajpVar2.zzc;
                                        long j92 = zzajrVar2.zzp;
                                        i14 = i492;
                                        while (i14 < i13) {
                                        }
                                        zzajrVar2.zzp = j92;
                                        i41 = i13;
                                        i40 = i42;
                                    } else {
                                        i8 = i39;
                                        i9 = size4;
                                        i10 = i32;
                                    }
                                    i39 = i8 + 1;
                                    size4 = i9;
                                    i32 = i10;
                                    i6 = 1953658222;
                                }
                                i4 = i32;
                                zzajp zzajpVar3 = zzajcVar.zzd.zza;
                                zzaiy zzaiyVar4 = zzajrVar2.zza;
                                zzaiyVar4.getClass();
                                zzajq zzb4 = zzajpVar3.zzb(zzaiyVar4.zza);
                                zzfd zzb5 = zzfcVar2.zzb(1935763834);
                                if (zzb5 != null) {
                                    zzb4.getClass();
                                    int i50 = zzb4.zzd;
                                    zzen zzenVar7 = zzb5.zza;
                                    zzenVar7.zzL(8);
                                    if ((zzenVar7.zzg() & 1) == 1) {
                                        zzenVar7.zzM(8);
                                    }
                                    int zzm = zzenVar7.zzm();
                                    int zzp2 = zzenVar7.zzp();
                                    int i51 = zzajrVar2.zze;
                                    if (zzp2 > i51) {
                                        throw zzaz.zza("Saiz sample count " + zzp2 + " is greater than fragment sample count" + i51, null);
                                    }
                                    if (zzm == 0) {
                                        boolean[] zArr3 = zzajrVar2.zzl;
                                        i7 = 0;
                                        for (int i52 = 0; i52 < zzp2; i52++) {
                                            int zzm2 = zzenVar7.zzm();
                                            i7 += zzm2;
                                            zArr3[i52] = zzm2 > i50;
                                        }
                                        z = false;
                                    } else {
                                        boolean z8 = zzm > i50;
                                        i7 = zzm * zzp2;
                                        z = false;
                                        Arrays.fill(zzajrVar2.zzl, 0, zzp2, z8);
                                    }
                                    Arrays.fill(zzajrVar2.zzl, zzp2, zzajrVar2.zze, z);
                                    if (i7 > 0) {
                                        zzajrVar2.zza(i7);
                                    }
                                }
                                zzfd zzb6 = zzfcVar2.zzb(1935763823);
                                if (zzb6 != null) {
                                    zzen zzenVar8 = zzb6.zza;
                                    zzenVar8.zzL(8);
                                    int zzg4 = zzenVar8.zzg();
                                    if ((zzg4 & 1) == 1) {
                                        zzenVar8.zzM(8);
                                    }
                                    int zzp3 = zzenVar8.zzp();
                                    if (zzp3 != 1) {
                                        throw zzaz.zza("Unexpected saio entry count: " + zzp3, null);
                                    }
                                    zzajrVar2.zzc += zzaix.zza(zzg4) == 0 ? zzenVar8.zzu() : zzenVar8.zzw();
                                }
                                zzfd zzb7 = zzfcVar2.zzb(1936027235);
                                if (zzb7 != null) {
                                    zzl(zzb7.zza, 0, zzajrVar2);
                                }
                                String str2 = zzb4 != null ? zzb4.zzb : null;
                                zzen zzenVar9 = null;
                                zzen zzenVar10 = null;
                                for (int i53 = 0; i53 < list4.size(); i53++) {
                                    zzfd zzfdVar4 = (zzfd) list4.get(i53);
                                    zzen zzenVar11 = zzfdVar4.zza;
                                    int i54 = zzfdVar4.zzd;
                                    if (i54 == 1935828848) {
                                        zzenVar11.zzL(12);
                                        if (zzenVar11.zzg() == 1936025959) {
                                            zzenVar9 = zzenVar11;
                                        }
                                    } else if (i54 == 1936158820) {
                                        zzenVar11.zzL(12);
                                        if (zzenVar11.zzg() == 1936025959) {
                                            zzenVar10 = zzenVar11;
                                        }
                                    }
                                }
                                if (zzenVar9 != null && zzenVar10 != null) {
                                    zzenVar9.zzL(8);
                                    int zza4 = zzaix.zza(zzenVar9.zzg());
                                    zzenVar9.zzM(4);
                                    if (zza4 == 1) {
                                        zzenVar9.zzM(4);
                                    }
                                    if (zzenVar9.zzg() != 1) {
                                        throw zzaz.zzc("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    zzenVar10.zzL(8);
                                    int zza5 = zzaix.zza(zzenVar10.zzg());
                                    zzenVar10.zzM(4);
                                    if (zza5 == 1) {
                                        if (zzenVar10.zzu() == 0) {
                                            throw zzaz.zzc("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (zza5 >= 2) {
                                        zzenVar10.zzM(4);
                                    }
                                    if (zzenVar10.zzu() != 1) {
                                        throw zzaz.zzc("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    zzenVar10.zzM(1);
                                    int zzm3 = zzenVar10.zzm();
                                    int i55 = (zzm3 & 240) >> 4;
                                    int i56 = zzm3 & 15;
                                    if (zzenVar10.zzm() == 1) {
                                        int zzm4 = zzenVar10.zzm();
                                        int i57 = i30;
                                        byte[] bArr3 = new byte[i57];
                                        zzenVar10.zzH(bArr3, 0, i57);
                                        if (zzm4 == 0) {
                                            int zzm5 = zzenVar10.zzm();
                                            byte[] bArr4 = new byte[zzm5];
                                            zzenVar10.zzH(bArr4, 0, zzm5);
                                            bArr = bArr4;
                                        } else {
                                            bArr = null;
                                        }
                                        zzajrVar2.zzk = true;
                                        zzajrVar2.zzm = new zzajq(true, str2, zzm4, bArr3, i55, i56, bArr);
                                    }
                                }
                                int size5 = list4.size();
                                for (int i58 = 0; i58 < size5; i58++) {
                                    zzfd zzfdVar5 = (zzfd) list4.get(i58);
                                    if (zzfdVar5.zzd == 1970628964) {
                                        zzen zzenVar12 = zzfdVar5.zza;
                                        zzenVar12.zzL(8);
                                        zzenVar12.zzH(bArr2, 0, 16);
                                        if (Arrays.equals(bArr2, zza)) {
                                            zzl(zzenVar12, 16, zzajrVar2);
                                        }
                                    }
                                }
                                i5 = 16;
                                i3 = 8;
                            }
                        } else {
                            i = i31;
                            list = list3;
                            i2 = size3;
                            i3 = i23;
                            i4 = i32;
                            i5 = i30;
                        }
                        i30 = i5;
                        i23 = i3;
                        i31 = i;
                        size3 = i2;
                        list3 = list;
                        i32 = i4 + 1;
                    }
                    zzs zzj2 = zzj(zzfcVar.zzb);
                    if (zzj2 != null) {
                        int size6 = sparseArray3.size();
                        for (int i59 = 0; i59 < size6; i59++) {
                            ((zzajc) sparseArray3.valueAt(i59)).zzj(zzj2);
                        }
                    }
                    if (this.zzz != -9223372036854775807L) {
                        int size7 = sparseArray3.size();
                        for (int i60 = 0; i60 < size7; i60++) {
                            zzajc zzajcVar2 = (zzajc) sparseArray3.valueAt(i60);
                            long j10 = this.zzz;
                            int i61 = zzajcVar2.zzf;
                            while (true) {
                                zzajr zzajrVar3 = zzajcVar2.zzb;
                                if (i61 < zzajrVar3.zze && zzajrVar3.zzi[i61] <= j10) {
                                    if (zzajrVar3.zzj[i61]) {
                                        zzajcVar2.zzi = i61;
                                    }
                                    i61++;
                                }
                            }
                        }
                        this.zzz = -9223372036854775807L;
                    }
                } else if (!arrayDeque.isEmpty()) {
                    ((zzfc) arrayDeque.peek()).zzc(zzfcVar);
                }
            }
        }
    }

    private static final zzaiy zzn(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzaiy) sparseArray.valueAt(0);
        }
        zzaiy zzaiyVar = (zzaiy) sparseArray.get(i);
        zzaiyVar.getClass();
        return zzaiyVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:314:0x009c, code lost:
    
        r10 = "video/avc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x00a4, code lost:
    
        if (r31.zzs != 3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x00a6, code lost:
    
        r31.zzD = r2.zzb();
        r4 = r2.zzd.zza.zzg.zzo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x00b8, code lost:
    
        if (java.util.Objects.equals(r4, "video/avc") != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x00ba, code lost:
    
        java.util.Objects.equals(r4, "video/hevc");
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x00bd, code lost:
    
        r31.zzG = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x00c3, code lost:
    
        if (r2.zzf >= r2.zzi) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x00c5, code lost:
    
        r32.zzk(r31.zzD);
        r1 = r2.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x00ce, code lost:
    
        if (r1 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x00d1, code lost:
    
        r4 = r2.zzb;
        r6 = r4.zzn;
        r1 = r1.zzd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x00d7, code lost:
    
        if (r1 == 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x00d9, code lost:
    
        r6.zzM(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x00e2, code lost:
    
        if (r4.zzb(r2.zzf) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x00e4, code lost:
    
        r6.zzM(r6.zzq() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x00f0, code lost:
    
        if (r2.zzl() != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x00f2, code lost:
    
        r31.zzC = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x00f4, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0332, code lost:
    
        r31.zzs = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0336, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x00fd, code lost:
    
        if (r2.zzd.zza.zzh != 1) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x00ff, code lost:
    
        r31.zzD -= 8;
        r32.zzk(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0116, code lost:
    
        if ("audio/ac4".equals(r2.zzd.zza.zzg.zzo) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x0118, code lost:
    
        r31.zzE = r2.zzc(r31.zzD, 7);
        r4 = r31.zzD;
        r12 = r31.zzk;
        com.google.android.gms.internal.ads.zzacy.zzc(r4, r12);
        r2.zza.zzr(r12, 7);
        r4 = r31.zzE + 7;
        r31.zzE = r4;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x013d, code lost:
    
        r31.zzD += r4;
        r31.zzs = 4;
        r31.zzF = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0134, code lost:
    
        r8 = 0;
        r4 = r2.zzc(r31.zzD, 0);
        r31.zzE = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x0146, code lost:
    
        r4 = r2.zzd.zza;
        r8 = r2.zza;
        r12 = r2.zze();
        r14 = r4.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0152, code lost:
    
        if (r14 != 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0154, code lost:
    
        r4 = r31.zzE;
        r5 = r31.zzD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x0158, code lost:
    
        if (r4 >= r5) goto L438;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x015a, code lost:
    
        r31.zzE += r8.zzf(r32, r5 - r4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x0166, code lost:
    
        r28 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x02d1, code lost:
    
        r1 = r28.zza();
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x02d7, code lost:
    
        if (r31.zzG != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x02d9, code lost:
    
        r1 = r1 | 67108864;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x02dc, code lost:
    
        r22 = r1;
        r1 = r28.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x02e2, code lost:
    
        if (r1 == null) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x02e4, code lost:
    
        r25 = r1.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x02eb, code lost:
    
        r8.zzt(r12, r22, r31.zzD, 0, r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x02f8, code lost:
    
        r1 = r31.zzo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x02fe, code lost:
    
        if (r1.isEmpty() != false) goto L439;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0300, code lost:
    
        r1 = (com.google.android.gms.internal.ads.zzajb) r1.removeFirst();
        r2 = r31.zzy;
        r7 = r1.zzc;
        r31.zzy = r2 - r7;
        r2 = r1.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0311, code lost:
    
        if (r1.zzb == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0313, code lost:
    
        r2 = r2 + r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0315, code lost:
    
        r4 = r2;
        r1 = r31.zzJ;
        r2 = r1.length;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x031a, code lost:
    
        if (r10 >= r2) goto L442;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x031c, code lost:
    
        r1[r10].zzt(r4, 1, r7, r31.zzy, null);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x032c, code lost:
    
        if (r28.zzl() != false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x032e, code lost:
    
        r31.zzC = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x0331, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x02e9, code lost:
    
        r25 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x016a, code lost:
    
        r15 = r31.zzh;
        r3 = r15.zzN();
        r3[0] = 0;
        r3[1] = 0;
        r3[r17] = 0;
        r7 = 4 - r14;
        r19 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0180, code lost:
    
        if (r31.zzE >= r31.zzD) goto L443;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0182, code lost:
    
        r5 = r31.zzF;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0184, code lost:
    
        if (r5 != 0) goto L444;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x0189, code lost:
    
        if (r31.zzK.length > 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x018d, code lost:
    
        if (r31.zzG != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0190, code lost:
    
        r28 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x01a4, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x01a5, code lost:
    
        r32.zzi(r3, r7, r14 + r5);
        r15.zzL(0);
        r9 = r15.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x01b2, code lost:
    
        if (r9 < 0) goto L448;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x01b4, code lost:
    
        r31.zzF = r9 - r5;
        r9 = r31.zzg;
        r9.zzL(0);
        r8.zzr(r9, 4);
        r31.zzE += 4;
        r31.zzD += r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x01cd, code lost:
    
        if (r31.zzK.length <= 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x01cf, code lost:
    
        if (r5 <= 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x01d1, code lost:
    
        r9 = r4.zzg;
        r11 = r3[4];
        r2 = com.google.android.gms.internal.ads.zzfv.zza;
        r2 = r9.zzo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x01dd, code lost:
    
        if (java.util.Objects.equals(r2, r10) != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x01df, code lost:
    
        r17 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x01e7, code lost:
    
        if (com.google.android.gms.internal.ads.zzay.zzg(r9.zzk, r10) == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x01ea, code lost:
    
        r21 = r10;
        r10 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x01fb, code lost:
    
        if (java.util.Objects.equals(r2, "video/hevc") != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0203, code lost:
    
        if (com.google.android.gms.internal.ads.zzay.zzg(r9.zzk, "video/hevc") == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0215, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0216, code lost:
    
        r31.zzH = r2;
        r8.zzr(r15, r5);
        r31.zzE += r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0220, code lost:
    
        if (r5 <= 0) goto L445;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0224, code lost:
    
        if (r31.zzG != false) goto L446;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x022d, code lost:
    
        if (com.google.android.gms.internal.ads.zzfv.zzj(r3, 4, r5, r4.zzg) == false) goto L447;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x023d, code lost:
    
        r7 = r17;
        r10 = r21;
        r2 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x02cd, code lost:
    
        r19 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x022f, code lost:
    
        r31.zzG = r19;
        r7 = r17;
        r10 = r21;
        r2 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x020b, code lost:
    
        if (((r11 & 126) >> 1) != 39) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x020d, code lost:
    
        r2 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x01f0, code lost:
    
        r21 = r10;
        r10 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x01f5, code lost:
    
        if ((r11 & com.google.common.base.Ascii.US) == 6) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x01ee, code lost:
    
        r17 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x0210, code lost:
    
        r17 = r7;
        r21 = r10;
        r10 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x024e, code lost:
    
        throw com.google.android.gms.internal.ads.zzaz.zza("Invalid NAL length", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x0193, code lost:
    
        r5 = com.google.android.gms.internal.ads.zzfv.zzb(r4.zzg);
        r28 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x01a2, code lost:
    
        if ((r14 + r5) <= (r31.zzD - r31.zzE)) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x024f, code lost:
    
        r28 = r2;
        r17 = r7;
        r21 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x0258, code lost:
    
        if (r31.zzH == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x025a, code lost:
    
        r2 = r31.zzi;
        r2.zzI(r5);
        r32.zzi(r2.zzN(), 0, r31.zzF);
        r8.zzr(r2, r31.zzF);
        r5 = r31.zzF;
        r7 = com.google.android.gms.internal.ads.zzfv.zzc(r2.zzN(), r2.zzd());
        r2.zzL(0);
        r2.zzK(r7);
        r7 = r4.zzg.zzq;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x0287, code lost:
    
        if (r7 != (-1)) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x0289, code lost:
    
        r7 = r31.zzp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x028f, code lost:
    
        if (r7.zza() == 0) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x0291, code lost:
    
        r7.zze(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x02a0, code lost:
    
        r7 = r31.zzp;
        r7.zzb(r12, r2);
        r20 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x02ad, code lost:
    
        if ((r28.zza() & 4) == 0) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x02af, code lost:
    
        r7.zzd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x02ba, code lost:
    
        r31.zzE += r5;
        r31.zzF -= r5;
        r7 = r17;
        r10 = r21;
        r2 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x0295, code lost:
    
        r9 = r31.zzp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x029b, code lost:
    
        if (r9.zza() == r7) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x029d, code lost:
    
        r9.zze(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x02b3, code lost:
    
        r20 = 4;
        r5 = r8.zzf(r32, r5, false);
     */
    @Override // com.google.android.gms.internal.ads.zzadv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        char c;
        boolean z;
        boolean z2;
        String zzy;
        String zzy2;
        long zzu;
        long zzu2;
        long j;
        long j2;
        while (true) {
            int i = this.zzs;
            char c2 = 2;
            if (i == 0) {
                if (this.zzv == 0) {
                    zzen zzenVar = this.zzm;
                    if (!zzadwVar.zzn(zzenVar.zzN(), 0, 8, true)) {
                        if (this.zzM == -1) {
                            this.zzp.zzd();
                            return -1;
                        }
                        zzaerVar.zza = 0L;
                        this.zzM = -1L;
                        this.zzI.zzP(this.zzq.zza());
                        return 1;
                    }
                    this.zzv = 8;
                    zzenVar.zzL(0);
                    this.zzu = zzenVar.zzu();
                    this.zzt = zzenVar.zzg();
                }
                long j3 = this.zzu;
                if (j3 == 1) {
                    zzen zzenVar2 = this.zzm;
                    zzadwVar.zzi(zzenVar2.zzN(), 8, 8);
                    this.zzv += 8;
                    this.zzu = zzenVar2.zzw();
                } else if (j3 == 0) {
                    long zzd = zzadwVar.zzd();
                    if (zzd == -1) {
                        ArrayDeque arrayDeque = this.zzn;
                        zzd = !arrayDeque.isEmpty() ? ((zzfc) arrayDeque.peek()).zza : -1L;
                    }
                    if (zzd != -1) {
                        this.zzu = (zzd - zzadwVar.zzf()) + this.zzv;
                    }
                }
                long j4 = this.zzu;
                long j5 = this.zzv;
                if (j4 < j5) {
                    throw zzaz.zzc("Atom size less than header length (unsupported).");
                }
                if (this.zzM != -1) {
                    if (this.zzt == 1936286840) {
                        zzen zzenVar3 = this.zzk;
                        zzenVar3.zzI((int) j4);
                        System.arraycopy(this.zzm.zzN(), 0, zzenVar3.zzN(), 0, 8);
                        zzadwVar.zzi(zzenVar3.zzN(), 8, (int) (this.zzu - this.zzv));
                        this.zzq.zzb((zzadi) zzh(new zzfd(1936286840, zzenVar3).zza, zzadwVar.zze()).second);
                    } else {
                        zzadwVar.zzo((int) (j4 - j5), true);
                    }
                    zzk();
                } else {
                    long zzf = zzadwVar.zzf() - j5;
                    int i2 = this.zzt;
                    if ((i2 == 1836019558 || i2 == 1835295092) && !this.zzL) {
                        this.zzI.zzP(new zzaet(this.zzA, zzf));
                        this.zzL = true;
                    }
                    if (this.zzt == 1836019558) {
                        SparseArray sparseArray = this.zzf;
                        int size = sparseArray.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            zzajr zzajrVar = ((zzajc) sparseArray.valueAt(i3)).zzb;
                            zzajrVar.zzc = zzf;
                            zzajrVar.zzb = zzf;
                        }
                    }
                    int i4 = this.zzt;
                    if (i4 == 1835295092) {
                        this.zzC = null;
                        this.zzx = zzf + this.zzu;
                        this.zzs = 2;
                    } else if (i4 == 1836019574 || i4 == 1953653099 || i4 == 1835297121 || i4 == 1835626086 || i4 == 1937007212 || i4 == 1836019558 || i4 == 1953653094 || i4 == 1836475768 || i4 == 1701082227) {
                        long zzf2 = (zzadwVar.zzf() + this.zzu) - 8;
                        this.zzn.push(new zzfc(i4, zzf2));
                        if (this.zzu == this.zzv) {
                            zzm(zzf2);
                        } else {
                            zzk();
                        }
                    } else if (i4 == 1751411826 || i4 == 1835296868 || i4 == 1836476516 || i4 == 1936286840 || i4 == 1937011556 || i4 == 1937011827 || i4 == 1668576371 || i4 == 1937011555 || i4 == 1937011578 || i4 == 1937013298 || i4 == 1937007471 || i4 == 1668232756 || i4 == 1937011571 || i4 == 1952867444 || i4 == 1952868452 || i4 == 1953196132 || i4 == 1953654136 || i4 == 1953658222 || i4 == 1886614376 || i4 == 1935763834 || i4 == 1935763823 || i4 == 1936027235 || i4 == 1970628964 || i4 == 1935828848 || i4 == 1936158820 || i4 == 1701606260 || i4 == 1835362404 || i4 == 1701671783) {
                        if (this.zzv != 8) {
                            throw zzaz.zzc("Leaf atom defines extended atom size (unsupported).");
                        }
                        if (this.zzu > 2147483647L) {
                            throw zzaz.zzc("Leaf atom with length > 2147483647 (unsupported).");
                        }
                        zzen zzenVar4 = new zzen((int) this.zzu);
                        System.arraycopy(this.zzm.zzN(), 0, zzenVar4.zzN(), 0, 8);
                        this.zzw = zzenVar4;
                        this.zzs = 1;
                    } else {
                        if (this.zzu > 2147483647L) {
                            throw zzaz.zzc("Skipping atom with length > 2147483647 (unsupported).");
                        }
                        this.zzw = null;
                        this.zzs = 1;
                    }
                }
            } else if (i != 1) {
                long j6 = Long.MAX_VALUE;
                if (i != 2) {
                    zzajc zzajcVar = this.zzC;
                    if (zzajcVar != null) {
                        c = 2;
                        break;
                    }
                    SparseArray sparseArray2 = this.zzf;
                    int size2 = sparseArray2.size();
                    long j7 = Long.MAX_VALUE;
                    int i5 = 0;
                    zzajc zzajcVar2 = null;
                    while (i5 < size2) {
                        char c3 = c2;
                        zzajc zzajcVar3 = (zzajc) sparseArray2.valueAt(i5);
                        z = zzajcVar3.zzm;
                        if (z || zzajcVar3.zzf != zzajcVar3.zzd.zzb) {
                            z2 = zzajcVar3.zzm;
                            if (!z2 || zzajcVar3.zzh != zzajcVar3.zzb.zzd) {
                                long zzd2 = zzajcVar3.zzd();
                                if (zzd2 < j7) {
                                    zzajcVar2 = zzajcVar3;
                                    j7 = zzd2;
                                }
                            }
                        }
                        i5++;
                        c2 = c3;
                    }
                    c = c2;
                    if (zzajcVar2 == null) {
                        int zzf3 = (int) (this.zzx - zzadwVar.zzf());
                        if (zzf3 < 0) {
                            throw zzaz.zza("Offset to end of mdat was negative.", null);
                        }
                        zzadwVar.zzk(zzf3);
                        zzk();
                    } else {
                        int zzd3 = (int) (zzajcVar2.zzd() - zzadwVar.zzf());
                        if (zzd3 < 0) {
                            zzea.zzf("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            zzd3 = 0;
                        }
                        zzadwVar.zzk(zzd3);
                        this.zzC = zzajcVar2;
                        zzajcVar = zzajcVar2;
                    }
                } else {
                    SparseArray sparseArray3 = this.zzf;
                    int size3 = sparseArray3.size();
                    zzajc zzajcVar4 = null;
                    for (int i6 = 0; i6 < size3; i6++) {
                        zzajr zzajrVar2 = ((zzajc) sparseArray3.valueAt(i6)).zzb;
                        if (zzajrVar2.zzo) {
                            long j8 = zzajrVar2.zzc;
                            if (j8 < j6) {
                                zzajcVar4 = (zzajc) sparseArray3.valueAt(i6);
                                j6 = j8;
                            }
                        }
                    }
                    if (zzajcVar4 == null) {
                        this.zzs = 3;
                    } else {
                        int zzf4 = (int) (j6 - zzadwVar.zzf());
                        if (zzf4 < 0) {
                            throw zzaz.zza("Offset to encryption data was negative.", null);
                        }
                        zzadwVar.zzk(zzf4);
                        zzajr zzajrVar3 = zzajcVar4.zzb;
                        zzen zzenVar5 = zzajrVar3.zzn;
                        zzadwVar.zzi(zzenVar5.zzN(), 0, zzenVar5.zzd());
                        zzenVar5.zzL(0);
                        zzajrVar3.zzo = false;
                    }
                }
            } else {
                long j9 = this.zzu - this.zzv;
                zzen zzenVar6 = this.zzw;
                int i7 = (int) j9;
                if (zzenVar6 != null) {
                    zzadwVar.zzi(zzenVar6.zzN(), 8, i7);
                    zzfd zzfdVar = new zzfd(this.zzt, zzenVar6);
                    ArrayDeque arrayDeque2 = this.zzn;
                    if (arrayDeque2.isEmpty()) {
                        int i8 = zzfdVar.zzd;
                        if (i8 == 1936286840) {
                            Pair zzh = zzh(zzfdVar.zza, zzadwVar.zzf());
                            this.zzq.zzb((zzadi) zzh.second);
                            if (!this.zzL) {
                                this.zzB = ((Long) zzh.first).longValue();
                                this.zzI.zzP((zzaeu) zzh.second);
                                this.zzL = true;
                            }
                        } else if (i8 == 1701671783) {
                            zzen zzenVar7 = zzfdVar.zza;
                            if (this.zzJ.length != 0) {
                                zzenVar7.zzL(8);
                                int zza2 = zzaix.zza(zzenVar7.zzg());
                                if (zza2 == 0) {
                                    zzy = zzenVar7.zzy((char) 0);
                                    zzy.getClass();
                                    zzy2 = zzenVar7.zzy((char) 0);
                                    zzy2.getClass();
                                    long zzu3 = zzenVar7.zzu();
                                    long zzu4 = zzex.zzu(zzenVar7.zzu(), 1000000L, zzu3, RoundingMode.DOWN);
                                    long j10 = this.zzB;
                                    long j11 = j10 != -9223372036854775807L ? j10 + zzu4 : -9223372036854775807L;
                                    zzu = zzex.zzu(zzenVar7.zzu(), 1000L, zzu3, RoundingMode.DOWN);
                                    zzu2 = zzenVar7.zzu();
                                    j = zzu4;
                                    j2 = j11;
                                } else if (zza2 != 1) {
                                    zzea.zzf("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + zza2);
                                } else {
                                    long zzu5 = zzenVar7.zzu();
                                    long zzu6 = zzex.zzu(zzenVar7.zzw(), 1000000L, zzu5, RoundingMode.DOWN);
                                    long zzu7 = zzex.zzu(zzenVar7.zzu(), 1000L, zzu5, RoundingMode.DOWN);
                                    long zzu8 = zzenVar7.zzu();
                                    zzy = zzenVar7.zzy((char) 0);
                                    zzy.getClass();
                                    zzy2 = zzenVar7.zzy((char) 0);
                                    zzy2.getClass();
                                    zzu = zzu7;
                                    zzu2 = zzu8;
                                    j = -9223372036854775807L;
                                    j2 = zzu6;
                                }
                                String str = zzy;
                                String str2 = zzy2;
                                byte[] bArr = new byte[zzenVar7.zza()];
                                zzenVar7.zzH(bArr, 0, zzenVar7.zza());
                                zzen zzenVar8 = new zzen(this.zzl.zza(new zzagr(str, str2, zzu, zzu2, bArr)));
                                int zza3 = zzenVar8.zza();
                                for (zzafb zzafbVar : this.zzJ) {
                                    zzenVar8.zzL(0);
                                    zzafbVar.zzr(zzenVar8, zza3);
                                }
                                if (j2 == -9223372036854775807L) {
                                    this.zzo.addLast(new zzajb(j, true, zza3));
                                    this.zzy += zza3;
                                } else {
                                    ArrayDeque arrayDeque3 = this.zzo;
                                    if (arrayDeque3.isEmpty()) {
                                        for (zzafb zzafbVar2 : this.zzJ) {
                                            zzafbVar2.zzt(j2, 1, zza3, 0, null);
                                        }
                                    } else {
                                        arrayDeque3.addLast(new zzajb(j2, false, zza3));
                                        this.zzy += zza3;
                                    }
                                }
                            }
                        }
                    } else {
                        ((zzfc) arrayDeque2.peek()).zzd(zzfdVar);
                    }
                } else {
                    zzadwVar.zzk(i7);
                }
                zzm(zzadwVar.zzf());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ zzadv zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ List zzd() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zze(zzady zzadyVar) {
        int i;
        int i2 = this.zzd;
        if ((i2 & 32) == 0) {
            zzadyVar = new zzaku(zzadyVar, this.zzc);
        }
        this.zzI = zzadyVar;
        zzk();
        zzafb[] zzafbVarArr = new zzafb[2];
        this.zzJ = zzafbVarArr;
        int i3 = 100;
        int i4 = 0;
        if ((i2 & 4) != 0) {
            zzafbVarArr[0] = this.zzI.zzw(100, 5);
            i = 1;
            i3 = 101;
        } else {
            i = 0;
        }
        zzafb[] zzafbVarArr2 = (zzafb[]) zzex.zzQ(this.zzJ, i);
        this.zzJ = zzafbVarArr2;
        for (zzafb zzafbVar : zzafbVarArr2) {
            zzafbVar.zzm(zzb);
        }
        List list = this.zze;
        this.zzK = new zzafb[list.size()];
        while (i4 < this.zzK.length) {
            zzafb zzw = this.zzI.zzw(i3, 3);
            zzw.zzm((zzz) list.get(i4));
            this.zzK[i4] = zzw;
            i4++;
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        SparseArray sparseArray = this.zzf;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((zzajc) sparseArray.valueAt(i)).zzi();
        }
        this.zzo.clear();
        this.zzy = 0;
        this.zzp.zzc();
        this.zzz = j2;
        this.zzn.clear();
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        zzaey zza2 = zzajo.zza(zzadwVar);
        this.zzr = zza2 != null ? zzfyq.zzo(zza2) : zzfyq.zzn();
        return zza2 == null;
    }

    public zzajd(zzakr zzakrVar, int i, zzeu zzeuVar, zzajp zzajpVar, List list, zzafb zzafbVar) {
        this.zzc = zzakrVar;
        this.zzd = i;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzags();
        this.zzm = new zzen(16);
        this.zzg = new zzen(zzfv.zza);
        this.zzh = new zzen(6);
        this.zzi = new zzen();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzen(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzr = zzfyq.zzn();
        this.zzA = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzB = -9223372036854775807L;
        this.zzI = zzady.zza;
        this.zzJ = new zzafb[0];
        this.zzK = new zzafb[0];
        this.zzp = new zzfz(new zzfy() { // from class: com.google.android.gms.internal.ads.zzaja
            @Override // com.google.android.gms.internal.ads.zzfy
            public final void zza(long j, zzen zzenVar) {
                zzadh.zza(j, zzenVar, zzajd.this.zzK);
            }
        });
        this.zzq = new zzadj();
        this.zzM = -1L;
    }
}
