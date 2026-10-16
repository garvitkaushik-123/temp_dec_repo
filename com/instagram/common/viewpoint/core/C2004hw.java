package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.hw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2004hw implements QD {
    public final /* synthetic */ C7Q A00;
    public final /* synthetic */ Q8 A01;

    public C2004hw(C7Q c7q, Q8 q8) {
        this.A00 = c7q;
        this.A01 = q8;
    }

    @Override // com.instagram.common.viewpoint.core.QD
    public final Object A5G(int i) {
        Q6 compatInfo = this.A01.A00(i);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.A0M();
    }

    @Override // com.instagram.common.viewpoint.core.QD
    public final List<Object> A6Y(String str, int i) {
        List<Q6> A03 = this.A01.A03(str, i);
        if (A03 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int infoCount = A03.size();
        for (int i2 = 0; i2 < infoCount; i2++) {
            arrayList.add(A03.get(i2).A0M());
        }
        return arrayList;
    }

    @Override // com.instagram.common.viewpoint.core.QD
    public final Object A6Z(int i) {
        Q6 compatInfo = this.A01.A01(i);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.A0M();
    }

    @Override // com.instagram.common.viewpoint.core.QD
    public final boolean AGv(int i, int i2, Bundle bundle) {
        return this.A01.A04(i, i2, bundle);
    }
}
