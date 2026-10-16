package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.AdSettings;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Set;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.iP, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2030iP implements U3 {
    public static byte[] A03;
    public final Bundle A00;
    public final String A01;
    public final String A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 11);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{83, 94, 94, 93, 78, 84, 73, 65, 93, 88, 82, 88, 69, 78, 69, 84, 66, 69, 78, 92, 94, 85, 84, 78, 90, 84, 72, 67, 78, 78, 77, 94, 72, 82, 94, 84, 79, 72, 85, 88, Ascii.FF, 1, 1, 2, 17, 3, 7, Ascii.SYN, Ascii.VT, 10, 17, Ascii.SI, Ascii.ESC, 10, 7, Ascii.VT, 0, Ascii.CR, Ascii.VT, 17, 5, Ascii.VT, Ascii.ETB, 32, 37, 48, 37, 59, 52, 54, 43, 39, 33, 55, 55, 45, 42, 35, 59, 43, 52, 48, 45, 43, 42, 55, 59, 39, 43, 49, 42, 48, 54, Base64.padSymbol, 59, 47, 33, Base64.padSymbol, 54, 51, 38, 51, 45, 34, 32, Base64.padSymbol, 49, 55, 33, 33, 59, 60, 53, 45, Base64.padSymbol, 34, 38, 59, Base64.padSymbol, 60, 33, 45, 57, 55, 43, 7, 2, Ascii.ETB, 2, Ascii.FS, 19, 17, Ascii.FF, 0, 6, Ascii.DLE, Ascii.DLE, 10, Ascii.CR, 4, Ascii.FS, Ascii.FF, 19, Ascii.ETB, 10, Ascii.FF, Ascii.CR, Ascii.DLE, Ascii.FS, Ascii.DLE, Ascii.ETB, 2, Ascii.ETB, 6, Ascii.FS, 8, 6, Ascii.SUB, 94, 89, 95, 82, 76, 73, 82, 89, 72, 94, 89, 82, 89, 84, 93, 72, 82, 70, 72, 84, 84, 83, 85, 88, 74, 66, 67, 78, 70, 83, 78, 72, 73, 88, 84, 66, 85, 81, 78, 68, 66, 88, 76, 66, 94};
    }

    public C2030iP(String str, String str2, Bundle bundle) {
        this.A01 = str;
        this.A02 = str2;
        this.A00 = bundle;
    }

    @Override // com.instagram.common.viewpoint.core.U3
    public final String A79() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.U3
    public final String A7N() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.U3
    public final TM A7m(T8 t8) {
        String[] stringArray = this.A00.getStringArray(A00(98, 27, Sdk.SDKError.Reason.TPAT_ERROR_VALUE));
        Integer valueOf = Integer.valueOf(this.A00.getInt(A00(63, 35, 111), -1));
        if (valueOf.intValue() == -1) {
            valueOf = null;
        }
        Integer country = Integer.valueOf(this.A00.getInt(A00(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 33, 72), -1));
        if (country.intValue() == -1) {
            country = null;
        }
        return new TM(stringArray, valueOf, country);
    }

    @Override // com.instagram.common.viewpoint.core.U3
    public final String A8W() {
        return this.A00.getString(A00(178, 25, 12));
    }

    @Override // com.instagram.common.viewpoint.core.U3
    public final String A9G() {
        String string = this.A00.getString(A00(158, 20, 6));
        String adTestTypeStr = AdSettings.TestAdType.DEFAULT.getAdTypeString();
        if (adTestTypeStr.equals(string)) {
            return null;
        }
        for (AdSettings.TestAdType testAdType : AdSettings.TestAdType.values()) {
            String adTestTypeStr2 = testAdType.getAdTypeString();
            if (adTestTypeStr2.equals(string)) {
                String adTestTypeStr3 = testAdType.getAdTypeString();
                return adTestTypeStr3;
            }
        }
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.U3
    public final boolean AAa() {
        return this.A00.getBoolean(A00(40, 23, 69));
    }

    @Override // com.instagram.common.viewpoint.core.U3
    public final boolean AAg() {
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.U3
    public final Boolean AAk() {
        Set<String> keySet = this.A00.keySet();
        String A00 = A00(27, 13, 10);
        if (keySet.contains(A00)) {
            return Boolean.valueOf(this.A00.getBoolean(A00));
        }
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.U3
    public final boolean isTestMode(Context context) {
        return this.A00.getBoolean(A00(0, 27, 26)) || AdSettings.isTestMode(context);
    }
}
