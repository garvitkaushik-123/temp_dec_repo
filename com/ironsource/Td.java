package com.ironsource;

import com.ironsource.G8;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Td implements G8, G8.a {

    /* renamed from: a, reason: collision with root package name */
    private Sd f3063a;
    private boolean b;

    @Override // com.ironsource.G8
    public La a() {
        Sd sd = this.f3063a;
        if (sd != null) {
            return new La(sd);
        }
        return null;
    }

    @Override // com.ironsource.G8
    public D9 b() {
        Sd sd = this.f3063a;
        if (sd != null) {
            return new D9(sd);
        }
        return null;
    }

    @Override // com.ironsource.G8
    public boolean c() {
        return this.b;
    }

    @Override // com.ironsource.G8.a
    public void d() {
        this.b = true;
    }

    @Override // com.ironsource.G8.a
    public void a(Sd sdkConfig) {
        Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
        this.f3063a = sdkConfig;
    }
}
