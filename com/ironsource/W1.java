package com.ironsource;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class W1 implements X1 {

    /* renamed from: a, reason: collision with root package name */
    private final C3079f9 f3103a;
    private final com.ironsource.mediationsdk.d b;
    private final C3038d2 c;

    public W1(C3079f9 instanceInfo, com.ironsource.mediationsdk.d auctionDataUtils, C3038d2 c3038d2) {
        Intrinsics.checkNotNullParameter(instanceInfo, "instanceInfo");
        Intrinsics.checkNotNullParameter(auctionDataUtils, "auctionDataUtils");
        this.f3103a = instanceInfo;
        this.b = auctionDataUtils;
        this.c = c3038d2;
    }

    @Override // com.ironsource.X1
    public void a(String methodName) {
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        C3038d2 c3038d2 = this.c;
        if (c3038d2 == null || (emptyList = c3038d2.b()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        a(emptyList, methodName);
    }

    @Override // com.ironsource.X1
    public void b(String methodName) {
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        C3038d2 c3038d2 = this.c;
        if (c3038d2 == null || (emptyList = c3038d2.a()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        a(emptyList, methodName);
    }

    @Override // com.ironsource.X1
    public void c(String methodName) {
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        C3038d2 c3038d2 = this.c;
        if (c3038d2 == null || (emptyList = c3038d2.c()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        a(emptyList, methodName);
    }

    private final void a(List<String> list, String str) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.b.a(str, this.f3103a.e(), com.ironsource.mediationsdk.d.b().a(it.next(), this.f3103a.e(), this.f3103a.f(), this.f3103a.d(), "", "", "", ""));
        }
    }
}
