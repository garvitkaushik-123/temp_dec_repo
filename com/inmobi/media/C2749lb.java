package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.lb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2749lb extends AbstractC2781nb {

    /* renamed from: a, reason: collision with root package name */
    public final int f2633a;
    public final String b;

    public C2749lb(String message, int i) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.f2633a = i;
        this.b = message;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2749lb)) {
            return false;
        }
        C2749lb c2749lb = (C2749lb) obj;
        return this.f2633a == c2749lb.f2633a && Intrinsics.areEqual(this.b, c2749lb.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.f2633a) * 31);
    }

    public final String toString() {
        return "Failure(statusCode=" + this.f2633a + ", message=" + this.b + ')';
    }
}
