package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.y1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3392y1 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3943a;

    /* JADX WARN: Multi-variable type inference failed */
    public C3392y1() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String a() {
        return this.f3943a;
    }

    public final String b() {
        return this.f3943a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3392y1) && Intrinsics.areEqual(this.f3943a, ((C3392y1) obj).f3943a);
    }

    public int hashCode() {
        return this.f3943a.hashCode();
    }

    public String toString() {
        return "ApplicationAuctionSettings(auctionData=" + this.f3943a + ")";
    }

    public C3392y1(String auctionData) {
        Intrinsics.checkNotNullParameter(auctionData, "auctionData");
        this.f3943a = auctionData;
    }

    public final C3392y1 a(String auctionData) {
        Intrinsics.checkNotNullParameter(auctionData, "auctionData");
        return new C3392y1(auctionData);
    }

    public /* synthetic */ C3392y1(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public static /* synthetic */ C3392y1 a(C3392y1 c3392y1, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c3392y1.f3943a;
        }
        return c3392y1.a(str);
    }
}
