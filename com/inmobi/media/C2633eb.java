package com.inmobi.media;

/* renamed from: com.inmobi.media.eb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2633eb {

    /* renamed from: a, reason: collision with root package name */
    public int f2563a = 0;
    public int b = 0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2633eb)) {
            return false;
        }
        C2633eb c2633eb = (C2633eb) obj;
        return this.f2563a == c2633eb.f2563a && this.b == c2633eb.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Integer.hashCode(this.f2563a) * 31);
    }

    public final String toString() {
        return "PurchaseData(noOfInAppPurchases=" + this.f2563a + ", noOfSubscriptions=" + this.b + ')';
    }
}
