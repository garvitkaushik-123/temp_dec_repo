package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.gc, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3099gc implements InterfaceC3100gd {

    /* renamed from: a, reason: collision with root package name */
    private final String f3318a;

    /* renamed from: com.ironsource.gc$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3319a = new a();
        public static final String b = "IronSource";

        private a() {
        }
    }

    public C3099gc(String networkInstanceId) {
        Intrinsics.checkNotNullParameter(networkInstanceId, "networkInstanceId");
        this.f3318a = networkInstanceId;
    }

    @Override // com.ironsource.InterfaceC3100gd
    public String value() {
        if (this.f3318a.length() == 0) {
            return "";
        }
        if (Intrinsics.areEqual(this.f3318a, "0") || Intrinsics.areEqual(this.f3318a, "IronSource")) {
            return "IronSource";
        }
        return "IronSource_" + this.f3318a;
    }
}
