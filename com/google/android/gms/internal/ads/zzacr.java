package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzacr {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzacp zza(byte[] bArr) throws zzaz {
        return zzb(new zzem(bArr, bArr.length), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ae, code lost:
    
        if (r11 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzacp zzb(zzem zzemVar, boolean z) throws zzaz {
        int zzc2 = zzc(zzemVar);
        int zzd = zzd(zzemVar);
        int zzd2 = zzemVar.zzd(4);
        String str = "mp4a.40." + zzc2;
        int i = 22;
        if (zzc2 == 5 || zzc2 == 29) {
            zzd = zzd(zzemVar);
            zzc2 = zzc(zzemVar);
            if (zzc2 == 22) {
                zzd2 = zzemVar.zzd(4);
            }
        }
        if (z) {
            int i2 = 3;
            if (zzc2 != 1 && zzc2 != 2 && zzc2 != 3 && zzc2 != 4 && zzc2 != 6 && zzc2 != 7 && zzc2 != 17) {
                switch (zzc2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw zzaz.zzc("Unsupported audio object type: " + zzc2);
                }
            }
            if (zzemVar.zzp()) {
                zzea.zzf("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (zzemVar.zzp()) {
                zzemVar.zzn(14);
            }
            boolean zzp = zzemVar.zzp();
            if (zzd2 == 0) {
                throw new UnsupportedOperationException();
            }
            if (zzc2 != 6) {
                if (zzc2 == 20) {
                    zzc2 = 20;
                }
                if (zzp) {
                    if (zzc2 == 22) {
                        zzemVar.zzn(16);
                    } else {
                        i = zzc2;
                    }
                    if (i == 17 || i == 19 || i == 20 || i == 23) {
                        zzemVar.zzn(3);
                    }
                    zzemVar.zzn(1);
                }
                switch (zzc2) {
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        int zzd3 = zzemVar.zzd(2);
                        if (zzd3 == 2) {
                            i2 = zzd3;
                        }
                        throw zzaz.zzc("Unsupported epConfig: " + i2);
                }
            }
            zzemVar.zzn(3);
            if (zzp) {
            }
            switch (zzc2) {
            }
        }
        int i3 = zzc[zzd2];
        if (i3 != -1) {
            return new zzacp(zzd, i3, str, null);
        }
        throw zzaz.zza(null, null);
    }

    private static int zzc(zzem zzemVar) {
        int zzd = zzemVar.zzd(5);
        return zzd == 31 ? zzemVar.zzd(6) + 32 : zzd;
    }

    private static int zzd(zzem zzemVar) throws zzaz {
        int zzd = zzemVar.zzd(4);
        if (zzd == 15) {
            if (zzemVar.zza() >= 24) {
                return zzemVar.zzd(24);
            }
            throw zzaz.zza("AAC header insufficient data", null);
        }
        if (zzd < 13) {
            return zzb[zzd];
        }
        throw zzaz.zza("AAC header wrong Sampling Frequency Index", null);
    }
}
