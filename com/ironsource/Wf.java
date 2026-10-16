package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Wf implements Y5 {

    /* renamed from: a, reason: collision with root package name */
    private final Mc f3116a;
    private final String b;

    public Wf(Mc folderRootUrl, String version) {
        Intrinsics.checkNotNullParameter(folderRootUrl, "folderRootUrl");
        Intrinsics.checkNotNullParameter(version, "version");
        this.f3116a = folderRootUrl;
        this.b = version;
    }

    public final String a() {
        return this.b;
    }

    @Override // com.ironsource.Y5
    public String value() {
        return this.f3116a.a() + "/versions/" + this.b + "/mobileController.html";
    }
}
