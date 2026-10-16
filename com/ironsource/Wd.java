package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Wd extends IllegalArgumentException {

    /* renamed from: a, reason: collision with root package name */
    private final IronSourceError f3115a;
    private final int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Wd(IronSourceError error) {
        super(error.getErrorMessage());
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3115a = error;
        this.b = error.getErrorCode();
    }

    public final IronSourceError a() {
        return this.f3115a;
    }

    public final int b() {
        return this.b;
    }
}
