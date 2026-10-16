package com.inmobi.media;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class X9 {

    /* renamed from: a, reason: collision with root package name */
    public final Map f2482a;

    public X9(Map requestParams) {
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        this.f2482a = requestParams;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof X9) && Intrinsics.areEqual(this.f2482a, ((X9) obj).f2482a);
    }

    public final int hashCode() {
        return this.f2482a.hashCode();
    }

    public final String toString() {
        return "NovatiqAdData(requestParams=" + this.f2482a + ')';
    }
}
