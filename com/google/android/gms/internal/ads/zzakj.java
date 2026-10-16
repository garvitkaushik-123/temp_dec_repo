package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzakj extends zzakh {
    private zzaki zza;
    private int zzb;
    private boolean zzc;
    private zzafg zzd;
    private zzafe zze;

    zzakj() {
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    protected final long zza(zzen zzenVar) {
        if ((zzenVar.zzN()[0] & 1) == 1) {
            return -1L;
        }
        byte b = zzenVar.zzN()[0];
        zzaki zzakiVar = this.zza;
        zzdd.zzb(zzakiVar);
        int i = !zzakiVar.zzd[(b >> 1) & (255 >>> (8 - zzakiVar.zze))].zza ? zzakiVar.zza.zze : zzakiVar.zza.zzf;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzenVar.zzb() < zzenVar.zzd() + 4) {
            byte[] copyOf = Arrays.copyOf(zzenVar.zzN(), zzenVar.zzd() + 4);
            zzenVar.zzJ(copyOf, copyOf.length);
        } else {
            zzenVar.zzK(zzenVar.zzd() + 4);
        }
        long j = i2;
        byte[] zzN = zzenVar.zzN();
        zzN[zzenVar.zzd() - 4] = (byte) (j & 255);
        zzN[zzenVar.zzd() - 3] = (byte) ((j >>> 8) & 255);
        zzN[zzenVar.zzd() - 2] = (byte) ((j >>> 16) & 255);
        zzN[zzenVar.zzd() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    protected final void zzi(long j) {
        super.zzi(j);
        this.zzc = j != 0;
        zzafg zzafgVar = this.zzd;
        this.zzb = zzafgVar != null ? zzafgVar.zze : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzen zzenVar, long j, zzake zzakeVar) throws IOException {
        zzaki zzakiVar;
        int i;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        long j2;
        if (this.zza != null) {
            zzakeVar.zza.getClass();
            return false;
        }
        zzafg zzafgVar = this.zzd;
        int i5 = 1;
        if (zzafgVar == null) {
            zzafh.zzd(1, zzenVar, false);
            int zzj = zzenVar.zzj();
            int zzm = zzenVar.zzm();
            int zzj2 = zzenVar.zzj();
            int zzi = zzenVar.zzi();
            int i6 = zzi <= 0 ? -1 : zzi;
            int zzi2 = zzenVar.zzi();
            int i7 = zzi2 <= 0 ? -1 : zzi2;
            int zzi3 = zzenVar.zzi();
            int i8 = zzi3 <= 0 ? -1 : zzi3;
            int zzm2 = zzenVar.zzm();
            this.zzd = new zzafg(zzj, zzm, zzj2, i6, i7, i8, (int) Math.pow(2.0d, zzm2 & 15), (int) Math.pow(2.0d, (zzm2 & 240) >> 4), 1 == (zzenVar.zzm() & 1), Arrays.copyOf(zzenVar.zzN(), zzenVar.zzd()));
        } else {
            int i9 = 4;
            zzafe zzafeVar = this.zze;
            if (zzafeVar == null) {
                this.zze = zzafh.zzc(zzenVar, true, true);
            } else {
                byte[] bArr = new byte[zzenVar.zzd()];
                System.arraycopy(zzenVar.zzN(), 0, bArr, 0, zzenVar.zzd());
                int i10 = zzafgVar.zza;
                int i11 = 5;
                zzafh.zzd(5, zzenVar, false);
                int zzm3 = zzenVar.zzm() + 1;
                zzafd zzafdVar = new zzafd(zzenVar.zzN());
                zzafdVar.zzc(zzenVar.zzc() * 8);
                int i12 = 0;
                while (true) {
                    int i13 = 2;
                    int i14 = 16;
                    if (i12 >= zzm3) {
                        int i15 = i5;
                        int i16 = 6;
                        int zzb = zzafdVar.zzb(6) + i15;
                        for (int i17 = 0; i17 < zzb; i17++) {
                            if (zzafdVar.zzb(16) != 0) {
                                throw zzaz.zza("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int zzb2 = zzafdVar.zzb(6) + i15;
                        int i18 = 0;
                        while (true) {
                            int i19 = 3;
                            if (i18 < zzb2) {
                                int zzb3 = zzafdVar.zzb(i14);
                                if (zzb3 == 0) {
                                    int i20 = 8;
                                    zzafdVar.zzc(8);
                                    zzafdVar.zzc(16);
                                    zzafdVar.zzc(16);
                                    zzafdVar.zzc(6);
                                    zzafdVar.zzc(8);
                                    int zzb4 = zzafdVar.zzb(4) + 1;
                                    int i21 = 0;
                                    while (i21 < zzb4) {
                                        zzafdVar.zzc(i20);
                                        i21++;
                                        i20 = 8;
                                    }
                                } else {
                                    if (zzb3 != i15) {
                                        throw zzaz.zza("floor type greater than 1 not decodable: " + zzb3, null);
                                    }
                                    int zzb5 = zzafdVar.zzb(5);
                                    int[] iArr2 = new int[zzb5];
                                    int i22 = -1;
                                    for (int i23 = 0; i23 < zzb5; i23++) {
                                        int zzb6 = zzafdVar.zzb(4);
                                        iArr2[i23] = zzb6;
                                        if (zzb6 > i22) {
                                            i22 = zzb6;
                                        }
                                    }
                                    int i24 = i22 + 1;
                                    int[] iArr3 = new int[i24];
                                    int i25 = 0;
                                    while (i25 < i24) {
                                        int i26 = 1;
                                        iArr3[i25] = zzafdVar.zzb(i19) + 1;
                                        int zzb7 = zzafdVar.zzb(2);
                                        if (zzb7 > 0) {
                                            i3 = 8;
                                            zzafdVar.zzc(8);
                                        } else {
                                            i3 = 8;
                                        }
                                        int i27 = i24;
                                        int i28 = 0;
                                        while (true) {
                                            int i29 = i26 << zzb7;
                                            iArr = iArr2;
                                            if (i28 < i29) {
                                                zzafdVar.zzc(i3);
                                                i28++;
                                                iArr2 = iArr;
                                                i3 = 8;
                                                i26 = 1;
                                            }
                                        }
                                        i25++;
                                        iArr2 = iArr;
                                        i24 = i27;
                                        i19 = 3;
                                    }
                                    int[] iArr4 = iArr2;
                                    zzafdVar.zzc(2);
                                    int zzb8 = zzafdVar.zzb(4);
                                    int i30 = 0;
                                    int i31 = 0;
                                    for (int i32 = 0; i32 < zzb5; i32++) {
                                        i30 += iArr3[iArr4[i32]];
                                        while (i31 < i30) {
                                            zzafdVar.zzc(zzb8);
                                            i31++;
                                        }
                                    }
                                }
                                i18++;
                                i16 = 6;
                                i14 = 16;
                                i15 = 1;
                            } else {
                                int i33 = 1;
                                int zzb9 = zzafdVar.zzb(i16) + 1;
                                int i34 = 0;
                                while (i34 < zzb9) {
                                    if (zzafdVar.zzb(16) > 2) {
                                        throw zzaz.zza("residueType greater than 2 is not decodable", null);
                                    }
                                    zzafdVar.zzc(24);
                                    zzafdVar.zzc(24);
                                    zzafdVar.zzc(24);
                                    int zzb10 = zzafdVar.zzb(i16) + i33;
                                    int i35 = 8;
                                    zzafdVar.zzc(8);
                                    int[] iArr5 = new int[zzb10];
                                    for (int i36 = 0; i36 < zzb10; i36++) {
                                        iArr5[i36] = ((zzafdVar.zzd() ? zzafdVar.zzb(5) : 0) * 8) + zzafdVar.zzb(3);
                                    }
                                    int i37 = 0;
                                    while (i37 < zzb10) {
                                        int i38 = 0;
                                        while (i38 < i35) {
                                            if ((iArr5[i37] & (1 << i38)) != 0) {
                                                zzafdVar.zzc(i35);
                                            }
                                            i38++;
                                            i35 = 8;
                                        }
                                        i37++;
                                        i35 = 8;
                                    }
                                    i34++;
                                    i16 = 6;
                                    i33 = 1;
                                }
                                int zzb11 = zzafdVar.zzb(i16) + 1;
                                for (int i39 = 0; i39 < zzb11; i39++) {
                                    int zzb12 = zzafdVar.zzb(16);
                                    if (zzb12 != 0) {
                                        zzea.zzc("VorbisUtil", "mapping type other than 0 not supported: " + zzb12);
                                    } else {
                                        if (zzafdVar.zzd()) {
                                            i = 1;
                                            i2 = zzafdVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            i2 = 1;
                                        }
                                        if (zzafdVar.zzd()) {
                                            int zzb13 = zzafdVar.zzb(8) + i;
                                            for (int i40 = 0; i40 < zzb13; i40++) {
                                                int i41 = i10 - 1;
                                                zzafdVar.zzc(zzafh.zza(i41));
                                                zzafdVar.zzc(zzafh.zza(i41));
                                            }
                                        }
                                        if (zzafdVar.zzb(2) != 0) {
                                            throw zzaz.zza("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (i2 > 1) {
                                            for (int i42 = 0; i42 < i10; i42++) {
                                                zzafdVar.zzc(4);
                                            }
                                        }
                                        for (int i43 = 0; i43 < i2; i43++) {
                                            zzafdVar.zzc(8);
                                            zzafdVar.zzc(8);
                                            zzafdVar.zzc(8);
                                        }
                                    }
                                }
                                int zzb14 = zzafdVar.zzb(6);
                                int i44 = zzb14 + 1;
                                zzaff[] zzaffVarArr = new zzaff[i44];
                                for (int i45 = 0; i45 < i44; i45++) {
                                    zzaffVarArr[i45] = new zzaff(zzafdVar.zzd(), zzafdVar.zzb(16), zzafdVar.zzb(16), zzafdVar.zzb(8));
                                }
                                if (!zzafdVar.zzd()) {
                                    throw zzaz.zza("framing bit after modes not set as expected", null);
                                }
                                zzakiVar = new zzaki(zzafgVar, zzafeVar, bArr, zzaffVarArr, zzafh.zza(zzb14));
                            }
                        }
                    } else {
                        if (zzafdVar.zzb(24) != 5653314) {
                            throw zzaz.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzafdVar.zza(), null);
                        }
                        int zzb15 = zzafdVar.zzb(16);
                        int zzb16 = zzafdVar.zzb(24);
                        if (zzafdVar.zzd()) {
                            zzafdVar.zzc(i11);
                            for (int i46 = 0; i46 < zzb16; i46 += zzafdVar.zzb(zzafh.zza(zzb16 - i46))) {
                            }
                        } else {
                            boolean zzd = zzafdVar.zzd();
                            for (int i47 = 0; i47 < zzb16; i47++) {
                                if (!zzd) {
                                    zzafdVar.zzc(i11);
                                } else if (zzafdVar.zzd()) {
                                    zzafdVar.zzc(i11);
                                }
                            }
                        }
                        int i48 = i9;
                        int zzb17 = zzafdVar.zzb(i48);
                        if (zzb17 > 2) {
                            throw zzaz.zza("lookup type greater than 2 not decodable: " + zzb17, null);
                        }
                        if (zzb17 == i5) {
                            i13 = zzb17;
                        } else if (zzb17 != 2) {
                            i4 = i5;
                            i12++;
                            i5 = i4;
                            i9 = 4;
                            i11 = 5;
                        }
                        zzafdVar.zzc(32);
                        zzafdVar.zzc(32);
                        int zzb18 = zzafdVar.zzb(i48) + i5;
                        zzafdVar.zzc(i5);
                        if (i13 != i5) {
                            i4 = i5;
                            j2 = zzb15 * zzb16;
                        } else if (zzb15 != 0) {
                            i4 = i5;
                            j2 = (long) Math.floor(Math.pow(zzb16, 1.0d / zzb15));
                        } else {
                            i4 = i5;
                            j2 = 0;
                        }
                        zzafdVar.zzc((int) (j2 * zzb18));
                        i12++;
                        i5 = i4;
                        i9 = 4;
                        i11 = 5;
                    }
                }
            }
        }
        zzakiVar = null;
        this.zza = zzakiVar;
        if (zzakiVar == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        zzafg zzafgVar2 = zzakiVar.zza;
        arrayList.add(zzafgVar2.zzg);
        arrayList.add(zzakiVar.zzc);
        zzav zzb19 = zzafh.zzb(zzfyq.zzm(zzakiVar.zzb.zza));
        zzx zzxVar = new zzx();
        zzxVar.zzG("audio/ogg");
        zzxVar.zzah("audio/vorbis");
        zzxVar.zzC(zzafgVar2.zzd);
        zzxVar.zzac(zzafgVar2.zzc);
        zzxVar.zzD(zzafgVar2.zza);
        zzxVar.zzai(zzafgVar2.zzb);
        zzxVar.zzT(arrayList);
        zzxVar.zzaa(zzb19);
        zzakeVar.zza = zzxVar.zzan();
        return true;
    }
}
