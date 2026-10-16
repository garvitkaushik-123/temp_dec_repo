package com.instagram.common.viewpoint.core;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public final class B3 {
    public static byte[] A0B;
    public static String[] A0C = {"I9JaO4heFf5nDgSUvVeAxAeOAdbY1nhs", "PVSEhsxK0zpzpXeziFZITHKDYbLYMlXw", "qlK6yxEC", "9zKWhcki2UyQZLYGzaAyWcMw08QqvpbN", "JlMwKIWIzkUyHhMRK", "e8OveLjqyhc2hkEtyY01o7K", "DY1oAH7PrQgT6IVPSHYZAZf9F8l8uJ13", "bCAM9BCoFLqZyqtmC8leb"};
    public final MediaCodecInfo.CodecCapabilities A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final boolean A04;
    public final boolean A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 26);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0B = new byte[]{73, Ascii.GS, 6, 73, Ascii.GS, 17, 65, 77, 54, 46, 48, 2, 2, 4, Ascii.FS, Ascii.DC4, Ascii.NAK, 60, Ascii.DLE, 9, 50, Ascii.EM, Ascii.DLE, Ascii.US, Ascii.US, Ascii.DC4, Ascii.GS, 48, Ascii.NAK, Ascii.ESC, 4, 2, 5, Ascii.FS, Ascii.DC4, Ascii.US, 5, 75, 81, Ascii.SO, 60, 60, 58, 34, 42, 43, Ascii.FS, 58, 63, 63, 32, Base64.padSymbol, 59, 111, Ascii.DC4, 19, 58, 49, 48, 41, 48, Byte.MAX_VALUE, Ascii.VT, Ascii.GS, 114, 7, 105, 111, 106, 98, 75, SignedBytes.MAX_POWER_OF_TWO, 65, 88, 65, Ascii.SO, 122, 108, 3, 118, Ascii.CAN, Ascii.RS, Ascii.CAN, 86, Byte.MAX_VALUE, 116, 117, 108, 117, 58, 78, 88, 55, 66, 44, 43, 44, 52, Ascii.FS, Ascii.GS, Ascii.DLE, Ascii.CAN, 58, Ascii.SYN, Ascii.GS, Ascii.FS, Ascii.SUB, 48, Ascii.ETB, Ascii.US, Ascii.SYN, Ascii.FS, 55, 42, 39, 33, 114, 99, 98, 126, 95, 99, 69, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 95, 66, 68, Ascii.DLE, 107, Ascii.VT, 0, Ascii.SYN, Ascii.VT, Ascii.CR, 0, 105, Ascii.FS, 17, 119, 32, 34, 55, 65, 42, Ascii.ETB, Ascii.SYN, 1, 0, Ascii.FS, 65, 46, 57, 44, 65, 43, 10, Ascii.FF, 0, Ascii.VT, 10, Ascii.GS, Ascii.US, Ascii.GS, 8, 126, Ascii.NAK, 40, 41, 62, 63, 35, 126, 17, 6, 19, 126, Ascii.DC4, 53, 51, 63, 52, 53, 34, 126, 35, 53, 51, 37, 34, 53, 84, 86, 67, 53, 86, 90, 73, 77, 94, 87, 87, 53, 77, 82, 95, 94, 84, 53, 83, 76, 53, 88, 84, 95, 90, 44, 46, 47, 41, 95, 94, 88, 84, 95, 94, 73, Ascii.VT, 9, Ascii.FS, 106, 9, Ascii.DLE, Ascii.SI, 106, Ascii.DC2, Ascii.CR, 0, 1, Ascii.VT, 106, 0, 1, 7, Ascii.VT, 0, 1, Ascii.SYN, 106, Ascii.FF, 1, Ascii.DC2, 7, Ascii.DLE, Ascii.SO, 110, Ascii.ETB, 113, 112, 115, Ascii.SI, 102, Ascii.ESC, 96, 90, 95, 90, 75, 79, 82, 77, 94, Ascii.SYN, 75, 87, 90, 66, 89, 90, 88, 80, Ascii.GS, 9, Ascii.CAN, Ascii.NAK, 19, 83, 79, Ascii.ESC, Ascii.FF, Ascii.FF, 74, 94, 79, 66, 68, 4, 74, 72, Ascii.CAN, 110, 122, 107, 102, 96, 32, 110, 98, 125, 34, 120, 109, 44, 56, 41, 36, 34, 98, 40, 44, 46, 126, 7, 19, 2, Ascii.SI, 9, 73, 0, 10, 7, 5, Byte.MAX_VALUE, 107, 122, 119, 113, 49, 121, 41, 47, 47, 51, Byte.MAX_VALUE, 114, Byte.MAX_VALUE, 105, 42, 62, 47, 34, 36, 100, 44, 124, 122, 122, 102, 38, 39, 42, 60, Ascii.CAN, Ascii.FF, Ascii.GS, Ascii.DLE, Ascii.SYN, 86, Ascii.RS, 10, Ascii.DC4, 78, 90, 75, 70, SignedBytes.MAX_POWER_OF_TWO, 0, 66, 95, Ascii.ESC, 78, 2, 67, 78, 91, 66, 85, 65, 80, 93, 91, Ascii.ESC, 89, 68, 81, 83, 79, 91, 74, 71, 65, 1, 65, 94, 91, 93, 84, SignedBytes.MAX_POWER_OF_TWO, 81, 92, 90, Ascii.SUB, 71, 84, 66, 111, 123, 106, 103, 97, 33, 120, 97, 124, 108, 103, 125, 126, 115, 110, 121, 125, 112, 5, Ascii.SO, 7, 8, 8, 3, 10, 37, 9, 19, 8, Ascii.DC2, 72, 7, 37, 7, Ascii.SYN, Ascii.NAK, 66, 73, SignedBytes.MAX_POWER_OF_TWO, 79, 79, 68, 77, 98, 78, 84, 79, 85, Ascii.SI, 66, SignedBytes.MAX_POWER_OF_TWO, 81, 82, 55, 60, 53, 58, 58, 49, 56, Ascii.ETB, 59, 33, 58, 32, 122, 39, 33, 36, 36, 59, 38, 32, 120, 116, 53, 57, 50, 51, 53, 120, 59, 63, 59, 51, 118, 107, 103, 108, 109, 107, 38, 120, 122, 103, 110, 97, 100, 109, 68, 109, 126, 109, 100, 36, 40, 126, 114, 97, Byte.MAX_VALUE, 122, 125, 36, 42, 63, 124, 40, 87, 69, 70, 86, 77, 74, 69, 77, 95, 87, 82, 88, 87, 77, 86, 49, 35, 47, 50, 46, 39, Ascii.DLE, 35, 54, 39, 108, 35, 1, 35, 50, 49, 109, Byte.MAX_VALUE, 115, 110, 114, 123, 76, Byte.MAX_VALUE, 106, 123, 48, 125, Byte.MAX_VALUE, 110, 109, 2, Ascii.DLE, Ascii.FS, 1, Ascii.GS, Ascii.DC4, 35, Ascii.DLE, 5, Ascii.DC4, 95, 2, 4, 1, 1, Ascii.RS, 3, 5, 93, 81, 1, Ascii.ETB, 17, 7, 0, Ascii.ETB, 95, 2, Ascii.RS, 19, Ascii.VT, Ascii.DLE, 19, 17, Ascii.EM, 102, 124, 111, 112, 84, 123, 113, 71, 116, 97, 112, 59, 118, 116, 101, 102, SignedBytes.MAX_POWER_OF_TWO, 90, 73, 86, 114, 93, 87, 97, 82, 71, 86, Ascii.GS, 80, 92, 69, 86, 65, Ascii.US, 19, 108, 118, 101, 122, 94, 113, 123, 77, 126, 107, 122, 49, 109, 112, 107, 126, 107, 122, 123, 51, 63, Ascii.CAN, 2, 17, Ascii.SO, 42, 5, Ascii.SI, 57, 10, Ascii.US, Ascii.SO, 69, Ascii.CAN, Ascii.RS, Ascii.ESC, Ascii.ESC, 4, Ascii.EM, Ascii.US, 71, 75, 100, 126, 109, 114, 86, 121, 115, 69, 118, 99, 114, 57, 97, 84, 118, 103, 100, 4, 5, Ascii.RS, Ascii.RS, Ascii.NAK, Ascii.FS, Ascii.NAK, Ascii.DC4, 93, 0, Ascii.FS, 17, 9, Ascii.DC2, 17, 19, Ascii.ESC, 48, 47, 34, 35, 41, 105, 39, 48, 37, 114, 109, 96, 97, 107, 43, 96, 107, 104, 102, 125, 41, 114, 109, 119, 109, 107, 106, Ascii.NAK, 10, 7, 6, Ascii.FF, 76, Ascii.VT, 6, Ascii.NAK, 0, 82, 77, SignedBytes.MAX_POWER_OF_TWO, 65, 75, Ascii.VT, 92, 9, 82, 74, SignedBytes.MAX_POWER_OF_TWO, 10, 75, 74, Ascii.SYN, 10, 82, 84, Ascii.GS, 92};
    }

    static {
        A04();
    }

    public B3(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.A03 = (String) AbstractC07133y.A01(str);
        this.A02 = str2;
        this.A01 = str3;
        this.A00 = codecCapabilities;
        this.A05 = z;
        this.A07 = z2;
        this.A09 = z3;
        this.A04 = z4;
        this.A08 = z5;
        this.A06 = z6;
        this.A0A = C3J.A0F(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ce, code lost:
    
        if (A03(332, 15, 4).equals(r6) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00de, code lost:
    
        if (A03(347, 15, 81).equals(r6) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ee, code lost:
    
        if (A03(362, 9, 99).equals(r6) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0119, code lost:
    
        if (A03(291, 9, 49).equals(r6) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x011b, code lost:
    
        r4 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011c, code lost:
    
        com.instagram.common.viewpoint.core.AbstractC07214g.A07(A03(97, 14, 99), A03(10, 29, 107) + r5 + A03(6, 3, com.vungle.ads.internal.protos.Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) + r7 + A03(0, 4, 115) + r4 + A03(260, 1, 72));
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0171, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0180, code lost:
    
        if (A03(com.vungle.ads.internal.protos.Sdk.SDKError.Reason.DEEPLINK_OPEN_FAILED_VALUE, 10, 87).equals(r6) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0182, code lost:
    
        r4 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0185, code lost:
    
        r4 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0108, code lost:
    
        if (A03(332, 15, 4).equals(r6) == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A00(String str, String str2, int i) {
        if (i > 1 || (C5C.A02 >= 26 && i > 0)) {
            return i;
        }
        if (!A03(386, 10, 46).equals(str2) && !A03(281, 10, 102).equals(str2) && !A03(300, 12, 21).equals(str2) && !A03(371, 15, 53).equals(str2) && !A03(TTAdConstant.VIDEO_COVER_URL_CODE, 12, 20).equals(str2) && !A03(396, 10, 52).equals(str2)) {
            String A03 = A03(406, 9, 47);
            String[] strArr = A0C;
            if (strArr[6].charAt(25) != strArr[3].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[7] = "P3L7eJR7rcEs8Hcud8b0q";
            strArr2[5] = "gztvffw6orscNCYhET6gtHo";
            if (!A03.equals(str2) && !A03(322, 10, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE).equals(str2)) {
                if (A0C[0].charAt(21) == 'A') {
                    String[] strArr3 = A0C;
                    strArr3[6] = "8EyIo3AmLznCqcE1QD1Y0pSK088XgXR2";
                    strArr3[3] = "dhhtuZGj1yFwqgsK2BE3ZfBkQ801LDWI";
                }
            }
        }
        return i;
    }

    public static Point A01(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int heightAlignment = videoCapabilities.getWidthAlignment();
        int widthAlignment = videoCapabilities.getHeightAlignment();
        return new Point(C5C.A05(i, heightAlignment) * heightAlignment, C5C.A05(i2, widthAlignment) * widthAlignment);
    }

    public static B3 A02(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        if (!z4 && codecCapabilities != null) {
            boolean A09 = A09(codecCapabilities);
            if (A0C[2].length() != 8) {
                throw new RuntimeException();
            }
            A0C[2] = "xqlBNWNY";
            if (A09 && !A0J(str)) {
                z6 = true;
                return new B3(str, str2, str3, codecCapabilities, z, z2, z3, z6, codecCapabilities == null && A0D(codecCapabilities), !z5 || (codecCapabilities != null && A0B(codecCapabilities)));
            }
        }
        z6 = false;
        return new B3(str, str2, str3, codecCapabilities, z, z2, z3, z6, codecCapabilities == null && A0D(codecCapabilities), !z5 || (codecCapabilities != null && A0B(codecCapabilities)));
    }

    private void A05(String str) {
        StringBuilder append = new StringBuilder().append(A03(39, 16, 85)).append(str);
        String A03 = A03(261, 3, 33);
        AbstractC07214g.A04(A03(97, 14, 99), append.append(A03).append(this.A03).append(A03(4, 2, 43)).append(this.A02).append(A03).append(C5C.A04).append(A03(260, 1, 72)).toString());
    }

    private void A06(String str) {
        StringBuilder append = new StringBuilder().append(A03(Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 11, 42)).append(str);
        String A03 = A03(261, 3, 33);
        AbstractC07214g.A04(A03(97, 14, 99), append.append(A03).append(this.A03).append(A03(4, 2, 43)).append(this.A02).append(A03).append(C5C.A04).append(A03(260, 1, 72)).toString());
    }

    public static boolean A07() {
        return C5C.A03.equals(A03(532, 7, 62)) || C5C.A03.equals(A03(427, 6, 6)) || C5C.A06.startsWith(A03(55, 14, 69)) || C5C.A06.startsWith(A03(69, 14, 52)) || C5C.A06.startsWith(A03(83, 14, 0));
    }

    public static boolean A09(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C5C.A02 >= 19 && A0A(codecCapabilities);
    }

    public static boolean A0A(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(264, 17, 33));
    }

    public static boolean A0B(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C5C.A02 >= 21 && A0C(codecCapabilities);
    }

    public static boolean A0C(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(598, 15, 104));
    }

    public static boolean A0D(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C5C.A02 >= 21 && A0E(codecCapabilities);
    }

    public static boolean A0E(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(IronSourceError.ERROR_NT_INSTANCE_INIT_TIMEOUT, 17, 106));
    }

    public static boolean A0F(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point alignedSize = A01(videoCapabilities, i, i2);
        int i3 = alignedSize.x;
        int i4 = alignedSize.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D46258033: [FBLite][Video] Solve tasks T154141530 T154151746 gating the call for SDK >=21")
    private boolean A0G(C2489qI c2489qI, boolean z) {
        Pair<Integer, Integer> A0B2 = C0881Ba.A0B(c2489qI);
        if (A0B2 == null) {
            return true;
        }
        Integer num = (Integer) A0B2.first;
        String[] strArr = A0C;
        if (strArr[6].charAt(25) == strArr[3].charAt(25)) {
            A0C[2] = "XFIr8RM8";
            int intValue = num.intValue();
            int level = ((Integer) A0B2.second).intValue();
            if (A03(733, 18, 30).equals(c2489qI.A0W)) {
                if (A03(724, 9, 92).equals(this.A02)) {
                    intValue = 8;
                    level = 0;
                } else if (A03(751, 10, Sdk.SDKError.Reason.TPAT_ERROR_VALUE).equals(this.A02)) {
                    intValue = 2;
                    level = 0;
                }
            }
            if (!this.A0A) {
                if (A0C[2].length() == 8) {
                    A0C[4] = "U7uwaC6XnAT7ItuO5";
                    if (intValue != 42) {
                        return true;
                    }
                }
            }
            if (A0V().length <= 0) {
                return true;
            }
            MediaCodecInfo.CodecProfileLevel[] A0V = A0V();
            if (C5C.A02 >= 21 && C5C.A02 <= 23) {
                if (A03(761, 19, 62).equals(this.A02) && A0V.length == 0) {
                    A0V = A0M(this.A00);
                }
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : A0V) {
                if (codecProfileLevel.profile == intValue) {
                    int i = codecProfileLevel.level;
                    if (A0C[0].charAt(21) == 'A') {
                        A0C[1] = "Tk1KZqXmKjuSsbjIU3mgahSyAhYoMHEk";
                        if (i >= level || !z) {
                            boolean A0L = A0L(this.A02, intValue);
                            if (A0C[1].charAt(21) != 'k') {
                                A0C[0] = "B6qJQnb2cEtex6AQnXMJ6AJyRiBsPuck";
                                if (!A0L) {
                                    return true;
                                }
                            } else if (!A0L) {
                                return true;
                            }
                        }
                    }
                }
            }
            A06(A03(501, 20, 18) + c2489qI.A0R + A03(4, 2, 43) + this.A01);
            return false;
        }
        throw new RuntimeException();
    }

    public static boolean A0H(String str) {
        return A03(396, 10, 52).equals(str);
    }

    public static boolean A0I(String str) {
        return C5C.A06.startsWith(A03(253, 7, 89)) && A03(191, 36, 1).equals(str);
    }

    public static boolean A0J(String str) {
        if (C5C.A02 <= 22) {
            if ((A03(130, 10, 94).equals(C5C.A06) || A03(111, 8, 72).equals(C5C.A06)) && (A03(140, 22, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE).equals(str) || A03(162, 29, 74).equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0K(String str) {
        if (A03(227, 26, 94).equals(str) && A03(IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 5, 83).equals(C5C.A03)) {
            return false;
        }
        return true;
    }

    public static boolean A0L(String str, int i) {
        if (A03(751, 10, Sdk.SDKError.Reason.TPAT_ERROR_VALUE).equals(str) && 2 == i) {
            if (A03(539, 8, 36).equals(C5C.A03) || A03(521, 6, 9).equals(C5C.A03)) {
                return true;
            }
        }
        return false;
    }

    public static MediaCodecInfo.CodecProfileLevel[] A0M(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int level;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int i = 0;
        if (codecCapabilities != null && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
            Integer upper = videoCapabilities.getBitrateRange().getUpper();
            if (A0C[0].charAt(21) != 'A') {
                throw new RuntimeException();
            }
            A0C[0] = "QcEMGW7v0Yxqh7XLcQ4xIAQDDerowqhX";
            i = upper.intValue();
        }
        if (i >= 180000000) {
            level = 1024;
        } else if (i >= 120000000) {
            level = 512;
        } else if (i >= 60000000) {
            level = 256;
        } else if (i >= 30000000) {
            level = 128;
        } else if (i >= 18000000) {
            level = 64;
        } else {
            if (A0C[0].charAt(21) != 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[7] = "cnj1P9QIvdvvlmM3jq4NJ";
            strArr[5] = "0LKKsHUxH9Ew65kXLPhVQ5r";
            if (i >= 12000000) {
                level = 32;
            } else if (i >= 7200000) {
                level = 16;
            } else if (i >= 3600000) {
                level = 8;
            } else if (i >= 1800000) {
                level = 4;
            } else if (i >= 800000) {
                level = 2;
            } else {
                level = 1;
            }
        }
        MediaCodecInfo.CodecProfileLevel profileLevel = new MediaCodecInfo.CodecProfileLevel();
        profileLevel.profile = 1;
        profileLevel.level = level;
        return new MediaCodecInfo.CodecProfileLevel[]{profileLevel};
    }

    public final Point A0N(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (this.A00 == null || (videoCapabilities = this.A00.getVideoCapabilities()) == null) {
            return null;
        }
        return A01(videoCapabilities, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        if (r1 != r14.A0A) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C6L A0O(C2489qI c2489qI, C2489qI c2489qI2) {
        int i = C5C.A1E(c2489qI.A0W, c2489qI2.A0W) ? 0 : 0 | 8;
        if (this.A0A) {
            int discardReasons = c2489qI.A0F;
            if (discardReasons != c2489qI2.A0F) {
                i |= 1024;
            }
            if (!this.A04) {
                int discardReasons2 = c2489qI.A0L;
                if (discardReasons2 == c2489qI2.A0L) {
                    int discardReasons3 = c2489qI.A0A;
                }
                i |= 512;
            }
            if (!C5C.A1E(c2489qI.A0N, c2489qI2.A0N)) {
                i |= 2048;
            }
            if (A0I(this.A03) && !c2489qI.A0A(c2489qI2)) {
                i |= 2;
            }
            if (i == 0) {
                String str = this.A03;
                int i2 = c2489qI.A0A(c2489qI2) ? 3 : 2;
                if (A0C[0].charAt(21) != 'A') {
                    throw new RuntimeException();
                }
                String[] strArr = A0C;
                strArr[7] = "2o9LDR7wht3djkkWSozFp";
                strArr[5] = "xzNY8imEyNfCiAqEOIotcML";
                return new C6L(str, c2489qI, c2489qI2, i2, 0);
            }
        } else {
            int discardReasons4 = c2489qI.A06;
            if (discardReasons4 != c2489qI2.A06) {
                i |= 4096;
            }
            int discardReasons5 = c2489qI.A0G;
            if (discardReasons5 != c2489qI2.A0G) {
                i |= 8192;
            }
            int discardReasons6 = c2489qI.A0C;
            if (discardReasons6 != c2489qI2.A0C) {
                i |= 16384;
            }
            if (i == 0 && A03(371, 15, 53).equals(this.A02)) {
                Pair<Integer, Integer> A0B2 = C0881Ba.A0B(c2489qI);
                Pair<Integer, Integer> A0B3 = C0881Ba.A0B(c2489qI2);
                if (A0B2 != null && A0B3 != null) {
                    int intValue = ((Integer) A0B2.first).intValue();
                    int intValue2 = ((Integer) A0B3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new C6L(this.A03, c2489qI, c2489qI2, 3, 0);
                    }
                }
            }
            if (!c2489qI.A0A(c2489qI2)) {
                i |= 32;
            }
            if (A0H(this.A02)) {
                i |= 2;
            }
            if (i == 0) {
                return new C6L(this.A03, c2489qI, c2489qI2, 1, 0);
            }
        }
        return new C6L(this.A03, c2489qI, c2489qI2, 0, i);
    }

    public final boolean A0P(int i) {
        if (this.A00 == null) {
            A06(A03(451, 17, 59));
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.A00.getAudioCapabilities();
        if (audioCapabilities == null) {
            A06(A03(433, 18, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE));
            return false;
        }
        if (A00(this.A03, this.A02, audioCapabilities.getMaxInputChannelCount()) < i) {
            A06(A03(468, 22, 78) + i);
            return false;
        }
        return true;
    }

    public final boolean A0Q(int i) {
        if (this.A00 == null) {
            A06(A03(563, 15, 4));
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.A00.getAudioCapabilities();
        if (audioCapabilities == null) {
            A06(A03(547, 16, 88));
            return false;
        }
        if (!audioCapabilities.isSampleRateSupported(i)) {
            A06(A03(578, 20, 107) + i);
            return false;
        }
        return true;
    }

    public final boolean A0R(int i, int i2, double d) {
        if (this.A00 == null) {
            if (A0C[4].length() != 17) {
                throw new RuntimeException();
            }
            A0C[1] = "VtsIfpRARdWM2RcSD8UT7BsOJP98i2Mb";
            A06(A03(613, 16, 15));
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.A00.getVideoCapabilities();
        if (videoCapabilities == null) {
            A06(A03(690, 17, 13));
            return false;
        }
        int i3 = C5C.A02;
        String A03 = A03(9, 1, 116);
        String A032 = A03(780, 1, 62);
        if (i3 >= 29) {
            int A00 = B1.A00(videoCapabilities, i, i2, d);
            if (A00 == 2) {
                return true;
            }
            if (A00 == 1) {
                A06(A03(LevelPlayAdError.ERROR_CODE_LOAD_WHILE_SHOW, 19, 41) + i + A032 + i2 + A03 + d);
                return false;
            }
        }
        if (!A0F(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !A0K(this.A03) || !A0F(videoCapabilities, i2, i, d)) {
                A06(A03(669, 21, 113) + i + A032 + i2 + A03 + d);
                return false;
            }
            A05(A03(648, 21, 5) + i + A032 + i2 + A03 + d);
        }
        return true;
    }

    @MetaExoPlayerCustomization(type = {"DEPRECATED_LOGIC"}, value = "D51676338: Control Renderer Support behavior")
    public final boolean A0S(C2489qI c2489qI) {
        String A07;
        if (c2489qI.A0R == null || this.A02 == null || (A07 = C3J.A07(c2489qI.A0R)) == null) {
            return true;
        }
        String codecMimeType = this.A02;
        if (!codecMimeType.equals(A07)) {
            StringBuilder sb = new StringBuilder();
            String codecMimeType2 = A03(490, 11, 76);
            StringBuilder append = sb.append(codecMimeType2);
            String codecMimeType3 = c2489qI.A0R;
            StringBuilder append2 = append.append(codecMimeType3);
            String codecMimeType4 = A03(4, 2, 43);
            A06(append2.append(codecMimeType4).append(A07).toString());
            return false;
        }
        return A0G(c2489qI, true);
    }

    public final boolean A0T(C2489qI c2489qI) {
        if (this.A0A) {
            boolean z = this.A04;
            if (A0C[1].charAt(21) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[7] = "p6ujkjtFWGTlktsjRzxuv";
            strArr[5] = "iao6hIdGkkUEjHJmkTON0Ul";
            return z;
        }
        Pair<Integer, Integer> profileLevel = C0881Ba.A0B(c2489qI);
        return profileLevel != null && ((Integer) profileLevel.first).intValue() == 42;
    }

    @Deprecated
    public final boolean A0U(C2489qI c2489qI, C2489qI c2489qI2, boolean z) {
        if (!z && c2489qI.A0N != null) {
            ColorInfo colorInfo = c2489qI2.A0N;
            String[] strArr = A0C;
            if (strArr[7].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A0C[2] = "CiueF8sE";
            if (colorInfo == null) {
                c2489qI2 = c2489qI2.A07().A0t(c2489qI.A0N).A14();
            }
        }
        int i = A0O(c2489qI, c2489qI2).A01;
        return i == 2 || i == 3;
    }

    public final MediaCodecInfo.CodecProfileLevel[] A0V() {
        if (this.A00 == null || this.A00.profileLevels == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (A0C[2].length() != 8) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[7] = "wYBsKMorArWFj72U1vIrO";
        strArr[5] = "2GYgXVRgmEsc3DaR9LQ86J2";
        return codecCapabilities.profileLevels;
    }

    public final String toString() {
        return this.A03;
    }
}
