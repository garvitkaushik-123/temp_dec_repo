package com.ironsource;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.o2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3224o2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3610a;
    private final com.ironsource.mediationsdk.d b;

    public C3224o2(String serverData) {
        Intrinsics.checkNotNullParameter(serverData, "serverData");
        this.f3610a = serverData;
        this.b = com.ironsource.mediationsdk.d.b();
    }

    private final String c() {
        return this.f3610a;
    }

    public final C3224o2 a(String serverData) {
        Intrinsics.checkNotNullParameter(serverData, "serverData");
        return new C3224o2(serverData);
    }

    public final Map<String, String> b() {
        Map<String, String> b = this.b.b(this.f3610a);
        Intrinsics.checkNotNullExpressionValue(b, "auctionDataUtils.getAuct…verDataParams(serverData)");
        return b;
    }

    public final String d() {
        String c = this.b.c(this.f3610a);
        Intrinsics.checkNotNullExpressionValue(c, "auctionDataUtils.getDyna…romServerData(serverData)");
        return c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3224o2) && Intrinsics.areEqual(this.f3610a, ((C3224o2) obj).f3610a);
    }

    public int hashCode() {
        return this.f3610a.hashCode();
    }

    public String toString() {
        return "AuctionServerData(serverData=" + this.f3610a + ")";
    }

    public static /* synthetic */ C3224o2 a(C3224o2 c3224o2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c3224o2.f3610a;
        }
        return c3224o2.a(str);
    }

    public final String a() {
        String a2 = this.b.a(this.f3610a);
        Intrinsics.checkNotNullExpressionValue(a2, "auctionDataUtils.getAdmFromServerData(serverData)");
        return a2;
    }
}
