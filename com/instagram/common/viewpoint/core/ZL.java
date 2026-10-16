package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class ZL implements UD {
    public final /* synthetic */ String[] A00;

    public ZL(String[] strArr) {
        this.A00 = strArr;
    }

    @Override // com.instagram.common.viewpoint.core.UD
    public final boolean A3A(String str) {
        for (String str2 : this.A00) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }
}
