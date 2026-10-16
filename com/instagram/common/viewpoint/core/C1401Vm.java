package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;

/* renamed from: com.facebook.ads.redexgen.X.Vm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1401Vm {
    public final AdErrorType A00;
    public final String A01;

    public C1401Vm(int i, String str) {
        this(AdErrorType.adErrorTypeFromCode(i), str);
    }

    public C1401Vm(AdErrorType adErrorType, String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public static C1401Vm A00(AdErrorType adErrorType) {
        return new C1401Vm(adErrorType, (String) null);
    }

    public static C1401Vm A01(AdErrorType adErrorType, String str) {
        return new C1401Vm(adErrorType, str);
    }

    public static C1401Vm A02(C1402Vn c1402Vn) {
        return new C1401Vm(c1402Vn.A00(), c1402Vn.A01());
    }

    public final AdErrorType A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }
}
