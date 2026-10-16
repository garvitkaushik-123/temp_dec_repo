package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.view.ViewCompat;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzalz {
    private boolean zzb;
    private boolean zzc;
    private int[] zzd;
    private int zze;
    private int zzf;
    private Rect zzg;
    private final int[] zza = new int[4];
    private int zzh = -1;
    private int zzi = -1;

    private static int zze(int[] iArr, int i) {
        if (i >= iArr.length) {
            i = 0;
        }
        return iArr[i];
    }

    private static int zzf(int i, int i2) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((i2 * 17) << 24);
    }

    private final void zzg(zzem zzemVar, boolean z, Rect rect, int[] iArr) {
        int i;
        int i2;
        int i3 = !z ? 1 : 0;
        int width = rect.width();
        int i4 = i3 * width;
        int height = rect.height();
        while (true) {
            int i5 = 0;
            do {
                int i6 = 0;
                for (int i7 = 1; i6 < i7 && i7 <= 64; i7 <<= 2) {
                    if (zzemVar.zza() < 4) {
                        i = -1;
                        i2 = 0;
                        break;
                    }
                    i6 = (i6 << 4) | zzemVar.zzd(4);
                }
                i = i6 & 3;
                i2 = i6 < 4 ? width : i6 >> 2;
                int min = Math.min(i2, width - i5);
                if (min > 0) {
                    int i8 = i4 + min;
                    Arrays.fill(iArr, i4, i8, this.zza[i]);
                    i5 += min;
                    i4 = i8;
                }
            } while (i5 < width);
            i3 += 2;
            if (i3 >= height) {
                return;
            }
            i4 = i3 * width;
            zzemVar.zzf();
        }
    }

    public final zzcu zza(zzen zzenVar) {
        Rect rect;
        if (this.zzd == null || !this.zzb || !this.zzc || (rect = this.zzg) == null || this.zzh == -1 || this.zzi == -1 || rect.width() < 2 || this.zzg.height() < 2) {
            return null;
        }
        Rect rect2 = this.zzg;
        int[] iArr = new int[rect2.width() * rect2.height()];
        zzem zzemVar = new zzem();
        zzenVar.zzL(this.zzh);
        zzemVar.zzj(zzenVar);
        zzg(zzemVar, true, rect2, iArr);
        zzenVar.zzL(this.zzi);
        zzemVar.zzj(zzenVar);
        zzg(zzemVar, false, rect2, iArr);
        Bitmap createBitmap = Bitmap.createBitmap(iArr, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
        zzcs zzcsVar = new zzcs();
        zzcsVar.zzc(createBitmap);
        zzcsVar.zzh(rect2.left / this.zze);
        zzcsVar.zzi(0);
        zzcsVar.zze(rect2.top / this.zzf, 0);
        zzcsVar.zzf(0);
        zzcsVar.zzk(rect2.width() / this.zze);
        zzcsVar.zzd(rect2.height() / this.zzf);
        return zzcsVar.zzq();
    }

    public final void zzb(String str) {
        int i;
        String trim = str.trim();
        String str2 = zzex.zza;
        for (String str3 : trim.split("\\r?\\n", -1)) {
            if (str3.startsWith("palette: ")) {
                String[] split = str3.substring(9).split(",", -1);
                this.zzd = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    int[] iArr = this.zzd;
                    try {
                        i = Integer.parseInt(split[i2].trim(), 16);
                    } catch (RuntimeException unused) {
                        i = 0;
                    }
                    iArr[i2] = i;
                }
            } else if (str3.startsWith("size: ")) {
                String[] split2 = str3.substring(6).trim().split(VastAttributes.HORIZONTAL_POSITION, -1);
                if (split2.length == 2) {
                    try {
                        this.zze = Integer.parseInt(split2[0]);
                        this.zzf = Integer.parseInt(split2[1]);
                        this.zzb = true;
                    } catch (RuntimeException e) {
                        zzea.zzg("VobsubParser", "Parsing IDX failed", e);
                    }
                }
            }
        }
    }

    public final void zzc(zzen zzenVar) {
        int[] iArr = this.zzd;
        if (iArr == null || !this.zzb) {
            return;
        }
        zzenVar.zzM(zzenVar.zzq() - 2);
        int zzq = zzenVar.zzq();
        while (zzenVar.zzc() < zzq && zzenVar.zza() > 0) {
            switch (zzenVar.zzm()) {
                case 0:
                case 1:
                case 2:
                    break;
                case 3:
                    if (zzenVar.zza() >= 2) {
                        int zzm = zzenVar.zzm();
                        int zzm2 = zzenVar.zzm();
                        int[] iArr2 = this.zza;
                        iArr2[3] = zze(iArr, zzm >> 4);
                        iArr2[2] = zze(iArr, zzm & 15);
                        iArr2[1] = zze(iArr, zzm2 >> 4);
                        iArr2[0] = zze(iArr, zzm2 & 15);
                        this.zzc = true;
                        break;
                    } else {
                        return;
                    }
                case 4:
                    if (zzenVar.zza() >= 2 && this.zzc) {
                        int zzm3 = zzenVar.zzm();
                        int zzm4 = zzenVar.zzm();
                        int[] iArr3 = this.zza;
                        iArr3[3] = zzf(iArr3[3], zzm3 >> 4);
                        iArr3[2] = zzf(iArr3[2], zzm3 & 15);
                        iArr3[1] = zzf(iArr3[1], zzm4 >> 4);
                        iArr3[0] = zzf(iArr3[0], zzm4 & 15);
                        break;
                    } else {
                        return;
                    }
                    break;
                case 5:
                    if (zzenVar.zza() >= 6) {
                        int zzm5 = zzenVar.zzm();
                        int zzm6 = zzenVar.zzm();
                        int i = zzm6 >> 4;
                        int zzm7 = ((zzm6 & 15) << 8) | zzenVar.zzm();
                        int zzm8 = zzenVar.zzm();
                        int zzm9 = zzenVar.zzm();
                        this.zzg = new Rect((zzm5 << 4) | i, (zzm8 << 4) | (zzm9 >> 4), zzm7 + 1, (((zzm9 & 15) << 8) | zzenVar.zzm()) + 1);
                        break;
                    } else {
                        return;
                    }
                case 6:
                    if (zzenVar.zza() >= 4) {
                        this.zzh = zzenVar.zzq();
                        this.zzi = zzenVar.zzq();
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public final void zzd() {
        this.zzc = false;
        this.zzg = null;
        this.zzh = -1;
        this.zzi = -1;
    }
}
