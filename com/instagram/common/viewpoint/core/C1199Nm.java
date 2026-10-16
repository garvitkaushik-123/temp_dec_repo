package com.instagram.common.viewpoint.core;

import java.io.Serializable;

/* renamed from: com.facebook.ads.redexgen.X.Nm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1199Nm implements Serializable {
    public static final long serialVersionUID = 351643298236575728L;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;

    public C1199Nm(C1198Nl c1198Nl) {
        String str;
        String str2;
        String str3;
        this.A02 = c1198Nl.A02;
        str = c1198Nl.A01;
        this.A01 = str;
        str2 = c1198Nl.A00;
        this.A00 = str2;
        str3 = c1198Nl.A03;
        this.A03 = str3;
    }

    public final String A00() {
        return this.A00;
    }

    public final String A01() {
        return this.A01;
    }

    public final String A02() {
        return this.A02;
    }

    public final String A03() {
        return this.A03;
    }
}
