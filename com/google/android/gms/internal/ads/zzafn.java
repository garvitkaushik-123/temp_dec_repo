package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzafn implements zzadv {
    private final zzen zza;
    private final zzafl zzb;
    private final boolean zzc;
    private final zzakr zzd;
    private int zze;
    private zzady zzf;
    private zzafo zzg;
    private long zzh;
    private zzafq[] zzi;
    private long zzj;
    private zzafq zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    @Deprecated
    public zzafn() {
        this(1, zzakr.zza);
    }

    private final zzafq zzg(int i) {
        for (zzafq zzafqVar : this.zzi) {
            if (zzafqVar.zzf(i)) {
                return zzafqVar;
            }
        }
        return null;
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
        this.zze = 0;
        if (this.zzc) {
            zzadyVar = new zzaku(zzadyVar, this.zzd);
        }
        this.zzf = zzadyVar;
        this.zzj = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzj = -1L;
        this.zzk = null;
        for (zzafq zzafqVar : this.zzi) {
            zzafqVar.zze(j);
        }
        if (j == 0) {
            this.zze = this.zzi.length != 0 ? 3 : 0;
        } else {
            this.zze = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        zzen zzenVar = this.zza;
        zzadwVar.zzh(zzenVar.zzN(), 0, 12);
        zzenVar.zzL(0);
        if (zzenVar.zzi() != 1179011410) {
            return false;
        }
        zzenVar.zzM(4);
        return zzenVar.zzi() == 541677121;
    }

    public zzafn(int i, zzakr zzakrVar) {
        this.zzd = zzakrVar;
        this.zzc = 1 == (i ^ 1);
        this.zza = new zzen(12);
        this.zzb = new zzafl(null);
        this.zzf = new zzaep();
        this.zzi = new zzafq[0];
        this.zzm = -1L;
        this.zzn = -1L;
        this.zzl = -1;
        this.zzh = -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3, types: [int] */
    /* JADX WARN: Type inference failed for: r20v4 */
    @Override // com.google.android.gms.internal.ads.zzadv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        boolean z;
        ?? r20;
        long j;
        long j2 = this.zzj;
        if (j2 != -1) {
            long zzf = zzadwVar.zzf();
            if (j2 < zzf || j2 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE + zzf) {
                zzaerVar.zza = j2;
                z = true;
                this.zzj = -1L;
                if (!z) {
                    return 1;
                }
                int i = this.zze;
                zzafq zzafqVar = null;
                if (i == 0) {
                    if (!zzi(zzadwVar)) {
                        throw zzaz.zza("AVI Header List not found", null);
                    }
                    zzadwVar.zzk(12);
                    this.zze = 1;
                    return 0;
                }
                if (i == 1) {
                    zzen zzenVar = this.zza;
                    zzadwVar.zzi(zzenVar.zzN(), 0, 12);
                    zzenVar.zzL(0);
                    zzafl zzaflVar = this.zzb;
                    zzaflVar.zza(zzenVar);
                    int i2 = zzaflVar.zza;
                    if (i2 != 1414744396) {
                        throw zzaz.zza("LIST expected, found: " + i2, null);
                    }
                    int zzi = zzenVar.zzi();
                    if (zzi == 1819436136) {
                        this.zzl = zzaflVar.zzb;
                        this.zze = 2;
                        return 0;
                    }
                    throw zzaz.zza("hdrl expected, found: " + zzi, null);
                }
                if (i == 2) {
                    int i3 = this.zzl - 4;
                    zzen zzenVar2 = new zzen(i3);
                    zzadwVar.zzi(zzenVar2.zzN(), 0, i3);
                    zzafr zzc = zzafr.zzc(1819436136, zzenVar2);
                    if (zzc.zza() != 1819436136) {
                        throw zzaz.zza("Unexpected header list type " + zzc.zza(), null);
                    }
                    zzafo zzafoVar = (zzafo) zzc.zzb(zzafo.class);
                    if (zzafoVar == null) {
                        throw zzaz.zza("AviHeader not found", null);
                    }
                    this.zzg = zzafoVar;
                    this.zzh = zzafoVar.zzc * zzafoVar.zza;
                    ArrayList arrayList = new ArrayList();
                    zzfyq zzfyqVar = zzc.zza;
                    int size = zzfyqVar.size();
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < size) {
                        zzafj zzafjVar = (zzafj) zzfyqVar.get(i4);
                        if (zzafjVar.zza() == 1819440243) {
                            zzafr zzafrVar = (zzafr) zzafjVar;
                            int i6 = i5 + 1;
                            zzafp zzafpVar = (zzafp) zzafrVar.zzb(zzafp.class);
                            zzafs zzafsVar = (zzafs) zzafrVar.zzb(zzafs.class);
                            if (zzafpVar == null) {
                                zzea.zzf("AviExtractor", "Missing Stream Header");
                            } else if (zzafsVar == null) {
                                zzea.zzf("AviExtractor", "Missing Stream Format");
                            } else {
                                long zzc2 = zzafpVar.zzc();
                                zzz zzzVar = zzafsVar.zza;
                                zzx zzb = zzzVar.zzb();
                                zzb.zzR(i5);
                                int i7 = zzafpVar.zze;
                                if (i7 != 0) {
                                    zzb.zzX(i7);
                                }
                                zzaft zzaftVar = (zzaft) zzafrVar.zzb(zzaft.class);
                                if (zzaftVar != null) {
                                    zzb.zzU(zzaftVar.zza);
                                }
                                int zzb2 = zzay.zzb(zzzVar.zzo);
                                if (zzb2 != 1) {
                                    if (zzb2 == 2) {
                                        zzb2 = 2;
                                    } else {
                                        zzafqVar = null;
                                    }
                                }
                                zzafb zzw = this.zzf.zzw(i5, zzb2);
                                zzw.zzm(zzb.zzan());
                                zzw.zzl(zzc2);
                                this.zzh = Math.max(this.zzh, zzc2);
                                zzafqVar = new zzafq(i5, zzafpVar, zzw);
                            }
                            if (zzafqVar != null) {
                                arrayList.add(zzafqVar);
                            }
                            i5 = i6;
                        }
                        i4++;
                        zzafqVar = null;
                    }
                    this.zzi = (zzafq[]) arrayList.toArray(new zzafq[0]);
                    this.zzf.zzG();
                    this.zze = 3;
                    return 0;
                }
                if (i == 3) {
                    long j3 = this.zzm;
                    if (j3 != -1 && zzadwVar.zzf() != j3) {
                        this.zzj = j3;
                        return 0;
                    }
                    zzen zzenVar3 = this.zza;
                    zzadwVar.zzh(zzenVar3.zzN(), 0, 12);
                    zzadwVar.zzj();
                    zzenVar3.zzL(0);
                    zzafl zzaflVar2 = this.zzb;
                    zzaflVar2.zza(zzenVar3);
                    int zzi2 = zzenVar3.zzi();
                    int i8 = zzaflVar2.zza;
                    if (i8 == 1179011410) {
                        zzadwVar.zzk(12);
                        return 0;
                    }
                    if (i8 != 1414744396 || zzi2 != 1769369453) {
                        this.zzj = zzadwVar.zzf() + zzaflVar2.zzb + 8;
                        return 0;
                    }
                    long zzf2 = zzadwVar.zzf();
                    this.zzm = zzf2;
                    long j4 = zzf2 + zzaflVar2.zzb + 8;
                    this.zzn = j4;
                    if (!this.zzp) {
                        zzafo zzafoVar2 = this.zzg;
                        zzafoVar2.getClass();
                        if ((zzafoVar2.zzb & 16) == 16) {
                            this.zze = 4;
                            this.zzj = j4;
                            return 0;
                        }
                        this.zzf.zzP(new zzaet(this.zzh, 0L));
                        this.zzp = true;
                    }
                    this.zzj = zzadwVar.zzf() + 12;
                    this.zze = 6;
                    return 0;
                }
                if (i == 4) {
                    zzen zzenVar4 = this.zza;
                    zzadwVar.zzi(zzenVar4.zzN(), 0, 8);
                    zzenVar4.zzL(0);
                    int zzi3 = zzenVar4.zzi();
                    int zzi4 = zzenVar4.zzi();
                    if (zzi3 != 829973609) {
                        this.zzj = zzadwVar.zzf() + zzi4;
                        return 0;
                    }
                    this.zze = 5;
                    this.zzo = zzi4;
                    return 0;
                }
                if (i != 5) {
                    if (zzadwVar.zzf() >= this.zzn) {
                        return -1;
                    }
                    zzafq zzafqVar2 = this.zzk;
                    if (zzafqVar2 != null) {
                        if (!zzafqVar2.zzg(zzadwVar)) {
                            return 0;
                        }
                        this.zzk = null;
                        return 0;
                    }
                    if ((zzadwVar.zzf() & 1) == 1) {
                        zzadwVar.zzk(1);
                    }
                    zzen zzenVar5 = this.zza;
                    zzadwVar.zzh(zzenVar5.zzN(), 0, 12);
                    zzenVar5.zzL(0);
                    int zzi5 = zzenVar5.zzi();
                    if (zzi5 == 1414744396) {
                        zzenVar5.zzL(8);
                        zzadwVar.zzk(zzenVar5.zzi() != 1769369453 ? 8 : 12);
                        zzadwVar.zzj();
                        return 0;
                    }
                    int zzi6 = zzenVar5.zzi();
                    if (zzi5 == 1263424842) {
                        this.zzj = zzadwVar.zzf() + zzi6 + 8;
                        return 0;
                    }
                    zzadwVar.zzk(8);
                    zzadwVar.zzj();
                    zzafq zzg = zzg(zzi5);
                    if (zzg == null) {
                        this.zzj = zzadwVar.zzf() + zzi6;
                        return 0;
                    }
                    zzg.zzd(zzi6);
                    this.zzk = zzg;
                    return 0;
                }
                zzen zzenVar6 = new zzen(this.zzo);
                zzadwVar.zzi(zzenVar6.zzN(), 0, this.zzo);
                if (zzenVar6.zza() < 16) {
                    r20 = 0;
                    j = 0;
                } else {
                    int zzc3 = zzenVar6.zzc();
                    zzenVar6.zzM(8);
                    long zzi7 = zzenVar6.zzi();
                    r20 = 0;
                    long j5 = this.zzm;
                    j = zzi7 > j5 ? 0L : j5 + 8;
                    zzenVar6.zzL(zzc3);
                }
                while (zzenVar6.zza() >= 16) {
                    int zzi8 = zzenVar6.zzi();
                    int zzi9 = zzenVar6.zzi();
                    long zzi10 = zzenVar6.zzi() + j;
                    zzenVar6.zzM(4);
                    zzafq zzg2 = zzg(zzi8);
                    if (zzg2 != null) {
                        zzg2.zzb(zzi10, (zzi9 & 16) == 16 ? true : r20);
                    }
                }
                zzafq[] zzafqVarArr = this.zzi;
                int length = zzafqVarArr.length;
                for (int i9 = r20; i9 < length; i9++) {
                    zzafqVarArr[i9].zzc();
                }
                this.zzp = true;
                if (this.zzi.length == 0) {
                    this.zzf.zzP(new zzaet(this.zzh, 0L));
                } else {
                    this.zzf.zzP(new zzafk(this, this.zzh));
                }
                this.zze = 6;
                this.zzj = this.zzm;
                return r20;
            }
            zzadwVar.zzk((int) (j2 - zzf));
        }
        z = false;
        this.zzj = -1L;
        if (!z) {
        }
    }
}
