package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaie implements zzadv {
    private final zzen zza;
    private final zzaen zzb;
    private final zzaej zzc;
    private final zzael zzd;
    private final zzafb zze;
    private zzady zzf;
    private zzafb zzg;
    private zzafb zzh;
    private int zzi;
    private zzav zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private zzaig zzp;
    private boolean zzq;

    public zzaie() {
        throw null;
    }

    public zzaie(int i) {
        this.zza = new zzen(10);
        this.zzb = new zzaen();
        this.zzc = new zzaej();
        this.zzk = -9223372036854775807L;
        this.zzd = new zzael();
        zzadr zzadrVar = new zzadr();
        this.zze = zzadrVar;
        this.zzh = zzadrVar;
        this.zzn = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00b9  */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45, types: [com.google.android.gms.internal.ads.zzaig] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v65 */
    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zzg(zzadw zzadwVar) throws IOException {
        long j;
        Throwable th;
        int i;
        zzaej zzaejVar;
        long j2;
        int i2;
        Object zzaibVar;
        int i3;
        int i4;
        zzav zzavVar;
        Object obj;
        zzaif zzaifVar;
        long j3;
        Object obj2;
        if (this.zzi == 0) {
            try {
                zzm(zzadwVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.zzp == null) {
            zzaen zzaenVar = this.zzb;
            zzen zzenVar = new zzen(zzaenVar.zzc);
            zzadwVar.zzh(zzenVar.zzN(), 0, zzaenVar.zzc);
            int i5 = 21;
            if ((zzaenVar.zza & 1) != 0) {
                if (zzaenVar.zze != 1) {
                    i5 = 36;
                }
            } else if (zzaenVar.zze == 1) {
                i5 = 13;
            }
            j = -9223372036854775807L;
            if (zzenVar.zzd() >= i5 + 4) {
                zzenVar.zzL(i5);
                i = zzenVar.zzg();
                if (i != 1483304551) {
                    if (i == 1231971951) {
                        i = 1231971951;
                    }
                }
                if (i != 1231971951) {
                    if (i == 1447187017) {
                        Object zzb = zzaih.zzb(zzadwVar.zzd(), zzadwVar.zzf(), zzaenVar, zzenVar);
                        zzadwVar.zzk(zzaenVar.zzc);
                        obj2 = zzb;
                    } else if (i != 1483304551) {
                        zzadwVar.zzj();
                        obj2 = null;
                    }
                    th = null;
                    zzaibVar = obj2;
                    zzavVar = this.zzj;
                    long zzf = zzadwVar.zzf();
                    if (zzavVar != null) {
                        int zza = zzavVar.zza();
                        for (int i6 = 0; i6 < zza; i6++) {
                            zzau zzb2 = zzavVar.zzb(i6);
                            if (zzb2 instanceof zzahi) {
                                zzahi zzahiVar = (zzahi) zzb2;
                                int zza2 = zzavVar.zza();
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= zza2) {
                                        j3 = -9223372036854775807L;
                                        break;
                                    }
                                    zzau zzb3 = zzavVar.zzb(i7);
                                    if (zzb3 instanceof zzahk) {
                                        zzahk zzahkVar = (zzahk) zzb3;
                                        if (zzahkVar.zzf.equals("TLEN")) {
                                            j3 = zzex.zzs(Long.parseLong((String) zzahkVar.zzb.get(0)));
                                            break;
                                        }
                                    }
                                    i7++;
                                }
                                obj = zzaid.zzb(zzf, zzahiVar, j3);
                                ?? r2 = zzaibVar;
                                if (this.zzq) {
                                    if (obj != null) {
                                        r2 = obj;
                                    } else if (zzaibVar == null) {
                                        r2 = th;
                                    }
                                    if (r2 == 0) {
                                        zzen zzenVar2 = this.zza;
                                        zzadwVar.zzh(zzenVar2.zzN(), 0, 4);
                                        zzenVar2.zzL(0);
                                        zzaenVar.zza(zzenVar2.zzg());
                                        r2 = new zzaib(zzadwVar.zzd(), zzadwVar.zzf(), zzaenVar.zzf, zzaenVar.zzc, false);
                                    }
                                    this.zzg.zzl(r2.zza());
                                    zzaifVar = r2;
                                } else {
                                    zzaifVar = new zzaif();
                                }
                                this.zzp = zzaifVar;
                                this.zzf.zzP(zzaifVar);
                                zzx zzxVar = new zzx();
                                zzxVar.zzG("audio/mpeg");
                                zzxVar.zzah(zzaenVar.zzb);
                                zzxVar.zzX(4096);
                                zzxVar.zzD(zzaenVar.zze);
                                zzxVar.zzai(zzaenVar.zzd);
                                zzaej zzaejVar2 = this.zzc;
                                zzxVar.zzM(zzaejVar2.zza);
                                zzxVar.zzN(zzaejVar2.zzb);
                                zzxVar.zzaa(this.zzj);
                                if (this.zzp.zzc() != -2147483647) {
                                    zzxVar.zzC(this.zzp.zzc());
                                }
                                this.zzh.zzm(zzxVar.zzan());
                                this.zzm = zzadwVar.zzf();
                            }
                        }
                    }
                    obj = th;
                    ?? r22 = zzaibVar;
                    if (this.zzq) {
                    }
                    this.zzp = zzaifVar;
                    this.zzf.zzP(zzaifVar);
                    zzx zzxVar2 = new zzx();
                    zzxVar2.zzG("audio/mpeg");
                    zzxVar2.zzah(zzaenVar.zzb);
                    zzxVar2.zzX(4096);
                    zzxVar2.zzD(zzaenVar.zze);
                    zzxVar2.zzai(zzaenVar.zzd);
                    zzaej zzaejVar22 = this.zzc;
                    zzxVar2.zzM(zzaejVar22.zza);
                    zzxVar2.zzN(zzaejVar22.zzb);
                    zzxVar2.zzaa(this.zzj);
                    if (this.zzp.zzc() != -2147483647) {
                    }
                    this.zzh.zzm(zzxVar2.zzan());
                    this.zzm = zzadwVar.zzf();
                }
                zzaii zzb4 = zzaii.zzb(zzaenVar, zzenVar);
                zzaejVar = this.zzc;
                if (!zzaejVar.zza() && (i3 = zzb4.zzd) != -1 && (i4 = zzb4.zze) != -1) {
                    zzaejVar.zza = i3;
                    zzaejVar.zzb = i4;
                }
                long zzf2 = zzadwVar.zzf();
                if (zzadwVar.zzd() != -1) {
                    long j4 = zzb4.zzc;
                    if (j4 != -1) {
                        long j5 = j4 + zzf2;
                        if (zzadwVar.zzd() != j5) {
                            j2 = -1;
                            th = null;
                            zzea.zze("Mp3Extractor", "Data size mismatch between stream (" + zzadwVar.zzd() + ") and Xing frame (" + j5 + "), using Xing value.");
                            zzadwVar.zzk(zzaenVar.zzc);
                            if (i != 1483304551) {
                                zzaibVar = zzaij.zzb(zzb4, zzf2);
                            } else {
                                long zzd = zzadwVar.zzd();
                                long zza3 = zzb4.zza();
                                if (zza3 != -9223372036854775807L) {
                                    long j6 = zzb4.zzc;
                                    if (j6 != j2) {
                                        zzd = zzf2 + j6;
                                        i2 = zzb4.zza.zzc;
                                    } else if (zzd != j2) {
                                        j6 = zzd - zzf2;
                                        i2 = zzb4.zza.zzc;
                                    }
                                    long j7 = j6 - i2;
                                    zzaibVar = new zzaib(zzd, zzf2 + zzb4.zza.zzc, zzgbt.zzb(zzex.zzu(j7, 8000000L, zza3, RoundingMode.HALF_UP)), zzgbt.zzb(zzgbo.zzb(j7, zzb4.zzb, RoundingMode.HALF_UP)), false);
                                }
                                zzaibVar = th;
                            }
                            zzavVar = this.zzj;
                            long zzf3 = zzadwVar.zzf();
                            if (zzavVar != null) {
                            }
                            obj = th;
                            ?? r222 = zzaibVar;
                            if (this.zzq) {
                            }
                            this.zzp = zzaifVar;
                            this.zzf.zzP(zzaifVar);
                            zzx zzxVar22 = new zzx();
                            zzxVar22.zzG("audio/mpeg");
                            zzxVar22.zzah(zzaenVar.zzb);
                            zzxVar22.zzX(4096);
                            zzxVar22.zzD(zzaenVar.zze);
                            zzxVar22.zzai(zzaenVar.zzd);
                            zzaej zzaejVar222 = this.zzc;
                            zzxVar22.zzM(zzaejVar222.zza);
                            zzxVar22.zzN(zzaejVar222.zzb);
                            zzxVar22.zzaa(this.zzj);
                            if (this.zzp.zzc() != -2147483647) {
                            }
                            this.zzh.zzm(zzxVar22.zzan());
                            this.zzm = zzadwVar.zzf();
                        }
                    }
                }
                j2 = -1;
                th = null;
                zzadwVar.zzk(zzaenVar.zzc);
                if (i != 1483304551) {
                }
                zzavVar = this.zzj;
                long zzf32 = zzadwVar.zzf();
                if (zzavVar != null) {
                }
                obj = th;
                ?? r2222 = zzaibVar;
                if (this.zzq) {
                }
                this.zzp = zzaifVar;
                this.zzf.zzP(zzaifVar);
                zzx zzxVar222 = new zzx();
                zzxVar222.zzG("audio/mpeg");
                zzxVar222.zzah(zzaenVar.zzb);
                zzxVar222.zzX(4096);
                zzxVar222.zzD(zzaenVar.zze);
                zzxVar222.zzai(zzaenVar.zzd);
                zzaej zzaejVar2222 = this.zzc;
                zzxVar222.zzM(zzaejVar2222.zza);
                zzxVar222.zzN(zzaejVar2222.zzb);
                zzxVar222.zzaa(this.zzj);
                if (this.zzp.zzc() != -2147483647) {
                }
                this.zzh.zzm(zzxVar222.zzan());
                this.zzm = zzadwVar.zzf();
            }
            if (zzenVar.zzd() >= 40) {
                zzenVar.zzL(36);
                if (zzenVar.zzg() == 1447187017) {
                    i = 1447187017;
                    if (i != 1231971951) {
                    }
                    zzaii zzb42 = zzaii.zzb(zzaenVar, zzenVar);
                    zzaejVar = this.zzc;
                    if (!zzaejVar.zza()) {
                        zzaejVar.zza = i3;
                        zzaejVar.zzb = i4;
                    }
                    long zzf22 = zzadwVar.zzf();
                    if (zzadwVar.zzd() != -1) {
                    }
                    j2 = -1;
                    th = null;
                    zzadwVar.zzk(zzaenVar.zzc);
                    if (i != 1483304551) {
                    }
                    zzavVar = this.zzj;
                    long zzf322 = zzadwVar.zzf();
                    if (zzavVar != null) {
                    }
                    obj = th;
                    ?? r22222 = zzaibVar;
                    if (this.zzq) {
                    }
                    this.zzp = zzaifVar;
                    this.zzf.zzP(zzaifVar);
                    zzx zzxVar2222 = new zzx();
                    zzxVar2222.zzG("audio/mpeg");
                    zzxVar2222.zzah(zzaenVar.zzb);
                    zzxVar2222.zzX(4096);
                    zzxVar2222.zzD(zzaenVar.zze);
                    zzxVar2222.zzai(zzaenVar.zzd);
                    zzaej zzaejVar22222 = this.zzc;
                    zzxVar2222.zzM(zzaejVar22222.zza);
                    zzxVar2222.zzN(zzaejVar22222.zzb);
                    zzxVar2222.zzaa(this.zzj);
                    if (this.zzp.zzc() != -2147483647) {
                    }
                    this.zzh.zzm(zzxVar2222.zzan());
                    this.zzm = zzadwVar.zzf();
                }
            }
            i = 0;
            if (i != 1231971951) {
            }
            zzaii zzb422 = zzaii.zzb(zzaenVar, zzenVar);
            zzaejVar = this.zzc;
            if (!zzaejVar.zza()) {
            }
            long zzf222 = zzadwVar.zzf();
            if (zzadwVar.zzd() != -1) {
            }
            j2 = -1;
            th = null;
            zzadwVar.zzk(zzaenVar.zzc);
            if (i != 1483304551) {
            }
            zzavVar = this.zzj;
            long zzf3222 = zzadwVar.zzf();
            if (zzavVar != null) {
            }
            obj = th;
            ?? r222222 = zzaibVar;
            if (this.zzq) {
            }
            this.zzp = zzaifVar;
            this.zzf.zzP(zzaifVar);
            zzx zzxVar22222 = new zzx();
            zzxVar22222.zzG("audio/mpeg");
            zzxVar22222.zzah(zzaenVar.zzb);
            zzxVar22222.zzX(4096);
            zzxVar22222.zzD(zzaenVar.zze);
            zzxVar22222.zzai(zzaenVar.zzd);
            zzaej zzaejVar222222 = this.zzc;
            zzxVar22222.zzM(zzaejVar222222.zza);
            zzxVar22222.zzN(zzaejVar222222.zzb);
            zzxVar22222.zzaa(this.zzj);
            if (this.zzp.zzc() != -2147483647) {
            }
            this.zzh.zzm(zzxVar22222.zzan());
            this.zzm = zzadwVar.zzf();
        } else {
            j = -9223372036854775807L;
            th = null;
            long j8 = this.zzm;
            if (j8 != 0) {
                long zzf4 = zzadwVar.zzf();
                if (zzf4 < j8) {
                    zzadwVar.zzk((int) (j8 - zzf4));
                }
            }
        }
        int i8 = this.zzo;
        if (i8 == 0) {
            zzadwVar.zzj();
            if (zzl(zzadwVar)) {
                return -1;
            }
            zzen zzenVar3 = this.zza;
            zzenVar3.zzL(0);
            int zzg = zzenVar3.zzg();
            if (!zzk(zzg, this.zzi) || zzaeo.zzb(zzg) == -1) {
                zzadwVar.zzk(1);
                this.zzi = 0;
                return 0;
            }
            zzaen zzaenVar2 = this.zzb;
            zzaenVar2.zza(zzg);
            if (this.zzk == j) {
                this.zzk = this.zzp.zze(zzadwVar.zzf());
            }
            i8 = zzaenVar2.zzc;
            this.zzo = i8;
            this.zzn = zzadwVar.zzf() + i8;
            zzaig zzaigVar = this.zzp;
            if (zzaigVar instanceof zzaic) {
                zzh(this.zzl + zzaenVar2.zzg);
                throw th;
            }
        }
        int zzf5 = this.zzh.zzf(zzadwVar, i8, true);
        if (zzf5 == -1) {
            return -1;
        }
        int i9 = this.zzo - zzf5;
        this.zzo = i9;
        if (i9 > 0) {
            return 0;
        }
        this.zzh.zzt(zzh(this.zzl), 1, this.zzb.zzc, 0, null);
        this.zzl += r1.zzg;
        this.zzo = 0;
        return 0;
    }

    private final long zzh(long j) {
        return this.zzk + ((j * 1000000) / this.zzb.zzd);
    }

    private final void zzj() {
        zzaig zzaigVar = this.zzp;
        if ((zzaigVar instanceof zzaib) && zzaigVar.zzh()) {
            long j = this.zzn;
            if (j == -1 || j == this.zzp.zzd()) {
                return;
            }
            this.zzp = ((zzaib) this.zzp).zzf(this.zzn);
            zzady zzadyVar = this.zzf;
            zzadyVar.getClass();
            zzadyVar.zzP(this.zzp);
            this.zzg.getClass();
            this.zzp.zza();
        }
    }

    private static boolean zzk(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    private final boolean zzl(zzadw zzadwVar) throws IOException {
        zzaig zzaigVar = this.zzp;
        if (zzaigVar != null) {
            long zzd = zzaigVar.zzd();
            if (zzd != -1 && zzadwVar.zze() > zzd - 4) {
                return true;
            }
        }
        try {
            return !zzadwVar.zzm(this.zza.zzN(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzm(zzadw zzadwVar, boolean z) throws IOException {
        int i;
        int i2;
        int zzb;
        zzadwVar.zzj();
        if (zzadwVar.zzf() == 0) {
            zzav zza = this.zzd.zza(zzadwVar, null);
            this.zzj = zza;
            if (zza != null) {
                this.zzc.zzb(zza);
            }
            i = (int) zzadwVar.zze();
            if (!z) {
                zzadwVar.zzk(i);
            }
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        int i3 = i2;
        int i4 = i3;
        while (true) {
            if (!zzl(zzadwVar)) {
                zzen zzenVar = this.zza;
                zzenVar.zzL(0);
                int zzg = zzenVar.zzg();
                if ((i2 == 0 || zzk(zzg, i2)) && (zzb = zzaeo.zzb(zzg)) != -1) {
                    i3++;
                    if (i3 != 1) {
                        if (i3 == 4) {
                            break;
                        }
                    } else {
                        this.zzb.zza(zzg);
                        i2 = zzg;
                    }
                    zzadwVar.zzg(zzb - 4);
                } else {
                    int i5 = i4 + 1;
                    if (i4 == (true != z ? 131072 : 32768)) {
                        if (z) {
                            return false;
                        }
                        zzj();
                        throw new EOFException();
                    }
                    if (z) {
                        zzadwVar.zzj();
                        zzadwVar.zzg(i + i5);
                    } else {
                        zzadwVar.zzk(1);
                    }
                    i2 = 0;
                    i4 = i5;
                    i3 = 0;
                }
            } else if (i3 <= 0) {
                zzj();
                throw new EOFException();
            }
        }
        if (z) {
            zzadwVar.zzk(i + i4);
        } else {
            zzadwVar.zzj();
        }
        this.zzi = i2;
        return true;
    }

    public final void zza() {
        this.zzq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        zzdd.zzb(this.zzg);
        String str = zzex.zza;
        int zzg = zzg(zzadwVar);
        if (zzg == -1 && (this.zzp instanceof zzaic)) {
            if (this.zzp.zza() != zzh(this.zzl)) {
                throw null;
            }
        }
        return zzg;
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
        this.zzf = zzadyVar;
        zzafb zzw = zzadyVar.zzw(0, 1);
        this.zzg = zzw;
        this.zzh = zzw;
        this.zzf.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzi = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = 0L;
        this.zzo = 0;
        zzaig zzaigVar = this.zzp;
        if (zzaigVar instanceof zzaic) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        return zzm(zzadwVar, true);
    }
}
