package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import io.bidmachine.media3.common.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzuc {
    public static final /* synthetic */ int zza = 0;
    private static final HashMap zzb = new HashMap();

    public static zzti zza() throws zztw {
        List zzd = zzd("audio/raw", false, false);
        if (zzd.isEmpty()) {
            return null;
        }
        return (zzti) zzd.get(0);
    }

    public static String zzb(zzz zzzVar) {
        Pair zza2;
        String str = zzzVar.zzo;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str) && (zza2 = zzdk.zza(zzzVar)) != null) {
            int intValue = ((Integer) zza2.first).intValue();
            if (intValue == 16 || intValue == 256) {
                return "video/hevc";
            }
            if (intValue == 512) {
                return "video/avc";
            }
            if (intValue == 1024) {
                return "video/av01";
            }
        }
        if (MimeTypes.VIDEO_MV_HEVC.equals(str)) {
            return "video/hevc";
        }
        return null;
    }

    public static List zzc(zztr zztrVar, zzz zzzVar, boolean z, boolean z2) throws zztw {
        String zzb2 = zzb(zzzVar);
        return zzb2 == null ? zzfyq.zzn() : zztrVar.zza(zzb2, z, z2);
    }

    public static synchronized List zzd(String str, boolean z, boolean z2) throws zztw {
        synchronized (zzuc.class) {
            zztv zztvVar = new zztv(str, z, z2);
            HashMap hashMap = zzb;
            List list = (List) hashMap.get(zztvVar);
            if (list != null) {
                return list;
            }
            ArrayList zzg = zzg(zztvVar, new zztz(z, z2, str.equals(MimeTypes.VIDEO_MV_HEVC)));
            if (z) {
                zzg.isEmpty();
            }
            if ("audio/raw".equals(str)) {
                zzh(zzg, new zzua() { // from class: com.google.android.gms.internal.ads.zztt
                    @Override // com.google.android.gms.internal.ads.zzua
                    public final int zza(Object obj) {
                        int i = zzuc.zza;
                        String str2 = ((zzti) obj).zza;
                        return (str2.startsWith("OMX.google") || str2.startsWith("c2.android")) ? 1 : 0;
                    }
                });
            }
            if (Build.VERSION.SDK_INT < 32 && zzg.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzti) zzg.get(0)).zza)) {
                zzg.add((zzti) zzg.remove(0));
            }
            zzfyq zzl = zzfyq.zzl(zzg);
            hashMap.put(zztvVar, zzl);
            return zzl;
        }
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zze(zztr zztrVar, zzz zzzVar, boolean z, boolean z2) throws zztw {
        List zza2 = zztrVar.zza(zzzVar.zzo, z, z2);
        List zzc = zzc(zztrVar, zzzVar, z, z2);
        int i = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        zzfynVar.zzh(zza2);
        zzfynVar.zzh(zzc);
        return zzfynVar.zzi();
    }

    public static List zzf(List list, final zzz zzzVar) {
        ArrayList arrayList = new ArrayList(list);
        zzh(arrayList, new zzua() { // from class: com.google.android.gms.internal.ads.zztu
            @Override // com.google.android.gms.internal.ads.zzua
            public final int zza(Object obj) {
                int i = zzuc.zza;
                return ((zzti) obj).zze(zzz.this) ? 1 : 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(1:(1:37))|38|(1:40)(2:84|(1:86)(1:87))|41|(1:43)(2:76|(1:83)(1:82))|(4:(8:(1:46)|64|65|66|67|68|69|70)(1:75)|68|69|70)|(2:49|(3:52|53|54))|64|65|66|67) */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0173, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019b, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010d A[Catch: Exception -> 0x0199, TryCatch #1 {Exception -> 0x0199, blocks: (B:28:0x00db, B:32:0x00f4, B:38:0x0107, B:40:0x010d, B:41:0x011e, B:43:0x012a, B:76:0x012f, B:78:0x013f, B:80:0x0147, B:84:0x0113), top: B:27:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012a A[Catch: Exception -> 0x0199, TryCatch #1 {Exception -> 0x0199, blocks: (B:28:0x00db, B:32:0x00f4, B:38:0x0107, B:40:0x010d, B:41:0x011e, B:43:0x012a, B:76:0x012f, B:78:0x013f, B:80:0x0147, B:84:0x0113), top: B:27:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012f A[Catch: Exception -> 0x0199, TryCatch #1 {Exception -> 0x0199, blocks: (B:28:0x00db, B:32:0x00f4, B:38:0x0107, B:40:0x010d, B:41:0x011e, B:43:0x012a, B:76:0x012f, B:78:0x013f, B:80:0x0147, B:84:0x0113), top: B:27:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0113 A[Catch: Exception -> 0x0199, TryCatch #1 {Exception -> 0x0199, blocks: (B:28:0x00db, B:32:0x00f4, B:38:0x0107, B:40:0x010d, B:41:0x011e, B:43:0x012a, B:76:0x012f, B:78:0x013f, B:80:0x0147, B:84:0x0113), top: B:27:0x00db }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList zzg(zztv zztvVar, zztx zztxVar) throws zztw {
        int i;
        String str;
        String str2;
        String str3;
        boolean z;
        String str4;
        boolean z2;
        boolean zzi;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        zztv zztvVar2 = zztvVar;
        zztx zztxVar2 = zztxVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str5 = zztvVar2.zza;
            int zza2 = zztxVar2.zza();
            boolean zze = zztxVar2.zze();
            int i2 = 0;
            while (i2 < zza2) {
                MediaCodecInfo zzb2 = zztxVar2.zzb(i2);
                if (Build.VERSION.SDK_INT < 29 || !zzb2.isAlias()) {
                    int i3 = i2;
                    String name = zzb2.getName();
                    if (!zzb2.isEncoder() && (zze || !name.endsWith(".secure"))) {
                        String[] supportedTypes = zzb2.getSupportedTypes();
                        int length = supportedTypes.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 < length) {
                                str = supportedTypes[i4];
                                if (str.equalsIgnoreCase(str5)) {
                                    break;
                                }
                                i4++;
                            } else if (str5.equals("video/dolby-vision")) {
                                if ("OMX.MS.HEVCDV.Decoder".equals(name)) {
                                    str = "video/hevcdv";
                                } else {
                                    if ("OMX.RTK.video.decoder".equals(name) || "OMX.realtek.video.decoder.tunneled".equals(name)) {
                                        str = "video/dv_hevc";
                                    }
                                    str = null;
                                }
                            } else if (str5.equals(MimeTypes.VIDEO_MV_HEVC)) {
                                if (!"c2.qti.mvhevc.decoder".equals(name)) {
                                    if ("c2.qti.mvhevc.decoder.secure".equals(name)) {
                                    }
                                    str = null;
                                }
                                str = "video/x-mvhevc";
                            } else if (str5.equals("audio/alac") && "OMX.lge.alac.decoder".equals(name)) {
                                str = "audio/x-lg-alac";
                            } else if (str5.equals("audio/flac") && "OMX.lge.flac.decoder".equals(name)) {
                                str = "audio/x-lg-flac";
                            } else {
                                if (str5.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(name)) {
                                    str = "audio/lg-ac3";
                                }
                                str = null;
                            }
                        }
                        if (str != null) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = zzb2.getCapabilitiesForType(str);
                                boolean zzd = zztxVar2.zzd("tunneled-playback", str, capabilitiesForType);
                                boolean zzc = zztxVar2.zzc("tunneled-playback", str, capabilitiesForType);
                                if (zztvVar2.zzc) {
                                    if (!zzd) {
                                        i = i3;
                                    }
                                    boolean zzd2 = zztxVar2.zzd("secure-playback", str, capabilitiesForType);
                                    boolean zzc2 = zztxVar2.zzc("secure-playback", str, capabilitiesForType);
                                    z = zztvVar2.zzb;
                                    if (!z) {
                                    }
                                    if (z) {
                                    }
                                    if (Build.VERSION.SDK_INT < 29) {
                                    }
                                    zzi = zzi(zzb2, str5);
                                    z3 = z2;
                                    if (Build.VERSION.SDK_INT < 29) {
                                    }
                                    if (zze) {
                                    }
                                    if (!zze) {
                                    }
                                    z6 = z4;
                                    i = i3;
                                    str2 = str;
                                    str3 = name;
                                    if (!zze) {
                                        arrayList.add(zzti.zzd(str3 + str4, str5, str2, capabilitiesForType, z3, zzi, z6, false, true));
                                        return arrayList;
                                    }
                                    continue;
                                } else {
                                    if (!zzc) {
                                        boolean zzd22 = zztxVar2.zzd("secure-playback", str, capabilitiesForType);
                                        boolean zzc22 = zztxVar2.zzc("secure-playback", str, capabilitiesForType);
                                        z = zztvVar2.zzb;
                                        if (!z || !zzc22) {
                                            if (z) {
                                                if (zzd22) {
                                                    zzd22 = true;
                                                }
                                            }
                                            if (Build.VERSION.SDK_INT < 29) {
                                                z2 = zzb2.isHardwareAccelerated();
                                                str4 = ".secure";
                                            } else {
                                                str4 = ".secure";
                                                z2 = !zzi(zzb2, str5);
                                            }
                                            zzi = zzi(zzb2, str5);
                                            z3 = z2;
                                            if (Build.VERSION.SDK_INT < 29) {
                                                z4 = zzb2.isVendor();
                                            } else {
                                                String zza3 = zzfuv.zza(zzb2.getName());
                                                z4 = (zza3.startsWith("omx.google.") || zza3.startsWith("c2.android.") || zza3.startsWith("c2.google.")) ? false : true;
                                            }
                                            try {
                                                if (zze) {
                                                    z5 = zzd22;
                                                } else {
                                                    if (z != zzd22) {
                                                        z5 = true;
                                                    }
                                                    boolean z7 = z4;
                                                    i = i3;
                                                    str2 = str;
                                                    str3 = name;
                                                    arrayList.add(zzti.zzd(name, str5, str2, capabilitiesForType, z3, zzi, z7, false, false));
                                                }
                                                arrayList.add(zzti.zzd(name, str5, str2, capabilitiesForType, z3, zzi, z7, false, false));
                                            } catch (Exception e) {
                                                e = e;
                                                zzea.zzc("MediaCodecUtil", "Failed to query codec " + str3 + " (" + str2 + ")");
                                                throw e;
                                            }
                                            if (!zze || z) {
                                                z6 = z4;
                                                i = i3;
                                                str2 = str;
                                                str3 = name;
                                                if (!zze && z5) {
                                                    arrayList.add(zzti.zzd(str3 + str4, str5, str2, capabilitiesForType, z3, zzi, z6, false, true));
                                                    return arrayList;
                                                }
                                            }
                                            boolean z72 = z4;
                                            i = i3;
                                            str2 = str;
                                            str3 = name;
                                        }
                                    }
                                    i = i3;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                str2 = str;
                            }
                        }
                    }
                    i = i3;
                } else {
                    i = i2;
                }
                i2 = i + 1;
                zztvVar2 = zztvVar;
                zztxVar2 = zztxVar;
            }
            return arrayList;
        } catch (Exception e3) {
            throw new zztw(e3, null);
        }
    }

    private static void zzh(List list, final zzua zzuaVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzts
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i = zzuc.zza;
                zzua zzuaVar2 = zzua.this;
                return zzuaVar2.zza(obj2) - zzuaVar2.zza(obj);
            }
        });
    }

    private static boolean zzi(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzay.zzh(str)) {
            return true;
        }
        String zza2 = zzfuv.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.") || ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google."))) {
            return true;
        }
        return (zza2.startsWith("omx.") || zza2.startsWith("c2.")) ? false : true;
    }
}
