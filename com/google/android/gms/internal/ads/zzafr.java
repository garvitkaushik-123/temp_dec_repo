package com.google.android.gms.internal.ads;

import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzafr implements zzafj {
    public final zzfyq zza;
    private final int zzb;

    private zzafr(int i, zzfyq zzfyqVar) {
        this.zzb = i;
        this.zza = zzfyqVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzafr zzc(int i, zzen zzenVar) {
        zzafj zzafsVar;
        String str;
        zzfyn zzfynVar = new zzfyn();
        int zzd = zzenVar.zzd();
        int i2 = -2;
        while (zzenVar.zza() > 8) {
            int zzi = zzenVar.zzi();
            int zzc = zzenVar.zzc() + zzenVar.zzi();
            zzenVar.zzK(zzc);
            if (zzi != 1414744396) {
                zzafs zzafsVar2 = null;
                switch (zzi) {
                    case 1718776947:
                        if (i2 == 2) {
                            zzenVar.zzM(4);
                            int zzi2 = zzenVar.zzi();
                            int zzi3 = zzenVar.zzi();
                            zzenVar.zzM(4);
                            int zzi4 = zzenVar.zzi();
                            switch (zzi4) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str = "video/avc";
                                    break;
                                case 842289229:
                                    str = "video/mp42";
                                    break;
                                case 859066445:
                                    str = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str = "video/mjpeg";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            if (str == null) {
                                zzea.zzf("StreamFormatChunk", "Ignoring track with unsupported compression " + zzi4);
                            } else {
                                zzx zzxVar = new zzx();
                                zzxVar.zzam(zzi2);
                                zzxVar.zzQ(zzi3);
                                zzxVar.zzah(str);
                                zzafsVar2 = new zzafs(zzxVar.zzan());
                            }
                        } else if (i2 == 1) {
                            int zzk = zzenVar.zzk();
                            String str2 = zzk != 1 ? zzk != 85 ? zzk != 255 ? zzk != 8192 ? zzk != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : "audio/mp4a-latm" : "audio/mpeg" : "audio/raw";
                            if (str2 != null) {
                                int zzk2 = zzenVar.zzk();
                                int zzi5 = zzenVar.zzi();
                                zzenVar.zzM(6);
                                int zzn = zzex.zzn(zzenVar.zzk(), ByteOrder.LITTLE_ENDIAN);
                                int zzk3 = zzenVar.zza() > 0 ? zzenVar.zzk() : 0;
                                zzx zzxVar2 = new zzx();
                                zzxVar2.zzah(str2);
                                zzxVar2.zzD(zzk2);
                                zzxVar2.zzai(zzi5);
                                if (str2.equals("audio/raw") && zzn != 0) {
                                    zzxVar2.zzab(zzn);
                                }
                                if (str2.equals("audio/mp4a-latm") && zzk3 > 0) {
                                    byte[] bArr = new byte[zzk3];
                                    zzenVar.zzH(bArr, 0, zzk3);
                                    zzxVar2.zzT(zzfyq.zzo(bArr));
                                }
                                zzafsVar = new zzafs(zzxVar2.zzan());
                                break;
                            } else {
                                zzea.zzf("StreamFormatChunk", "Ignoring track with unsupported format tag " + zzk);
                            }
                        } else {
                            zzea.zzf("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzex.zzD(i2)));
                        }
                        zzafsVar = zzafsVar2;
                        break;
                    case 1751742049:
                        zzafsVar = zzafo.zzb(zzenVar);
                        break;
                    case 1752331379:
                        zzafsVar = zzafp.zzd(zzenVar);
                        break;
                    case 1852994675:
                        zzafsVar = zzaft.zzb(zzenVar);
                        break;
                    default:
                        zzafsVar = zzafsVar2;
                        break;
                }
            } else {
                zzafsVar = zzc(zzenVar.zzi(), zzenVar);
            }
            if (zzafsVar != null) {
                if (zzafsVar.zza() == 1752331379) {
                    i2 = ((zzafp) zzafsVar).zzb();
                }
                zzfynVar.zzf(zzafsVar);
            }
            zzenVar.zzL(zzc);
            zzenVar.zzK(zzd);
        }
        return new zzafr(i, zzfynVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final int zza() {
        return this.zzb;
    }

    public final zzafj zzb(Class cls) {
        zzfyq zzfyqVar = this.zza;
        int size = zzfyqVar.size();
        int i = 0;
        while (i < size) {
            zzafj zzafjVar = (zzafj) zzfyqVar.get(i);
            i++;
            if (zzafjVar.getClass() == cls) {
                return zzafjVar;
            }
        }
        return null;
    }
}
