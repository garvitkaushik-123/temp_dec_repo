package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzwg implements zzzv, zzuw {
    final /* synthetic */ zzwl zza;
    private final long zzb;
    private final Uri zzc;
    private final zzhi zzd;
    private final zzwa zze;
    private final zzady zzf;
    private final zzdm zzg;
    private final zzaer zzh;
    private volatile boolean zzi;
    private boolean zzj;
    private long zzk;
    private zzgo zzl;
    private zzafb zzm;
    private boolean zzn;

    public zzwg(zzwl zzwlVar, Uri uri, zzgj zzgjVar, zzwa zzwaVar, zzady zzadyVar, zzdm zzdmVar) {
        Objects.requireNonNull(zzwlVar);
        this.zza = zzwlVar;
        this.zzc = uri;
        this.zzd = new zzhi(zzgjVar);
        this.zze = zzwaVar;
        this.zzf = zzadyVar;
        this.zzg = zzdmVar;
        this.zzh = new zzaer();
        this.zzj = true;
        this.zzb = zzuy.zza();
        this.zzl = zzi(0L);
    }

    static /* bridge */ /* synthetic */ void zzf(zzwg zzwgVar, long j, long j2) {
        zzwgVar.zzh.zza = j;
        zzwgVar.zzk = j2;
        zzwgVar.zzj = true;
        zzwgVar.zzn = false;
    }

    private final zzgo zzi(long j) {
        zzgm zzgmVar = new zzgm();
        zzgmVar.zzd(this.zzc);
        zzgmVar.zzc(j);
        zzgmVar.zza(6);
        zzgmVar.zzb(zzwl.zzb);
        return zzgmVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3 A[Catch: all -> 0x01e1, TryCatch #1 {all -> 0x01e1, blocks: (B:23:0x0098, B:25:0x00a3, B:26:0x00af, B:28:0x00b9, B:29:0x00c5, B:31:0x00cf, B:32:0x00db, B:34:0x00e5, B:35:0x00f7, B:37:0x0101, B:39:0x0107, B:44:0x0135, B:45:0x013c, B:47:0x0149, B:49:0x0151, B:50:0x016c, B:52:0x017f, B:53:0x0182, B:55:0x0186, B:98:0x0111, B:101:0x0125, B:113:0x006c, B:117:0x0084), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9 A[Catch: all -> 0x01e1, TryCatch #1 {all -> 0x01e1, blocks: (B:23:0x0098, B:25:0x00a3, B:26:0x00af, B:28:0x00b9, B:29:0x00c5, B:31:0x00cf, B:32:0x00db, B:34:0x00e5, B:35:0x00f7, B:37:0x0101, B:39:0x0107, B:44:0x0135, B:45:0x013c, B:47:0x0149, B:49:0x0151, B:50:0x016c, B:52:0x017f, B:53:0x0182, B:55:0x0186, B:98:0x0111, B:101:0x0125, B:113:0x006c, B:117:0x0084), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf A[Catch: all -> 0x01e1, TryCatch #1 {all -> 0x01e1, blocks: (B:23:0x0098, B:25:0x00a3, B:26:0x00af, B:28:0x00b9, B:29:0x00c5, B:31:0x00cf, B:32:0x00db, B:34:0x00e5, B:35:0x00f7, B:37:0x0101, B:39:0x0107, B:44:0x0135, B:45:0x013c, B:47:0x0149, B:49:0x0151, B:50:0x016c, B:52:0x017f, B:53:0x0182, B:55:0x0186, B:98:0x0111, B:101:0x0125, B:113:0x006c, B:117:0x0084), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e5 A[Catch: all -> 0x01e1, TryCatch #1 {all -> 0x01e1, blocks: (B:23:0x0098, B:25:0x00a3, B:26:0x00af, B:28:0x00b9, B:29:0x00c5, B:31:0x00cf, B:32:0x00db, B:34:0x00e5, B:35:0x00f7, B:37:0x0101, B:39:0x0107, B:44:0x0135, B:45:0x013c, B:47:0x0149, B:49:0x0151, B:50:0x016c, B:52:0x017f, B:53:0x0182, B:55:0x0186, B:98:0x0111, B:101:0x0125, B:113:0x006c, B:117:0x0084), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101 A[Catch: all -> 0x01e1, TRY_LEAVE, TryCatch #1 {all -> 0x01e1, blocks: (B:23:0x0098, B:25:0x00a3, B:26:0x00af, B:28:0x00b9, B:29:0x00c5, B:31:0x00cf, B:32:0x00db, B:34:0x00e5, B:35:0x00f7, B:37:0x0101, B:39:0x0107, B:44:0x0135, B:45:0x013c, B:47:0x0149, B:49:0x0151, B:50:0x016c, B:52:0x017f, B:53:0x0182, B:55:0x0186, B:98:0x0111, B:101:0x0125, B:113:0x006c, B:117:0x0084), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0135 A[Catch: all -> 0x01e1, TryCatch #1 {all -> 0x01e1, blocks: (B:23:0x0098, B:25:0x00a3, B:26:0x00af, B:28:0x00b9, B:29:0x00c5, B:31:0x00cf, B:32:0x00db, B:34:0x00e5, B:35:0x00f7, B:37:0x0101, B:39:0x0107, B:44:0x0135, B:45:0x013c, B:47:0x0149, B:49:0x0151, B:50:0x016c, B:52:0x017f, B:53:0x0182, B:55:0x0186, B:98:0x0111, B:101:0x0125, B:113:0x006c, B:117:0x0084), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0149 A[Catch: all -> 0x01e1, TryCatch #1 {all -> 0x01e1, blocks: (B:23:0x0098, B:25:0x00a3, B:26:0x00af, B:28:0x00b9, B:29:0x00c5, B:31:0x00cf, B:32:0x00db, B:34:0x00e5, B:35:0x00f7, B:37:0x0101, B:39:0x0107, B:44:0x0135, B:45:0x013c, B:47:0x0149, B:49:0x0151, B:50:0x016c, B:52:0x017f, B:53:0x0182, B:55:0x0186, B:98:0x0111, B:101:0x0125, B:113:0x006c, B:117:0x0084), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017f A[Catch: all -> 0x01e1, TryCatch #1 {all -> 0x01e1, blocks: (B:23:0x0098, B:25:0x00a3, B:26:0x00af, B:28:0x00b9, B:29:0x00c5, B:31:0x00cf, B:32:0x00db, B:34:0x00e5, B:35:0x00f7, B:37:0x0101, B:39:0x0107, B:44:0x0135, B:45:0x013c, B:47:0x0149, B:49:0x0151, B:50:0x016c, B:52:0x017f, B:53:0x0182, B:55:0x0186, B:98:0x0111, B:101:0x0125, B:113:0x006c, B:117:0x0084), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0186 A[Catch: all -> 0x01e1, TRY_LEAVE, TryCatch #1 {all -> 0x01e1, blocks: (B:23:0x0098, B:25:0x00a3, B:26:0x00af, B:28:0x00b9, B:29:0x00c5, B:31:0x00cf, B:32:0x00db, B:34:0x00e5, B:35:0x00f7, B:37:0x0101, B:39:0x0107, B:44:0x0135, B:45:0x013c, B:47:0x0149, B:49:0x0151, B:50:0x016c, B:52:0x017f, B:53:0x0182, B:55:0x0186, B:98:0x0111, B:101:0x0125, B:113:0x006c, B:117:0x0084), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0200 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[LOOP:0: B:2:0x0004->B:86:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c7 A[EDGE_INSN: B:95:0x01c7->B:76:0x01c7 BREAK  A[LOOP:1: B:57:0x018e->B:68:0x018e], SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzzv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzh() throws IOException {
        long j;
        boolean z;
        int i;
        List list;
        String str;
        List list2;
        String str2;
        List list3;
        String str3;
        List list4;
        boolean z2;
        List list5;
        int i2;
        zzgj zzgjVar;
        zzwl zzwlVar;
        zzgj zzgjVar2;
        int i3;
        int i4;
        int i5;
        while (!this.zzi) {
            int i6 = 0;
            try {
                long j2 = this.zzh.zza;
                zzgo zzi = zzi(j2);
                this.zzl = zzi;
                zzhi zzhiVar = this.zzd;
                long zzb = zzhiVar.zzb(zzi);
                if (this.zzi) {
                    zzwa zzwaVar = this.zze;
                    if (zzwaVar.zzb() != -1) {
                        this.zzh.zza = zzwaVar.zzb();
                    }
                    zzgl.zza(this.zzd);
                    return;
                }
                if (zzb != -1) {
                    zzb += j2;
                    zzwl.zzF(this.zza);
                }
                long j3 = zzb;
                zzwl zzwlVar2 = this.zza;
                Map zze = zzhiVar.zze();
                List list6 = (List) zze.get("icy-br");
                try {
                    if (list6 != null) {
                        String str4 = (String) list6.get(0);
                        try {
                            i5 = Integer.parseInt(str4) * 1000;
                        } catch (NumberFormatException unused) {
                            j = -1;
                            i5 = -1;
                        }
                        if (i5 > 0) {
                            j = -1;
                            z = true;
                            i = i5;
                            list = (List) zze.get("icy-genre");
                            if (list != null) {
                                str = (String) list.get(0);
                                z = true;
                            } else {
                                str = null;
                            }
                            list2 = (List) zze.get("icy-name");
                            if (list2 != null) {
                                str2 = (String) list2.get(0);
                                z = true;
                            } else {
                                str2 = null;
                            }
                            list3 = (List) zze.get("icy-url");
                            if (list3 != null) {
                                str3 = (String) list3.get(0);
                                z = true;
                            } else {
                                str3 = null;
                            }
                            list4 = (List) zze.get("icy-pub");
                            if (list4 != null) {
                                z2 = ((String) list4.get(0)).equals("1");
                                z = true;
                            } else {
                                z2 = false;
                            }
                            list5 = (List) zze.get("icy-metaint");
                            if (list5 != null) {
                                String str5 = (String) list5.get(0);
                                try {
                                    i4 = Integer.parseInt(str5);
                                } catch (NumberFormatException unused2) {
                                    i4 = -1;
                                }
                                if (i4 > 0) {
                                    z = true;
                                    i2 = i4;
                                    zzwlVar2.zzs = z ? new zzagv(i, str, str2, str3, z2, i2) : null;
                                    zzgjVar = this.zzd;
                                    zzwlVar = this.zza;
                                    if (zzwlVar.zzs != null || zzwlVar.zzs.zzf == -1) {
                                        zzgjVar2 = zzgjVar;
                                    } else {
                                        zzgj zzuxVar = new zzux(zzgjVar, zzwlVar.zzs.zzf, this);
                                        zzafb zzv = zzwlVar.zzv();
                                        this.zzm = zzv;
                                        zzv.zzm(zzwl.zzc);
                                        zzgjVar2 = zzuxVar;
                                    }
                                    zzwa zzwaVar2 = this.zze;
                                    zzwaVar2.zzd(zzgjVar2, this.zzc, zzgjVar.zze(), j2, j3, this.zzf);
                                    if (zzwlVar.zzs != null) {
                                        zzwaVar2.zzc();
                                    }
                                    if (this.zzj) {
                                        zzwaVar2.zzf(j2, this.zzk);
                                        this.zzj = false;
                                    }
                                    i3 = 0;
                                    while (true) {
                                        if (i3 != 0) {
                                            break;
                                        }
                                        try {
                                            if (this.zzi) {
                                                i3 = 0;
                                                break;
                                            }
                                            try {
                                                zzdm zzdmVar = this.zzg;
                                                zzdmVar.zza();
                                                i3 = zzwaVar2.zza(this.zzh);
                                                long zzb2 = zzwaVar2.zzb();
                                                if (zzb2 > zzwlVar.zzj + j2) {
                                                    zzdmVar.zzd();
                                                    zzwlVar.zzq.post(zzwlVar.zzp);
                                                    j2 = zzb2;
                                                }
                                            } catch (InterruptedException unused3) {
                                                throw new InterruptedIOException();
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            i6 = i3;
                                            if (i6 != 1) {
                                                zzwa zzwaVar3 = this.zze;
                                                if (zzwaVar3.zzb() != j) {
                                                    this.zzh.zza = zzwaVar3.zzb();
                                                }
                                            }
                                            zzgl.zza(this.zzd);
                                            throw th;
                                        }
                                    }
                                    if (i3 != 1) {
                                        if (zzwaVar2.zzb() != j) {
                                            this.zzh.zza = zzwaVar2.zzb();
                                        }
                                        i6 = i3;
                                    }
                                    zzgl.zza(zzgjVar);
                                    if (i6 != 0) {
                                        return;
                                    }
                                } else {
                                    try {
                                        zzea.zzf("IcyHeaders", "Invalid metadata interval: " + str5);
                                    } catch (NumberFormatException unused4) {
                                        zzea.zzf("IcyHeaders", "Invalid metadata interval: ".concat(String.valueOf(str5)));
                                        i2 = i4;
                                        zzwlVar2.zzs = z ? new zzagv(i, str, str2, str3, z2, i2) : null;
                                        zzgjVar = this.zzd;
                                        zzwlVar = this.zza;
                                        if (zzwlVar.zzs != null) {
                                        }
                                        zzgjVar2 = zzgjVar;
                                        zzwa zzwaVar22 = this.zze;
                                        zzwaVar22.zzd(zzgjVar2, this.zzc, zzgjVar.zze(), j2, j3, this.zzf);
                                        if (zzwlVar.zzs != null) {
                                        }
                                        if (this.zzj) {
                                        }
                                        i3 = 0;
                                        while (true) {
                                            if (i3 != 0) {
                                            }
                                        }
                                        if (i3 != 1) {
                                        }
                                        zzgl.zza(zzgjVar);
                                        if (i6 != 0) {
                                        }
                                    }
                                }
                            }
                            i2 = -1;
                            zzwlVar2.zzs = z ? new zzagv(i, str, str2, str3, z2, i2) : null;
                            zzgjVar = this.zzd;
                            zzwlVar = this.zza;
                            if (zzwlVar.zzs != null) {
                            }
                            zzgjVar2 = zzgjVar;
                            zzwa zzwaVar222 = this.zze;
                            zzwaVar222.zzd(zzgjVar2, this.zzc, zzgjVar.zze(), j2, j3, this.zzf);
                            if (zzwlVar.zzs != null) {
                            }
                            if (this.zzj) {
                            }
                            i3 = 0;
                            while (true) {
                                if (i3 != 0) {
                                }
                            }
                            if (i3 != 1) {
                            }
                            zzgl.zza(zzgjVar);
                            if (i6 != 0) {
                            }
                        } else {
                            j = -1;
                            try {
                                zzea.zzf("IcyHeaders", "Invalid bitrate: " + str4);
                            } catch (NumberFormatException unused5) {
                                zzea.zzf("IcyHeaders", "Invalid bitrate header: ".concat(String.valueOf(str4)));
                                z = false;
                                i = i5;
                                list = (List) zze.get("icy-genre");
                                if (list != null) {
                                }
                                list2 = (List) zze.get("icy-name");
                                if (list2 != null) {
                                }
                                list3 = (List) zze.get("icy-url");
                                if (list3 != null) {
                                }
                                list4 = (List) zze.get("icy-pub");
                                if (list4 != null) {
                                }
                                list5 = (List) zze.get("icy-metaint");
                                if (list5 != null) {
                                }
                                i2 = -1;
                                zzwlVar2.zzs = z ? new zzagv(i, str, str2, str3, z2, i2) : null;
                                zzgjVar = this.zzd;
                                zzwlVar = this.zza;
                                if (zzwlVar.zzs != null) {
                                }
                                zzgjVar2 = zzgjVar;
                                zzwa zzwaVar2222 = this.zze;
                                zzwaVar2222.zzd(zzgjVar2, this.zzc, zzgjVar.zze(), j2, j3, this.zzf);
                                if (zzwlVar.zzs != null) {
                                }
                                if (this.zzj) {
                                }
                                i3 = 0;
                                while (true) {
                                    if (i3 != 0) {
                                    }
                                }
                                if (i3 != 1) {
                                }
                                zzgl.zza(zzgjVar);
                                if (i6 != 0) {
                                }
                            }
                        }
                    } else {
                        j = -1;
                    }
                    list = (List) zze.get("icy-genre");
                    if (list != null) {
                    }
                    list2 = (List) zze.get("icy-name");
                    if (list2 != null) {
                    }
                    list3 = (List) zze.get("icy-url");
                    if (list3 != null) {
                    }
                    list4 = (List) zze.get("icy-pub");
                    if (list4 != null) {
                    }
                    list5 = (List) zze.get("icy-metaint");
                    if (list5 != null) {
                    }
                    i2 = -1;
                    zzwlVar2.zzs = z ? new zzagv(i, str, str2, str3, z2, i2) : null;
                    zzgjVar = this.zzd;
                    zzwlVar = this.zza;
                    if (zzwlVar.zzs != null) {
                    }
                    zzgjVar2 = zzgjVar;
                    zzwa zzwaVar22222 = this.zze;
                    zzwaVar22222.zzd(zzgjVar2, this.zzc, zzgjVar.zze(), j2, j3, this.zzf);
                    if (zzwlVar.zzs != null) {
                    }
                    if (this.zzj) {
                    }
                    i3 = 0;
                    while (true) {
                        if (i3 != 0) {
                        }
                    }
                    if (i3 != 1) {
                    }
                    zzgl.zza(zzgjVar);
                    if (i6 != 0) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                z = false;
                i = -1;
            } catch (Throwable th3) {
                th = th3;
                j = -1;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zza(zzen zzenVar) {
        long max = !this.zzn ? this.zzk : Math.max(zzwl.zzr(this.zza, true), this.zzk);
        int zza = zzenVar.zza();
        zzafb zzafbVar = this.zzm;
        zzafbVar.getClass();
        zzafbVar.zzr(zzenVar, zza);
        zzafbVar.zzt(max, 1, zza, 0, null);
        this.zzn = true;
    }
}
