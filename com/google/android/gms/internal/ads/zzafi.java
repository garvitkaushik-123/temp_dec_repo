package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzafi implements zzadv {
    private static final int[] zza = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzb = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private static final byte[] zzc;
    private static final byte[] zzd;
    private final byte[] zze;
    private final zzafb zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private zzady zzn;
    private zzafb zzo;
    private zzafb zzp;
    private zzaeu zzq;
    private long zzr;
    private boolean zzs;

    static {
        String str = zzex.zza;
        zzc = "#!AMR\n".getBytes(StandardCharsets.UTF_8);
        zzd = "#!AMR-WB\n".getBytes(StandardCharsets.UTF_8);
    }

    public zzafi() {
        throw null;
    }

    public zzafi(int i) {
        this.zze = new byte[1];
        this.zzk = -1;
        zzadr zzadrVar = new zzadr();
        this.zzf = zzadrVar;
        this.zzp = zzadrVar;
    }

    private static boolean zzg(zzadw zzadwVar, byte[] bArr) throws IOException {
        zzadwVar.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        zzadwVar.zzh(bArr2, 0, length);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzh(zzadw zzadwVar) throws IOException {
        byte[] bArr = zzc;
        if (zzg(zzadwVar, bArr)) {
            this.zzg = false;
            zzadwVar.zzk(bArr.length);
            return true;
        }
        byte[] bArr2 = zzd;
        if (!zzg(zzadwVar, bArr2)) {
            return false;
        }
        this.zzg = true;
        zzadwVar.zzk(bArr2.length);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        zzdd.zzb(this.zzo);
        String str = zzex.zza;
        if (zzadwVar.zzf() == 0 && !zzh(zzadwVar)) {
            throw zzaz.zza("Could not find AMR header.", null);
        }
        if (!this.zzs) {
            this.zzs = true;
            boolean z = this.zzg;
            String str2 = true != z ? "audio/amr" : "audio/amr-wb";
            String str3 = true != z ? "audio/3gpp" : "audio/amr-wb";
            int i = true != z ? 8000 : 16000;
            int i2 = z ? zzb[8] : zza[7];
            zzafb zzafbVar = this.zzo;
            zzx zzxVar = new zzx();
            zzxVar.zzG(str2);
            zzxVar.zzah(str3);
            zzxVar.zzX(i2);
            zzxVar.zzD(1);
            zzxVar.zzai(i);
            zzafbVar.zzm(zzxVar.zzan());
        }
        int zza2 = zza(zzadwVar);
        if (this.zzq == null) {
            zzaet zzaetVar = new zzaet(-9223372036854775807L, 0L);
            this.zzq = zzaetVar;
            this.zzn.zzP(zzaetVar);
        }
        return zza2 == -1 ? -1 : 0;
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
        this.zzn = zzadyVar;
        zzafb zzw = zzadyVar.zzw(0, 1);
        this.zzo = zzw;
        this.zzp = zzw;
        zzadyVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzh = 0L;
        this.zzi = 0;
        this.zzj = 0;
        this.zzr = j2;
        this.zzm = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        return zzh(zzadwVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0039 A[Catch: EOFException -> 0x00ab, TryCatch #0 {EOFException -> 0x00ab, blocks: (B:13:0x000c, B:15:0x001b, B:23:0x0039, B:24:0x0042, B:30:0x003e, B:40:0x0081, B:41:0x0099, B:42:0x009a, B:43:0x00aa), top: B:12:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003e A[Catch: EOFException -> 0x00ab, TryCatch #0 {EOFException -> 0x00ab, blocks: (B:13:0x000c, B:15:0x001b, B:23:0x0039, B:24:0x0042, B:30:0x003e, B:40:0x0081, B:41:0x0099, B:42:0x009a, B:43:0x00aa), top: B:12:0x000c }] */
    @RequiresNonNull({"realTrackOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zza(zzadw zzadwVar) throws IOException {
        int i;
        int i2 = this.zzj;
        if (i2 == 0) {
            try {
                zzadwVar.zzj();
                byte[] bArr = this.zze;
                zzadwVar.zzh(bArr, 0, 1);
                byte b = bArr[0];
                if ((b & 131) > 0) {
                    throw zzaz.zza("Invalid padding bits for frame header " + ((int) b), null);
                }
                int i3 = b >> 3;
                boolean z = this.zzg;
                int i4 = i3 & 15;
                if (z) {
                    if (i4 >= 10) {
                        if (i4 > 13) {
                        }
                    }
                    i2 = !z ? zzb[i4] : zza[i4];
                    this.zzi = i2;
                    this.zzj = i2;
                    i = this.zzk;
                    if (i == -1) {
                        this.zzk = i2;
                        i = i2;
                    }
                    if (i == i2) {
                        this.zzl++;
                    }
                }
                if (!z) {
                    if (i4 >= 12 && i4 <= 14) {
                    }
                    i2 = !z ? zzb[i4] : zza[i4];
                    this.zzi = i2;
                    this.zzj = i2;
                    i = this.zzk;
                    if (i == -1) {
                    }
                    if (i == i2) {
                    }
                }
                throw zzaz.zza("Illegal AMR " + (true != z ? "NB" : "WB") + " frame type " + i4, null);
            } catch (EOFException unused) {
                return -1;
            }
        }
        int zzf = this.zzp.zzf(zzadwVar, i2, true);
        if (zzf == -1) {
            return -1;
        }
        int i5 = this.zzj - zzf;
        this.zzj = i5;
        if (i5 > 0) {
            return 0;
        }
        this.zzp.zzt(this.zzh, 1, this.zzi, 0, null);
        this.zzh += 20000;
        return 0;
    }
}
