package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzagj implements zzadv {
    private zzady zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private zzahm zzg;
    private zzadw zzh;
    private zzagm zzi;
    private zzajj zzj;
    private final zzen zza = new zzen(6);
    private long zzf = -1;

    private final int zza(zzadw zzadwVar) throws IOException {
        zzen zzenVar = this.zza;
        zzenVar.zzI(2);
        ((zzadl) zzadwVar).zzm(zzenVar.zzN(), 0, 2, false);
        return zzenVar.zzq();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0193  */
    @Override // com.google.android.gms.internal.ads.zzadv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        int i;
        String zzy;
        zzagl zza;
        zzahm zzahmVar;
        long j;
        int i2 = this.zzc;
        long j2 = -1;
        if (i2 == 0) {
            zzen zzenVar = this.zza;
            zzenVar.zzI(2);
            zzadwVar.zzi(zzenVar.zzN(), 0, 2);
            int zzq = zzenVar.zzq();
            this.zzd = zzq;
            if (zzq == 65498) {
                if (this.zzf != -1) {
                    this.zzc = 4;
                    return 0;
                }
                zzg();
                return 0;
            }
            if ((zzq >= 65488 && zzq <= 65497) || zzq == 65281) {
                return 0;
            }
            this.zzc = 1;
            return 0;
        }
        if (i2 == 1) {
            zzen zzenVar2 = this.zza;
            zzenVar2.zzI(2);
            zzadwVar.zzi(zzenVar2.zzN(), 0, 2);
            this.zze = zzenVar2.zzq() - 2;
            this.zzc = 2;
            return 0;
        }
        if (i2 != 2) {
            if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 == 6) {
                        return -1;
                    }
                    throw new IllegalStateException();
                }
                if (this.zzi == null || zzadwVar != this.zzh) {
                    this.zzh = zzadwVar;
                    this.zzi = new zzagm(zzadwVar, this.zzf);
                }
                zzajj zzajjVar = this.zzj;
                zzajjVar.getClass();
                int zzb = zzajjVar.zzb(this.zzi, zzaerVar);
                if (zzb == 1) {
                    zzaerVar.zza += this.zzf;
                }
                return zzb;
            }
            long zzf = zzadwVar.zzf();
            long j3 = this.zzf;
            if (zzf != j3) {
                zzaerVar.zza = j3;
                return 1;
            }
            if (zzadwVar.zzm(this.zza.zzN(), 0, 1, true)) {
                zzadwVar.zzj();
                if (this.zzj == null) {
                    this.zzj = new zzajj(zzakr.zza, 8);
                }
                zzagm zzagmVar = new zzagm(zzadwVar, this.zzf);
                this.zzi = zzagmVar;
                if (this.zzj.zzi(zzagmVar)) {
                    zzajj zzajjVar2 = this.zzj;
                    long j4 = this.zzf;
                    zzady zzadyVar = this.zzb;
                    zzadyVar.getClass();
                    zzajjVar2.zze(new zzago(j4, zzadyVar));
                    zzahm zzahmVar2 = this.zzg;
                    zzahmVar2.getClass();
                    zzady zzadyVar2 = this.zzb;
                    zzadyVar2.getClass();
                    zzafb zzw = zzadyVar2.zzw(1024, 4);
                    zzx zzxVar = new zzx();
                    zzxVar.zzG("image/jpeg");
                    zzxVar.zzaa(new zzav(-9223372036854775807L, zzahmVar2));
                    zzw.zzm(zzxVar.zzan());
                    this.zzc = 5;
                } else {
                    zzg();
                }
            } else {
                zzg();
            }
            return 0;
        }
        if (this.zzd == 65505) {
            zzen zzenVar3 = new zzen(this.zze);
            zzadwVar.zzi(zzenVar3.zzN(), 0, this.zze);
            if (this.zzg != null || !"http://ns.adobe.com/xap/1.0/".equals(zzenVar3.zzy((char) 0)) || (zzy = zzenVar3.zzy((char) 0)) == null) {
                i = 0;
                this.zzc = i;
                return i;
            }
            long zzd = zzadwVar.zzd();
            if (zzd != -1 && (zza = zzagp.zza(zzy)) != null) {
                List list = zza.zzb;
                if (list.size() >= 2) {
                    int size = list.size() - 1;
                    long j5 = -1;
                    long j6 = -1;
                    long j7 = -1;
                    long j8 = -1;
                    boolean z = false;
                    while (size >= 0) {
                        zzagk zzagkVar = (zzagk) list.get(size);
                        long j9 = j2;
                        boolean equals = "video/mp4".equals(zzagkVar.zza) | z;
                        if (size == 0) {
                            zzd -= zzagkVar.zzc;
                            j = 0;
                        } else {
                            j = zzd - zzagkVar.zzb;
                        }
                        long j10 = j;
                        long j11 = zzd;
                        zzd = j10;
                        if (!equals || zzd == j11) {
                            z = equals;
                        } else {
                            j8 = j11 - zzd;
                            j7 = zzd;
                            z = false;
                        }
                        if (size == 0) {
                            j6 = j11;
                        }
                        if (size == 0) {
                            j5 = zzd;
                        }
                        size--;
                        j2 = j9;
                    }
                    long j12 = j2;
                    if (j7 != j12 && j8 != j12 && j5 != j12 && j6 != j12) {
                        zzahmVar = new zzahm(j5, j6, zza.zza, j7, j8);
                        this.zzg = zzahmVar;
                        if (zzahmVar != null) {
                            this.zzf = zzahmVar.zzd;
                        }
                    }
                }
            }
            zzahmVar = null;
            this.zzg = zzahmVar;
            if (zzahmVar != null) {
            }
        } else {
            zzadwVar.zzk(this.zze);
        }
        i = 0;
        this.zzc = i;
        return i;
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
        this.zzb = zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        if (zza(zzadwVar) != 65496) {
            return false;
        }
        int zza = zza(zzadwVar);
        this.zzd = zza;
        if (zza == 65504) {
            zzen zzenVar = this.zza;
            zzenVar.zzI(2);
            zzadl zzadlVar = (zzadl) zzadwVar;
            zzadlVar.zzm(zzenVar.zzN(), 0, 2, false);
            zzadlVar.zzl(zzenVar.zzq() - 2, false);
            zza = zza(zzadwVar);
            this.zzd = zza;
        }
        if (zza == 65505) {
            zzadl zzadlVar2 = (zzadl) zzadwVar;
            zzadlVar2.zzl(2, false);
            zzen zzenVar2 = this.zza;
            zzenVar2.zzI(6);
            zzadlVar2.zzm(zzenVar2.zzN(), 0, 6, false);
            if (zzenVar2.zzu() == 1165519206 && zzenVar2.zzq() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzajj zzajjVar = this.zzj;
            zzajjVar.getClass();
            zzajjVar.zzf(j, j2);
        }
    }

    private final void zzg() {
        zzady zzadyVar = this.zzb;
        zzadyVar.getClass();
        zzadyVar.zzG();
        this.zzb.zzP(new zzaet(-9223372036854775807L, 0L));
        this.zzc = 6;
    }
}
