package com.moloco.sdk.internal;

import com.moloco.sdk.publisher.MolocoAdError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class s {
    public static final int c = 8;

    /* renamed from: a, reason: collision with root package name */
    public final MolocoAdError f5598a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b;

    public s(MolocoAdError molocoAdError, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c subErrorType) {
        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
        Intrinsics.checkNotNullParameter(subErrorType, "subErrorType");
        this.f5598a = molocoAdError;
        this.b = subErrorType;
    }

    public final MolocoAdError a() {
        return this.f5598a;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b() {
        return this.b;
    }

    public final MolocoAdError c() {
        return this.f5598a;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Intrinsics.areEqual(this.f5598a, sVar.f5598a) && Intrinsics.areEqual(this.b, sVar.b);
    }

    public int hashCode() {
        return (this.f5598a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MolocoInternalAdError(molocoAdError=" + this.f5598a + ", subErrorType=" + this.b + ')';
    }

    public final s a(MolocoAdError molocoAdError, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c subErrorType) {
        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
        Intrinsics.checkNotNullParameter(subErrorType, "subErrorType");
        return new s(molocoAdError, subErrorType);
    }

    public static /* synthetic */ s a(s sVar, MolocoAdError molocoAdError, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            molocoAdError = sVar.f5598a;
        }
        if ((i & 2) != 0) {
            cVar = sVar.b;
        }
        return sVar.a(molocoAdError, cVar);
    }
}
