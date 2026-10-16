package com.fyber.inneractive.sdk.player.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.SparseIntArray;
import com.adjust.sdk.Constants;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f1518a;
    public static final HashMap b;
    public static final SparseIntArray c;
    public static final SparseIntArray d;
    public static final HashMap e;
    public static int f;

    public static a a(boolean z, String str) {
        List list;
        synchronized (j.class) {
            e eVar = new e(z, str);
            list = (List) b.get(eVar);
            if (list == null) {
                int i = z.f1599a;
                ArrayList a2 = a(eVar, i >= 21 ? new i(z) : new h());
                if (z && a2.isEmpty() && 21 <= i && i <= 23) {
                    a2 = a(eVar, new h());
                    if (!a2.isEmpty()) {
                        Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((a) a2.get(0)).f1514a);
                    }
                }
                if (i < 26) {
                    int i2 = 1;
                    if (a2.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(((a) a2.get(0)).f1514a)) {
                        while (true) {
                            if (i2 >= a2.size()) {
                                break;
                            }
                            a aVar = (a) a2.get(i2);
                            if ("OMX.google.raw.decoder".equals(aVar.f1514a)) {
                                a2.remove(i2);
                                a2.add(0, aVar);
                                break;
                            }
                            i2++;
                        }
                    }
                }
                list = Collections.unmodifiableList(a2);
                b.put(eVar, list);
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        return (a) list.get(0);
    }

    static {
        new a("OMX.google.raw.decoder", null, null, false);
        f1518a = Pattern.compile("^\\D?(\\d+)$");
        b = new HashMap();
        f = -1;
        SparseIntArray sparseIntArray = new SparseIntArray();
        c = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        d = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap hashMap = new HashMap();
        e = hashMap;
        hashMap.put("L30", 1);
        hashMap.put("L60", 4);
        hashMap.put("L63", 16);
        hashMap.put("L90", 64);
        hashMap.put("L93", 256);
        hashMap.put("L120", 1024);
        hashMap.put("L123", 4096);
        hashMap.put("L150", 16384);
        hashMap.put("L153", 65536);
        hashMap.put("L156", 262144);
        hashMap.put("L180", 1048576);
        hashMap.put("L183", 4194304);
        hashMap.put("L186", 16777216);
        hashMap.put("H30", 2);
        hashMap.put("H60", 8);
        hashMap.put("H63", 32);
        hashMap.put("H90", 128);
        hashMap.put("H93", 512);
        hashMap.put("H120", 2048);
        hashMap.put("H123", 8192);
        hashMap.put("H150", 32768);
        hashMap.put("H153", 131072);
        hashMap.put("H156", 524288);
        hashMap.put("H180", 2097152);
        hashMap.put("H183", 8388608);
        hashMap.put("H186", 33554432);
    }

    public static int a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i;
        if (f == -1) {
            int i2 = 0;
            a a2 = a(false, "video/avc");
            if (a2 != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = a2.e;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = codecProfileLevelArr[i2].level;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, z.f1599a >= 21 ? 345600 : AdConfig.DEFAULT_PING_V2_EXPIRY_HIGH);
            }
            f = i2;
        }
        return f;
    }

    public static ArrayList a(e eVar, g gVar) {
        boolean z;
        g gVar2 = gVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str = eVar.f1516a;
            int a2 = gVar2.a();
            boolean b2 = gVar2.b();
            int i = 0;
            loop0: while (i < a2) {
                MediaCodecInfo a3 = gVar2.a(i);
                String name = a3.getName();
                if (a(a3, name, b2)) {
                    String[] supportedTypes = a3.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str2 = supportedTypes[i2];
                        if (str2.equalsIgnoreCase(str)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = a3.getCapabilitiesForType(str2);
                                boolean a4 = gVar2.a(str, capabilitiesForType);
                                if (z.f1599a <= 22) {
                                    String str3 = z.d;
                                    if ((str3.equals("ODROID-XU3") || str3.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name))) {
                                        z = true;
                                        if ((!b2 && eVar.b == a4) || (!b2 && !eVar.b)) {
                                            arrayList.add(new a(name, str, capabilitiesForType, z));
                                        } else if (!b2 && a4) {
                                            arrayList.add(new a(name + ".secure", str, capabilitiesForType, z));
                                            break loop0;
                                        }
                                    }
                                }
                                z = false;
                                if (!b2) {
                                }
                                if (!b2) {
                                    arrayList.add(new a(name + ".secure", str, capabilitiesForType, z));
                                    break loop0;
                                    break loop0;
                                }
                                continue;
                            } catch (Exception e2) {
                                if (z.f1599a <= 23 && !arrayList.isEmpty()) {
                                    Log.e("MediaCodecUtil", "Skipping codec " + name + " (failed to query capabilities)");
                                } else {
                                    Log.e("MediaCodecUtil", "Failed to query codec " + name + " (" + str2 + ")");
                                    throw e2;
                                }
                            }
                        }
                        i2++;
                        gVar2 = gVar;
                    }
                }
                i++;
                gVar2 = gVar;
            }
            return arrayList;
        } catch (Exception e3) {
            throw new f(e3);
        }
    }

    public static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = z.f1599a;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && "a70".equals(z.b)) {
            return false;
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str2 = z.b;
            if ("dlxu".equals(str2) || "protou".equals(str2) || "ville".equals(str2) || "villeplus".equals(str2) || "villec2".equals(str2) || str2.startsWith("gee") || "C6602".equals(str2) || "C6603".equals(str2) || "C6606".equals(str2) || "C6616".equals(str2) || "L36h".equals(str2) || "SO-02E".equals(str2)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str3 = z.b;
            if ("C1504".equals(str3) || "C1505".equals(str3) || "C1604".equals(str3) || "C1605".equals(str3)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && Constants.REFERRER_API_SAMSUNG.equals(z.c)) {
            String str4 = z.b;
            if (str4.startsWith("d2") || str4.startsWith("serrano") || str4.startsWith("jflte") || str4.startsWith("santos") || str4.startsWith("t0")) {
                return false;
            }
        }
        return (i <= 19 && z.b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) ? false : true;
    }
}
