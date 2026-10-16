package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import com.google.firebase.sessions.settings.RemoteSettings;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzajf {
    public static zzau zza(zzen zzenVar) {
        String str;
        zzau zzagwVar;
        int zzc = zzenVar.zzc() + zzenVar.zzg();
        int zzg = zzenVar.zzg();
        int i = (zzg >> 24) & 255;
        zzau zzauVar = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = zzg & ViewCompat.MEASURED_SIZE_MASK;
                if (i2 == 6516084) {
                    int zzg2 = zzenVar.zzg();
                    if (zzenVar.zzg() == 1684108385) {
                        zzenVar.zzM(8);
                        String zzA = zzenVar.zzA(zzg2 - 16);
                        zzauVar = new zzaha("und", zzA, zzA);
                    } else {
                        zzea.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzff.zze(zzg)));
                    }
                } else {
                    if (i2 != 7233901 && i2 != 7631467) {
                        if (i2 != 6516589 && i2 != 7828084) {
                            if (i2 == 6578553) {
                                zzauVar = zze(zzg, "TDRC", zzenVar);
                            } else if (i2 == 4280916) {
                                zzauVar = zze(zzg, "TPE1", zzenVar);
                            } else if (i2 == 7630703) {
                                zzauVar = zze(zzg, "TSSE", zzenVar);
                            } else if (i2 == 6384738) {
                                zzauVar = zze(zzg, "TALB", zzenVar);
                            } else if (i2 == 7108978) {
                                zzauVar = zze(zzg, "USLT", zzenVar);
                            } else if (i2 == 6776174) {
                                zzauVar = zze(zzg, "TCON", zzenVar);
                            } else {
                                if (i2 == 6779504) {
                                    zzauVar = zze(zzg, "TIT1", zzenVar);
                                }
                                zzea.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzff.zze(zzg));
                            }
                        }
                        zzauVar = zze(zzg, "TCOM", zzenVar);
                    }
                    zzauVar = zze(zzg, "TIT2", zzenVar);
                }
            } else if (zzg == 1735291493) {
                String zza = zzahg.zza(zzb(zzenVar) - 1);
                if (zza != null) {
                    zzagwVar = new zzahk("TCON", null, zzfyq.zzo(zza));
                    zzauVar = zzagwVar;
                } else {
                    zzea.zzf("MetadataUtil", "Failed to parse standard genre code");
                }
            } else if (zzg == 1684632427) {
                zzauVar = zzd(1684632427, "TPOS", zzenVar);
            } else if (zzg == 1953655662) {
                zzauVar = zzd(1953655662, "TRCK", zzenVar);
            } else if (zzg == 1953329263) {
                zzauVar = zzc(1953329263, "TBPM", zzenVar, true, false);
            } else if (zzg == 1668311404) {
                zzauVar = zzc(1668311404, "TCMP", zzenVar, true, true);
            } else if (zzg == 1668249202) {
                int zzg3 = zzenVar.zzg();
                if (zzenVar.zzg() == 1684108385) {
                    int zzg4 = zzenVar.zzg();
                    int i3 = zzaix.zza;
                    int i4 = zzg4 & ViewCompat.MEASURED_SIZE_MASK;
                    if (i4 == 13) {
                        str = "image/jpeg";
                    } else if (i4 == 14) {
                        str = "image/png";
                        i4 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        zzea.zzf("MetadataUtil", "Unrecognized cover art flags: " + i4);
                    } else {
                        zzenVar.zzM(4);
                        int i5 = zzg3 - 16;
                        byte[] bArr = new byte[i5];
                        zzenVar.zzH(bArr, 0, i5);
                        zzagwVar = new zzagw(str, null, 3, bArr);
                        zzauVar = zzagwVar;
                    }
                } else {
                    zzea.zzf("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (zzg == 1631670868) {
                zzauVar = zze(1631670868, "TPE2", zzenVar);
            } else if (zzg == 1936682605) {
                zzauVar = zze(1936682605, "TSOT", zzenVar);
            } else if (zzg == 1936679276) {
                zzauVar = zze(1936679276, "TSOA", zzenVar);
            } else if (zzg == 1936679282) {
                zzauVar = zze(1936679282, "TSOP", zzenVar);
            } else if (zzg == 1936679265) {
                zzauVar = zze(1936679265, "TSO2", zzenVar);
            } else if (zzg == 1936679791) {
                zzauVar = zze(1936679791, "TSOC", zzenVar);
            } else if (zzg == 1920233063) {
                zzauVar = zzc(1920233063, "ITUNESADVISORY", zzenVar, false, false);
            } else if (zzg == 1885823344) {
                zzauVar = zzc(1885823344, "ITUNESGAPLESS", zzenVar, false, true);
            } else if (zzg == 1936683886) {
                zzauVar = zze(1936683886, "TVSHOWSORT", zzenVar);
            } else if (zzg == 1953919848) {
                zzauVar = zze(1953919848, "TVSHOW", zzenVar);
            } else {
                if (zzg == 757935405) {
                    int i6 = -1;
                    int i7 = -1;
                    String str2 = null;
                    String str3 = null;
                    while (zzenVar.zzc() < zzc) {
                        int zzc2 = zzenVar.zzc();
                        int zzg5 = zzenVar.zzg();
                        int zzg6 = zzenVar.zzg();
                        zzenVar.zzM(4);
                        if (zzg6 == 1835360622) {
                            str2 = zzenVar.zzA(zzg5 - 12);
                        } else {
                            int i8 = zzg5 - 12;
                            if (zzg6 == 1851878757) {
                                str3 = zzenVar.zzA(i8);
                            } else {
                                if (zzg6 == 1684108385) {
                                    i7 = zzg5;
                                }
                                if (zzg6 == 1684108385) {
                                    i6 = zzc2;
                                }
                                zzenVar.zzM(i8);
                            }
                        }
                    }
                    if (str2 != null && str3 != null && i6 != -1) {
                        zzenVar.zzL(i6);
                        zzenVar.zzM(16);
                        zzauVar = new zzahh(str2, str3, zzenVar.zzA(i7 - 16));
                    }
                }
                zzea.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzff.zze(zzg));
            }
            return zzauVar;
        } finally {
            zzenVar.zzL(zzc);
        }
    }

    private static int zzb(zzen zzenVar) {
        int zzg = zzenVar.zzg();
        if (zzenVar.zzg() == 1684108385) {
            zzenVar.zzM(8);
            int i = zzg - 16;
            if (i == 1) {
                return zzenVar.zzm();
            }
            if (i == 2) {
                return zzenVar.zzq();
            }
            if (i == 3) {
                return zzenVar.zzo();
            }
            if (i == 4 && (zzenVar.zzf() & 128) == 0) {
                return zzenVar.zzp();
            }
        }
        zzea.zzf("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzahf zzc(int i, String str, zzen zzenVar, boolean z, boolean z2) {
        int zzb = zzb(zzenVar);
        if (z2) {
            zzb = Math.min(1, zzb);
        }
        if (zzb >= 0) {
            return z ? new zzahk(str, null, zzfyq.zzo(Integer.toString(zzb))) : new zzaha("und", str, Integer.toString(zzb));
        }
        zzea.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzff.zze(i)));
        return null;
    }

    private static zzahk zzd(int i, String str, zzen zzenVar) {
        int zzg = zzenVar.zzg();
        if (zzenVar.zzg() == 1684108385 && zzg >= 22) {
            zzenVar.zzM(10);
            int zzq = zzenVar.zzq();
            if (zzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzq);
                String sb2 = sb.toString();
                int zzq2 = zzenVar.zzq();
                if (zzq2 > 0) {
                    sb2 = sb2 + RemoteSettings.FORWARD_SLASH_STRING + zzq2;
                }
                return new zzahk(str, null, zzfyq.zzo(sb2));
            }
        }
        zzea.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzff.zze(i)));
        return null;
    }

    private static zzahk zze(int i, String str, zzen zzenVar) {
        int zzg = zzenVar.zzg();
        if (zzenVar.zzg() == 1684108385) {
            zzenVar.zzM(8);
            return new zzahk(str, null, zzfyq.zzo(zzenVar.zzA(zzg - 16)));
        }
        zzea.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzff.zze(i)));
        return null;
    }
}
