package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.d, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3035d implements Y5 {

    /* renamed from: a, reason: collision with root package name */
    private final Mc f3235a;

    public C3035d(Mc folderRootUrl) {
        Intrinsics.checkNotNullParameter(folderRootUrl, "folderRootUrl");
        this.f3235a = folderRootUrl;
    }

    @Override // com.ironsource.Y5
    public String value() {
        return this.f3235a.a() + "/abTestMap.json";
    }
}
