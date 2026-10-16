package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.k4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3158k4 implements InterfaceC3330u7 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3398a;
    private final String b;
    private final boolean c;
    private final Mc d;

    public C3158k4() {
        this(null, null, false, null, 15, null);
    }

    @Override // com.ironsource.InterfaceC3330u7
    public String a() {
        return this.f3398a;
    }

    @Override // com.ironsource.InterfaceC3330u7
    public boolean b() {
        return this.c;
    }

    @Override // com.ironsource.InterfaceC3330u7
    public Mc c() {
        return this.d;
    }

    @Override // com.ironsource.InterfaceC3330u7
    public String d() {
        return this.b;
    }

    public C3158k4(String controllerUrl, String cacheFolder, boolean z, Mc rootFolder) {
        Intrinsics.checkNotNullParameter(controllerUrl, "controllerUrl");
        Intrinsics.checkNotNullParameter(cacheFolder, "cacheFolder");
        Intrinsics.checkNotNullParameter(rootFolder, "rootFolder");
        this.f3398a = controllerUrl;
        this.b = cacheFolder;
        this.c = z;
        this.d = rootFolder;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ C3158k4(String str, String str2, boolean z, Mc mc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? new Mc(str) : mc);
        str = (i & 1) != 0 ? "" : str;
    }
}
