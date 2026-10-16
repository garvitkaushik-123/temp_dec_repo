package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.bridge.fbsdk.FBLoginASID;
import com.facebook.ads.internal.bridge.gms.AdvertisingId;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.ao, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1565ao implements TD {
    public static byte[] A01;
    public final T8 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 57);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-20, Ascii.EM, Ascii.SI, Ascii.GS, Ascii.SUB, Ascii.DC4, Ascii.SI};
    }

    public C1565ao(T8 t8) {
        this.A00 = t8;
    }

    @Override // com.instagram.common.viewpoint.core.TD
    public final String A79() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.TD
    public final String A86() {
        return WI.A02(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.TD
    public final String A87() {
        return FBLoginASID.getFBLoginASID();
    }

    @Override // com.instagram.common.viewpoint.core.TD
    public final String A8V() {
        return AdInternalSettings.getMediationService();
    }

    @Override // com.instagram.common.viewpoint.core.TD
    public final String A8c() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.TD
    public final TC A8x() {
        AdvertisingId advertisingIdInfoDirectly = AdvertisingId.getAdvertisingIdInfoDirectly(this.A00);
        if (advertisingIdInfoDirectly == null) {
            return null;
        }
        return new C1574ax(this, advertisingIdInfoDirectly);
    }

    @Override // com.instagram.common.viewpoint.core.TD
    public final String A9Q() {
        return AdInternalSettings.getUrlPrefix();
    }

    @Override // com.instagram.common.viewpoint.core.TD
    public final String A9S() {
        return A00(0, 7, 114);
    }

    @Override // com.instagram.common.viewpoint.core.TD
    public final String A9T() {
        return BuildConfigApi.getVersionName(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.TD
    public final boolean AAO() {
        return BuildConfigApi.isDebug();
    }
}
