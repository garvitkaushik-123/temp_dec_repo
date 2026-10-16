package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzagc implements zzadv {
    private zzady zzf;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private zzagb zzo;
    private zzagg zzp;
    private final zzen zza = new zzen(4);
    private final zzen zzb = new zzen(9);
    private final zzen zzc = new zzen(11);
    private final zzen zzd = new zzen();
    private final zzagd zze = new zzagd();
    private int zzg = 1;

    private final zzen zza(zzadw zzadwVar) throws IOException {
        zzen zzenVar = this.zzd;
        if (this.zzl > zzenVar.zzb()) {
            int zzb = zzenVar.zzb();
            zzenVar.zzJ(new byte[Math.max(zzb + zzb, this.zzl)], 0);
        } else {
            zzenVar.zzL(0);
        }
        zzenVar.zzK(this.zzl);
        zzadwVar.zzi(zzenVar.zzN(), 0, this.zzl);
        return zzenVar;
    }

    @RequiresNonNull({"extractorOutput"})
    private final void zzg() {
        if (this.zzn) {
            return;
        }
        this.zzf.zzP(new zzaet(-9223372036854775807L, 0L));
        this.zzn = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0009 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzadv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        boolean zzf;
        boolean z;
        zzdd.zzb(this.zzf);
        while (true) {
            int i = this.zzg;
            int i2 = 8;
            if (i == 1) {
                zzen zzenVar = this.zzb;
                if (!zzadwVar.zzn(zzenVar.zzN(), 0, 9, true)) {
                    return -1;
                }
                zzenVar.zzL(0);
                zzenVar.zzM(4);
                int zzm = zzenVar.zzm();
                int i3 = zzm & 4;
                int i4 = zzm & 1;
                if (i3 != 0 && this.zzo == null) {
                    this.zzo = new zzagb(this.zzf.zzw(8, 1));
                }
                if (i4 != 0 && this.zzp == null) {
                    this.zzp = new zzagg(this.zzf.zzw(9, 2));
                }
                this.zzf.zzG();
                this.zzj = zzenVar.zzg() - 5;
                this.zzg = 2;
            } else if (i == 2) {
                zzadwVar.zzk(this.zzj);
                this.zzj = 0;
                this.zzg = 3;
            } else if (i == 3) {
                zzen zzenVar2 = this.zzc;
                if (!zzadwVar.zzn(zzenVar2.zzN(), 0, 11, true)) {
                    return -1;
                }
                zzenVar2.zzL(0);
                this.zzk = zzenVar2.zzm();
                this.zzl = zzenVar2.zzo();
                this.zzm = zzenVar2.zzo();
                this.zzm = ((zzenVar2.zzm() << 24) | this.zzm) * 1000;
                zzenVar2.zzM(3);
                this.zzg = 4;
            } else {
                if (i != 4) {
                    throw new IllegalStateException();
                }
                long j = this.zzh ? this.zzi + this.zzm : this.zze.zzc() == -9223372036854775807L ? 0L : this.zzm;
                int i5 = this.zzk;
                if (i5 != 8) {
                    i2 = i5;
                } else if (this.zzo != null) {
                    zzg();
                    zzf = this.zzo.zzf(zza(zzadwVar), j);
                    z = true;
                    if (!this.zzh && zzf) {
                        this.zzh = true;
                        this.zzi = this.zze.zzc() != -9223372036854775807L ? -this.zzm : 0L;
                    }
                    this.zzj = 4;
                    this.zzg = 2;
                    if (!z) {
                        return 0;
                    }
                }
                if (i2 == 9) {
                    if (this.zzp != null) {
                        zzg();
                        zzf = this.zzp.zzf(zza(zzadwVar), j);
                        z = true;
                    }
                    zzadwVar.zzk(this.zzl);
                    zzf = false;
                    z = false;
                } else {
                    if (i2 == 18 && !this.zzn) {
                        zzagd zzagdVar = this.zze;
                        zzf = zzagdVar.zzf(zza(zzadwVar), j);
                        long zzc = zzagdVar.zzc();
                        if (zzc != -9223372036854775807L) {
                            this.zzf.zzP(new zzaem(zzagdVar.zzd(), zzagdVar.zze(), zzc));
                            this.zzn = true;
                        }
                        z = true;
                    }
                    zzadwVar.zzk(this.zzl);
                    zzf = false;
                    z = false;
                }
                if (!this.zzh) {
                    this.zzh = true;
                    this.zzi = this.zze.zzc() != -9223372036854775807L ? -this.zzm : 0L;
                }
                this.zzj = 4;
                this.zzg = 2;
                if (!z) {
                }
            }
        }
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
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzg = 1;
            this.zzh = false;
        } else {
            this.zzg = 3;
        }
        this.zzj = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        zzen zzenVar = this.zza;
        zzadl zzadlVar = (zzadl) zzadwVar;
        zzadlVar.zzm(zzenVar.zzN(), 0, 3, false);
        zzenVar.zzL(0);
        if (zzenVar.zzo() != 4607062) {
            return false;
        }
        zzadlVar.zzm(zzenVar.zzN(), 0, 2, false);
        zzenVar.zzL(0);
        if ((zzenVar.zzq() & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) != 0) {
            return false;
        }
        zzadlVar.zzm(zzenVar.zzN(), 0, 4, false);
        zzenVar.zzL(0);
        int zzg = zzenVar.zzg();
        zzadwVar.zzj();
        zzadlVar.zzl(zzg, false);
        zzadlVar.zzm(zzenVar.zzN(), 0, 4, false);
        zzenVar.zzL(0);
        return zzenVar.zzg() == 0;
    }
}
