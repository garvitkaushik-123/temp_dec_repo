package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import com.google.android.gms.nearby.uwb.RangingPosition;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzalg {
    private final zzen zza = new zzen();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static /* bridge */ /* synthetic */ void zzb(zzalg zzalgVar, zzen zzenVar, int i) {
        int zzo;
        if (i < 4) {
            return;
        }
        zzenVar.zzM(3);
        int i2 = i - 4;
        if ((zzenVar.zzm() & 128) != 0) {
            if (i2 < 7 || (zzo = zzenVar.zzo()) < 4) {
                return;
            }
            zzalgVar.zzh = zzenVar.zzq();
            zzalgVar.zzi = zzenVar.zzq();
            zzalgVar.zza.zzI(zzo - 4);
            i2 = i - 11;
        }
        zzen zzenVar2 = zzalgVar.zza;
        int zzc = zzenVar2.zzc();
        int zzd = zzenVar2.zzd();
        if (zzc >= zzd || i2 <= 0) {
            return;
        }
        int min = Math.min(i2, zzd - zzc);
        zzenVar.zzH(zzenVar2.zzN(), zzc, min);
        zzenVar2.zzL(zzc + min);
    }

    static /* bridge */ /* synthetic */ void zzc(zzalg zzalgVar, zzen zzenVar, int i) {
        if (i < 19) {
            return;
        }
        zzalgVar.zzd = zzenVar.zzq();
        zzalgVar.zze = zzenVar.zzq();
        zzenVar.zzM(11);
        zzalgVar.zzf = zzenVar.zzq();
        zzalgVar.zzg = zzenVar.zzq();
    }

    static /* bridge */ /* synthetic */ void zzd(zzalg zzalgVar, zzen zzenVar, int i) {
        if (i % 5 != 2) {
            return;
        }
        zzenVar.zzM(2);
        int[] iArr = zzalgVar.zzb;
        Arrays.fill(iArr, 0);
        int i2 = 0;
        for (int i3 = i / 5; i2 < i3; i3 = i3) {
            int zzm = zzenVar.zzm();
            int zzm2 = zzenVar.zzm();
            int zzm3 = zzenVar.zzm();
            int zzm4 = zzenVar.zzm();
            int zzm5 = zzenVar.zzm();
            double d = zzm2;
            int i4 = zzm3 + RangingPosition.RSSI_UNKNOWN;
            int i5 = zzm4 + RangingPosition.RSSI_UNKNOWN;
            int i6 = zzm5 << 24;
            String str = zzex.zza;
            double d2 = i4;
            double d3 = i5;
            iArr[zzm] = (Math.max(0, Math.min((int) (d + (1.402d * d2)), 255)) << 16) | i6 | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)) << 8) | Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255));
            i2++;
        }
        zzalgVar.zzc = true;
    }

    public final zzcu zza() {
        int i;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzen zzenVar = this.zza;
        if (zzenVar.zzd() == 0 || zzenVar.zzc() != zzenVar.zzd() || !this.zzc) {
            return null;
        }
        zzenVar.zzL(0);
        int i2 = this.zzh * this.zzi;
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int zzm = zzenVar.zzm();
            if (zzm != 0) {
                i = i3 + 1;
                iArr[i3] = this.zzb[zzm];
            } else {
                int zzm2 = zzenVar.zzm();
                if (zzm2 != 0) {
                    int i4 = zzm2 & 63;
                    if ((zzm2 & 64) != 0) {
                        i4 = (i4 << 8) | zzenVar.zzm();
                    }
                    i = i4 + i3;
                    Arrays.fill(iArr, i3, i, (zzm2 & 128) == 0 ? this.zzb[0] : this.zzb[zzenVar.zzm()]);
                }
            }
            i3 = i;
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcs zzcsVar = new zzcs();
        zzcsVar.zzc(createBitmap);
        zzcsVar.zzh(this.zzf / this.zzd);
        zzcsVar.zzi(0);
        zzcsVar.zze(this.zzg / this.zze, 0);
        zzcsVar.zzf(0);
        zzcsVar.zzk(this.zzh / this.zzd);
        zzcsVar.zzd(this.zzi / this.zze);
        return zzcsVar.zzq();
    }

    public final void zze() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zzI(0);
        this.zzc = false;
    }
}
