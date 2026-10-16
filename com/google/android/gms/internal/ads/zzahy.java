package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzahy implements zzadv {
    private static final byte[] zza = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final UUID zze;
    private static final Map zzf;
    private long zzA;
    private boolean zzB;
    private zzahw zzC;
    private boolean zzD;
    private int zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private long zzJ;
    private zzeb zzK;
    private zzeb zzL;
    private boolean zzM;
    private boolean zzN;
    private int zzO;
    private long zzP;
    private long zzQ;
    private int zzR;
    private int zzS;
    private int[] zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private boolean zzY;
    private long zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private int zzag;
    private byte zzah;
    private boolean zzai;
    private zzady zzaj;
    private final zzaht zzak;
    private final zzaia zzg;
    private final SparseArray zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final zzakr zzk;
    private final zzen zzl;
    private final zzen zzm;
    private final zzen zzn;
    private final zzen zzo;
    private final zzen zzp;
    private final zzen zzq;
    private final zzen zzr;
    private final zzen zzs;
    private final zzen zzt;
    private final zzen zzu;
    private ByteBuffer zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        String str = zzex.zza;
        zzb = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        zzc = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zzd = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zze = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        zzf = Collections.unmodifiableMap(hashMap);
    }

    @Deprecated
    public zzahy() {
        this(new zzaht(), 2, zzakr.zza);
    }

    @RequiresNonNull({"#2.output"})
    private final int zzp(zzadw zzadwVar, zzahw zzahwVar, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzahwVar.zzc)) {
            zzx(zzadwVar, zza, i);
            int i3 = this.zzab;
            zzw();
            return i3;
        }
        if ("S_TEXT/ASS".equals(zzahwVar.zzc) || "S_TEXT/SSA".equals(zzahwVar.zzc)) {
            zzx(zzadwVar, zzc, i);
            int i4 = this.zzab;
            zzw();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(zzahwVar.zzc)) {
            zzx(zzadwVar, zzd, i);
            int i5 = this.zzab;
            zzw();
            return i5;
        }
        zzafb zzafbVar = zzahwVar.zzX;
        if (!this.zzad) {
            if (zzahwVar.zzh) {
                this.zzW &= -1073741825;
                if (!this.zzae) {
                    zzen zzenVar = this.zzn;
                    zzadwVar.zzi(zzenVar.zzN(), 0, 1);
                    this.zzaa++;
                    if ((zzenVar.zzN()[0] & 128) == 128) {
                        throw zzaz.zza("Extension bit is set in signal byte", null);
                    }
                    this.zzah = zzenVar.zzN()[0];
                    this.zzae = true;
                }
                byte b = this.zzah;
                if ((b & 1) == 1) {
                    int i6 = b & 2;
                    this.zzW |= 1073741824;
                    if (!this.zzai) {
                        zzen zzenVar2 = this.zzs;
                        zzadwVar.zzi(zzenVar2.zzN(), 0, 8);
                        this.zzaa += 8;
                        this.zzai = true;
                        zzen zzenVar3 = this.zzn;
                        zzenVar3.zzN()[0] = (byte) ((i6 != 2 ? 0 : 128) | 8);
                        zzenVar3.zzL(0);
                        zzafbVar.zzs(zzenVar3, 1, 1);
                        this.zzab++;
                        zzenVar2.zzL(0);
                        zzafbVar.zzs(zzenVar2, 8, 1);
                        this.zzab += 8;
                    }
                    if (i6 == 2) {
                        if (!this.zzaf) {
                            zzen zzenVar4 = this.zzn;
                            zzadwVar.zzi(zzenVar4.zzN(), 0, 1);
                            this.zzaa++;
                            zzenVar4.zzL(0);
                            this.zzag = zzenVar4.zzm();
                            this.zzaf = true;
                        }
                        int i7 = this.zzag * 4;
                        zzen zzenVar5 = this.zzn;
                        zzenVar5.zzI(i7);
                        zzadwVar.zzi(zzenVar5.zzN(), 0, i7);
                        this.zzaa += i7;
                        int i8 = (this.zzag >> 1) + 1;
                        int i9 = (i8 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzv;
                        if (byteBuffer == null || byteBuffer.capacity() < i9) {
                            this.zzv = ByteBuffer.allocate(i9);
                        }
                        this.zzv.position(0);
                        this.zzv.putShort((short) i8);
                        int i10 = 0;
                        int i11 = 0;
                        while (true) {
                            i2 = this.zzag;
                            if (i10 >= i2) {
                                break;
                            }
                            int zzp = zzenVar5.zzp();
                            int i12 = zzp - i11;
                            if (i10 % 2 == 0) {
                                this.zzv.putShort((short) i12);
                            } else {
                                this.zzv.putInt(i12);
                            }
                            i10++;
                            i11 = zzp;
                        }
                        int i13 = (i - this.zzaa) - i11;
                        if ((i2 & 1) == 1) {
                            this.zzv.putInt(i13);
                        } else {
                            this.zzv.putShort((short) i13);
                            this.zzv.putInt(0);
                        }
                        zzen zzenVar6 = this.zzt;
                        zzenVar6.zzJ(this.zzv.array(), i9);
                        zzafbVar.zzs(zzenVar6, i9, 1);
                        this.zzab += i9;
                    }
                }
            } else {
                byte[] bArr = zzahwVar.zzi;
                if (bArr != null) {
                    this.zzq.zzJ(bArr, bArr.length);
                }
            }
            if (!"A_OPUS".equals(zzahwVar.zzc) ? zzahwVar.zzg > 0 : z) {
                this.zzW |= 268435456;
                this.zzu.zzI(0);
                int zzd2 = (this.zzq.zzd() + i) - this.zzaa;
                zzen zzenVar7 = this.zzn;
                zzenVar7.zzI(4);
                zzenVar7.zzN()[0] = (byte) ((zzd2 >> 24) & 255);
                zzenVar7.zzN()[1] = (byte) ((zzd2 >> 16) & 255);
                zzenVar7.zzN()[2] = (byte) ((zzd2 >> 8) & 255);
                zzenVar7.zzN()[3] = (byte) (zzd2 & 255);
                zzafbVar.zzs(zzenVar7, 4, 2);
                this.zzab += 4;
            }
            this.zzad = true;
        }
        zzen zzenVar8 = this.zzq;
        int zzd3 = i + zzenVar8.zzd();
        if (!"V_MPEG4/ISO/AVC".equals(zzahwVar.zzc) && !"V_MPEGH/ISO/HEVC".equals(zzahwVar.zzc)) {
            if (zzahwVar.zzU != null) {
                zzdd.zzf(zzenVar8.zzd() == 0);
                zzahwVar.zzU.zzd(zzadwVar);
            }
            while (true) {
                int i14 = this.zzaa;
                if (i14 >= zzd3) {
                    break;
                }
                int zzq = zzq(zzadwVar, zzafbVar, zzd3 - i14);
                this.zzaa += zzq;
                this.zzab += zzq;
            }
        } else {
            zzen zzenVar9 = this.zzm;
            byte[] zzN = zzenVar9.zzN();
            zzN[0] = 0;
            zzN[1] = 0;
            zzN[2] = 0;
            int i15 = zzahwVar.zzY;
            int i16 = 4 - i15;
            while (this.zzaa < zzd3) {
                int i17 = this.zzac;
                if (i17 == 0) {
                    int min = Math.min(i15, zzenVar8.zza());
                    zzadwVar.zzi(zzN, i16 + min, i15 - min);
                    if (min > 0) {
                        zzenVar8.zzH(zzN, i16, min);
                    }
                    this.zzaa += i15;
                    zzenVar9.zzL(0);
                    this.zzac = zzenVar9.zzp();
                    zzen zzenVar10 = this.zzl;
                    zzenVar10.zzL(0);
                    zzafbVar.zzr(zzenVar10, 4);
                    this.zzab += 4;
                } else {
                    int zzq2 = zzq(zzadwVar, zzafbVar, i17);
                    this.zzaa += zzq2;
                    this.zzab += zzq2;
                    this.zzac -= zzq2;
                }
            }
        }
        if ("A_VORBIS".equals(zzahwVar.zzc)) {
            zzen zzenVar11 = this.zzo;
            zzenVar11.zzL(0);
            zzafbVar.zzr(zzenVar11, 4);
            this.zzab += 4;
        }
        int i18 = this.zzab;
        zzw();
        return i18;
    }

    private final int zzq(zzadw zzadwVar, zzafb zzafbVar, int i) throws IOException {
        zzen zzenVar = this.zzq;
        int zza2 = zzenVar.zza();
        if (zza2 <= 0) {
            return zzafbVar.zzf(zzadwVar, i, false);
        }
        int min = Math.min(i, zza2);
        zzafbVar.zzr(zzenVar, min);
        return min;
    }

    private final long zzr(long j) throws zzaz {
        long j2 = this.zzy;
        if (j2 != -9223372036854775807L) {
            return zzex.zzu(j, j2, 1000L, RoundingMode.DOWN);
        }
        throw zzaz.zza("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzs(int i) throws zzaz {
        if (this.zzK == null || this.zzL == null) {
            throw zzaz.zza("Element " + i + " must be in a Cues", null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzt(int i) throws zzaz {
        if (this.zzC != null) {
            return;
        }
        throw zzaz.zza("Element " + i + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f6  */
    @RequiresNonNull({"#1.output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzu(zzahw zzahwVar, long j, int i, int i2, int i3) {
        char c;
        byte[] zzy;
        int i4;
        int zzd2;
        zzafc zzafcVar = zzahwVar.zzU;
        if (zzafcVar != null) {
            zzafcVar.zzc(zzahwVar.zzX, j, i, i2, i3, zzahwVar.zzj);
        } else {
            if ("S_TEXT/UTF8".equals(zzahwVar.zzc) || "S_TEXT/ASS".equals(zzahwVar.zzc) || "S_TEXT/SSA".equals(zzahwVar.zzc) || "S_TEXT/WEBVTT".equals(zzahwVar.zzc)) {
                if (this.zzS > 1) {
                    zzea.zzf("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.zzQ;
                    if (j2 == -9223372036854775807L) {
                        zzea.zzf("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = zzahwVar.zzc;
                        zzen zzenVar = this.zzr;
                        byte[] zzN = zzenVar.zzN();
                        switch (str.hashCode()) {
                            case 738597099:
                                if (str.equals("S_TEXT/ASS")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 738614379:
                                if (str.equals("S_TEXT/SSA")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1045209816:
                                if (str.equals("S_TEXT/WEBVTT")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1422270023:
                                if (str.equals("S_TEXT/UTF8")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        if (c == 0) {
                            zzy = zzy(j2, "%02d:%02d:%02d,%03d", 1000L);
                            i4 = 19;
                        } else if (c == 1 || c == 2) {
                            zzy = zzy(j2, "%01d:%02d:%02d:%02d", 10000L);
                            i4 = 21;
                        } else {
                            if (c != 3) {
                                throw new IllegalArgumentException();
                            }
                            zzy = zzy(j2, "%02d:%02d:%02d.%03d", 1000L);
                            i4 = 25;
                        }
                        System.arraycopy(zzy, 0, zzN, i4, zzy.length);
                        int zzc2 = zzenVar.zzc();
                        while (true) {
                            if (zzc2 < zzenVar.zzd()) {
                                if (zzenVar.zzN()[zzc2] == 0) {
                                    zzenVar.zzK(zzc2);
                                } else {
                                    zzc2++;
                                }
                            }
                        }
                        zzahwVar.zzX.zzr(zzenVar, zzenVar.zzd());
                        zzd2 = i2 + zzenVar.zzd();
                        if ((i & 268435456) != 0) {
                            if (this.zzS > 1) {
                                this.zzu.zzI(0);
                            } else {
                                zzen zzenVar2 = this.zzu;
                                int zzd3 = zzenVar2.zzd();
                                zzahwVar.zzX.zzs(zzenVar2, zzd3, 2);
                                zzd2 += zzd3;
                            }
                        }
                        zzahwVar.zzX.zzt(j, i, zzd2, i3, zzahwVar.zzj);
                    }
                }
            }
            zzd2 = i2;
            if ((i & 268435456) != 0) {
            }
            zzahwVar.zzX.zzt(j, i, zzd2, i3, zzahwVar.zzj);
        }
        this.zzN = true;
    }

    private final void zzv(zzadw zzadwVar, int i) throws IOException {
        zzen zzenVar = this.zzn;
        if (zzenVar.zzd() >= i) {
            return;
        }
        if (zzenVar.zzb() < i) {
            int zzb2 = zzenVar.zzb();
            zzenVar.zzF(Math.max(zzb2 + zzb2, i));
        }
        zzadwVar.zzi(zzenVar.zzN(), zzenVar.zzd(), i - zzenVar.zzd());
        zzenVar.zzK(i);
    }

    private final void zzw() {
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = 0;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = false;
        this.zzag = 0;
        this.zzah = (byte) 0;
        this.zzai = false;
        this.zzq.zzI(0);
    }

    private final void zzx(zzadw zzadwVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        zzen zzenVar = this.zzr;
        if (zzenVar.zzb() < i2) {
            byte[] copyOf = Arrays.copyOf(bArr, i2 + i);
            zzenVar.zzJ(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, zzenVar.zzN(), 0, length);
        }
        zzadwVar.zzi(zzenVar.zzN(), length, i);
        zzenVar.zzL(0);
        zzenVar.zzK(i2);
    }

    private static byte[] zzy(long j, String str, long j2) {
        zzdd.zzd(j != -9223372036854775807L);
        Locale locale = Locale.US;
        int i = (int) (j / 3600000000L);
        Integer valueOf = Integer.valueOf(i);
        long j3 = j - (i * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        Integer valueOf2 = Integer.valueOf(i2);
        long j4 = j3 - (i2 * 60000000);
        int i3 = (int) (j4 / 1000000);
        String format = String.format(locale, str, valueOf, valueOf2, Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2)));
        String str2 = zzex.zza;
        return format.getBytes(StandardCharsets.UTF_8);
    }

    private static int[] zzz(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        int i = 0;
        this.zzN = false;
        while (!this.zzN) {
            if (this.zzak.zzc(zzadwVar)) {
                long zzf2 = zzadwVar.zzf();
                if (this.zzG) {
                    this.zzI = zzf2;
                    zzaerVar.zza = this.zzH;
                    this.zzG = false;
                    return 1;
                }
                if (this.zzD) {
                    long j = this.zzI;
                    if (j != -1) {
                        zzaerVar.zza = j;
                        this.zzI = -1L;
                        return 1;
                    }
                }
            } else {
                while (true) {
                    SparseArray sparseArray = this.zzh;
                    if (i >= sparseArray.size()) {
                        return -1;
                    }
                    zzahw zzahwVar = (zzahw) sparseArray.valueAt(i);
                    zzahwVar.zzX.getClass();
                    zzafc zzafcVar = zzahwVar.zzU;
                    if (zzafcVar != null) {
                        zzafcVar.zza(zzahwVar.zzX, zzahwVar.zzj);
                    }
                    i++;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ zzadv zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ List zzd() {
        return zzfyq.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zze(zzady zzadyVar) {
        if (this.zzj) {
            zzadyVar = new zzaku(zzadyVar, this.zzk);
        }
        this.zzaj = zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzJ = -9223372036854775807L;
        int i = 0;
        this.zzO = 0;
        this.zzak.zzb();
        this.zzg.zze();
        zzw();
        while (true) {
            SparseArray sparseArray = this.zzh;
            if (i >= sparseArray.size()) {
                return;
            }
            zzafc zzafcVar = ((zzahw) sparseArray.valueAt(i)).zzU;
            if (zzafcVar != null) {
                zzafcVar.zzb();
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        return new zzahz().zza(zzadwVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01de, code lost:
    
        if (r2.equals("V_MPEGH/ISO/HEVC") != false) goto L195;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzj(int i) throws zzaz {
        int i2;
        zzaeu zzaetVar;
        int i3;
        zzdd.zzb(this.zzaj);
        char c = '\b';
        int i4 = 0;
        if (i == 160) {
            if (this.zzO == 2) {
                zzahw zzahwVar = (zzahw) this.zzh.get(this.zzU);
                zzahwVar.zzX.getClass();
                if (this.zzZ > 0 && "A_OPUS".equals(zzahwVar.zzc)) {
                    zzen zzenVar = this.zzu;
                    byte[] array = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzZ).array();
                    zzenVar.zzJ(array, array.length);
                }
                int i5 = 0;
                for (int i6 = 0; i6 < this.zzS; i6++) {
                    i5 += this.zzT[i6];
                }
                int i7 = 0;
                while (i7 < this.zzS) {
                    long j = this.zzP + ((zzahwVar.zzf * i7) / 1000);
                    int i8 = this.zzW;
                    if (i7 == 0) {
                        if (!this.zzY) {
                            i8 |= 1;
                        }
                        i2 = 0;
                    } else {
                        i2 = i7;
                    }
                    int i9 = this.zzT[i2];
                    int i10 = i5 - i9;
                    zzu(zzahwVar, j, i8, i9, i10);
                    i7 = i2 + 1;
                    i5 = i10;
                }
                this.zzO = 0;
                return;
            }
            return;
        }
        if (i != 174) {
            if (i == 19899) {
                int i11 = this.zzE;
                if (i11 != -1) {
                    long j2 = this.zzF;
                    if (j2 != -1) {
                        if (i11 == 475249515) {
                            this.zzH = j2;
                            return;
                        }
                        return;
                    }
                }
                throw zzaz.zza("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i == 25152) {
                zzt(i);
                zzahw zzahwVar2 = this.zzC;
                if (zzahwVar2.zzh) {
                    if (zzahwVar2.zzj == null) {
                        throw zzaz.zza("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    zzahwVar2.zzl = new zzs(null, new zzr(zzh.zza, null, "video/webm", this.zzC.zzj.zzb));
                    return;
                }
                return;
            }
            if (i == 28032) {
                zzt(i);
                zzahw zzahwVar3 = this.zzC;
                if (zzahwVar3.zzh && zzahwVar3.zzi != null) {
                    throw zzaz.zza("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i == 357149030) {
                if (this.zzy == -9223372036854775807L) {
                    this.zzy = 1000000L;
                }
                long j3 = this.zzz;
                if (j3 != -9223372036854775807L) {
                    this.zzA = zzr(j3);
                    return;
                }
                return;
            }
            if (i == 374648427) {
                if (this.zzh.size() == 0) {
                    throw zzaz.zza("No valid tracks were found", null);
                }
                this.zzaj.zzG();
                return;
            }
            if (i != 475249515) {
                return;
            }
            if (!this.zzD) {
                zzady zzadyVar = this.zzaj;
                zzeb zzebVar = this.zzK;
                zzeb zzebVar2 = this.zzL;
                if (this.zzx == -1 || this.zzA == -9223372036854775807L || zzebVar == null || zzebVar.zza() == 0 || zzebVar2 == null || zzebVar2.zza() != zzebVar.zza()) {
                    zzaetVar = new zzaet(this.zzA, 0L);
                } else {
                    int zza2 = zzebVar.zza();
                    int[] iArr = new int[zza2];
                    long[] jArr = new long[zza2];
                    long[] jArr2 = new long[zza2];
                    long[] jArr3 = new long[zza2];
                    for (int i12 = 0; i12 < zza2; i12++) {
                        jArr3[i12] = zzebVar.zzb(i12);
                        jArr[i12] = this.zzx + zzebVar2.zzb(i12);
                    }
                    while (true) {
                        i3 = zza2 - 1;
                        if (i4 >= i3) {
                            break;
                        }
                        int i13 = i4 + 1;
                        iArr[i4] = (int) (jArr[i13] - jArr[i4]);
                        jArr2[i4] = jArr3[i13] - jArr3[i4];
                        i4 = i13;
                    }
                    int i14 = i3;
                    while (i14 > 0 && jArr3[i14] > this.zzA) {
                        i14--;
                    }
                    iArr[i14] = (int) ((this.zzx + this.zzw) - jArr[i14]);
                    jArr2[i14] = this.zzA - jArr3[i14];
                    if (i14 < i3) {
                        zzea.zzf("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration");
                        int i15 = i14 + 1;
                        iArr = Arrays.copyOf(iArr, i15);
                        jArr = Arrays.copyOf(jArr, i15);
                        jArr2 = Arrays.copyOf(jArr2, i15);
                        jArr3 = Arrays.copyOf(jArr3, i15);
                    }
                    zzaetVar = new zzadi(iArr, jArr, jArr2, jArr3);
                }
                zzadyVar.zzP(zzaetVar);
                this.zzD = true;
            }
            this.zzK = null;
            this.zzL = null;
            return;
        }
        zzahw zzahwVar4 = this.zzC;
        zzdd.zzb(zzahwVar4);
        String str = zzahwVar4.zzc;
        if (str == null) {
            throw zzaz.zza("CodecId is missing in TrackEntry element", null);
        }
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 738614379:
                if (str.equals("S_TEXT/SSA")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case 855502857:
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    c = 11;
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
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case ' ':
            case '!':
                zzahwVar4.zze(this.zzaj, zzahwVar4.zzd);
                this.zzh.put(zzahwVar4.zzd, zzahwVar4);
                break;
        }
        this.zzC = null;
    }

    protected final void zzm(int i, long j, long j2) throws zzaz {
        zzdd.zzb(this.zzaj);
        if (i == 160) {
            this.zzY = false;
            this.zzZ = 0L;
            return;
        }
        if (i == 174) {
            zzahw zzahwVar = new zzahw();
            this.zzC = zzahwVar;
            zzahwVar.zza = this.zzB;
            return;
        }
        if (i == 187) {
            this.zzM = false;
            return;
        }
        if (i == 19899) {
            this.zzE = -1;
            this.zzF = -1L;
            return;
        }
        if (i == 20533) {
            zzt(i);
            this.zzC.zzh = true;
            return;
        }
        if (i == 21968) {
            zzt(i);
            this.zzC.zzy = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.zzx;
            if (j3 != -1 && j3 != j) {
                throw zzaz.zza("Multiple Segment elements not supported", null);
            }
            this.zzx = j;
            this.zzw = j2;
            return;
        }
        if (i == 475249515) {
            this.zzK = new zzeb(32);
            this.zzL = new zzeb(32);
        } else if (i == 524531317 && !this.zzD) {
            if (this.zzi && this.zzH != -1) {
                this.zzG = true;
            } else {
                this.zzaj.zzP(new zzaet(this.zzA, 0L));
                this.zzD = true;
            }
        }
    }

    zzahy(zzaht zzahtVar, int i, zzakr zzakrVar) {
        this.zzx = -1L;
        this.zzy = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzH = -1L;
        this.zzI = -1L;
        this.zzJ = -9223372036854775807L;
        this.zzak = zzahtVar;
        zzahtVar.zza(new zzahv(this, null));
        this.zzk = zzakrVar;
        this.zzi = 1 == ((i & 1) ^ 1);
        this.zzj = (i & 2) == 0;
        this.zzg = new zzaia();
        this.zzh = new SparseArray();
        this.zzn = new zzen(4);
        this.zzo = new zzen(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzp = new zzen(4);
        this.zzl = new zzen(zzfv.zza);
        this.zzm = new zzen(4);
        this.zzq = new zzen();
        this.zzr = new zzen();
        this.zzs = new zzen(8);
        this.zzt = new zzen();
        this.zzu = new zzen();
        this.zzT = new int[1];
    }

    protected final void zzn(int i, String str) throws zzaz {
        if (i == 134) {
            zzt(i);
            this.zzC.zzc = str;
            return;
        }
        if (i == 17026) {
            if ("webm".equals(str) || "matroska".equals(str)) {
                this.zzB = Objects.equals(str, "webm");
                return;
            }
            throw zzaz.zza("DocType " + str + " not supported", null);
        }
        if (i == 21358) {
            zzt(i);
            this.zzC.zzb = str;
        } else {
            if (i != 2274716) {
                return;
            }
            zzt(i);
            this.zzC.zzaa = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void zzh(int i, int i2, zzadw zzadwVar) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = i;
        int i15 = 1;
        int i16 = 0;
        if (i14 != 161 && i14 != 163) {
            if (i14 == 165) {
                if (this.zzO != 2) {
                    return;
                }
                zzahw zzahwVar = (zzahw) this.zzh.get(this.zzU);
                if (this.zzX != 4 || !"V_VP9".equals(zzahwVar.zzc)) {
                    zzadwVar.zzk(i2);
                    return;
                }
                zzen zzenVar = this.zzu;
                zzenVar.zzI(i2);
                zzadwVar.zzi(zzenVar.zzN(), 0, i2);
                return;
            }
            if (i14 == 16877) {
                zzt(i);
                zzahw zzahwVar2 = this.zzC;
                i12 = zzahwVar2.zzZ;
                if (i12 != 1685485123) {
                    i13 = zzahwVar2.zzZ;
                    if (i13 != 1685480259) {
                        zzadwVar.zzk(i2);
                        return;
                    }
                }
                zzahwVar2.zzO = new byte[i2];
                zzadwVar.zzi(zzahwVar2.zzO, 0, i2);
                return;
            }
            if (i14 == 16981) {
                zzt(i);
                zzahw zzahwVar3 = this.zzC;
                zzahwVar3.zzi = new byte[i2];
                zzadwVar.zzi(zzahwVar3.zzi, 0, i2);
                return;
            }
            if (i14 == 18402) {
                byte[] bArr = new byte[i2];
                zzadwVar.zzi(bArr, 0, i2);
                zzt(i);
                this.zzC.zzj = new zzafa(1, bArr, 0, 0);
                return;
            }
            if (i14 == 21419) {
                zzen zzenVar2 = this.zzp;
                Arrays.fill(zzenVar2.zzN(), (byte) 0);
                zzadwVar.zzi(zzenVar2.zzN(), 4 - i2, i2);
                zzenVar2.zzL(0);
                this.zzE = (int) zzenVar2.zzu();
                return;
            }
            if (i14 == 25506) {
                zzt(i);
                zzahw zzahwVar4 = this.zzC;
                zzahwVar4.zzk = new byte[i2];
                zzadwVar.zzi(zzahwVar4.zzk, 0, i2);
                return;
            }
            if (i14 != 30322) {
                throw zzaz.zza("Unexpected id: " + i14, null);
            }
            zzt(i);
            zzahw zzahwVar5 = this.zzC;
            zzahwVar5.zzw = new byte[i2];
            zzadwVar.zzi(zzahwVar5.zzw, 0, i2);
            return;
        }
        int i17 = 8;
        if (this.zzO == 0) {
            zzaia zzaiaVar = this.zzg;
            this.zzU = (int) zzaiaVar.zzd(zzadwVar, false, true, 8);
            this.zzV = zzaiaVar.zza();
            this.zzQ = -9223372036854775807L;
            this.zzO = 1;
            this.zzn.zzI(0);
        }
        zzahw zzahwVar6 = (zzahw) this.zzh.get(this.zzU);
        if (zzahwVar6 == null) {
            zzadwVar.zzk(i2 - this.zzV);
            this.zzO = 0;
            return;
        }
        zzahwVar6.zzX.getClass();
        if (this.zzO == 1) {
            zzv(zzadwVar, 3);
            zzen zzenVar3 = this.zzn;
            int i18 = (zzenVar3.zzN()[2] & 6) >> 1;
            if (i18 == 0) {
                this.zzS = 1;
                int[] zzz = zzz(this.zzT, 1);
                this.zzT = zzz;
                zzz[0] = (i2 - this.zzV) - 3;
            } else {
                zzv(zzadwVar, 4);
                int i19 = (zzenVar3.zzN()[3] & 255) + 1;
                this.zzS = i19;
                int[] zzz2 = zzz(this.zzT, i19);
                this.zzT = zzz2;
                if (i18 == 2) {
                    int i20 = (i2 - this.zzV) - 4;
                    int i21 = this.zzS;
                    Arrays.fill(zzz2, 0, i21, i20 / i21);
                } else {
                    if (i18 != 1) {
                        if (i18 != 3) {
                            throw zzaz.zza("Unexpected lacing value: 2", null);
                        }
                        int i22 = 0;
                        int i23 = 0;
                        int i24 = 4;
                        while (true) {
                            int i25 = this.zzS - 1;
                            if (i22 >= i25) {
                                i3 = i15;
                                i5 = i16;
                                this.zzT[i25] = ((i2 - this.zzV) - i24) - i23;
                                break;
                            }
                            this.zzT[i22] = i16;
                            int i26 = i24 + 1;
                            zzv(zzadwVar, i26);
                            if (zzenVar3.zzN()[i24] == 0) {
                                throw zzaz.zza("No valid varint length mask found", null);
                            }
                            int i27 = i15;
                            int i28 = i16;
                            while (true) {
                                if (i28 >= i17) {
                                    i6 = i16;
                                    i7 = i17;
                                    j = 0;
                                    break;
                                }
                                i7 = i17;
                                int i29 = i27 << (7 - i28);
                                if ((zzenVar3.zzN()[i24] & i29) != 0) {
                                    i26 += i28;
                                    zzv(zzadwVar, i26);
                                    i6 = i16;
                                    j = zzenVar3.zzN()[i24] & 255 & (~i29);
                                    int i30 = i24 + 1;
                                    while (i30 < i26) {
                                        j = (j << i7) | (zzenVar3.zzN()[i30] & 255);
                                        i30++;
                                        i28 = i28;
                                    }
                                    int i31 = i28;
                                    if (i22 > 0) {
                                        j -= (1 << ((i31 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i28++;
                                    i17 = i7;
                                }
                            }
                            i24 = i26;
                            if (j < -2147483648L || j > 2147483647L) {
                                break;
                            }
                            int[] iArr = this.zzT;
                            int i32 = (int) j;
                            if (i22 != 0) {
                                i32 += iArr[i22 - 1];
                            }
                            iArr[i22] = i32;
                            i23 += i32;
                            i22++;
                            i15 = i27;
                            i16 = i6;
                            i17 = i7;
                        }
                        throw zzaz.zza("EBML lacing sample size out of range.", null);
                    }
                    int i33 = 0;
                    int i34 = 0;
                    int i35 = 4;
                    while (true) {
                        i8 = this.zzS - 1;
                        if (i33 >= i8) {
                            break;
                        }
                        this.zzT[i33] = 0;
                        while (true) {
                            i9 = i35 + 1;
                            zzv(zzadwVar, i9);
                            int i36 = zzenVar3.zzN()[i35] & 255;
                            int[] iArr2 = this.zzT;
                            i10 = iArr2[i33] + i36;
                            iArr2[i33] = i10;
                            if (i36 != 255) {
                                break;
                            } else {
                                i35 = i9;
                            }
                        }
                        i34 += i10;
                        i33++;
                        i35 = i9;
                    }
                    this.zzT[i8] = ((i2 - this.zzV) - i35) - i34;
                }
            }
            i3 = 1;
            i5 = 0;
            this.zzP = this.zzJ + zzr((zzenVar3.zzN()[i5] << 8) | (zzenVar3.zzN()[i3] & 255));
            if (zzahwVar6.zze == 2) {
                i11 = i3;
            } else if (i14 == 163) {
                i11 = (zzenVar3.zzN()[2] & 128) == 128 ? i3 : i5;
                i14 = 163;
            } else {
                i11 = i5;
            }
            this.zzW = i11;
            this.zzO = 2;
            this.zzR = i5;
            i4 = 163;
        } else {
            i3 = 1;
            i4 = 163;
        }
        if (i14 == i4) {
            while (true) {
                int i37 = this.zzR;
                if (i37 >= this.zzS) {
                    this.zzO = 0;
                    return;
                }
                int zzp = zzp(zzadwVar, zzahwVar6, this.zzT[i37], false);
                zzahw zzahwVar7 = zzahwVar6;
                zzu(zzahwVar7, this.zzP + ((this.zzR * zzahwVar6.zzf) / 1000), this.zzW, zzp, 0);
                this.zzR++;
                zzahwVar6 = zzahwVar7;
            }
        } else {
            while (true) {
                int i38 = this.zzR;
                if (i38 >= this.zzS) {
                    return;
                }
                int[] iArr3 = this.zzT;
                boolean z = i3;
                iArr3[i38] = zzp(zzadwVar, zzahwVar6, iArr3[i38], z);
                this.zzR += z ? 1 : 0;
            }
        }
    }

    public zzahy(zzakr zzakrVar, int i) {
        this(new zzaht(), 0, zzakrVar);
    }

    protected final void zzk(int i, double d) throws zzaz {
        if (i == 181) {
            zzt(i);
            this.zzC.zzR = (int) d;
            return;
        }
        if (i == 17545) {
            this.zzz = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                zzt(i);
                this.zzC.zzE = (float) d;
                break;
            case 21970:
                zzt(i);
                this.zzC.zzF = (float) d;
                break;
            case 21971:
                zzt(i);
                this.zzC.zzG = (float) d;
                break;
            case 21972:
                zzt(i);
                this.zzC.zzH = (float) d;
                break;
            case 21973:
                zzt(i);
                this.zzC.zzI = (float) d;
                break;
            case 21974:
                zzt(i);
                this.zzC.zzJ = (float) d;
                break;
            case 21975:
                zzt(i);
                this.zzC.zzK = (float) d;
                break;
            case 21976:
                zzt(i);
                this.zzC.zzL = (float) d;
                break;
            case 21977:
                zzt(i);
                this.zzC.zzM = (float) d;
                break;
            case 21978:
                zzt(i);
                this.zzC.zzN = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        zzt(i);
                        this.zzC.zzt = (float) d;
                        break;
                    case 30324:
                        zzt(i);
                        this.zzC.zzu = (float) d;
                        break;
                    case 30325:
                        zzt(i);
                        this.zzC.zzv = (float) d;
                        break;
                }
        }
    }

    protected final void zzl(int i, long j) throws zzaz {
        boolean z;
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw zzaz.zza("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw zzaz.zza("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case MRAID_JS_WRITE_FAILED_VALUE:
                zzt(i);
                this.zzC.zze = (int) j;
                return;
            case 136:
                z = j == 1;
                zzt(i);
                this.zzC.zzW = z;
                return;
            case 155:
                this.zzQ = zzr(j);
                return;
            case 159:
                zzt(i);
                this.zzC.zzP = (int) j;
                return;
            case 176:
                zzt(i);
                this.zzC.zzm = (int) j;
                return;
            case 179:
                zzs(i);
                this.zzK.zzc(zzr(j));
                return;
            case 186:
                zzt(i);
                this.zzC.zzn = (int) j;
                return;
            case AD_RESPONSE_EMPTY_VALUE:
                zzt(i);
                this.zzC.zzd = (int) j;
                return;
            case 231:
                this.zzJ = zzr(j);
                return;
            case 238:
                this.zzX = (int) j;
                return;
            case 241:
                if (this.zzM) {
                    return;
                }
                zzs(i);
                this.zzL.zzc(j);
                this.zzM = true;
                return;
            case 251:
                this.zzY = true;
                return;
            case 16871:
                zzt(i);
                this.zzC.zzZ = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw zzaz.zza("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw zzaz.zza("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw zzaz.zza("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw zzaz.zza("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw zzaz.zza("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.zzF = j + this.zzx;
                return;
            case 21432:
                int i2 = (int) j;
                zzt(i);
                if (i2 == 0) {
                    this.zzC.zzx = 0;
                    return;
                }
                if (i2 == 1) {
                    this.zzC.zzx = 2;
                    return;
                } else if (i2 == 3) {
                    this.zzC.zzx = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.zzC.zzx = 3;
                    return;
                }
            case 21680:
                zzt(i);
                this.zzC.zzp = (int) j;
                return;
            case 21682:
                zzt(i);
                this.zzC.zzr = (int) j;
                return;
            case 21690:
                zzt(i);
                this.zzC.zzq = (int) j;
                return;
            case 21930:
                z = j == 1;
                zzt(i);
                this.zzC.zzV = z;
                return;
            case 21938:
                zzt(i);
                zzahw zzahwVar = this.zzC;
                zzahwVar.zzy = true;
                zzahwVar.zzo = (int) j;
                return;
            case 21998:
                zzt(i);
                this.zzC.zzg = (int) j;
                return;
            case 22186:
                zzt(i);
                this.zzC.zzS = j;
                return;
            case 22203:
                zzt(i);
                this.zzC.zzT = j;
                return;
            case 25188:
                zzt(i);
                this.zzC.zzQ = (int) j;
                return;
            case 30114:
                this.zzZ = j;
                return;
            case 30321:
                int i3 = (int) j;
                zzt(i);
                if (i3 == 0) {
                    this.zzC.zzs = 0;
                    return;
                }
                if (i3 == 1) {
                    this.zzC.zzs = 1;
                    return;
                } else if (i3 == 2) {
                    this.zzC.zzs = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.zzC.zzs = 3;
                    return;
                }
            case 2352003:
                zzt(i);
                this.zzC.zzf = (int) j;
                return;
            case 2807729:
                this.zzy = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i4 = (int) j;
                        zzt(i);
                        if (i4 == 1) {
                            this.zzC.zzB = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.zzC.zzB = 1;
                            return;
                        }
                    case 21946:
                        zzt(i);
                        int zzb2 = zzk.zzb((int) j);
                        if (zzb2 != -1) {
                            this.zzC.zzA = zzb2;
                            return;
                        }
                        return;
                    case 21947:
                        zzt(i);
                        this.zzC.zzy = true;
                        int zza2 = zzk.zza((int) j);
                        if (zza2 != -1) {
                            this.zzC.zzz = zza2;
                            return;
                        }
                        return;
                    case 21948:
                        zzt(i);
                        this.zzC.zzC = (int) j;
                        return;
                    case 21949:
                        zzt(i);
                        this.zzC.zzD = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }
}
