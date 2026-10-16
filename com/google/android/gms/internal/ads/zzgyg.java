package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgyg implements zzhbf {
    private final zzgyf zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgyg(zzgyf zzgyfVar) {
        zzgzu.zzc(zzgyfVar, "input");
        this.zza = zzgyfVar;
        zzgyfVar.zzd = this;
    }

    private final void zzO(Object obj, zzhbl zzhblVar, zzgyr zzgyrVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzhblVar.zzh(obj, this, zzgyrVar);
            if (this.zzb == this.zzc) {
            } else {
                throw new zzgzw("Failed to parse the message.");
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzP(Object obj, zzhbl zzhblVar, zzgyr zzgyrVar) throws IOException {
        zzgyf zzgyfVar = this.zza;
        int zzm = zzgyfVar.zzm();
        if (zzgyfVar.zzb >= zzgyfVar.zzc) {
            throw new zzgzw("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int zzd = zzgyfVar.zzd(zzm);
        zzgyfVar.zzb++;
        zzhblVar.zzh(obj, this, zzgyrVar);
        zzgyfVar.zzy(0);
        zzgyfVar.zzb--;
        zzgyfVar.zzz(zzd);
    }

    private final void zzQ(int i) throws IOException {
        if (this.zza.zzc() != i) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private final void zzR(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw new zzgzv("Protocol message tag had invalid wire type.");
        }
    }

    private static final void zzS(int i) throws IOException {
        if ((i & 3) != 0) {
            throw new zzgzw("Failed to parse the message.");
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 7) != 0) {
            throw new zzgzw("Failed to parse the message.");
        }
    }

    public static zzgyg zzq(zzgyf zzgyfVar) {
        zzgyg zzgygVar = zzgyfVar.zzd;
        return zzgygVar != null ? zzgygVar : new zzgyg(zzgyfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzA(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzhah) {
            zzhah zzhahVar = (zzhah) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzm = zzgyfVar.zzm();
                zzT(zzm);
                int zzc = zzgyfVar.zzc() + zzm;
                do {
                    zzhahVar.zzg(zzgyfVar.zzn());
                } while (zzgyfVar.zzc() < zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzhahVar.zzg(zzgyfVar2.zzn());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzm2 = zzgyfVar3.zzm();
                zzT(zzm2);
                int zzc2 = zzgyfVar3.zzc() + zzm2;
                do {
                    list.add(Long.valueOf(zzgyfVar3.zzn()));
                } while (zzgyfVar3.zzc() < zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Long.valueOf(zzgyfVar4.zzn()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzB(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzgyy) {
            zzgyy zzgyyVar = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzgyf zzgyfVar = this.zza;
                int zzm = zzgyfVar.zzm();
                zzS(zzm);
                int zzc = zzgyfVar.zzc() + zzm;
                do {
                    zzgyyVar.zzh(zzgyfVar.zzb());
                } while (zzgyfVar.zzc() < zzc);
                return;
            }
            if (i2 != 5) {
                throw new zzgzv("Protocol message tag had invalid wire type.");
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzgyyVar.zzh(zzgyfVar2.zzb());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                zzgyf zzgyfVar3 = this.zza;
                int zzm2 = zzgyfVar3.zzm();
                zzS(zzm2);
                int zzc2 = zzgyfVar3.zzc() + zzm2;
                do {
                    list.add(Float.valueOf(zzgyfVar3.zzb()));
                } while (zzgyfVar3.zzc() < zzc2);
                return;
            }
            if (i3 != 5) {
                throw new zzgzv("Protocol message tag had invalid wire type.");
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Float.valueOf(zzgyfVar4.zzb()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    @Deprecated
    public final void zzC(List list, zzhbl zzhblVar, zzgyr zzgyrVar) throws IOException {
        int zzl;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw new zzgzv("Protocol message tag had invalid wire type.");
        }
        do {
            Object zze = zzhblVar.zze();
            zzO(zze, zzhblVar, zzgyrVar);
            zzhblVar.zzf(zze);
            list.add(zze);
            zzgyf zzgyfVar = this.zza;
            if (zzgyfVar.zzA() || this.zzd != 0) {
                return;
            } else {
                zzl = zzgyfVar.zzl();
            }
        } while (zzl == i);
        this.zzd = zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzD(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzgzi) {
            zzgzi zzgziVar = (zzgzi) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzc = zzgyfVar.zzc() + zzgyfVar.zzm();
                do {
                    zzgziVar.zzi(zzgyfVar.zzg());
                } while (zzgyfVar.zzc() < zzc);
                zzQ(zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzgziVar.zzi(zzgyfVar2.zzg());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzc2 = zzgyfVar3.zzc() + zzgyfVar3.zzm();
                do {
                    list.add(Integer.valueOf(zzgyfVar3.zzg()));
                } while (zzgyfVar3.zzc() < zzc2);
                zzQ(zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Integer.valueOf(zzgyfVar4.zzg()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzE(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzhah) {
            zzhah zzhahVar = (zzhah) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzc = zzgyfVar.zzc() + zzgyfVar.zzm();
                do {
                    zzhahVar.zzg(zzgyfVar.zzo());
                } while (zzgyfVar.zzc() < zzc);
                zzQ(zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzhahVar.zzg(zzgyfVar2.zzo());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzc2 = zzgyfVar3.zzc() + zzgyfVar3.zzm();
                do {
                    list.add(Long.valueOf(zzgyfVar3.zzo()));
                } while (zzgyfVar3.zzc() < zzc2);
                zzQ(zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Long.valueOf(zzgyfVar4.zzo()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzF(List list, zzhbl zzhblVar, zzgyr zzgyrVar) throws IOException {
        int zzl;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw new zzgzv("Protocol message tag had invalid wire type.");
        }
        do {
            Object zze = zzhblVar.zze();
            zzP(zze, zzhblVar, zzgyrVar);
            zzhblVar.zzf(zze);
            list.add(zze);
            zzgyf zzgyfVar = this.zza;
            if (zzgyfVar.zzA() || this.zzd != 0) {
                return;
            } else {
                zzl = zzgyfVar.zzl();
            }
        } while (zzl == i);
        this.zzd = zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzG(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzgzi) {
            zzgzi zzgziVar = (zzgzi) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzgyf zzgyfVar = this.zza;
                int zzm = zzgyfVar.zzm();
                zzS(zzm);
                int zzc = zzgyfVar.zzc() + zzm;
                do {
                    zzgziVar.zzi(zzgyfVar.zzj());
                } while (zzgyfVar.zzc() < zzc);
                return;
            }
            if (i2 != 5) {
                throw new zzgzv("Protocol message tag had invalid wire type.");
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzgziVar.zzi(zzgyfVar2.zzj());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                zzgyf zzgyfVar3 = this.zza;
                int zzm2 = zzgyfVar3.zzm();
                zzS(zzm2);
                int zzc2 = zzgyfVar3.zzc() + zzm2;
                do {
                    list.add(Integer.valueOf(zzgyfVar3.zzj()));
                } while (zzgyfVar3.zzc() < zzc2);
                return;
            }
            if (i3 != 5) {
                throw new zzgzv("Protocol message tag had invalid wire type.");
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Integer.valueOf(zzgyfVar4.zzj()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzH(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzhah) {
            zzhah zzhahVar = (zzhah) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzm = zzgyfVar.zzm();
                zzT(zzm);
                int zzc = zzgyfVar.zzc() + zzm;
                do {
                    zzhahVar.zzg(zzgyfVar.zzs());
                } while (zzgyfVar.zzc() < zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzhahVar.zzg(zzgyfVar2.zzs());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzm2 = zzgyfVar3.zzm();
                zzT(zzm2);
                int zzc2 = zzgyfVar3.zzc() + zzm2;
                do {
                    list.add(Long.valueOf(zzgyfVar3.zzs()));
                } while (zzgyfVar3.zzc() < zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Long.valueOf(zzgyfVar4.zzs()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzI(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzgzi) {
            zzgzi zzgziVar = (zzgzi) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzc = zzgyfVar.zzc() + zzgyfVar.zzm();
                do {
                    zzgziVar.zzi(zzgyfVar.zzk());
                } while (zzgyfVar.zzc() < zzc);
                zzQ(zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzgziVar.zzi(zzgyfVar2.zzk());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzc2 = zzgyfVar3.zzc() + zzgyfVar3.zzm();
                do {
                    list.add(Integer.valueOf(zzgyfVar3.zzk()));
                } while (zzgyfVar3.zzc() < zzc2);
                zzQ(zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Integer.valueOf(zzgyfVar4.zzk()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzJ(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzhah) {
            zzhah zzhahVar = (zzhah) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzc = zzgyfVar.zzc() + zzgyfVar.zzm();
                do {
                    zzhahVar.zzg(zzgyfVar.zzt());
                } while (zzgyfVar.zzc() < zzc);
                zzQ(zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzhahVar.zzg(zzgyfVar2.zzt());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzc2 = zzgyfVar3.zzc() + zzgyfVar3.zzm();
                do {
                    list.add(Long.valueOf(zzgyfVar3.zzt()));
                } while (zzgyfVar3.zzc() < zzc2);
                zzQ(zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Long.valueOf(zzgyfVar4.zzt()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    public final void zzK(List list, boolean z) throws IOException {
        int zzl;
        int i;
        if ((this.zzb & 7) != 2) {
            throw new zzgzv("Protocol message tag had invalid wire type.");
        }
        if ((list instanceof zzhae) && !z) {
            zzhae zzhaeVar = (zzhae) list;
            do {
                zzp();
                zzhaeVar.zzb();
                zzgyf zzgyfVar = this.zza;
                if (zzgyfVar.zzA()) {
                    return;
                } else {
                    i = zzgyfVar.zzl();
                }
            } while (i == this.zzb);
        } else {
            do {
                list.add(z ? zzs() : zzr());
                zzgyf zzgyfVar2 = this.zza;
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar2.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzL(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzgzi) {
            zzgzi zzgziVar = (zzgzi) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzc = zzgyfVar.zzc() + zzgyfVar.zzm();
                do {
                    zzgziVar.zzi(zzgyfVar.zzm());
                } while (zzgyfVar.zzc() < zzc);
                zzQ(zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzgziVar.zzi(zzgyfVar2.zzm());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzc2 = zzgyfVar3.zzc() + zzgyfVar3.zzm();
                do {
                    list.add(Integer.valueOf(zzgyfVar3.zzm()));
                } while (zzgyfVar3.zzc() < zzc2);
                zzQ(zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Integer.valueOf(zzgyfVar4.zzm()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzM(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzhah) {
            zzhah zzhahVar = (zzhah) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzc = zzgyfVar.zzc() + zzgyfVar.zzm();
                do {
                    zzhahVar.zzg(zzgyfVar.zzu());
                } while (zzgyfVar.zzc() < zzc);
                zzQ(zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzhahVar.zzg(zzgyfVar2.zzu());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzc2 = zzgyfVar3.zzc() + zzgyfVar3.zzm();
                do {
                    list.add(Long.valueOf(zzgyfVar3.zzu()));
                } while (zzgyfVar3.zzc() < zzc2);
                zzQ(zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Long.valueOf(zzgyfVar4.zzu()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final boolean zzN() throws IOException {
        zzR(0);
        return this.zza.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final double zza() throws IOException {
        zzR(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final float zzb() throws IOException {
        zzR(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzl();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final int zze() throws IOException {
        zzR(0);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final int zzf() throws IOException {
        zzR(5);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final int zzg() throws IOException {
        zzR(0);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final int zzh() throws IOException {
        zzR(5);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final int zzi() throws IOException {
        zzR(0);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final int zzj() throws IOException {
        zzR(0);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final long zzk() throws IOException {
        zzR(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final long zzl() throws IOException {
        zzR(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final long zzm() throws IOException {
        zzR(1);
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final long zzn() throws IOException {
        zzR(0);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final long zzo() throws IOException {
        zzR(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final zzgxz zzp() throws IOException {
        zzR(2);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final String zzr() throws IOException {
        zzR(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final String zzs() throws IOException {
        zzR(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzt(Object obj, zzhbl zzhblVar, zzgyr zzgyrVar) throws IOException {
        zzR(3);
        zzO(obj, zzhblVar, zzgyrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzu(Object obj, zzhbl zzhblVar, zzgyr zzgyrVar) throws IOException {
        zzR(2);
        zzP(obj, zzhblVar, zzgyrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzv(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzgxp) {
            zzgxp zzgxpVar = (zzgxp) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzc = zzgyfVar.zzc() + zzgyfVar.zzm();
                do {
                    zzgxpVar.zzg(zzgyfVar.zzB());
                } while (zzgyfVar.zzc() < zzc);
                zzQ(zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzgxpVar.zzg(zzgyfVar2.zzB());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzc2 = zzgyfVar3.zzc() + zzgyfVar3.zzm();
                do {
                    list.add(Boolean.valueOf(zzgyfVar3.zzB()));
                } while (zzgyfVar3.zzc() < zzc2);
                zzQ(zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Boolean.valueOf(zzgyfVar4.zzB()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzw(List list) throws IOException {
        int zzl;
        if ((this.zzb & 7) != 2) {
            throw new zzgzv("Protocol message tag had invalid wire type.");
        }
        do {
            list.add(zzp());
            zzgyf zzgyfVar = this.zza;
            if (zzgyfVar.zzA()) {
                return;
            } else {
                zzl = zzgyfVar.zzl();
            }
        } while (zzl == this.zzb);
        this.zzd = zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzx(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzgyo) {
            zzgyo zzgyoVar = (zzgyo) list;
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzm = zzgyfVar.zzm();
                zzT(zzm);
                int zzc = zzgyfVar.zzc() + zzm;
                do {
                    zzgyoVar.zzh(zzgyfVar.zza());
                } while (zzgyfVar.zzc() < zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzgyoVar.zzh(zzgyfVar2.zza());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzm2 = zzgyfVar3.zzm();
                zzT(zzm2);
                int zzc2 = zzgyfVar3.zzc() + zzm2;
                do {
                    list.add(Double.valueOf(zzgyfVar3.zza()));
                } while (zzgyfVar3.zzc() < zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Double.valueOf(zzgyfVar4.zza()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzy(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzgzi) {
            zzgzi zzgziVar = (zzgzi) list;
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar = this.zza;
                int zzc = zzgyfVar.zzc() + zzgyfVar.zzm();
                do {
                    zzgziVar.zzi(zzgyfVar.zze());
                } while (zzgyfVar.zzc() < zzc);
                zzQ(zzc);
                return;
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzgziVar.zzi(zzgyfVar2.zze());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzgzv("Protocol message tag had invalid wire type.");
                }
                zzgyf zzgyfVar3 = this.zza;
                int zzc2 = zzgyfVar3.zzc() + zzgyfVar3.zzm();
                do {
                    list.add(Integer.valueOf(zzgyfVar3.zze()));
                } while (zzgyfVar3.zzc() < zzc2);
                zzQ(zzc2);
                return;
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Integer.valueOf(zzgyfVar4.zze()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhbf
    public final void zzz(List list) throws IOException {
        int zzl;
        int i;
        if (list instanceof zzgzi) {
            zzgzi zzgziVar = (zzgzi) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                zzgyf zzgyfVar = this.zza;
                int zzm = zzgyfVar.zzm();
                zzS(zzm);
                int zzc = zzgyfVar.zzc() + zzm;
                do {
                    zzgziVar.zzi(zzgyfVar.zzf());
                } while (zzgyfVar.zzc() < zzc);
                return;
            }
            if (i2 != 5) {
                throw new zzgzv("Protocol message tag had invalid wire type.");
            }
            do {
                zzgyf zzgyfVar2 = this.zza;
                zzgziVar.zzi(zzgyfVar2.zzf());
                if (zzgyfVar2.zzA()) {
                    return;
                } else {
                    i = zzgyfVar2.zzl();
                }
            } while (i == this.zzb);
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                zzgyf zzgyfVar3 = this.zza;
                int zzm2 = zzgyfVar3.zzm();
                zzS(zzm2);
                int zzc2 = zzgyfVar3.zzc() + zzm2;
                do {
                    list.add(Integer.valueOf(zzgyfVar3.zzf()));
                } while (zzgyfVar3.zzc() < zzc2);
                return;
            }
            if (i3 != 5) {
                throw new zzgzv("Protocol message tag had invalid wire type.");
            }
            do {
                zzgyf zzgyfVar4 = this.zza;
                list.add(Integer.valueOf(zzgyfVar4.zzf()));
                if (zzgyfVar4.zzA()) {
                    return;
                } else {
                    zzl = zzgyfVar4.zzl();
                }
            } while (zzl == this.zzb);
            i = zzl;
        }
        this.zzd = i;
    }
}
