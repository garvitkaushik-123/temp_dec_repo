package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.7s, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08117s {
    public static final C08117s A01 = new C08117s(false);
    public final boolean A00;

    public C08117s(boolean z) {
        this.A00 = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.A00 == ((C08117s) obj).A00;
    }

    public final int hashCode() {
        return !this.A00 ? 1 : 0;
    }
}
