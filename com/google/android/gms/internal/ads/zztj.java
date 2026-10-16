package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zztj {
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Boolean bool;
        Boolean bool2;
        List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
            return 0;
        }
        int zzc = zzc(supportedPerformancePoints, new MediaCodecInfo.VideoCapabilities.PerformancePoint(i, i2, (int) d));
        boolean z = true;
        if (zzc == 1) {
            bool = zztk.zza;
            if (bool == null) {
                if (Build.VERSION.SDK_INT < 35) {
                    int zzb = zzb(false);
                    int zzb2 = zzb(true);
                    if (zzb != 0) {
                        if (zzb2 == 0) {
                        }
                    }
                    zztk.zza = Boolean.valueOf(z);
                    bool2 = zztk.zza;
                    if (!bool2.booleanValue()) {
                        return 0;
                    }
                }
                z = false;
                zztk.zza = Boolean.valueOf(z);
                bool2 = zztk.zza;
                if (!bool2.booleanValue()) {
                }
            }
        }
        return zzc;
    }

    private static int zzb(boolean z) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints;
        try {
            zzx zzxVar = new zzx();
            zzxVar.zzah("video/avc");
            zzz zzan = zzxVar.zzan();
            if (zzan.zzo != null) {
                List zze = zzuc.zze(zztr.zza, zzan, z, false);
                for (int i = 0; i < zze.size(); i++) {
                    if (((zzti) zze.get(i)).zzd != null && (videoCapabilities = ((zzti) zze.get(i)).zzd.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                        return zzc(supportedPerformancePoints, new MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60));
                    }
                }
            }
        } catch (zztw unused) {
        }
        return 0;
    }

    private static int zzc(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i = 0; i < list.size(); i++) {
            if (((MediaCodecInfo.VideoCapabilities.PerformancePoint) list.get(i)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
