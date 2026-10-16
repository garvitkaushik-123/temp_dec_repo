package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaoj implements zzadv {
    private final int zza;
    private final List zzb;
    private final zzen zzc;
    private final SparseIntArray zzd;
    private final zzaom zze;
    private final zzakr zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;
    private final SparseBooleanArray zzi;
    private final zzaog zzj;
    private zzaof zzk;
    private zzady zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    @Deprecated
    public zzaoj() {
        this(1, 1, zzakr.zza, new zzeu(0L), new zzamw(0), 112800);
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x019a, code lost:
    
        if (r3 == false) goto L96;
     */
    @Override // com.google.android.gms.internal.ads.zzadv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        long j;
        long j2;
        long zzd = zzadwVar.zzd();
        if (this.zzn) {
            if (zzd != -1) {
                zzaog zzaogVar = this.zzj;
                if (!zzaogVar.zzd()) {
                    return zzaogVar.zza(zzadwVar, zzaerVar, this.zzr);
                }
            }
            if (this.zzo) {
                j = -1;
                j2 = 0;
            } else {
                this.zzo = true;
                zzaog zzaogVar2 = this.zzj;
                if (zzaogVar2.zzb() != -9223372036854775807L) {
                    j = -1;
                    j2 = 0;
                    zzaof zzaofVar = new zzaof(zzaogVar2.zzc(), zzaogVar2.zzb(), zzd, this.zzr, 112800);
                    this.zzk = zzaofVar;
                    this.zzl.zzP(zzaofVar.zzb());
                } else {
                    j = -1;
                    j2 = 0;
                    this.zzl.zzP(new zzaet(zzaogVar2.zzb(), 0L));
                }
            }
            if (this.zzp) {
                this.zzp = false;
                zzf(j2, j2);
                if (zzadwVar.zzf() != j2) {
                    zzaerVar.zza = j2;
                    return 1;
                }
            }
            zzaof zzaofVar2 = this.zzk;
            if (zzaofVar2 != null && zzaofVar2.zze()) {
                return zzaofVar2.zza(zzadwVar, zzaerVar);
            }
        } else {
            j = -1;
        }
        zzen zzenVar = this.zzc;
        byte[] zzN = zzenVar.zzN();
        if (9400 - zzenVar.zzc() < 188) {
            int zza = zzenVar.zza();
            if (zza > 0) {
                System.arraycopy(zzN, zzenVar.zzc(), zzN, 0, zza);
            }
            zzenVar.zzJ(zzN, zza);
        }
        while (zzenVar.zza() < 188) {
            int zzd2 = zzenVar.zzd();
            int zza2 = zzadwVar.zza(zzN, zzd2, 9400 - zzd2);
            if (zza2 == -1) {
                int i = 0;
                while (true) {
                    SparseArray sparseArray = this.zzg;
                    if (i >= sparseArray.size()) {
                        return -1;
                    }
                    zzaoo zzaooVar = (zzaoo) sparseArray.valueAt(i);
                    if (zzaooVar instanceof zzant) {
                        zzant zzantVar = (zzant) zzaooVar;
                        if (zzantVar.zzd(false)) {
                            zzantVar.zza(new zzen(), 1);
                        }
                    }
                    i++;
                }
            } else {
                zzenVar.zzK(zzd2 + zza2);
            }
        }
        int zzc = zzenVar.zzc();
        int zzd3 = zzenVar.zzd();
        int zza3 = zzaop.zza(zzenVar.zzN(), zzc, zzd3);
        zzenVar.zzL(zza3);
        int i2 = zza3 + 188;
        if (i2 > zzd3) {
            this.zzq += zza3 - zzc;
        } else {
            this.zzq = 0;
        }
        int zzd4 = zzenVar.zzd();
        if (i2 > zzd4) {
            return 0;
        }
        int zzg = zzenVar.zzg();
        if ((8388608 & zzg) != 0) {
            zzenVar.zzL(i2);
            return 0;
        }
        int i3 = (4194304 & zzg) != 0 ? 1 : 0;
        int i4 = zzg & 32;
        int i5 = (zzg >> 8) & 8191;
        zzaoo zzaooVar2 = (zzg & 16) != 0 ? (zzaoo) this.zzg.get(i5) : null;
        if (zzaooVar2 == null) {
            zzenVar.zzL(i2);
            return 0;
        }
        int i6 = zzg & 15;
        SparseIntArray sparseIntArray = this.zzd;
        int i7 = sparseIntArray.get(i5, i6 - 1);
        sparseIntArray.put(i5, i6);
        if (i7 == i6) {
            zzenVar.zzL(i2);
            return 0;
        }
        if (i6 != ((i7 + 1) & 15)) {
            zzaooVar2.zzc();
        }
        if (i4 != 0) {
            int zzm = zzenVar.zzm();
            i3 |= (zzenVar.zzm() & 64) != 0 ? 2 : 0;
            zzenVar.zzM(zzm - 1);
        }
        boolean z = this.zzn;
        if (z || !this.zzi.get(i5, false)) {
            zzenVar.zzK(i2);
            zzaooVar2.zza(zzenVar, i3);
            zzenVar.zzK(zzd4);
        }
        if (this.zzn && zzd != j) {
            this.zzp = true;
        }
        zzenVar.zzL(i2);
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
        if (this.zza == 0) {
            zzadyVar = new zzaku(zzadyVar, this.zzf);
        }
        this.zzl = zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        zzaof zzaofVar;
        List list = this.zzb;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            zzeu zzeuVar = (zzeu) list.get(i);
            if (zzeuVar.zzf() != -9223372036854775807L) {
                long zzd = zzeuVar.zzd();
                if (zzd != -9223372036854775807L) {
                    if (zzd != 0) {
                        if (zzd == j2) {
                        }
                    }
                }
            }
            zzeuVar.zzi(j2);
        }
        if (j2 != 0 && (zzaofVar = this.zzk) != null) {
            zzaofVar.zzd(j2);
        }
        this.zzc.zzI(0);
        this.zzd.clear();
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.zzg;
            if (i2 >= sparseArray.size()) {
                this.zzq = 0;
                return;
            } else {
                ((zzaoo) sparseArray.valueAt(i2)).zzc();
                i2++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.google.android.gms.internal.ads.zzadv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        byte[] zzN = this.zzc.zzN();
        zzadl zzadlVar = (zzadl) zzadwVar;
        zzadlVar.zzm(zzN, 0, 940, false);
        int i = 0;
        while (i < 188) {
            for (int i2 = 0; i2 < 5; i2++) {
                if (zzN[(i2 * 188) + i] != 71) {
                    break;
                }
            }
            zzadlVar.zzo(i, false);
            return true;
        }
        return false;
    }

    public zzaoj(int i, int i2, zzakr zzakrVar, zzeu zzeuVar, zzaom zzaomVar, int i3) {
        this.zze = zzaomVar;
        this.zza = i2;
        this.zzf = zzakrVar;
        this.zzb = Collections.singletonList(zzeuVar);
        this.zzc = new zzen(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzaog(112800);
        this.zzl = zzady.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray zza = zzaomVar.zza();
        int size = zza.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzg.put(zza.keyAt(i4), (zzaoo) zza.valueAt(i4));
        }
        this.zzg.put(0, new zzaob(new zzaoh(this)));
    }
}
