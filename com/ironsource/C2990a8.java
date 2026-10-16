package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.a8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C2990a8 extends Throwable {

    /* renamed from: a, reason: collision with root package name */
    private final IronSourceError f3178a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2990a8(IronSourceError error) {
        super(error.getErrorMessage());
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3178a = error;
    }

    public final IronSourceError a() {
        return this.f3178a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(C2990a8.class, obj.getClass())) {
            return false;
        }
        C2990a8 c2990a8 = (C2990a8) obj;
        if (this.f3178a.getErrorCode() != c2990a8.f3178a.getErrorCode()) {
            return false;
        }
        return Intrinsics.areEqual(this.f3178a.getErrorMessage(), c2990a8.f3178a.getErrorMessage());
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f3178a.getErrorCode()), this.f3178a.getErrorMessage());
    }
}
