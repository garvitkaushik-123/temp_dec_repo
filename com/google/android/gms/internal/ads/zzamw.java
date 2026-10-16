package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.primitives.SignedBytes;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzamw implements zzaom {
    private final List zza;

    public zzamw() {
        this(0);
    }

    public zzamw(int i, List list) {
        this.zza = list;
    }

    private final zzaod zzc(zzaol zzaolVar) {
        return new zzaod(zze(zzaolVar), "video/mp2t");
    }

    private final zzaor zzd(zzaol zzaolVar) {
        return new zzaor(zze(zzaolVar), "video/mp2t");
    }

    private final List zze(zzaol zzaolVar) {
        String str;
        int i;
        List list;
        zzen zzenVar = new zzen(zzaolVar.zze);
        List list2 = this.zza;
        while (zzenVar.zza() > 0) {
            int zzm = zzenVar.zzm();
            int zzc = zzenVar.zzc() + zzenVar.zzm();
            if (zzm == 134) {
                list2 = new ArrayList();
                int zzm2 = zzenVar.zzm() & 31;
                for (int i2 = 0; i2 < zzm2; i2++) {
                    String zzB = zzenVar.zzB(3, StandardCharsets.UTF_8);
                    int zzm3 = zzenVar.zzm();
                    boolean z = (zzm3 & 128) != 0;
                    if (z) {
                        i = zzm3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte zzm4 = (byte) zzenVar.zzm();
                    zzenVar.zzM(1);
                    if (z) {
                        int i3 = zzm4 & SignedBytes.MAX_POWER_OF_TWO;
                        int i4 = zzdk.zza;
                        list = Collections.singletonList(i3 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    zzx zzxVar = new zzx();
                    zzxVar.zzah(str);
                    zzxVar.zzW(zzB);
                    zzxVar.zzB(i);
                    zzxVar.zzT(list);
                    list2.add(zzxVar.zzan());
                }
            }
            zzenVar.zzL(zzc);
        }
        return list2;
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final SparseArray zza() {
        return new SparseArray();
    }

    public zzamw(int i) {
        this.zza = zzfyq.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzaom
    public final zzaoo zzb(int i, zzaol zzaolVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzant(new zzanl(zzaolVar.zzb, zzaolVar.zza(), "video/mp2t"));
            }
            if (i == 21) {
                return new zzant(new zzanj("video/mp2t"));
            }
            if (i == 27) {
                return new zzant(new zzang(zzc(zzaolVar), false, false, "video/mp2t"));
            }
            if (i == 36) {
                return new zzant(new zzani(zzc(zzaolVar), "video/mp2t"));
            }
            if (i == 45) {
                return new zzant(new zzanm("video/mp2t"));
            }
            if (i == 89) {
                return new zzant(new zzamy(zzaolVar.zzd, "video/mp2t"));
            }
            if (i == 172) {
                return new zzant(new zzamt(zzaolVar.zzb, zzaolVar.zza(), "video/mp2t"));
            }
            if (i == 257) {
                return new zzaob(new zzans("application/vnd.dvb.ait", "video/mp2t"));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i != 138) {
                        if (i == 139) {
                            return new zzant(new zzamx(zzaolVar.zzb, zzaolVar.zza(), 5408, "video/mp2t"));
                        }
                        switch (i) {
                            case 15:
                                return new zzant(new zzamv(false, zzaolVar.zzb, zzaolVar.zza(), "video/mp2t"));
                            case 16:
                                return new zzant(new zzane(zzd(zzaolVar), "video/mp2t"));
                            case 17:
                                return new zzant(new zzank(zzaolVar.zzb, zzaolVar.zza(), "video/mp2t"));
                            default:
                                switch (i) {
                                    case 134:
                                        return new zzaob(new zzans("application/x-scte35", "video/mp2t"));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                        }
                    }
                    return new zzant(new zzamx(zzaolVar.zzb, zzaolVar.zza(), 4096, "video/mp2t"));
                }
                return new zzant(new zzamr(zzaolVar.zzb, zzaolVar.zza(), "video/mp2t"));
            }
        }
        return new zzant(new zzanb(zzd(zzaolVar), "video/mp2t"));
    }
}
