package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzalf implements zzakt {
    private static final byte[] zza = {0, 7, 8, Ascii.SI};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzaky zzg;
    private final zzakx zzh;
    private final zzale zzi;
    private Bitmap zzj;

    public zzalf(List list) {
        zzen zzenVar = new zzen((byte[]) list.get(0));
        int zzq = zzenVar.zzq();
        int zzq2 = zzenVar.zzq();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzaky(719, 575, 0, 719, 0, 575);
        this.zzh = new zzakx(0, zzg(), zzh(), zzi());
        this.zzi = new zzale(zzq, zzq2);
    }

    private static int zzb(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static zzakx zzc(zzem zzemVar, int i) {
        int zzd;
        int zzd2;
        int i2;
        int i3;
        int i4 = 8;
        int zzd3 = zzemVar.zzd(8);
        zzemVar.zzn(8);
        int[] zzg = zzg();
        int[] zzh = zzh();
        int[] zzi = zzi();
        int i5 = i - 2;
        while (i5 > 0) {
            int zzd4 = zzemVar.zzd(i4);
            int zzd5 = zzemVar.zzd(i4);
            int[] iArr = (zzd5 & 128) != 0 ? zzg : (zzd5 & 64) != 0 ? zzh : zzi;
            if ((zzd5 & 1) != 0) {
                i2 = zzemVar.zzd(i4);
                i3 = zzemVar.zzd(i4);
                zzd = zzemVar.zzd(i4);
                zzd2 = zzemVar.zzd(i4);
                i5 -= 6;
            } else {
                int zzd6 = zzemVar.zzd(6) << 2;
                int zzd7 = zzemVar.zzd(4) << 4;
                i5 -= 4;
                zzd = zzemVar.zzd(4) << 4;
                zzd2 = zzemVar.zzd(2) << 6;
                i2 = zzd6;
                i3 = zzd7;
            }
            if (i2 == 0) {
                zzd2 = 255;
            }
            if (i2 == 0) {
                zzd = 0;
            }
            if (i2 == 0) {
                i3 = 0;
            }
            int i6 = zzd + RangingPosition.RSSI_UNKNOWN;
            double d = i2;
            String str = zzex.zza;
            double d2 = i3 + RangingPosition.RSSI_UNKNOWN;
            double d3 = i6;
            iArr[zzd4] = zzb((byte) (255 - (zzd2 & 255)), Math.max(0, Math.min((int) (d + (1.402d * d2)), 255)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)), Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)));
            zzd3 = zzd3;
            i4 = 8;
        }
        return new zzakx(zzd3, zzg, zzh, zzi);
    }

    private static zzakz zzd(zzem zzemVar) {
        byte[] bArr;
        int zzd = zzemVar.zzd(16);
        zzemVar.zzn(4);
        int zzd2 = zzemVar.zzd(2);
        boolean zzp = zzemVar.zzp();
        zzemVar.zzn(1);
        byte[] bArr2 = zzex.zzb;
        if (zzd2 == 1) {
            zzemVar.zzn(zzemVar.zzd(8) * 16);
        } else if (zzd2 == 0) {
            int zzd3 = zzemVar.zzd(16);
            int zzd4 = zzemVar.zzd(16);
            if (zzd3 > 0) {
                bArr2 = new byte[zzd3];
                zzemVar.zzi(bArr2, 0, zzd3);
            }
            if (zzd4 > 0) {
                bArr = new byte[zzd4];
                zzemVar.zzi(bArr, 0, zzd4);
                return new zzakz(zzd, zzp, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new zzakz(zzd, zzp, bArr2, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fe A[LOOP:3: B:85:0x0163->B:98:0x01fe, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01fa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zze(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int i4;
        int zzd;
        char c;
        int i5;
        int i6;
        int i7;
        int zzd2;
        int i8;
        int i9;
        boolean z;
        int zzd3;
        int zzd4;
        int i10;
        int i11;
        int i12;
        int zzd5;
        int i13;
        Paint paint2 = paint;
        zzem zzemVar = new zzem(bArr, bArr.length);
        int i14 = i2;
        int i15 = i3;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        while (zzemVar.zza() != 0) {
            int zzd6 = zzemVar.zzd(8);
            if (zzd6 != 240) {
                int i16 = 4;
                int i17 = 1;
                int i18 = 2;
                switch (zzd6) {
                    case 16:
                        int i19 = 1;
                        if (i != 3) {
                            if (i != 2) {
                                bArr2 = null;
                            } else if (bArr6 == null) {
                                bArr3 = zza;
                                bArr2 = bArr3;
                            } else {
                                bArr2 = bArr6;
                            }
                            i4 = 0;
                            while (true) {
                                zzd = zzemVar.zzd(2);
                                if (zzd != 0) {
                                }
                                i5 = i4;
                                c = 4;
                                if (i7 != 0) {
                                }
                                i8 = i14;
                                i14 = i8 + i7;
                                if (i5 != 0) {
                                }
                                paint2 = paint;
                                i4 = i5;
                                i19 = 1;
                            }
                        } else if (bArr4 == null) {
                            bArr3 = zzb;
                            bArr2 = bArr3;
                            i4 = 0;
                            while (true) {
                                zzd = zzemVar.zzd(2);
                                if (zzd != 0) {
                                    i7 = i19;
                                    i6 = zzd;
                                } else {
                                    if (zzemVar.zzp()) {
                                        zzd2 = zzemVar.zzd(3) + 3;
                                        i6 = zzemVar.zzd(2);
                                    } else {
                                        if (zzemVar.zzp()) {
                                            i7 = i19;
                                            i5 = i4;
                                            i6 = 0;
                                        } else {
                                            int zzd7 = zzemVar.zzd(2);
                                            if (zzd7 == 0) {
                                                c = 4;
                                                i5 = i19;
                                                i6 = 0;
                                                i7 = 0;
                                            } else if (zzd7 == i19) {
                                                c = 4;
                                                i5 = i4;
                                                i7 = 2;
                                                i6 = 0;
                                            } else if (zzd7 == 2) {
                                                c = 4;
                                                i5 = i4;
                                                i7 = zzemVar.zzd(4) + 12;
                                                i6 = zzemVar.zzd(2);
                                            } else if (zzd7 != 3) {
                                                i5 = i4;
                                                i6 = 0;
                                                i7 = 0;
                                            } else {
                                                zzd2 = zzemVar.zzd(8) + 29;
                                                i6 = zzemVar.zzd(2);
                                            }
                                            if (i7 != 0 || paint2 == null) {
                                                i8 = i14;
                                            } else {
                                                int i20 = i15 + 1;
                                                float f = i15;
                                                if (bArr2 != 0) {
                                                    i6 = bArr2[i6];
                                                }
                                                paint2.setColor(iArr[i6]);
                                                i8 = i14;
                                                canvas.drawRect(i14, f, i14 + i7, i20, paint2);
                                            }
                                            i14 = i8 + i7;
                                            if (i5 != 0) {
                                                zzemVar.zzf();
                                                break;
                                            } else {
                                                paint2 = paint;
                                                i4 = i5;
                                                i19 = 1;
                                            }
                                        }
                                        c = 4;
                                        if (i7 != 0) {
                                        }
                                        i8 = i14;
                                        i14 = i8 + i7;
                                        if (i5 != 0) {
                                        }
                                    }
                                    i7 = zzd2;
                                }
                                i5 = i4;
                                c = 4;
                                if (i7 != 0) {
                                }
                                i8 = i14;
                                i14 = i8 + i7;
                                if (i5 != 0) {
                                }
                            }
                        } else {
                            bArr2 = bArr4;
                            i4 = 0;
                            while (true) {
                                zzd = zzemVar.zzd(2);
                                if (zzd != 0) {
                                }
                                i5 = i4;
                                c = 4;
                                if (i7 != 0) {
                                }
                                i8 = i14;
                                i14 = i8 + i7;
                                if (i5 != 0) {
                                }
                                paint2 = paint;
                                i4 = i5;
                                i19 = 1;
                            }
                        }
                    case 17:
                        byte[] bArr7 = i == 3 ? bArr5 == null ? zzc : bArr5 : null;
                        boolean z2 = false;
                        while (true) {
                            int zzd8 = zzemVar.zzd(i16);
                            if (zzd8 != 0) {
                                i9 = 1;
                                z = z2;
                            } else if (zzemVar.zzp()) {
                                if (zzemVar.zzp()) {
                                    int zzd9 = zzemVar.zzd(i18);
                                    if (zzd9 == 0) {
                                        i9 = 1;
                                        z = z2;
                                        zzd8 = 0;
                                    } else if (zzd9 == 1) {
                                        z = z2;
                                        i9 = i18;
                                        zzd8 = 0;
                                    } else if (zzd9 == i18) {
                                        zzd3 = zzemVar.zzd(i16) + 9;
                                        zzd4 = zzemVar.zzd(i16);
                                    } else if (zzd9 != 3) {
                                        z = z2;
                                        zzd8 = 0;
                                        i9 = 0;
                                    } else {
                                        zzd3 = zzemVar.zzd(8) + 25;
                                        zzd4 = zzemVar.zzd(i16);
                                    }
                                } else {
                                    zzd3 = zzemVar.zzd(i18) + i16;
                                    zzd4 = zzemVar.zzd(i16);
                                }
                                i9 = zzd3;
                                z = z2;
                                zzd8 = zzd4;
                            } else {
                                int zzd10 = zzemVar.zzd(3);
                                if (zzd10 != 0) {
                                    i9 = zzd10 + 2;
                                    z = z2;
                                    zzd8 = 0;
                                } else {
                                    z = true;
                                    zzd8 = 0;
                                    i9 = 0;
                                }
                            }
                            if (i9 == 0 || paint2 == null) {
                                i10 = i14;
                                i11 = i18;
                            } else {
                                int i21 = i15 + 1;
                                float f2 = i15;
                                if (bArr7 != 0) {
                                    zzd8 = bArr7[zzd8];
                                }
                                paint2.setColor(iArr[zzd8]);
                                i10 = i14;
                                i11 = 2;
                                canvas.drawRect(i14, f2, i14 + i9, i21, paint2);
                            }
                            i14 = i10 + i9;
                            if (z) {
                                zzemVar.zzf();
                                continue;
                            } else {
                                i18 = i11;
                                z2 = z;
                                i16 = 4;
                            }
                        }
                    case 18:
                        int i22 = i14;
                        int i23 = 0;
                        while (true) {
                            int zzd11 = zzemVar.zzd(8);
                            if (zzd11 != 0) {
                                i12 = i23;
                                zzd5 = i17;
                            } else if (zzemVar.zzp()) {
                                i12 = i23;
                                zzd5 = zzemVar.zzd(7);
                                zzd11 = zzemVar.zzd(8);
                            } else {
                                int zzd12 = zzemVar.zzd(7);
                                if (zzd12 != 0) {
                                    i12 = i23;
                                    zzd5 = zzd12;
                                    zzd11 = 0;
                                } else {
                                    i12 = i17;
                                    zzd11 = 0;
                                    zzd5 = 0;
                                }
                            }
                            if (zzd5 == 0 || paint2 == null) {
                                i13 = i17;
                            } else {
                                paint2.setColor(iArr[zzd11]);
                                i13 = i17;
                                canvas.drawRect(i22, i15, i22 + zzd5, i15 + 1, paint2);
                            }
                            i22 += zzd5;
                            if (i12 == 0) {
                                i17 = i13;
                                i23 = i12;
                            } else {
                                i14 = i22;
                                continue;
                            }
                        }
                    default:
                        switch (zzd6) {
                            case 32:
                                bArr6 = zzf(4, 4, zzemVar);
                                break;
                            case 33:
                                bArr4 = zzf(4, 8, zzemVar);
                                break;
                            case 34:
                                bArr5 = zzf(16, 8, zzemVar);
                                break;
                            default:
                                continue;
                        }
                }
            } else {
                i15 += 2;
                i14 = i2;
            }
            paint2 = paint;
        }
    }

    private static byte[] zzf(int i, int i2, zzem zzemVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzemVar.zzd(i2);
        }
        return bArr;
    }

    private static int[] zzg() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] zzh() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            int i2 = i & 4;
            int i3 = i & 2;
            int i4 = i & 1;
            if (i < 8) {
                iArr[i] = zzb(255, 1 != i4 ? 0 : 255, i3 != 0 ? 255 : 0, i2 != 0 ? 255 : 0);
            } else {
                iArr[i] = zzb(255, 1 != i4 ? 0 : 127, i3 != 0 ? 127 : 0, i2 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] zzi() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = zzb(63, 1 != (i & 1) ? 0 : 255, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & 136;
                if (i2 == 0) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = zzb(127, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 43) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = zzb(255, (1 != (i & 1) ? 0 : 43) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        boolean z;
        zzakl zzaklVar;
        Canvas canvas;
        char c;
        char c2;
        char c3;
        int i3;
        zzale zzaleVar;
        Canvas canvas2;
        int i4;
        int i5;
        int i6;
        zzalc zzalcVar;
        int zzd;
        int zzd2;
        int i7;
        int i8;
        int i9;
        int i10;
        zzem zzemVar = new zzem(bArr, i + i2);
        zzemVar.zzl(i);
        while (true) {
            z = true;
            if (zzemVar.zza() >= 48 && zzemVar.zzd(8) == 15) {
                zzale zzaleVar2 = this.zzi;
                int zzd3 = zzemVar.zzd(8);
                int zzd4 = zzemVar.zzd(16);
                int zzd5 = zzemVar.zzd(16);
                int zzb2 = zzemVar.zzb() + zzd5;
                if (zzd5 * 8 > zzemVar.zza()) {
                    zzea.zzf("DvbParser", "Data field length exceeds limit");
                    zzemVar.zzn(zzemVar.zza());
                } else {
                    switch (zzd3) {
                        case 16:
                            if (zzd4 == zzaleVar2.zza) {
                                zzala zzalaVar = zzaleVar2.zzi;
                                int zzd6 = zzemVar.zzd(8);
                                int zzd7 = zzemVar.zzd(4);
                                int zzd8 = zzemVar.zzd(2);
                                zzemVar.zzn(2);
                                SparseArray sparseArray = new SparseArray();
                                for (int i11 = zzd5 - 2; i11 > 0; i11 -= 6) {
                                    int zzd9 = zzemVar.zzd(8);
                                    zzemVar.zzn(8);
                                    sparseArray.put(zzd9, new zzalb(zzemVar.zzd(16), zzemVar.zzd(16)));
                                }
                                zzala zzalaVar2 = new zzala(zzd6, zzd7, zzd8, sparseArray);
                                if (zzalaVar2.zzb != 0) {
                                    zzaleVar2.zzi = zzalaVar2;
                                    zzaleVar2.zzc.clear();
                                    zzaleVar2.zzd.clear();
                                    zzaleVar2.zze.clear();
                                    break;
                                } else if (zzalaVar != null) {
                                    if (zzalaVar.zza != zzalaVar2.zza) {
                                        zzaleVar2.zzi = zzalaVar2;
                                        break;
                                    }
                                }
                            }
                            break;
                        case 17:
                            zzala zzalaVar3 = zzaleVar2.zzi;
                            if (zzd4 == zzaleVar2.zza && zzalaVar3 != null) {
                                int zzd10 = zzemVar.zzd(8);
                                zzemVar.zzn(4);
                                boolean zzp = zzemVar.zzp();
                                zzemVar.zzn(3);
                                int zzd11 = zzemVar.zzd(16);
                                int zzd12 = zzemVar.zzd(16);
                                int zzd13 = zzemVar.zzd(3);
                                int zzd14 = zzemVar.zzd(3);
                                zzemVar.zzn(2);
                                int zzd15 = zzemVar.zzd(8);
                                int zzd16 = zzemVar.zzd(8);
                                int zzd17 = zzemVar.zzd(4);
                                int zzd18 = zzemVar.zzd(2);
                                zzemVar.zzn(2);
                                int i12 = zzd5 - 10;
                                SparseArray sparseArray2 = new SparseArray();
                                while (i12 > 0) {
                                    int zzd19 = zzemVar.zzd(16);
                                    int zzd20 = zzemVar.zzd(2);
                                    int zzd21 = zzemVar.zzd(2);
                                    int zzd22 = zzemVar.zzd(12);
                                    zzemVar.zzn(4);
                                    int zzd23 = zzemVar.zzd(12);
                                    int i13 = i12 - 6;
                                    if (zzd20 != 1) {
                                        if (zzd20 == 2) {
                                            zzd20 = 2;
                                        } else {
                                            i12 = i13;
                                            zzd = 0;
                                            zzd2 = 0;
                                            sparseArray2.put(zzd19, new zzald(zzd20, zzd21, zzd22, zzd23, zzd, zzd2));
                                        }
                                    }
                                    i12 -= 8;
                                    zzd = zzemVar.zzd(8);
                                    zzd2 = zzemVar.zzd(8);
                                    sparseArray2.put(zzd19, new zzald(zzd20, zzd21, zzd22, zzd23, zzd, zzd2));
                                }
                                zzalc zzalcVar2 = new zzalc(zzd10, zzp, zzd11, zzd12, zzd13, zzd14, zzd15, zzd16, zzd17, zzd18, sparseArray2);
                                if (zzalaVar3.zzb == 0 && (zzalcVar = (zzalc) zzaleVar2.zzc.get(zzalcVar2.zza)) != null) {
                                    int i14 = 0;
                                    while (true) {
                                        SparseArray sparseArray3 = zzalcVar.zzj;
                                        if (i14 < sparseArray3.size()) {
                                            zzalcVar2.zzj.put(sparseArray3.keyAt(i14), (zzald) sparseArray3.valueAt(i14));
                                            i14++;
                                        }
                                    }
                                }
                                zzaleVar2.zzc.put(zzalcVar2.zza, zzalcVar2);
                                break;
                            }
                            break;
                        case 18:
                            if (zzd4 == zzaleVar2.zza) {
                                zzakx zzc2 = zzc(zzemVar, zzd5);
                                zzaleVar2.zzd.put(zzc2.zza, zzc2);
                                break;
                            } else if (zzd4 == zzaleVar2.zzb) {
                                zzakx zzc3 = zzc(zzemVar, zzd5);
                                zzaleVar2.zzf.put(zzc3.zza, zzc3);
                                break;
                            }
                            break;
                        case 19:
                            if (zzd4 == zzaleVar2.zza) {
                                zzakz zzd24 = zzd(zzemVar);
                                zzaleVar2.zze.put(zzd24.zza, zzd24);
                                break;
                            } else if (zzd4 == zzaleVar2.zzb) {
                                zzakz zzd25 = zzd(zzemVar);
                                zzaleVar2.zzg.put(zzd25.zza, zzd25);
                                break;
                            }
                            break;
                        case 20:
                            if (zzd4 == zzaleVar2.zza) {
                                zzemVar.zzn(4);
                                boolean zzp2 = zzemVar.zzp();
                                zzemVar.zzn(3);
                                int zzd26 = zzemVar.zzd(16);
                                int zzd27 = zzemVar.zzd(16);
                                if (zzp2) {
                                    int zzd28 = zzemVar.zzd(16);
                                    i7 = zzemVar.zzd(16);
                                    i10 = zzemVar.zzd(16);
                                    i8 = zzemVar.zzd(16);
                                    i9 = zzd28;
                                } else {
                                    i7 = zzd26;
                                    i8 = zzd27;
                                    i9 = 0;
                                    i10 = 0;
                                }
                                zzaleVar2.zzh = new zzaky(zzd26, zzd27, i9, i7, i10, i8);
                                break;
                            }
                            break;
                    }
                    zzemVar.zzo(zzb2 - zzemVar.zzb());
                }
            }
        }
        zzale zzaleVar3 = this.zzi;
        zzala zzalaVar4 = zzaleVar3.zzi;
        if (zzalaVar4 == null) {
            zzaklVar = new zzakl(zzfyq.zzn(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzaky zzakyVar = zzaleVar3.zzh;
            if (zzakyVar == null) {
                zzakyVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzakyVar.zza + 1 != bitmap.getWidth() || zzakyVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap createBitmap = Bitmap.createBitmap(zzakyVar.zza + 1, zzakyVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = createBitmap;
                this.zzf.setBitmap(createBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray4 = zzalaVar4.zzc;
            int i15 = 0;
            while (i15 < sparseArray4.size()) {
                Canvas canvas3 = this.zzf;
                canvas3.save();
                zzalb zzalbVar = (zzalb) sparseArray4.valueAt(i15);
                zzalc zzalcVar3 = (zzalc) zzaleVar3.zzc.get(sparseArray4.keyAt(i15));
                int i16 = zzalbVar.zza + zzakyVar.zzc;
                int i17 = zzalbVar.zzb + zzakyVar.zze;
                int i18 = zzalcVar3.zzc;
                int i19 = i16 + i18;
                boolean z2 = z;
                int min = Math.min(i19, zzakyVar.zzd);
                int i20 = zzalcVar3.zzd;
                int i21 = i17 + i20;
                canvas3.clipRect(i16, i17, min, Math.min(i21, zzakyVar.zzf));
                int i22 = zzalcVar3.zzf;
                zzakx zzakxVar = (zzakx) zzaleVar3.zzd.get(i22);
                if (zzakxVar == null && (zzakxVar = (zzakx) zzaleVar3.zzf.get(i22)) == null) {
                    zzakxVar = this.zzh;
                }
                SparseArray sparseArray5 = zzalcVar3.zzj;
                SparseArray sparseArray6 = sparseArray4;
                int i23 = i15;
                int i24 = 0;
                while (i24 < sparseArray5.size()) {
                    int keyAt = sparseArray5.keyAt(i24);
                    int i25 = i24;
                    zzald zzaldVar = (zzald) sparseArray5.valueAt(i24);
                    SparseArray sparseArray7 = sparseArray5;
                    zzakz zzakzVar = (zzakz) zzaleVar3.zze.get(keyAt);
                    if (zzakzVar == null) {
                        zzakzVar = (zzakz) zzaleVar3.zzg.get(keyAt);
                    }
                    if (zzakzVar != null) {
                        Paint paint = zzakzVar.zzb ? null : this.zzd;
                        i5 = i18;
                        int i26 = zzalcVar3.zze;
                        zzaleVar = zzaleVar3;
                        int i27 = zzaldVar.zza + i16;
                        int i28 = i17 + zzaldVar.zzb;
                        canvas2 = canvas3;
                        i4 = i16;
                        int[] iArr = i26 == 3 ? zzakxVar.zzd : i26 == 2 ? zzakxVar.zzc : zzakxVar.zzb;
                        i6 = i19;
                        zze(zzakzVar.zzc, iArr, i26, i27, i28, paint, canvas2);
                        zze(zzakzVar.zzd, iArr, i26, i27, i28 + 1, paint, canvas2);
                    } else {
                        zzaleVar = zzaleVar3;
                        canvas2 = canvas3;
                        i4 = i16;
                        i5 = i18;
                        i6 = i19;
                    }
                    i16 = i4;
                    i19 = i6;
                    i24 = i25 + 1;
                    i18 = i5;
                    canvas3 = canvas2;
                    sparseArray5 = sparseArray7;
                    zzaleVar3 = zzaleVar;
                }
                zzale zzaleVar4 = zzaleVar3;
                Canvas canvas4 = canvas3;
                int i29 = i16;
                int i30 = i18;
                int i31 = i19;
                float f = i17;
                float f2 = i29;
                if (zzalcVar3.zzb) {
                    int i32 = zzalcVar3.zze;
                    if (i32 == 3) {
                        i3 = zzakxVar.zzd[zzalcVar3.zzg];
                        c3 = 2;
                    } else {
                        c3 = 2;
                        i3 = i32 == 2 ? zzakxVar.zzc[zzalcVar3.zzh] : zzakxVar.zzb[zzalcVar3.zzi];
                    }
                    Paint paint2 = this.zze;
                    paint2.setColor(i3);
                    float f3 = i31;
                    c2 = c3;
                    c = 3;
                    canvas = canvas4;
                    canvas.drawRect(f2, f, f3, i21, paint2);
                } else {
                    canvas = canvas4;
                    c = 3;
                    c2 = 2;
                }
                zzcs zzcsVar = new zzcs();
                zzcsVar.zzc(Bitmap.createBitmap(this.zzj, i29, i17, i30, i20));
                float f4 = zzakyVar.zza;
                zzcsVar.zzh(f2 / f4);
                zzcsVar.zzi(0);
                float f5 = zzakyVar.zzb;
                zzcsVar.zze(f / f5, 0);
                zzcsVar.zzf(0);
                zzcsVar.zzk(i30 / f4);
                zzcsVar.zzd(i20 / f5);
                arrayList.add(zzcsVar.zzq());
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                i15 = i23 + 1;
                z = z2;
                zzaleVar3 = zzaleVar4;
                sparseArray4 = sparseArray6;
            }
            zzaklVar = new zzakl(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzdnVar.zza(zzaklVar);
    }
}
