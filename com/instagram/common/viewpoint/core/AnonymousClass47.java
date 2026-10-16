package com.instagram.common.viewpoint.core;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.ironsource.Hd;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.services.UnityAdsConstants;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.47, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AnonymousClass47 {
    public static byte[] A00;
    public static final Map<String, Integer> A01;
    public static final Pattern A02;
    public static final Pattern A03;
    public static final Pattern A04;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 121);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-29, -13, 7, -4, -9, -15, -67, -67, -15, -7, Ascii.DLE, -58, -63, -56, Ascii.DC2, -66, -63, -67, -15, -7, Ascii.DLE, -58, -63, -56, Ascii.DC2, -66, -63, -67, -15, -7, Ascii.DLE, -58, -63, -56, Ascii.DC2, -66, -15, -66, -71, 19, 39, Ascii.FS, Ascii.ETB, Ascii.SYN, 17, -35, -35, 17, Ascii.EM, 48, -26, -31, -24, 50, -34, -31, -35, 17, Ascii.EM, 48, -26, -31, -24, 50, -34, -31, -35, 17, Ascii.EM, 48, -26, -31, -24, 50, -34, -31, -35, 17, Ascii.EM, -33, 17, -29, -12, 17, Ascii.EM, -33, -12, -34, 17, -34, -39, -10, 10, -1, -6, -7, -12, -64, -64, -12, -4, 19, -55, -60, -53, Ascii.NAK, -63, -60, -64, -12, -4, 19, -55, -60, -53, Ascii.NAK, -63, -60, -64, -12, -4, 19, -55, -60, -53, Ascii.NAK, -63, -60, -64, -12, -4, 19, -55, -60, -53, Ascii.NAK, -63, -12, -63, -68, Ascii.SI, Ascii.SUB, Ascii.ETB, 17, 19, Ascii.DLE, Ascii.SUB, 35, 19, 47, 60, 66, 55, 63, 67, 51, 69, 54, 55, 66, 51, -27, -11, -7, -27, 55, 71, 75, 55, 67, 55, 72, 63, 68, 59, -30, -5, -10, -13, -26, -7, -4, 0, -2, -4, 55, 62, 72, 70, 74, 58, -36, -26, -37, -35, -27, Ascii.SYN, 32, Ascii.NAK, 34, Ascii.ETB, Ascii.FS, Ascii.EM, Ascii.CAN, Ascii.NAK, 32, 33, 35, 34, Ascii.CAN, -11, -1, 8, -8, -1, 9, Ascii.DC2, 2, 19, 6, Ascii.FF, 9, 2, 17, 90, 106, 103, 111, 102, -6, Ascii.CR, 10, 4, 17, Ascii.SI, 7, 7, -4, 80, 78, 81, 82, 97, 79, 89, 98, 82, 76, 81, 74, 91, 93, 91, 78, 94, 92, 78, Ascii.DLE, Ascii.NAK, Ascii.FS, Ascii.DLE, Ascii.FS, Ascii.EM, Ascii.SO, 33, Ascii.DC2, 47, 59, 62, 45, 56, -20, -8, -5, -9, -17, -11, -8, 0, -18, -5, -21, -11, -2, -18, -25, -13, -10, -14, -9, -19, -16, -17, -13, 2, -7, -3, 3, -1, -2, 39, Base64.padSymbol, 37, 50, 60, 57, 74, 67, 58, 68, 77, Base64.padSymbol, 54, 51, 68, Base64.padSymbol, 53, 75, 51, SignedBytes.MAX_POWER_OF_TWO, Ascii.FF, 9, Ascii.SUB, 19, Ascii.SI, Ascii.ETB, Ascii.DC4, Ascii.FF, Ascii.CR, Ascii.SYN, Ascii.SUB, Ascii.ETB, Ascii.FF, 50, 47, SignedBytes.MAX_POWER_OF_TWO, 57, 53, SignedBytes.MAX_POWER_OF_TWO, 47, 71, 73, 70, 87, 80, 76, 87, 74, 74, 83, -8, -11, 6, -1, -5, 6, -7, Ascii.CR, Ascii.CR, 10, Ascii.ESC, Ascii.DC4, Ascii.DC4, 17, 10, Ascii.DC4, Ascii.DC2, -32, -35, -18, -25, -23, -35, -29, -31, -22, -16, -35, -35, -38, -21, -28, -24, -27, -30, -17, -34, -32, -21, -34, -34, -25, Base64.padSymbol, 58, 75, 68, 72, 75, 58, 71, SignedBytes.MAX_POWER_OF_TWO, 62, -32, -35, -18, -25, -21, -18, -33, -28, -27, -32, -11, -14, 3, -4, 3, -10, -11, 92, 89, 106, 99, 107, 89, 100, 101, 103, 102, 35, 32, 49, 42, 50, 36, 32, 38, 49, 36, 36, 45, 34, Ascii.US, 48, 41, 49, 42, Ascii.US, 50, 35, 32, 42, 51, 35, -9, -12, 5, -2, 6, -1, -12, 7, -8, -6, 5, -12, Ascii.FF, -2, -5, Ascii.FF, 5, Ascii.CR, 6, -5, Ascii.SO, -1, 1, Ascii.FF, -1, 19, 47, 44, Base64.padSymbol, 54, 63, SignedBytes.MAX_POWER_OF_TWO, Base64.padSymbol, 60, SignedBytes.MAX_POWER_OF_TWO, 58, 52, 62, 48, Base64.padSymbol, 58, 75, 68, 79, 66, 72, 69, 62, 77, 92, 93, 93, 104, 104, 97, 102, 99, Ascii.DC4, Ascii.NAK, Ascii.NAK, 32, 35, Ascii.ESC, 41, Ascii.DC2, Ascii.FS, 37, Ascii.NAK, Ascii.FF, 17, Ascii.NAK, Ascii.SI, Ascii.SUB, 9, 33, 65, 70, 74, 68, 79, 66, 86, -8, 3, -8, -5, -7, 6, -10, 0, 9, -7, Ascii.EM, Ascii.FS, 37, Ascii.CAN, Ascii.NAK, 37, Ascii.FS, Ascii.SYN, Ascii.RS, -11, -5, -2, 1, -16, -5, 6, -9, -8, 3, -12, Ascii.FS, 37, 40, Ascii.ESC, 41, 42, Ascii.GS, 40, Ascii.ESC, Ascii.ESC, 36, -28, -13, -31, -26, -15, -25, -33, -16, -22, -14, -9, -4, -21, -8, -5, -8, -9, -8, -1, 3, 4, 7, -8, -7, 4, -11, 9, 17, Ascii.SO, 6, Ascii.SO, Ascii.SYN, 19, Ascii.VT, Ascii.FF, Ascii.NAK, Ascii.EM, Ascii.SYN, Ascii.VT, 34, 45, Ascii.FS, 52, 69, 80, 67, 67, 76, -28, -17, -30, -30, -21, -10, -30, -23, -23, -20, -12, -13, -2, -15, 5, Ascii.SUB, 33, 32, Ascii.ETB, 43, Ascii.SYN, Ascii.ETB, 41, 34, 41, 46, 42, 35, 40, 37, 10, Ascii.SI, 5, 10, 2, Ascii.SI, 19, 6, 5, 69, 74, SignedBytes.MAX_POWER_OF_TWO, 69, 67, 75, 1, Ascii.SO, 7, 10, 17, Ascii.US, Ascii.FS, Ascii.NAK, Ascii.US, Ascii.GS, -7, -18, 3, -14, -5, -15, -14, -1, 0, -11, 10, -7, 2, -8, -7, 6, -10, 0, 9, 7, -4, 47, 36, 58, 49, 42, 53, 40, 40, 49, 86, 79, 87, 89, 88, 77, 82, 83, 80, 80, 89, 88, 65, 62, 60, Base64.padSymbol, 73, 55, 65, 74, 58, -5, -8, -10, -9, 3, -14, -2, 1, -16, -5, 94, 91, 89, 90, 102, 85, 107, 83, 96, 42, 39, 37, 38, 50, 37, 45, 42, 34, 35, 44, 48, 45, 34, 55, 35, 42, 42, 45, 53, Ascii.GS, Ascii.SUB, Ascii.CAN, Ascii.EM, 37, Ascii.CAN, 35, Ascii.DC2, 42, -13, -16, -18, -17, -5, -18, -7, -20, -20, -11, 51, 48, 46, 47, 59, 46, 57, 44, SignedBytes.MAX_POWER_OF_TWO, -24, -27, -29, -28, -16, -20, -27, -22, -25, 99, 96, 94, 95, 107, 106, 88, 99, 100, 102, 101, -6, -9, -11, -10, 2, 1, -13, -17, -11, 0, -13, -13, -4, 82, 79, 77, 78, 90, 89, 81, 95, 72, 82, 91, 75, 91, 88, 86, 87, 99, 98, 91, 80, 99, 84, 86, 97, 80, 104, Ascii.GS, Ascii.SUB, Ascii.CAN, Ascii.EM, 37, 36, Ascii.GS, Ascii.DC2, 37, Ascii.SYN, Ascii.CAN, 35, Ascii.SYN, 42, 79, 76, 74, 75, 87, 86, 87, 72, 72, 79, 69, 79, 88, 72, -24, -27, -29, -28, -16, -11, -31, -24, -24, -21, -13, 34, Ascii.US, 35, Ascii.ESC, 78, 75, 79, 71, 73, 84, 71, 71, 80, -12, -15, -10, -19, -10, 99, 87, 93, 91, 100, 106, 87, 78, 66, 83, 80, 80, 79, 55, 47, 46, 51, 63, 55, 43, 59, 63, 43, 55, 43, 60, 51, 56, 47, 66, 58, 57, 62, 74, 66, 55, 65, 74, 58, -12, -20, -21, -16, -4, -12, -10, -7, -22, -17, -16, -21, 57, 49, 48, 53, 65, 57, 60, 65, 62, 60, 56, 49, 19, Ascii.VT, 10, Ascii.SI, Ascii.ESC, 19, Ascii.EM, Ascii.VT, 7, Ascii.CR, Ascii.CAN, Ascii.VT, Ascii.VT, Ascii.DC4, -22, -30, -31, -26, -14, -22, -16, -23, -34, 
        -15, -30, -33, -23, -14, -30, 56, 48, 47, 52, SignedBytes.MAX_POWER_OF_TWO, 56, 62, 59, Base64.padSymbol, 52, 57, 50, 50, Base64.padSymbol, 48, 48, 57, 59, 51, 50, 55, 67, 59, 66, 67, SignedBytes.MAX_POWER_OF_TWO, 63, 67, Base64.padSymbol, 55, 65, 51, 71, 63, 62, 67, 79, 71, 80, 67, 73, 70, 63, 78, 76, 63, 62, 94, 90, 85, 95, 90, 88, 89, 101, 83, 93, 102, 86, 56, 52, 57, 63, 46, Base64.padSymbol, 48, 44, 56, 36, 32, 42, 43, 48, 41, 38, 42, Ascii.FS, 36, 38, Ascii.SUB, Ascii.SUB, Ascii.CAN, 42, 32, 37, 80, 67, 88, 67, 76, 81, 89, 74, 75, 86, 71, 50, 37, 58, Base64.padSymbol, -14, -17, -25, -17, -28, -26, -24, Ascii.DC4, 17, Ascii.SO, Ascii.ESC, 10, -14, -17, -20, -7, -24, -25, -11, -28, -27, Ascii.ESC, Ascii.RS, Ascii.CR, Ascii.SUB, 19, 17, 8, Ascii.VT, -6, 7, 0, -2, Ascii.VT, -2, -3, 5, 8, -7, -2, -1, -6, 49, 34, 45, 38, 40, 48, 45, 37, 38, 47, 51, 48, 37, Ascii.FF, -3, 8, 1, 3, Ascii.SO, 1, 1, 10, -1, -16, -5, -12, 3, 4, 1, 0, 4, -2, -8, 2, -12, Ascii.CAN, 9, Ascii.DC4, Ascii.CR, Ascii.RS, 17, Ascii.ETB, Ascii.DC4, Ascii.CR, Ascii.FS, Ascii.SUB, Ascii.CR, Ascii.FF, Ascii.NAK, 6, Ascii.NAK, 6, Ascii.RS, 6, Ascii.FS, Ascii.CR, Ascii.SO, Ascii.NAK, 6, -5, -9, -7, -2, 6, Ascii.VT, -4, -4, -9, -20, -7, -4, 51, 44, 49, 46, 100, 96, 105, 97, 41, 40, 48, Ascii.GS, Ascii.RS, 43, Ascii.ESC, 37, 46, Ascii.RS, -6, -1, -4, -6, -10, -17, 71, 58, 55, 58, 56, 56, 54, 69, 74, 71, 69, 65, 58, 17, 4, 3, 65, 54, 49, 0, -11, -16, -17, 59, 56, 60, 66, 43, 59, 56, SignedBytes.MAX_POWER_OF_TWO, 55, 32, Ascii.GS, 39, Ascii.SI, Ascii.SUB, Ascii.DLE, Ascii.SUB, 35, 19, Ascii.ESC, 9, Ascii.FF, Ascii.FF, Ascii.DC4, Ascii.CR, 10, Ascii.SUB, Ascii.ETB, Ascii.US, Ascii.SYN, Ascii.RS, Ascii.FF, Ascii.ETB, Ascii.CAN, Ascii.SUB, Ascii.EM, Ascii.DC4, 2, Ascii.SI, 5, Ascii.SUB, 3, 19, Ascii.DLE, Ascii.CAN, Ascii.SI, 0, -14, -18, -12, -1, -14, -14, -5, Ascii.FS, Ascii.SO, 10, Ascii.FS, 17, Ascii.SO, Ascii.NAK, Ascii.NAK, Ascii.CR, 3, -1, 8, 8, -5, 87, 77, 80, 90, 73, 86, 105, 97, 111, 88, 98, 107, 91, 58, 51, 40, 59, 44, 41, 51, 60, 44, -3, -10, -21, -2, -17, -15, -4, -21, 3, 65, 58, 47, 66, 51, 53, SignedBytes.MAX_POWER_OF_TWO, 51, 71, 89, 84, 85, 93, 77, 74, 76, 67, 72, 65, 65, 76, 63, 63, 72, -6, -5, -20, -20, -13, -23, -13, -4, -20, 71, 52, 65, 92, 77, 73, 84, 72, 60, Base64.padSymbol, 71, 72, SignedBytes.MAX_POWER_OF_TWO, 57, 32, Ascii.ESC, Ascii.EM, Ascii.CR, 32, Ascii.ESC, Ascii.CAN, Ascii.SYN, 5, Ascii.DC2, Ascii.ETB, Ascii.DC4, 5, Ascii.SYN, 9, Ascii.DC2, Ascii.CAN, 45, 46, 43, 42, 46, 40, 34, 44, Ascii.RS, 9, -4, 2, -1, -8, 7, 51, 36, 33, Ascii.GS, 48, 103, 88, 89, 100, 85, Ascii.CAN, 9, 10, Ascii.NAK, 6, Ascii.DC4, Ascii.SO, Ascii.DLE, Ascii.FF, 6, 54, 34, 41, 41, 44, 52, 45, Ascii.EM, 32, 32, 35, 43, Ascii.ESC, 38, Ascii.EM, Ascii.EM, 34};
    }

    static {
        A04();
        A04 = Pattern.compile(A03(1, 38, 28));
        A03 = Pattern.compile(A03(91, 49, 31));
        A02 = Pattern.compile(A03(39, 52, 60));
        A01 = new HashMap();
        A01.put(A03(140, 9, 53), -984833);
        A01.put(A03(149, 12, 85), -332841);
        A01.put(A03(161, 4, 11), -16711681);
        A01.put(A03(165, 10, 93), -8388652);
        A01.put(A03(175, 5, 8), -983041);
        A01.put(A03(180, 5, 30), -657956);
        A01.put(A03(185, 6, 92), -6972);
        A01.put(A03(191, 5, 1), -16777216);
        A01.put(A03(196, 14, 59), -5171);
        A01.put(A03(210, 4, 26), -16776961);
        A01.put(A03(Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, 10, 36), -7722014);
        A01.put(A03(224, 5, 127), -5952982);
        A01.put(A03(229, 9, 31), -2180985);
        A01.put(A03(238, 9, 116), -10510688);
        A01.put(A03(247, 10, 112), -8388864);
        A01.put(A03(257, 9, 52), -2987746);
        A01.put(A03(266, 5, 83), -32944);
        A01.put(A03(271, 14, 16), -10185235);
        A01.put(A03(285, 8, 11), -1828);
        A01.put(A03(293, 7, 23), -2354116);
        A01.put(A03(300, 4, 75), -16711681);
        A01.put(A03(Sdk.SDKError.Reason.AD_EXPIRED_VALUE, 8, 95), -16777077);
        A01.put(A03(Sdk.SDKError.Reason.DEEPLINK_OPEN_FAILED_VALUE, 8, 89), -16741493);
        A01.put(A03(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 13, 47), -4684277);
        A01.put(A03(333, 8, 85), -5658199);
        A01.put(A03(341, 9, 108), -16751616);
        A01.put(A03(350, 8, 27), -5658199);
        A01.put(A03(358, 9, 48), -4343957);
        A01.put(A03(367, 11, 3), -7667573);
        A01.put(A03(378, 14, 0), -11179217);
        A01.put(A03(392, 10, 96), -29696);
        A01.put(A03(TTAdConstant.AD_ID_IS_NULL_CODE, 10, 3), -6737204);
        A01.put(A03(TTAdConstant.IMAGE_URL_CODE, 7, 24), -7667712);
        A01.put(A03(419, 10, 127), -1468806);
        A01.put(A03(CommonGatewayClient.CODE_TOO_MANY_REQUESTS, 12, 70), -7357297);
        A01.put(A03(441, 13, 69), -12042869);
        A01.put(A03(454, 13, 26), -13676721);
        A01.put(A03(467, 13, 33), -13676721);
        A01.put(A03(480, 13, 82), -16724271);
        A01.put(A03(493, 10, 96), -7077677);
        A01.put(A03(503, 8, 127), -60269);
        A01.put(A03(511, 11, 55), -16728065);
        A01.put(A03(522, 7, 47), -9868951);
        A01.put(A03(529, 7, 100), -9868951);
        A01.put(A03(536, 10, 27), -14774017);
        A01.put(A03(546, 9, 58), -5103070);
        A01.put(A03(555, 11, 22), -1296);
        A01.put(A03(566, 11, 61), -14513374);
        A01.put(A03(577, 7, 5), -65281);
        A01.put(A03(584, 9, 16), -2302756);
        A01.put(A03(593, 10, 23), -460545);
        A01.put(A03(603, 4, 41), -10496);
        A01.put(A03(607, 9, 46), -2448096);
        A01.put(A03(616, 4, 66), -8355712);
        A01.put(A03(IronSourceError.ERROR_DO_BN_LOAD_DURING_SHOW, 5, 101), -16744448);
        A01.put(A03(LevelPlayAdError.ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK, 11, 4), -5374161);
        A01.put(A03(636, 4, 19), -8355712);
        A01.put(A03(640, 8, 57), -983056);
        A01.put(A03(648, 7, 65), -38476);
        A01.put(A03(655, 9, 40), -3318692);
        A01.put(A03(664, 6, 99), -11861886);
        A01.put(A03(670, 5, 31), -16);
        A01.put(A03(675, 5, 59), -989556);
        A01.put(A03(680, 8, 20), -1644806);
        A01.put(A03(688, 13, 27), -3851);
        A01.put(A03(701, 9, 74), -8586240);
        A01.put(A03(710, 12, 113), -1331);
        A01.put(A03(722, 9, 92), -5383962);
        A01.put(A03(731, 10, 22), -1015680);
        A01.put(A03(741, 9, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), -2031617);
        A01.put(A03(UnityAdsConstants.AdOperations.GET_TOKEN_TIMEOUT_MS, 20, 69), -329006);
        A01.put(A03(770, 9, 56), -2894893);
        A01.put(A03(779, 10, 14), -7278960);
        A01.put(A03(789, 9, 78), -2894893);
        A01.put(A03(798, 9, 3), -18751);
        A01.put(A03(807, 11, 126), -24454);
        A01.put(A03(818, 13, 21), -14634326);
        A01.put(A03(831, 12, 109), -7876870);
        A01.put(A03(843, 14, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE), -8943463);
        A01.put(A03(857, 14, 56), -8943463);
        A01.put(A03(871, 14, 106), -5192482);
        A01.put(A03(885, 11, 3), -32);
        A01.put(A03(896, 4, 61), -16711936);
        A01.put(A03(DescriptorProtos.Edition.EDITION_LEGACY_VALUE, 9, 105), -13447886);
        A01.put(A03(EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_LOSS_VALUE, 5, 15), -331546);
        A01.put(A03(914, 7, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), -65281);
        A01.put(A03(921, 6, 104), -8388608);
        A01.put(A03(927, 16, 81), -10039894);
        A01.put(A03(943, 10, 92), -16777011);
        A01.put(A03(953, 12, 14), -4565549);
        A01.put(A03(965, 12, 83), -7114533);
        A01.put(A03(977, 14, 45), -12799119);
        A01.put(A03(991, 15, 4), -8689426);
        A01.put(A03(1006, 17, 82), -16713062);
        A01.put(A03(1023, 15, 85), -12004916);
        A01.put(A03(IronSourceError.ERROR_RV_SHOW_EXCEPTION, 15, 97), -3730043);
        A01.put(A03(1053, 12, 120), -15132304);
        A01.put(A03(1065, 9, 82), -655366);
        A01.put(A03(1074, 9, 62), -6943);
        A01.put(A03(1083, 8, 62), -6987);
        A01.put(A03(1091, 11, 105), -8531);
        A01.put(A03(1102, 4, 75), -16777088);
        A01.put(A03(1106, 7, 10), -133658);
        A01.put(A03(1113, 5, 44), -8355840);
        A01.put(A03(1118, 9, 10), -9728477);
        A01.put(A03(1127, 6, 51), -23296);
        A01.put(A03(1133, 9, 32), -47872);
        A01.put(A03(1142, 6, 29), -2461482);
        A01.put(A03(1148, 13, 72), -1120086);
        A01.put(A03(1161, 9, 35), -6751336);
        A01.put(A03(1170, 13, 22), -5247250);
        A01.put(A03(1183, 13, 47), -2396013);
        A01.put(A03(1196, 10, 44), -4139);
        A01.put(A03(Hd.a.e, 9, 29), -9543);
        A01.put(A03(1215, 4, 14), -3308225);
        A01.put(A03(1219, 4, 74), -16181);
        A01.put(A03(1223, 4, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), -2252579);
        A01.put(A03(1227, 10, 64), -5185306);
        A01.put(A03(1237, 6, 17), -8388480);
        A01.put(A03(1243, 13, 92), -10079335);
        A01.put(A03(1256, 3, 38), -65536);
        A01.put(A03(1266, 9, 80), -4419697);
        A01.put(A03(1275, 9, 53), -12490271);
        A01.put(A03(1284, 11, 47), -7650029);
        A01.put(A03(1295, 6, 50), -360334);
        A01.put(A03(Hd.c.e, 10, 40), -744352);
        A01.put(A03(1311, 8, 20), -13726889);
        A01.put(A03(1319, 8, 48), -2578);
        A01.put(A03(1327, 6, 33), -6270419);
        A01.put(A03(1333, 6, 107), -4144960);
        A01.put(A03(1339, 7, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), -7876885);
        A01.put(A03(1346, 9, 78), -9807155);
        A01.put(A03(1355, 9, 17), -9404272);
        A01.put(A03(1364, 9, 85), -9404272);
        A01.put(A03(1373, 4, 109), -1286);
        A01.put(A03(1377, 11, 97), -16711809);
        A01.put(A03(1388, 9, 14), -12156236);
        A01.put(A03(1397, 3, 90), -2968436);
        A01.put(A03(1400, 4, 111), -16744320);
        A01.put(A03(1404, 7, 91), -2572328);
        A01.put(A03(1411, 6, 51), -40121);
        A01.put(A03(1417, 11, 43), 0);
        A01.put(A03(1428, 9, 64), -12525360);
        A01.put(A03(1437, 6, 26), -1146130);
        A01.put(A03(1443, 5, 67), -663885);
        A01.put(A03(1448, 5, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), -1);
        A01.put(A03(1453, 10, 40), -657931);
        A01.put(A03(1463, 6, 68), Integer.valueOf(InputDeviceCompat.SOURCE_ANY));
        A01.put(A03(1469, 11, 59), -6632142);
    }

    public static int A00(String str) {
        return A02(str, true);
    }

    public static int A01(String str) {
        return A02(str, false);
    }

    public static int A02(String str, boolean z) {
        int parseInt;
        AbstractC07133y.A07(!TextUtils.isEmpty(str));
        String replace = str.replace(A03(0, 1, 74), A03(0, 0, 45));
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return (-16777216) | parseLong;
            }
            if (replace.length() == 9) {
                return ((parseLong & 255) << 24) | (parseLong >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith(A03(1262, 4, 21))) {
            Matcher matcher = (z ? A02 : A03).matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    parseInt = (int) (Float.parseFloat((String) AbstractC07133y.A01(matcher.group(4))) * 255.0f);
                } else {
                    parseInt = Integer.parseInt((String) AbstractC07133y.A01(matcher.group(4)), 10);
                }
                return Color.argb(parseInt, Integer.parseInt((String) AbstractC07133y.A01(matcher.group(1)), 10), Integer.parseInt((String) AbstractC07133y.A01(matcher.group(2)), 10), Integer.parseInt((String) AbstractC07133y.A01(matcher.group(3)), 10));
            }
        } else if (replace.startsWith(A03(1259, 3, 86))) {
            Matcher matcher2 = A04.matcher(replace);
            if (matcher2.matches()) {
                return Color.rgb(Integer.parseInt((String) AbstractC07133y.A01(matcher2.group(1)), 10), Integer.parseInt((String) AbstractC07133y.A01(matcher2.group(2)), 10), Integer.parseInt((String) AbstractC07133y.A01(matcher2.group(3)), 10));
            }
        } else {
            Integer color = A01.get(AbstractC2124k7.A01(replace));
            if (color != null) {
                return color.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
