package com.instagram.common.viewpoint.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ok, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1223Ok implements Serializable {
    public static final long serialVersionUID = -3209129042070173126L;
    public C1223Ok A00;
    public final int A01;
    public final String A02;
    public final String A03;
    public final List<C1223Ok> A04;

    public C1223Ok(int i, String str, String str2) {
        this.A04 = new ArrayList();
        this.A01 = i;
        this.A03 = str;
        this.A02 = str2;
    }

    public C1223Ok(String str) {
        this(0, null, str);
    }

    private void A00(C1223Ok c1223Ok) {
        this.A00 = c1223Ok;
    }

    public final int A01() {
        return this.A01;
    }

    public final C1223Ok A02() {
        return this.A00;
    }

    public final String A03() {
        return this.A02;
    }

    public final String A04() {
        return this.A03;
    }

    public final List<C1223Ok> A05() {
        return this.A04;
    }

    public final void A06(C1223Ok c1223Ok) {
        c1223Ok.A00(this);
        this.A04.add(c1223Ok);
    }
}
