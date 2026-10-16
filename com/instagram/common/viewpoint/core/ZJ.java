package com.instagram.common.viewpoint.core;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public final class ZJ implements UF {
    public static PackageInfo A02;
    public static boolean A03;
    public static byte[] A04;
    public static String[] A05 = {"txu4RBo63YQ5Q7SoAp", "BY8ga9ljLbuWBmJa1ktUn6UmPorDtudq", "oIcH05TUMC1H4eRB0f575BffOzLV6s", "RDV9o0Xs0wR3bMJwiMoqv", "Drf", "fWBbnfM052TaJjbz2mNIhyXx2yjBcv", "vwrAcDNdoQtjOaT8FPnJSektvmYH0bUo", "A7bgPIcOUjT1m5u12vt0AimohlYQKPcw"};
    public static final EnumC1158Lw[] A06;
    public final C1325Sn A00;
    public final T8 A01;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 63);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        if (A05[4].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[3] = "e8Iif6peCxlhmB6JTHauJ";
        strArr[0] = "U2Egyo0LhTV3FJWkcb";
        A04 = new byte[]{-98, -70, -85, -83, -83, -81, -67, -67, -77, -84, -77, -74, -77, -66, -61, -55, -81, -72, -85, -84, -74, -81, -82, -26, -13, -26, -15, -12, -20, -69, -54, -54, -39, -57, -61, -56, -39, -51, -66, -59, -39, -48, -65, -52, -51, -61, -55, -56, -38, -20, -31, -38, -20, -25, -7, -17, -22, -14, 5, 5, 3, -6, -13, 6, 5, -6, 0, -1, Ascii.DLE, -6, -11, -7, 0, -5, -5, -4, 9, Ascii.SYN, Ascii.VT, 6, 2, -4, 5, Ascii.SYN, -4, Ascii.SI, Ascii.VT, 9, -8, 10, -124, -117, -122, -122, -121, -108, -95, -106, -111, -115, -121, -112, -95, -106, -107, -95, -113, -107, -26, -7, -14, -24, -16, -23, -110, -112, -110, -105, -108, -73, -75, -60, -60, -71, -72, -45, -67, -72, -57, -96, -98, -81, -81, -90, -94, -81, -32, -35, -16, -35, -5, -20, -18, -21, -33, -31, -17, -17, -27, -22, -29, -5, -21, -20, -16, -27, -21, -22, -17, -120, -123, -104, -123, -93, -108, -106, -109, -121, -119, -105, -105, -115, -110, -117, -93, -109, -108, -104, -115, -109, -110, -105, -93, -121, -109, -103, -110, -104, -106, -99, -104, -107, -88, -107, -77, -92, -90, -93, -105, -103, -89, -89, -99, -94, -101, -77, -93, -92, -88, -99, -93, -94, -89, -77, -89, -88, -107, -88, -103, -71, -70, -61, -56, -66, -55, -50, -41, -26, -33, -33, -42, -35, -16, -44, -32, -29, -42, -16, -42, -25, -42, -33, -27, -28, -25, -10, -17, -17, -26, -19, 0, -19, -16, -24, -24, -26, -27, -81, -54, -46, -43, -50, -51, -119, -35, -40, -119, -53, -34, -46, -43, -51, -119, -34, -36, -50, -37, -119, -35, -40, -44, -50, -41, -96, -103, -85, -73, -99, -80, -89, -88, -92, -103, -79, -99, -86, -6, -11, -9, -14, -57, -62, -35, -63, -65, -63, -58, -61, -35, -46, -47, -35, -53, -47, -69, -74, -47, -59, -63, -57, -60, -75, -73, -24, -19, -14, -13, -32, -21, -21, -28, -15, -104, -101, -113, -115, -104, -111, 1, -11, -1, -7, -75, -83, -84, -79, -87, -68, -79, -73, -74, -57, -69, -83, -70, -66, -79, -85, -83, -10, -19, -4, -1, -9, -6, -13, 7, -4, 1, -8, -19, -82, -94, -76, -85, -76, -78, -66, -76, -78, -92, -79, -66, -88, -93, -100, -103, -103, -98, -113, -114, -74, -74, -61, -89, -80, -83, -87, -78, -72, -61, -73, -88, -81, -61, -70, -87, -74, -73, -83, -77, -78, 2, 2, Ascii.SI, -13, -1, -2, -10, -7, -9, Ascii.SI, 4, 3, Ascii.SI, -3, 3, -6, -6, 7, -19, 0, -4, -6, -23, -5, -89, -89, -76, -98, -88, -76, -101, -89, -92, -94, -76, -88, -102, -89, -85, -98, -104, -102, -111, -111, -98, -110, -124, -111, -107, -120, -126, -124, -98, -110, -125, -118, -98, -107, -124, -111, -110, -120, -114, -115, -42, -40, -54, -29, -54, -58, -29, -59, -44, -44, -29, -51, -46, -41, -40, -59, -48, -48, -55, -56, -109, -107, -121, -96, -121, -125, -96, -126, -111, -111, -96, -105, -122, -109, -108, -118, -112, -113, -17, -33, -18, -31, -31, -22, -5, -28, -31, -27, -29, -28, -16, -10, -26, -11, -24, -24, -15, 2, -6, -20, -25, -9, -21, -27, -42, -35, -15, -43, -45, -30, -45, -44, -37, -34, -37, -26, -21, -65, -80, -73, -53, -71, -83, -70, -83, -77, -79, -80, -53, -81, -83, -81, -76, -79, -9, -23, -9, -9, -19, -13, -14, 3, -8, -19, -15, -23, 17, 10, 5, Ascii.DLE, Ascii.NAK, -106, -108, -122, -109, -96, -126, -120, -122, -113, -107, -59, -80, -69, -65, -80, -63, -80, -68, -62, -60, -53, -62, -62};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final String A05(UD ud) {
        UB.A08(this.A01, true, null);
        ByteArrayOutputStream byteArrayOutputStream = null;
        Base64OutputStream base64OutputStream = null;
        DeflaterOutputStream deflaterOutputStream = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 0);
                deflaterOutputStream = new DeflaterOutputStream(base64OutputStream);
                Map A062 = A06();
                if (TextUtils.isEmpty(SZ.A00().A03())) {
                    SZ.A07(this.A01);
                }
                A062.put(A01(296, 4, 114), SZ.A00().A03());
                A062.put(A01(587, 10, 2), UJ.A06(new C1352To(this.A01), this.A01, false));
                if (C1379Up.A21(this.A01)) {
                    A062.put(A01(Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 10, 53), N8.A01(this.A01).A0K());
                }
                Iterator it = A062.entrySet().iterator();
                while (it.hasNext()) {
                    if (!ud.A3A((String) ((Map.Entry) it.next()).getKey())) {
                        it.remove();
                    }
                }
                deflaterOutputStream.write(new JSONObject(A062).toString().getBytes());
                deflaterOutputStream.close();
                String replaceAll = byteArrayOutputStream.toString().replaceAll(A01(0, 1, 85), A01(0, 0, 46));
                try {
                    deflaterOutputStream.close();
                    base64OutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return replaceAll;
            } catch (IOException e) {
                throw new RuntimeException(A01(257, 26, 42), e);
            }
        } catch (Throwable th) {
            if (A05[4].length() != 3) {
                throw new RuntimeException();
            }
            A05[1] = "YYekAclIzhra9Pv39zprUDIkOoogCrwo";
            if (deflaterOutputStream != null) {
                try {
                    deflaterOutputStream.close();
                } catch (IOException unused2) {
                    throw th;
                }
            }
            if (base64OutputStream != null) {
                base64OutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    public final /* synthetic */ Map A06() {
        return UC.A00(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x037d, code lost:
    
        if (com.instagram.common.viewpoint.core.AbstractC1382Us.A0D(r5) != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x037f, code lost:
    
        r3.put(A01(90, 18, 3), com.instagram.common.viewpoint.core.Y1.A07(com.instagram.common.viewpoint.core.Y1.A00()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0393, code lost:
    
        r3.put(A01(283, 13, 25), java.lang.String.valueOf(r11.A01.A04().A9m()));
        r3.put(A01(244, 13, 98), java.lang.String.valueOf(com.instagram.common.viewpoint.core.TX.A0H(r11.A01)));
        r5 = new java.lang.StringBuilder();
        r7 = com.instagram.common.viewpoint.core.ZJ.A06;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x03cd, code lost:
    
        r8 = r7.length;
        r9 = true;
        r2 = com.instagram.common.viewpoint.core.ZJ.A05;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x03df, code lost:
    
        if (r2[3].length() == r2[0].length()) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x03e1, code lost:
    
        r2 = com.instagram.common.viewpoint.core.ZJ.A05;
        r2[5] = "zWUmLpLkv5ZkeLP8Nx8FR5P0NkpI1z";
        r2[2] = "rR6LCigUl1U30r1W401qlH7SB9R1I9";
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x03ed, code lost:
    
        if (r6 >= r8) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x03ef, code lost:
    
        r5.append(r7[r6].A03() + 4000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x03fd, code lost:
    
        if (r6 == (r7.length - 1)) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x03ff, code lost:
    
        r5.append(A01(1, 1, 79));
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x040a, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0483, code lost:
    
        r3.put(A01(com.vungle.ads.internal.protos.Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, 18, 82), r5.toString());
        r6 = A00(r11.A01);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x049a, code lost:
    
        if (r6 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x049c, code lost:
    
        r3.put(A01(476, 20, 69), java.lang.String.valueOf(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x04ad, code lost:
    
        if (r6 == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x04af, code lost:
    
        r3.put(A01(496, 18, 2), java.lang.String.valueOf(r6.versionCode));
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x04c1, code lost:
    
        A03(r12, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x04ce, code lost:
    
        if (com.instagram.common.viewpoint.core.ZJ.A05[4].length() == 3) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x04d5, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x04d8, code lost:
    
        r2 = com.instagram.common.viewpoint.core.ZJ.A05;
        r2[3] = "GvfG5gBfjM6hmXKTNV25n";
        r2[0] = "CjMBMD2IWFco7mVmEr";
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x04ea, code lost:
    
        if (com.instagram.common.viewpoint.core.C1379Up.A0y(r11.A01) == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x04ec, code lost:
    
        r4 = com.instagram.common.viewpoint.core.U6.A02(r11.A01.A02());
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x04f6, code lost:
    
        if (r4 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x04f8, code lost:
    
        r3.put(A01(553, 17, 45), com.instagram.common.viewpoint.core.AbstractC1440Xd.A01(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0509, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x04d6, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x040d, code lost:
    
        if (r6 >= r8) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x041b, code lost:
    
        if (com.instagram.common.viewpoint.core.AbstractC1382Us.A0D(r5) != false) goto L60;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.UF
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, String> A7y(U3 u3) {
        String A87;
        String A79 = u3 != null ? u3.A79() : null;
        String packageName = A79 != null ? A79 : this.A01.getPackageName();
        UB.A08(this.A01, ProcessUtils.isRemoteRenderingProcess() ? true : C1379Up.A0n(this.A01), A79);
        C1351Tn.A0B(this.A01);
        C1351Tn.A08(this.A01);
        HashMap hashMap = new HashMap();
        U8.A03(this.A01, hashMap, A79);
        hashMap.put(A01(332, 6, 13), Locale.getDefault().toString());
        float f = XX.A02;
        int i = this.A01.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.A01.getResources().getDisplayMetrics().heightPixels;
        hashMap.put(A01(Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 7, 54), String.valueOf(f));
        hashMap.put(A01(IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 12, 100), String.valueOf((int) (i / f)));
        hashMap.put(A01(EventTypeExtended.EVENT_TYPE_EXTENDED_IMPRESSION_OPPORTUNITY_VALUE, 13, 93), String.valueOf((int) (i2 / f)));
        hashMap.put(A01(57, 14, 114), SZ.A03());
        hashMap.put(A01(Sdk.SDKError.Reason.LINK_COMMAND_OPEN_FAILED_VALUE, 9, 51), SZ.A00().A02().name());
        hashMap.put(A01(300, 14, 63), String.valueOf(SZ.A00().A01()));
        C1352To c1352To = new C1352To(this.A01, A79);
        hashMap.put(A01(108, 6, 101), UJ.A03(this.A01, c1352To));
        hashMap.put(A01(129, 7, 30), c1352To.A08());
        hashMap.put(A01(338, 4, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), c1352To.A09());
        hashMap.put(A01(385, 6, 11), String.valueOf(UB.A00(this.A01).A00));
        hashMap.put(A01(323, 9, 96), c1352To.A0B());
        hashMap.put(A01(539, 14, 83), XF.A01());
        hashMap.put(A01(359, 12, 105), String.valueOf(AbstractC1462Xz.A00(this.A01).A00));
        hashMap.put(A01(570, 12, 101), Y1.A03(this.A01.A09().A01()));
        UB.A06(this.A01, packageName, hashMap);
        String A032 = XU.A03(this.A01, packageName);
        if (A032 != null) {
            hashMap.put(A01(48, 5, 90), A032);
        }
        String A01 = A01(582, 5, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        if (u3 != null && u3.AAk() != null) {
            Boolean AAk = u3.AAk();
            String[] strArr = A05;
            if (strArr[7].charAt(0) != strArr[6].charAt(0)) {
                String[] strArr2 = A05;
                strArr2[5] = "32RBgLNf778xvD9weLhwI46Snl5hrv";
                strArr2[2] = "IyuqHiwE4txdUinr9J2yO2mEn55tsE";
                hashMap.put(A01, String.valueOf(AAk));
            }
            throw new RuntimeException();
        }
        boolean A052 = XY.A05(this.A01);
        String[] strArr3 = A05;
        if (strArr3[3].length() == strArr3[0].length()) {
            throw new RuntimeException();
        }
        A05[4] = "M1q";
        hashMap.put(A01, String.valueOf(A052));
        String A8V = (u3 == null || u3.A8W() == null) ? this.A01.A05().A8V() : u3.A8W();
        if (A8V != null) {
            String[] strArr4 = A05;
            if (strArr4[7].charAt(0) != strArr4[6].charAt(0)) {
                String[] strArr5 = A05;
                strArr5[5] = "lzJ4Ecl31LKhf9GNtdySIIM2KCn5d6";
                strArr5[2] = "MfUCKgpZ3l00IXdOSEBXHLe94uIrQG";
                hashMap.put(A01(342, 17, 41), A8V);
            } else {
                hashMap.put(A01(342, 17, 41), A8V);
            }
        }
        hashMap.put(A01(2, 21, 43), String.valueOf(c1352To.A0C()));
        if (c1352To.A03() != -1) {
            hashMap.put(A01(29, 19, 59), String.valueOf(c1352To.A03()));
        }
        hashMap.put(A01(597, 9, 48), U4.A05(this.A01, packageName));
        hashMap.put(A01(23, 6, 102), AbstractC1440Xd.A01(C1351Tn.A02()));
        if (AbstractC1378Uo.A05(this.A01) && (A87 = this.A01.A05().A87()) != null) {
            hashMap.put(A01(53, 4, 103), A87);
        }
        String A8c = this.A01.A05().A8c();
        if (!TextUtils.isEmpty(A8c)) {
            hashMap.put(A01(371, 14, 32), A8c);
        }
        TM tm = null;
        if (u3 != null) {
            T8 t8 = this.A01;
            String[] strArr6 = A05;
            if (strArr6[7].charAt(0) != strArr6[6].charAt(0)) {
                String[] strArr7 = A05;
                strArr7[3] = "QL1vZoGO1wQ14zpGXE2Sg";
                strArr7[0] = "5V9s84iDx7Ocfd5gsL";
                tm = u3.A7m(t8);
            }
            throw new RuntimeException();
        }
        if (tm == null) {
            TP A07 = this.A01.A07();
            String[] strArr8 = A05;
            if (strArr8[3].length() != strArr8[0].length()) {
                String[] strArr9 = A05;
                strArr9[7] = "UvZ2k7gEJDaOAPFQ7LljUQwSSHt3Qj5l";
                strArr9[6] = "lsSUyvw0Epval1a8yRy7YtOStWYNlmUT";
                tm = A07.A7k();
            }
            throw new RuntimeException();
        }
        String A012 = A01(190, 29, 21);
        String A013 = A01(159, 31, 5);
        String A014 = A01(136, 23, 93);
        if (tm != null) {
            hashMap.put(A014, tm.A08());
            hashMap.put(A013, String.valueOf(tm.A05()));
            hashMap.put(A012, String.valueOf(tm.A06()));
        } else {
            String A015 = A01(606, 4, 23);
            hashMap.put(A014, A015);
            hashMap.put(A013, A015);
            hashMap.put(A012, A015);
        }
        hashMap.put(A01(Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 10, 53), N8.A01(this.A01).A0K());
        String A033 = this.A00.A03(this.A01);
        if (A033 != null && !TextUtils.isEmpty(A033)) {
            hashMap.put(A01(71, 19, 120), A033);
        }
        T8 t82 = this.A01;
        String[] strArr10 = A05;
        if (strArr10[3].length() != strArr10[0].length()) {
            A05[1] = "xfpBh2d17TpisnhOgc4FARMiGoOeOma4";
        } else {
            A05[4] = "SgB";
        }
    }

    static {
        A02();
        A03 = false;
        A06 = new EnumC1158Lw[]{EnumC1158Lw.A1D, EnumC1158Lw.A0r, EnumC1158Lw.A1E, EnumC1158Lw.A1O, EnumC1158Lw.A18, EnumC1158Lw.A1A, EnumC1158Lw.A2h, EnumC1158Lw.A2i, EnumC1158Lw.A2j};
    }

    public ZJ(T8 t8, boolean z, C1325Sn c1325Sn) {
        this.A01 = t8;
        this.A00 = c1325Sn;
        UB.A08(t8, z, null);
    }

    public static synchronized PackageInfo A00(T8 t8) {
        PackageInfo packageInfo;
        synchronized (ZJ.class) {
            if (!A03) {
                A02 = AbstractC1445Xi.A00(t8);
                A03 = true;
            }
            packageInfo = A02;
        }
        return packageInfo;
    }

    private void A03(U3 u3, Map<String, String> map) {
        String A01;
        if (u3 != null && u3.AAg()) {
            map.put(A01(436, 18, 22), Boolean.TRUE.toString());
            if (u3.A7N() != null) {
                map.put(A01(391, 21, 37), u3.A7N());
            }
        }
        if (AbstractC1382Us.A09(this.A01)) {
            T8 t8 = this.A01;
            if (A05[1].charAt(25) != 'o') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[7] = "qhmjNI7uMFHuEfCbgrNi3HvbFW0uqLeT";
            strArr[6] = "rAF5k5sPuv4hj6bjGKLvAsDqqwbdtY33";
            String A032 = U5.A03(t8.A02());
            if (A032 != null) {
                String remoteRenderingSdkVersion = A01(454, 22, 0);
                map.put(remoteRenderingSdkVersion, A032);
            }
            String A022 = U5.A02(this.A01.A02());
            if (A032 != null) {
                String remoteRenderingSdkVersion2 = A01(427, 9, 105);
                map.put(remoteRenderingSdkVersion2, A022);
            }
            if (AbstractC1382Us.A0D(this.A01)) {
                String A012 = U5.A01(this.A01.A02());
                String[] strArr2 = A05;
                String remoteRenderingExtras = strArr2[7];
                if (remoteRenderingExtras.charAt(0) == strArr2[6].charAt(0)) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A05;
                strArr3[7] = "Mj9TvIbv6bgZbZ2pKznECnYI7EK5ROuc";
                strArr3[6] = "5qjAp4YjV3Q6sbLE0XRdgT3gO1lX1tGk";
                if (A032 != null) {
                    String remoteRenderingSdkVersion3 = A01(TTAdConstant.IMAGE_URL_CODE, 15, 113);
                    map.put(remoteRenderingSdkVersion3, A012);
                }
            }
        }
        if (C1379Up.A0x(this.A01) && (A01 = U6.A01(this.A01.A02())) != null) {
            String cache = A01(114, 5, 16);
            map.put(cache, A01);
        }
    }

    public final String A04() {
        return A05(UE.A00());
    }
}
