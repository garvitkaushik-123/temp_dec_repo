package com.mbridge.msdk.playercommon.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import com.adjust.sdk.Constants;
import com.inmobi.commons.core.configs.AdConfig;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public final class MediaCodecUtil {
    private static final SparseIntArray AVC_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray AVC_PROFILE_NUMBER_TO_CONST;
    private static final String CODEC_ID_AVC1 = "avc1";
    private static final String CODEC_ID_AVC2 = "avc2";
    private static final String CODEC_ID_HEV1 = "hev1";
    private static final String CODEC_ID_HVC1 = "hvc1";
    private static final Map<String, Integer> HEVC_CODEC_STRING_TO_PROFILE_LEVEL;
    private static final String MTK_RAW_DECODER_NAME = "OMX.MTK.AUDIO.DECODER.RAW";
    private static final String TAG = "MediaCodecUtil";
    private static final String GOOGLE_RAW_DECODER_NAME = "OMX.google.raw.decoder";
    private static final MediaCodecInfo PASSTHROUGH_DECODER_INFO = MediaCodecInfo.newPassthroughInstance(GOOGLE_RAW_DECODER_NAME);
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap<>();
    private static int maxH264DecodableFrameSize = -1;

    private static final class CodecKey {
        public final String mimeType;
        public final boolean secure;

        public CodecKey(String str, boolean z) {
            this.mimeType = str;
            this.secure = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == CodecKey.class) {
                CodecKey codecKey = (CodecKey) obj;
                if (TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            String str = this.mimeType;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.secure ? 1231 : 1237);
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private interface MediaCodecListCompat {
        int getCodecCount();

        android.media.MediaCodecInfo getCodecInfoAt(int i);

        boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    private static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        private MediaCodecListCompatV16() {
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    private static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        private android.media.MediaCodecInfo[] mediaCodecInfos;

        public MediaCodecListCompatV21(boolean z) {
            this.codecKind = z ? 1 : 0;
        }

        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int i) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[i];
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        AVC_PROFILE_NUMBER_TO_CONST = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        AVC_LEVEL_NUMBER_TO_CONST = sparseIntArray2;
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
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL = hashMap;
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

    private MediaCodecUtil() {
    }

    private static void applyWorkarounds(List<MediaCodecInfo> list) {
        if (Util.SDK_INT < 26) {
            if (list.size() <= 1 || !MTK_RAW_DECODER_NAME.equals(list.get(0).name)) {
                return;
            }
            for (int i = 1; i < list.size(); i++) {
                MediaCodecInfo mediaCodecInfo = list.get(i);
                if (GOOGLE_RAW_DECODER_NAME.equals(mediaCodecInfo.name)) {
                    list.remove(i);
                    list.add(0, mediaCodecInfo);
                    return;
                }
            }
        }
    }

    private static int avcLevelToMaxFrameSize(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    private static boolean codecNeedsDisableAdaptationWorkaround(String str) {
        if (Util.SDK_INT > 22) {
            return false;
        }
        String str2 = Util.MODEL;
        if ("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) {
            return "OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str);
        }
        return false;
    }

    private static Pair<Integer, Integer> getAvcProfileAndLevel(String str, String[] strArr) {
        Integer valueOf;
        Integer num;
        if (strArr.length < 2) {
            Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else {
                if (strArr.length < 3) {
                    Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                num = valueOf2;
            }
            int i = AVC_PROFILE_NUMBER_TO_CONST.get(num.intValue(), -1);
            if (i == -1) {
                Log.w(TAG, "Unknown AVC profile: " + num);
                return null;
            }
            int i2 = AVC_LEVEL_NUMBER_TO_CONST.get(valueOf.intValue(), -1);
            if (i2 != -1) {
                return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
            }
            Log.w(TAG, "Unknown AVC level: " + valueOf);
            return null;
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        if (r3.equals(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil.CODEC_ID_AVC1) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> getCodecProfileAndLevel(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        char c = 0;
        String str2 = split[0];
        str2.hashCode();
        str2.hashCode();
        switch (str2.hashCode()) {
            case 3006243:
                break;
            case 3006244:
                if (str2.equals(CODEC_ID_AVC2)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3199032:
                if (str2.equals(CODEC_ID_HEV1)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3214780:
                if (str2.equals(CODEC_ID_HVC1)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
        }
        return null;
    }

    public static MediaCodecInfo getDecoderInfo(String str, boolean z) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(str, z);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(String str, boolean z) throws DecoderQueryException {
        synchronized (MediaCodecUtil.class) {
            CodecKey codecKey = new CodecKey(str, z);
            HashMap<CodecKey, List<MediaCodecInfo>> hashMap = decoderInfosCache;
            List<MediaCodecInfo> list = hashMap.get(codecKey);
            if (list != null) {
                return list;
            }
            int i = Util.SDK_INT;
            MediaCodecListCompat mediaCodecListCompatV21 = i >= 21 ? new MediaCodecListCompatV21(z) : new MediaCodecListCompatV16();
            ArrayList<MediaCodecInfo> decoderInfosInternal = getDecoderInfosInternal(codecKey, mediaCodecListCompatV21, str);
            if (z && decoderInfosInternal.isEmpty() && 21 <= i && i <= 23) {
                mediaCodecListCompatV21 = new MediaCodecListCompatV16();
                decoderInfosInternal = getDecoderInfosInternal(codecKey, mediaCodecListCompatV21, str);
                if (!decoderInfosInternal.isEmpty()) {
                    Log.w(TAG, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + decoderInfosInternal.get(0).name);
                }
            }
            if ("audio/eac3-joc".equals(str)) {
                decoderInfosInternal.addAll(getDecoderInfosInternal(new CodecKey("audio/eac3", codecKey.secure), mediaCodecListCompatV21, str));
            }
            applyWorkarounds(decoderInfosInternal);
            List<MediaCodecInfo> unmodifiableList = Collections.unmodifiableList(decoderInfosInternal);
            hashMap.put(codecKey, unmodifiableList);
            return unmodifiableList;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        if (r17.secure != r7) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        r3.add(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo.newInstance(r10, r4, r0, r2, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
    
        if (r17.secure == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList<MediaCodecInfo> getDecoderInfosInternal(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat, String str) throws DecoderQueryException {
        int i;
        MediaCodecListCompat mediaCodecListCompat2 = mediaCodecListCompat;
        try {
            ArrayList<MediaCodecInfo> arrayList = new ArrayList<>();
            String str2 = codecKey.mimeType;
            int codecCount = mediaCodecListCompat2.getCodecCount();
            boolean secureDecodersExplicit = mediaCodecListCompat2.secureDecodersExplicit();
            int i2 = 0;
            loop0: while (i2 < codecCount) {
                android.media.MediaCodecInfo codecInfoAt = mediaCodecListCompat2.getCodecInfoAt(i2);
                String name = codecInfoAt.getName();
                if (isCodecUsableDecoder(codecInfoAt, name, secureDecodersExplicit, str)) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i3 = 0;
                    while (i3 < length) {
                        String str3 = supportedTypes[i3];
                        if (str3.equalsIgnoreCase(str2)) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str3);
                                boolean isSecurePlaybackSupported = mediaCodecListCompat2.isSecurePlaybackSupported(str2, capabilitiesForType);
                                boolean codecNeedsDisableAdaptationWorkaround = codecNeedsDisableAdaptationWorkaround(name);
                                if (secureDecodersExplicit) {
                                    i = codecCount;
                                    try {
                                    } catch (Exception e) {
                                        e = e;
                                        if (Util.SDK_INT <= 23 || arrayList.isEmpty()) {
                                            Log.e(TAG, "Failed to query codec " + name + " (" + str3 + ")");
                                            throw e;
                                        }
                                        Log.e(TAG, "Skipping codec " + name + " (failed to query capabilities)");
                                        i3++;
                                        mediaCodecListCompat2 = mediaCodecListCompat;
                                        codecCount = i;
                                    }
                                } else {
                                    i = codecCount;
                                }
                                if (!secureDecodersExplicit) {
                                    try {
                                    } catch (Exception e2) {
                                        e = e2;
                                        if (Util.SDK_INT <= 23) {
                                        }
                                        Log.e(TAG, "Failed to query codec " + name + " (" + str3 + ")");
                                        throw e;
                                    }
                                }
                                if (!secureDecodersExplicit && isSecurePlaybackSupported) {
                                    arrayList.add(MediaCodecInfo.newInstance(name + ".secure", str2, capabilitiesForType, codecNeedsDisableAdaptationWorkaround, true));
                                    break loop0;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                i = codecCount;
                            }
                        } else {
                            i = codecCount;
                        }
                        i3++;
                        mediaCodecListCompat2 = mediaCodecListCompat;
                        codecCount = i;
                    }
                }
                i2++;
                mediaCodecListCompat2 = mediaCodecListCompat;
                codecCount = codecCount;
            }
            return arrayList;
        } catch (Exception e4) {
            throw new DecoderQueryException(e4);
        }
    }

    private static Pair<Integer, Integer> getHevcProfileAndLevel(String str, String[] strArr) {
        int i;
        if (strArr.length < 4) {
            Log.w(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if ("1".equals(group)) {
            i = 1;
        } else {
            if (!"2".equals(group)) {
                Log.w(TAG, "Unknown HEVC profile string: " + group);
                return null;
            }
            i = 2;
        }
        Integer num = HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(strArr[3]);
        if (num != null) {
            return new Pair<>(Integer.valueOf(i), num);
        }
        Log.w(TAG, "Unknown HEVC level string: " + matcher.group(1));
        return null;
    }

    public static MediaCodecInfo getPassthroughDecoderInfo() {
        return PASSTHROUGH_DECODER_INFO;
    }

    private static boolean isCodecUsableDecoder(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = Util.SDK_INT;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = Util.DEVICE;
            if ("a70".equals(str3) || ("Xiaomi".equals(Util.MANUFACTURER) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = Util.DEVICE;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = Util.DEVICE;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && Constants.REFERRER_API_SAMSUNG.equals(Util.MANUFACTURER))) {
            String str6 = Util.DEVICE;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && Constants.REFERRER_API_SAMSUNG.equals(Util.MANUFACTURER)) {
            String str7 = Util.DEVICE;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        if (maxH264DecodableFrameSize == -1) {
            int i = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo("video/avc", false);
            if (decoderInfo != null) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(avcLevelToMaxFrameSize(profileLevels[i].level), i2);
                    i++;
                }
                i = Math.max(i2, Util.SDK_INT >= 21 ? 345600 : AdConfig.DEFAULT_PING_V2_EXPIRY_HIGH);
            }
            maxH264DecodableFrameSize = i;
        }
        return maxH264DecodableFrameSize;
    }

    public static void warmDecoderInfoCache(String str, boolean z) {
        try {
            getDecoderInfos(str, z);
        } catch (DecoderQueryException e) {
            Log.e(TAG, "Codec warming failed", e);
        }
    }
}
