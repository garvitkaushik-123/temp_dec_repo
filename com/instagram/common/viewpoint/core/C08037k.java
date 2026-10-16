package com.instagram.common.viewpoint.core;

import android.view.View;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.7k, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08037k extends AbstractC2064j0 {
    public static byte[] A03;
    public long A00;
    public View A01;
    public AnonymousClass76 A02;

    static {
        A05();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 81);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{Ascii.DC4, Ascii.ETB, 38, -15, -16, -3, -3, -12, 1, -18, 1, -12, -11, 1, -12, 2, -9, -18, 3, -8, -4, -12, -5, 0, -7, 1, 6, -9, 8, -7, 10, -7, 5, Ascii.VT, 38, 55, Ascii.ESC, 40, 40, 37, 40, -42, 45, Ascii.RS, Ascii.US, 34, Ascii.ESC, -42, 38, Ascii.ETB, 40, 41, Ascii.US, 36, Ascii.GS, -42, Ascii.EM, Ascii.RS, Ascii.ETB, Ascii.US, 36, Ascii.ESC, Ascii.SUB, -42, Ascii.ETB, Ascii.SUB, 41, -42, -8, Ascii.ETB, 36, 36, Ascii.ESC, 40};
    }

    public C08037k(AnonymousClass76 anonymousClass76, O7 o7) {
        super(anonymousClass76, o7);
        this.A00 = 10000L;
        this.A02 = anonymousClass76;
    }

    private C2067j3 A01(Runnable runnable) {
        return new C2067j3(this, runnable);
    }

    private List<JSONObject> A04(O8 o8) {
        ArrayList arrayList = new ArrayList();
        JSONObject A032 = o8.A03();
        if (A032.has(A03(22, 12, 71))) {
            try {
                this.A00 = A032.getJSONObject(r1).optInt(A03(3, 19, 62), 10000);
                JSONArray adsArray = A032.getJSONArray(A03(0, 3, 98));
                if (adsArray.length() > 0) {
                    for (int i = 0; i < adsArray.length(); i++) {
                        arrayList.add((JSONObject) adsArray.get(i));
                    }
                }
            } catch (JSONException unused) {
                String A033 = A03(36, 38, 101);
                this.A02.A0F().A5g(C1401Vm.A01(AdErrorType.UNKNOWN_ERROR, A033).A03().getErrorCode(), A033);
                return arrayList;
            }
        } else {
            arrayList.add(A032);
        }
        return arrayList;
    }

    private void A06(InterfaceC2125k8 interfaceC2125k8, JSONObject jSONObject, C1361Tx c1361Tx) {
        this.A0C = false;
        C2066j2 c2066j2 = new C2066j2(this, interfaceC2125k8, AbstractC1440Xd.A02(jSONObject, A03(34, 2, 114)));
        A0H().postDelayed(c2066j2, c1361Tx.A05());
        interfaceC2125k8.AAt(this.A02, this.A09, this.A08.A08, A01(c2066j2), jSONObject, c1361Tx);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2064j0
    public final void A0P() {
        if (this.A01 != null) {
            this.A02.A0F().A4e();
            this.A07.A0E(this.A01);
        } else {
            this.A02.A0F().A4f();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2064j0
    public final void A0R(N1 n1, C1360Tw c1360Tw, C1358Tu c1358Tu, final O8 o8) {
        this.A02.A0F().A4Y();
        final InterfaceC2125k8 interfaceC2125k8 = (InterfaceC2125k8) n1;
        if (interfaceC2125k8.AKL()) {
            final List<JSONObject> A04 = A04(o8);
            A06(interfaceC2125k8, A04.get(0), o8.A01());
            if (A04.size() > 1) {
                A0H().postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.O9
                    @Override // java.lang.Runnable
                    public final void run() {
                        C08037k.this.A0a(interfaceC2125k8, A04, o8);
                    }
                }, this.A00);
                return;
            }
            return;
        }
        A06(interfaceC2125k8, o8.A03(), o8.A01());
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2064j0
    public final void A0U(String str) {
        this.A02.A0F().A4d(str != null);
        super.A0U(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2064j0
    public final void A0Y(boolean z) {
        super.A0Y(z);
        this.A01 = null;
    }

    public final /* synthetic */ void A0a(InterfaceC2125k8 interfaceC2125k8, List list, O8 o8) {
        A06(interfaceC2125k8, (JSONObject) list.get(1), o8.A01());
    }
}
