package com.google.android.gms.internal.ads;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzacu {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 174, 208, 243, 278, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b = bArr[4];
            return zzf((b & 192) >> 6, b & 63);
        }
        int i = bArr[2] & 7;
        int i2 = ((bArr[3] & 255) | (i << 8)) + 1;
        return i2 + i2;
    }

    public static zzz zzc(zzen zzenVar, String str, String str2, zzs zzsVar) {
        zzem zzemVar = new zzem();
        zzemVar.zzj(zzenVar);
        int i = zzc[zzemVar.zzd(2)];
        zzemVar.zzn(8);
        int i2 = zze[zzemVar.zzd(3)];
        if (zzemVar.zzd(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzemVar.zzd(5)] * 1000;
        zzemVar.zzf();
        zzenVar.zzL(zzemVar.zzb());
        zzx zzxVar = new zzx();
        zzxVar.zzS(str);
        zzxVar.zzah("audio/ac3");
        zzxVar.zzD(i2);
        zzxVar.zzai(i);
        zzxVar.zzL(zzsVar);
        zzxVar.zzW(str2);
        zzxVar.zzC(i3);
        zzxVar.zzac(i3);
        return zzxVar.zzan();
    }

    public static zzz zzd(zzen zzenVar, String str, String str2, zzs zzsVar) {
        String str3;
        zzem zzemVar = new zzem();
        zzemVar.zzj(zzenVar);
        int zzd2 = zzemVar.zzd(13) * 1000;
        zzemVar.zzn(3);
        int i = zzc[zzemVar.zzd(2)];
        zzemVar.zzn(10);
        int i2 = zze[zzemVar.zzd(3)];
        if (zzemVar.zzd(1) != 0) {
            i2++;
        }
        zzemVar.zzn(3);
        int zzd3 = zzemVar.zzd(4);
        zzemVar.zzn(1);
        if (zzd3 > 0) {
            zzemVar.zzn(6);
            if (zzemVar.zzd(1) != 0) {
                i2 += 2;
            }
            zzemVar.zzn(1);
        }
        if (zzemVar.zza() > 7) {
            zzemVar.zzn(7);
            if (zzemVar.zzd(1) != 0) {
                str3 = "audio/eac3-joc";
                zzemVar.zzf();
                zzenVar.zzL(zzemVar.zzb());
                zzx zzxVar = new zzx();
                zzxVar.zzS(str);
                zzxVar.zzah(str3);
                zzxVar.zzD(i2);
                zzxVar.zzai(i);
                zzxVar.zzL(zzsVar);
                zzxVar.zzW(str2);
                zzxVar.zzac(zzd2);
                return zzxVar.zzan();
            }
        }
        str3 = "audio/eac3";
        zzemVar.zzf();
        zzenVar.zzL(zzemVar.zzb());
        zzx zzxVar2 = new zzx();
        zzxVar2.zzS(str);
        zzxVar2.zzah(str3);
        zzxVar2.zzD(i2);
        zzxVar2.zzai(i);
        zzxVar2.zzL(zzsVar);
        zzxVar2.zzW(str2);
        zzxVar2.zzac(zzd2);
        return zzxVar2.zzan();
    }

    public static zzacs zze(zzem zzemVar) {
        int zzf2;
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int zzc2 = zzemVar.zzc();
        zzemVar.zzn(40);
        int zzd2 = zzemVar.zzd(5);
        zzemVar.zzl(zzc2);
        int i9 = -1;
        if (zzd2 > 10) {
            zzemVar.zzn(16);
            int zzd3 = zzemVar.zzd(2);
            if (zzd3 == 0) {
                i9 = 0;
            } else if (zzd3 == 1) {
                i9 = 1;
            } else if (zzd3 == 2) {
                i9 = 2;
            }
            zzemVar.zzn(3);
            int zzd4 = zzemVar.zzd(11) + 1;
            int zzd5 = zzemVar.zzd(2);
            if (zzd5 == 3) {
                i = zzd[zzemVar.zzd(2)];
                i6 = 6;
                i5 = 3;
            } else {
                int zzd6 = zzemVar.zzd(2);
                int i10 = zzb[zzd6];
                i5 = zzd6;
                i = zzc[zzd5];
                i6 = i10;
            }
            zzf2 = zzd4 + zzd4;
            int i11 = (zzf2 * i) / (i6 * 32);
            int zzd7 = zzemVar.zzd(3);
            boolean zzp = zzemVar.zzp();
            i2 = zze[zzd7] + (zzp ? 1 : 0);
            zzemVar.zzn(10);
            if (zzemVar.zzp()) {
                zzemVar.zzn(8);
            }
            if (zzd7 == 0) {
                zzemVar.zzn(5);
                if (zzemVar.zzp()) {
                    zzemVar.zzn(8);
                }
                i7 = 0;
                zzd7 = 0;
            } else {
                i7 = zzd7;
            }
            if (i9 == 1) {
                if (zzemVar.zzp()) {
                    zzemVar.zzn(16);
                }
                i8 = 1;
            } else {
                i8 = i9;
            }
            if (zzemVar.zzp()) {
                if (i7 > 2) {
                    zzemVar.zzn(2);
                }
                if ((i7 & 1) != 0 && i7 > 2) {
                    zzemVar.zzn(6);
                }
                if ((i7 & 4) != 0) {
                    zzemVar.zzn(6);
                }
                if (zzp && zzemVar.zzp()) {
                    zzemVar.zzn(5);
                }
                if (i8 == 0) {
                    if (zzemVar.zzp()) {
                        zzemVar.zzn(6);
                    }
                    if (i7 == 0 && zzemVar.zzp()) {
                        zzemVar.zzn(6);
                    }
                    if (zzemVar.zzp()) {
                        zzemVar.zzn(6);
                    }
                    int zzd8 = zzemVar.zzd(2);
                    if (zzd8 == 1) {
                        zzemVar.zzn(5);
                    } else if (zzd8 == 2) {
                        zzemVar.zzn(12);
                    } else if (zzd8 == 3) {
                        int zzd9 = zzemVar.zzd(5);
                        if (zzemVar.zzp()) {
                            zzemVar.zzn(5);
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(4);
                            }
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(4);
                            }
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(4);
                            }
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(4);
                            }
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(4);
                            }
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(4);
                            }
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(4);
                            }
                            if (zzemVar.zzp()) {
                                if (zzemVar.zzp()) {
                                    zzemVar.zzn(4);
                                }
                                if (zzemVar.zzp()) {
                                    zzemVar.zzn(4);
                                }
                            }
                        }
                        if (zzemVar.zzp()) {
                            zzemVar.zzn(5);
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(7);
                                if (zzemVar.zzp()) {
                                    zzemVar.zzn(8);
                                }
                            }
                        }
                        zzemVar.zzn((zzd9 + 2) * 8);
                        zzemVar.zzf();
                    }
                    if (i7 < 2) {
                        if (zzemVar.zzp()) {
                            zzemVar.zzn(14);
                        }
                        if (zzd7 == 0 && zzemVar.zzp()) {
                            zzemVar.zzn(14);
                        }
                    }
                    if (zzemVar.zzp()) {
                        if (i5 == 0) {
                            zzemVar.zzn(5);
                            i8 = 0;
                            i5 = 0;
                        } else {
                            for (int i12 = 0; i12 < i6; i12++) {
                                if (zzemVar.zzp()) {
                                    zzemVar.zzn(5);
                                }
                            }
                        }
                    }
                    i8 = 0;
                }
            }
            if (zzemVar.zzp()) {
                zzemVar.zzn(5);
                if (i7 == 2) {
                    zzemVar.zzn(4);
                    i7 = 2;
                }
                if (i7 >= 6) {
                    zzemVar.zzn(2);
                }
                if (zzemVar.zzp()) {
                    zzemVar.zzn(8);
                }
                if (i7 == 0 && zzemVar.zzp()) {
                    zzemVar.zzn(8);
                }
                if (zzd5 < 3) {
                    zzemVar.zzm();
                }
            }
            if (i8 == 0 && i5 != 3) {
                zzemVar.zzm();
            }
            if (i8 == 2 && (i5 == 3 || zzemVar.zzp())) {
                zzemVar.zzn(6);
            }
            i3 = i6 * 256;
            str = (zzemVar.zzp() && zzemVar.zzd(6) == 1 && zzemVar.zzd(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i4 = i11;
        } else {
            zzemVar.zzn(32);
            int zzd10 = zzemVar.zzd(2);
            String str2 = zzd10 == 3 ? null : "audio/ac3";
            int zzd11 = zzemVar.zzd(6);
            int i13 = zzf[zzd11 / 2] * 1000;
            zzf2 = zzf(zzd10, zzd11);
            zzemVar.zzn(8);
            int zzd12 = zzemVar.zzd(3);
            if ((zzd12 & 1) != 0 && zzd12 != 1) {
                zzemVar.zzn(2);
            }
            if ((zzd12 & 4) != 0) {
                zzemVar.zzn(2);
            }
            if (zzd12 == 2) {
                zzemVar.zzn(2);
            }
            i = zzd10 < 3 ? zzc[zzd10] : -1;
            i2 = zze[zzd12] + (zzemVar.zzp() ? 1 : 0);
            i3 = 1536;
            str = str2;
            i4 = i13;
        }
        return new zzacs(str, i9, i2, i, zzf2, i3, i4, null);
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
