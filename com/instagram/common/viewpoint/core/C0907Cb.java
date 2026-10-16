package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Cb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0907Cb implements InterfaceC1905gK {
    public static byte[] A05;
    public JSONObject A00;
    public JSONObject A01;
    public final EnumC1906gL A03;
    public final List<InterfaceC1907gM> A04 = new ArrayList();
    public boolean A02 = false;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 29);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-74, -23, -30, -40, -32, -39, -108, -103, -25, -108, -40, -43, -24, -43, -108, -23, -28, -40, -43, -24, -39, -82, 126, -98, -98, -108, -40, -43, -24, -43, -108, -98, -98, 126, -103, -25, 126, -98, -98, -108, -38, -35, -30, -37, -39, -26, -28, -26, -35, -30, -24, -108, -98, -98, 126, -103, -25, 122, -83, -90, -100, -92, -99, 88, -96, -103, -85, 88, -90, -89, 88, -98, -95, -90, -97, -99, -86, -88, -86, -95, -90, -84, 111, -94, -101, -111, -103, -110, 77, -106, -96, 77, -101, -100, -95, 77, -97, -110, -114, -111, -90, -31, -34, -15, -34, -99, -70, -70, -99, -21, -14, -23, -23, -46, -43, -38, -45, -47, -34, -36, -34, -43, -38, -32, -116, -115, -87, -116, -38, -31, -40, -40, -106, -103, -98, -105, -107, -94, -96, -94, -103, -98, -92, 80, 109, 109, 80, -98, -91, -100, -100, -39, -32, -41, -41};
    }

    public C0907Cb(EnumC1906gL enumC1906gL) {
        this.A03 = enumC1906gL;
    }

    private boolean A02(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return false;
        }
        if (jSONObject == null || jSONObject2 == null) {
            return true;
        }
        return true ^ AbstractC1904gJ.A02(jSONObject, jSONObject2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        if (r10.A03.A05() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ac, code lost:
    
        throw new java.lang.IllegalArgumentException(A00(113, 19, 79));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean A03(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            if (jSONObject2 == null && this.A03.A05()) {
                throw new IllegalArgumentException(A00(Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 19, 19));
            }
            if (!A02(this.A01, jSONObject2) && !A02(this.A00, jSONObject)) {
                return false;
            }
            this.A00 = jSONObject;
            this.A01 = jSONObject2;
            this.A02 = true;
            Iterator<InterfaceC1907gM> it = this.A04.iterator();
            while (it.hasNext()) {
                it.next().A4m();
            }
            try {
                String.format(Locale.US, A00(0, 57, 87), this.A03, this.A00 == null ? A00(151, 4, 78) : this.A00.toString(2), this.A01 == null ? A00(151, 4, 78) : this.A01.toString(2));
            } catch (JSONException unused) {
            }
            return true;
        }
        throw new IllegalArgumentException(A00(101, 12, 96));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1905gK
    public final synchronized void A41(InterfaceC1907gM interfaceC1907gM) {
        this.A04.add(interfaceC1907gM);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1905gK
    public final synchronized JSONObject A7i() {
        if (this.A00 != null) {
        } else {
            throw new IllegalStateException(A00(82, 19, 16));
        }
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1905gK
    public final synchronized JSONObject A88() {
        if (this.A03.A05()) {
            if (this.A01 != null) {
            } else {
                throw new IllegalStateException(A00(82, 19, 16));
            }
        } else {
            throw new IllegalStateException(A00(57, 25, 27));
        }
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1905gK
    public final EnumC1906gL A8F() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1905gK
    public final synchronized boolean AAe() {
        return this.A02;
    }
}
