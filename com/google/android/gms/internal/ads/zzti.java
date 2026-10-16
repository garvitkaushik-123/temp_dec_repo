package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import com.ironsource.C3040d4;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.media3.common.MimeTypes;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzti {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    private final boolean zzi;
    private int zzj;
    private int zzk;
    private float zzl;

    public static zzti zzd(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        String str4;
        String str5;
        MediaCodecInfo.CodecCapabilities codecCapabilities2;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        String str6;
        boolean z10 = codecCapabilities != null && codecCapabilities.isFeatureSupported("adaptive-playback");
        boolean z11 = codecCapabilities != null && codecCapabilities.isFeatureSupported("tunneled-playback");
        boolean z12 = z5 || (codecCapabilities != null && codecCapabilities.isFeatureSupported("secure-playback"));
        if (Build.VERSION.SDK_INT < 35 || codecCapabilities == null || !codecCapabilities.isFeatureSupported("detached-surface") || Build.MANUFACTURER.equals("Xiaomi") || Build.MANUFACTURER.equals("OPPO") || Build.MANUFACTURER.equals("realme")) {
            str4 = str;
            str5 = str3;
            codecCapabilities2 = codecCapabilities;
            z6 = z;
            z7 = z2;
            z8 = z3;
            z9 = false;
            str6 = str2;
        } else {
            str6 = str2;
            str5 = str3;
            codecCapabilities2 = codecCapabilities;
            z6 = z;
            z7 = z2;
            z8 = z3;
            z9 = true;
            str4 = str;
        }
        return new zzti(str4, str6, str5, codecCapabilities2, z6, z7, z8, z10, z11, z12, z9);
    }

    private static Point zzj(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        String str = zzex.zza;
        return new Point((((i + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i2 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzk(String str) {
        zzea.zzb("MediaCodecInfo", "NoSupport [" + str + "] [" + this.zza + ", " + this.zzb + "] [" + zzex.zza + C3040d4.i.e);
    }

    private static boolean zzl(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point zzj = zzj(videoCapabilities, i, i2);
        int i3 = zzj.x;
        int i4 = zzj.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        double floor = Math.floor(d);
        if (!videoCapabilities.areSizeAndRateSupported(i3, i4, floor)) {
            return false;
        }
        Range<Double> achievableFrameRatesFor = videoCapabilities.getAchievableFrameRatesFor(i3, i4);
        return achievableFrameRatesFor == null || floor <= achievableFrameRatesFor.getUpper().doubleValue();
    }

    private final boolean zzm(zzz zzzVar, boolean z) {
        int i;
        int i2 = zzuc.zza;
        Pair zza = zzdk.zza(zzzVar);
        String str = zzzVar.zzo;
        char c = 65535;
        if (str != null && str.equals(MimeTypes.VIDEO_MV_HEVC)) {
            String zze = zzay.zze(this.zzc);
            if (!zze.equals(MimeTypes.VIDEO_MV_HEVC)) {
                if (zze.equals("video/hevc")) {
                    String zzh = zzfv.zzh(zzzVar.zzr);
                    if (zzh == null) {
                        zza = null;
                    } else {
                        String trim = zzh.trim();
                        String str2 = zzex.zza;
                        zza = zzdk.zzb(zzh, trim.split("\\.", -1), zzzVar.zzE);
                    }
                }
            }
            return true;
        }
        if (zza != null) {
            int intValue = ((Integer) zza.first).intValue();
            int intValue2 = ((Integer) zza.second).intValue();
            if ("video/dolby-vision".equals(str)) {
                String str3 = this.zzb;
                int hashCode = str3.hashCode();
                if (hashCode != -1662735862) {
                    if (hashCode != -1662541442) {
                        if (hashCode == 1331836730 && str3.equals("video/avc")) {
                            c = 0;
                        }
                    } else if (str3.equals("video/hevc")) {
                        c = 1;
                    }
                } else if (str3.equals("video/av01")) {
                    c = 2;
                }
                if (c != 0) {
                    intValue = (c == 1 || c == 2) ? 2 : 8;
                }
                intValue2 = 0;
            }
            if (!this.zzi) {
                if (intValue == 42) {
                    intValue = 42;
                }
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzi()) {
                i = (codecProfileLevel.profile != intValue || (codecProfileLevel.level < intValue2 && z) || ("video/hevc".equals(this.zzb) && intValue == 2 && ("sailfish".equals(Build.DEVICE) || "marlin".equals(Build.DEVICE)))) ? i + 1 : 0;
            }
            zzk("codec.profileLevel, " + zzzVar.zzk + ", " + this.zzc);
            return false;
        }
        return true;
    }

    private final boolean zzn(zzz zzzVar) {
        return (Objects.equals(zzzVar.zzo, "audio/flac") && zzzVar.zzI == 22 && Build.VERSION.SDK_INT < 34 && this.zza.equals("c2.android.flac.decoder")) ? false : true;
    }

    private final boolean zzo(zzz zzzVar) {
        String str = this.zzb;
        return str.equals(zzzVar.zzo) || str.equals(zzuc.zzb(zzzVar));
    }

    public final String toString() {
        return this.zza;
    }

    public final float zza(int i, int i2) {
        if (!this.zzi) {
            return -3.4028235E38f;
        }
        float f = this.zzl;
        if (f != -3.4028235E38f && this.zzj == i && this.zzk == i2) {
            return f;
        }
        float f2 = 1024.0f;
        if (!zzh(i, i2, 1024.0d)) {
            float f3 = 0.0f;
            while (true) {
                float f4 = f2 - f3;
                if (Math.abs(f4) <= 5.0f) {
                    break;
                }
                float f5 = (f4 / 2.0f) + f3;
                boolean zzh = zzh(i, i2, f5);
                if (true == zzh) {
                    f3 = f5;
                }
                if (true != zzh) {
                    f2 = f5;
                }
            }
            f2 = f3;
        }
        this.zzl = f2;
        this.zzj = i;
        this.zzk = i2;
        return f2;
    }

    public final Point zzb(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzj(videoCapabilities, i, i2);
    }

    public final zzie zzc(zzz zzzVar, zzz zzzVar2) {
        zzz zzzVar3;
        zzz zzzVar4;
        int i;
        int i2 = true != Objects.equals(zzzVar.zzo, zzzVar2.zzo) ? 8 : 0;
        if (this.zzi) {
            if (zzzVar.zzA != zzzVar2.zzA) {
                i2 |= 1024;
            }
            boolean z = (zzzVar.zzv == zzzVar2.zzv && zzzVar.zzw == zzzVar2.zzw) ? false : true;
            if (!this.zze && z) {
                i2 |= 512;
            }
            zzk zzkVar = zzzVar.zzE;
            if ((!zzk.zzg(zzkVar) || !zzk.zzg(zzzVar2.zzE)) && !Objects.equals(zzkVar, zzzVar2.zzE)) {
                i2 |= 2048;
            }
            String str = this.zza;
            if (Build.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzzVar.zzd(zzzVar2)) {
                i2 |= 2;
            }
            int i3 = zzzVar.zzx;
            if (i3 != -1 && (i = zzzVar.zzy) != -1 && i3 == zzzVar2.zzx && i == zzzVar2.zzy && z) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new zzie(str, zzzVar, zzzVar2, true != zzzVar.zzd(zzzVar2) ? 2 : 3, 0);
            }
            zzzVar3 = zzzVar;
            zzzVar4 = zzzVar2;
        } else {
            zzzVar3 = zzzVar;
            zzzVar4 = zzzVar2;
            if (zzzVar3.zzG != zzzVar4.zzG) {
                i2 |= 4096;
            }
            if (zzzVar3.zzH != zzzVar4.zzH) {
                i2 |= 8192;
            }
            if (zzzVar3.zzI != zzzVar4.zzI) {
                i2 |= 16384;
            }
            if (i2 == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                int i4 = zzuc.zza;
                Pair zza = zzdk.zza(zzzVar3);
                Pair zza2 = zzdk.zza(zzzVar4);
                if (zza != null && zza2 != null) {
                    int intValue = ((Integer) zza.first).intValue();
                    int intValue2 = ((Integer) zza2.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new zzie(this.zza, zzzVar3, zzzVar4, 3, 0);
                    }
                }
            }
            if (!zzzVar3.zzd(zzzVar4)) {
                i2 |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new zzie(this.zza, zzzVar3, zzzVar4, 1, 0);
            }
        }
        return new zzie(this.zza, zzzVar3, zzzVar4, 0, i2);
    }

    public final boolean zze(zzz zzzVar) {
        return zzo(zzzVar) && zzm(zzzVar, false) && zzn(zzzVar);
    }

    public final boolean zzf(zzz zzzVar) throws zztw {
        int i;
        if (!zzo(zzzVar) || !zzm(zzzVar, true) || !zzn(zzzVar)) {
            return false;
        }
        if (this.zzi) {
            int i2 = zzzVar.zzv;
            if (i2 <= 0 || (i = zzzVar.zzw) <= 0) {
                return true;
            }
            return zzh(i2, i, zzzVar.zzz);
        }
        int i3 = zzzVar.zzH;
        if (i3 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null) {
                zzk("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                zzk("sampleRate.aCaps");
                return false;
            }
            if (!audioCapabilities.isSampleRateSupported(i3)) {
                zzk("sampleRate.support, " + i3);
                return false;
            }
        }
        int i4 = zzzVar.zzG;
        if (i4 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
            if (codecCapabilities2 == null) {
                zzk("channelCount.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
            if (audioCapabilities2 == null) {
                zzk("channelCount.aCaps");
                return false;
            }
            String str = this.zza;
            String str2 = this.zzb;
            int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
            if (maxInputChannelCount <= 1 && maxInputChannelCount <= 0 && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2)) {
                int i5 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                zzea.zzf("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i5 + C3040d4.i.e);
                maxInputChannelCount = i5;
            }
            if (maxInputChannelCount < i4) {
                zzk("channelCount.support, " + i4);
                return false;
            }
        }
        return true;
    }

    public final boolean zzg(zzz zzzVar) {
        if (this.zzi) {
            return this.zze;
        }
        int i = zzuc.zza;
        Pair zza = zzdk.zza(zzzVar);
        return zza != null && ((Integer) zza.first).intValue() == 42;
    }

    public final boolean zzh(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzk("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzk("sizeAndRate.vCaps");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            int zza = zztk.zza(videoCapabilities, i, i2, d);
            if (zza != 2) {
                if (zza == 1) {
                    zzk("sizeAndRate.cover, " + i + VastAttributes.HORIZONTAL_POSITION + i2 + "@" + d);
                    return false;
                }
            }
            return true;
        }
        if (!zzl(videoCapabilities, i, i2, d)) {
            if (i < i2) {
                String str = this.zza;
                if ((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(Build.DEVICE)) && zzl(videoCapabilities, i2, i, d)) {
                    zzea.zzb("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i + VastAttributes.HORIZONTAL_POSITION + i2 + "@" + d) + "] [" + str + ", " + this.zzb + "] [" + zzex.zza + C3040d4.i.e);
                }
            }
            zzk("sizeAndRate.support, " + i + VastAttributes.HORIZONTAL_POSITION + i2 + "@" + d);
            return false;
        }
        return true;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzi() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecCapabilities.profileLevels;
    }

    zzti(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z;
        this.zze = z4;
        this.zzf = z6;
        this.zzh = z7;
        this.zzi = zzay.zzj(str2);
        this.zzl = -3.4028235E38f;
        this.zzj = -1;
        this.zzk = -1;
    }
}
